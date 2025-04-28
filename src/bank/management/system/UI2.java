//welcome to hell
//anything u change it will change everything except what u want to change
//everything going well?
//then u r not using it
//everything working as intended?
//then u r not dreaming
//total time wasted: 20hrs+

package bank.management.system;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.text.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UI2 extends JFrame {

    private int width, height;

    //constructor for all basic details required per page
    public UI2(){
        System.out.println("UI2 class called");
        setUndecorated(true);
    }
    public UI2(int width, int height, String title, boolean center) {
        this.width = width;
        this.height = height;

        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);

        // Centering the pop-up dynamically
        if(center){
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int centerX = (screenSize.width - width) / 2;
            int centerY = (screenSize.height - height) / 2;
            setLocation(centerX, centerY);
        }else{
            setLocation(0,0);
        }

    }
    public UI2(int width, int height, String title, boolean center,int x,int y) {
        this.width = width;
        this.height = height;

        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);

        // Centering the pop-up dynamically
        if(center){
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int centerX = (screenSize.width - width) / 2;
            int centerY = (screenSize.height - height) / 2;
            setLocation(centerX, centerY);
        }else{
            setLocation(x,y);
        }

    }
    //this function is used in SignUPNEW an additional
    // playground not in the main code



    protected JTextField addLabelWithTextField2(String text, String fontName, int fontStyle, int fontSize,
                                                int x, int y, int textFieldWidth, int textFieldHeight,
                                                int labelWidth, int spacing, boolean transparent,
                                                int opacityLevel, int textFieldX) {
        // Create label
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, labelWidth, textFieldHeight); // Label position and size
        add(label);
        //new label?


        // Create text field
        JTextField textField = new JTextField();
        textField.setFont(new Font(fontName, Font.BOLD, 16));

        // If textFieldX is provided (> 0), use it, else calculate as before
        int effectiveTextFieldX = (textFieldX > 0) ? textFieldX : x + labelWidth + spacing;
        textField.setBounds(effectiveTextFieldX, y, textFieldWidth, textFieldHeight);

        // Apply transparency settings
        makeRoundedTextField(textField, textFieldWidth, textFieldHeight, 20, transparent, opacityLevel);

        if (transparent) {
            textField.setOpaque(false);
            textField.setBackground(new Color(255, 255, 255, opacityLevel));
        }

        add(textField);
        return textField;
    }



    protected JPasswordField addLabelWithPasswordField2(String text, String fontName, int fontStyle, int fontSize,
                                                        int x, int y, int textFieldWidth, int textFieldHeight,
                                                        int labelWidth, int spacing, boolean transparent, int opacityLevel) {
        // Create label
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, labelWidth, textFieldHeight); // Ensuring label height matches text field
        add(label);

        // Create password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font(fontName, Font.BOLD, 16));
        passwordField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);

        // Apply transparency settings
        makeRoundedTextField(passwordField, textFieldWidth, textFieldHeight, 20, transparent, opacityLevel);

        if (transparent) {
            passwordField.setOpaque(false); // Set after applying styles
            passwordField.setBackground(new Color(255, 255, 255, opacityLevel));
        }

        add(passwordField);
        return passwordField;
    }


    //Image addition
    protected void addImage(ImageIcon imageIcon, int x, int y, int width, int height) {
        Image image = imageIcon.getImage();  // Get the Image from the ImageIcon
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);  // Resize the image
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledImageIcon); // Create JLabel to hold the image
        imageLabel.setBounds(x, y, width, height); // Set bounds for positioning
        add(imageLabel); // Add the label with the image to the window
    }//Image addition


    //Label
    protected void addLabel(String text, String fontName, int fontStyle, int fontSize, int x, int y, boolean center, boolean colorChange, String color) {
        JLabel label = new JLabel(text); //object thingy
        label.setFont(new Font(fontName, fontStyle, fontSize));//using parameters
        // Enable antialiasing for smoother text rendering
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Get preferred size
        Dimension size = label.getPreferredSize();

        // Add subtle padding dynamically (2-5px based on text length)
        int padding = Math.min(5, size.width / 20); // Scale padding based on text size

        // Apply an empty border for subtle spacing
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));

        // Adjust size with subtle padding
        label.setSize(size.width + padding * 2, size.height);

        // If centering is required
        if (center) {
            x = (width - label.getWidth()) / 2;
        }
        if (colorChange) {
            label.setForeground(Color.decode(color)); // Set font color
        }

        // Set final position
        //taking extra 5 px cuz no clue why the fuck it wont take it any other way!????
        label.setBounds(x, y, label.getWidth()+10, label.getHeight());
        add(label);
    }


    protected JTextField addLabelWithTextField2(String text, String fontName, int fontStyle, int fontSize,
                                                int x, int y, boolean colorChange, String color, int textFieldWidth, int textFieldHeight,
                                                int labelWidth, int spacing, boolean transparent,
                                                int opacityLevel, int textFieldX) {
        // Create label
        JLabel label = new JLabel(text); //object thingy
        label.setFont(new Font(fontName, fontStyle, fontSize));//using parameters
        // Enable antialiasing for smoother text rendering
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Get preferred size
        Dimension size = label.getPreferredSize();

        // Add subtle padding dynamically (2-5px based on text length)
        int padding = Math.min(2, size.width / 20); // Scale padding based on text size

        // Apply an empty border for subtle spacing
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));

        // Adjust size with subtle padding
        label.setSize(size.width + padding * 2, size.height);

        if (colorChange) {
            try {
                // Use reflection to convert the string to a Color object
                Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
                label.setForeground(labelColor);
            } catch (Exception e) {
                // Default to white if the color name is invalid
                label.setForeground(Color.WHITE);
                System.out.println("Invalid color name: " + color + ". Defaulting to white.");
            }
        }

        // Set final position
        //taking extra 5 px cuz no clue why the fuck it wont take it any other way!????
        label.setBounds(x, y, label.getWidth()+10, label.getHeight());
        add(label);


        // Create text field
        JTextField textField = new JTextField();
        textField.setFont(new Font(fontName, Font.BOLD, 16));

        // If textFieldX is provided (> 0), use it, else calculate as before
        int effectiveTextFieldX = (textFieldX > 0) ? textFieldX : x + labelWidth + spacing;
        textField.setBounds(effectiveTextFieldX, y, textFieldWidth, textFieldHeight);

        // Apply transparency settings
        makeRoundedTextField(textField, textFieldWidth, textFieldHeight, 20, transparent, opacityLevel);

        if (transparent) {
            textField.setOpaque(false);
            textField.setBackground(new Color(255, 255, 255, opacityLevel));
        }

        add(textField);
        return textField;
    }

    protected JPasswordField addLabelWithPasswordField2(String text, String fontName, int fontStyle, int fontSize,
                                                         int x, int y,boolean colorChange, String color, int textFieldWidth, int textFieldHeight,
                                                         int labelWidth, int spacing, boolean transparent, int opacityLevel) {
        // Create label
        JLabel label = new JLabel(text); //object thingy
        label.setFont(new Font(fontName, fontStyle, fontSize));//using parameters
        // Enable antialiasing for smoother text rendering
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Get preferred size
        Dimension size = label.getPreferredSize();

        // Add subtle padding dynamically (2-5px based on text length)
        int padding = Math.min(5, size.width / 20); // Scale padding based on text size

        // Apply an empty border for subtle spacing
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));

        // Adjust size with subtle padding
        label.setSize(size.width + padding * 2, size.height);

        if (colorChange) {
            try {
                // Use reflection to convert the string to a Color object
                Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
                label.setForeground(labelColor);
            } catch (Exception e) {
                // Default to white if the color name is invalid
                label.setForeground(Color.WHITE);
                System.out.println("Invalid color name: " + color + ". Defaulting to white.");
            }
        }

        // Set final position
        //taking extra 5 px cuz no clue why the fuck it wont take it any other way!????
        label.setBounds(x, y, label.getWidth()+5, label.getHeight());
        add(label);


        // Create password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font(fontName, Font.BOLD, 16));
        passwordField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);

        // Apply transparency settings
        makeRoundedTextField(passwordField, textFieldWidth, textFieldHeight, 20, transparent, opacityLevel);

        if (transparent) {
            passwordField.setOpaque(false); // Set after applying styles
            passwordField.setBackground(new Color(255, 255, 255, opacityLevel));
        }

        add(passwordField);
        return passwordField;
    }

    protected void addLabelWithRadioButton2(String text, String fontName, int fontStyle, int fontSize,
                                            int x, int y, int labelWidth, int radioFontSize,
                                            int rx1, int ry1, int rx2, int ry2,
                                            int radioWidth, int radioHeight, int radioWidth2,
                                            String radioButtonLabel1, String radioButtonLabel2,
                                            boolean transparent, int opacityLevel) {
        // Create label
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setForeground(Color.WHITE);
        label.setSize(labelWidth, label.getPreferredSize().height);
        label.setBounds(x, y, labelWidth, label.getHeight());
        add(label);

        // Create radio buttons
        JRadioButton r1 = new JRadioButton(radioButtonLabel1);
        r1.setFont(new Font(fontName, fontStyle, radioFontSize));
        r1.setBounds(rx1, ry1, radioWidth, radioHeight);
        r1.setForeground(Color.BLACK);

        JRadioButton r2 = new JRadioButton(radioButtonLabel2);
        r2.setFont(new Font(fontName, fontStyle, radioFontSize));
        r2.setBounds(rx2, ry2, radioWidth2, radioHeight);
        r2.setForeground(Color.BLACK);

        // Apply transparency only if needed
        if (transparent) {
            makeTransparentRadioButton(r1, transparent, opacityLevel);
            makeTransparentRadioButton(r2, transparent, opacityLevel);
        }

        add(r1);
        add(r2);

        // Group buttons so only one can be selected at a time
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
    }


    protected JDateChooser addLabelWithTextFieldWithCalendar2(String text, String fontName, int fontStyle, int fontSize,
                                                             int x, int y, int textFieldWidth, int textFieldHeight,
                                                             int labelWidth, int spacing, boolean transparent, int opacityLevel) {
        // Create label
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setForeground(Color.WHITE);
        label.setSize(labelWidth, label.getPreferredSize().height);
        label.setBounds(x, y, labelWidth, label.getHeight());
        add(label);

        // Load calendar icon
        ImageIcon calendarIcon = new ImageIcon(new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\calendar.png")
                .getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));

        // Create JDateChooser
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setFont(new Font(fontName, Font.BOLD, 16));
        dateChooser.setBounds(x + spacing, y, textFieldWidth, textFieldHeight);
        dateChooser.setBorder(null);

        // Apply transparency settings
        if (transparent) {
            dateChooser.setOpaque(false);
            dateChooser.setBackground(new Color(255, 255, 255, opacityLevel));
        } else {
            dateChooser.setOpaque(true);
            dateChooser.setBackground(Color.WHITE);
        }

        // Get internal JTextField and apply transparency
        JTextField editor = (JTextField) dateChooser.getDateEditor().getUiComponent();
        if (transparent) {
            editor.setOpaque(false);
            editor.setBackground(new Color(255, 255, 255, opacityLevel));
        }
        editor.setBorder(null);
        editor.setForeground(Color.WHITE);
        editor.setCaretColor(Color.WHITE);

        // Get calendar button
        JButton calendarButton = dateChooser.getCalendarButton();
        calendarButton.setIcon(calendarIcon);
        calendarButton.setOpaque(false);
        calendarButton.setContentAreaFilled(false);
        calendarButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        calendarButton.setMargin(new Insets(2, 2, 2, 2));
        calendarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Ensure the button is correctly positioned within the layout
        calendarButton.setFocusable(false);
        editor.setFocusable(true);

        // Force UI refresh
        SwingUtilities.invokeLater(() -> {
            dateChooser.updateUI();
            dateChooser.revalidate();
            dateChooser.repaint();
        });

        // 🔥 **Call makeRoundedCalendarField to apply the border**
        makeRoundedCalendarField(dateChooser, textFieldWidth, textFieldHeight, 20, transparent, opacityLevel);

        add(dateChooser);
        return dateChooser;
    }
    //this bitch
    protected JDateChooser addLabelWithTextFieldWithCalender(String text, String fontName, int fontStyle, int fontSize,
                                                             int x, int y,boolean colorChange, String color, int textFieldWidth, int textFieldHeight,
                                                             int labelWidth, int spacing) {
        // Create label
        JLabel label = new JLabel(text); //object thingy
        label.setFont(new Font(fontName, fontStyle, fontSize));//using parameters
        // Enable antialiasing for smoother text rendering
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Get preferred size
        Dimension size = label.getPreferredSize();

        // Add subtle padding dynamically (2-5px based on text length)
        int padding = Math.min(5, size.width / 20); // Scale padding based on text size

        // Apply an empty border for subtle spacing
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));

        // Adjust size with subtle padding
        label.setSize(size.width + padding * 2, size.height);

        if (colorChange) {
            try {
                // Use reflection to convert the string to a Color object
                Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
                label.setForeground(labelColor);
            } catch (Exception e) {
                // Default to white if the color name is invalid
                label.setForeground(Color.WHITE);
                System.out.println("Invalid color name: " + color + ". Defaulting to white.");
            }
        }

        // Set final position
        //taking extra 5 px cuz no clue why the fuck it wont take it any other way!????
        label.setBounds(x, y, label.getWidth()+5, label.getHeight());
        add(label);

        //icon for calender!!!!!
        ImageIcon calendarIcon = new ImageIcon(new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\calendar.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));

// Create JDateChooser
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setFont(new Font(fontName, Font.BOLD, 16));
        dateChooser.setBounds(x + spacing, y, textFieldWidth, textFieldHeight);

// Remove border & background
        dateChooser.setBorder(null);
        dateChooser.setOpaque(false);
        dateChooser.setBackground(new Color(0, 0, 0, 0));

