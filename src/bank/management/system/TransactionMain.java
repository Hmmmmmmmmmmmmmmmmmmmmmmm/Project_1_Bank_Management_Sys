package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TransactionMain extends UI2 implements ActionListener {
    int widthWindow = 1550;
    int heightWindow = 1080;

    //Objects


    private JButton depositB, cashWithdrawal, fastCash, miniStatement,
                    pinChange, balanceInquiry, exit;
    String pin;
    private final int opacityLevel = 200;
    TransactionMain(String pin){
        super(1550,1080,"Main",false);
        this.pin = pin;
        addLabel("Please Select Your Transaction", "Times New Roman Bold",
                Font.PLAIN, 28,
                430, 170, false, true,
                255, 255, 255); // colorChange=false so these values are ignored (or you can use defaults)

        //buttons:

        depositB = addRoundedButton(
                "Deposit", "Tahoma", Font.PLAIN, 18,
                410, 271, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        cashWithdrawal = addRoundedButton(
                "Cash Withdrawl", "Tahoma", Font.PLAIN, 18,
                700, 271, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        fastCash = addRoundedButton(
                "Fast Cash", "Tahoma", Font.PLAIN, 18,
                410, 318, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        miniStatement = addRoundedButton(
                "Mini Statement", "Tahoma", Font.PLAIN, 18,
                410, 362, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        pinChange = addRoundedButton(
                "Pin Change", "Tahoma", Font.PLAIN, 18,
                700, 362, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        balanceInquiry = addRoundedButton(
                "Balance Inquiry", "Tahoma", Font.PLAIN, 18,
                700, 318, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        exit = addRoundedButton(
                "Exit", "Tahoma", Font.PLAIN, 18,
                700, 406, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        //mentioning all of em in actionListener

        depositB.addActionListener((ActionListener) this);
        cashWithdrawal.addActionListener((ActionListener) this);
        fastCash.addActionListener((ActionListener) this);
        miniStatement.addActionListener((ActionListener) this);
        pinChange.addActionListener((ActionListener) this);
        balanceInquiry.addActionListener((ActionListener) this);
        exit.addActionListener((ActionListener) this);


        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\atm2.png");
        addImage(backgroundImage, 0, 0, 1550, 830);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //depositB, cashWithdrawal, fastCash,
        // miniStatement,
        // pinChange, balanceInquiry, exit;
        try{
            if(e.getSource()==depositB){
                new Deposit(pin);
                setVisible(false);
            }else if(e.getSource()==cashWithdrawal){
//                setVisible(false);
                new CashWithdrawal(pin);
                setVisible(false);
            }else if(e.getSource()==balanceInquiry){
//                setVisible(false);
                new BalanceInquiry(pin);
                setVisible(false);
            }else if(e.getSource()==fastCash){
//                setVisible(false);
                new FastCash(pin);
                setVisible(false);
            }else if(e.getSource()==exit){
//                setVisible(false);
                System.exit(0);
            }
        }
        catch (Exception E){

        }

    }

    public static void main(String[] args) {
        new TransactionMain("");
    }
}
