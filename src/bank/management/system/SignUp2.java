package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp2 extends UI2 implements ActionListener{
    int widthWindow = 850;
    int heightWindow = 700;

    //Objects
    String formNo;
    private ImageIcon logo;
    private JComboBox category, income, education, occupation;
    private JTextField PAN, Aadhaar;

    ButtonGroup existingAcc = new ButtonGroup();
    JRadioButton yesAccExists;
    JRadioButton noAccExists;

    private JButton next;

    private final int opacityLevel = 200;

    public SignUp2(String formNo){
        //constructor call for basic calls
        super(850, 700, "Sign Up page 2",true);

        logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\allgood.jpg");
        addImage(logo, 25, 25, 100, 100); // Logo at top center

        this.formNo=formNo;

        //heading all centered!
        addLabel("APPLICATION FORM NO."+formNo, "Times New Roman Bold", Font.PLAIN, 24, 150, 30, false, true, "#000000");
        addLabel("Page 2.", "Times New Roman Bold", Font.PLAIN, 22, 150, 65, false, true, "#000000");
        addLabel("Additional Details.", "Times New Roman Bold", Font.PLAIN, 22, 150, 95, false, true, "#000000");

        String[] categoriesSlab = {"General", "General-PWD", "OBC", "SC/ST"};
        category = addLabelWithDropdown6("Category:", "Times New Roman", Font.BOLD, 20,
                100, 170, true, "Black", 400, 35, 220, 200,
                categoriesSlab, true, 0.8f);

        String[] incomeSlab = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "<10,00,000", ">10,00,000"};
        income = addLabelWithDropdown6("Income:", "Times New Roman", Font.BOLD, 20,
                100, 220, true, "Black", 400, 35, 220, 200,
                incomeSlab, true, 0.8f);

        String[] educationSlab = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other","None"};
        education = addLabelWithDropdown6("Education:", "Times New Roman", Font.BOLD, 20,
                100, 270, true, "Black", 400, 35, 220, 200,
                educationSlab, true, 0.8f);

        String[] occupationSlab = {"Salaried", "Self-Employed", "Government-Employee", "Business", "Student","Retired","Other","Unemployed"};
        occupation = addLabelWithDropdown6("Occupation:", "Times New Roman", Font.BOLD, 20,
                100, 320, true, "Black", 400, 35, 220, 200,
                occupationSlab, true, 0.8f);

        PAN = addLabelWithTextField2("PAN Number:", "Times New Roman", Font.BOLD, 20,
                100, 370,true,"Black", 400, 35,
                250, 200, true, opacityLevel,300);

        Aadhaar = addLabelWithTextField2("Aadhaar Number:", "Times New Roman", Font.BOLD, 20,
                100, 420,true,"Black", 400, 35,
                900, 200, true, opacityLevel,300);

        addLabel("Existing Account: ", "Times New Roman", Font.BOLD, 20, 100, 470, false, true, "#000000");
        yesAccExists = createRadioButton("Yes", "Times New Roman", Font.PLAIN, 18, 310, 470, 100, 30, Color.BLACK);
        noAccExists = createRadioButton("No", "Times New Roman", Font.PLAIN, 18, 410, 470, 90, 30, Color.BLACK);
        existingAcc.add(yesAccExists);
        existingAcc.add(noAccExists);


        next = addRoundedButton("Next", "Times New Roman", Font.BOLD, 14, 550, 520, 150, 40, false, true, opacityLevel);
        next.addActionListener((ActionListener) this);

        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\gradientBG6.png");
        addImage(backgroundImage, 0, 0, widthWindow, heightWindow);
            setVisible(true);
    }

//    public static void main(String[] args) {
//        new SignUp2("");
//    }
//    @Override
    public void actionPerformed(ActionEvent b) {
        try {
            String Category = (String)category.getSelectedItem();
            String Income = (String)income.getSelectedItem();
            String Education = (String)education.getSelectedItem();
            String Occupation = (String)occupation.getSelectedItem();
            String PANNumber = PAN.getText();
            String AadhaarNumber = Aadhaar .getText();
            String ExistingAcc = null;
            if(yesAccExists.isSelected()){
                ExistingAcc = "Yes";
            } else if(noAccExists.isSelected()){
                ExistingAcc = "No";
            }

            try{
                //change this for a check for every input field
                if(PAN.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }else{
                    ConnectionTrial con1 = new ConnectionTrial();
                    System.out.println(formNo);
                    String q = "insert into signUp2 values ('"+formNo+"','"+Category+"','"+Income+"','"+Education+"','"+Occupation+"','"+PANNumber+"','"+AadhaarNumber+"','"+ExistingAcc+"')";

                    con1.statement.executeUpdate(q);
                    new SignUp3(formNo);
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
