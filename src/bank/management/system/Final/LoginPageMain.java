package bank.management.system.Final;

import bank.management.system.ConnectionTrial;
import bank.management.system.SignUp;
import bank.management.system.TransactionMain;
import bank.management.system.UI2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

public class LoginPageMain extends FunctionsAndUI implements ActionListener{
        //setting 4:3 ratio:
        private final int widthWindow = 640;
        private final int heightWindow = 480;

        // Global opacity level for all components (0 = fully transparent, 255 = solid)
        private final int opacityLevel = 200;

        //declarations of objects
        private JTextField cardNumberField;
        private JPasswordField pinField;
        private JButton signInButton, clearButton, signUpButton;
        private ImageIcon logo,logo2;

        //error icon bullshit lets hope it works:
        private JLabel errorIcon;

        //Login page main???
        public LoginPageMain() {
            super(640, 480, "Asteroid Destroyer",true,-1,-1);

            //custom font:
            try {
                GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\xtra\\Last_Chance\\BMS\\Additionals\\moment.vintage.ttf")));
            }
            catch (IOException | FontFormatException e) {
                //Handle exception
                e.printStackTrace();
            }

            // Create an ImageIcon with the logo (to set them as referable path)
            logo = new ImageIcon("src/icons/coolCatS.png");
            addImage(logo, (widthWindow - 100) / 2-25, 10, 170, 170); // Logo at top center
            logo2 = new ImageIcon("src/icons/logo1.png");
            addImage(logo2, 540, 380, 100, 100); // Logo at top center

            // Centered title
            addLabelWhichReturns("Welcome to the Bank", "Moment Vintage", Font.PLAIN, 34,
                    0, 150, true, true,
                    0, 0, 0,true); // colorChange=false so these values are ignored (or you can use defaults)

            //input section :
            cardNumberField = addLabelWithTextField(
                    "Card Number:",
                    "Times New Roman", Font.BOLD, 20,  // Label font
                    70, 225,                           // Label position
                    0,0,0,                     // Label text color: white
                    220, 15,                           // labelWidth, spacing
                    "Times New Roman", Font.BOLD, 16,  // Text field font
                    250, 35,                           // Text field dimensions
                    0, 0, 0,                          // Text field text color: black
                    50, 50, 50,                       // Border color: dark gray
                    168, 144, 146,
                    10,                    // Background color: very light gray
                    false,                              // Transparent flag
                    100,                      // Opacity level (e.g., 178 for 70%)
                    -1                                 // textFieldX override (-1 means calculate default)
            );


            pinField = addLabelWithPasswordField(
                    "PIN:",
                    "Times New Roman", Font.BOLD, 20,  // Label font
                    70, 270,                           // Label position
                    0,0,0,                      // Label text color: white
                    220, 15,                           // labelWidth, spacing
                    "Times New Roman", Font.BOLD, 16,  // Password field font
                    250, 35,                           // Password field dimensions
                    0, 0, 0,                          // Password field text color: black
                    50, 50, 50,                       // Border color: dark gray
                    168, 144, 146,10,                     // Background color: very light gray
                    false,                              // Transparent flag
                    100 ,-1                  // Slightly lower opacity for PIN field if desired
            );

            //regex
            // Apply real-time validation
            applyInputFilter(cardNumberField, "^\\d{0,16}$", "The Card number must start with (9 or 6)\nand contain a 16 digits!", "^[69]\\d{0,15}$"); // 12-14 digits
            applyInputFilter(pinField, "^\\d{0,4}$", "The PIN is incomplete! \nIt should have 4 digits!", "^\\d{0,4}$"); // 4 digits

            //butttttoooonnnnsssss
            signInButton = addRoundedButton(
                    "Sign In", "Times New Roman", Font.BOLD, 18,
                    160, 330, 130, 40,
                    false, true, 230,
                    0, 0, 0,          // Base text color: black
                    50, 50, 50,       // Base border color: dark gray
                    161, 138, 140,    // Base background color: very light gray
                    20                // Corner radius: 20
            );

            clearButton = addRoundedButton(
                    "Clear", "Times New Roman", Font.BOLD, 18,
                    330, 330, 130, 40,
                    false, true, 230,
                    0, 0, 0,          // Base text color: black
                    35,35,35,       // Base border color: dark gray
                    161, 138, 140,    // Base background color: very light gray
                    20                // Corner radius: 20
            );


            signUpButton = addRoundedButton(
                    "Sign Up", "Times New Roman", Font.BOLD, 18,
                    ((640 - 120) / 2) , 390, 120, 40,
                    false, true, 230,
                    0,0,0,          // Base text color: black
                    50, 50, 50,       // Base border color: dark gray
                    161, 138, 140,    // Base background color: very light gray
                    20                // Corner radius: 20
            );

            //actionListener Nonsense
            clearButton.addActionListener(this);
            signInButton.addActionListener(this);
            signUpButton.addActionListener(this);


            //putting the bg at last:
            ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\layer-170971.jpg"); // Replace with actual path
            addImage(backgroundImage, 0, 0, widthWindow, heightWindow);

            setVisible(true);
        }

        //add the error/warning icon
        //after the project is done!!
        @Override
        public void actionPerformed(ActionEvent b) {
            try {
                if (b.getSource() == signInButton) {
                    String cardNumber = cardNumberField.getText();
                    String pinNumber = pinField.getText();
                    boolean isValid = (cardNumber.matches("\\d{16}")||pinNumber.matches("\\d{16}"));
                    if (!isValid) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Please fill the Values", "Incomplete Entries", JOptionPane.WARNING_MESSAGE);
                        errorIcon = showErrorIcon(isValid, "C:\\xtra\\Last_Chance\\BMS\\src\\icons\\error.png",  0, 385, 100, 100, errorIcon);
                        // Explicitly add to the content pane
                        getContentPane().add(errorIcon);
                        getContentPane().setComponentZOrder(errorIcon, 0);
                        getContentPane().revalidate();
                        getContentPane().repaint();
                    }else{
                            ConnectionFinal con1 = new ConnectionFinal();
                            String cardNum = cardNumberField.getText();
                            String pinPassword = pinField.getText();
                            System.out.println(pinPassword);
                            String query = "select * from Login where REPLACE(Card_Number, '-', '') = '"+cardNum+"' and Pin = '"+pinPassword+"'";
                            ResultSet resultSet = con1.statement.executeQuery(query);
                            if(resultSet.next()){
                                setVisible(false);
                                new HomePage(cardNum);
                            }else{
                                System.out.println("huh");
                                JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                            }

                    }
                }else if (b.getSource() == signUpButton) {
                    new SignUpPage1();
                    setVisible(false);
                }else if (b.getSource() == clearButton) {
                    //clear up lil bitch
                    cardNumberField.setText("");
                    pinField.setText("");
                    //clearing the error boxes:
                    // Reset to default borders by clearing any overlays
                    if (errorIcon != null) {
                        getContentPane().remove(errorIcon);
                        errorIcon = null;
                        getContentPane().revalidate();
                        getContentPane().repaint();
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {
        new LoginPageMain();
    }
}
