import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class register extends JFrame {

    int REG;
    String NAME1, NAME2;
    public String NAME;
    public String reg;
    String PASSWORD;
    int state;

    JTextField regTextField;
    JPasswordField pwField;
    JButton logButton;

    public register() {
        setSize(200, 200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel regLabel = new JLabel("Enter Your RegNo ");
        add(regLabel);

        JLabel pwLabel = new JLabel("Enter Your Password ");
        add(pwLabel);

        regTextField = new JTextField();
        add(regTextField);

        pwField = new JPasswordField();
        add(pwField);

        regLabel.setBounds(30, 40, 120, 30);
        pwLabel.setBounds(30, 80, 120, 30);
        regTextField.setBounds(150, 40, 60, 20);
        pwField.setBounds(150, 80, 60, 20);

        logButton = new JButton("Login");
        add(logButton);
        logButton.setBounds(150, 120, 80, 30);

        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                login();
            }
        });
    }

    void login() {
        REG = Integer.parseInt(regTextField.getText());
        PASSWORD = new String(pwField.getPassword());

        try (Connection connection = DbConnector.connect1();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM student");
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {
                if (REG == result.getInt(3) && PASSWORD.equals(result.getString(4))) {
                    // Handle successful login
                    System.out.println("Login successful!");
                    state = 1;
                    NAME1 = result.getString(1);
                    NAME2 = result.getString(2);
                    reg=result.getString(3);
                    NAME=NAME1+" "+NAME2;

                    openDashboard();

                    return;
                }
            }

            // Handle unsuccessful login
            System.out.println("Invalid login credentials");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the connection in a final block

        }
    }

    private void openDashboard() {
        // Close the current window
        dispose();

        // Create and display the Dashboard

        new Dashboard(NAME,reg);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new register();
            }
        });
    }
}
