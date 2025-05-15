import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    public LoginPage() {
        setTitle("Banking Management System - Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        messageLabel = new JLabel("");
        add(messageLabel);

        loginButton = new JButton("Login");
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Simple hardcoded authentication for demonstration
                if ("user".equals(username) && "password".equals(password)) {
                    dispose();
                    WithdrawPage withdrawPage = new WithdrawPage();
                    withdrawPage.setVisible(true);
                } else {
                    messageLabel.setText("Invalid username or password");
                    messageLabel.setForeground(Color.RED);
                }
            }
        });
    }
}
