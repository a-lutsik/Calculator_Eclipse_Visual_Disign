package com.kramator.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private JTextField txtDisplay;
    static double firstNum;
    static double secondNum;
    static double result;
    static String answer;
    static String operations;
    static double zero;

    public ButtonListener(JTextField txtDisplay) {
        this.txtDisplay = txtDisplay;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (!(event.getSource() instanceof JButton)) {
            return;
        }

        zero = 1.0;

        if (txtDisplay.getText().equals("0") || txtDisplay.getText().equals("0.0")) {
            txtDisplay.setText("");
            zero = 0.0;
        }

        JButton button = (JButton) event.getSource();

        if (button.getText().equals("\uF0E7")) { // backspace
            StringBuilder sb = new StringBuilder(txtDisplay.getText());

            if (sb.length() == 0) {
                txtDisplay.setText("0");
            }

            sb.deleteCharAt(sb.length() - 1);
            txtDisplay.setText(sb.toString());

        } else if (button.getText().equals("C")) {
            txtDisplay.setText("0");

        } else if (button.getText().equals("\u00B1")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = ops * (-1);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("\u221A")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.sqrt(ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("/")) {
            firstNum = Double.parseDouble(txtDisplay.getText());
            txtDisplay.setText("");
            operations = "/";

        } else if (button.getText().equals("%")) {
            firstNum = Double.parseDouble(txtDisplay.getText());
            txtDisplay.setText("");
            operations = "%";

        } else if (button.getText().equals("*")) {
            firstNum = Double.parseDouble(txtDisplay.getText());
            txtDisplay.setText("");
            operations = "*";

        } else if (button.getText().equals("1/x")) {
            double ops = 0.0;

            if (txtDisplay.getText().equals("") && zero == 1.0) {
                txtDisplay.setText("Enter a number");
            } else if (zero == 0) {
                ops = 0.0;
            } else {
                ops = Double.parseDouble(txtDisplay.getText());
            }

            if (ops != 0) {
                txtDisplay.setText(String.valueOf(1 / ops));
            } else {
                txtDisplay.setText("Сan't divide to zero");
            }

        } else if (button.getText().equals("-")) {
            firstNum = Double.parseDouble(txtDisplay.getText());
            txtDisplay.setText("");
            operations = "-";

        } else if (button.getText().equals(".")) {
            String str = txtDisplay.getText();
            String strResult = null;
            if (!str.contains(".")) {
                strResult = str + ".";
            } else {
                txtDisplay.setText(str);
            }
            txtDisplay.setText(strResult);

        } else if (button.getText().equals("+")) {
            firstNum = Double.parseDouble(txtDisplay.getText());
            txtDisplay.setText("");
            operations = "+";

        } else if (button.getText().equals("=")) {

            if (txtDisplay.getText().equals("") && zero == 1.0) {
                txtDisplay.setText("Enter a number");
            } else if (zero == 0) {
                secondNum = 0.0;
            } else {
                secondNum = Double.parseDouble(txtDisplay.getText());
            }

            if (operations.equals("+")) {
                result = firstNum + secondNum;
                answer = String.format("%.2f", result);
                txtDisplay.setText(answer);
            } else if (operations.equals("-")) {
                result = firstNum - secondNum;
                answer = String.format("%.2f", result);
                txtDisplay.setText(answer);
            } else if (operations.equals("*")) {
                result = firstNum * secondNum;
                answer = String.format("%.2f", result);
                txtDisplay.setText(answer);
            } else if (operations.equals("/")) {
                if (secondNum == 0.0) {
                    txtDisplay.setText("Can't divide to zero");
                } else {
                    result = firstNum / secondNum;
                    answer = String.format("%.2f", result);
                    txtDisplay.setText(answer);
                }
            }

        } else if (button.getText().equals("CE")) {
            txtDisplay.setText("");

        } else {
            //Handler of number buttons (0, 1, 2, 3.....9)
            txtDisplay.replaceSelection("" + button.getActionCommand());

        }
    }
}