// Get internal JTextField and make it transparent
        JTextField editor = (JTextField) dateChooser.getDateEditor().getUiComponent();
        editor.setOpaque(false);
        editor.setBackground(new Color(0, 0, 0, 0));
        editor.setBorder(null);
        editor.setForeground(Color.WHITE);
        editor.setCaretColor(Color.WHITE); // Ensure cursor is visible

// Get the calendar button
        JButton calendarButton = dateChooser.getCalendarButton();
        calendarButton.setIcon(calendarIcon);
        calendarButton.setOpaque(false);
        calendarButton.setContentAreaFilled(false);
        calendarButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // Adjust outer spacing
        calendarButton.setMargin(new Insets(2, 2, 2, 2)); // Adjust padding inside the button
        calendarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

// Ensure the button is correctly positioned within the layout
        calendarButton.setFocusable(false);
        editor.setFocusable(true);

// Force UI refresh
        SwingUtilities.invokeLater(() -> {
            dateChooser.updateUI();
            dateChooser.revalidate();
            dateChooser.repaint();
        });
        // Apply rounded border
        makeRoundedCalenderField(dateChooser, textFieldWidth, textFieldHeight, 20);

        add(dateChooser);
        return dateChooser;
    } // uses another function to make the things rounded! aka

    protected JDateChooser addLabelWithTextFieldWithCalender2(String text, String fontName, int fontStyle, int fontSize,
                                                             int x, int y, boolean colorChange, String color, int textFieldWidth, int textFieldHeight,
                                                             int labelWidth, int spacing, boolean opaque, float opacityLevel) { // Added opacity parameters

        JLabel label = new JLabel(text); //object thingy
        label.setFont(new Font(fontName, fontStyle, fontSize));//using parameters
        // Enable antialiasing for smoother text rendering
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Get preferred size
        Dimension size = label.getPreferredSize();

        // Add subtle padding dynamically (2-5px based on text length)
        int padding = Math.min(5, size.width / 20); // Scale padding based on text size

        // Apply an empty border for subtle spacing
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));

        // Adjust size with subtle padding
        label.setSize(size.width + padding * 2, size.height);

        if (colorChange) {
            try {
                // Use reflection to convert the string to a Color object
                Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
                label.setForeground(labelColor);
            } catch (Exception e) {
                // Default to white if the color name is invalid
                label.setForeground(Color.WHITE);
                System.out.println("Invalid color name: " + color + ". Defaulting to white.");
            }
        }

        // Set final position
        //taking extra 5 px cuz no clue why the fuck it wont take it any other way!????
        label.setBounds(x, y, label.getWidth()+5, label.getHeight());
        add(label);

        //icon for calender!!!!!
        ImageIcon calendarIcon = new ImageIcon(new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\calendar.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));

        //adding this here:
        // 🎨 Custom Panel for Rounded Background
        JPanel dateChooserPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Apply semi-transparent background with rounded edges
                if (!opaque) {
                    g2.setColor(new Color(255, 255, 255, (int) (opacityLevel * 255))); // Dynamic opacity
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Rounded fill
                }

                g2.dispose();
            }
        };
        dateChooserPanel.setLayout(null);
        dateChooserPanel.setBounds(x + spacing, y, textFieldWidth, textFieldHeight);
        dateChooserPanel.setOpaque(false);

        // Create JDateChooser
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setFont(new Font(fontName, Font.BOLD, 16));
        dateChooser.setBounds(x + spacing, y, textFieldWidth, textFieldHeight);

// Remove border & background
        dateChooser.setBorder(null);
        dateChooser.setOpaque(false);
        dateChooser.setBackground(new Color(0, 0, 0, 0));

// Get internal JTextField and make it transparent
        JTextField editor = (JTextField) dateChooser.getDateEditor().getUiComponent();
        editor.setOpaque(false);
        editor.setBackground(new Color(0, 0, 0, 0));
        editor.setBorder(null);
        editor.setForeground(Color.WHITE);
        editor.setCaretColor(Color.WHITE); // Ensure cursor is visible

// Get the calendar button
        JButton calendarButton = dateChooser.getCalendarButton();
        calendarButton.setIcon(calendarIcon);
        calendarButton.setOpaque(false);
        calendarButton.setContentAreaFilled(false);
        calendarButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // Adjust outer spacing
        calendarButton.setMargin(new Insets(2, 2, 2, 2)); // Adjust padding inside the button
        calendarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

// Ensure the button is correctly positioned within the layout
        calendarButton.setFocusable(false);
        editor.setFocusable(true);

// Force UI refresh
        SwingUtilities.invokeLater(() -> {
            dateChooser.updateUI();
            dateChooser.revalidate();
            dateChooser.repaint();
        });
        // Apply rounded border
        makeRoundedCalenderField(dateChooser, textFieldWidth, textFieldHeight, 20);

        add(dateChooser);
        return dateChooser;
    } // uses another function to make the things rounded! aka


    //    protected JButton addRoundedButton(String text, String fontName, int fontStyle, int fontSize,
//                                       int x, int y, int width, int height, boolean opaque, boolean transparent, int opacityLevel) {
//        JButton button = new JButton(text);
//        button.setFont(new Font(fontName, fontStyle, fontSize));
//        button.setBounds(x, y, width, height);
//
//        // Define colors
//        Color normalColor = new Color(50, 150, 250);
//        Color hoverColor = new Color(30, 130, 230);
//        Color clickColor = new Color(20, 100, 200);
//
//        // Set transparency based on parameters
//        if (transparent) {
//            button.setOpaque(false);
//            button.setContentAreaFilled(false);
//            button.setBackground(new Color(255, 255, 255, opacityLevel));
//        } else {
//            button.setOpaque(true);
//            button.setContentAreaFilled(true);
//            button.setBackground(normalColor);
//        }
//
//        // Set the rounded border
//        button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
//        button.setFocusPainted(false);
//
//        // Hover & Click Effect
//        button.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                button.setBorder(new RoundedBorder(20, hoverColor));
//                button.setForeground(Color.WHITE);
//            }
//
//            @Override
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
//            }
//
//            @Override
//            public void mousePressed(java.awt.event.MouseEvent evt) {
//                button.setBorder(new RoundedBorder(20, clickColor));
//                if (!transparent) {
//                    button.setBackground(clickColor);
//                }
//            }
//
//            @Override
//            public void mouseReleased(java.awt.event.MouseEvent evt) {
//                if (button.getBounds().contains(evt.getPoint())) {
//                    button.setBorder(new RoundedBorder(20, hoverColor));
//                    if (!transparent) {
//                        button.setBackground(hoverColor);
//                    }
//                } else {
//                    button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
//                    if (!transparent) {
//                        button.setBackground(normalColor);
//                    }
//                }
//                if (transparent) {
//                    button.setOpaque(false);
//                }
//                button.repaint();
//            }
//        });
//
//        button.setForeground(Color.WHITE);
//        add(button);
//        return button;
//    }
//
    protected JButton addRoundedButton(String text, String fontName, int fontStyle, int fontSize,
                                       int x, int y, int width, int height, boolean opaque,
                                       boolean transparent, int opacityLevel) {
        JButton button = new JButton(text);
        button.setFont(new Font(fontName, fontStyle, fontSize));
//        button.setFont(new Font(fontName, fontStyle, fontSize));
        button.setBounds(x, y, width, height);

        // Define colors
        Color normalColor = new Color(50, 150, 250);
        Color hoverColor = new Color(30, 130, 230);
        Color clickColor = new Color(20, 100, 200);

        // Set transparency based on parameters
        if (transparent) {
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBackground(new Color(255, 255, 255, opacityLevel)); // Semi-transparent
        } else {
            button.setOpaque(true);
            button.setContentAreaFilled(true);
            button.setBackground(Color.LIGHT_GRAY);
        }

        // Set the rounded border
        button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
        button.setFocusPainted(false); // Remove the white focus box

        // Hover & Click Effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBorder(new RoundedBorder(20, hoverColor));
                button.setForeground(hoverColor);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBorder(new RoundedBorder(20, Color.BLACK));
                button.setForeground(Color.BLACK);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                button.setBorder(new RoundedBorder(20, clickColor));
                if (!transparent) {
                    button.setBackground(clickColor);
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (button.getBounds().contains(evt.getPoint())) {
                    button.setBorder(new RoundedBorder(20, hoverColor));
                    if (!transparent) {
                        button.setBackground(hoverColor);
                    }
                } else {
                    button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
                    if (!transparent) {
                        button.setBackground(normalColor);
                    }
                }
                if (transparent) {
                    button.setOpaque(false);
                }
                button.repaint();
            }
        });

        button.setForeground(Color.BLACK);
        add(button);
        return button;
    }




    protected JRadioButton createRadioButton(String text, String fontName, int fontStyle, int fontSize,
                                             int x, int y, int width, int height, Color textColor) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setFont(new Font(fontName, fontStyle, fontSize));
        radioButton.setBounds(x, y, width, height);
        radioButton.setForeground(textColor);
        styleCustomRadioButton(radioButton);
        add(radioButton);// Apply existing styling
        return radioButton;
    }



    protected void applyInputFilter(JTextComponent field, String regexField, String warningMsg, String hardRegex) {
        // Real-time input filter
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches(regexField) || newText.isEmpty()) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Small feedback for invalid input
                }
            }
        });
//uncomment below for msg annoyance!!!!
        // Focus Listener to show warning if needed
//        field.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusLost(FocusEvent e) {
//                String input = field.getText().trim();
//                if (!input.matches(hardRegex)) {
//                    JOptionPane.showMessageDialog(null, warningMsg, "Warning", JOptionPane.WARNING_MESSAGE);
//                }
//            }
//        });

    }
    protected void applyInputFilter(JPasswordField field, String regexField, String warningMsg, String hardRegex) {
        // Real-time input filter
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches(regexField) || newText.isEmpty()) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Small feedback for invalid input
                }
            }
        });

        // Focus Listener to show warning if needed
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String input = field.getText().trim();
                if (!input.matches(hardRegex)) {
                    JOptionPane.showMessageDialog(null, warningMsg, "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }

//    protected JButton addRoundedButton(String text, String fontName, int fontStyle, int fontSize,
//                                       int x, int y, int width, int height, boolean opaque, int opacityLevel) {
//        JButton button = new JButton(text);
//        button.setFont(new Font(fontName, fontStyle, fontSize));
//        button.setBounds(x, y, width, height);
//
//        // Define colors
//        Color normalColor = new Color(50, 150, 250);
//        Color hoverColor = new Color(30, 130, 230);
//        Color clickColor = new Color(20, 100, 200);
//
//        // Set transparency properly
//        if (!opaque) {
//            button.setOpaque(false);
//            button.setContentAreaFilled(false);
//
//            // 🟢 **Enable semi-transparency** (Comment this out if you want full transparency)
//            button.setBackground(new Color(50, 150, 250, opacityLevel)); // Adjust transparency
//        } else {
//            button.setOpaque(true);
//            button.setContentAreaFilled(true);
//            button.setBackground(normalColor);
//        }
//
//        // Set the rounded border
//        button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
//
//        // Remove the annoying white focus box
//        button.setFocusPainted(false);
//
//        // Hover & Click Effect
//        button.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                button.setBorder(new RoundedBorder(20, hoverColor)); // Change border color
//                button.setForeground(Color.WHITE); // Ensure text is visible
//            }
//
//            @Override
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                button.setBorder(new RoundedBorder(20, Color.DARK_GRAY)); // Revert border color
//            }
//
//            @Override
//            public void mousePressed(java.awt.event.MouseEvent evt) {
//                button.setBorder(new RoundedBorder(20, clickColor)); // Darker border on click
//
//                if (opaque) {
//                    button.setBackground(clickColor); // Change background only if opaque
//                } else {
//                    button.setForeground(new Color(200, 200, 200)); // Dim text for transparent button
//
//                    // 🟢 **Apply temporary solid color effect on click** (Comment out for full transparency)
//                    button.setBackground(new Color(20, 100, 200, opacityLevel));
//                }
//                button.setOpaque(true);
//                button.repaint();
//            }
//
//            @Override
//            public void mouseReleased(java.awt.event.MouseEvent evt) {
//                if (button.getBounds().contains(evt.getPoint())) {
//                    button.setBorder(new RoundedBorder(20, hoverColor)); // Return to hover color
//
//                    if (opaque) {
//                        button.setBackground(hoverColor); // Keep hover color if opaque
//                    } else {
//                        button.setForeground(Color.WHITE); // Reset text for transparent button
//
//                        // 🟢 **Restore semi-transparency after click** (Comment out for full transparency)
//                        button.setBackground(new Color(50, 150, 250, opacityLevel));
//                    }
//                } else {
//                    button.setBorder(new RoundedBorder(20, Color.DARK_GRAY)); // Reset border
//
//                    if (opaque) {
//                        button.setBackground(normalColor); // Reset background
//                    } else {
//                        button.setForeground(Color.WHITE); // Reset text color
//
//                        // 🟢 **Restore semi-transparency after click** (Comment out for full transparency)
//                        button.setBackground(new Color(50, 150, 250, opacityLevel));
//                    }
//                }
//
//                // 🔥 **Restore transparency if needed**
//                if (!opaque) {
//                    button.setOpaque(false);
//                }
//                button.repaint();
//            }
//        });
//
//        button.setForeground(Color.WHITE); // Text color
//        add(button);
//        return button;
//    }
    protected JComboBox<String> addLabelWithDropdown(String text, String fontName, int fontStyle, int fontSize,
                                                     int x, int y, boolean colorChange, String color,
                                                     int dropdownWidth, int dropdownHeight,
                                                     int labelWidth, int spacing,
                                                     String[] options, boolean opaque, float opacityLevel) {

        // 🔖 Create Label
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Dynamic Padding
        Dimension size = label.getPreferredSize();
        int padding = Math.min(5, size.width / 20);
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
        label.setSize(size.width + padding * 2, size.height);

        // Color Management
        if (colorChange) {
            try {
                Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
                label.setForeground(labelColor);
            } catch (Exception e) {
                label.setForeground(Color.WHITE);
                System.out.println("Invalid color name: " + color + ". Defaulting to white.");
            }
        }

        // Positioning the Label
        label.setBounds(x, y, label.getWidth() + 5, label.getHeight());
        add(label);
        // Optional: Load a custom arrow icon (like the calendar icon)
        ImageIcon arrowIcon = new ImageIcon(
                new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\arrowDown.png")
                        .getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH)
        );
// Create the JComboBox
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(new Font(fontName, Font.BOLD, fontSize));
        comboBox.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);

// Force heavyweight popup to avoid layering artifacts
        comboBox.setLightWeightPopupEnabled(false);

// Make main combo box transparent
        comboBox.setOpaque(false);
        comboBox.setBackground(new Color(0, 0, 0, 0));
        comboBox.setForeground(Color.WHITE);
        comboBox.setBorder(null);
        comboBox.setFocusable(true);  // Keep focusable if you want keyboard navigation

// Transparent arrow button (optional)
        JButton arrowButton = (JButton) comboBox.getComponent(0);
        arrowButton.setOpaque(false);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        arrowButton.setMargin(new Insets(2, 2, 2, 2));
        arrowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        arrowButton.setFocusPainted(false);

// Custom renderer for items
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                renderer.setFont(new Font(fontName, Font.PLAIN, fontSize));

                // Use a solid background to avoid ghosting/layering artifacts
                if (isSelected) {
                    renderer.setBackground(new Color(50, 50, 50)); // Solid gray for selected item
                    renderer.setForeground(Color.YELLOW);
                    renderer.setOpaque(true);
                } else {
                    renderer.setBackground(new Color(30, 30, 30)); // Slightly lighter gray for non-selected
                    renderer.setForeground(Color.WHITE);
                    renderer.setOpaque(true);
                }
                return renderer;
            }
        });

