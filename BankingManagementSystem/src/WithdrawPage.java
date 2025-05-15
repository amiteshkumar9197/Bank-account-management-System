import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawPage extends JFrame {
    private JTextField amountField;
    private JButton withdrawButton;
    private JLabel balanceLabel;
    private JLabel messageLabel;

    private double balance = 1000.00; // Initial balance for saving account

    public WithdrawPage() {
        setTitle("Banking Management System - Withdraw");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        balanceLabel = new JLabel("Current Balance: $" + balance);
        add(balanceLabel);
        add(new JLabel("")); // empty cell

        add(new JLabel("Withdraw Amount:"));
        amountField = new JTextField();
        add(amountField);

        messageLabel = new JLabel("");
        add(messageLabel);

        withdrawButton = new JButton("Withdraw");
        add(withdrawButton);

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (amount <= 0) {
                        messageLabel.setText("Enter a positive amount");
                        messageLabel.setForeground(Color.RED);
                    } else if (amount > balance) {
                        messageLabel.setText("Insufficient balance");
                        messageLabel.setForeground(Color.RED);
                    } else {
                        balance -= amount;
                        balanceLabel.setText("Current Balance: $" + balance);
                        messageLabel.setText("Withdrawal successful");
                        messageLabel.setForeground(Color.GREEN);
                    }
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Invalid amount");
                    messageLabel.setForeground(Color.RED);
                }
            }
        });
    }
}
