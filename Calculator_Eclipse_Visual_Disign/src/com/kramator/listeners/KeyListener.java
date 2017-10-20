package com.kramator.listeners;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.kramator.listeners.ButtonListener.*;

public class KeyListener extends KeyAdapter {
    private JTextField txtDisplay;

    public KeyListener(JTextField txtDisplay) {
        this.txtDisplay = txtDisplay;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        zero = 1.0;
        System.out.println(event.getKeyCode());

        if (txtDisplay.getText().equals("0") || txtDisplay.getText().equals("0.0")) {
            txtDisplay.setText("");
            zero = 0.0;
        }

        if (event.getKeyCode() == KeyEvent.VK_NUMPAD0 ||
                event.getKeyCode() == KeyEvent.VK_NUMPAD1 ||
                event.getKeyCode() == KeyEvent.VK_NUMPAD2 ||
                event.getKeyCode() == KeyEvent.VK_NUMPAD3 ||
                event.getKeyCode() == KeyEvent.VK_NUMPAD4 ||
                event.getKeyCode() == KeyEvent.VK_NUMPAD5 ||
                event.getKeyCode() == KeyEvent.VK_NUMPAD6 ||
                event.getKeyCode() == KeyEvent.VK_NUMPAD7 ||
                event.getKeyCode() == KeyEvent.VK_NUMPAD8 ||
                event.getKeyCode() == KeyEvent.VK_NUMPAD9) {
            txtDisplay.replaceSelection("" + event.getKeyChar());

        } else if (event.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            System.out.println("BackSpace");
            String backspace = null;

            if (txtDisplay.getText().length() > 0) {
                StringBuilder sb = new StringBuilder(txtDisplay.getText());
                sb.deleteCharAt(txtDisplay.getText().length() - 1);
                backspace = sb.toString();
                txtDisplay.setText(backspace);
            }

        } else if(event.getKeyCode() == KeyEvent.VK_DIVIDE) {
            firstNum = Double.parseDouble(txtDisplay.getText());
            txtDisplay.setText("");
            operations = "/";

        } else if(event.getKeyCode() == KeyEvent.VK_MULTIPLY) {
            firstNum = Double.parseDouble(txtDisplay.getText());
            txtDisplay.setText("");
            operations = "*";

        } else if(event.getKeyCode() == KeyEvent.VK_SUBTRACT) {
            firstNum = Double.parseDouble(txtDisplay.getText());
            txtDisplay.setText("");
            operations = "-";

        } else if(event.getKeyCode() == KeyEvent.VK_DECIMAL) {
            String str = txtDisplay.getText();
            String strResult = null;

            if (!str.contains(".")) {
                strResult = str + ".";
            } else {
                txtDisplay.setText(str);
            }
            txtDisplay.setText(strResult);

        } else if(event.getKeyCode() == KeyEvent.VK_ADD) {
            firstNum = Double.parseDouble(txtDisplay.getText());
            txtDisplay.setText("");
            operations = "+";

        } else if(event.getKeyCode() == KeyEvent.VK_ENTER) {

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
        }
    }
}
