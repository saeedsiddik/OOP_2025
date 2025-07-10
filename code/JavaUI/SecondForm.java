import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondForm {
    private JFrame frame;

    public SecondForm(String userName) {
        frame = new JFrame("Second Form");
        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcomeLabel = new JLabel("Welcome, " + userName + "!");
        welcomeLabel.setBounds(70, 70, 200, 25);
        frame.add(welcomeLabel);

        JButton backButton = new JButton("Back to First Form");
        backButton.setBounds(70, 120, 150, 30);
        frame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();       // Close this form
                new FirstForm();       // Go back to first form
            }
        });

        frame.setVisible(true);
    }
}
