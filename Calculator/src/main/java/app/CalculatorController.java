package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.lang.reflect.Array;
import java.util.*;

public class CalculatorController {
    @FXML
    private Button buttonZero;
    @FXML
    private Button buttonOne;
    @FXML
    private Button buttonTwo;
    @FXML
    private Button buttonThree;
    @FXML
    private Button buttonFour;
    @FXML
    private Button buttonFive;
    @FXML
    private Button buttonSix;
    @FXML
    private Button buttonSeven;
    @FXML
    private Button buttonEight;
    @FXML
    private Button buttonNine;
    @FXML
    private Button buttonMinus;
    @FXML
    private Button buttonPlus;
    @FXML
    private Button buttonEquals;
    @FXML
    private TextField outputField;
    @FXML
    private Button buttonMultiply;
    @FXML
    private Button buttonDivide;

    private String writtenOutput = "";
    private int firstNumber = 0;
    private int secondNumber = 0;


    @FXML
    private void initialize() {
        outputField.setEditable(false);

        handleNumberButtons();
    }

    private void handleNumberButtons() {
        buttonZero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = outputField.getText() + "0";
                outputField.setText(writtenOutput);

                System.out.println("used zero");
            }
        });

        buttonOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = outputField.getText() + "1";
                outputField.setText(writtenOutput);

                System.out.println("used one");
            }
        });

        buttonTwo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = outputField.getText() + "2";
                outputField.setText(writtenOutput);

                System.out.println("used two");
            }
        });

        buttonThree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = outputField.getText() + "3";
                outputField.setText(writtenOutput);

                System.out.println("used three");
            }
        });

        buttonFour.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = outputField.getText() + "4";
                outputField.setText(writtenOutput);

                System.out.println("used four");
            }
        });

        buttonFive.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = outputField.getText() + "5";
                outputField.setText(writtenOutput);
                ;

                System.out.println("used five");
            }
        });

        buttonSix.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = outputField.getText() + "6";
                outputField.setText(writtenOutput);

                System.out.println("used six");
            }
        });

        buttonSeven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = outputField.getText() + "7";
                outputField.setText(writtenOutput);

                System.out.println("used seven");
            }
        });

        buttonEight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = outputField.getText() + "8";
                outputField.setText(writtenOutput);

                System.out.println("used eight");
            }
        });

        buttonNine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = outputField.getText() + "9";
                outputField.setText(writtenOutput);

                System.out.println("used nine");
            }
        });

        buttonPlus.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                if (!outputField.getText().substring(outputField.getText().length() - 1).equals("*") && !outputField.getText().substring(outputField.getText().length() - 1).equals("/") && !outputField.getText().substring(outputField.getText().length() - 1).equals("+")) {  // checking if last character of a user input String is equal + and if it is already then input won't change (cant be something like 1 +++ and if previous character is not equal - so (55-+1000 for example) is not possible either
                    writtenOutput = outputField.getText() + "+";
                    outputField.setText(writtenOutput);
                }

                System.out.println("used plus");
            }
        });

        buttonMinus.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                if (outputField.getText().isEmpty() || !outputField.getText().substring(outputField.getText().length() - 1).equals("-")) {
                    writtenOutput = outputField.getText() + "-";
                    outputField.setText(writtenOutput);
                }

                System.out.println("used minus");
            }
        });

        buttonEquals.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                calculate();

                System.out.println("used equals");
            }
        });

        buttonMultiply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!outputField.getText().substring(outputField.getText().length() - 1).equals("*") && !outputField.getText().substring(outputField.getText().length() - 1).equals("/") && !outputField.getText().substring(outputField.getText().length() - 1).equals("+")) {
                    writtenOutput = outputField.getText() + "*";
                    outputField.setText(writtenOutput);
                }

                System.out.println("used multiply");
            }
        });

        buttonDivide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!outputField.getText().substring(outputField.getText().length() - 1).equals("*") && !outputField.getText().substring(outputField.getText().length() - 1).equals("/") && !outputField.getText().substring(outputField.getText().length() - 1).equals("+")) {
                    writtenOutput = outputField.getText() + "/";
                    outputField.setText(writtenOutput);
                }
                System.out.println("used divide");
            }
        });

    }

    private void calculate() {
        String toCalculate = outputField.getText();
        String[] operations = toCalculate.split("[0-9]+");
        //String[] numbers = toCalculate.split("\\\\+?\\\\d+|\\\\-?\\\\d+");
        double result = 0.0;
        double divisionResult = 0.0;
        boolean firstDivision = false;
        boolean divisionInARow = false;

        //String[] numbers = toCalculate.split("[+-/*]");
        String[] numbers = toCalculate.split("[+\\-*/]");

        List<String> forDetection = new ArrayList<>(Arrays.asList(operations));
        List<String> forDetectionFiltered = forDetection.stream().filter( x -> x.equals("/") || x.equals("+") || x.equals("-") || x.equals("*")).toList();


        if (forDetectionFiltered.getFirst().equals("/")){
            firstDivision = true;
        }

        int counterOfDivisions = 0;
        for (int i = 0; i < forDetectionFiltered.size(); i++) {
            System.out.println(forDetectionFiltered.get(i));
            if (forDetectionFiltered.get(i).contains("/") && operations.length > 1) {  // operations.lenght > 1 the change
                counterOfDivisions++;
            }
        }

        System.out.println(counterOfDivisions + " amount of divisions");
        operations = forDetectionFiltered.toArray(new String[0]);

       // String[] newNumbers = new String[counterOfDivisions];

        boolean divisionActive = false;
        boolean multiplicationActive = false;

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("/") && operations.length > 1) {  // operations.lenght > 1 the change
                divisionActive = true;
            }
        }

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("*") && operations.length > 1) {
                multiplicationActive = true;
            }
        }

        int newNumbersSize = 0;

        int divisionsInRow = 0;

        String[] operationsAndJunk = new String[operations.length + 1];

        for (int i = 0; i < operations.length; i++) {
            operationsAndJunk[i] = operations[i];
        }
        operationsAndJunk[operationsAndJunk.length - 1] = "0";

        for (int i = 0; i < operationsAndJunk.length; i++){
            if (operationsAndJunk[i].equals("/") && operationsAndJunk[i+1].equals("/")) {
                divisionsInRow++;
            }
        }

        System.out.println(divisionsInRow + " divison in a row counter");

        System.out.println(numbers.length + " old numbers");

        int counterOfMultiplication = 0;

        for (int i = 0; i < forDetectionFiltered.size(); i++) {
            System.out.println(forDetectionFiltered.get(i));
            if (forDetectionFiltered.get(i).contains("*") && operations.length > 1) {  // operations.lenght > 1 the change
                counterOfMultiplication++;
            }
        }

        System.out.println(counterOfDivisions + " counter of divisions");
        System.out.println(counterOfMultiplication + " counter of multiplication");


        if (divisionActive || multiplicationActive) { // do for multiplying
            newNumbersSize = numbers.length - counterOfDivisions - counterOfMultiplication;


//            if (divisionsInRow == 0){
//                newNumbersSize = numbers.length - counterOfDivisions;
//            }
//            else {
//                newNumbersSize = numbers.length - counterOfDivisions - divisionsInRow;
//            }
        }
        else {
            newNumbersSize = numbers.length;
        }

        System.out.println(newNumbersSize + " newNumber size");

        String[] newNumbers = new String[newNumbersSize];

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " unmodified numbers " + i + "= index of unmodified numbers");
        }

        List<Double> newNumbersList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(Double.parseDouble(numbers[i]) + " to be added");
            newNumbersList.add(Double.parseDouble(numbers[i]));
        }
        for (int i = 0; i < newNumbersList.size(); i++) {
            System.out.println(newNumbersList.get(i) + " from new nums list");
        }

        List<String> newOperationsList = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            newOperationsList.add(operations[i]);
        }
        for (int i = 0; i < newOperationsList.size(); i++) {
            System.out.println(newOperationsList.get(i) + " from operations list");
        }


        System.out.println(forDetectionFiltered + " filtered operations list");

        int updatedNumbersSize = 0;
        for (int i = 0; i < operations.length; i++) {
            if (i < operations.length - 1 && operations[i].equals("/") && operations[i + 1].equals("/")) {
                updatedNumbersSize++;
            }
        }

        double newResult = 1;

        int inRowCounter = 0;
        List<Integer> indexesOfRow = new ArrayList<>();

        for (int i = 0; i < operationsAndJunk.length; i++) {
            if (operationsAndJunk[i].equals("/") && operationsAndJunk[i+1].equals("/")){
                indexesOfRow.add(i);
                indexesOfRow.add(i + 1);
            }
        }

        for (int i = 0; i < indexesOfRow.size(); i++) {
            if (i < indexesOfRow.size() - 1 && indexesOfRow.get(i).equals(indexesOfRow.get(i+1))){
                indexesOfRow.remove(i);
            }
        }
        System.out.println(indexesOfRow + " divison indexes of row");

        List<Integer> indexesOfRowMultiplication = new ArrayList<>();

        for (int i = 0; i < operationsAndJunk.length; i++) {
            if (operationsAndJunk[i].equals("*") && operationsAndJunk[i+1].equals("*")){
                indexesOfRowMultiplication.add(i);
                indexesOfRowMultiplication.add(i + 1);
            }
        }

        for (int i = 0; i < indexesOfRowMultiplication.size(); i++) {
            if (i < indexesOfRowMultiplication.size() - 1 && indexesOfRowMultiplication.get(i).equals(indexesOfRowMultiplication.get(i+1))){
                indexesOfRowMultiplication.remove(i);
            }
        }

        boolean inRowMultiplicationAndDivision = false;
        boolean inRowDivisionAndMultiplication = false;
        int inRowMultiplicationAndDivisionCounter = 0;

        List<Integer> indexesOfRowDivAndMulti = new ArrayList<>();
        for (int i = 0; i < operationsAndJunk.length; i++) {
            if ((operationsAndJunk[i].equals("*") && operationsAndJunk[i+1].equals("/")) || (operationsAndJunk[i].equals("/") && operationsAndJunk[i+1].equals("*"))){
                indexesOfRowDivAndMulti.add(i);
            }
        }

