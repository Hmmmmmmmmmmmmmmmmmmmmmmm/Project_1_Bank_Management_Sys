package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class BalanceInquiry extends UI2 implements ActionListener {
    private final int opacityLevel = 200;

    //Objects:
    private ImageIcon logo;
    JTextField withdrawalAmount;
    private JButton withdrawalButton,BackButton;
    private JLabel balanceDisplay;

    String pin;


    BalanceInquiry(String pin){
        super(1550,1080,"Main",false);
        this.pin = pin;
        addLabel("Your Current Balance is:", "Times New Roman Bold",
                Font.PLAIN, 24,
                430, 180, false, true,
                255, 255, 255);


        balanceDisplay = addLabelWhichReturns("(Maximum Limit: 20,000/-)", "Times New Roman Bold",
                            Font.PLAIN, 24,
                            430, 225, false, true,
                            255, 255, 255,
                            true); // colorChange=false so these values are ignored (or you can use defaults)


        BackButton = addRoundedButton(
                "Back", "Times New Roman", Font.BOLD, 18,
                700,406, 150, 40,
                false, true, opacityLevel,
                0, 0, 0,          // Base text color: black
                50, 50, 50,       // Base border color: dark gray
                245, 245, 245,    // Base background color: very light gray
                10                // Corner radius: 20
        );

        //actionListener Nonsense
        BackButton.addActionListener(this);

        int balance = 0;
        try{
            ConnectionTrial con = new ConnectionTrial();
            ResultSet resultSet = con.statement.executeQuery("select * from Deposit where Pin = '"+pin+"'");
            while (resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")){
                    balance = Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance-=Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        balanceDisplay.setText(""+balance);


        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\atm2.png");
        addImage(backgroundImage, 0, 0, 1550, 830);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceInquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent b) {
        try {
            if (b.getSource() == BackButton) {
//                    System.exit(0);
                setVisible(false);
                new TransactionMain(pin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
