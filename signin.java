package FirstWindowpackage;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signin {

    private JFrame frame;
    private JTextField firstNameField;
    private JTextField userNameField;
    private JTextField lastNameField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                signin window = new signin();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public signin() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 706, 496);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel title = new JLabel("Sign In!");
        title.setFont(new Font("Tahoma", Font.BOLD, 14));
        title.setBounds(320, 20, 100, 20);
        frame.getContentPane().add(title);

        // First Name
        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblFirstName.setBounds(186, 54, 87, 14);
        frame.getContentPane().add(lblFirstName);

        firstNameField = new JTextField();
        firstNameField.setBounds(106, 79, 216, 27);
        frame.getContentPane().add(firstNameField);

        // Username
        JLabel lblUsername = new JLabel("User Name");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblUsername.setBounds(186, 129, 87, 14);
        frame.getContentPane().add(lblUsername);

        userNameField = new JTextField();
        userNameField.setBounds(106, 149, 216, 27);
        frame.getContentPane().add(userNameField);

        // Last Name
        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblLastName.setBounds(427, 54, 87, 14);
        frame.getContentPane().add(lblLastName);

        lastNameField = new JTextField();
        lastNameField.setBounds(354, 79, 216, 27);
        frame.getContentPane().add(lastNameField);

        // Password
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPassword.setBounds(427, 129, 87, 14);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(354, 149, 216, 27);
        frame.getContentPane().add(passwordField);

        // Sex
        JLabel lblSex = new JLabel("Sex");
        lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblSex.setBounds(126, 203, 87, 14);
        frame.getContentPane().add(lblSex);

        JRadioButton maleBtn = new JRadioButton("Male");
        maleBtn.setBounds(103, 220, 75, 23);
        frame.getContentPane().add(maleBtn);

        JRadioButton femaleBtn = new JRadioButton("Female");
        femaleBtn.setBounds(186, 220, 75, 23);
        frame.getContentPane().add(femaleBtn);

        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(maleBtn);
        sexGroup.add(femaleBtn);

        // Age ComboBox
        JLabel lblAge = new JLabel("Age");
        lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblAge.setBounds(354, 203, 46, 14);
        frame.getContentPane().add(lblAge);

        JComboBox<String> ageCombo = new JComboBox<>();
        ageCombo.setModel(new DefaultComboBoxModel<>(new String[]{
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
        }));
        ageCombo.setBounds(354, 220, 216, 22);
        frame.getContentPane().add(ageCombo);

        // Subscription
        JLabel lblSubscription = new JLabel("Subscription");
        lblSubscription.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblSubscription.setBounds(106, 267, 87, 14);
        frame.getContentPane().add(lblSubscription);

        JRadioButton freeBtn = new JRadioButton("Free");
        freeBtn.setBounds(103, 288, 75, 23);
        frame.getContentPane().add(freeBtn);

        JRadioButton premiumBtn = new JRadioButton("Premium");
        premiumBtn.setBounds(186, 288, 87, 23);
        frame.getContentPane().add(premiumBtn);

        ButtonGroup subscriptionGroup = new ButtonGroup();
        subscriptionGroup.add(freeBtn);
        subscriptionGroup.add(premiumBtn);

        // Output text area
        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(51, 327, 593, 119);
        frame.getContentPane().add(outputArea);

        // Button: Sign In
        JButton signInBtn = new JButton("Sign In");
        signInBtn.setBounds(354, 288, 89, 23);
        frame.getContentPane().add(signInBtn);

        signInBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String sex = maleBtn.isSelected() ? "Male" :
                             femaleBtn.isSelected() ? "Female" : "Not selected";

                String subscription = freeBtn.isSelected() ? "Free" :
                                      premiumBtn.isSelected() ? "Premium" : "Not selected";

                outputArea.setText(
                        "Sign In Details:\n" +
                        "First Name: " + firstNameField.getText() + "\n" +
                        "Last Name: " + lastNameField.getText() + "\n" +
                        "Username: " + userNameField.getText() + "\n" +
                        "Age: " + ageCombo.getSelectedItem() + "\n" +
                        "Sex: " + sex + "\n" +
                        "Subscription: " + subscription
                );
            }
        });
    }
}
