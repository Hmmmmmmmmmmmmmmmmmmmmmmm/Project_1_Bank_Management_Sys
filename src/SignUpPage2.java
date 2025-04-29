import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class SignUpPage2 extends FunctionsAndUI implements ActionListener{
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

        public SignUpPage2(String formNo){

            //constructor call for basic calls
            super(850, 700, "Sign Up page 2",true,-1,-1);
            System.out.println("SignUpPage2: Constructor called"); // Add this line

            logo = new ImageIcon("src/icons/coolCatS.png");
            addImage(logo, 5, 0, 170, 170);
            this.formNo=formNo;

            //heading all centered!
            addLabelWhichReturns("APPLICATION FORM NO."+formNo, "Times New Roman Bold",
                    Font.PLAIN, 24, 150, 30, false, true,
                    0,0,0,true);
            addLabelWhichReturns("Page 2.", "Times New Roman Bold",
                    Font.PLAIN, 22, 150, 65, false, true,
                    0,0,0,true);
            addLabelWhichReturns("Additional Details.", "Times New Roman Bold",
                    Font.PLAIN, 22, 150, 95, false, true,
                    0,0,0,true);

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

            PAN = addLabelWithTextField(
                    "PAN Number:", "Times New Roman", Font.BOLD, 20,
                    100, 370, 0, 0, 0, 250, 200, // Use 0, 0, 0 for black label color
                    "Times New Roman", Font.PLAIN, 16, // Assuming plain font for text field
                    400, 35,
                    0, 0, 0, // Assuming black text color
                    0, 0, 0, 255, 255, 255, 10, // Assuming black border and white background
                    false, opacityLevel, 300
            );

            Aadhaar = addLabelWithTextField(
                    "Aadhaar Number:", "Times New Roman", Font.BOLD, 20,
                    100, 420, 0, 0, 0, 900, 200, // Use 0, 0, 0 for black label color
                    "Times New Roman", Font.PLAIN, 16, // Assuming plain font for text field
                    400, 35,
                    0, 0, 0, // Assuming black text color
                    0, 0, 0, 255, 255, 255, 10, // Assuming black border and white background
                    false, opacityLevel, 300
            );

            applyInputFilter(PAN, "^[A-Za-z0-9]{0,10}$", "PAN should be 10 characters", "^[A-Za-z]{5}{4}[A-Za-z]{1}$");
            applyInputFilter(Aadhaar, "^[0-9]{0,12}$", "Aadhaar should be 12 digits", "^{1}{11}$");

            addLabelWhichReturns("Existing Account: ", "Times New Roman",
                    Font.BOLD, 20, 100, 470, false, true,
                    0,0,0,true);
            yesAccExists = createRadioButton("Yes", "Times New Roman", Font.PLAIN, 18, 310, 470, 100, 30, Color.BLACK);
            noAccExists = createRadioButton("No", "Times New Roman", Font.PLAIN, 18, 410, 470, 90, 30, Color.BLACK);
            existingAcc.add(yesAccExists);
            existingAcc.add(noAccExists);


            next = addRoundedButton(
                    "Next", "Times New Roman", Font.BOLD, 14, 550, 520, 150, 40,
                    false, true, opacityLevel,
                    0, 0, 0,          // Base text color: black
                    35, 35, 35,       // Base border color: dark gray
                    235, 235, 235,    // Base background color: very light gray
                    20                // Corner radius: 20
            );
            next.addActionListener((ActionListener) this);

            // Add a new image at the bottom of the window, centered horizontally
            ImageIcon bottomImage = new ImageIcon("src/icons/Group2.png"); // Replace with your image path
            addImage(bottomImage, 0, heightWindow - 150, widthWindow, 150); // Image centered at bottom


            ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\BlurLeaves.jpg"); // Replace with actual path

            addImage(backgroundImage, 0, 0, widthWindow, heightWindow);
//            setVisible(true);
        }

        //    public static void main(String[] args) {
//        new SignUp2("");
//    }
    @Override
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
                    if (Category == null || Income == null || Education == null || Occupation == null ||
                            PANNumber.isEmpty() || AadhaarNumber.isEmpty() || ExistingAcc == null) {
                        JOptionPane.showMessageDialog(null, "Fill all the fields");
                        next.setEnabled(true); // Re-enable the button if fields are empty
                    } else if (!PANNumber.matches("^[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}$")) {
                        JOptionPane.showMessageDialog(null, "Invalid PAN number format");
                        next.setEnabled(true); // Re-enable the button if PAN is invalid
                    } else if (!AadhaarNumber.matches("^[0-9]{12}$")) {
                        JOptionPane.showMessageDialog(null, "Invalid Aadhaar number format");
                        next.setEnabled(true); // Re-enable the button if Aadhaar is invalid
                    } else{
                        ConnectionFinal con1 = new ConnectionFinal();

                        // Use PreparedStatement to prevent SQL injection
                        String q = "INSERT INTO signUp2 (Form_no, Category, Income, Education, Occupation, PAN_Number, Addhaar_Number, Existing_Account) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement pstmt = con1.connection.prepareStatement(q)) {
                            pstmt.setString(1, formNo);
                            pstmt.setString(2, Category);
                            pstmt.setString(3, Income);
                            pstmt.setString(4, Education);
                            pstmt.setString(5, Occupation);
                            pstmt.setString(6, PANNumber);
                            pstmt.setString(7, AadhaarNumber);
                            pstmt.setString(8, ExistingAcc);
                            pstmt.executeUpdate();
                        }
                        new SignUpPage3(formNo);
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


