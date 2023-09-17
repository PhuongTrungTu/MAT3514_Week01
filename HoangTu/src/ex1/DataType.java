package ex1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is another version of exercise number 1. It will allow the user to input
 * data and then check what data type the input is.
 * 
 * @author Grizmo - Hoang Tuan Tu
 * @version 1.0
 */
public class DataType {
    private final JTextField inputField;
    private final JLabel resultLabel;

    public DataType() {
        JFrame frame = new JFrame("Data Type");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel inputLabel = new JLabel("Input Data:");
        inputField = new JTextField(20);
        JButton checkButton = new JButton("Check Data Type");
        resultLabel = new JLabel();

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputData = inputField.getText();
                try {
                    // Thử chuyển đổi dữ liệu nhập thành kiểu Integer
                    Integer.parseInt(inputData);
                    resultLabel.setText("Data Type: Integer");
                } catch (NumberFormatException ex) {
                    try {
                        // Thử chuyển đổi dữ liệu nhập thành kiểu Double
                        Double.parseDouble(inputData);
                        resultLabel.setText("Data Type: Double");
                    } catch (NumberFormatException ex2) {
                        // Nếu không thể chuyển đổi thành số, coi đó là kiểu String
                        resultLabel.setText("Data Type: String");
                    }
                }
            }
        });

        frame.add(inputLabel);
        frame.add(inputField);
        frame.add(checkButton);
        frame.add(resultLabel);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DataType();
            }
        });
    }
}
