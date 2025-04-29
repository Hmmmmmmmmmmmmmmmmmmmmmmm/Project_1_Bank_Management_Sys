import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.List;
import java.util.ArrayList;


public class MiniStatementFinal extends FunctionsAndUI implements ActionListener {
    String cardNumber;
    JButton BackButton;
    MiniStatementFinal(String cardNumber){
        super(400,600,"MiniStatement",false,20,20);
        this.cardNumber = cardNumber;
        try {
            GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\xtra\\Last_Chance\\BMS\\Additionals\\moment.vintage.ttf")));
        } catch (IOException | FontFormatException e) {
            //Handle exception
            e.printStackTrace();
        }
        getContentPane().setBackground(new Color(207,196,176));

        JLabel label1=addLabelWhichReturns("", "Georgia",
                Font.PLAIN, 13,
                5, 140, false, true,
                0, 0, 0,true);

        JLabel label2=addLabelWhichReturns("Footprints and Trails",
                "Moment Vintage",Font.PLAIN, 22,
                100, 20, true, true,
                0, 0, 0,true);

        JLabel label3=addLabelWhichReturns("", "Georgia",
                Font.PLAIN, 16,
                20, 90, false, true,
                0, 0, 0,true);

        JLabel label4=addLabelWhichReturns("", "Georgia",
                Font.PLAIN, 18,
                20, 420, false, true,
                0, 0, 0,true);
        label3.repaint();

//        label1.repaint();

//        label3.repaint();
        label4.repaint();
        //thisPOINT
        try {
            ConnectionFinal con = new ConnectionFinal();

            // Validate card number (same as before)
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
            // Now retrieve the actual card number string from the Login table
            // so we can display it in label3.
            String loginQuery = "SELECT Card_Number FROM Login WHERE Card_Number = ?";
            try (PreparedStatement loginStmt = con.connection.prepareStatement(loginQuery)) {
                loginStmt.setString(1, cardNumber);
                try (ResultSet rs = loginStmt.executeQuery()) {
                    if (rs.next()) {
                        String fullCard = rs.getString("Card_Number");
                        // Mask the middle digits
                        String masked = fullCard.substring(0,4) + "-XXXX-XXXX-" + fullCard.substring(12);
                        label3.setText("Card Number: " + masked);
                    }
                }
            }

            // 1) Query transactions in ascending order
            String query = "SELECT * FROM Transactions WHERE CardNumber = ? ORDER BY date ASC";
            List<TransactionEntry> entries = new ArrayList<>();
            int runningBalance = 0;

            try (PreparedStatement pstmt = con.connection.prepareStatement(query)) {
                pstmt.setString(1, cardNumber);
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    while (resultSet.next()) {
                        String type = resultSet.getString("type");
                        int amount = Integer.parseInt(resultSet.getString("amount"));

                        // Accumulate in ascending order
                        if ("Deposit".equals(type)) {
                            runningBalance += amount;
                        } else {
                            runningBalance -= amount;
                        }

                        entries.add(new TransactionEntry(
                                resultSet.getString("date"),
                                type,
                                amount,
                                runningBalance
                        ));
                    }
                }
            }

            if (!entries.isEmpty()) {
                // 2) Build HTML from oldest to newest (NO reversing)
                StringBuilder html = new StringBuilder();
                html.append("<html><body><table style='width:100%;'>");
                html.append("<tr><th>Date</th><th>Type</th><th>Amount</th><th>Balance</th></tr>");
                html.append("<tr><td colspan='4'><hr></td></tr>");

                for (TransactionEntry entry : entries) {
                    html.append("<tr>");
                    html.append("<td>").append(entry.date).append("</td>");
                    html.append("<td>").append(entry.type).append("</td>");
                    html.append("<td>").append(entry.amount).append("</td>");
                    html.append("<td>").append(entry.runningBalance).append("</td>");
                    html.append("</tr>");
                }

                html.append("</table></body></html>");
                label1.setText(html.toString());

                // 3) The final balance is the last transaction's runningBalance
                int finalBalance = entries.get(entries.size() - 1).runningBalance;
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                label4.setText("Current balance: " + nf.format(finalBalance));
            } else {
                label1.setText("No transactions found.");
                label4.setText("Current balance: " + NumberFormat.getCurrencyInstance().format(0));
            }

            // Resize labels if needed
            label1.setSize(label1.getPreferredSize());
            label4.setSize(label4.getPreferredSize());
            label1.repaint();
            label3.repaint();
            label4.repaint();
            label3.setSize(label3.getPreferredSize());
            label3.repaint();


        } catch (Exception e) {
            e.printStackTrace();
        }


        BackButton = addRoundedButton(
                "Exit", "Times New Roman", Font.BOLD, 18,
                20,500, 100, 40,
                false, true, 100,
                0, 0, 0,          // Base text color: black
                50, 50, 50,       // Base border color: dark gray
                95,77,57,    // Base background color: very light gray
                20                // Corner radius: 20
        );
        BackButton.addActionListener(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatementFinal("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

    }

}
class TransactionEntry {
    String date;
    String type;
    int amount;
    int runningBalance;

    public TransactionEntry(String date, String type, int amount, int runningBalance) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.runningBalance = runningBalance;
    }
}