// Force UI refresh (like the calendar approach)
        SwingUtilities.invokeLater(() -> {
            comboBox.updateUI();
            comboBox.revalidate();
            comboBox.repaint();
        });

// Apply a rounded border, just like `makeRoundedCalenderField`
        makeRoundedComboBox(comboBox, dropdownWidth, dropdownHeight, 20);

        add(comboBox);
        return comboBox;

//        // Create the JComboBox
//        JComboBox<String> comboBox = new JComboBox<>(options);
//        comboBox.setFont(new Font(fontName, fontStyle, fontSize));
//        comboBox.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);
//
//// Remove border & background
//        comboBox.setBorder(null);
//        comboBox.setOpaque(false);
//        comboBox.setBackground(new Color(0, 0, 0, 0));
//        comboBox.setForeground(Color.WHITE);
//        comboBox.setFocusable(false);
//
//// Custom renderer for transparency and custom item colors
//        comboBox.setRenderer(new DefaultListCellRenderer() {
//            @Override
//            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//                renderer.setOpaque(isSelected); // Make the selected item opaque only
//                renderer.setFont(new Font(fontName, fontStyle, fontSize));
//                renderer.setForeground(isSelected ? Color.YELLOW : Color.WHITE);
//                renderer.setBackground(isSelected ? new Color(0, 0, 0, 150) : new Color(0, 0, 0, 0)); // Transparent bg
//                return renderer;
//            }
//        });
//
//// Transparent arrow button
//        JButton arrowButton = (JButton) comboBox.getComponent(0);
//        arrowButton.setOpaque(false);
//        arrowButton.setContentAreaFilled(false);
//        arrowButton.setBorder(BorderFactory.createEmptyBorder());
//        arrowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//
//// Apply rounded border using the existing helper function
//        makeRoundedComboBox(comboBox, dropdownWidth, dropdownHeight, 20);
//
//        add(comboBox);
//        return comboBox;


    }

    protected JComboBox<String> addLabelWithDropdown3(String text, String fontName, int fontStyle, int fontSize,
                                                     int x, int y, boolean colorChange, String color,
                                                     int dropdownWidth, int dropdownHeight,
                                                     int labelWidth, int spacing,
                                                     String[] options, boolean opaque, float opacityLevel) {

        // 🔖 Create Label
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Dynamic Padding
        Dimension size = label.getPreferredSize();
        int padding = Math.min(5, size.width / 20);
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
        label.setSize(size.width + padding * 2, size.height);

        // Color Management
        if (colorChange) {
            try {
                Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
                label.setForeground(labelColor);
            } catch (Exception e) {
                label.setForeground(Color.WHITE);
                System.out.println("Invalid color name: " + color + ". Defaulting to white.");
            }
        }

        // Positioning the Label
        label.setBounds(x, y, label.getWidth() + 5, label.getHeight());
        add(label);

        // Optional: Load a custom arrow icon (like the calendar icon)
        ImageIcon arrowIcon = new ImageIcon(new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\arrowDown.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));

        // Create the JComboBox
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(new Font(fontName, Font.BOLD, fontSize));
        comboBox.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);

        // Force heavyweight popup to avoid layering artifacts
        comboBox.setLightWeightPopupEnabled(false);

        // Make main combo box transparent
        comboBox.setOpaque(false);
        comboBox.setBackground(new Color(0, 0, 0, 0));
        //comboBox.setForeground(Color.WHITE);
        comboBox.setBorder(null);
        comboBox.setFocusable(true);  // Keep focusable if you want keyboard navigation

        //Transparent arrow button
        JButton arrowButton = (JButton) comboBox.getComponent(0);
        arrowButton.setIcon(arrowIcon);
        arrowButton.setOpaque(false);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        arrowButton.setMargin(new Insets(2, 2, 2, 2));
        arrowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        arrowButton.setFocusPainted(false);
         // Force UI refresh (like the calendar approach)
         SwingUtilities.invokeLater(() -> {
             comboBox.updateUI();
             comboBox.revalidate();
             comboBox.repaint();
         });

// Custom renderer for items
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                renderer.setFont(new Font(fontName, Font.PLAIN, fontSize));

                // Use a solid background to avoid ghosting/layering artifacts
                if (isSelected) {
                    renderer.setBackground(new Color(50, 50, 50)); // Solid gray for selected item
                    renderer.setForeground(Color.YELLOW);
                    renderer.setOpaque(true);
                } else {
                    renderer.setBackground(new Color(30, 30, 30)); // Slightly lighter gray for non-selected
                    renderer.setForeground(Color.WHITE);
                    renderer.setOpaque(true);
                }
                return renderer;
            }
        });



// Apply a rounded border, just like `makeRoundedCalenderField`
        makeRoundedComboBox(comboBox, dropdownWidth, dropdownHeight, 20);

        add(comboBox);
        return comboBox;

    }

    protected JComboBox<String> addLabelWithDropdown2(String text, String fontName, int fontStyle, int fontSize,
                                                     int x, int y, boolean colorChange, String color,
                                                     int dropdownWidth, int dropdownHeight,
                                                     int labelWidth, int spacing,
                                                     String[] options, boolean opaque, float opacityLevel) {

        // 🔖 Create Label
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Dynamic Padding
        Dimension size = label.getPreferredSize();
        int padding = Math.min(5, size.width / 20);
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
        label.setSize(size.width + padding * 2, size.height);

        // Color Management
        if (colorChange) {
            try {
                Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
                label.setForeground(labelColor);
            } catch (Exception e) {
                label.setForeground(Color.WHITE);
                System.out.println("Invalid color name: " + color + ". Defaulting to white.");
            }
        }

        // Positioning the Label
        label.setBounds(x, y, label.getWidth() + 5, label.getHeight());
        add(label);
        // icon path:
        // C:\xtra\Last_Chance\BMS\src\icons\arrow2.png

        // Create the JComboBox
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(new Font(fontName, Font.PLAIN, 18)); // Set combo box text to size 18
        comboBox.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);

// Force heavyweight popup to avoid layering artifacts
        comboBox.setLightWeightPopupEnabled(false);

// Main combo box: transparent
        comboBox.setOpaque(false);
        comboBox.setBackground(new Color(0, 0, 0, 0));
        comboBox.setForeground(Color.BLACK); // Black text
        comboBox.setBorder(null);
        comboBox.setFocusable(true); // Keep focusable if you want keyboard navigation

// Arrow button transparent (with your arrow2 icon)
        JButton arrowButton = (JButton) comboBox.getComponent(0);
        arrowButton.setOpaque(false);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setBorder(BorderFactory.createEmptyBorder());
        arrowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        arrowButton.setFocusPainted(false);

        ImageIcon arrowIcon = new ImageIcon(
                new ImageIcon("")
                        .getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH)
        );
        arrowButton.setIcon(arrowIcon);

// Simple item renderer: white background, black text
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                renderer.setFont(new Font(fontName, Font.PLAIN, 18)); // Item text also size 18
                renderer.setOpaque(true);

                if (isSelected) {
                    renderer.setBackground(Color.LIGHT_GRAY);
                    renderer.setForeground(Color.BLACK);
                } else {
                    renderer.setBackground(Color.WHITE);
                    renderer.setForeground(Color.BLACK);
                }
                return renderer;
            }
        });

// Avoid updateUI() to prevent NullPointerException
        comboBox.revalidate();
        comboBox.repaint();

// Apply a compound border for a rounded outline + inner horizontal padding
        comboBox.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
//        comboBox.setBorder(BorderFactory.createCompoundBorder(
//                new RoundedBorder(20, Color.DARK_GRAY),  // Outer rounded border
//                BorderFactory.createEmptyBorder(0, 10, 0, 10) // No top/bottom padding, 10 left/right
//        ));

        add(comboBox);
        return comboBox;
//        // Create the JComboBox
//        JComboBox<String> comboBox = new JComboBox<>(options);
//        comboBox.setFont(new Font(fontName, Font.BOLD, fontSize));
//        comboBox.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);
//
//// Force heavyweight popup to avoid layering artifacts
//        comboBox.setLightWeightPopupEnabled(false);
//
//// Main combo box: transparent
//        comboBox.setOpaque(false);
//        comboBox.setBackground(new Color(0, 0, 0, 0));
//        comboBox.setForeground(Color.BLACK);  // Black text
//        comboBox.setBorder(null);
//        comboBox.setFocusable(true);
//
//// Arrow button transparent
//        JButton arrowButton = (JButton) comboBox.getComponent(0);
//        arrowButton.setOpaque(false);
//        arrowButton.setContentAreaFilled(false);
//        arrowButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
//        arrowButton.setMargin(new Insets(2, 2, 2, 2));
//        arrowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        arrowButton.setFocusPainted(false);
//
//// (Optional) Custom arrow icon
//        ImageIcon arrowIcon = new ImageIcon(
//                new ImageIcon("")
////                new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\arrow2.png")
//                        .getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH)
//        );
//        arrowButton.setIcon(arrowIcon);
//
//// Simple item renderer: white background, black text
//        comboBox.setRenderer(new DefaultListCellRenderer() {
//            @Override
//            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//                renderer.setFont(new Font(fontName, Font.PLAIN, 18));
//                renderer.setOpaque(true);
//
//                if (isSelected) {
//                    renderer.setBackground(Color.LIGHT_GRAY);
//                    renderer.setForeground(Color.BLACK);
//                } else {
//                    renderer.setBackground(Color.WHITE);
//                    renderer.setForeground(Color.BLACK);
//                }
//                return renderer;
//            }
//        });
//
//// **Do NOT call comboBox.updateUI()** - it can cause the NullPointerException
//// Just do a simple revalidate/repaint if needed:
//        comboBox.revalidate();
//        comboBox.repaint();
//
//// Apply a simple compound border for rounded corners
//        comboBox.setBorder(BorderFactory.createCompoundBorder(
//                new RoundedBorder(20, Color.DARK_GRAY),            // Outer rounded border
//                BorderFactory.createEmptyBorder(0, 10, 0, 10)      // Inner padding
//        ));
//
//        add(comboBox);
//        return comboBox;


    }

    protected JComboBox<String> addLabelWithDropdown5(String text, String fontName, int fontStyle, int fontSize,
                                                     int x, int y, boolean colorChange, String color,
                                                     int dropdownWidth, int dropdownHeight,
                                                     int labelWidth, int spacing,
                                                     String[] options, boolean opaque, float opacityLevel) {

        // 🔖 Create Label
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Dynamic Padding
        Dimension size = label.getPreferredSize();
        int padding = Math.min(5, size.width / 20);
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
        label.setSize(size.width + padding * 2, size.height);

        // Color Management
        if (colorChange) {
            try {
                Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
                label.setForeground(labelColor);
            } catch (Exception e) {
                label.setForeground(Color.WHITE);
                System.out.println("Invalid color name: " + color + ". Defaulting to white.");
            }
        }

        // Positioning the Label
        label.setBounds(x, y, label.getWidth() + 5, label.getHeight());
        add(label);
        // icon path:
        // C:\xtra\Last_Chance\BMS\src\icons\arrow2.png

        // Create the JComboBox
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(new Font(fontName, Font.BOLD, fontSize));
        comboBox.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);

// Force heavyweight popup to avoid layering artifacts
        comboBox.setLightWeightPopupEnabled(false);

// Main combo box: transparent
        comboBox.setOpaque(false);
        comboBox.setBackground(new Color(0, 0, 0, 0));
        comboBox.setForeground(Color.BLACK);
        comboBox.setBorder(null);
        comboBox.setFocusable(true);

// Arrow button transparent with your arrow2 icon
        JButton arrowButton = (JButton) comboBox.getComponent(0);
        arrowButton.setOpaque(false);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        arrowButton.setMargin(new Insets(2, 2, 2, 2));
        arrowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        arrowButton.setFocusPainted(false);

        ImageIcon arrowIcon = new ImageIcon(
                new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\arrow2.png")
                        .getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH)
        );
        arrowButton.setIcon(arrowIcon);

