package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.NumberFormat;

public class MiniStatement extends UI2 implements ActionListener {
    String pin;
    JButton BackButton;
    MiniStatement(String pin){
        super(400,600,"MiniStatement",false,20,20);
        this.pin = pin;
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
                20, 140, false, true,
                255, 255, 255,true);

        JLabel label2=addLabelWhichReturns("Footprints and Trails",
                "Moment Vintage",Font.PLAIN, 22,
                100, 20, true, true,
                0, 0, 0,true);

        JLabel label3=addLabelWhichReturns("", "Georgia",
                Font.PLAIN, 18,
                20, 80, false, true,
                255, 255, 255,true);

        JLabel label4=addLabelWhichReturns("", "Georgia",
                Font.PLAIN, 18,
                20, 420, false, true,
                0, 0, 0,true);
        label1.repaint();
        label3.setSize(label3.getPreferredSize());
        Dimension d = label3.getPreferredSize();
        label3.setSize(d.width, 250);
        label3.repaint();

        label3.repaint();
        label4.repaint();

        try{
            ConnectionTrial con = new ConnectionTrial();
            ResultSet resultSet = con.statement.executeQuery("select * from login where PiN ='"+pin+"'");
            while(resultSet.next()){
                label3.setText("Card Number: "+resultSet.getString("Card_Number").substring(0,4)+"-XXXX-XXXX-"+resultSet.getString("Card_Number").substring(12));

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            int balance = 0;
            ConnectionTrial con = new ConnectionTrial();
            ResultSet resultSet = con.statement.executeQuery("select * from Deposit where Pin = '"+pin+"'");
            while (resultSet.next()) {
                label1.setText(label1.getText()+"<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><html>");
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            label4.setText("Current balance: "+nf.format(balance));
            label1.setSize(label1.getPreferredSize());
            label1.repaint();
            label3.setSize(label3.getPreferredSize());
            label3.repaint();
            label4.setSize(label4.getPreferredSize());
            label4.repaint();

        }catch (Exception e){
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
        new MiniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

    }
}
