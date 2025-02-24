package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp extends UI2 implements ActionListener{
    //variables and constants
    int widthWindow = 850;
    int heightWindow = 800;
    Random rand = new Random();
    long first4 = (rand.nextLong()%9000L)+1000L;
    String first = " " + Math.abs(first4);
    // Global opacity level for all components (0 = fully transparent, 255 = solid)
    // need to implement this bitch
    private final int opacityLevel = 200;

    //Objects:
    private ImageIcon logo;

    //data
    private JTextField userName;
    private JTextField fathersName;

    //DOB Calender setup:
    JDateChooser dateChooser;

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
//    private JPasswordField pinField;

    public SignUp() {
        super(850, 800, "Sign Up page");

        //logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\bank.png");
        logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\allgood.jpg");
        addImage(logo, 25, 20, 100, 100); // Logo at top center

        //heading all centered!
        addLabel("APPLICATION FORM NO."+first, "Times New Roman Bold", Font.PLAIN, 34, 100, 20, true, true, "#000000");
        addLabel("Page 1.", "Times New Roman Bold", Font.PLAIN, 22, 330, 70, true, true, "#000000");
        addLabel("Personal Details.", "Times New Roman Bold", Font.PLAIN, 22, 290, 100, true, true, "#000000");

        //text field with label time!!!
        //input section :
        userName = addLabelWithTextField2("Name:", "Times New Roman", Font.BOLD, 20,
                100, 190,true,"Black", 400, 35,
                220, 200, true, opacityLevel,300);

        fathersName = addLabelWithTextField2("Father's Name:", "Times New Roman", Font.BOLD, 20,
                100, 240,true,"Black", 400, 35,
                220, 200, true, opacityLevel,300);


//        dateChooser = addLabelWithTextFieldWithCalender("Date Of Birth:", "Times New Roman", Font.BOLD, 20, 100, 290, 400, 35, 220, 200);

        //change this into label + one button + one button + group said 2 buttons for data capturing

//        trying this addLabelWithRadioButton2("Gender", "Times New Roman", Font.BOLD, 20,
//        100, 290, 200, 14, 310, 290, 400, 290,
//        90, 30, 90,
//        "Male", "Female");

        //gender radio button setup
        //changing the buttons text from BOLD to PLAIN
        addLabel("Gender", "Times New Roman", Font.BOLD, 20, 100, 290, false, true, "#000000");
        gender1 = createRadioButton("Male", "Times New Roman", Font.PLAIN, 14, 310, 290, 100, 30, Color.BLACK);
        gender2 = createRadioButton("Female", "Times New Roman", Font.PLAIN, 14, 410, 290, 90, 30, Color.BLACK);
        gender.add(gender1);
        gender.add(gender2);

        //DOB date chooser class + label = amalgamation
        dateChooser = addLabelWithTextFieldWithCalender("Date Of Birth:", "Times New Roman", Font.BOLD, 20,
        100, 340, true,"black",400, 35, 220, 200);

        //basic info
        emailAddress = addLabelWithTextField2("Email:", "Times New Roman", Font.BOLD, 20,
                100, 390,true,"Black", 400, 35,
                220, 200, true, opacityLevel,300);

        //ohk this was definitely not needed #realityCheck
        addLabel("Marital Status", "Times New Roman", Font.BOLD, 20, 100, 440, false, true, "#000000");
//        married = createRadioButton("Married", "Arial", Font.PLAIN, 14, 310, 440, 100, 30, Color.BLACK);
//        keepDreamingBro = createRadioButton("Unmarried", "Arial", Font.PLAIN, 14, 410, 440, 100, 30, Color.BLACK);
//        noClueBoutThisOne = createRadioButton("Others", "Arial", Font.PLAIN, 14, 510, 440, 100, 30, Color.BLACK);
        married = createRadioButton("Married", "Times New Roman", Font.PLAIN, 14, 310, 440, 100, 30, Color.BLACK);
        keepDreamingBro = createRadioButton("Unmarried", "Times New Roman", Font.PLAIN, 14, 410, 440, 110, 30, Color.BLACK);
        noClueBoutThisOne = createRadioButton("Others", "Times New Roman", Font.PLAIN, 14, 520, 440, 100, 30, Color.BLACK);
        maritalStatus.add(married);
        maritalStatus.add(keepDreamingBro);
        maritalStatus.add(noClueBoutThisOne);


        //back to basics
        addressText = addLabelWithTextField2("Address:", "Times New Roman", Font.BOLD, 20,
                100, 490,true,"Black", 400, 35,
                220, 200, true, opacityLevel,300);
        City = addLabelWithTextField2("City:", "Times New Roman", Font.BOLD, 20,
                100, 540,true,"Black",400, 35,
                220, 200, true, opacityLevel,300);
        State = addLabelWithTextField2("State:", "Times New Roman", Font.BOLD, 20,
                100, 590,true,"Black", 400, 35,
                220, 200, true, opacityLevel,300);
        PinCode = addLabelWithTextField2("Pin Code:", "Times New Roman", Font.BOLD, 20,
                100, 640,true,"Black",400, 35,
                220, 200, true, opacityLevel,300);

        //butttttoooonnnnsssss
        next = addRoundedButton("Next", "Times New Roman", Font.BOLD, 14, 620, 710, 150, 40, false, true, opacityLevel);
        next.addActionListener((ActionListener) this);
//        clearButton = addRoundedButton("Clear", "Times New Roman", Font.BOLD, 18, 300, 300, 150, 40, false);
//        clearButton.addActionListener((ActionListener) this);
//        signUpButton = addRoundedButton("Sign Up", "Times New Roman", Font.BOLD, 18, ((640 - 120) / 2) - 20, 360, 120, 40, false);
//        signUpButton.addActionListener((ActionListener) this);




        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\gradientBG6.png"); // Replace with actual path

        addImage(backgroundImage, 0, 0, widthWindow, heightWindow);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp();
    }

    @Override
    public void actionPerformed(ActionEvent b) {
        try {
            String formNo = first;
            String name = userName.getText();
            String fatherName = fathersName.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
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
                if(userName.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }else{
                    ConnectionTrial con1 = new ConnectionTrial();
                    String q = "insert into signUp values ('"+formNo+"','"+name+"','"+fatherName+"','"+dob+"','"+gen+"','"+email+"','"+marr+"','"+address+"','"+city+"','"+pinCode+"','"+state+"')";
                    con1.statement.executeUpdate(q);
                    new SignUp2(first);
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