// Simple item renderer: solid white background, black text
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                renderer.setFont(new Font(fontName, Font.PLAIN, 18));
                renderer.setOpaque(true);
                if (isSelected) {
                    renderer.setBackground(Color.LIGHT_GRAY);
                    renderer.setForeground(Color.BLACK);
                } else {
                    renderer.setBackground(Color.WHITE);
                    renderer.setForeground(Color.BLACK);
                }
                return renderer;
            }
        });

// Remove the white rectangle by overriding paintCurrentValueBackground only
        comboBox.setUI(new BasicComboBoxUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                super.paint(g, c);
                // We still want the normal painting logic,
                // but do not do anything extra here.
            }
            @Override
            public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
                // Do nothing: this removes the white box behind the selected text
            }
        });

// Revalidate & repaint instead of updateUI()
        comboBox.revalidate();
        comboBox.repaint();

// Apply a compound border for a rounded outline
        comboBox.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(20, Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(0, 10, 0, 10) // If you want some horizontal padding
        ));

        add(comboBox);
        return comboBox;

    }


    //most fucked up most bullshit but the only working drop down fk everything
    //fk this
    //last trial at this
    //swing is shit
    //anyhow this one works
    //60 is the old and correct transparent but rest good one
    protected JComboBox<String> addLabelWithDropdown60(String text, String fontName, int fontStyle, int fontSize,
                                                         int x, int y, boolean colorChange, String color,
                                                         int dropdownWidth, int dropdownHeight,
                                                         int labelWidth, int spacing,
                                                         String[] options, boolean opaque, float opacityLevel) {

            // 🔖 Create Label
            JLabel label = new JLabel(text);
            label.setFont(new Font(fontName, fontStyle, fontSize));
            label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            // Dynamic Padding
            Dimension size = label.getPreferredSize();
            int padding = Math.min(5, size.width / 20);
            label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
            label.setSize(size.width + padding * 2, size.height);

            // Color Management
            if (colorChange) {
                try {
                    Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
                    label.setForeground(labelColor);
                } catch (Exception e) {
                    label.setForeground(Color.WHITE);
                    System.out.println("Invalid color name: " + color + ". Defaulting to white.");
                }
            }

            // Positioning the Label
            label.setBounds(x, y, label.getWidth() + 5, label.getHeight());
            add(label);
            // icon path:
            // C:\xtra\Last_Chance\BMS\src\icons\arrow2.png

            // Create the JComboBox
         // Create the JComboBox
             JComboBox<String> comboBox = new JComboBox<>(options);
             comboBox.setFont(new Font(fontName, Font.PLAIN, 18)); // Plain, size 18
             comboBox.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);

    // Force heavyweight popup to avoid layering artifacts
             comboBox.setLightWeightPopupEnabled(false);

        // Main combo box: transparent
             comboBox.setOpaque(false);
             comboBox.setBackground(new Color(0, 0, 0, 0));
             comboBox.setForeground(Color.BLACK);
             comboBox.setBorder(null);
             comboBox.setFocusable(true); // If you want keyboard navigation


         // Custom ComboBox UI with arrow button styling
         comboBox.setUI(new BasicComboBoxUI() {
             @Override
             protected JButton createArrowButton() {
                 JButton button = new JButton();
                 button.setOpaque(false);
                 button.setContentAreaFilled(false);
                 button.setBorder(BorderFactory.createEmptyBorder());
                 button.setBackground(new Color(0, 0, 0, 0));
                 button.setFocusPainted(false);

                 // Custom paint method for the arrow icon
                 button.setUI(new BasicButtonUI() {
                     @Override
                     public void paint(Graphics g, JComponent c) {
                         Graphics2D g2 = (Graphics2D) g;
                         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                         // Draw a simple dark gray triangle (inverted)
                         int w = c.getWidth();
                         int h = c.getHeight();
                         int[] xPoints = { w / 4, w / 2, 3 * w / 4 };
                         int[] yPoints = { h / 3, 2 * h / 3, h / 3 };

                         g2.setColor(Color.DARK_GRAY);
                         g2.fillPolygon(xPoints, yPoints, 3);
                     }
                 });
                 return button;
             }

             @Override
             public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
                 // No background to keep transparency
             }


             protected void paintFocus(Graphics g, Rectangle bounds) {
                 // Remove focus ring
             }

             protected void paintCurrentValueFocus(Graphics g, Rectangle bounds, boolean hasFocus) {
                 // Remove any leftover focus outline
             }
         });

         // Simple item renderer for dropdown items
         comboBox.setRenderer(new DefaultListCellRenderer() {
             @Override
             public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                 JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                 renderer.setFont(new Font(fontName, Font.PLAIN, 18));
                 renderer.setOpaque(true);
                 renderer.setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);
                 renderer.setForeground(Color.BLACK);
                 return renderer;
             }
         });

         // Apply a compound border for a rounded outline + optional padding
         comboBox.setBorder(BorderFactory.createCompoundBorder(
                 new RoundedBorder(20, Color.DARK_GRAY), // Thicker border
                 BorderFactory.createEmptyBorder(0, 10, 0, 10)
         ));

         add(comboBox);
         return comboBox;
     }

    protected JComboBox<String> addLabelWithDropdown6(String text, String fontName, int fontStyle, int fontSize,
                                                      int x, int y, boolean colorChange, String color,
                                                      int dropdownWidth, int dropdownHeight,
                                                      int labelWidth, int spacing,
                                                      String[] options, boolean opaque, float opacityLevel) {

        // 🔖 Create Label
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Dynamic Padding
        Dimension size = label.getPreferredSize();
        int padding = Math.min(5, size.width / 20);
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
        label.setSize(size.width + padding * 2, size.height);

        // Color Management
        if (colorChange) {
            try {
                Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
                label.setForeground(labelColor);
            } catch (Exception e) {
                label.setForeground(Color.WHITE);
                System.out.println("Invalid color name: " + color + ". Defaulting to white.");
            }
        }

        // Positioning the Label
        label.setBounds(x, y, label.getWidth() + 5, label.getHeight());
        add(label);

        // 🔹 Custom Background Panel with Rounded Fill
        JPanel comboPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Apply semi-transparent background with rounded edges
                g2.setColor(new Color(255, 255, 255, (int) (opacityLevel * 255)));  // Adjust opacity dynamically
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Rounded Fill Only

                g2.dispose();
            }
        };
        comboPanel.setLayout(null);
        comboPanel.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);
        comboPanel.setOpaque(false); // Ensure transparency is handled correctly

        // 🔹 Create the JComboBox
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(new Font(fontName, Font.PLAIN, 18));
        comboBox.setBounds(5, 5, dropdownWidth - 10, dropdownHeight - 10); // Inner padding for border effect
        comboBox.setOpaque(false); // Transparent text field
        comboBox.setBackground(new Color(0, 0, 0, 0)); // Fully transparent field
        comboBox.setForeground(Color.BLACK);
        comboBox.setBorder(null);
        comboBox.setFocusable(true);

        // 🔹 Custom UI for Arrow Button
        comboBox.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setBorder(BorderFactory.createEmptyBorder());
                button.setBackground(new Color(0, 0, 0, 0));
                button.setFocusPainted(false);

                button.setUI(new BasicButtonUI() {
                    @Override
                    public void paint(Graphics g, JComponent c) {
                        Graphics2D g2 = (Graphics2D) g;
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                        int w = c.getWidth();
                        int h = c.getHeight();
                        int[] xPoints = { w / 4, w / 2, 3 * w / 4 };
                        int[] yPoints = { h / 3, 2 * h / 3, h / 3 };

                        g2.setColor(Color.DARK_GRAY);
                        g2.fillPolygon(xPoints, yPoints, 3);
                    }
                });
                return button;
            }

            @Override
            public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
                // No background to keep transparency
            }

            protected void paintFocus(Graphics g, Rectangle bounds) {
                // Remove focus ring
            }

            protected void paintCurrentValueFocus(Graphics g, Rectangle bounds, boolean hasFocus) {
                // Remove any leftover focus outline
            }
        });

        // 🔹 Simple Renderer for Dropdown Items
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                renderer.setFont(new Font(fontName, Font.PLAIN, 18));
                renderer.setOpaque(true);
                renderer.setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);
                renderer.setForeground(Color.BLACK);
                return renderer;
            }
        });

        // 🔹 Add Rounded Fill Only (No Extra Border)
        comboPanel.add(comboBox);
        add(comboPanel);
        return comboBox;
    }


    protected JComboBox<String> addCustomDropdown(String text, String fontName, int fontStyle, int fontSize,
                                                  int x, int y, int dropdownWidth, int dropdownHeight,
                                                  int labelWidth, int spacing,
                                                  String[] options) {

        // Create Label
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setBounds(x, y, labelWidth, dropdownHeight);
        add(label);

        // Create ComboBox
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(new Font(fontName, Font.BOLD, fontSize));
        comboBox.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);
        comboBox.setOpaque(false);
        comboBox.setBackground(new Color(240, 240, 240)); // Light gray background like calendar field
        comboBox.setForeground(Color.BLACK);
        comboBox.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        String iconPath = "C:\\xtra\\Last_Chance\\BMS\\src\\icons\\arrowDown.png";
        // Remove default arrow
        comboBox.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton customButton = new JButton();
                customButton.setBorder(null);
                customButton.setContentAreaFilled(false);
                customButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

                // Set custom dropdown icon
                ImageIcon arrowIcon = new ImageIcon(new ImageIcon(iconPath).getImage()
                        .getScaledInstance(20, 20, Image.SCALE_SMOOTH));
                customButton.setIcon(arrowIcon);
                return customButton;
            }
        });

        // Custom renderer for dropdown list items
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                renderer.setFont(new Font(fontName, Font.PLAIN, fontSize));

                if (isSelected) {
                    renderer.setBackground(new Color(200, 200, 200)); // Light gray for selection
                    renderer.setForeground(Color.BLACK);
                } else {
                    renderer.setBackground(new Color(240, 240, 240)); // Light gray background
                    renderer.setForeground(Color.BLACK);
                }
                renderer.setOpaque(true);
                return renderer;
            }
        });

        // Round the combo box (similar to the calendar field)
        makeRoundedComboBox(comboBox, dropdownWidth, dropdownHeight, 20);

        add(comboBox);
        return comboBox;
    }

    protected JComboBox<String> addLabelWithComboBox(String text, String fontName, int fontStyle, int fontSize,
                                                     int x, int y, boolean colorChange, String color,
                                                     String[] options, int comboBoxWidth, int comboBoxHeight,
                                                     int labelWidth, int spacing, Color textColor) {
        // Added textColor parameter
        // Create label (same as before)
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Dimension size = label.getPreferredSize();
        int padding = Math.min(5, size.width / 20);
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
        label.setSize(size.width + padding * 2, size.height);

        if (colorChange) {
            try {
                Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
                label.setForeground(labelColor);
            } catch (Exception e) {
                label.setForeground(Color.WHITE);
                System.out.println("Invalid color name: " + color + ". Defaulting to white.");
            }
        }

        label.setBounds(x, y, label.getWidth() + 5, label.getHeight());
        add(label);

        // Create JComboBox
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(new Font(fontName, Font.BOLD, 16));
        comboBox.setBounds(x + spacing, y, comboBoxWidth, comboBoxHeight);

        // Remove border & background
        comboBox.setBorder(null);
        comboBox.setOpaque(false);
        comboBox.setBackground(new Color(0, 0, 0, 0));
        comboBox.setForeground(textColor); // Use the provided textColor

        // Hardcoded icon path (consistent icon)
        String iconPath = "C:\\xtra\\Last_Chance\\BMS\\src\\icons\\dropdown.png"; // Replace with your actual icon path
        ImageIcon dropdownIcon = new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));

        // Iterate through components to find the button
        for (Component component : comboBox.getComponents()) {
            if (component instanceof JButton) {
                JButton arrowButton = (JButton) component;
                arrowButton.setIcon(dropdownIcon);
                arrowButton.setOpaque(false);
                arrowButton.setContentAreaFilled(false);
                arrowButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
                arrowButton.setMargin(new Insets(2, 2, 2, 2));
                arrowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                arrowButton.setFocusable(false);
                break;
            }
        }

        // Custom renderer to remove overlay
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (isSelected) {
                    setBackground(list.getSelectionBackground());
                    setForeground(list.getSelectionForeground());
                } else {
                    setBackground(list.getBackground());
                    setForeground(textColor); // Use the provided textColor for unselected items
                }
                return this;
            }
        });

        // Apply rounded border
        makeRoundedComboBox(comboBox, comboBoxWidth, comboBoxHeight, 20);

        add(comboBox);
        return comboBox;
    }


    protected JCheckBox createCheckButton(String text, String fontName, int fontStyle, int fontSize,
                                             int x, int y, int width, int height, Color textColor) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(new Font(fontName, fontStyle, fontSize));
        checkBox.setBounds(x, y, width, height);
        checkBox.setForeground(textColor);
        styleCustomCheckButton(checkBox);
        add(checkBox);// Apply existing styling
        return checkBox;
    }






    //helper functions:
    private void makeRoundedTextField(JComponent textField, int width, int height, int arc, boolean transparent, int opacityLevel) {
        textField.setPreferredSize(new Dimension(width, height));
        textField.setFocusable(true);

        if (transparent) {
            textField.setOpaque(false);
            textField.setBackground(new Color(255, 255, 255, Math.min(opacityLevel, 255))); // Ensures valid opacity
        } else {
            textField.setOpaque(true);
            textField.setBackground(Color.WHITE);
        }

        // Apply the fixed rounded border
        textField.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(arc, Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding inside
        ));

        // Force repainting
        textField.repaint();
    }

    private void makeRoundedTextField2(JComponent textField, int width, int height, int arc, boolean transparent, int opacityLevel) {
        textField.setPreferredSize(new Dimension(width, height));
        if (transparent) {
            textField.setOpaque(false);
            textField.setBackground(new Color(255, 255, 255, opacityLevel));
        } else {
            textField.setOpaque(true);
            textField.setBackground(Color.WHITE);
        }

        // Apply the fixed rounded border
        textField.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(arc, Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding
        ));

        textField.setFocusable(true);
    }
    private void makeRoundedComponent(JComponent component, int width, int height, int arc, boolean transparent, int opacityLevel) {
        component.setPreferredSize(new Dimension(width, height));

        if (transparent) {
            component.setOpaque(false);
            component.setBackground(new Color(255, 255, 255, opacityLevel));
        } else {
            component.setOpaque(true);
            component.setBackground(Color.WHITE);
        }

        component.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(arc, Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding
        ));

        component.setFocusable(true);
    }
    private void makeTransparentRadioButton(JRadioButton radioButton, boolean transparent, int opacityLevel) {
        if (transparent) {
            radioButton.setOpaque(false);
            radioButton.setContentAreaFilled(false);
            radioButton.setBorderPainted(false);
        } else {
            // Apply a semi-transparent background if not fully transparent
            radioButton.setOpaque(true);
            radioButton.setBackground(new Color(255, 255, 255, opacityLevel)); // Opacity applied here
        }
    }
    private void makeRoundedCalendarField(JDateChooser dateChooser, int width, int height, int arc, boolean transparent, int opacityLevel) {
        dateChooser.setPreferredSize(new Dimension(width, height));

        // Apply transparency settings
        if (transparent) {
            dateChooser.setOpaque(false);
            dateChooser.setBackground(new Color(255, 255, 255, Math.min(opacityLevel, 255))); // Ensure valid opacity
        } else {
            dateChooser.setOpaque(true);
            dateChooser.setBackground(Color.WHITE);
        }

        // Apply the fixed rounded border
        dateChooser.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(arc, Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding inside
        ));

        // Ensure focusability
        dateChooser.setFocusable(true);
    }
    private void makeRoundedCalenderField(JDateChooser dateChooser, int width, int height, int arc) {
        dateChooser.setPreferredSize(new Dimension(width, height));
        dateChooser.setOpaque(false); // Ensure it's interactive
        dateChooser.setBackground(Color.WHITE);

        // Apply the fixed rounded border
        dateChooser.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(arc,Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding
        ));

        dateChooser.setFocusable(true); // Ensure the field can be focused


    }
    //    private void makeFullyTransparentRadioButton1(JRadioButton radioButton) {
