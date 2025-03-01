package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CashWithdrawal extends UI2 implements ActionListener {

    private final int opacityLevel = 200;

    //Objects:
    private ImageIcon logo;
    JTextField withdrawalAmount;
    private JButton withdrawalButton,BackButton;

    String pin;

    CashWithdrawal(String pin){
        super(1550,1080,"Main",false);
        this.pin = pin;
        addLabel("Pleas Enter Withdrawal Amount", "Times New Roman Bold",
                Font.PLAIN, 24,
                460, 185, false, true,
                255, 255, 255);


        addLabel("(Maximum Limit: 20,000/-)", "Times New Roman Bold",
                Font.PLAIN, 16,
                460, 220, false, true,
                255, 255, 255); // colorChange=false so these values are ignored (or you can use defaults)

        withdrawalAmount = justTextField(460,250,350,35,
                "Times New Roman Bold",Font.PLAIN,20,
                0,0,0,
                0,0,0,
                135, 178, 247,
                0,false,100);

        withdrawalButton = addRoundedButton(
                "Withdrawal", "Times New Roman", Font.BOLD, 18,
                700, 362, 150, 40,
                false, true, opacityLevel,
                0, 0, 0,          // Base text color: black
                50, 50, 50,       // Base border color: dark gray
                245, 245, 245,    // Base background color: very light gray
                10                // Corner radius: 20
        );
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
        withdrawalButton.addActionListener(this);
        BackButton.addActionListener(this);

        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\atm2.png");
        addImage(backgroundImage, 0, 0, 1550, 830);
        setVisible(true);
    }


    public static void main(String[] args) {
        new CashWithdrawal("");
    }
    @Override
    public void actionPerformed(ActionEvent b) {
        try {
            String Amount = withdrawalAmount.getText();
            Date date = new Date();
            try {
                int amt = Integer.parseInt(Amount);
                if (b.getSource() == withdrawalButton ) {
                    if (withdrawalAmount.getText().isEmpty()|| amt>20000) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter appropriate Withdrawal amount");
                    }else {
                        ConnectionTrial con1 = new ConnectionTrial();
                        ResultSet resultSet = con1.statement.executeQuery("select * from deposit where Pin = '"+pin+"'");
                        int balance = 0;
                        while (resultSet.next()){
                            if(resultSet.getString("type").equals("Deposit")){
                                balance = Integer.parseInt(resultSet.getString("amount"));
                            }else{
                                balance-=Integer.parseInt(resultSet.getString("amount"));
                            }
                        }if(balance<Integer.parseInt(Amount)){
                            JOptionPane.showMessageDialog(null,"Insufficient Balance");
                            return;
                        }

                        con1.statement.executeUpdate("insert into Deposit value('"+pin+"','"+date+"','Withdrawal','"+Amount+"')");
                        JOptionPane.showMessageDialog(null,"'"+Amount+"' Debited Successfully");
                        setVisible(false);
                        new TransactionMain(pin);

                    }
                } else if (b.getSource() == BackButton) {
//                    System.exit(0);
                    setVisible(false);
                    new TransactionMain(pin);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
