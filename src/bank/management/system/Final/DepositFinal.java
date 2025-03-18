package bank.management.system.Final;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;

public class DepositFinal extends FunctionsAndUI implements ActionListener {
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
    String cardNumber;
    DepositFinal(String cardNumber){
        super(1550,1080,"Main",false,-1,-1);
        this.cardNumber = cardNumber;

        addLabelWhichReturns("Enter the Amount you want to deposit", "Times New Roman Bold",
                Font.PLAIN, 24,
                440, 170, false, true,
                255, 255, 255,true);

        depositAmount = justTextField2(460,215,350,35,
                "Times New Roman Bold",Font.PLAIN,20,
                0,0,0,
                0,0,0,
                135, 178, 247,
                0,false,200);

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




        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\atm2.png");
        addImage(backgroundImage, 0, 0, 1550, 830);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DepositFinal("");
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
                        ConnectionFinal con1 = new ConnectionFinal();
//                        System.out.println(formNo);
                        String q = "INSERT INTO Transactions (CardNumber, date, type, amount) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement pstmt = con1.connection.prepareStatement(q)) {
                            pstmt.setString(1, cardNumber);
                            pstmt.setString(2, String.valueOf(date)); // Convert date to string
                            pstmt.setString(3, "Deposit");
                            pstmt.setString(4, Amount);
                            pstmt.executeUpdate();
                        }JOptionPane.showMessageDialog(null,"Rs. "+Amount+"/- Deposited Successfully");
//                        new SignUp3(formNo);
                        setVisible(false);
                        new HomePage(cardNumber);
                    }
                } else if (b.getSource()==BackButton) {
//                    System.exit(0);
                    setVisible(false);
                    new HomePage(cardNumber);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
