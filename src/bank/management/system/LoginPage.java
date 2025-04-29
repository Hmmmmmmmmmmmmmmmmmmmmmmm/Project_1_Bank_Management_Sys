package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Arrays;

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
    private ImageIcon logo, logo2;

    //error icon bullshit lets hope it works:
    private JLabel errorIcon=null;

    //Login page main???
    public LoginPage() {
        super(640, 480, "Asteroid Destroyer",true);

        //custom font:
        try {
            GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\xtra\\Last_Chance\\BMS\\Additionals\\moment.vintage.ttf")));
        } catch (IOException | FontFormatException e) {
            //Handle exception
            e.printStackTrace();
        }

        // Create an ImageIcon with your logo (adjust the path to the image file)
        logo = new ImageIcon("src/icons/coolCatS.png");
        addImage(logo, (widthWindow - 100) / 2-25, 10, 170, 170); // Logo at top center
        logo2 = new ImageIcon("src/icons/logo1.png");
        addImage(logo2, 540, 380, 100, 100); // Logo at top center

        // Centered title
        addLabel("Welcome to the Bank", "Moment Vintage", Font.PLAIN, 34,
                0, 150, true, true,
                255,255,255); // colorChange=false so these values are ignored (or you can use defaults)

        //input section :
        cardNumberField = addLabelWithTextField2(
                "Card Number:",
                "Times New Roman", Font.BOLD, 20,  // Label font
                70, 225,                           // Label position
                255,255,255,                     // Label text color: white
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


        pinField = addLabelWithPasswordField3(
                "PIN:",
                "Times New Roman", Font.BOLD, 20,  // Label font
                70, 270,                           // Label position
                255,255,255,                      // Label text color: white
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
        //old validation constant popups
        applyInputFilter(cardNumberField, "^\\d{0,16}$", "The Card number must start with (9 or 6)\nand contain a 16 digits!", "^[69]\\d{0,15}$"); // 12-14 digits
        applyInputFilter(pinField, "^\\d{0,4}$", "The PIN is incomplete! \nIt should have 4 digits!", "^\\d{0,4}$"); // 4 digits
        //new:
//        applyInputFilter(
//                cardNumberField,
//                "^\\d{0,16}$",
//                "The Card number must start with (9 or 6) and contain 16 digits!",
//                "^[69]\\d{15}$",
//                Color.RED,
//                2,
//                true
//        );
//
//        applyInputFilter(
//                pinField,
//                "^\\d{0,4}$",
//                "The PIN is incomplete! It should have 4 digits!",
//                "^\\d{4}$",
//                Color.RED,
//                2,
//                true
//        );
        //we say fk this we do it the hard way in the action listener

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
//                ((640 - 120) / 2) - 20, 390, 120, 40,
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

        //Centering the pop-up
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int screenWidth = screenSize.width;
//        int screenHeight = screenSize.height;
//
//        //calculating the center position based on the screenWidth
//        int sideToWindowSize = (screenWidth - 640) / 2;  // (screenWidth - windowWidth) / 2
//        int topToWindow = (screenHeight - 480) / 2; // (screenHeight - windowHeight) / 2
//        setLocation(sideToWindowSize, topToWindow);

        //temp pos t1: above bg
        // Initialize the shared error icon

//        ImageIcon icon = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\warning.png");
//        errorIcon = new JLabel(icon);
//        errorIcon.setVisible(false); // Initially hidden
//        add(errorIcon);

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
                // Validate card number
//                boolean isCardNumberValid = applyInputValidation(
//                        cardNumberField,
//                        errorIcon, // Pass the error icon here
//                        "Invalid card number!",
//                        "Validation Error",
//                        JOptionPane.WARNING_MESSAGE,
//                        true,
//                        "\\d{16}", // Regex for 12-14 digits
//                        false, // Not a clear action
//                        5, 0, // Icon X and Y offset
//                        20, 20 // Icon dimensions
//                );
//
//                boolean isPinValid = applyInputValidation(
//                        pinField,
//                        errorIcon, // Pass the error icon here
//                        "Invalid PIN!",
//                        "Validation Error",
//                        JOptionPane.WARNING_MESSAGE,
//                        true,
//                        "\\d{4}", // Regex for 4 digits
//                        false,
//                        5, 0,
//                        20, 20
//                );
                String cardNumber = cardNumberField.getText();
                String pinNumber = pinField.getText();
                boolean isValid = (cardNumber.matches("\\d{16}")||pinNumber.matches("\\d{16}"));
//                if (!isValid) {
////                    setLayout(null);
//                    System.out.println("i am in");
//                    Toolkit.getDefaultToolkit().beep();
//                    JOptionPane.showMessageDialog(null, "Please fill the Values", "Incomplete Entries",JOptionPane.WARNING_MESSAGE);
//                    errorIcon = showErrorIcon(isValid, "C:\\xtra\\Last_Chance\\BMS\\src\\icons\\error.png", 15, 360, 100, 100, errorIcon);
//                    errorIcon.setBounds(15, 360, 100, 100);
//                    setComponentZOrder(errorIcon, 0);
//                    revalidate();
//                    repaint();
//
//                }
                if (!isValid) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Please fill the Values", "Incomplete Entries", JOptionPane.WARNING_MESSAGE);
                    errorIcon = showErrorIcon(isValid, "C:\\xtra\\Last_Chance\\BMS\\src\\icons\\error.png",  0, 385, 100, 100, errorIcon);
                    // Explicitly add to the content pane
                    getContentPane().add(errorIcon);
                    getContentPane().setComponentZOrder(errorIcon, 0);
                    getContentPane().revalidate();
                    getContentPane().repaint();
                }else {
                    System.out.println("All inputs are valid. Proceeding with login...");
                    System.out.println("Sign-in Clicked");
                    ConnectionTrial con1 = new ConnectionTrial();
                    String cardNum = cardNumberField.getText();
                    String pinPassword = pinField.getText();
                    System.out.println(pinPassword);
                    String query = "select * from Login where REPLACE(Card_Number, '-', '') = '"+cardNum+"' and PiN = '"+pinPassword+"'";
                    ResultSet resultSet = con1.statement.executeQuery(query);
                    if(resultSet.next()){
                        setVisible(false);
                        new TransactionMain(pinPassword);
                    }else{
                        System.out.println("huh");
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null,"Bro u trippin aka\nIncorrect Card Number or Pin","Incorrect Entries",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }else if (b.getSource() == signUpButton) {
                new SignUp();
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
}

//1409963051935469
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
