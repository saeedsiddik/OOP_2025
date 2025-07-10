import javax.swing.*;
import java.io.*;

public class RegistrationFormToFile {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration Form with File Save");
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 20, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 20, 250, 25);
        frame.add(nameLabel);
        frame.add(nameField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 60, 100, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 60, 250, 25);
        frame.add(emailLabel);
        frame.add(emailField);

        // Phone
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 100, 100, 25);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(150, 100, 250, 25);
        frame.add(phoneLabel);
        frame.add(phoneField);

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 140, 100, 25);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(150, 140, 70, 25);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(230, 140, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        frame.add(genderLabel);
        frame.add(male);
        frame.add(female);

        // Country
        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setBounds(30, 180, 100, 25);
        String[] countries = {"Select", "Bangladesh", "Nepal", "USA", "UK", "Canada"};
        JComboBox<String> countryBox = new JComboBox<>(countries);
        countryBox.setBounds(150, 180, 250, 25);
        frame.add(countryLabel);
        frame.add(countryBox);

        // DOB
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(30, 220, 150, 25);
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] years = new String[100];
        for (int i = 0; i < 100; i++) years[i] = String.valueOf(2025 - i);

        JComboBox<String> dayBox = new JComboBox<>(days);
        JComboBox<String> monthBox = new JComboBox<>(months);
        JComboBox<String> yearBox = new JComboBox<>(years);
        dayBox.setBounds(150, 220, 70, 25);
        monthBox.setBounds(210, 220, 70, 25);
        yearBox.setBounds(290, 220, 100, 25);
        frame.add(dobLabel);
        frame.add(dayBox);
        frame.add(monthBox);
        frame.add(yearBox);

        // File Upload
        JLabel fileLabel = new JLabel("Profile Photo:");
        fileLabel.setBounds(30, 260, 100, 25);
        JButton fileButton = new JButton("Choose File");
        fileButton.setBounds(150, 260, 120, 25);
        JLabel filePathLabel = new JLabel();
        filePathLabel.setBounds(280, 260, 180, 25);
        frame.add(fileLabel);
        frame.add(fileButton);
        frame.add(filePathLabel);

        final String[] selectedFilePath = {""};
        fileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                selectedFilePath[0] = file.getAbsolutePath();
                filePathLabel.setText(file.getName());
            }
        });

        // Register Button
        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(150, 320, 120, 30);
        frame.add(registerBtn);

        registerBtn.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = new String(phoneField.getText());
            String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "Not selected");
            String country = (String) countryBox.getSelectedItem();
            String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
            String photo = selectedFilePath[0].isEmpty() ? "Not uploaded" : selectedFilePath[0];

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || gender.equals("Not selected") || country.equals("Select")) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    FileWriter writer = new FileWriter("registration_data.txt", true); // true = append mode
                    writer.write("Name: " + name + "\n");
                    writer.write("Email: " + email + "\n");
                    writer.write("Phone: " + phone + "\n");
                    writer.write("Gender: " + gender + "\n");
                    writer.write("DOB: " + dob + "\n");
                    writer.write("Country: " + country + "\n");
                    writer.write("Profile Photo: " + photo + "\n");
                    writer.write("----------------------------------\n");
                    writer.close();

                    JOptionPane.showMessageDialog(frame, "Registration Saved Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Clear the form
                    nameField.setText("");
                    emailField.setText("");
                    phoneField.setText("");
                    genderGroup.clearSelection();
                    countryBox.setSelectedIndex(0);
                    dayBox.setSelectedIndex(0);
                    monthBox.setSelectedIndex(0);
                    yearBox.setSelectedIndex(0);
                    filePathLabel.setText("");
                    selectedFilePath[0] = "";
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error writing to file!", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        frame.setVisible(true);
    }
}
