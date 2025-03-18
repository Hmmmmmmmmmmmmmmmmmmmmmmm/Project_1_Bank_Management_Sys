package bank.management.system.Final;

import bank.management.system.ConnectionTrial;
import bank.management.system.Deposit;
import bank.management.system.SignUp3;
import bank.management.system.UI2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignUpPage3 extends FunctionsAndUI implements ActionListener{
    int widthWindow = 750;
    int heightWindow = 750;
    String formNo;
    private ImageIcon logo;

    //acc type radio button
    ButtonGroup accountType = new ButtonGroup();
    JRadioButton savingAccount;
    JRadioButton fixedDeposit;
    JRadioButton currentAccount;
    JRadioButton recurringDeposit;

    //services checkbox
    JCheckBox ATMCard;
    JCheckBox InternetBanking;
    JCheckBox MobileBanking;
    JCheckBox EmailAlerts;
    JCheckBox ChequeBook;
    JCheckBox EStatement;
    JCheckBox Consent;

    private JButton Submit;
    private JButton Cancel;

    public SignUpPage3(String formNo) {
            super(750, 750, "Sign Up page 3",true,-1,-1);
            logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\allgood.jpg");
            addImage(logo, 25, 25, 100, 100); // Logo at top center

            this.formNo=formNo;

            //heading all centered!
            addLabelWhichReturns("APPLICATION FORM NO."+formNo, "Times New Roman Bold",
                    Font.PLAIN, 24, 150, 30, false, true,
                    0,0,0,true);
            addLabelWhichReturns("Page 3.", "Times New Roman Bold",
                    Font.PLAIN, 22, 150, 65, false, true,
                    0,0,0,true);
            addLabelWhichReturns("Additional Details.", "Times New Roman Bold",
                    Font.PLAIN, 22, 150, 95, false, true,
                    0,0,0,true);


            addLabelWhichReturns("Account Type: ", "Times New Roman",
                    Font.BOLD, 18,100, 150, false, true,
                    0,0,0,true);
            savingAccount = createRadioButton("Saving Account", "Times New Roman", Font.PLAIN, 18,
                    100, 180, 250, 30, Color.BLACK);
            fixedDeposit = createRadioButton("Fixed Deposit Account", "Times New Roman", Font.PLAIN, 18,
                    350, 180, 300, 30, Color.BLACK);
            currentAccount = createRadioButton("Current Account", "Times New Roman", Font.PLAIN, 18,
                    100, 210, 250, 30, Color.BLACK);
            recurringDeposit = createRadioButton("Recurring Deposit Account", "Times New Roman", Font.PLAIN, 18,
                    350, 210, 300, 30, Color.BLACK);
            accountType.add(savingAccount);
            accountType.add(fixedDeposit);
            accountType.add(currentAccount);
            accountType.add(recurringDeposit);

            addLabelWhichReturns("Card Number:", "Times New Roman Bold",
                    Font.PLAIN,18, 100, 270, false, true,
                    0,0,0,true);

            addLabelWhichReturns("(Your 16-Digit Card Number)", "Raleway",
                    Font.PLAIN,13, 100, 295, false, true,
                    0,0,0,true);

            addLabelWhichReturns("XXXX-XXXX-XXXX-1234", "Times New Roman Bold", Font.PLAIN,
                        18, 350, 270, false, true,
                        0,0,0,true);

            addLabelWhichReturns("(It will appear on atm card/ cheque Book and Statement)", "Raleway", Font.PLAIN,
                        13, 350, 295, false, true,
                    0,0,0,true);

            addLabelWhichReturns("PIN Number:", "Times New Roman Bold", Font.PLAIN,
                        18, 100, 355, false, true,
                    0,0,0,true);

            addLabelWhichReturns("(Your 4-Digit PIN)", "Raleway", Font.PLAIN,
                        13, 100, 375, false, true,
                    0,0,0,true);

            addLabelWhichReturns("XXXX", "Times New Roman Bold", Font.PLAIN,
                        18, 350, 355, false, true,
                    0,0,0,true);


            addLabelWhichReturns("Services Requested: ", "Times New Roman", Font.BOLD, 18,
                        100, 440, false, true, 0,0,0,true);
            ATMCard = createCheckButton("ATM Card", "Times New Roman", Font.PLAIN, 18,
                    100, 470, 250, 30, Color.BLACK);
            InternetBanking = createCheckButton("Internet Banking", "Times New Roman", Font.PLAIN, 18,
                    350, 470, 300, 30, Color.BLACK);
            MobileBanking = createCheckButton("Mobile Banking", "Times New Roman", Font.PLAIN, 18,
                    100, 500, 250, 30, Color.BLACK);
            EmailAlerts = createCheckButton("EmailAlerts", "Times New Roman", Font.PLAIN, 18,
                    350, 500, 300, 30, Color.BLACK);
            ChequeBook = createCheckButton("Cheque Book", "Times New Roman", Font.PLAIN, 18,
                    100, 530, 250, 30, Color.BLACK);
            EStatement = createCheckButton("E-Statement", "Times New Roman", Font.PLAIN, 18,
                    350, 530, 300, 30, Color.BLACK);

            Consent = createCheckButton("I here by declare that the aforementioned details are correct to the best of my knowledge", "Times New Roman", Font.PLAIN, 14,
                    100, 590, 600, 30, Color.BLACK);

            // Example: Dark gray text & border, light gray background, semi-transparent
            Submit = addRoundedButton(
                    /* text */ "Submit",
                    /* fontName */ "Times New Roman",
                    /* fontStyle */ Font.BOLD,
                    /* fontSize */ 14,
                    /* x, y, width, height */ 170, 650, 150, 40,
                    /* opaque? */ false,
                    /* transparent? */ true,
                    /* opacityLevel */ 200,
                    /* baseTextR, baseTextG, baseTextB */ 50, 50, 50,
                    /* baseBorderR, baseBorderG, baseBorderB */ 50, 50, 50,
                    /* baseBgR, baseBgG, baseBgB */ 200, 200, 200,
                    /* cornerRadius */ 10
            );


            Cancel = addRoundedButton("Cancel", "Times New Roman", Font.BOLD, 14,
                    400, 650, 150, 40,
                    false, true, 200,
                    50, 50, 50,    // base text color: dark gray
                    50, 50, 50,    // base border color: dark gray
                    200, 200, 200,
                    10// base background color: light grayish
            );
            Submit.addActionListener((ActionListener) this);
            Cancel.addActionListener((ActionListener) this);



        ImageIcon bottomImage = new ImageIcon("src/icons/Group2.png"); // Replace with your image path
        addImage(bottomImage, 0, heightWindow - 150, widthWindow, 150); // Image centered at bottom



            ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\bg1.jpg"); // Replace with actual path

            addImage(backgroundImage, 0, 0, widthWindow, heightWindow);
            setVisible(true);


        }
        @Override
        public void actionPerformed(ActionEvent b) {
            try {
                String AccountType = null;
                if(savingAccount.isSelected()){
                    AccountType="Saving Account";
                }else if(fixedDeposit.isSelected()){
                    AccountType="Fixed Deposit Account";
                }else if(currentAccount.isSelected()){
                    AccountType="Current Account";
                }else if(recurringDeposit.isSelected()){
                    AccountType="Recurring Deposit Account";
                }
                //private shit
                Random rand = new Random();
                long first7 = (rand.nextLong()%90000000L)+1409963000000000L;
                String cardNumber = String.format("%016d", Math.abs(first7));
                String formattedCardNumber = String.format("%s-%s-%s-%s",
                        cardNumber.substring(0, 4),
                        cardNumber.substring(4, 8),
                        cardNumber.substring(8, 12),
                        cardNumber.substring(12, 16));
                int first4 = rand.nextInt(9000) + 1000; // Generates a number between 1000 and 9999
                String Pin = Integer.toString(first4);
//            String Pin = "" + Math.abs(first3);
//
                //rest things
                String services = "";
                if(ATMCard.isSelected()){
                    services += "ATM Card  ";
                }            if(InternetBanking.isSelected()){
                    services += "Internet Banking  ";
                }            if(MobileBanking.isSelected()){
                    services += "Mobile Banking  ";
                }            if(EmailAlerts.isSelected()){
                    services += "Email Alerts  ";
                }            if(ChequeBook.isSelected()){
                    services += "Cheque Book  ";
                }           if(EStatement.isSelected()){
                    services += "E-Statement  ";
                }

                try{
                    if(b.getSource()==Submit){
                        //change this for a check for every input field
//                assert AccountType != null;
                        if (AccountType == null) { // Check for null instead of empty string
                            JOptionPane.showMessageDialog(null, "Fill all the fields");
                        } else {
                            ConnectionFinal con1 = new ConnectionFinal();
                            System.out.println(formNo);
                            // Use PreparedStatement to prevent SQL injection
                            String q1 = "INSERT INTO signUp3 (Form_no, Account_Type, Card_Number, Pin, Facilities) VALUES (?, ?, ?, ?, ?)";
                            String q2 = "INSERT INTO Login (Form_no, Card_Number, Pin) VALUES (?, ?, ?)";
                            try (PreparedStatement pstmt1 = con1.connection.prepareStatement(q1);
                                 PreparedStatement pstmt2 = con1.connection.prepareStatement(q2)) {
                                pstmt1.setString(1, formNo);
                                pstmt1.setString(2, AccountType);
                                pstmt1.setString(3, cardNumber);
                                pstmt1.setString(4, Pin);
                                pstmt1.setString(5, services);
                                pstmt2.setString(1, formNo);
                                pstmt2.setString(2, cardNumber);
                                pstmt2.setString(3, Pin);
                                pstmt1.executeUpdate();
                                pstmt2.executeUpdate();
                            }
                            JOptionPane.showMessageDialog(null,"Card Number: " +cardNumber+"\n PIN: "+Pin);
                            new DepositFinal(cardNumber);
                            setVisible(false);
                        }
                    }
                    else if (b.getSource()==Cancel) {
                        System.out.println("Cancel button pressed");

                        if (formNo != null && !formNo.isEmpty()) { // Check if formNo is not null or empty
                            ConnectionFinal con1 = new ConnectionFinal();
                            String q1 = "DELETE FROM signUp WHERE formNo = ?";
                            String q2 = "DELETE FROM signUp2 WHERE formNo = ?";
                            try (PreparedStatement pstmt1 = con1.connection.prepareStatement(q1);
                                 PreparedStatement pstmt2 = con1.connection.prepareStatement(q2)) {
                                pstmt1.setString(1, formNo);
                                pstmt2.setString(1, formNo);
                                int rowsAffected1 = pstmt1.executeUpdate();
                                int rowsAffected2 = pstmt2.executeUpdate();
                                System.out.println("Rows deleted from signUp: " + rowsAffected1);
                                System.out.println("Rows deleted from signUp2: " + rowsAffected2);
                            }

                            JOptionPane.showMessageDialog(null, "Application canceled. Data deleted.");
                        } else {
                            System.out.println("formNo is null or empty. Skipping delete operation.");
                        }

                        System.exit(0);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

