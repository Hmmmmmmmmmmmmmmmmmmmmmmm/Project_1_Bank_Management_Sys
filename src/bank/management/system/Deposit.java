package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

public class Deposit extends UI2 implements ActionListener {
    //variables and constants
    int widthWindow = 1920;
    int heightWindow = 1080;
    // Global opacity level for all components (0 = fully transparent, 255 = solid)
    // need to implement this bitch
    private final int opacityLevel = 200;

    //Objects:
    private ImageIcon logo;
    JTextField depositAmount;
    private JButton depositButton,BackButton;

    String pin;
    Deposit(String pin){
        //issues with image scalling
//        super(1550,1080,"ATM");
        //cant use this condition
        this.pin = pin;




        addLabel("Enter the Amount you want to deposit", "Times New Roman Bold",
                Font.PLAIN, 24,
                440, 170, false, true,
                255, 255, 255); // colorChange=false so these values are ignored (or you can use defaults)

        depositAmount = justTextField(460,215,350,35,
                                    "Times New Roman Bold",Font.PLAIN,20,
                                    0,0,0,
                                    0,0,0,
                                    135, 178, 247,
                                    0,false,100);

        depositButton = addRoundedButton(
                "Deposit", "Times New Roman", Font.BOLD, 18,
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
        depositButton.addActionListener(this);
        BackButton.addActionListener(this);





        ImageIcon i1 = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\atm2.png");
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel backgroundImage = new JLabel(i3);
        backgroundImage.setBounds(0,0,1550,830);
        add(backgroundImage);



        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Deposit("");
    }
    @Override
    public void actionPerformed(ActionEvent b) {
        try {
            String Amount = depositAmount.getText();
            Date date = new Date();
            try{
                if(b.getSource()==depositButton){
                    if(depositAmount.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,
                                "Please enter the Deposit amount");
                    }else{
                        ConnectionTrial con1 = new ConnectionTrial();
//                        System.out.println(formNo);
                        con1.statement.executeUpdate("insert into Deposit values('"+pin+"','"+date+"','Deposit','"+Amount+"')");
                        JOptionPane.showMessageDialog(null,"Rs. "+Amount+"/- Deposited Successfully");
//                        new SignUp3(formNo);
                        setVisible(false);
                        new TransactionMain(pin);
                    }
                } else if (b.getSource()==BackButton) {
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
