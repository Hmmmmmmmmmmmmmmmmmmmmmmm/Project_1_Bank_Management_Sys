package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class SignUpNew extends UI2 {
    //variables and constants
    private final int widthWindow = 850;
    private final int heightWindow = 800;
    private final int opacityLevel = 100; // Global opacity control

    Random rand = new Random();
    long first4 = (rand.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    //Objects:
    private ImageIcon logo;
    private JTextField name;
    private JTextField fathersName;

    //DOB Calendar setup:
    private JDateChooser dateChooser;
    private JTextField email;
    private JTextField address;
    private JTextField City;
    private JTextField State;
    private JTextField PinCode;

    public SignUpNew() {
        super(850, 800, "Sign Up page",true);

        //logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\bank.png");
        logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\allgood.jpg");
        addImage(logo, 25, 20, 100, 100); // Logo at top center

        //heading all centered!
        addLabel("APPLICATION FORM NO." + first, "Times New Roman Bold", Font.PLAIN, 34, 100, 20, true, true, "#000000");
        addLabel("Page 1.", "Times New Roman Bold", Font.PLAIN, 22, 330, 70, true, true, "#000000");
        addLabel("Personal Details.", "Times New Roman Bold", Font.PLAIN, 22, 290, 100, true, true, "#000000");

        //text field with label time!!!
        //input section :
        name = addLabelWithTextField2("Name:", "Times New Roman", Font.BOLD, 20,
                100, 190, 400, 35, 220, 200, true, opacityLevel,300);
        fathersName = addLabelWithTextField2("Father's Name:", "Times New Roman", Font.BOLD, 20,
                100, 240, 400, 35, 220, 200, true, opacityLevel,300);

        // **Swapped Gender & DOB positions**:
        addLabelWithRadioButton2("Gender", "Times New Roman", Font.BOLD, 20,
                100, 290, 200, 14, 310, 290, 400, 290,
                90, 30, 90, "Male", "Female", true, opacityLevel);

        dateChooser = addLabelWithTextFieldWithCalendar2("Date Of Birth:", "Times New Roman", Font.BOLD, 20,
                100, 350, 400, 35, 220, 200, true, opacityLevel);

        // Background image
        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\gradientBG1.png"); // Replace with actual path
        addImage(backgroundImage, 0, 0, widthWindow, heightWindow);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp();
    }

//    @Override
    public void actionPerformed(ActionEvent b) {

    }
}
