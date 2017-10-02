import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//1import java.awt.event.KeyEvent;

public class ScientificCalculator {

    private JFrame frmStandartCalculator;
    private JTextField txtDisplay;

    private double firstNum;
    private double secondNum;
    private double result;
    private String operations;
    private String answer;
    private JTextField converterField;
    private JTextField resultCnvrtField;

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
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmStandartCalculator = new JFrame();
        frmStandartCalculator.setAlwaysOnTop(true);
        frmStandartCalculator.setTitle("Standart Calculator");
        frmStandartCalculator.setBounds(100, 100, 900, 410);
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
                txtDisplay.setBounds(10, 11, 583, 37);
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
        txtDisplay.setRequestFocusEnabled(false);
        txtDisplay.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDisplay.setBounds(10, 11, 264, 37);
        frmStandartCalculator.getContentPane().add(txtDisplay);
        txtDisplay.setColumns(10);

        JButton btn = new JButton("\uF0E7");
        btn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    String backspace = null;

                    if (txtDisplay.getText().length() > 0) {
                        StringBuilder sb = new StringBuilder(txtDisplay.getText());
                        sb.deleteCharAt(txtDisplay.getText().length() - 1);
                        backspace = sb.toString();
                        txtDisplay.setText(backspace);
                    }
                }
            }
        });
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String backspace = null;

                if (txtDisplay.getText().length() > 0) {
                    StringBuilder sb = new StringBuilder(txtDisplay.getText());
                    sb.deleteCharAt(txtDisplay.getText().length() - 1);
                    backspace = sb.toString();
                    txtDisplay.setText(backspace);
                }
            }
        });
        btn.setBounds(10, 59, 49, 52);
        frmStandartCalculator.getContentPane().add(btn);

        JButton btnC = new JButton("C");
        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                txtDisplay.setText("0");
            }
        });
        btnC.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnC.setBounds(118, 59, 49, 52);
        frmStandartCalculator.getContentPane().add(btnC);

        JButton btnPlusMinus = new JButton("\u00B1");
        btnPlusMinus.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = ops * (-1);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnPlusMinus.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnPlusMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = ops * (-1);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnPlusMinus.setBounds(171, 59, 49, 52);
        frmStandartCalculator.getContentPane().add(btnPlusMinus);

        JButton btnSqrt = new JButton("\u221A");
        btnSqrt.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnSqrt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.sqrt(ops);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnSqrt.setBounds(225, 59, 49, 52);
        frmStandartCalculator.getContentPane().add(btnSqrt);

        JButton btn7 = new JButton("7");
        btn7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                String iNum = txtDisplay.getText() + btn7.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String iNum = txtDisplay.getText() + btn7.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn7.setBounds(10, 116, 49, 52);
        frmStandartCalculator.getContentPane().add(btn7);

        JButton btn8 = new JButton("8");
        btn8.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                String iNum = txtDisplay.getText() + btn8.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String iNum = txtDisplay.getText() + btn8.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn8.setBounds(64, 116, 49, 52);
        frmStandartCalculator.getContentPane().add(btn8);

        JButton btn9 = new JButton("9");
        btn9.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                String iNum = txtDisplay.getText() + btn9.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String iNum = txtDisplay.getText() + btn9.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn9.setBounds(118, 116, 49, 52);
        frmStandartCalculator.getContentPane().add(btn9);

        JButton btnDivision = new JButton("/");
        btnDivision.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_DIVIDE) {
                    firstNum = Double.parseDouble(txtDisplay.getText());
                    txtDisplay.setText("");
                    operations = "/";
                }
            }
        });
        btnDivision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                firstNum = Double.parseDouble(txtDisplay.getText());
                txtDisplay.setText("");
                operations = "/";
            }
        });
        btnDivision.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnDivision.setBounds(171, 116, 49, 52);
        frmStandartCalculator.getContentPane().add(btnDivision);

        JButton btnPersent = new JButton("%");
        btnPersent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                firstNum = Double.parseDouble(txtDisplay.getText());
                txtDisplay.setText("");
                operations = "%";
            }
        });
        btnPersent.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPersent.setBounds(225, 116, 49, 52);
        frmStandartCalculator.getContentPane().add(btnPersent);

        JButton btn4 = new JButton("4");
        btn4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                String iNum = txtDisplay.getText() + btn4.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String iNum = txtDisplay.getText() + btn4.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn4.setBounds(10, 173, 49, 52);
        frmStandartCalculator.getContentPane().add(btn4);

        JButton btn5 = new JButton("5");
        btn5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                String iNum = txtDisplay.getText() + btn5.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String iNum = txtDisplay.getText() + btn5.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn5.setBounds(64, 173, 49, 52);
        frmStandartCalculator.getContentPane().add(btn5);

        JButton btn6 = new JButton("6");
        btn6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                String iNum = txtDisplay.getText() + btn6.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String iNum = txtDisplay.getText() + btn6.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn6.setBounds(118, 173, 49, 52);
        frmStandartCalculator.getContentPane().add(btn6);

        JButton btnMultiply = new JButton("*");
        btnMultiply.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
                    firstNum = Double.parseDouble(txtDisplay.getText());
                    txtDisplay.setText("");
                    operations = "*";
                }
            }
        });
        btnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                firstNum = Double.parseDouble(txtDisplay.getText());
                txtDisplay.setText("");
                operations = "*";
            }
        });
        btnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnMultiply.setBounds(171, 173, 49, 52);
        frmStandartCalculator.getContentPane().add(btnMultiply);

        JButton btnx = new JButton("1/x");
        btnx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                if (ops != 0) {
                    txtDisplay.setText(String.valueOf(1 / ops));
                } else {
                    txtDisplay.setText("Сan not be divided into 0");
                }
            }
        });
        btnx.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnx.setBounds(225, 173, 49, 52);
        frmStandartCalculator.getContentPane().add(btnx);

        JButton btn1 = new JButton("1");
        btn1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                String iNum = txtDisplay.getText() + btn1.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String iNum = txtDisplay.getText() + btn1.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn1.setBounds(10, 230, 49, 52);
        frmStandartCalculator.getContentPane().add(btn1);

        JButton btn2 = new JButton("2");
        btn2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                String iNum = txtDisplay.getText() + btn2.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String iNum = txtDisplay.getText() + btn2.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn2.setBounds(64, 230, 49, 52);
        frmStandartCalculator.getContentPane().add(btn2);

        JButton btn3 = new JButton("3");
        btn3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                String iNum = txtDisplay.getText() + btn3.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String iNum = txtDisplay.getText() + btn3.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn3.setBounds(118, 230, 49, 52);
        frmStandartCalculator.getContentPane().add(btn3);

        JButton btnSubtract = new JButton("-");
        btnSubtract.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
                    firstNum = Double.parseDouble(txtDisplay.getText());
                    txtDisplay.setText("");
                    operations = "-";
                }
            }
        });
        btnSubtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                firstNum = Double.parseDouble(txtDisplay.getText());
                txtDisplay.setText("");
                operations = "-";
            }
        });
        btnSubtract.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnSubtract.setBounds(171, 230, 49, 52);
        frmStandartCalculator.getContentPane().add(btnSubtract);

        JButton btn0 = new JButton("0");
        btn0.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent arg0) {

                String iNum = txtDisplay.getText() + btn0.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String iNum = txtDisplay.getText() + btn0.getText();
                txtDisplay.setText(iNum);
            }
        });
        btn0.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn0.setBounds(10, 287, 103, 52);
        frmStandartCalculator.getContentPane().add(btn0);

        JButton button_21 = new JButton(".");
        button_21.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                String str = txtDisplay.getText();
                String strResult = null;
                if (!str.contains(".")) {
                    strResult = str + ".";
                } else {
                    txtDisplay.setText(str);
                }
                txtDisplay.setText(strResult);
            }
        });
        button_21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String str = txtDisplay.getText();
                String strResult = null;
                if (!str.contains(".")) {
                    strResult = str + ".";
                } else {
                    txtDisplay.setText(str);
                }
                txtDisplay.setText(strResult);
            }
        });
        button_21.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button_21.setBounds(118, 287, 49, 52);
        frmStandartCalculator.getContentPane().add(button_21);

        JButton btnAddition = new JButton("+");
        btnAddition.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_PLUS) {
                    firstNum = Double.parseDouble(txtDisplay.getText());
                    txtDisplay.setText("");
                    operations = "+";
                }
            }
        });
        btnAddition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                firstNum = Double.parseDouble(txtDisplay.getText());
                txtDisplay.setText("");
                operations = "+";
            }
        });
        btnAddition.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnAddition.setBounds(171, 287, 49, 52);
        frmStandartCalculator.getContentPane().add(btnAddition);

        JButton button_23 = new JButton("=");
        button_23.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    secondNum = Double.parseDouble(txtDisplay.getText());
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
                        result = firstNum / secondNum;
                        answer = String.format("%.2f", result);
                        txtDisplay.setText(answer);
                    }
                }
            }
        });
        button_23.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                secondNum = Double.parseDouble(txtDisplay.getText());
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
                    result = firstNum / secondNum;
                    answer = String.format("%.2f", result);
                    txtDisplay.setText(answer);
                }

            }
        });
        button_23.setFont(new Font("Tahoma", Font.PLAIN, 17));
        button_23.setBounds(225, 230, 49, 109);
        frmStandartCalculator.getContentPane().add(button_23);

        JButton btnCe = new JButton("CE");
        btnCe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                txtDisplay.setText("");
            }
        });
        btnCe.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCe.setBounds(64, 59, 49, 52);
        frmStandartCalculator.getContentPane().add(btnCe);

        JButton btnLog = new JButton("Log");
        btnLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.log(ops);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnLog.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnLog.setBounds(308, 59, 65, 52);
        frmStandartCalculator.getContentPane().add(btnLog);

        JButton btnSin = new JButton("Sin");
        btnSin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.sin(ops);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnSin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnSin.setBounds(378, 59, 65, 52);
        frmStandartCalculator.getContentPane().add(btnSin);

        JButton btnSinh = new JButton("Sinh");
        btnSinh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.sinh(ops);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnSinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnSinh.setBounds(448, 59, 65, 52);
        frmStandartCalculator.getContentPane().add(btnSinh);

        JButton btnMod = new JButton("Mod");
        btnMod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                firstNum = Double.parseDouble(txtDisplay.getText());
                txtDisplay.setText("");
                operations = "Mod";
            }
        });
        btnMod.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnMod.setBounds(518, 59, 65, 52);
        frmStandartCalculator.getContentPane().add(btnMod);

        JButton btnPi = new JButton("\u03C0");
        btnPi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                txtDisplay.setText(String.valueOf(3.1415926535897932384626433832795));
            }
        });
        btnPi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnPi.setBounds(308, 116, 65, 52);
        frmStandartCalculator.getContentPane().add(btnPi);

        JButton btnCos = new JButton("Cos");
        btnCos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.cos(ops);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnCos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCos.setBounds(378, 116, 65, 52);
        frmStandartCalculator.getContentPane().add(btnCos);

        JButton btnCosh = new JButton("Cosh");
        btnCosh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.cosh(ops);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnCosh.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCosh.setBounds(448, 116, 65, 52);
        frmStandartCalculator.getContentPane().add(btnCosh);

        JButton btnInx = new JButton("Inx");
        btnInx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.log10(ops);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnInx.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnInx.setBounds(518, 116, 65, 52);
        frmStandartCalculator.getContentPane().add(btnInx);

        JButton btnXy = new JButton("x^y");
        btnXy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.pow(ops, ops);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnXy.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnXy.setBounds(308, 173, 65, 52);
        frmStandartCalculator.getContentPane().add(btnXy);

        JButton btnTan = new JButton("Tan");
        btnTan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.tan(ops);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnTan.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnTan.setBounds(378, 173, 65, 52);
        frmStandartCalculator.getContentPane().add(btnTan);

        JButton btnTanh = new JButton("Tanh");
        btnTanh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.tanh(ops);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnTanh.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnTanh.setBounds(448, 173, 65, 52);
        frmStandartCalculator.getContentPane().add(btnTanh);

        JButton btnExp = new JButton("Exp");
        btnExp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                firstNum = Double.parseDouble(txtDisplay.getText());
                txtDisplay.setText("");
                operations = "Exp";
            }
        });
        btnExp.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnExp.setBounds(518, 173, 65, 52);
        frmStandartCalculator.getContentPane().add(btnExp);

        JButton btnX = new JButton("x^2");
        btnX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.pow(ops, 2);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnX.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnX.setBounds(308, 230, 65, 52);
        frmStandartCalculator.getContentPane().add(btnX);

        JButton btnCbr = new JButton("Cbr");
        btnCbr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.cbrt(ops);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnCbr.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCbr.setBounds(378, 230, 65, 52);
        frmStandartCalculator.getContentPane().add(btnCbr);

        JButton btnRund = new JButton("Round");
        btnRund.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.round(ops);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnRund.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnRund.setBounds(448, 230, 65, 52);
        frmStandartCalculator.getContentPane().add(btnRund);

        JButton btnpi = new JButton("2*\u03C0");
        btnpi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops;
                ops = 2 * (3.1415926535897932384626433832795);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnpi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnpi.setBounds(518, 230, 65, 52);
        frmStandartCalculator.getContentPane().add(btnpi);

        JButton btnX_1 = new JButton("x^3");
        btnX_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double ops = Double.parseDouble(txtDisplay.getText());
                ops = Math.pow(ops, 3);
                txtDisplay.setText(String.valueOf(ops));
            }
        });
        btnX_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnX_1.setBounds(308, 287, 65, 52);
        frmStandartCalculator.getContentPane().add(btnX_1);

        JButton btnBin = new JButton("Bin");
        btnBin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int a = Integer.parseInt(txtDisplay.getText());
                txtDisplay.setText(Integer.toBinaryString(a));
            }
        });
        btnBin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBin.setBounds(378, 287, 65, 52);
        frmStandartCalculator.getContentPane().add(btnBin);

        JButton btnHex = new JButton("Hex");
        btnHex.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int a = Integer.parseInt(txtDisplay.getText());
                txtDisplay.setText(Integer.toHexString(a));
            }
        });
        btnHex.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnHex.setBounds(448, 287, 65, 52);
        frmStandartCalculator.getContentPane().add(btnHex);

        JButton btnOctal = new JButton("Octal");
        btnOctal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int a = Integer.parseInt(txtDisplay.getText());
                txtDisplay.setText(Integer.toOctalString(a));
            }
        });
        btnOctal.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnOctal.setBounds(518, 287, 65, 52);
        frmStandartCalculator.getContentPane().add(btnOctal);

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
}
