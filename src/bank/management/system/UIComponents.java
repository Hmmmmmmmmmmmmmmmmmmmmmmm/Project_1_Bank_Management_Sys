package bank.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UIComponents {

    public static JLabel addLabel(JComponent parent, String text, String fontName, int fontStyle, int fontSize, int x, int y, boolean center, int width) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setForeground(Color.WHITE);

        label.setSize(label.getPreferredSize());
        if (center) {
            x = (parent.getWidth() - label.getWidth()) / 2;
        }

        label.setBounds(x, y, width, label.getHeight());
        parent.add(label);
        return label;
    }

    public static JTextField addLabelWithTextField(JComponent parent, String text, String fontName, int fontStyle, int fontSize,
                                                   int x, int y, int textFieldWidth, int textFieldHeight,
                                                   int labelWidth, int spacing) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, labelWidth, label.getHeight());
        parent.add(label);

        JTextField textField = new JTextField();
        textField.setFont(new Font(fontName, Font.BOLD, 16));
        textField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);
        makeRoundedTextField(textField, textFieldWidth, textFieldHeight, 20);
        parent.add(textField);

        return textField;
    }

    public static JPasswordField addLabelWithPasswordField(JComponent parent, String text, String fontName, int fontStyle, int fontSize,
                                                           int x, int y, int textFieldWidth, int textFieldHeight,
                                                           int labelWidth, int spacing) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, labelWidth, label.getHeight());
        parent.add(label);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font(fontName, Font.BOLD, 16));
        passwordField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);
        makeRoundedTextField(passwordField, textFieldWidth, textFieldHeight, 20);
        parent.add(passwordField);

        return passwordField;
    }

    public static JButton addRoundedButton(JComponent parent, String text, String fontName, int fontStyle, int fontSize,
                                           int x, int y, int width, int height, boolean opaque) {
        JButton button = new JButton(text);
        button.setFont(new Font(fontName, fontStyle, fontSize));
        button.setBounds(x, y, width, height);
        button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));

        if (!opaque) {
            button.setOpaque(false);
            button.setContentAreaFilled(false);
        } else {
            button.setOpaque(true);
            button.setBackground(new Color(50, 150, 250));
        }

        parent.add(button);
        return button;
    }

    public static void addImage(JComponent parent, ImageIcon imageIcon, int x, int y, int width, int height) {
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(x, y, width, height);
        parent.add(imageLabel);
    }

    public static void makeRoundedTextField(JComponent textField, int width, int height, int arc) {
        textField.setOpaque(false);
        textField.setBackground(Color.WHITE);
        textField.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(arc, Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }
}
