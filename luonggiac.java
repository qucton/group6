import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class luonggiac extends JFrame {
    private JTextField angleField;
    private JTextArea resultArea;

    public luonggiac() {
        setTitle("Trigonometric Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel angleLabel = new JLabel("Enter angle in degrees:");
        inputPanel.add(angleLabel);

        angleField = new JTextField(10);
        inputPanel.add(angleField);

        JButton sinButton = new JButton("sin");
        sinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTrigonometricFunction("sin");
            }
        });
        inputPanel.add(sinButton);

        JButton cosButton = new JButton("cos");
        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTrigonometricFunction("cos");
            }
        });
        inputPanel.add(cosButton);

        JButton tanButton = new JButton("tan");
        tanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTrigonometricFunction("tan");
            }
        });
        inputPanel.add(tanButton);

        JButton arcsinButton = new JButton("arcsin");
        arcsinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTrigonometricFunction("arcsin");
            }
        });
        inputPanel.add(arcsinButton);

        JButton arccosButton = new JButton("arccos");
        arccosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTrigonometricFunction("arccos");
            }
        });
        inputPanel.add(arccosButton);

        JButton arctanButton = new JButton("arctan");
        arctanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTrigonometricFunction("arctan");
            }
        });
        inputPanel.add(arctanButton);   

        JButton sinhButton = new JButton("sinh");
        sinhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTrigonometricFunction("sinh");
            }
        });
        inputPanel.add(sinhButton);

        JButton coshButton = new JButton("cosh");
        coshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTrigonometricFunction("cosh");
            }
        });
        inputPanel.add(coshButton);

        JButton tanhButton = new JButton("tanh");
        tanhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTrigonometricFunction("tanh");
            }
        });
        inputPanel.add(tanhButton);

        JButton calculateAllButton = new JButton("Calculate All");
        calculateAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAllTrigonometricFunctions();
            }
        });
        inputPanel.add(calculateAllButton);

        add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void calculateTrigonometricFunction(String function) {
        try {
            double angleDegree = Double.parseDouble(angleField.getText());
            double angleRadian = Math.toRadians(angleDegree);
            double result = 0;

            switch (function) {
                case "sin":
                    result = Math.sin(angleRadian);
                    break;
                case "cos":
                    result = Math.cos(angleRadian);
                    break;
                case "tan":
                    result = Math.tan(angleRadian);
                    break;
                case "arcsin":
                    result = Math.asin(angleRadian);
                    break;
                case "arccos":
                    result = Math.acos(angleRadian);
                    break;
                case "arctan":
                    result = Math.atan(angleRadian);
                    break;
                case "sinh":
                    result = Math.sinh(angleRadian);
                    break;
                case "cosh":
                    result = Math.cosh(angleRadian);
                    break;
                case "tanh":
                    result = Math.tanh(angleRadian);
                    break;
            }

            resultArea.setText(function + "(" + angleDegree + "°) = " + result);
        } catch (NumberFormatException ex) {
            resultArea.setText("vui lòng nhập độ.");
        }
    }

    private void calculateAllTrigonometricFunctions() {
        calculateTrigonometricFunction("sin");
        calculateTrigonometricFunction("cos");
        calculateTrigonometricFunction("tan");
        calculateTrigonometricFunction("arcsin");
        calculateTrigonometricFunction("arccos");
        calculateTrigonometricFunction("arctan");
        calculateTrigonometricFunction("sinh");
        calculateTrigonometricFunction("cosh");
        calculateTrigonometricFunction("tanh");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                luonggiac calculator = new luonggiac();
                calculator.setVisible(true);
            }
        });
    }
}
