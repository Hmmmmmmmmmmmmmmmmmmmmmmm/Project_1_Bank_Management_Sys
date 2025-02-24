package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class trialLoginPage extends UI implements ActionListener {
    //setting 4:3 ratio:
    private final int widthWindow = 640;
    private final int heightWindow = 480;
    //declarations of objects
    private JTextField cardNumberField;
    private JPasswordField pinField;
    private JButton signInButton, clearButton, signUpButton;
    private ImageIcon logo;

    //Login page main???
    public trialLoginPage() {
        super(640, 480, "Asteroid Destroyer");

        // Create an ImageIcon with your logo (adjust the path to the image file)
//        logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\bank.png");
        logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\allgood.jpg");
        addImage(logo, (widthWindow - 100) / 2, 20, 100, 100); // Logo at top center
        // Centered title
        addLabel("Welcome to the Bank!", "Times New Roman Bold", Font.PLAIN, 34, 0, 130, true, false, "");

        //input section :
//        cardNumberField = addLabelWithTextField2("Card Number:", "Times New Roman", Font.BOLD, 20, 70, 205, 250, 30, 220, 15);
        cardNumberField = addLabelWithTextField2("Card Number:", "Times New Roman", Font.BOLD, 20, 70, 205, 250, 35, 220, 235);
        pinField = addLabelWithPasswordField2("PIN:", "Times New Roman", Font.BOLD, 20, 70, 255, 250, 35, 220, 15);

        //regex
        // Apply real-time validation
        applyInputFilter(cardNumberField, "^\\d{0,16}$", "The Card number must start with (9 or 6)\nand contain a 16 digits!", "^[69]\\d{0,15}$"); // 12-14 digits
        applyInputFilter(pinField, "^\\d{0,4}$", "The PIN is incomplete! \nIt should have 4 digits!", "^\\d{0,4}$"); // 4 digits


        //butttttoooonnnnsssss
        signInButton = addRoundedButton("Sign In", "Times New Roman", Font.BOLD, 18, 125, 300, 150, 40, false);
        signInButton.addActionListener((ActionListener) this);
        clearButton = addRoundedButton("Clear", "Times New Roman", Font.BOLD, 18, 300, 300, 150, 40, false);
        clearButton.addActionListener((ActionListener) this);
        signUpButton = addRoundedButton("Sign Up", "Times New Roman", Font.BOLD, 18, ((640 - 120) / 2) - 20, 360, 120, 40, false);
        signUpButton.addActionListener((ActionListener) this);


        //Centering the pop-up
        //using another function to get the center of the screen
        //this uses the awt package
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        //temp info gathering
//        System.out.println("width: "+screenWidth);
//        System.out.println("height: "+screenHeight);
//        System.out.println("width window: "+widthWindow);
//        System.out.println("height window: "+heightWindow);

        //calculating the center position based on the screenWidth
        int sideToWindowSize = (screenWidth - 640) / 2;  // (screenWidth - windowWidth) / 2
        int topToWindow = (screenHeight - 480) / 2; // (screenHeight - windowHeight) / 2
        setLocation(sideToWindowSize, topToWindow);

        //putting the bg at last:
        //trying to place this right:
        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\layer-170971.jpg"); // Replace with actual path
        addImage(backgroundImage, 0, 0, widthWindow, heightWindow);

        setVisible(true);
    }

    private boolean isClearing = false;

    @Override
    public void actionPerformed(ActionEvent b) {
        try {
            if (b.getSource() == signInButton) {
                System.out.println("Sign-in Clicked");
            } else if (b.getSource() == clearButton) {
                cardNumberField.setText("");
                pinField.setText("");
            } else if (b.getSource() == signUpButton) {
                System.out.println("Sign-Up Clicked");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//    @Override
//    public void actionPerformed(ActionEvent b) {
//        try {
//            if(b.getSource()==signInButton){
//                System.out.println("Sign-in Clicked");
//            } else if (b.getSource()==clearButton) {
//                isClearing = true;
//
//                // Clear the fields
//                cardNumberField.setText("");  // Clears card number field
//                pinField.setText("");
//                isClearing = false;
//            }else if (b.getSource()==signUpButton){
//                System.out.println("Sign-Up Clicked");
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}

