package bank.management.system.Final;

import bank.management.system.ChangePin;
import bank.management.system.ConnectionTrial;
import bank.management.system.TransactionMain;
import bank.management.system.UI2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class ChangePinFinal extends FunctionsAndUI implements ActionListener {
    private final int opacityLevel = 200;

    //Objects:
    private ImageIcon logo;
    JTextField newPinField,reNewPinField;
    private JButton changePinButton,BackButton;

    String cardNumber;

    ChangePinFinal(String cardNumber){
        super(1550,1080,"Main",false,-1,-1);
        this.cardNumber = cardNumber;
        addLabelWhichReturns("Change Your Pin", "Times New Roman Bold",
                Font.PLAIN, 24,
                430, 185, false, true,
                255, 255, 255,true);

        newPinField = addLabelWithPasswordField(
                "New PIN:",
                "Times New Roman", Font.BOLD, 18,  // Label font
                430, 230,                          // Label position
                255, 255, 255,                     // Label text color: white
                150, 15,                           // labelWidth, spacing
                "Times New Roman", Font.BOLD, 16,  // Password field font
                250, 35,                           // Password field dimensions
                0, 0, 0,                           // Password field text color: black
                0, 0, 0,                           // Border color
                135, 178, 247,                     // Background color
                5,                                // Arc for rounded corners (adjust as needed)
                false,                             // Transparent flag
                opacityLevel,                  // Slightly lower opacity for PIN field if desired
                -1                                 // textFieldX override (-1 means default placement)
        );
        applyInputFilter(newPinField, "^\\d{0,4}$", "The PIN is incomplete! \nIt should have 4 digits!", "^\\d{0,4}$"); // 4 digits

        //Re-Enter New Pin
        reNewPinField = addLabelWithPasswordField(
                "Re-Enter New Pin",
                "Times New Roman", Font.BOLD, 18,  // Label font
                430, 270,                          // Label position
                255, 255, 255,                     // Label text color: white
                150, 15,                            // Label width, spacing
                "Times New Roman", Font.BOLD, 16,  // Password field font
                250, 35,                            // Password field dimensions
                0, 0, 0,                            // Password field text color: black
                0, 0, 0,                            // Border color
                135, 178, 247,                      // Background color
                5,                                 // Corner radius (arc)
                false,                              // Transparent flag
                opacityLevel,-1           // Password field x position override
        );
        applyInputFilter(reNewPinField, "^\\d{0,4}$", "The PIN is incomplete! \nIt should have 4 digits!", "^\\d{0,4}$"); // 4 digits


        changePinButton = addRoundedButton(
                "Change", "Times New Roman", Font.BOLD, 18,
                700, 362, 150, 40,
                false, true, opacityLevel,
                0, 0, 0,          // Base text color: black
                50, 50, 50,       // Base border color: dark gray
                245, 245, 245,    // Base background color: very light gray
                10                // Corner radius: 20
        );
        BackButton = addRoundedButton(
                "Back", "Times New Roman", Font.BOLD, 18,
                700,406, 150, 40,
                false, true, opacityLevel,
                0, 0, 0,          // Base text color: black
                50, 50, 50,       // Base border color: dark gray
                245, 245, 245,    // Base background color: very light gray
                10                // Corner radius: 20
        );
        changePinButton.addActionListener(this);
        BackButton.addActionListener(this);

        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\atm2.png");
        addImage(backgroundImage, 0, 0, 1550, 830);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ChangePinFinal("");
    }


    @Override
    public void actionPerformed(ActionEvent b) {
        try{
            String pin1 = newPinField.getText();
            String pin2 = reNewPinField.getText();
            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not Match");
                return;
            }if(b.getSource()==changePinButton){
                if(newPinField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter new PIN");
                    return;
                }
                if(reNewPinField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Re Enter new PIN");
                    return;
                }
                ConnectionFinal con = new ConnectionFinal();
                String query1 = "UPDATE Login SET Pin = ? WHERE Card_Number = ?";
                String query3 = "UPDATE signUp3 SET Pin = ? WHERE Card_Number = ?"; // Only update Login and signUp3
                try (PreparedStatement pstmt1 = con.connection.prepareStatement(query1);
                     PreparedStatement pstmt3 = con.connection.prepareStatement(query3)) {
                    pstmt1.setString(1, pin1);
                    pstmt1.setString(2, cardNumber);
                    pstmt3.setString(1, pin1);
                    pstmt3.setString(2, cardNumber);
                    pstmt1.executeUpdate();
                    pstmt3.executeUpdate();
                }

                JOptionPane.showMessageDialog(null,"Pin changed Successfully");
                setVisible(false);
                new HomePage(cardNumber);
            }else if(b.getSource()==BackButton){
                new HomePage(cardNumber);
                setVisible(false);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