//        //old makeRoundedRadioButton(JRadioButton radioButton, int width, int height, int arc) {
////        radioButton.setPreferredSize(new Dimension(width, height));
//        radioButton.setOpaque(false); // Remove background
//        radioButton.setContentAreaFilled(false); // Remove button area fill
//        radioButton.setBorderPainted(false); // No borders
//        radioButton.setFocusPainted(false); // Remove focus ring
////        radioButton.setBackground(new Color(0, 0, 0, 0));
////        radioButton.setIcon(createTransparentIcon());
////        radioButton.setSelectedIcon(createSelectedTransparentIcon());
//        // Apply custom UI to remove background rendering
////        radioButton.setBorder(new RoundedBorder(arc, Color.BLACK));
//    }
//    private void makeTransparentRadioButton1(JRadioButton radioButton) {
//        radioButton.setOpaque(false);
//        radioButton.setContentAreaFilled(false);
//        radioButton.setBorderPainted(false);
//        radioButton.setForeground(Color.BLACK); // Keep text visible
//
//        // Custom UI to remove the white background inside the button
//        radioButton.setUI(new BasicRadioButtonUI() {
//            @Override
//            public void paint(Graphics g, JComponent c) {
//                Graphics2D g2 = (Graphics2D) g.create();
//                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//                // Draw the default radio button without the white box
//                super.paint(g2, c);
//                g2.dispose();
//            }
//        });
//    }
//    private void makeTransparentRadioButton(JRadioButton radioButton) {
//        radioButton.setOpaque(false);
//        radioButton.setContentAreaFilled(false);
//        radioButton.setBorderPainted(false);
//        radioButton.setUI(new CustomRadioButtonUI()); // Apply the custom UI
//    }
    // 🔍 Helper function to style radio buttons with a rounded border
    private void styleRoundedRadioButton2(JRadioButton radioButton, int radius, Color borderColor) {
        radioButton.setOpaque(false);
        radioButton.setContentAreaFilled(false);
        radioButton.setFocusPainted(false);
        radioButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Add a custom border with rounded corners
        radioButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borderColor, 1, true), // Rounded line border
                BorderFactory.createEmptyBorder(5, 5, 5, 5) // Padding
        ));
    }
    private void styleCustomRadioButton(JRadioButton radioButton) {
        radioButton.setOpaque(false);
        radioButton.setFocusPainted(false);
        radioButton.setContentAreaFilled(false);
        radioButton.setBorderPainted(false);

        // Set custom icons for default and selected states
        radioButton.setIcon(createRadioIcon(false));
        radioButton.setSelectedIcon(createRadioIcon(true));
    }
    // 🎨 Custom Icon for Rounded Radio Button
    private Icon createRadioIcon(boolean selected) {
        int size = 15;
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Draw the outer circle (white ring if selected, dark gray otherwise)
                if (selected) {
                    g2.setColor(Color.WHITE);
                } else {
                    g2.setColor(Color.DARK_GRAY);
                }
                g2.fillOval(x, y, size, size);

                // Draw the inner circle for selection (grey fill if selected, light gray otherwise)
                if (selected) {
                    g2.setColor(Color.DARK_GRAY); // New grey fill when selected
                    g2.fillOval(x + 4, y + 4, size - 8, size - 8);
                } else {
                    g2.setColor(new Color(192,192,192)); // Default fill color
                    g2.fillOval(x + 2, y + 2, size - 4, size - 4);
                }
                g2.dispose();
            }
