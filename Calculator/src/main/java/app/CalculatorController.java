package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    private String writtenOutput = "";
    private int firstNumber = 0;
    private int secondNumber = 0;


    @FXML
    private void initialize() {
        outputField.setEditable(false);

        handleNumberButtons();
    }

    private void handleNumberButtons(){
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
                outputField.setText(writtenOutput);;

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
                if (!outputField.getText().substring(outputField.getText().length() - 1).equals("+") && !outputField.getText().substring(outputField.getText().length() - 1).equals("-")) {  // checking if last character of a user input String is equal + and if it is already then input won't change (cant be something like 1 +++ and if previous character is not equal - so (55-+1000 for example) is not possible either
                    writtenOutput = outputField.getText() + "+";
                    outputField.setText(writtenOutput);
                }

                System.out.println("used plus");
            }
        });

        buttonMinus.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                if (!outputField.getText().substring(outputField.getText().length() - 1).equals("-")) {
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



    }

    private void calculate(){
        String toCalculate = outputField.getText();;
        int result = 0;
        List<Integer> numbers = new ArrayList<>();
        List<String> operations = new ArrayList<>();

        String newComma = toCalculate.replaceAll("[^0-9]",",");
        String[] parts = newComma.split(",");

        for (int i = 0; i < parts.length; i++) {
            numbers.add(Integer.parseInt(parts[i]));
        }



        for (int i = 0; i < toCalculate.length(); i++) {
            if (toCalculate.charAt(i) == '+') {
                operations.add("+");
            }
            if (toCalculate.charAt(i) == '-') {
                operations.add("-");
            }
        }
        System.out.println(operations);
        Iterator<Integer> iterator = numbers.iterator();
      //  for (int i = 0; i < numbers.size(); i++) {
            //System.out.println(numbers.get(i) + " from simple loop");
//            if (i != numbers.size() - 1) {
//                System.out.println(numbers.get(i) + " not lasts");
//            }
//
//            if (i == numbers.size() - 1) {
//                System.out.println(numbers.get(i) + " last");
//            }
//        }
        List<Integer> solvedList = new ArrayList<>();
        int firstResult = 0;

            for (int i = 0; i < operations.size(); i++) {
                if (operations.get(i).equals("+")) {
                    //System.out.println(numbers.get(i) + "+");
                    //result = numbers.get(i) + numbers.get(i + 1);
                    for (int j = 0; j < numbers.size(); j++) {
                        System.out.println((numbers.get(j).toString() + operations.get(i) + numbers.get(j+1)) + " debug statement");
                        if ((numbers.get(j).toString() + operations.get(i) + numbers.get(j+1).toString()).equals(outputField.getText())) {
                            System.out.println(numbers.get(j) + numbers.get(j+1) + " inside if");
                        }
                        break;

//                        if ((numbers.get(j).toString() + operations.get(i)).equals(outputField.getText())) {
//                            System.out.println(numbers.get(j));
//                            break;
//                        }
//                        System.out.println(numbers.get(j));

                    }
                }
            }

            }

            //System.out.println(numbers + " list in the end");

        //System.out.println(result + " in the end");

        }
