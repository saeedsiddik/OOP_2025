import javax.swing.*;
import java.awt.event.*;

public class FirstForm {
    private JFrame frame;
    private JTextField nameField;

    public FirstForm() {
        frame = new JFrame("First Form");
        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setBounds(30, 30, 120, 25);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 30, 100, 25);
        frame.add(nameField);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(100, 80, 100, 30);
        frame.add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = nameField.getText();
                if (!userName.isEmpty()) {
                    frame.dispose(); // Close current form
                    new SecondForm(userName); // Pass name to next form
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter your name.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FirstForm(); // Launch the app
    }
}
