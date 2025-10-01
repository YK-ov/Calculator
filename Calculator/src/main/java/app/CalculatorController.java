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
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("/") && operations.length > 1) {  // operations.lenght > 1 the change
                divisionActive = true;
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
        if (divisionActive) {
            newNumbersSize = numbers.length - counterOfDivisions;


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

        String[] updatedNumbers = new String[updatedNumbersSize];
        double newResult = 1;

//        String[] operationsAndJunk = new String[operations.length + 1]; -- TO uncomment perhaps
//
//        for (int i = 0; i < operations.length; i++) {
//            operationsAndJunk[i] = operations[i];
//        }
//        operationsAndJunk[operationsAndJunk.length - 1] = "0";
//
//        System.out.println(operationsAndJunk.length + " len of new arr");
//        for (int i = 0; i < operationsAndJunk.length; i++) {
//            System.out.println(operationsAndJunk[i] + " operations and junk");
//        }

//        int inRowCounter = 0;
//
//        for (int i = 0; i < operationsAndJunk.length; i++) {
//            if (operationsAndJunk[i].equals("/") && operationsAndJunk[i+1].equals("/")){
//                inRowCounter++;
//            }
//        }



        //String[] numbersUpdated = new String[inRowCounter];

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

        for (int j = 0; j < indexesOfRow.size(); j++) {
            System.out.println(indexesOfRow.get(j) + " from indexes row list");
        }

        for (int i = 0; i < indexesOfRow.size(); i++) {
            System.out.println(indexesOfRow.get(i) + " indexes");
        }


        for (int i = 0; i < operationsAndJunk.length; i++) {
            if (divisionActive) {
                if (operationsAndJunk[i].equals("/") && operationsAndJunk[i+1].equals("/")) {  // to add junk symbol at the end of operation array and delete it right after
                    inRowCounter++;
                    System.out.println(inRowCounter + " instantly");
                    System.out.println("in a row");
                    System.out.println(i + " index");
                    if (inRowCounter != 1){
                        //numbersUpdated = removeWords(numbers, i-1);
                        System.out.println("inRowCounter != 1");
                        System.out.println(newResult + " / " + numbers[i+1]);
                        newResult = newResult / Double.parseDouble(numbers[i+1]);
                        System.out.println("new new new result " + newResult);
                    }
                    else {

                        newResult = Double.parseDouble(numbers[i]) /Double.parseDouble(numbers[i+1]);
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

                        for (int j = 0; j < indexesOfRow.size(); j++) {
                            int index = indexesOfRow.get(j);
                            newOperationsList.remove(index);
                        }

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
                    }
                    else {
                        System.out.println("entered else");
                        System.out.println(numbers[i] + " " + numbers[i + 1] + " index=" + i);

                        System.out.println(numbers[i] + " /" + numbers[i + 1]);

                        divisionResult = Double.parseDouble(numbers[i]) / Double.parseDouble(numbers[i + 1]);

                        numbers[i] = Double.toString(divisionResult);

                        newNumbers = removeWords(numbers, i + 1);
                    }
                }
            }
        }

        for (int i = 0; i < indexesOfRow.size(); i++) {
            System.out.println(indexesOfRow.get(i) + " indexes in a row");
        }


        System.out.println(divisionResult + " division result!!!");

        if (!divisionActive) {
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

        String[] finalOperations = new String[newOperationsList.size()];


        for (int i = 0; i < finalOperations.length; i++) {
            finalOperations[i] = newOperationsList.get(i);
        }

        for (int i = 0; i < finalOperations.length; i++) {
            System.out.println(finalOperations[i] + " from final operations array");
        }

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
                if(finalOperations[i].equals("*")) {
                    result = result * Double.parseDouble(newNumbers[i+1]);
                }
                if(finalOperations[i].equals("+")) {
                    System.out.println(i + " index right now");
                    System.out.println(newNumbers[i] + " newNumbers[i]");
                    System.out.println(newNumbers[i+1] + " newNumbers[i+1]");

                    if (i == 0){
                        result = result + Double.parseDouble(newNumbers[i+1]);  // to delete / from operations of in a row
                    }
                    else {
                        result = result + Double.parseDouble(newNumbers[i]);
                    }
                }
                if(finalOperations[i].equals("-")) {
                    result = result - Double.parseDouble(newNumbers[i+1]);
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