//                // Draw the outer circle
//                g2.setColor(Color.DARK_GRAY);
//                g2.fillOval(x, y, size, size);
//
//                // Draw the inner circle for selection
//                if (selected) {
//                    g2.setColor(Color.BLACK); // Selection color
//                    g2.fillOval(x + 4, y + 4, size - 8, size - 8);
//                } else {
//                    g2.setColor(Color.LIGHT_GRAY); // Default fill color
//                    g2.fillOval(x + 2, y + 2, size - 4, size - 4);
//                }
//                g2.dispose();
//            }

            @Override
            public int getIconWidth() {
                return size;
            }

            @Override
            public int getIconHeight() {
                return size;
            }
        };
    }
    private void makeRoundedDropdown(JComponent component, int width, int height, int radius) {
        component.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        component.setPreferredSize(new Dimension(width, height));
        component.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
    }
    protected void makeRoundedComboBox(JComboBox<?> comboBox, int width, int height, int arc) {
        comboBox.setPreferredSize(new Dimension(width, height));
        comboBox.setOpaque(false); // Same as the calender approach
        comboBox.setBackground(new Color(0, 0, 0, 0)); // Transparent

        comboBox.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(arc, Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding
        ));

        comboBox.setFocusable(true);
    }

    private void makeRoundedComboBox2(JComboBox comboBox, int width, int height, int arc) {
        comboBox.setPreferredSize(new Dimension(width, height));
        comboBox.setOpaque(false);
        comboBox.setBackground(Color.WHITE);

        comboBox.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(arc, Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        comboBox.setFocusable(true);
    }
    private void styleCustomCheckButton(JCheckBox checkBox) {
        checkBox.setOpaque(false);
        checkBox.setFocusPainted(false);
        checkBox.setContentAreaFilled(false);
        checkBox.setBorderPainted(false);
    }




    //REDO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //less go and fuck my life more:
    protected void addLabel(String text, String fontName, int fontStyle, int fontSize,
                            int x, int y, boolean center, boolean colorChange,
                            int labelTextR, int labelTextG, int labelTextB) {
        JLabel label = new JLabel(text); // Create the label
        label.setFont(new Font(fontName, fontStyle, fontSize)); // Set label font
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Get preferred size
        Dimension size = label.getPreferredSize();

        // Add subtle padding dynamically (2-5px based on text length)
        int padding = Math.min(5, size.width / 20); // Scale padding based on text size

        // Apply an empty border for subtle spacing
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));

        // Adjust size with padding
        label.setSize(size.width + padding * 2, size.height);

        // If centering is required (assuming 'width' is the container width)
        if (center) {
            x = (width - label.getWidth()) / 2;
        }

        // Set label color if requested using numeric RGB values
        if (colorChange) {
            label.setForeground(new Color(labelTextR, labelTextG, labelTextB));
        }

        // Set final position (extra 5 pixels added as in your original code)
        label.setBounds(x, y, label.getWidth() + 10, label.getHeight());
        add(label);
    }

    protected JLabel addLabelWhichReturns(String text, String fontName, int fontStyle, int fontSize,
                            int x, int y, boolean center, boolean colorChange,
                            int labelTextR, int labelTextG, int labelTextB, boolean ShouldIAddIt) {
        JLabel label = new JLabel(text); // Create the label
        label.setFont(new Font(fontName, fontStyle, fontSize)); // Set label font
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Get preferred size
        Dimension size = label.getPreferredSize();

        // Add subtle padding dynamically (2-5px based on text length)
        int padding = Math.min(5, size.width / 20); // Scale padding based on text size

        // Apply an empty border for subtle spacing
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));

        // Adjust size with padding
        label.setSize(size.width + padding * 2, size.height);

        // If centering is required (assuming 'width' is the container width)
        if (center) {
            x = (width - label.getWidth()) / 2;
        }

        // Set label color if requested using numeric RGB values
        if (colorChange) {
            label.setForeground(new Color(labelTextR, labelTextG, labelTextB));
        }

        // Set final position (extra 5 pixels added as in your original code)
        label.setBounds(x, y, label.getWidth() + 10, label.getHeight());
        if(ShouldIAddIt){
            add(label);
        }
        return label;
    }





    protected JTextField addLabelWithTextField2(
            // Label parameters:
            String labelText, String labelFontName, int labelFontStyle, int labelFontSize,
            int x, int y,
            // Label color (numeric RGB):
            int labelTextR, int labelTextG, int labelTextB,
            int labelWidth, int spacing,
            // Text field parameters:
            String textFieldFontName, int textFieldFontStyle, int textFieldFontSize,
            int textFieldWidth, int textFieldHeight,
            // Text field color (numeric RGB):
            int textFieldColorR, int textFieldColorG, int textFieldColorB,
            // Border color (numeric RGB):
            int borderR, int borderG, int borderB,
            // Background color for text field (numeric RGB):
            int bgR, int bgG, int bgB,
            // Transparency settings:
            boolean transparent, int opacityLevel,
            // Optional: text field x position override
            int textFieldX
    ) {
        // Create label
        JLabel label = new JLabel(labelText);
        label.setFont(new Font(labelFontName, labelFontStyle, labelFontSize));
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        label.setForeground(new Color(labelTextR, labelTextG, labelTextB));

        Dimension size = label.getPreferredSize();
        int padding = Math.min(2, size.width / 20);
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
        label.setSize(size.width + padding * 2, size.height);
        label.setBounds(x, y, label.getWidth() + 10, label.getHeight());
        add(label);

        // Create text field
        JTextField textField = new JTextField();
        textField.setFont(new Font(textFieldFontName, textFieldFontStyle, textFieldFontSize));
        int effectiveTextFieldX = (textFieldX > 0) ? textFieldX : x + labelWidth + spacing;
        textField.setBounds(effectiveTextFieldX, y, textFieldWidth, textFieldHeight);

        // Apply our custom rounded text field styling
        makeRoundedTextField(textField, textFieldWidth, textFieldHeight, 20, transparent, opacityLevel,
                new Color(bgR, bgG, bgB), new Color(borderR, borderG, borderB));

        textField.setForeground(new Color(textFieldColorR, textFieldColorG, textFieldColorB));

        add(textField);
        return textField;
    }

    protected JPasswordField addLabelWithPasswordField2(
            // Label parameters:
            String labelText,
            String labelFontName, int labelFontStyle, int labelFontSize,
            int x, int y,
            // Label color (RGB):
            int labelTextR, int labelTextG, int labelTextB,
            int labelWidth, int spacing,
            // Password field font parameters:
            String pwdFieldFontName, int pwdFieldFontStyle, int pwdFieldFontSize,
            int textFieldWidth, int textFieldHeight,
            // Password field text color (RGB):
            int pwdTextR, int pwdTextG, int pwdTextB,
            // Border color for password field (RGB):
            int borderR, int borderG, int borderB,
            // Background color for password field (RGB):
            int bgR, int bgG, int bgB,
            // Transparency settings:
            boolean transparent, int opacityLevel
    ) {
        // Create label
        JLabel label = new JLabel(labelText);
        label.setFont(new Font(labelFontName, labelFontStyle, labelFontSize));
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        label.setForeground(new Color(labelTextR, labelTextG, labelTextB));
        Dimension size = label.getPreferredSize();
        int padding = Math.min(5, size.width / 20);
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
        label.setSize(size.width + padding * 2, size.height);
        label.setBounds(x, y, label.getWidth() + 5, label.getHeight());
        add(label);

        // Create password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font(pwdFieldFontName, pwdFieldFontStyle, pwdFieldFontSize));
        passwordField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);

        // Apply rounded and transparent styling
        makeRoundedTextField(passwordField, textFieldWidth, textFieldHeight, 20, transparent, opacityLevel,
                new Color(bgR, bgG, bgB), new Color(borderR, borderG, borderB));

        // Set password field text color
        passwordField.setForeground(new Color(pwdTextR, pwdTextG, pwdTextB));

        add(passwordField);
        return passwordField;
    }
    //helper
    private void makeRoundedTextField(JComponent textField, int width, int height, int arc,
                                      boolean transparent, int opacityLevel, Color bgColor, Color borderColor) {
        textField.setPreferredSize(new Dimension(width, height));
        textField.setFocusable(true);

        if (transparent) {
            textField.setOpaque(false);
            // Set background with desired opacity (ensure opacityLevel is between 0 and 255)
            textField.setBackground(new Color(bgColor.getRed(), bgColor.getGreen(), bgColor.getBlue(), Math.min(opacityLevel, 255)));
        } else {
            textField.setOpaque(true);
            textField.setBackground(bgColor);
        }

        // Apply a compound border: a rounded border with inner padding.
        textField.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(arc, borderColor),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        textField.repaint();
    }
    private void makeRoundedTextField2(JComponent textField, int width, int height, int arc,
                                      boolean transparent, int opacityLevel,
                                       Color bgColor, Color borderColor,
                                       boolean reallyRound) {
        textField.setPreferredSize(new Dimension(width, height));
        textField.setFocusable(true);

        if (transparent) {
            textField.setOpaque(false);
            // Set background with desired opacity (ensure opacityLevel is between 0 and 255)
            textField.setBackground(new Color(bgColor.getRed(), bgColor.getGreen(), bgColor.getBlue(), Math.min(opacityLevel, 255)));
        } else {
            textField.setOpaque(true);
            textField.setBackground(bgColor);
        }
        // Apply a compound border: a rounded border with inner padding.
        textField.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(arc, borderColor),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        textField.repaint();
    }

    protected JTextField addLabelWithTextField2(
            // Label parameters:
            String labelText, String labelFontName, int labelFontStyle, int labelFontSize,
            int x, int y,
            // Label color (numeric RGB):
            int labelTextR, int labelTextG, int labelTextB,
            int labelWidth, int spacing,
            // Text field parameters:
            String textFieldFontName, int textFieldFontStyle, int textFieldFontSize,
            int textFieldWidth, int textFieldHeight,
            // Text field color (numeric RGB):
            int textFieldColorR, int textFieldColorG, int textFieldColorB,
            // Border color (numeric RGB):
            int borderR, int borderG, int borderB,
            // Background color for text field (numeric RGB):
            int bgR, int bgG, int bgB, int arc,
            // Transparency settings:
            boolean transparent, int opacityLevel,
            // Optional: text field x position override
            int textFieldX
    ) {
        // Create label
        JLabel label = new JLabel(labelText);
        label.setFont(new Font(labelFontName, labelFontStyle, labelFontSize));
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        label.setForeground(new Color(labelTextR, labelTextG, labelTextB));

        Dimension size = label.getPreferredSize();
        int padding = Math.min(2, size.width / 20);
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
        label.setSize(size.width + padding * 2, size.height);
        label.setBounds(x, y, label.getWidth() + 10, label.getHeight());
        add(label);

        // Create text field
        JTextField textField = justTextField2(
                (textFieldX > 0) ? textFieldX : x + labelWidth + spacing, y, textFieldWidth, textFieldHeight,
                textFieldFontName, textFieldFontStyle, textFieldFontSize,
                textFieldColorR, textFieldColorG, textFieldColorB,
                borderR, borderG, borderB,
                bgR, bgG, bgB, arc,
                transparent, opacityLevel
        );

        add(textField);
        return textField;
    }
    protected JPasswordField addLabelWithPasswordField3(
            // Label parameters:
            String labelText, String labelFontName, int labelFontStyle, int labelFontSize,
            int x, int y,
            // Label color (numeric RGB):
            int labelTextR, int labelTextG, int labelTextB,
            int labelWidth, int spacing,
            // Text field parameters:
            String textFieldFontName, int textFieldFontStyle, int textFieldFontSize,
            int textFieldWidth, int textFieldHeight,
            // Text field color (numeric RGB):
            int textFieldColorR, int textFieldColorG, int textFieldColorB,
            // Border color (numeric RGB):
            int borderR, int borderG, int borderB,
            // Background color for text field (numeric RGB):
            int bgR, int bgG, int bgB, int arc,
            // Transparency settings:
            boolean transparent, int opacityLevel,
            // Optional: text field x position override
            int textFieldX
    ) {
        // Create label
        JLabel label = new JLabel(labelText);
        label.setFont(new Font(labelFontName, labelFontStyle, labelFontSize));
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        label.setForeground(new Color(labelTextR, labelTextG, labelTextB));

        Dimension size = label.getPreferredSize();
        int padding = Math.min(2, size.width / 20);
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
        label.setSize(size.width + padding * 2, size.height);
        label.setBounds(x, y, label.getWidth() + 10, label.getHeight());
        add(label);

        // Create text field
        JPasswordField textField = justPasswordField2(
                (textFieldX > 0) ? textFieldX : x + labelWidth + spacing, y, textFieldWidth, textFieldHeight,
                textFieldFontName, textFieldFontStyle, textFieldFontSize,
                textFieldColorR, textFieldColorG, textFieldColorB,
                borderR, borderG, borderB,
                bgR, bgG, bgB, arc,
                transparent, opacityLevel
        );

        add(textField);
        return textField;
    }
    protected JPasswordField justPasswordField2(
            int x, int y, int textFieldWidth, int textFieldHeight,
            String textFieldFontName, int textFieldFontStyle, int textFieldFontSize,
            int textFieldColorR, int textFieldColorG, int textFieldColorB,
            int borderR, int borderG, int borderB,
            int bgR, int bgG, int bgB, int arc,
            boolean transparent, int opacityLevel
    ) {
        JPasswordField textField = new JPasswordField() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fill the rounded rectangle with the background color
                if (!transparent) {
                    g2.setColor(new Color(bgR, bgG, bgB, opacityLevel));
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
                }

                g2.dispose();
                super.paintComponent(g); // Draw text on top
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw the rounded border
                g2.setColor(new Color(borderR, borderG, borderB));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

                g2.dispose();
            }
        };

        // Set font and bounds
        textField.setFont(new Font(textFieldFontName, textFieldFontStyle, textFieldFontSize));
        textField.setBounds(x, y, textFieldWidth, textFieldHeight);

        // Set text color
        textField.setForeground(new Color(textFieldColorR, textFieldColorG, textFieldColorB));

        // Transparency settings
        textField.setOpaque(false); // Prevent default background fill

        // Set padding inside text field
        textField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        add(textField);
        return textField;
    }
    protected JTextField justTextField2(
            int x, int y, int textFieldWidth, int textFieldHeight,
            String textFieldFontName, int textFieldFontStyle, int textFieldFontSize,
            int textFieldColorR, int textFieldColorG, int textFieldColorB,
            int borderR, int borderG, int borderB,
            int bgR, int bgG, int bgB, int arc,
            boolean transparent, int opacityLevel
    ) {
        JTextField textField = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fill the rounded rectangle with the background color
                if (!transparent) {
                    g2.setColor(new Color(bgR, bgG, bgB, opacityLevel));
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
                }

                g2.dispose();
                super.paintComponent(g); // Draw text on top
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw the rounded border
                g2.setColor(new Color(borderR, borderG, borderB));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

                g2.dispose();
            }
        };

        // Set font and bounds
        textField.setFont(new Font(textFieldFontName, textFieldFontStyle, textFieldFontSize));
        textField.setBounds(x, y, textFieldWidth, textFieldHeight);

        // Set text color
        textField.setForeground(new Color(textFieldColorR, textFieldColorG, textFieldColorB));

        // Transparency settings
        textField.setOpaque(false); // Prevent default background fill

        // Set padding inside text field
        textField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        add(textField);
        return textField;
    }

    protected JPasswordField addLabelWithPasswordField2(
            // Label parameters:
            String labelText, String labelFontName, int labelFontStyle, int labelFontSize,
            int x, int y,
            // Label color (numeric RGB):
            int labelTextR, int labelTextG, int labelTextB,
            int labelWidth, int spacing,
            // Text field parameters:
            String textFieldFontName, int textFieldFontStyle, int textFieldFontSize,
            int textFieldWidth, int textFieldHeight,
            // Text field color (numeric RGB):
            int textFieldColorR, int textFieldColorG, int textFieldColorB,
            // Border color (numeric RGB):
            int borderR, int borderG, int borderB,
            // Background color for text field (numeric RGB):
            int bgR, int bgG, int bgB, int arc,
            // Transparency settings:
            boolean transparent, int opacityLevel,
            // Optional: text field x position override
            int textFieldX
    ) {
        // Create label
        JLabel label = new JLabel(labelText);
        label.setFont(new Font(labelFontName, labelFontStyle, labelFontSize));
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        label.setForeground(new Color(labelTextR, labelTextG, labelTextB));

        Dimension size = label.getPreferredSize();
        int padding = Math.min(2, size.width / 20);
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
        label.setSize(size.width + padding * 2, size.height);
        label.setBounds(x, y, label.getWidth() + 10, label.getHeight());
        add(label);

        // Create text field
        JPasswordField textField = justPasswordField(
                (textFieldX > 0) ? textFieldX : x + labelWidth + spacing, y, textFieldWidth, textFieldHeight,
                textFieldFontName, textFieldFontStyle, textFieldFontSize,
                textFieldColorR, textFieldColorG, textFieldColorB,
                borderR, borderG, borderB,
                bgR, bgG, bgB, arc,
                transparent, opacityLevel
        );

        add(textField);
        return textField;
    }


    public JButton addRoundedButton(String text, String fontName, int fontStyle, int fontSize,
                             int x, int y, int width, int height,
                             boolean opaque, // Means fully opaque or not
                             boolean transparent, // If true, we use opacityLevel for the fill
                             int opacityLevel,
                             // Numeric base color for text (R,G,B)
                             int baseTextR, int baseTextG, int baseTextB,
                             // Numeric base color for border (R,G,B)
                             int baseBorderR, int baseBorderG, int baseBorderB,
                             // Numeric base color for background (R,G,B)
                             int baseBgR, int baseBgG, int baseBgB,
                             // The corner radius for both border & fill
                             int cornerRadius) {
        // 1. Create a custom JButton that overrides paintComponent to fill a rounded shape
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                // Turn off default content fill so we can do our own
                setContentAreaFilled(false);
                // We'll fill a round rect matching the cornerRadius
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Choose fill color (semi-transparent or fully opaque)
                Color fillColor;
                if (transparent) {
                    fillColor = new Color(baseBgR, baseBgG, baseBgB, opacityLevel);
                } else {
                    fillColor = new Color(baseBgR, baseBgG, baseBgB); // fully opaque
                }

                // Fill the round rect
                g2.setColor(fillColor);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

                g2.dispose();

                // Now paint text, etc. on top
                super.paintComponent(g);
            }
        };

        // 2. Basic button settings
        button.setFont(new Font(fontName, fontStyle, fontSize));
        button.setBounds(x, y, width, height);

        // 3. Base text color
        button.setForeground(new Color(baseTextR, baseTextG, baseTextB));

        // 4. Border color
        Color borderColor = new Color(baseBorderR, baseBorderG, baseBorderB);

        // 5. If not transparent, set background
        //    (The actual fill is done in paintComponent, but let's keep this for consistency)
        if (!transparent) {
            button.setBackground(new Color(baseBgR, baseBgG, baseBgB));
        }
        // If we do want it transparent, we do setOpaque(false).
        if (transparent) {
            button.setOpaque(false);
        } else {
            button.setOpaque(true);
        }

        // 6. Add a rounded border outline
        button.setBorder(new RoundedBorder(cornerRadius, borderColor));
        button.setFocusPainted(false); // Remove the white focus box

        // 7. Hover & Click Effect
        Color normalColor = new Color(50, 150, 250);
        Color hoverColor = new Color(97, 24, 24);
        Color clickColor = new Color(97, 24, 24);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // Hover border & text
                button.setBorder(new RoundedBorder(cornerRadius, hoverColor));
                button.setForeground(hoverColor);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Reset to base border & text
                button.setBorder(new RoundedBorder(cornerRadius, borderColor));
                button.setForeground(new Color(baseTextR, baseTextG, baseTextB));
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                // Click border & maybe background
                button.setBorder(new RoundedBorder(cornerRadius, clickColor));
