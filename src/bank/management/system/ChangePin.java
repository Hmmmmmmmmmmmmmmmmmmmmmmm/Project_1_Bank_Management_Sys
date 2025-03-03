package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePin extends UI2 implements ActionListener {
    private final int opacityLevel = 200;

    //Objects:
    private ImageIcon logo;
    JTextField newPinField,reNewPinField;
    private JButton changePinButton,BackButton;

    String pin;

    ChangePin(String pin){
        super(1550,1080,"Main",false);
        this.pin = pin;
        addLabel("Change Your Pin", "Times New Roman Bold",
                Font.PLAIN, 24,
                430, 185, false, true,
                255, 255, 255);

        newPinField = addLabelWithPasswordField3(
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
        reNewPinField = addLabelWithPasswordField3(
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
        new ChangePin("");
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
                ConnectionTrial con = new ConnectionTrial();
                String query1 = "update Login set PiN = '"+pin1+"' where PiN='"+pin+"'";
                String query2 = "update Deposit set Pin = '"+pin1+"' where Pin='"+pin+"'";
                String query3 = "update signUp3 set PiN = '"+pin1+"' where PiN='"+pin+"'";

                con.statement.executeUpdate(query1);
                con.statement.executeUpdate(query2);
                con.statement.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin changed Successfully");
                setVisible(false);
                new TransactionMain(pin);
            }else if(b.getSource()==BackButton){
                new TransactionMain(pin);
                setVisible(false);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
