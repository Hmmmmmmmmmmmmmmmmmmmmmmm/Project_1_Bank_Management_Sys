package bank.management.system.Final;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class FastCashFinal extends FunctionsAndUI implements ActionListener {
    private final int opacityLevel = 200;

    //Objects:
    private JButton Rs100, Rs500, Rs1000, Rs2000,
            Rs5000, Rs10000, exit;

    String cardNumber;
    FastCashFinal(String cardNumber){
        super(1550,1080,"Main",false,-1,-1);
        this.cardNumber = cardNumber;
        addLabelWhichReturns("Select Withdrawal Amount", "Times New Roman Bold",
                Font.PLAIN, 32,
                430, 170, false, true,
                255, 255, 255,true); // colorChange=false so these values are ignored (or you can use defaults)

        //buttons:
        Rs100 = addRoundedButton(
                "Rs. 100", "Times New Roman", Font.PLAIN, 18,
                410, 271, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        Rs500 = addRoundedButton(
                "Rs. 500", "Times New Roman", Font.PLAIN, 18,
                700, 271, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        Rs1000 = addRoundedButton(
                "Rs. 1000", "Times New Roman", Font.PLAIN, 18,
                410, 318, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        Rs2000 = addRoundedButton(
                "Rs. 2000", "Times New Roman", Font.PLAIN, 18,
                410, 362, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        Rs5000 = addRoundedButton(
                "Rs. 5000", "Times New Roman", Font.PLAIN, 18,
                700, 362, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        Rs10000 = addRoundedButton(
                "Rs. 10000", "Times New Roman", Font.PLAIN, 18,
                700, 318, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        exit = addRoundedButton(
                "Back", "Times New Roman", Font.PLAIN, 18,
                700, 406, 150, 35,
                false, true, opacityLevel,
                255, 255, 255,          // Base text color: black
                11, 139, 145,       // Base border color: dark gray
                11, 139, 145,   // Base background color: very light gray
                0                // Corner radius: 20 base
        );
        //mentioning all of em in actionListener

        Rs100.addActionListener((ActionListener) this);
        Rs500.addActionListener((ActionListener) this);
        Rs1000.addActionListener((ActionListener) this);
        Rs2000.addActionListener((ActionListener) this);
        Rs5000.addActionListener((ActionListener) this);
        Rs10000.addActionListener((ActionListener) this);
        exit.addActionListener((ActionListener) this);

        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\atm2.png");
        addImage(backgroundImage, 0, 0, 1550, 830);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FastCashFinal("");
    }

    @Override
    public void actionPerformed(ActionEvent b) {
        try {
            if (b.getSource() == exit) {
//                    System.exit(0);
                setVisible(false);
                new HomePage(cardNumber);
            }else{
                String amount = ((JButton)b.getSource()).getText().substring(4);
                Date date = new Date();
                ConnectionFinal con = new ConnectionFinal();
                try {

                    // Validate cardNumber (example)
                    String checkCardNumberQuery = "SELECT COUNT(*) FROM Login WHERE Card_Number = ?";
                    try (PreparedStatement checkCardNumberStmt = con.connection.prepareStatement(checkCardNumberQuery)) {
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
                    try (PreparedStatement selectStmt = con.connection.prepareStatement(selectQuery)) {
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
                            if (balance < Integer.parseInt(amount)) {
                                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                                return;
                            }
                        }
                    }

                    // Use PreparedStatement to prevent SQL injection in INSERT query
                    String insertQuery = "INSERT INTO Transactions (CardNumber, date, type, amount) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement insertStmt = con.connection.prepareStatement(insertQuery)) {
                        insertStmt.setString(1, cardNumber);
                        insertStmt.setString(2, String.valueOf(date));
                        insertStmt.setString(3, "Withdrawal"); // Assuming "Withdrawal" is the correct type
                        insertStmt.setString(4, amount);
                        insertStmt.executeUpdate();
                    }JOptionPane.showMessageDialog(null,"Rs. "+amount+"/- Debited Successfully");

                }
                catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(false);
        new HomePage(cardNumber);
    }


}