//                if (!transparent) {
//                    button.setBackground(clickColor);
//                }
                button.setBackground(clickColor);
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (button.getBounds().contains(evt.getPoint())) {
                    button.setBorder(new RoundedBorder(cornerRadius, hoverColor));
                    if (!transparent) {
                        button.setBackground(hoverColor);
                    }
                } else {
                    button.setBorder(new RoundedBorder(cornerRadius, borderColor));
                    if (!transparent) {
                        // Reset to normalColor or base background if you prefer
                        button.setBackground(normalColor);
                    }
                }
                if (transparent) {
                    button.setOpaque(false);
                }
                button.repaint();
            }
        });

        // 8. Add to UI
        add(button);
        return button;
    }

    protected JDateChooser addLabelWithTextFieldWithCalender(
            // Label parameters:
            String text,
            String labelFontName, int labelFontStyle, int labelFontSize,
            int x, int y,
            // Label text color (RGB):
            int labelTextR, int labelTextG, int labelTextB,
            int textFieldWidth, int textFieldHeight,
            int labelWidth, int spacing,
            // Date chooser (internal text field) font parameters:
            String dateFieldFontName, int dateFieldFontStyle, int dateFieldFontSize,
            // Date chooser internal text color (RGB):
            int dateTextR, int dateTextG, int dateTextB,
            // Border color for date chooser (RGB):
            int borderR, int borderG, int borderB,
            // Background fill color for date chooser (RGB):
            int bgR, int bgG, int bgB,
            // Transparency settings:
            boolean transparent, int opacityLevel
    ) {
        // Create label
        JLabel label = new JLabel(text);
        label.setFont(new Font(labelFontName, labelFontStyle, labelFontSize));
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        label.setForeground(new Color(labelTextR, labelTextG, labelTextB));
        Dimension size = label.getPreferredSize();
        int padding = Math.min(5, size.width / 20);
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
        label.setSize(size.width + padding * 2, size.height);
        label.setBounds(x, y, label.getWidth() + 5, label.getHeight());
        add(label);

        // Load calendar icon
        ImageIcon calendarIcon = new ImageIcon(
                new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\calendar.png")
                        .getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH)
        );

        // Create JDateChooser
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setFont(new Font(dateFieldFontName, dateFieldFontStyle, dateFieldFontSize));
        dateChooser.setBounds(x + spacing, y, textFieldWidth, textFieldHeight);

        // Remove border & default background
        dateChooser.setBorder(null);
        dateChooser.setOpaque(false);
        dateChooser.setBackground(new Color(0, 0, 0, 0));

        // Get internal editor (JTextField) and customize it
        JTextField editor = (JTextField) dateChooser.getDateEditor().getUiComponent();
        editor.setFont(new Font(dateFieldFontName, dateFieldFontStyle, dateFieldFontSize));
        editor.setOpaque(false);
        editor.setBackground(new Color(0, 0, 0, 0));
        editor.setBorder(null);
        editor.setForeground(new Color(dateTextR, dateTextG, dateTextB));
        editor.setCaretColor(new Color(dateTextR, dateTextG, dateTextB));

        // Configure the calendar button
        JButton calendarButton = dateChooser.getCalendarButton();
        calendarButton.setIcon(calendarIcon);
        calendarButton.setOpaque(false);
        calendarButton.setContentAreaFilled(false);
        calendarButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        calendarButton.setMargin(new Insets(2, 2, 2, 2));
        calendarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        calendarButton.setFocusable(false);

        // Force UI refresh
        SwingUtilities.invokeLater(() -> {
            dateChooser.updateUI();
            dateChooser.revalidate();
            dateChooser.repaint();
        });

        // Apply rounded border and background fill (the fill stays inside the border)
        makeRoundedCalenderField(dateChooser, textFieldWidth, textFieldHeight, 20, transparent, opacityLevel,
                new Color(bgR, bgG, bgB), new Color(borderR, borderG, borderB));

        add(dateChooser);
        return dateChooser;
    }

    //check the override notations i commented them out for now
    //really check them when making the nxt hopefully last fucking UI file
    protected JComboBox<String> addLabelWithDropdown6(
            // Label parameters:
            String labelText,
            String labelFontName, int labelFontStyle, int labelFontSize,
            int x, int y,
            // Label color (RGB):
            int labelTextR, int labelTextG, int labelTextB,
            int labelWidth, int spacing,
            // Dropdown (combo box) font parameters:
            String dropdownFontName, int dropdownFontStyle, int dropdownFontSize,
            int dropdownWidth, int dropdownHeight,
            // Dropdown text color (RGB):
            int dropdownTextR, int dropdownTextG, int dropdownTextB,
            // Dropdown border color (RGB):
            int dropdownBorderR, int dropdownBorderG, int dropdownBorderB,
            // Dropdown background color (RGB):
            int dropdownBgR, int dropdownBgG, int dropdownBgB,
            // Transparency settings for dropdown background:
            boolean transparent, int opacityLevel,
            // Options for the combo box:
            String[] options,
            // Overall opaque flag for the combo box:
            boolean opaqueFlag
    ) {
        // 🔖 Create Label
        JLabel label = new JLabel(labelText);
        label.setFont(new Font(labelFontName, labelFontStyle, labelFontSize));
        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        label.setForeground(new Color(labelTextR, labelTextG, labelTextB));

        Dimension size = label.getPreferredSize();
        int padding = Math.min(5, size.width / 20);
        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
        label.setSize(size.width + padding * 2, size.height);
        label.setBounds(x, y, label.getWidth() + 5, label.getHeight());
        add(label);

        // (Optional) Load a custom arrow icon if desired; if not, leave it to default
        // For now, we assume we'll use the custom arrow from "arrow2.png"
        ImageIcon arrowIcon = new ImageIcon(
                new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\arrow2.png")
                        .getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH)
        );

        // Create the JComboBox with options
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(new Font(dropdownFontName, dropdownFontStyle, dropdownFontSize)); // Use dropdown font
        comboBox.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);

        // Force heavyweight popup to avoid layering artifacts
        comboBox.setLightWeightPopupEnabled(false);

        // Main combo box: transparency & color settings
        comboBox.setOpaque(opaqueFlag);
        if (opaqueFlag) {
            comboBox.setBackground(new Color(dropdownBgR, dropdownBgG, dropdownBgB));
        } else if (transparent) {
            // Use opacityLevel (ensure opacityLevel is between 0 and 255)
            comboBox.setBackground(new Color(dropdownBgR, dropdownBgG, dropdownBgB, Math.min(opacityLevel, 255)));
        } else {
            // Default to transparent background
            comboBox.setBackground(new Color(0, 0, 0, 0));
        }
        comboBox.setForeground(new Color(dropdownTextR, dropdownTextG, dropdownTextB));
        comboBox.setBorder(null);
        comboBox.setFocusable(true);

        // Set up the custom ComboBox UI with arrow button styling
        comboBox.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setBorder(BorderFactory.createEmptyBorder());
                button.setBackground(new Color(0, 0, 0, 0));
                button.setFocusPainted(false);
                // Override the button UI to paint the arrow
                button.setUI(new BasicButtonUI() {
                    @Override
                    public void paint(Graphics g, JComponent c) {
                        Graphics2D g2 = (Graphics2D) g;
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                        int w = c.getWidth();
                        int h = c.getHeight();
                        int[] xPoints = { w / 4, w / 2, 3 * w / 4 };
                        int[] yPoints = { h / 3, 2 * h / 3, h / 3 };

                        g2.setColor(Color.DARK_GRAY);
                        g2.fillPolygon(xPoints, yPoints, 3);
                    }
                });
                return button;
            }

            @Override
            public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
                // Do nothing to maintain transparency behind the current value
            }

//            @Override
            protected void paintFocus(Graphics g, Rectangle bounds) {
                // Remove focus ring
            }

//            @Override
            protected void paintCurrentValueFocus(Graphics g, Rectangle bounds, boolean hasFocus) {
                // Remove any leftover focus outline
            }
        });

        // Set up the arrow button properties explicitly
        JButton arrowButton = (JButton) comboBox.getComponent(0);
        arrowButton.setOpaque(false);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        arrowButton.setMargin(new Insets(2, 2, 2, 2));
        arrowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);

        // Simple item renderer for dropdown items:
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                renderer.setFont(new Font(dropdownFontName, Font.PLAIN, dropdownFontSize));
                renderer.setOpaque(true);
                if (isSelected) {
                    renderer.setBackground(Color.LIGHT_GRAY);
                    renderer.setForeground(Color.BLACK);
                } else {
                    renderer.setBackground(Color.WHITE);
                    renderer.setForeground(Color.BLACK);
                }
                return renderer;
            }
        });

        // Force UI refresh (without updateUI() to avoid NPE)
        comboBox.revalidate();
        comboBox.repaint();

        // Apply a compound border for a rounded outline; here we want the fill to stay strictly inside the border
        comboBox.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(20, new Color(dropdownBorderR, dropdownBorderG, dropdownBorderB)),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)
        ));

        add(comboBox);
        return comboBox;
    }

    //just the text field no label:

    protected JTextField justTextField(
            // Text field parameters:
            int x, int y, int textFieldWidth, int textFieldHeight,
            String textFieldFontName, int textFieldFontStyle, int textFieldFontSize,
            // Text field color (numeric RGB):
            int textFieldColorR, int textFieldColorG, int textFieldColorB,
            // Border color (numeric RGB):
            int borderR, int borderG, int borderB,
            // Background color for text field (numeric RGB):
            int bgR, int bgG, int bgB,int arc,
            // Transparency settings:
            boolean transparent, int opacityLevel
    ) {

        // Create text field
        JTextField textField = new JTextField();
        textField.setFont(new Font(textFieldFontName, textFieldFontStyle, textFieldFontSize));
        textField.setBounds(x, y, textFieldWidth, textFieldHeight);

        // Apply our custom rounded text field styling
        makeRoundedTextField(textField, textFieldWidth, textFieldHeight, arc, transparent, opacityLevel,
                new Color(bgR, bgG, bgB), new Color(borderR, borderG, borderB));

        textField.setForeground(new Color(textFieldColorR, textFieldColorG, textFieldColorB));

        add(textField);
        return textField;
    }


    protected JPasswordField justPasswordField(
            // Text field parameters:
            int x, int y, int textFieldWidth, int textFieldHeight,
            String textFieldFontName, int textFieldFontStyle, int textFieldFontSize,
            // Text field color (numeric RGB):
            int textFieldColorR, int textFieldColorG, int textFieldColorB,
            // Border color (numeric RGB):
            int borderR, int borderG, int borderB,
            // Background color for text field (numeric RGB):
            int bgR, int bgG, int bgB,int arc,
            // Transparency settings:
            boolean transparent, int opacityLevel
    ) {

        // Create text field
        JPasswordField textField = new JPasswordField();
        textField.setFont(new Font(textFieldFontName, textFieldFontStyle, textFieldFontSize));
        textField.setBounds(x, y, textFieldWidth, textFieldHeight);

        // Apply our custom rounded text field styling
        makeRoundedTextField(textField, textFieldWidth, textFieldHeight, arc, transparent, opacityLevel,
                new Color(bgR, bgG, bgB), new Color(borderR, borderG, borderB));

        textField.setForeground(new Color(textFieldColorR, textFieldColorG, textFieldColorB));

        add(textField);
        return textField;
    }

    //helper
    private void makeRoundedCalenderField(JDateChooser dateChooser, int width, int height, int arc,
                                          boolean transparent, int opacityLevel, Color fillColor, Color borderColor) {
        dateChooser.setPreferredSize(new Dimension(width, height));
        dateChooser.setOpaque(false);
        // Determine the effective fill color based on transparency flag
        Color effectiveFill;
        if (transparent) {
            effectiveFill = new Color(fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue(), Math.min(opacityLevel, 255));
        } else {
            effectiveFill = fillColor;
        }

        // Apply a compound border: the RoundedBorder draws the border, and the empty border provides inner padding
        dateChooser.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(arc, borderColor),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        // Optionally, if you want to force a background fill within the rounded border,
        // you could override dateChooser's paintComponent. However, since JDateChooser's internal
        // editor handles its own background, this compound border is usually enough.

        dateChooser.repaint();
    }

    protected void applyInputFilter(
            JTextComponent field,
            String regexField,
            String warningMsg,
            String hardRegex,
            Color errorBorderColor,
            int borderThickness,
            boolean validateOnFocusLost
    ) {
        Border defaultBorder = field.getBorder(); // Store the default border

        // Real-time input filter
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches(regexField) || newText.isEmpty()) {
                    super.replace(fb, offset, length, text, attrs);
                    field.setBorder(defaultBorder); // Keep the default border
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Feedback for invalid input
                    // Overlay an error border without losing the original
                    field.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(errorBorderColor, borderThickness),
                            defaultBorder
                    ));
                }
            }
        });

        // Optional Focus Listener for validation on focus lost
        if (validateOnFocusLost) {
            field.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    String input = field.getText().trim();
                    if (!input.matches(hardRegex)) {
                        field.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(errorBorderColor, borderThickness),
                                defaultBorder
                        ));
                        JOptionPane.showMessageDialog(null, warningMsg, "Validation Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        field.setBorder(defaultBorder);
                    }
                }
            });
        }
    }
    protected void applyInputValidation2(
            JTextComponent field,
            String warningMsg,
            String msgTitle,
            int msgType,
            boolean playBeep,
            String hardRegex,
            Color errorBorderColor,
            int borderThickness
    ) {
        Border defaultBorder = field.getBorder(); // Store the default border

        // Method to validate input on demand (e.g., button click)
        String input = field.getText().trim();
        if (!input.matches(hardRegex)) {
            // Set error border
            field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(errorBorderColor, borderThickness),
                    defaultBorder
            ));

            // Optional beep sound
            if (playBeep) {
                Toolkit.getDefaultToolkit().beep();
            }

            // Show customizable warning message
            JOptionPane.showMessageDialog(null, warningMsg, msgTitle, msgType);
        } else {
            // Reset to the default border if input is valid
            field.setBorder(defaultBorder);
        }
    }
    protected boolean applyInputValidation(
            JTextComponent field,
            String warningMsg,
            String msgTitle,
            int msgType,
            boolean playBeep,
            String hardRegex,
            Color errorBorderColor,
            int borderThickness
    ) {
        Border defaultBorder = field.getBorder(); // Store the default border

        // Method to validate input on demand (e.g., button click)
        String input = field.getText().trim();
        if (!input.matches(hardRegex)) {
            // Set error border
            field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(errorBorderColor, borderThickness),
                    defaultBorder
            ));

            // Optional beep sound
            if (playBeep) {
                Toolkit.getDefaultToolkit().beep();
            }

            // Show customizable warning message
            JOptionPane.showMessageDialog(null, warningMsg, msgTitle, msgType);

            return false; // Validation failed
        } else {
            // Reset to the default border if input is valid
            field.setBorder(defaultBorder);
            return true; // Validation passed
        }
    }

    protected boolean applyInputValidation(
            JTextComponent field,
            String warningMsg,
            String msgTitle,
            int msgType,
            boolean playBeep,
            String hardRegex,
            String iconPath, // Icon path parameter
            int iconXOffset, // X-offset relative to the text field
            int iconYOffset, // Y-offset relative to the text field
            int iconWidth, // Icon width
            int iconHeight // Icon height
    ) {
        String input = field.getText().trim();



        // Generate a unique name for the error icon label
        String iconLabelName = field.getName() + "_errorIcon";

        // Remove existing error icon (if any)
        Component existingIcon = findComponentByName(iconLabelName);
        if (existingIcon != null) {
            remove(existingIcon);
        }

        if (!input.matches(hardRegex)) {
            System.out.println("Icon Path: " + iconPath);
            System.out.println("Icon Exists: " + (existingIcon != null));
            System.out.println("Field Name: " + field.getName());

            // Optional beep sound
            if (playBeep) {
                Toolkit.getDefaultToolkit().beep();
            }

            // Show customizable warning message
            JOptionPane.showMessageDialog(null, warningMsg, msgTitle, msgType);

            // Add the error icon using the addImage method
            int x = field.getX() + field.getWidth() + iconXOffset;
            int y = field.getY() + iconYOffset;

            ImageIcon icon = new ImageIcon(iconPath);
            JLabel iconLabel = new JLabel(icon);
            iconLabel.setName(iconLabelName); // Name the icon for easy access later
            iconLabel.setBounds(x, y, iconWidth, iconHeight);
            add(iconLabel);
            revalidate();
            repaint();


            return false; // Input is invalid
        }

        return true; // Input is valid
    }


    //helpers here:
    // Method to find a component by its unique name (e.g., error icon labels)
    private Component findComponentByName(String name) {
        for (Component comp : getContentPane().getComponents()) {
            if (name.equals(comp.getName())) {
                return comp;
            }
        }
        return null;
    }

    protected void removeErrorIcon(JTextComponent field) {
        String iconLabelName = field.getName() + "_errorIcon";
        Component existingIcon = findComponentByName(iconLabelName);
        System.out.println("i am removeErrorIcon");
    //    System.out.println("Icon Path: " + iconPath);
        System.out.println("Icon Exists: " + (existingIcon != null));
        System.out.println("Field Name: " + field.getName());
        if (existingIcon != null) {
            remove(existingIcon);
            repaint(); // Ensure the UI is updated
        }
    }

    protected JLabel createErrorIcon(String imagePath, int x, int y, int width, int height) {
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        JLabel errorLabel = new JLabel(icon);
        errorLabel.setBounds(x, y, width, height);
        return errorLabel;
    }

    //reChecker
    protected boolean applyInputValidation(
            JTextComponent field,
            JLabel errorIcon,      // Pass the error icon as a parameter
            String warningMsg,
            String msgTitle,
            int msgType,
            boolean playBeep,
            String hardRegex,
            boolean isClearAction,
            int iconX, // Dynamic X-offset relative to the text field
            int iconY, // Dynamic Y-offset relative to the text field
            int iconWidth,   // Icon width
            int iconHeight   // Icon height
    ) {
        String input = field.getText().trim();

        // If this is a 'Clear' action, just hide the icon and return true
        if (isClearAction) {
//            errorIcon.setVisible(false);
            revalidate();
            repaint();
            return true;
        }

        // Validate input
        if (!input.matches(hardRegex)) {
            // Optional beep sound
            if (playBeep) {
                Toolkit.getDefaultToolkit().beep();
            }
            // Show customizable warning message
            JOptionPane.showMessageDialog(null, warningMsg, msgTitle, msgType);
//            errorIcon.setBounds(iconX, iconY, iconWidth, iconHeight);
//            errorIcon.setVisible(true);
//            revalidate();
//            repaint();
            return false; // Input is invalid
        }

        // Input is valid, hide the error icon
//        errorIcon.setVisible(false);
        revalidate();
        repaint();
        return true;
    }

    protected JLabel showErrorIcon(boolean correctEntries, String imagePath, int x, int y, int width, int height, JLabel errorIcon) {
        // If the entries are not correct, show the error icon
        if (!correctEntries) {
            // Remove existing error icon if it exists

            // Load and scale the image
            ImageIcon icon = new ImageIcon(
                    new ImageIcon(imagePath).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)
            );
            // Create a label to hold the error icon
            JLabel errorIconLabel = new JLabel(icon);
            errorIconLabel.setBounds(x, y, width, height); // Set desired position and size
            add(errorIconLabel);
            revalidate();
            repaint();
            System.out.println("i am comming out");
            return errorIconLabel;
        } else {
            // If entries are correct, remove any existing error icon
            if (errorIcon != null) {
                remove(errorIcon);
                revalidate();
                repaint();
            }
            return null;
        }

