package com.kramator.listeners;

import com.kramator.main.ScientificCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonScientificListener implements ActionListener {
    private JTextField txtDisplay;

    public ButtonScientificListener(JTextField txtDisplay) {
        this.txtDisplay = txtDisplay;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (!(event.getSource() instanceof JButton)) {
            return;
        }

        if (txtDisplay.getText().equals("0") || txtDisplay.getText().equals("0.0")) {
            txtDisplay.setText("");
        }

        if (txtDisplay.getText().equals("")) {
            txtDisplay.setText("Enter a number");
        }

        JButton button = (JButton) event.getSource();

        if (button.getText().equals("Log")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.log(ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("Sin")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.sin(ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("Sinh")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.sinh(ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("Mod")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.abs(ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("\u03C0")) {
            txtDisplay.setText(String.valueOf(3.1415926535897932384626433832795));

        } else if (button.getText().equals("Cos")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.cos(ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("Cosh")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.cosh(ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("Inx")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.log10(ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("x^y")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.pow(ops, ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("Tan")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.tan(ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("Tanh")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.tanh(ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("Exp")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.exp(ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("x^2")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.pow(ops, 2);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("Cbr")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.cbrt(ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("Round")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.round(ops);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("2*\u03C0")) {
            double ops;
            ops = 2 * (3.1415926535897932384626433832795);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("x^3")) {
            double ops = Double.parseDouble(txtDisplay.getText());
            ops = Math.pow(ops, 3);
            txtDisplay.setText(String.valueOf(ops));

        } else if (button.getText().equals("Bin")) {
            int a = Integer.parseInt(txtDisplay.getText());
            txtDisplay.setText(Integer.toBinaryString(a));

        } else if (button.getText().equals("Hex")) {
            int a = Integer.parseInt(txtDisplay.getText());
            txtDisplay.setText(Integer.toHexString(a));

        } else if (button.getText().equals("Octal")) {
            int a = Integer.parseInt(txtDisplay.getText());
            txtDisplay.setText(Integer.toOctalString(a));
        }
    }
}
