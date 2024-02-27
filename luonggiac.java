import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LuongGiac extends JFrame {
    private JTextField angleField;
    private JTextArea resultArea;

    public LuongGiac() {
        setTitle("Máy Tính Lượng Giác");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel chứa các thành phần nhập và nút chức năng
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Nhãn và ô nhập độ
        JLabel angleLabel = new JLabel("Nhập độ:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(angleLabel, gbc);

        angleField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(angleField, gbc);

        // Nút chức năng
        String[] functionButtons = {"sin", "cos", "tan", "arcsin", "arccos", "arctan", "sinh", "cosh", "tanh"};
        int row = 1;
        int col = 0;

        for (String function : functionButtons) {
            JButton button = new JButton(function);
            button.addActionListener(e -> calculateTrigonometricFunction(function));
            gbc.gridx = col;
            gbc.gridy = row;
            inputPanel.add(button, gbc);

            col++;
            if (col > 2) {
                col = 0;
                row++;
            }
        }

        // Nút tính tất cả các đáp án
        JButton calculateAllButton = new JButton("Tất Cả Đáp Án");
        calculateAllButton.addActionListener(e -> tinhHamLuongGiac());
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 3;
        inputPanel.add(calculateAllButton, gbc);

        // Thêm Panel vào phía trên cửa sổ
        add(inputPanel, BorderLayout.NORTH);

        // Vùng hiển thị kết quả
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Phương thức tính một hàm lượng giác khi nút chức năng được nhấn
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

            // Hiển thị kết quả và đường gạch phân cách
            resultArea.append(function + "(" + angleDegree + "°) = " + result + "\n");
            resultArea.append("------------\n");
        } catch (NumberFormatException ex) {
            resultArea.setText("Vui lòng không để trống.");
        }
    }

    // Phương thức tính tất cả các hàm lượng giác
    private void tinhHamLuongGiac() {
        resultArea.setText(""); // Xóa nội dung cũ trước khi tính toán tất cả các hàm

        // Mảng chứa tên của tất cả các hàm lượng giác
        String[] functions = {"sin", "cos", "tan", "arcsin", "arccos", "arctan", "sinh", "cosh", "tanh"};
        for (String function : functions) {
            calculateTrigonometricFunction(function);
        }
    }

    // Phương thức chính để chạy ứng dụng
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LuongGiac calculator = new LuongGiac();
            calculator.setVisible(true);
        });
    }
}
