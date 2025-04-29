import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;

public class BalanceInquiryFinal extends FunctionsAndUI implements ActionListener {
        private final int opacityLevel = 200;

        //Objects:
        private ImageIcon logo;
        JTextField withdrawalAmount;
        private JButton withdrawalButton,BackButton;
        private JLabel balanceDisplay;

        String cardNumber;


        BalanceInquiryFinal(String cardNumber){
            super(1550,1080,"Main",false,-1,-1);
            this.cardNumber = cardNumber;
            addLabelWhichReturns("Your Current Balance is:", "Times New Roman Bold",
                    Font.PLAIN, 24,
                    430, 180, false, true,
                    255, 255, 255,true);


            balanceDisplay = addLabelWhichReturns("", "Times New Roman Bold",
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
            try {
                ConnectionFinal con = new ConnectionFinal();

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

                // Use PreparedStatement to prevent SQL injection
                String query = "SELECT * FROM Transactions WHERE CardNumber = ?";
                try (PreparedStatement pstmt = con.connection.prepareStatement(query)) {
                    pstmt.setString(1, cardNumber);
                    try (ResultSet resultSet = pstmt.executeQuery()) {
                        while (resultSet.next()) {
                            if (resultSet.getString("type").equals("Deposit")) {
                                balance += Integer.parseInt(resultSet.getString("amount"));
                            } else {
                                balance -= Integer.parseInt(resultSet.getString("amount"));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
            balanceDisplay.setText("" + numberFormat.format(balance));
            balanceDisplay.setSize(balanceDisplay.getPreferredSize()); // Add this line
            balanceDisplay.repaint(); // Add this line


            ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\atm2.png");
            addImage(backgroundImage, 0, 0, 1550, 830);
            setVisible(true);
        }

        public static void main(String[] args) {
            new BalanceInquiryFinal("");
        }

        @Override
        public void actionPerformed(ActionEvent b) {
            try {
                if (b.getSource() == BackButton) {
//                    System.exit(0);
                    setVisible(false);
                    new HomePage(cardNumber);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
