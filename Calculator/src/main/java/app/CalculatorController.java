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
    @FXML
    private Button buttonOpenParenthesis;
    @FXML
    private Button buttonCloseParenthesis;
    @FXML
    private Button buttonClear;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonDot;

    private String writtenOutput = "";
    private String RPN = "";


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

        buttonOpenParenthesis.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = outputField.getText() + "(";
                outputField.setText(writtenOutput);
            }
        });

        buttonCloseParenthesis.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = outputField.getText() + ")";
                outputField.setText(writtenOutput);
            }
        });

        buttonClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = "";
                outputField.setText(writtenOutput);
            }
        });

        buttonDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writtenOutput = outputField.getText().substring(0, outputField.getText().length() - 1);

                outputField.setText(writtenOutput);
            }
        });

        buttonDot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!outputField.getText().substring(outputField.getText().length() - 1).equals(".")){
                    writtenOutput = outputField.getText() + ".";
                }

                outputField.setText(writtenOutput);
            }
        });

    }

    public int getPriority(char c){
        if (c == '+' || c == '-'){
            return 1;
        }
        else if (c == '*' || c == '/'){
            return 2;
        }
        else {
            return -1;
        }
    }

    private void infixToRpn() {
        RPN = "";
        System.out.println(outputField.getText());

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < outputField.getText().length(); i++) {
            char c = outputField.getText().charAt(i);

            if (Character.isDigit(c) || c == '.') {
                RPN = RPN + c;

                if (i + 1 >= outputField.getText().length() || (!Character.isDigit(outputField.getText().charAt(i + 1))) && outputField.getText().charAt(i + 1) != '.') {
                    RPN = RPN + " ";
                }
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    RPN = RPN + stack.pop() + " ";
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())) {
                    RPN = RPN + stack.pop() + " ";
                }
                stack.push(c);
            }

        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '('){
                System.out.println("Invalid expression");
            }
            RPN = RPN + stack.pop() + " ";
        }

        RPN = RPN.trim();
    }

    private double doOperation (double firstNum, double secondNum, char operator) {
        switch (operator){
            case '+':
                return firstNum + secondNum;
            case '-':
                return firstNum - secondNum;
            case '*':
                return firstNum * secondNum;
            case '/':
                return firstNum / secondNum;
        }
        return 0;
    }



    private void calculate() {
//        String toCalculate = outputField.getText();
//        String[] operations = toCalculate.split("[0-9]+");
//        //String[] numbers = toCalculate.split("\\\\+?\\\\d+|\\\\-?\\\\d+");
//        double result = 0.0;
//        double divisionResult = 0.0;
//        boolean firstDivision = false;
//        boolean divisionInARow = false;
//
//        //String[] numbers = toCalculate.split("[+-/*]");
//        String[] numbers = toCalculate.split("[+\\-*/]");
//
//        List<String> forDetection = new ArrayList<>(Arrays.asList(operations));
//        List<String> forDetectionFiltered = forDetection.stream().filter(x -> x.equals("/") || x.equals("+") || x.equals("-") || x.equals("*")).toList();


        infixToRpn();

        String[] tokens = RPN.split(" ");

        Stack<Double> stack = new Stack<>();

        String expression = RPN;
        System.out.println(expression + "RNP");

        for (int i = 0; i < tokens.length; i++) {

            if (Character.isDigit(tokens[i].charAt(0))) {
                stack.push(Double.parseDouble(tokens[i]));
            }
            else {
                if (!Character.isDigit(tokens[i].charAt(0)) && !Character.isWhitespace(tokens[i].charAt(0))) {
                    if (stack.size() < 2){
                        System.out.println("Invalid expression");
                    }
                    double firstNum = stack.peek();
                    stack.pop();
                    double secondNum = stack.peek();
                    stack.pop();
                    stack.push(doOperation(secondNum, firstNum, tokens[i].charAt(0)));
                }
            }
//            if (stack.size() != 1){
//                System.out.println("Invalid expression");
//            }

        }
        double result = stack.peek();
        stack.pop();

        //System.out.println(RPN + "= RPN");

        outputField.setText(String.valueOf(result));

    }


}
