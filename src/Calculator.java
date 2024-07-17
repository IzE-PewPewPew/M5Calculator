import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subButton, mulButton, divButton, modButton, clearButton;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));
        add(new JLabel("First Number:"));
        firstNumberField = new JTextField();
        add(firstNumberField);
        add(new JLabel("Second Number:"));
        secondNumberField = new JTextField();
        add(secondNumberField);
        add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);
        addButton = new JButton("+");
        addButton.addActionListener(this);
        add(addButton);
        subButton = new JButton("-");
        subButton.addActionListener(this);
        add(subButton);
        mulButton = new JButton("*");
        mulButton.addActionListener(this);
        add(mulButton);
        divButton = new JButton("/");
        divButton.addActionListener(this);
        add(divButton);
        modButton = new JButton("%");
        modButton.addActionListener(this);
        add(modButton);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        add(clearButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subButton) {
                result = num1 - num2;
            } else if (e.getSource() == mulButton) {
                result = num1 * num2;
            } else if (e.getSource() == divButton) {
                result = num1 / num2;
            } else if (e.getSource() == modButton) {
                result = num1 % num2;
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
