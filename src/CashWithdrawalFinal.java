import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class CashWithdrawalFinal extends FunctionsAndUI implements ActionListener {

    private final int opacityLevel = 200;

    //Objects:
    private ImageIcon logo;
    JTextField withdrawalAmount;
    private JButton withdrawalButton,BackButton;


    String cardNumber;

    CashWithdrawalFinal(String cardNumber){
        super(1550,1080,"Main",false,-1,-1);
        this.cardNumber = cardNumber;
        addLabelWhichReturns("Please Enter Withdrawal Amount", "Times New Roman Bold",
                Font.PLAIN, 24,
                460, 185, false, true,
                255, 255, 255,true);


        addLabelWhichReturns("(Maximum Limit: 20,000/-)", "Times New Roman Bold",
                Font.PLAIN, 16,
                460, 220, false, true,
                255, 255, 255,true); // colorChange=false so these values are ignored (or you can use defaults)

        withdrawalAmount = justTextField2(460,250,350,35,
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
        new CashWithdrawalFinal("");
    }
    @Override
    public void actionPerformed(ActionEvent b) {
        try {
            String Amount = withdrawalAmount.getText();
            Date date = new Date();
            try {
                int amt = Integer.parseInt(Amount);
                if (b.getSource() == BackButton) {
                    setVisible(false);
//                    new HomePage(cardNumber);
                }else if (b.getSource() == withdrawalButton ) {
                    if (withdrawalAmount.getText().isEmpty() || amt>20000) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter appropriate Withdrawal amount");
                    }else {
                        ConnectionFinal con1 = new ConnectionFinal();
                        // Validate cardNumber (example)
                        String checkCardNumberQuery = "SELECT COUNT(*) FROM Login WHERE Card_Number = ?";
                        try (PreparedStatement checkCardNumberStmt = con1.connection.prepareStatement(checkCardNumberQuery)) {
                            checkCardNumberStmt.setString(1, cardNumber);
                            try (ResultSet rs = checkCardNumberStmt.executeQuery()) {
                                if (rs.next() && rs.getInt(1) == 0) {
                                    JOptionPane.showMessageDialog(null, "Invalid card number");
                                    return;
                                }
                            }
                        }

                        // Use PreparedStatement to prevent SQL injection in SELECT query
                        String selectQuery = "SELECT * FROM Transactions WHERE CardNumber = ?";
                        try (PreparedStatement selectStmt = con1.connection.prepareStatement(selectQuery)) {
                            selectStmt.setString(1, cardNumber);
                            try (ResultSet resultSet = selectStmt.executeQuery()) {
                                int balance = 0;
                                while (resultSet.next()) {
                                    if (resultSet.getString("type").equals("Deposit")) {
                                        balance += Integer.parseInt(resultSet.getString("amount"));
                                    } else {
                                        balance -= Integer.parseInt(resultSet.getString("amount"));
                                    }
                                }
                                if (balance < Integer.parseInt(Amount)) {
                                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                                    return;
                                }
                            }
                        }

                        // Use PreparedStatement to prevent SQL injection in INSERT query
                        String insertQuery = "INSERT INTO Transactions (CardNumber, date, type, amount) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement insertStmt = con1.connection.prepareStatement(insertQuery)) {
                            insertStmt.setString(1, cardNumber);
                            insertStmt.setString(2, String.valueOf(date));
                            insertStmt.setString(3, "Withdrawal");
                            insertStmt.setString(4, Amount);
                            insertStmt.executeUpdate();
                        }JOptionPane.showMessageDialog(null,"'"+Amount+"' Debited Successfully");
                        setVisible(false);
                        new HomePage(cardNumber);

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
