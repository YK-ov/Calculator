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

        //String[] numbers = toCalculate.split("[+-/*]");
        String[] numbers = toCalculate.split("[+\\-*/]");

        /*  MODIFIED FOR A CHANGE
        if (toCalculate.substring(0,1).equals("-")) {
            toCalculate = toCalculate.substring(1);  // remove first character of a String
            numbers = toCalculate.split("[+-/*]");
            result = Double.parseDouble(numbers[0]) * (-1);
        }
        else {
            result = Double.parseDouble(numbers[0]);
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " unmodified numbers");
        }

         */

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

        if (divisionActive == true) {
            newNumbersSize = counterOfDivisions;
        }
        else {
            newNumbersSize = numbers.length;
        }
        System.out.println(newNumbersSize + " newNumber size");

        String[] newNumbers = new String[newNumbersSize];

        for (int i = 0; i < operations.length; i++) {
            if (divisionActive == true) {
                if (operations[i].equals("/")) {
                    //String temp = numbers[0];
                    System.out.println("entered if");

                    System.out.println(numbers[i] + " /" + numbers[i + 1]);
                    divisionResult = Double.parseDouble(numbers[i]) / Double.parseDouble(numbers[i + 1]);
                    numbers[i] = Double.toString(divisionResult);
                    //numbers[i] = Double.toString(divisionResult);
                    newNumbers = removeWords(numbers, i + 1);
                    //numbers[0] = temp;
                }
            }
        }

        if (divisionActive == false) {
            for (int i = 0; i < newNumbersSize; i++) {
                newNumbers[i] = numbers[i];
            }
        }


        for (int i = 0; i < newNumbers.length; i++) {
            System.out.println(newNumbers[i] + " modified numbers");
        }

        if (toCalculate.substring(0,1).equals("-")) {
            toCalculate = toCalculate.substring(1);  // remove first character of a String
            numbers = toCalculate.split("[+-/*]");
            result = Double.parseDouble(newNumbers[0]) * (-1);
        }
        else {
            result = Double.parseDouble(newNumbers[0]);
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " unmodified numbers");
        }


        System.out.println(operations.length + " len");
        System.out.println(result + " result regestered");

            for (int i = 0; i < operations.length; i++) {
                if(operations[i].equals("/") && operations.length == 1) {
                    System.out.println("case first division");
                    if (Double.parseDouble(newNumbers[i]) == 0) {
                        System.out.println("cant devide by zero");
                    }
                    System.out.println("division in the very beginning");
                    System.out.println(result + " / " + Double.parseDouble(newNumbers[i+1]) + " being calculated");
                    result = result / Double.parseDouble(newNumbers[i+1]);
                }
                if(operations[i].equals("*")) {
                    result = result * Double.parseDouble(newNumbers[i+1]);
                }
                if(operations[i].equals("+")) {
                    //result = result + Double.parseDouble(numbers[i]);
                  /*  System.out.println(numbers[i] + " current number for addition");
                    if (divisionResult != 0.0) {
                        System.out.println(divisionResult + " div esult");
                        System.out.println("division detected");
                        System.out.println("number we add division to is below");
                        System.out.println(Double.parseDouble(numbers[i]));
                        result = divisionResult + Double.parseDouble(numbers[i]);
                    }
                    else {
                        result = result + Double.parseDouble(numbers[i]);
                    }
*/
                    //System.out.println(result + " + " + numbers[i]);
                    //System.out.println(Double.parseDouble(numbers[i]) + " number added parsed");
                    System.out.println(newNumbers[i] + " inside plus");
                    System.out.println(result + " result in loop");
                    System.out.println(newNumbers[i] + " inside plus");
                    System.out.println(result + " + " + Double.parseDouble(newNumbers[i+1]));
                    result = result + Double.parseDouble(newNumbers[i+1]); // i + 1 necessary
                    System.out.println(result + " result in an if");
                }
                if(operations[i].equals("-")) {
                    result = result - Double.parseDouble(newNumbers[i+1]);
                }
            }
            for (int i = 0; i < operations.length; i++) {
                System.out.println(operations[i] + " operations after calculations");
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