//    protected void removeErrorIcon(JTextComponent field) {
//        String iconLabelName = field.getName() + "_errorIcon";
//        Component existingIcon = findComponentByName(iconLabelName);
//        System.out.println("i am removeErrorIcon");
//        if (existingIcon != null) {
//            remove(existingIcon);
//        }
//    }












}


class RoundedBorder implements Border {
    private final int radius;
    private final Color borderColor;
    private Color fillColor = null; // Optional fill color (null if no fill)

    public RoundedBorder(int radius, Color borderColor) {
        this.radius = radius;
        this.borderColor = borderColor;
    }

    // Optional method to set fill color with opacity
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(4, 4, 4, 4);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill the rounded rectangle if a fill color is set
        if (fillColor != null) {
            g2.setColor(fillColor);
            g2.fillRoundRect(x + 1, y + 1, width - 2, height - 2, radius, radius);
        }

        // Draw the border on top
        g2.setColor(borderColor);
        g2.drawRoundRect(x + 1, y + 1, width - 2, height - 2, radius, radius);
    }
}
}


//    //label + text Field
//    protected JTextField addLabelWithTextField2(String text, String fontName, int fontStyle, int fontSize,
//                                                int x, int y, int textFieldWidth, int textFieldHeight,
//                                                int labelWidth, int spacing) {
//        // Create label
//        JLabel label = new JLabel(text);
//        label.setFont(new Font(fontName, fontStyle, fontSize));
//        label.setForeground(Color.WHITE);
//        label.setSize(labelWidth, label.getPreferredSize().height);
//        label.setBounds(x, y, labelWidth, label.getHeight());
//        add(label);
//
//        // Create text field
//        JTextField textField = new JTextField();
//        textField.setFont(new Font(fontName, Font.BOLD, 16));
//        textField.setBounds(x + spacing, y, textFieldWidth, textFieldHeight);
//
//        // Set semi-transparent background (adjust alpha as needed)
//        textField.setOpaque(false);
//        textField.setBackground(new Color(255, 255, 255, 80));  // Adjust opacity (0-255)
//
//        makeRoundedTextField(textField, textFieldWidth, textFieldHeight, 20);
//        add(textField);
//        return textField;
//    }
//
//    //label + password Field (same as above just hide things)
//    protected JPasswordField addLabelWithPasswordField2(String text, String fontName, int fontStyle, int fontSize,
//                                                        int x, int y, int textFieldWidth, int textFieldHeight,
//                                                        int labelWidth, int spacing) {
//        // Create label
//        JLabel label = new JLabel(text);
//        label.setFont(new Font(fontName, fontStyle, fontSize));
//        label.setForeground(Color.WHITE);
//        label.setSize(labelWidth, label.getPreferredSize().height);
//        label.setBounds(x, y, labelWidth, label.getHeight());
//        add(label);
//
//        // Create password field
//        JPasswordField passwordField = new JPasswordField();
//        passwordField.setFont(new Font(fontName, Font.BOLD, 16));
//        passwordField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);
//
//        // Set semi-transparent background
//        passwordField.setOpaque(false);
//        passwordField.setBackground(new Color(255, 255, 255, 80)); // Adjust transparency
//
//        makeRoundedTextField(passwordField, textFieldWidth, textFieldHeight, 20);
//        add(passwordField);
//        return passwordField;
//    }
//
//
//    //to make radio button with label:
//    protected void addLabelWithRadioButton2(String text, String fontName, int fontStyle, int fontSize,
//                                            int x, int y, int labelWidth, int radioFontSize, int rx1, int ry1, int rx2, int ry2,
//                                            int radioWidth, int radioHeight, int radioWidth2,
//                                            String radioButtonLabel1, String radioButtonLabel2) {
//        // Create label
//        JLabel label = new JLabel(text);
//        label.setFont(new Font(fontName, fontStyle, fontSize));
//        label.setForeground(Color.WHITE);
//        label.setSize(labelWidth, label.getPreferredSize().height);
//        label.setBounds(x, y, labelWidth, label.getHeight());
//        add(label);
//
//        // Create radio buttons
//        JRadioButton r1 = new JRadioButton(radioButtonLabel1);
//        r1.setFont(new Font(fontName, fontStyle, radioFontSize));
//        r1.setBounds(rx1, ry1, radioWidth, radioHeight);
//        r1.setForeground(Color.BLACK);
//        makeTransparentRadioButton(r1);
//        add(r1);
//
//        JRadioButton r2 = new JRadioButton(radioButtonLabel2);
//        r2.setFont(new Font(fontName, fontStyle, radioFontSize));
//        r2.setBounds(rx2, ry2, radioWidth2, radioHeight);
//        r2.setForeground(Color.BLACK);
//        makeTransparentRadioButton(r2);
//        add(r2);
//
//        // Group the radio buttons
//        ButtonGroup buttonGroup = new ButtonGroup();
//        buttonGroup.add(r1);
//        buttonGroup.add(r2);
//    }
//
//
//    //calender for DOB
//    protected JDateChooser addLabelWithTextFieldWithCalender(String text, String fontName, int fontStyle, int fontSize,
//                                                             int x, int y, int textFieldWidth, int textFieldHeight,
//                                                             int labelWidth, int spacing) {
//        // Create label
//        JLabel label = new JLabel(text);
//        label.setFont(new Font(fontName, fontStyle, fontSize));
//        label.setForeground(Color.WHITE);
//        label.setSize(labelWidth, label.getPreferredSize().height);
//        label.setBounds(x, y, labelWidth, label.getHeight());
//        add(label);
//
//        // Create date chooser
//        JDateChooser dateChooser = new JDateChooser();
//        dateChooser.setFont(new Font(fontName, Font.BOLD, 16));
//        dateChooser.setBounds(x + spacing, y, textFieldWidth, textFieldHeight);
//        dateChooser.setBorder(null);
//        dateChooser.setOpaque(false);
//        dateChooser.setBackground(new Color(255, 255, 255, 80)); // Semi-transparent
//
//        // Get internal JTextField and make it transparent
//        JTextField editor = (JTextField) dateChooser.getDateEditor().getUiComponent();
//        editor.setOpaque(false);
//        editor.setBackground(new Color(0, 0, 0, 0));
//        editor.setBorder(null);
//        editor.setForeground(Color.WHITE);
//        editor.setCaretColor(Color.WHITE);
//
//        // Calendar button
//        JButton calendarButton = dateChooser.getCalendarButton();
//        calendarButton.setOpaque(false);
//        calendarButton.setContentAreaFilled(false);
//        calendarButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
//
//        // Apply rounded border
//        makeRoundedCalenderField(dateChooser, textFieldWidth, textFieldHeight, 20);
//
//        add(dateChooser);
//        return dateChooser;
//    }


//helper



//private void makeRoundedTextField(JComponent textField, int width, int height, int arc) {
//    textField.setPreferredSize(new Dimension(width, height));
//    textField.setOpaque(false);
//    textField.setBackground(new Color(255, 255, 255, 80)); // Semi-transparent
//    textField.setBorder(BorderFactory.createCompoundBorder(
//            new RoundedBorder(arc, Color.DARK_GRAY),
//            BorderFactory.createEmptyBorder(5, 10, 5, 10)
//    ));
//    textField.setFocusable(true);
//}
//
//private void makeRoundedCalenderField(JDateChooser dateChooser, int width, int height, int arc) {
//    dateChooser.setPreferredSize(new Dimension(width, height));
//    dateChooser.setOpaque(false);
//    dateChooser.setBackground(new Color(255, 255, 255, 80)); // Semi-transparent
//    dateChooser.setBorder(BorderFactory.createCompoundBorder(
//            new RoundedBorder(arc, Color.DARK_GRAY),
//            BorderFactory.createEmptyBorder(5, 10, 5, 10)
//    ));
//    dateChooser.setFocusable(true);
//}
//
//private void makeTransparentRadioButton(JRadioButton radioButton) {
//    radioButton.setOpaque(false);
//    radioButton.setContentAreaFilled(false);
//    radioButton.setBorderPainted(false);
//}
//
//
//protected void addLabelWithRadioButton21(String text, String fontName, int fontStyle, int fontSize,
//                                         int x, int y, int labelWidth, int radioFontSize, int rx1, int ry1, int rx2, int ry2,
//                                         int radioWidth, int radioHeight, int radioWidth2,
//                                         String radioButtonLabel1, String radioButtonLabel2,
//                                         boolean transparent) {
//    // Create label
//    JLabel label = new JLabel(text);
//    label.setFont(new Font(fontName, fontStyle, fontSize));
//    label.setForeground(Color.WHITE);
//    label.setSize(labelWidth, label.getPreferredSize().height);
//    label.setBounds(x, y, labelWidth, label.getHeight());
//    add(label);
//
//    // Create radio buttons
//    JRadioButton r1 = new JRadioButton(radioButtonLabel1);
//    r1.setFont(new Font(fontName, fontStyle, radioFontSize));
//    r1.setBounds(rx1, ry1, radioWidth, radioHeight);
//    r1.setForeground(Color.BLACK);
//
//    JRadioButton r2 = new JRadioButton(radioButtonLabel2);
//    r2.setFont(new Font(fontName, fontStyle, radioFontSize));
//    r2.setBounds(rx2, ry2, radioWidth2, radioHeight);
//    r2.setForeground(Color.BLACK);
//
////        if (transparent) {
////            makeTransparentRadioButton(r1, transparent, opacityLevel);
////            makeTransparentRadioButton(r2, transparent, opacityLevel);
////
////        }
//
//    add(r1);
//    add(r2);
//
//    // Group buttons so only one can be selected
//    ButtonGroup buttonGroup = new ButtonGroup();
//    buttonGroup.add(r1);
//    buttonGroup.add(r2);
//}
//
