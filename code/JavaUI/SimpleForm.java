import javax.swing.*;

public class SimpleForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);  // absolute positioning

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 10, 80, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(100, 10, 160, 25);
        frame.add(userText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 40, 80, 25);
        frame.add(loginButton);

//        Event Handling
    //We are going to see how to handle button clicks:
    //addActionListener
    //Lambda syntax
    //JOptionPane

        loginButton.addActionListener(e -> {
            String username = userText.getText();
            JOptionPane.showMessageDialog(frame, "Hello " + username);
        });


//        Task: Change labels and button texts
//      Add a password field (JPasswordField)
//      Create a simple calculator (2 inputs, + button, and output label)

        frame.setVisible(true);

    }
}