//        for (int i = 0; i < indexesOfRowDivAndMulti.size(); i++) {
//            if (indexesOfRowDivAndMulti.get(i).equals(indexesOfRowDivAndMulti.get(i+1))){
//                indexesOfRowDivAndMulti.remove(i);
//            }
//        }

        System.out.println(indexesOfRowDivAndMulti + " multi div in a row");

        System.out.println(indexesOfRowMultiplication + " multiplication indexes of row");
        boolean inRowMultiDiv = false;

        if (indexesOfRowDivAndMulti.size() > 1) {
            inRowMultiDiv = true;
        }


        for (int j = 0; j < indexesOfRow.size(); j++) {
            System.out.println(indexesOfRow.get(j) + " from indexes row list");
        }

        for (int i = 0; i < indexesOfRow.size(); i++) {
            System.out.println(indexesOfRow.get(i) + " indexes");
        }

        int inRowMultiplicationCounter = 0;
        double newResultMultiplication = 1;
        double multiplicationResult = 0;

        boolean firstMultiThenDiv = false;
        boolean firstDivThenMulti = false;

        for (int i = 0; i < operationsAndJunk.length; i++) {
            if (operationsAndJunk[i].equals("*") && operationsAndJunk[i+1].equals("/")){
                firstMultiThenDiv = true;
            }
            if (operationsAndJunk[i].equals("/") && operationsAndJunk[i+1].equals("*")){
                firstDivThenMulti = true;
            }
        }


        if (inRowMultiDiv){
            for (int i = 0; i < operationsAndJunk.length; i++) {
                if (operationsAndJunk[i].equals("*") && operationsAndJunk[i+1].equals("/")){

                }
                if (operationsAndJunk[i].equals("/") && operationsAndJunk[i+1].equals("*")){

                }
            }
        }





        for (int i = 0; i < operationsAndJunk.length; i++) {
            if (multiplicationActive){
                if (operationsAndJunk[i].equals("*") && operationsAndJunk[i+1].equals("*")){
                    System.out.println("entered one after another");
                    inRowMultiplicationCounter++;
                    if (inRowMultiplicationCounter != 1){
                        newResultMultiplication = newResultMultiplication * Double.parseDouble(numbers[i+1]);
                        System.out.println(numbers[i+1] + " numbers[i+1] multiplication");
                        System.out.println("entered if inRowMultiplicationCounter != 1");
                        System.out.println(newResultMultiplication + " multiplication result");
                    }
                    else  {
                        newResultMultiplication = Double.parseDouble(numbers[i]) * Double.parseDouble(numbers[i+1]);
                        System.out.println(newResultMultiplication + " from else multi result");
                    }
                }

                if (operationsAndJunk[i].equals("*") && !operationsAndJunk[i+1].equals("*")){
                    if (newResultMultiplication != 1){
                        indexesOfRowMultiplication.sort(Comparator.reverseOrder());
                        multiplicationResult = newResultMultiplication * Double.parseDouble(numbers[i+1]);
                        newNumbersList.set(i+1, multiplicationResult);
                        for (int j = 0; j < newNumbersList.size(); j++) {
                            System.out.println(newNumbersList.get(j) + " newNumbersList before");
                        }

                        System.out.println(newOperationsList.size() + " size before");
                        for (int j = 0; j < indexesOfRowMultiplication.size(); j++) {
                            int index = indexesOfRowMultiplication.get(j);
                            newOperationsList.remove(index);
                        }
                        System.out.println(newOperationsList.size() + " size after");

                        for (int j = 0; j < indexesOfRowMultiplication.size(); j++) {
                            System.out.println(indexesOfRowMultiplication.get(j) + " indexes in row");
                        }

                        for (int j = 0; j < newOperationsList.size(); j++) {
                            System.out.println("entered new operations loop");
                            System.out.println(newOperationsList.get(j) + " from indexes row list");
                        }

                        for (int j = 0; j < indexesOfRowMultiplication.size(); j++) {
                            int index = indexesOfRowMultiplication.get(j);
                            System.out.println(index + " index about to be deleted");
                            newNumbersList.remove(index);
                        }

                        for (int j = 0; j < newNumbersList.size(); j++) {
                            System.out.println(newNumbersList.get(j) + " from number list");
                        }

                        for (int j = 0; j < newNumbersList.size(); j++) {
                            newNumbers[j] = String.valueOf(newNumbersList.get(j));
                        }
                    }
                    else {
                        if (newNumbers.length != 0) {
                            System.out.println("entered newNumbers.length != 0 in multi");
                            if (newNumbers[0] == null) {
                                System.out.println("newNumbers not set yet");

                                System.out.println(numbers[i] + " numbers[i]");
                                System.out.println(numbers[i+1] + " numbers[i+1]");
                                multiplicationResult = Double.parseDouble(numbers[i]) * Double.parseDouble(numbers[i+1]);

                                newNumbers = removeWords(numbers, i);


                                newNumbers[i] = String.valueOf(multiplicationResult);

                                newOperationsList.remove(i);
                            }
                            else {

                                multiplicationResult = Double.parseDouble(newNumbers[i - 1]) / Double.parseDouble(newNumbers[i]);
                                newNumbers[i] = String.valueOf(multiplicationResult);

                                System.out.println(numbers[i] + " numbers[i]");
                                System.out.println(numbers[i+1] + " numbers[i+1]");


//                                multiplicationResult = Double.parseDouble(newNumbers[i - 1]) / Double.parseDouble(newNumbers[i]);
//                                newNumbers[i] = String.valueOf(multiplicationResult);
//
//                                newNumbers = removeWords(newNumbers, i - 1);
                                newNumbers = removeWords(newNumbers, i-1);
                                newOperationsList.remove(i);
                            }
                        }
                        else {


                            multiplicationResult = Double.parseDouble(numbers[i]) * Double.parseDouble(numbers[i + 1]);
                            numbers[i] = Double.toString(multiplicationResult);

                            newNumbers = removeWords(numbers, i + 1);
                        }
                    }

                }

            }
        }


        System.out.println(multiplicationResult + " multiplication result!!!");
        for (int i = 0; i < newNumbers.length; i++) {
            System.out.println(newNumbers[i] + " from new nums array after multiplication");
        }




        for (int i = 0; i < operationsAndJunk.length; i++) {
            if (divisionActive) {
                if (operationsAndJunk[i].equals("/") && operationsAndJunk[i+1].equals("/")) {  // to add junk symbol at the end of operation array and delete it right after
                    inRowCounter++;
                    System.out.println(inRowCounter + " instantly");
                    System.out.println("in a row");
                    System.out.println(i + " index");
                    if (inRowCounter != 1){
                        System.out.println("inRowCounter != 1");
                        System.out.println(newResult + " / " + numbers[i+1]);
                        newResult = newResult / Double.parseDouble(numbers[i+1]);
                        System.out.println("new new new result " + newResult);
                    }
                    else {
                        newResult = Double.parseDouble(numbers[i]) / Double.parseDouble(numbers[i+1]);
                        System.out.println(newResult + " new result");
                    }
                }


                if (operationsAndJunk[i].equals("/") && !operationsAndJunk[i+1].equals("/")) {
                    System.out.println("entered if");
                    System.out.println(i + " index after entering if");
                    if (newResult != 1){
                        for (int j = 0; j < numbers.length; j++) {
                            System.out.println(numbers[j] + " from regular numbers " + j + "=index");
                        }

                        System.out.println(indexesOfRow.size() + " size of in row");

                        indexesOfRow.sort(Collections.reverseOrder());  // sort, because have to start from the biggest index first otherwise will be wrong indexation and therefore result issue

                        divisionResult = newResult / Double.parseDouble(numbers[i+1]);  // swap element from newNumbers[i] to divisionResult

                        System.out.println(indexesOfRow.size() + " size of indexes in row");
                        newNumbersList.set(i+1, divisionResult);

                        for (int j = 0; j < newNumbersList.size(); j++) {
                            System.out.println(newNumbersList.get(j) + " before remove(index)");
                        }

                        System.out.println(newOperationsList + " before");
                        for (int j = 0; j < indexesOfRow.size(); j++) {
                            int index = indexesOfRow.get(j);
                            newOperationsList.remove(index);
                        }

                        System.out.println(newOperationsList + " after");

                        for (int j = 0; j < newOperationsList.size(); j++) {
                            System.out.println(newOperationsList.get(j) + " operations list after remove");
                        }

                        for (int j = 0; j < indexesOfRow.size(); j++) {
                            int index = indexesOfRow.get(j);
                            System.out.println(index + " index about to be deleted");
                            newNumbersList.remove(index);
                        }

                        for (int j = 0; j < newNumbersList.size(); j++) {
                            System.out.println(newNumbersList.get(j) + " from N E W nums list");
                        }

                        System.out.println(newNumbers.length + " len of newNumbers array");
                        System.out.println(newNumbersList.size() + " size of new num list");

                        for (int j = 0; j < newNumbersList.size(); j++) {
                            newNumbers[j] = String.valueOf(newNumbersList.get(j));
                        }
                        for (int j = 0; j < newNumbers.length; j++) {
                            System.out.println(newNumbers[j] + " from N E W nums array");
                        }
                    }
                    else {
                        if (newNumbers.length != 0){
                            if (newNumbers[0] == null) {
                                divisionResult = Double.parseDouble(numbers[i]) / Double.parseDouble(numbers[i+1]);

                                newNumbers = removeWords(numbers, i);
                                newNumbers[i] = String.valueOf(divisionResult);

                                newOperationsList.remove(i);
                            }
                            else {
                                System.out.println("entered newNumbers.length != 0");
                                for (int j = 0; j < newNumbers.length; j++) {
                                    System.out.println(newNumbers[j] + " from N E W nums array");
                                }
                                System.out.println(newNumbers[i] + " newNumbers[i]");

                                System.out.println("index before loop=" + i);
                                for (int j = 0; j < newNumbers.length; j++) {
                                    System.out.println(newNumbers[j] + " new numbers in else else division, index=" + j);
                                }

                                System.out.println(newNumbers[i] + " newNumbers[i]");
                                //System.out.println(newNumbers[i + 1] + " newNumbers[i+1]");
                                System.out.println("after");


                                System.out.println(i + " index i");
                                if (i == 0) {
                                    System.out.println("i == 0");
                                    divisionResult = Double.parseDouble(newNumbers[i]) / Double.parseDouble(newNumbers[i + 1]);
                                    System.out.println(divisionResult + " division result");
                                    newNumbers[i] = String.valueOf(divisionResult);

                                    for (int j = 0; j < newNumbers.length; j++) {
                                        System.out.println(newNumbers[j] + " new numbers in else else division, index=" + j);
                                    }

                                    System.out.println(newNumbers[i] + " newNumbers[i] before deletion");
                                    for (int j = 0; j < newNumbers.length; j++) {
                                        System.out.println(newNumbers[j] + " all newNumbers before");
                                    }

                                    newNumbers = removeWords(newNumbers, i+1);
                                    System.out.println(newNumbers[i] + " newNumbers[i] after deletion");
                                    for (int j = 0; j < newNumbers.length; j++) {
                                        System.out.println(newNumbers[j] + " all newNumbers after");
                                    }

                                    System.out.println(operationsAndJunk[i] + " to remove operation, index=" + i);

                                    newOperationsList.remove(i);
                                }
                                else {
                                    System.out.println("i != 0");
                                    divisionResult = Double.parseDouble(newNumbers[i - 1]) / Double.parseDouble(newNumbers[i]);
                                    System.out.println(divisionResult + " division result");
                                    newNumbers[i] = String.valueOf(divisionResult);

                                    newNumbers = removeWords(newNumbers, i - 1);

                                    System.out.println(operationsAndJunk[i] + " to remove operation, index=" + i);

                                    newOperationsList.remove(i - 1);
                                }
                            }
                        }
                        else {
                            System.out.println("entered else");
                            System.out.println(numbers[i] + " " + numbers[i + 1] + " index=" + i);

                            System.out.println(numbers[i] + " /" + numbers[i + 1]);

                            divisionResult = Double.parseDouble(numbers[i]) / Double.parseDouble(numbers[i + 1]);

                            for (int j = 0; j < numbers.length; j++) {
                                System.out.println(numbers[i] + " numbers nefore numbers[i] = Double.toString(divisionResult)");
                            }

                            numbers[i] = Double.toString(divisionResult);
                            for (int j = 0; j < numbers.length; j++) {
                                System.out.println(numbers[i] + " numbers after numbers[i] = Double.toString(divisionResult)");
                            }

                            newNumbers = removeWords(numbers, i + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i< newNumbers.length; i++) {
            System.out.println(newNumbers[i] + " from new nums array after division");
        }


        System.out.println(newNumbers.length + " newNumbers array len");
        for (int i = 0; i < newNumbers.length; i++) {
            System.out.println(newNumbers[i] + " newNumbers array after loop");
        }

        for (int i = 0; i < indexesOfRow.size(); i++) {
            System.out.println(indexesOfRow.get(i) + " indexes in a row");
        }


        System.out.println(divisionResult + " division result!!!");

        if (!divisionActive && !multiplicationActive) {
            for (int i = 0; i < newNumbersSize; i++) {
                newNumbers[i] = numbers[i];
            }
        }

        for (int i = 0; i < newNumbers.length; i++) {
            System.out.println(newNumbers[i] + " modified numbers");
        }


        if (toCalculate.substring(0,1).equals("-")) {
            toCalculate = toCalculate.substring(1);  // remove first character of a String
            result = Double.parseDouble(newNumbers[0]) * (-1);
        }
        else {
            result = Double.parseDouble(newNumbers[0]);
        }

        System.out.println(result + " result pre");

        String[] finalOperations = new String[newOperationsList.size()];  // to fix operations


        for (int i = 0; i < finalOperations.length; i++) {
            finalOperations[i] = newOperationsList.get(i);
        }

        for (int i = 0; i < finalOperations.length; i++) {
            System.out.println(finalOperations[i] + " from final operations array");
        }
        System.out.println(finalOperations.length + " finalOperations array len");
        System.out.println(newNumbers.length + " newNumbers array len");

            for (int i = 0; i < finalOperations.length; i++) {
                if(finalOperations[i].equals("/") && finalOperations.length == 1) {
                    System.out.println("case first division");
                    if (Double.parseDouble(newNumbers[i]) == 0) {
                        System.out.println("cant devide by zero");
                    }
                    System.out.println("division in the very beginning");
                    System.out.println(result + " / " + Double.parseDouble(newNumbers[i+1]) + " being calculated");
                    result = result / Double.parseDouble(newNumbers[i+1]);
                }
                if(finalOperations[i].equals("*") && finalOperations.length == 1) {
                    System.out.println("case first multiplication");
                    result = result * Double.parseDouble(newNumbers[i+1]);
                }
                if(finalOperations[i].equals("+")) {
                    System.out.println(i + " index right now");
                    System.out.println(newNumbers[i] + " newNumbers[i]");
                    System.out.println(newNumbers[i+1] + " newNumbers[i+1]");
                    result = result + Double.parseDouble(newNumbers[i+1]);

//                    if (i == 0){
//                        System.out.println("i == 0");
//                        System.out.println(newNumbers[i] + " newNumbers[i]");
//                        System.out.println(newNumbers[i+1] + " newNumbers[i+1]");
//                        System.out.println(result + " result before");
//
//                        result = result + Double.parseDouble(newNumbers[i+1]);  // to delete / from operations of in a row
//                        System.out.println(result + " result after");
//                    }
//                    else {
//                        System.out.println("else");
//                        System.out.println(newNumbers[i] + " newNumbers[i]");
//                        System.out.println(newNumbers[i+1] + " newNumbers[i+1]");
//                        System.out.println(result + " result before (else)");
//
//
//                        result = result + Double.parseDouble(newNumbers[i]);
//                        System.out.println(result + " result after(else)");
//                    }
                }
                if(finalOperations[i].equals("-")) {

                    result = result - Double.parseDouble(newNumbers[i+1]);

//                    if (i == 0){
//                        result = result - Double.parseDouble(newNumbers[i+1]);
//                    }
//                    else {
//                        result = result - Double.parseDouble(newNumbers[i]);
//                    }
                }
            }

            for (int i = 0; i < finalOperations.length; i++) {
                System.out.println(finalOperations[i] + " operations after calculations");
            }

        outputField.setText(String.valueOf(result));

    }

    public static String[] removeWords(String[] array, int indexToDelete) {
        String[] smallerArray = new String[array.length - 1];

        int indexSmallerArray = 0;

        for (int i = 0; i < array.length; i++) {
            if (i != indexToDelete) {
                smallerArray[indexSmallerArray] = array[i];
                indexSmallerArray++;
            }
        }

    return smallerArray;

    }


}
