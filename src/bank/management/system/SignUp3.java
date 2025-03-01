package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class SignUp3 extends UI2 implements ActionListener{
    int widthWindow = 750;
    int heightWindow = 700;
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



    public SignUp3(String formNo) {
        super(750, 750, "Sign Up page 3",true);
        logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\allgood.jpg");
        addImage(logo, 25, 25, 100, 100); // Logo at top center

        this.formNo=formNo;

        //heading all centered!
        getContentPane().setBackground(new Color(128, 159, 156));
        addLabel("APPLICATION FORM NO."+formNo, "Times New Roman Bold", Font.PLAIN, 24, 150, 30, false, true, "#000000");
        addLabel("Page 3.", "Times New Roman Bold", Font.PLAIN, 22, 150, 65, false, true, "#000000");
        addLabel("Additional Details.", "Times New Roman Bold", Font.PLAIN, 22, 150, 95, false, true, "#000000");


        addLabel("Account Type: ", "Times New Roman", Font.BOLD, 18,
                100, 150, false, true, "#000000");
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

        addLabel("Card Number:", "Times New Roman Bold", Font.PLAIN,
                18, 100, 270, false, true, "#000000");

        addLabel("(Your 16-Digit Card Number)", "Raleway", Font.PLAIN,
                 13, 100, 295, false, true, "#000000");

        addLabel("XXXX-XXXX-XXXX-1234", "Times New Roman Bold", Font.PLAIN,
                18, 350, 270, false, true, "#000000");

        addLabel("(It will appear on atm card/ cheque Book and Statement)", "Raleway", Font.PLAIN,
                13, 350, 295, false, true, "#000000");


        addLabel("PIN Number:", "Times New Roman Bold", Font.PLAIN,
                18, 100, 355, false, true, "#000000");

        addLabel("(Your 4-Digit PIN)", "Raleway", Font.PLAIN,
                13, 100, 375, false, true, "#000000");

        addLabel("XXXX", "Times New Roman Bold", Font.PLAIN,
                18, 350, 355, false, true, "#000000");


        addLabel("Services Requested: ", "Times New Roman", Font.BOLD, 18,
                100, 440, false, true, "#000000");
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






        setVisible(true);


    }

    public static void main(String[] args) {
        new SignUp3("");
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
                    if(AccountType.equals("")) {
                        JOptionPane.showMessageDialog(null,"Fill all the fields");
                    }
                    else{
                        ConnectionTrial con1 = new ConnectionTrial();
                        System.out.println(formNo);
                        String q1 = "insert into signUp3 values ('"+formNo+"','"+AccountType+"','"+formattedCardNumber+"','"+Pin+"','"+services+"')";
                        String q2 = "insert into Login values ('"+formNo+"','"+formattedCardNumber+"','"+Pin+"')";

                        con1.statement.executeUpdate(q1);
                        con1.statement.executeUpdate(q2);
                        JOptionPane.showMessageDialog(null,"Card Number: " +formattedCardNumber+"\n PIN: "+Pin);
                        new Deposit(formNo);
                        setVisible(false);
                    }
                } else if (b.getSource()==Cancel) {
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
