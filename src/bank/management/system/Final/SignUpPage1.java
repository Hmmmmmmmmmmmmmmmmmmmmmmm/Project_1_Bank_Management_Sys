package bank.management.system.Final;

import bank.management.system.ConnectionTrial;
import bank.management.system.SignUp;
import bank.management.system.SignUp2;
import bank.management.system.UI2;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignUpPage1 extends FunctionsAndUI implements ActionListener{


    //variables and constants
    int widthWindow = 850;
    int heightWindow = 800;
    Random rand = new Random();
    int first4 = rand.nextInt(9000) + 1000; // Generates a number between 1000 and 9999
    String first = Integer.toString(first4); // Convert to string
    // Global opacity level for all components (0 = fully transparent, 255 = solid)
    // need to implement this bitch
    private final int opacityLevel = 170;

    //Objects:
    private ImageIcon logo;

    //data
    private JTextField userName;
    private JTextField fathersName;

    //DOB Calender setup:
    JPanel dateChooser;
    private JDateChooser dateChooserInstance;


    //radio button setup
    ButtonGroup gender = new ButtonGroup();
    JRadioButton gender1;
    JRadioButton gender2;

    ButtonGroup maritalStatus = new ButtonGroup();
    JRadioButton married;
    JRadioButton keepDreamingBro;
    JRadioButton noClueBoutThisOne;

    private JTextField emailAddress;
    private JTextField addressText;
    private JTextField City;
    private JTextField State;
    private JTextField PinCode;

    //Buttons
    private JButton next;
    private JButton back;


public SignUpPage1() {
    super(850, 800, "Sign Up page", false, 0, 0); // Call superclass constructor first

    // Now calculate centerX and centerY after calling super()
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int centerX = (screenSize.width - getWidth()) / 2;
    int centerY = (screenSize.height - getHeight()) / 2-20;

    // Set the window location
    setLocation(centerX, centerY);

    logo = new ImageIcon("src/icons/coolCatS.png");
    addImage(logo, 15, 0, 170, 170); // Logo at top center

//    heading all centered!
    addLabelWhichReturns("APPLICATION FORM NO."+first, "Times New Roman Bold",
            Font.PLAIN,34, 100, 20, true, true,
            0,0,0,true);
    addLabelWhichReturns("Page 1.", "Times New Roman Bold",
            Font.PLAIN,22, 330, 70, true,
            true, 0,0,0,true);
    addLabelWhichReturns("Personal Details.", "Times New Roman Bold",
            Font.PLAIN,22, 290, 100, true,
            true, 0,0,0,true);
    //text field with label time!!!
    //input section :
    userName = addLabelWithTextField("Name:",
            "Times New Roman", Font.BOLD, 20,
            100, 170, 0, 0, 0, 220, 200,
            "Times New Roman", Font.PLAIN, 16,
            400, 35,
            0, 0, 0,
            0, 0, 0,
            255, 255, 255,
            10, false, opacityLevel, 300
    );


    fathersName = addLabelWithTextField("Father's Name:", "Times New Roman", Font.BOLD, 20,
            100, 220, 0, 0, 0, 220, 200,
            "Times New Roman", Font.PLAIN, 16,
            400, 35,
            0, 0, 0,
            0, 0, 0,
            255, 255, 255,
            10, false, opacityLevel, 300
    );


    addLabelWhichReturns("Gender", "Times New Roman",
            Font.BOLD, 20, 100, 270, false, true,
            0, 0, 0, true);

    gender1 = createRadioButton("Male", "Times New Roman", Font.PLAIN, 14, 310, 270, 100, 30, Color.BLACK);
    gender2 = createRadioButton("Female", "Times New Roman", Font.PLAIN, 14, 410, 270, 90, 30, Color.BLACK);
    gender.add(gender1);
    gender.add(gender2);

    //DOB date chooser class + label = amalgamation
//        dateChooser=addCustomDateFieldMewMewMew(
    dateChooserInstance = addLabelWithTextFieldWithCalenderMewMew2(
//        dateChooser=addLabelWithTextFieldWithCalender(
            "Date Of Birth:", "Times New Roman", Font.BOLD, 20,
            100, 320, 0, 0, 0, 220, 20,  // Label color (black) & spacing reduced
            "Times New Roman", Font.BOLD, 16,
            400, 35,
            0, 0, 0,  // Text color (white)
            0, 0, 0,
            255, 255, 255, // Background color (black)
            10,
            false, opacityLevel,  // Transparency settings
            300 // **Manually set x-position for alignment**
    );


    //basic info
    emailAddress = addLabelWithTextField(
            "Email:", "Times New Roman", Font.BOLD, 20,
            100, 370, 0, 0, 0, 220, 200,
            "Times New Roman", Font.PLAIN, 16,
            400, 35,
            0, 0, 0,
            0, 0, 0,
            255, 255, 255,
            10, false, opacityLevel, 300
    );


    //ohk this was definitely not needed #realityCheck
    addLabelWhichReturns("Marital Status", "Times New Roman",
            Font.BOLD, 20, 100, 420, false, true,
            0, 0, 0, true);
    married = createRadioButton("Married", "Times New Roman", Font.PLAIN, 14, 310, 420, 100, 30, Color.BLACK);
    keepDreamingBro = createRadioButton("Unmarried", "Times New Roman", Font.PLAIN, 14, 410, 420, 110, 30, Color.BLACK);
    noClueBoutThisOne = createRadioButton("Others", "Times New Roman", Font.PLAIN, 14, 520, 420, 100, 30, Color.BLACK);
    maritalStatus.add(married);
    maritalStatus.add(keepDreamingBro);
    maritalStatus.add(noClueBoutThisOne);


    //back to basics
    addressText = addLabelWithTextField(
            "Address:", "Times New Roman", Font.BOLD, 20,
            100, 470, 0, 0, 0, 220, 200,
            "Times New Roman", Font.PLAIN, 16,
            400, 35,
            0, 0, 0,
            0, 0, 0,
            255, 255, 255,
            10, false, opacityLevel, 300
    );


    City = addLabelWithTextField(
            "City:", "Times New Roman", Font.BOLD, 20,
            100, 520, 0, 0, 0, 220, 200,
            "Times New Roman", Font.PLAIN, 16,
            400, 35,
            0, 0, 0,
            0, 0, 0,
            255, 255, 255,
            10, false, opacityLevel, 300
    );


    State = addLabelWithTextField(
            "State:", "Times New Roman", Font.BOLD, 20,
            100, 570, 0, 0, 0, 220, 200,
            "Times New Roman", Font.PLAIN, 16,
            400, 35,
            0, 0, 0,
            0, 0, 0,
            255, 255, 255,
            10, false, opacityLevel, 300
    );


    PinCode = addLabelWithTextField(
            "Pin Code:", "Times New Roman", Font.BOLD, 20,
            100, 620, 0, 0, 0, 220, 200,
            "Times New Roman", Font.PLAIN, 16,
            400, 35,
            0, 0, 0,
            0, 0, 0,
            255, 255, 255,
            10, false, opacityLevel, 300
    );


    //butttttoooonnnnsssss
    next = addRoundedButton(
            "Next", "Times New Roman", Font.BOLD, 16,
            500, 690, 130, 40, // Move the next button to the left (x = 500)
            false, true, 230,
            0, 0, 0,
            35, 35, 35,
            235, 235, 235,
            20
    );


    back = addRoundedButton( // Add the back button
            "Back", "Times New Roman", Font.BOLD, 16,
            650, 690, 130, 40, // Position the back button to the right of next
            false, true, 230,
            0, 0, 0,
            35, 35, 35,
            235, 235, 235,
            20
    );
    back.addActionListener((ActionListener) this);

    next.addActionListener((ActionListener) this);
//        clearButton = addRoundedButton("Clear", "Times New Roman", Font.BOLD, 18, 300, 300, 150, 40, false);

    // Add a new image at the bottom of the window, centered horizontally
    ImageIcon bottomImage = new ImageIcon("src/icons/Group2.png"); // Replace with your image path
    addImage(bottomImage, 0, heightWindow - 150, widthWindow, 150); // Image centered at bottom



    ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\bg1.jpg"); // Replace with actual path

    addImage(backgroundImage, 0, 0, widthWindow, heightWindow);
    setVisible(true);
}
    public static void main(String[] args) {
        new SignUpPage1();
    }

    @Override
    public void actionPerformed(ActionEvent b) {
        if(b.getSource()==next){
            System.out.println("SignUpPage1: Next button clicked");
            try {
                String formNo = first;
                String name = userName.getText();
                String fatherName = fathersName.getText();
                // First, retrieve the JDateChooser from the JPanel
                String dob = ((JTextField) dateChooserInstance.getDateEditor().getUiComponent()).getText();
                //String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
                String gen = null;
                if(gender1.isSelected()){
                    gen = "Male";
                }else if(gender2.isSelected()){
                    gen = "Female";
                }
                String email = emailAddress.getText();
                String marr = null;
                if(married.isSelected()){
                    marr = "Married";
                } else if(keepDreamingBro.isSelected()){
                    marr = "Unmarried";
                }else if(noClueBoutThisOne.isSelected()){
                    marr = "Others";
                }
                String address = addressText.getText();
                String city = City.getText();
                String pinCode = PinCode.getText();
                String state = State.getText();

                try{
                    if (name.trim().isEmpty() || fatherName.trim().isEmpty() || dob.trim().isEmpty() ||
                            gen == null || marr == null || address.trim().isEmpty() ||
                            city.trim().isEmpty() || pinCode.trim().isEmpty() || state.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Fill all the fields");
                    }else{
                        ConnectionFinal con1 = new ConnectionFinal();
                        String q = "INSERT INTO signUp (Form_no, Name, Father_name, DOB, Gender, Email, Marital_Status, Address, City, pincode, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                        try (PreparedStatement pstmt = con1.connection.prepareStatement(q)) {
                            pstmt.setString(1, formNo);
                            pstmt.setString(2, name);
                            pstmt.setString(3, fatherName);
                            pstmt.setString(4, dob);
                            pstmt.setString(5, gen);
                            pstmt.setString(6, email);
                            pstmt.setString(7, marr);
                            pstmt.setString(8, address);
                            pstmt.setString(9, city);
                            pstmt.setString(10, pinCode);
                            pstmt.setString(11, state);
                            pstmt.executeUpdate();
                        }
                        SignUpPage2 page2 = new SignUpPage2(first); // Create the instance
                        page2.setVisible(true);
                        setVisible(false);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }

            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        else if (b.getSource()==back) {
            new LoginPageMain(); // Example: go back to the UI2 page
            dispose(); // Close the current SignUpPage1
        }
        }
    }

