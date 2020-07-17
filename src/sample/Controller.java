package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.lang.*;
import java.text.DecimalFormat;

public class Controller {
    Boolean resultOperation=false;
    DecimalFormat df = new DecimalFormat("#.##############");
    @FXML
    private TextField txtDisplay;


    @FXML
    private void handleDigitAction(ActionEvent event) {
        if(resultOperation){
            txtDisplay.clear();
            resultOperation=false;
        }
        String digit = ((Button) event.getSource()).getText();
        String oldText = txtDisplay.getText();
        String newText = oldText + digit;
        txtDisplay.setText(newText);


    }

    @FXML
    private void handleOperationAction(ActionEvent event) {
        String newText = txtDisplay.getText();
        Double newDigit = Double.parseDouble(newText);
        String currentOperation = ((Button) event.getSource()).getText();
        txtDisplay.setText(df.format(newDigit) + currentOperation);
    }

    @FXML
    private void handleEqualOperation(ActionEvent event) {
        Double num1,num2,result;
        String newText = txtDisplay.getText();
        System.out.println(newText);
        if (newText.contains("+")) {
            String[] parts = newText.split("\\+");
            String part1 = parts[0];
            String part2 = parts[1];
            num1=Double.parseDouble(part1);
            num2=Double.parseDouble(part2);
            result=num1+num2;
            txtDisplay.setText(df.format(result));
        }else if(newText.contains("-")){
            String[] parts = newText.split("-");
            String part1 = parts[0];
            String part2 = parts[1];
            num1=Double.parseDouble(part1);
            num2=Double.parseDouble(part2);
            result=num1-num2;
            txtDisplay.setText(result.toString());
        }else if(newText.contains("/")){
            String[] parts = newText.split("/");
            String part1 = parts[0];
            String part2 = parts[1];
            num1=Double.parseDouble(part1);
            num2=Double.parseDouble(part2);
            result=num1/num2;
            txtDisplay.setText(df.format(result));
        }else if(newText.contains("X")){
            String[] parts = newText.split("X");
            String part1 = parts[0];
            String part2 = parts[1];
            num1=Double.parseDouble(part1);
            num2=Double.parseDouble(part2);
            result=num1*num2;
            txtDisplay.setText(df.format(result));
        }
        resultOperation=true;

    }

    @FXML
    private void handleClearAction(ActionEvent event) {
        txtDisplay.clear();
    }

    @FXML
    private void handleBackspaceAction(ActionEvent event) {
        StringBuilder sb = new StringBuilder(txtDisplay.getText());
        if (sb.length() > 0 )
        sb.deleteCharAt(txtDisplay.getText().length() - 1);
        txtDisplay.setText(sb.toString());

    }

}

