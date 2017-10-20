package com.kramator.main;

import com.kramator.listeners.ButtonListener;
import com.kramator.listeners.ButtonScientificListener;
import com.kramator.listeners.KeyListener;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScientificCalculator {

    private JFrame frmStandartCalculator;
    private JTextField txtDisplay;

    private JTextField converterField;
    private JTextField resultCnvrtField;
    private final int WBUTTON = 49;
    private static final int WSBUTTON = 65 ;
    private final int HBUTTON = 52;

    private double[] i = new double[5];

    private double US_Dollar = 1.35;
    private double Russian_Ruble = 77.68;
    private double Ukrainian_Grivnya = 35.51;
    private double Euro = 1.14;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ScientificCalculator window = new ScientificCalculator();
                    window.frmStandartCalculator.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ScientificCalculator() {
        initialize();
        createButtonCommon();
        createButtonScientific();
        createConverter();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmStandartCalculator = new JFrame();
        frmStandartCalculator.setAlwaysOnTop(true);
        frmStandartCalculator.setFocusable(true);
        frmStandartCalculator.setTitle("Standart Calculator");
        frmStandartCalculator.setBounds(100, 100, 300, 410);
        frmStandartCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frmStandartCalculator.setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mntmStandart = new JMenuItem("Standart");
        mntmStandart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                frmStandartCalculator.setTitle("Standart Calculator");
                frmStandartCalculator.setBounds(100, 100, 300, 410);
                txtDisplay.setBounds(10, 11, 264, 37);
            }
        });
        mnFile.add(mntmStandart);

        JMenuItem mntmScientific = new JMenuItem("Scientific");
        mntmScientific.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frmStandartCalculator.setTitle("Scientific Calculator");
                frmStandartCalculator.setBounds(100, 100, 610, 410);
                txtDisplay.setBounds(10, 11, 574, 37);
            }
        });
        mnFile.add(mntmScientific);

        JMenuItem mntmUnitConversion = new JMenuItem("Unit conversion");
        mntmUnitConversion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frmStandartCalculator.setTitle("Unit conversion");
                frmStandartCalculator.setBounds(100, 100, 900, 410);
                txtDisplay.setBounds(10, 11, 574, 37);
            }
        });
        mnFile.add(mntmUnitConversion);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        mnFile.add(mntmExit);
        frmStandartCalculator.getContentPane().setLayout(null);

        txtDisplay = new JTextField();
        txtDisplay.setFocusable(false);
        txtDisplay.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDisplay.setBounds(10, 11, 264, 37);
        frmStandartCalculator.getContentPane().add(txtDisplay);
        txtDisplay.setColumns(10);
    }

        private void createButtonCommon() {

            JButton btn = new ButtonCreater("\uF0E7", 10, 59, WBUTTON, HBUTTON, 10);
            addMyKeyListener(btn);
            addMyButtonListener(btn);
            frmStandartCalculator.getContentPane().add(btn);

            JButton btnC = new ButtonCreater("C", 118, 59, WBUTTON, HBUTTON, 15);
            addMyButtonListener(btnC);
            frmStandartCalculator.getContentPane().add(btnC);

            JButton btnPlusMinus = new ButtonCreater("\u00B1", 171, 59, WBUTTON, HBUTTON, 17);
            addMyButtonListener(btnPlusMinus);
            frmStandartCalculator.getContentPane().add(btnPlusMinus);

            JButton btnSqrt = new ButtonCreater("\u221A", 225, 59, WBUTTON, HBUTTON, 17);
            addMyButtonListener(btnSqrt);
            frmStandartCalculator.getContentPane().add(btnSqrt);

            JButton btn7 = new ButtonCreater("7", 10, 116, WBUTTON, HBUTTON, 20);
            addMyKeyListener(btn7);
            addMyButtonListener(btn7);
            frmStandartCalculator.getContentPane().add(btn7);

            JButton btn8 = new ButtonCreater("8", 64, 116, WBUTTON, HBUTTON, 20);
            addMyKeyListener(btn8);
            addMyButtonListener(btn8);
            frmStandartCalculator.getContentPane().add(btn8);

            JButton btn9 = new ButtonCreater("9", 118, 116, WBUTTON, HBUTTON, 20);
            addMyKeyListener(btn9);
            addMyButtonListener(btn9);
            frmStandartCalculator.getContentPane().add(btn9);

            JButton btnDivision = new ButtonCreater("/", 171, 116, WBUTTON, HBUTTON, 17);
            addMyKeyListener(btnDivision);
            addMyButtonListener(btnDivision);
            frmStandartCalculator.getContentPane().add(btnDivision);

            JButton btnPersent = new ButtonCreater("%", 225, 116, WBUTTON, HBUTTON, 15);
            addMyButtonListener(btnPersent);
            frmStandartCalculator.getContentPane().add(btnPersent);

            JButton btn4 = new ButtonCreater("4", 10, 173, WBUTTON, HBUTTON, 20);
            addMyKeyListener(btn4);
            addMyButtonListener(btn4);
            frmStandartCalculator.getContentPane().add(btn4);

            JButton btn5 = new ButtonCreater("5", 64, 173, WBUTTON, HBUTTON, 20);
            addMyKeyListener(btn5);
            addMyButtonListener(btn5);
            frmStandartCalculator.getContentPane().add(btn5);

            JButton btn6 = new ButtonCreater("6", 118, 173, WBUTTON, HBUTTON, 20);
            addMyKeyListener(btn6);
            addMyButtonListener(btn6);
            frmStandartCalculator.getContentPane().add(btn6);

            JButton btnMultiply = new ButtonCreater("*", 171, 173, WBUTTON, HBUTTON, 17);
            addMyKeyListener(btnMultiply);
            addMyButtonListener(btnMultiply);
            frmStandartCalculator.getContentPane().add(btnMultiply);

            JButton btnx = new ButtonCreater("1/x", 225, 173, WBUTTON, HBUTTON, 10);
            addMyButtonListener(btnx);
            frmStandartCalculator.getContentPane().add(btnx);

            JButton btn1 = new ButtonCreater("1", 10, 230, WBUTTON, HBUTTON, 20);
            addMyKeyListener(btn1);
            addMyButtonListener(btn1);
            frmStandartCalculator.getContentPane().add(btn1);

            JButton btn2 = new ButtonCreater("2", 64, 230, WBUTTON, HBUTTON, 20);
            addMyKeyListener(btn2);
            addMyButtonListener(btn2);
            frmStandartCalculator.getContentPane().add(btn2);

            JButton btn3 = new ButtonCreater("3", 118, 230, WBUTTON, HBUTTON, 20);
            addMyKeyListener(btn3);
            addMyButtonListener(btn3);
            frmStandartCalculator.getContentPane().add(btn3);

            JButton btnSubtract = new ButtonCreater("-", 171, 230, WBUTTON, HBUTTON, 17);
            addMyKeyListener(btnSubtract);
            addMyButtonListener(btnSubtract);
            frmStandartCalculator.getContentPane().add(btnSubtract);

            JButton btn0 = new ButtonCreater("0", 10, 287, 103, 52, 20);
            addMyKeyListener(btn0);
            addMyButtonListener(btn0);
            frmStandartCalculator.getContentPane().add(btn0);

            JButton button_21 = new ButtonCreater(".", 118, 287, WBUTTON, HBUTTON, 20);
            addMyKeyListener(button_21);
            addMyButtonListener(button_21);
            frmStandartCalculator.getContentPane().add(button_21);

            JButton btnAddition = new ButtonCreater("+", 171, 287, WBUTTON, HBUTTON, 17);
            addMyKeyListener(btnAddition);
            addMyButtonListener(btnAddition);
            frmStandartCalculator.getContentPane().add(btnAddition);

            JButton button_23 = new ButtonCreater("=", 225, 230, WBUTTON, 109, 17);
            addMyKeyListener(button_23);
            addMyButtonListener(button_23);
            frmStandartCalculator.getContentPane().add(button_23);

            JButton btnCe = new ButtonCreater("CE", 64, 59, WBUTTON, HBUTTON, 13);
            addMyButtonListener(btnCe);
            frmStandartCalculator.getContentPane().add(btnCe);
        }

        private void createButtonScientific() {

            JButton btnLog = new ButtonCreater("Log", 308, 59, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnLog);
            frmStandartCalculator.getContentPane().add(btnLog);

            JButton btnSin = new ButtonCreater("Sin", 378, 59, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnSin);
            frmStandartCalculator.getContentPane().add(btnSin);

            JButton btnSinh = new ButtonCreater("Sinh", 448, 59, WSBUTTON, HBUTTON, 13);
            addButtonScientificListener(btnSinh);
            frmStandartCalculator.getContentPane().add(btnSinh);

            JButton btnMod = new ButtonCreater("Mod", 518, 59, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnMod);
            frmStandartCalculator.getContentPane().add(btnMod);

            JButton btnPi = new ButtonCreater("\u03C0", 308, 116, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnPi);
            frmStandartCalculator.getContentPane().add(btnPi);

            JButton btnCos = new ButtonCreater("Cos", 378, 116, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnCos);
            frmStandartCalculator.getContentPane().add(btnCos);

            JButton btnCosh = new ButtonCreater("Cosh", 448, 116, WSBUTTON, HBUTTON, 13);
            addButtonScientificListener(btnCosh);
            frmStandartCalculator.getContentPane().add(btnCosh);

            JButton btnInx = new ButtonCreater("Inx", 518, 116, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnInx);
            frmStandartCalculator.getContentPane().add(btnInx);

            JButton btnXy = new ButtonCreater("x^y", 308, 173, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnXy);
            frmStandartCalculator.getContentPane().add(btnXy);

            JButton btnTan = new ButtonCreater("Tan", 378, 173, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnTan);
            frmStandartCalculator.getContentPane().add(btnTan);

            JButton btnTanh = new ButtonCreater("Tanh", 448, 173, WSBUTTON, HBUTTON, 13);
            addButtonScientificListener(btnTanh);
            frmStandartCalculator.getContentPane().add(btnTanh);

            JButton btnExp = new ButtonCreater("Exp", 518, 173, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnExp);
            frmStandartCalculator.getContentPane().add(btnExp);

            JButton btnX = new ButtonCreater("x^2", 308, 230, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnX);
            frmStandartCalculator.getContentPane().add(btnX);

            JButton btnCbr = new ButtonCreater("Cbr", 378, 230, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnCbr);
            frmStandartCalculator.getContentPane().add(btnCbr);

            JButton btnRund = new ButtonCreater("Round", 448, 230, WSBUTTON, HBUTTON, 11);
            addButtonScientificListener(btnRund);
            frmStandartCalculator.getContentPane().add(btnRund);

            JButton btnpi = new ButtonCreater("2*\u03C0", 518, 230, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnpi);
            frmStandartCalculator.getContentPane().add(btnpi);

            JButton btnX_1 = new ButtonCreater("x^3", 308, 287, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnX_1);
            frmStandartCalculator.getContentPane().add(btnX_1);

            JButton btnBin = new ButtonCreater("Bin", 378, 287, WSBUTTON, HBUTTON, 14);
            addButtonScientificListener(btnBin);
            frmStandartCalculator.getContentPane().add(btnBin);

            JButton btnHex = new ButtonCreater("Hex", 448, 287, WSBUTTON, HBUTTON, 13);
            addButtonScientificListener(btnHex);
            frmStandartCalculator.getContentPane().add(btnHex);

            JButton btnOctal = new ButtonCreater("Octal", 518, 287, WSBUTTON, HBUTTON, 11);
            addButtonScientificListener(btnOctal);
            frmStandartCalculator.getContentPane().add(btnOctal);
    }

        private void createConverter() {

            JLabel lblNewLabel = new JLabel("Currency Converter");
            lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
            lblNewLabel.setBounds(622, 11, 232, 37);
            frmStandartCalculator.getContentPane().add(lblNewLabel);

            JComboBox comboBox = new JComboBox();
            comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
            comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choose one", "Dollar USA", "Russian ruble", "Ukrainian grivnya", "Euro"}));
            comboBox.setBounds(622, 59, 242, 52);
            frmStandartCalculator.getContentPane().add(comboBox);

            converterField = new JTextField();
            converterField.setBounds(622, 152, 242, 49);
            frmStandartCalculator.getContentPane().add(converterField);
            converterField.setColumns(10);

            resultCnvrtField = new JTextField();
            resultCnvrtField.setColumns(10);
            resultCnvrtField.setBounds(622, 233, 242, 49);
            frmStandartCalculator.getContentPane().add(resultCnvrtField);

            JLabel lblNewLabel_1 = new JLabel("Amount");
            lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblNewLabel_1.setBounds(622, 122, 57, 19);
            frmStandartCalculator.getContentPane().add(lblNewLabel_1);

            JLabel lblResult = new JLabel("Result");
            lblResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblResult.setBounds(622, 212, 46, 14);
            frmStandartCalculator.getContentPane().add(lblResult);

            JButton btnConverter = new JButton("Convert");
            btnConverter.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    double British_Pound = Double.parseDouble(converterField.getText());
                    if (comboBox.getSelectedItem().equals("Dollar USA")) {
                        String cCconvert1 = String.format("USD %.2f", British_Pound * US_Dollar);
                        resultCnvrtField.setText(cCconvert1);
                    } else if (comboBox.getSelectedItem().equals("Russian ruble")) {
                        String cCconvert1 = String.format("RUB %.2f", British_Pound * Russian_Ruble);
                        resultCnvrtField.setText(cCconvert1);
                    } else if (comboBox.getSelectedItem().equals("Ukrainian grivnya")) {
                        String cCconvert1 = String.format("UAH %.2f", British_Pound * Ukrainian_Grivnya);
                        resultCnvrtField.setText(cCconvert1);
                    } else if (comboBox.getSelectedItem().equals("Euro")) {
                        String cCconvert1 = String.format("EUR %.2f", British_Pound * Euro);
                        resultCnvrtField.setText(cCconvert1);
                    } else {
                        resultCnvrtField.setText("Empty");
                    }
                }
            });
            btnConverter.setFont(new Font("Tahoma", Font.PLAIN, 16));
            btnConverter.setBounds(622, 306, 103, 33);
            frmStandartCalculator.getContentPane().add(btnConverter);

            JButton btnClear = new JButton("Clear");
            btnClear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    converterField.setText("");
                    resultCnvrtField.setText("");
                    comboBox.setSelectedItem("Choose one");
                }
            });
            btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
            btnClear.setBounds(761, 306, 103, 33);
            frmStandartCalculator.getContentPane().add(btnClear);
        }


    private void addMyButtonListener(JButton button) {
        ButtonListener buttonListener = new ButtonListener(txtDisplay);
        button.addActionListener(buttonListener);
    }

    private void addButtonScientificListener(JButton button) {
        ButtonScientificListener buttonScientificListener = new ButtonScientificListener(txtDisplay);
        button.addActionListener(buttonScientificListener);
    }

    private void addMyKeyListener(JButton button) {
        KeyListener keyListener = new KeyListener(txtDisplay);
        button.addKeyListener(keyListener);
    }
}
