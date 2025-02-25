package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends UI2 implements ActionListener {
    //setting 4:3 ratio:
    private final int widthWindow = 640;
    private final int heightWindow = 480;

    // Global opacity level for all components (0 = fully transparent, 255 = solid)
    private final int opacityLevel = 200;

    //declarations of objects
    private JTextField cardNumberField;
    private JPasswordField pinField;
    private JButton signInButton, clearButton, signUpButton;
    private ImageIcon logo;

    //Login page main???
    public LoginPage() {
        super(640, 480, "Asteroid Destroyer");

        // Create an ImageIcon with your logo (adjust the path to the image file)
        logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\allgood.jpg");
        addImage(logo, (widthWindow - 100) / 2, 20, 100, 100); // Logo at top center

        // Centered title
        addLabel("Welcome to the Bank!", "Times New Roman Bold", Font.PLAIN, 34,
                0, 130, true, false,
                0, 0, 0); // colorChange=false so these values are ignored (or you can use defaults)

        //input section :
        cardNumberField = addLabelWithTextField2(
                "Card Number:",
                "Times New Roman", Font.BOLD, 20,  // Label font
                70, 205,                           // Label position
                255, 255, 255,                     // Label text color: white
                220, 15,                           // labelWidth, spacing
                "Times New Roman", Font.BOLD, 16,  // Text field font
                250, 35,                           // Text field dimensions
                0, 0, 0,                          // Text field text color: black
                50, 50, 50,                       // Border color: dark gray
                245, 245, 245,                     // Background color: very light gray
                true,                              // Transparent flag
                opacityLevel,                      // Opacity level (e.g., 178 for 70%)
                -1                                 // textFieldX override (-1 means calculate default)
        );


        pinField = addLabelWithPasswordField2(
                "PIN:",
                "Times New Roman", Font.BOLD, 20,  // Label font
                70, 255,                           // Label position
                255, 255, 255,                     // Label text color: white
                220, 15,                           // labelWidth, spacing
                "Times New Roman", Font.BOLD, 16,  // Password field font
                250, 35,                           // Password field dimensions
                0, 0, 0,                          // Password field text color: black
                50, 50, 50,                       // Border color: dark gray
                245, 245, 245,                     // Background color: very light gray
                true,                              // Transparent flag
                opacityLevel - 1                   // Slightly lower opacity for PIN field if desired
        );

        //regex
        // Apply real-time validation
        applyInputFilter(cardNumberField, "^\\d{0,16}$", "The Card number must start with (9 or 6)\nand contain a 16 digits!", "^[69]\\d{0,15}$"); // 12-14 digits
        applyInputFilter(pinField, "^\\d{0,4}$", "The PIN is incomplete! \nIt should have 4 digits!", "^\\d{0,4}$"); // 4 digits

        //butttttoooonnnnsssss
        signInButton = addRoundedButton(
                "Sign In", "Times New Roman", Font.BOLD, 18,
                125, 300, 150, 40,
                false, true, opacityLevel,
                0, 0, 0,          // Base text color: black
                50, 50, 50,       // Base border color: dark gray
                245, 245, 245,    // Base background color: very light gray
                20                // Corner radius: 20
        );

        clearButton = addRoundedButton(
                "Clear", "Times New Roman", Font.BOLD, 18,
                300, 300, 150, 40,
                false, true, opacityLevel,
                0, 0, 0,          // Base text color: black
                50, 50, 50,       // Base border color: dark gray
                245, 245, 245,    // Base background color: very light gray
                20                // Corner radius: 20
        );


        signUpButton = addRoundedButton(
                "Sign Up", "Times New Roman", Font.BOLD, 18,
                ((640 - 120) / 2) - 20, 360, 120, 40,
                false, true, opacityLevel,
                0, 0, 0,          // Base text color: black
                50, 50, 50,       // Base border color: dark gray
                245, 245, 245,    // Base background color: very light gray
                20                // Corner radius: 20
        );

        //actionListener Nonsense
        clearButton.addActionListener(this);
        signInButton.addActionListener(this);
        signUpButton.addActionListener(this);

        //Centering the pop-up
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        //calculating the center position based on the screenWidth
        int sideToWindowSize = (screenWidth - 640) / 2;  // (screenWidth - windowWidth) / 2
        int topToWindow = (screenHeight - 480) / 2; // (screenHeight - windowHeight) / 2
        setLocation(sideToWindowSize, topToWindow);

        //putting the bg at last:
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
                new SignUp();
                setVisible(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
//below is old code
//
//package bank.management.system;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class LoginPage extends UI2 implements ActionListener {
//    //setting 4:3 ratio:
//    private final int widthWindow = 640;
//    private final int heightWindow = 480;
//
//    // Global opacity level for all components (0 = fully transparent, 255 = solid)
//    private final int opacityLevel = 200;
//
//    //declarations of objects
//    private JTextField cardNumberField;
//    private JPasswordField pinField;
//    private JButton signInButton, clearButton, signUpButton;
//    private ImageIcon logo;
//
//    //Login page main???
//    public LoginPage() {
//        super(640, 480, "Asteroid Destroyer");
//
//        // Create an ImageIcon with your logo (adjust the path to the image file)
//        logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\allgood.jpg");
//        addImage(logo, (widthWindow - 100) / 2, 20, 100, 100); // Logo at top center
//
//        // Centered title
//        addLabel("Welcome to the Bank!", "Times New Roman Bold", Font.PLAIN, 34, 0, 130, true, false, "");
//
//        //input section :
//        cardNumberField = addLabelWithTextField2("Card Number:", "Times New Roman", Font.BOLD, 20,
//                70, 205, true,"", 250, 35, 220, 15, true, opacityLevel, -1);
//        pinField = addLabelWithPasswordField2("PIN:", "Times New Roman", Font.BOLD, 20,
//                70, 255, true,"",250, 35, 220, 15, true, opacityLevel-1);
//
//        //regex
//        // Apply real-time validation
//        applyInputFilter(cardNumberField, "^\\d{0,16}$", "The Card number must start with (9 or 6)\nand contain a 16 digits!", "^[69]\\d{0,15}$"); // 12-14 digits
//        applyInputFilter(pinField, "^\\d{0,4}$", "The PIN is incomplete! \nIt should have 4 digits!", "^\\d{0,4}$"); // 4 digits
//
//        //butttttoooonnnnsssss
//        signInButton = addRoundedButton("Sign In", "Times New Roman", Font.BOLD, 18,
//                125, 300, 150, 40, false, true, opacityLevel);
//
//
//        clearButton = addRoundedButton("Clear", "Times New Roman", Font.BOLD, 18,
//                300, 300, 150, 40, false, true, opacityLevel);
//
//
//        signUpButton = addRoundedButton("Sign Up", "Times New Roman", Font.BOLD, 18,
//                ((640 - 120) / 2) - 20, 360, 120, 40, false, true, opacityLevel);
//
//        //actionListener Nonsense
//        clearButton.addActionListener(this);
//        signInButton.addActionListener(this);
//        signUpButton.addActionListener(this);
//
//        //Centering the pop-up
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int screenWidth = screenSize.width;
//        int screenHeight = screenSize.height;
//
//        //calculating the center position based on the screenWidth
//        int sideToWindowSize = (screenWidth - 640) / 2;  // (screenWidth - windowWidth) / 2
//        int topToWindow = (screenHeight - 480) / 2; // (screenHeight - windowHeight) / 2
//        setLocation(sideToWindowSize, topToWindow);
//
//        //putting the bg at last:
//        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\layer-170971.jpg"); // Replace with actual path
//        addImage(backgroundImage, 0, 0, widthWindow, heightWindow);
//
//        setVisible(true);
//    }
//
//    private boolean isClearing = false;
//
//    @Override
//    public void actionPerformed(ActionEvent b) {
//        try {
//            if (b.getSource() == signInButton) {
//                System.out.println("Sign-in Clicked");
//            } else if (b.getSource() == clearButton) {
//                cardNumberField.setText("");
//                pinField.setText("");
//            } else if (b.getSource() == signUpButton) {
//                new SignUp();
//                setVisible(false);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
//
