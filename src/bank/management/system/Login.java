

package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private final int widthWindow = 640;
    private final int heightWindow = 480;

    JTextField cardNumberField;
    JPasswordField pinField;
    JButton signInButton, clearButton, signUpButton;

    public Login() {
        setSize(widthWindow, heightWindow);
        setTitle("Asteroid Destroyer");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center window on screen
        setLocationRelativeTo(null);

        // Use getContentPane() instead of this
        JComponent contentPane = (JComponent) getContentPane();
        // FIXED: Use Container instead of JComponent
        contentPane.setLayout(null);


        // Set logo
        ImageIcon logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\bank.png");
        UIComponents.addImage(contentPane, logo, (widthWindow - 100) / 2, 20, 100, 100);
//
//        // Centered title
//        UIComponents.addLabel(contentPane, "Welcome to the Bank!", "Times New Roman", Font.BOLD, 34, 0, 130, true, 300);
//
//        // Input fields
//        cardNumberField = UIComponents.addLabelWithTextField(contentPane, "Card Number:", "Times New Roman", Font.BOLD, 20,
//                70, 205, 250, 30, 220, 15);
//        pinField = UIComponents.addLabelWithPasswordField(contentPane, "PIN:", "Times New Roman", Font.BOLD, 20,
//                70, 245, 250, 30, 220, 15);

        UIComponents.addLabel(contentPane,"Welcome to the Bank!", "Times New Roman Bold", Font.PLAIN, 34, 0, 130, true,800);
        //trial 5 (4 does the stand-alone heading)
// Left-aligned Username & Password labels
//        addLabel("Card Number:", "Times New Roman Bold", Font.BOLD, 20, 50, 205, false);
//        addLabel("PIN                 :", "Times New Roman Bold", Font.BOLD, 20, 50, 245, false);

        //stand-alone text field
//        JTextField  cn = new JTextField();
//        cn.setBounds(325,190,230,30);
//        setFont(new Font("Times New Roman",Font.BOLD,14));
//        add(cn);
        cardNumberField = UIComponents.addLabelWithTextField(contentPane,"Card Number:", "Times New Roman", Font.BOLD, 20, 70, 205, 250, 30, 220, 15);
        pinField = UIComponents.addLabelWithPasswordField(contentPane,"PIN:", "Times New Roman", Font.BOLD, 20, 70, 245, 250, 30, 220, 15);


        // Buttons
        signInButton = UIComponents.addRoundedButton(contentPane, "Sign In", "Times New Roman", Font.BOLD, 18,
                125, 300, 150, 40, false);
        signInButton.addActionListener(this);

        clearButton = UIComponents.addRoundedButton(contentPane, "Clear", "Times New Roman", Font.BOLD, 18,
                300, 300, 150, 40, false);
        clearButton.addActionListener(this);

        signUpButton = UIComponents.addRoundedButton(contentPane, "Sign Up", "Times New Roman", Font.BOLD, 18,
                ((widthWindow - 120) / 2) - 20, 360, 120, 40, false);
        signUpButton.addActionListener(this);

        // Background
        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\layer-170971.jpg"); // Replace with actual path
        UIComponents.addImage(contentPane, backgroundImage, 0, 0, widthWindow, heightWindow);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            cardNumberField.setText("");
            pinField.setText("");
        } else if (e.getSource() == signInButton) {
            String cardNumber = cardNumberField.getText();
            String pin = new String(pinField.getPassword());
            JOptionPane.showMessageDialog(this, "Card: " + cardNumber + "\nPIN: " + pin);
        } else if (e.getSource() == signUpButton) {
            JOptionPane.showMessageDialog(this, "Sign Up clicked!");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}