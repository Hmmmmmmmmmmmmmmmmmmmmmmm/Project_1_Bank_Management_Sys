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
    JTextField cardNumberField;
    JPasswordField pinField;
    JButton signInButton, clearButton, signUpButton;
    ImageIcon logo;

    //Login page main???
    public trialLoginPage(){
        super(640,480,"Asteroid Destroyer");

        // Create an ImageIcon with your logo (adjust the path to the image file)
        logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\bank.png");
        addImage(logo, (widthWindow - 100) / 2, 20, 100, 100); // Logo at top center
        // Centered title
        addLabel("Welcome to the Bank!", "Times New Roman Bold", Font.PLAIN, 34, 0, 130, true);
        cardNumberField = addLabelWithTextField2("Card Number:", "Times New Roman", Font.BOLD, 20, 70, 205, 250, 30, 220, 15);
        pinField = addLabelWithPasswordField2("PIN:", "Times New Roman", Font.BOLD, 20, 70, 245, 250, 30, 220, 15);

        //butttttoooonnnnsssss
        signInButton = addRoundedButton("Sign In", "Times New Roman", Font.BOLD, 18, 125, 300, 150, 40, false);
        signInButton.addActionListener((ActionListener) this);
        clearButton = addRoundedButton("Clear", "Times New Roman", Font.BOLD, 18, 300, 300, 150, 40, false);
        clearButton.addActionListener((ActionListener) this);
        signUpButton = addRoundedButton("Sign Up", "Times New Roman", Font.BOLD, 18, ((640 - 120) / 2)-20, 360, 120, 40, false);
        signUpButton.addActionListener((ActionListener) this);



        //Centering the pop-up
        //using another function to get the center of the screen
        //this uses the awt package
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        //calculating the center position based on the screenWidth
        int sideToWindowSize = (screenWidth - 640) / 2;  // (screenWidth - windowWidth) / 2
        int topToWindow = (screenHeight - 480) / 2; // (screenHeight - windowHeight) / 2
        setLocation(sideToWindowSize, topToWindow);

        //putting the bg at last:
        //trying to place this right:
        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\layer-170971.jpg"); // Replace with actual path
        addImage(backgroundImage,0,0, widthWindow, heightWindow);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent b) {
        try {
            if(b.getSource()==signInButton){
                System.out.println("Sign-in Clicked");
            } else if (b.getSource()==clearButton) {
                cardNumberField.setText("");
                pinField.setText("");
            }else if (b.getSource()==signUpButton){
                System.out.println("Sign-Up Clicked");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

