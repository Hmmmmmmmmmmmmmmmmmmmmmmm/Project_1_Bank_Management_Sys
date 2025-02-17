package bank.management.system;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class UI extends JFrame{

    private int width, height;

    //constructor for all basic details required per page
    public UI(int width, int height, String title) {
        this.width = width;
        this.height = height;

        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Centering the pop-up dynamically
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - width) / 2;
        int centerY = (screenSize.height - height) / 2;
        setLocation(centerX, centerY);
    }
    //Image addition
    protected void addImage(ImageIcon imageIcon, int x, int y, int width, int height) {
        Image image = imageIcon.getImage();  // Get the Image from the ImageIcon
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);  // Resize the image
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledImageIcon); // Create JLabel to hold the image
        imageLabel.setBounds(x, y, width, height); // Set bounds for positioning
        add(imageLabel); // Add the label with the image to the window
    }

    //Label
    protected void addLabel(String text, String fontName, int fontStyle, int fontSize, int x, int y, boolean center) {
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

        // Set final position
        //taking extra 5 px cuz no clue why the fuck it wont take it any other way!????
        label.setBounds(x, y, label.getWidth()+5, label.getHeight());
        add(label);
    }

    //label + text Field
    protected JTextField addLabelWithTextField2(String text, String fontName, int fontStyle, int fontSize,
                                              int x, int y, int textFieldWidth, int textFieldHeight,
                                              int labelWidth, int spacing) {
        // Create label
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setForeground(Color.WHITE);
        label.setSize(labelWidth, label.getPreferredSize().height);
        label.setBounds(x, y, labelWidth, label.getHeight());
        add(label);

        // Create text field
        JTextField textField = new JTextField();
        textField.setFont(new Font(fontName, Font.BOLD, 16));  // Increased size for better visibility
        textField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);

        // Make it rounded rounder or something along those lines
        makeRoundedTextField(textField, textFieldWidth, textFieldHeight, 20);
        add(textField);
        return textField;
    } // uses another function to make the things rounded! aka helper function
    //label + password Field (same as above just hide things)
    protected JPasswordField addLabelWithPasswordField2(String text, String fontName, int fontStyle, int fontSize,
                                                      int x, int y, int textFieldWidth, int textFieldHeight,
                                                      int labelWidth, int spacing) {
        // Create label
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        label.setForeground(Color.WHITE);
        label.setSize(labelWidth, label.getPreferredSize().height);
        label.setBounds(x, y, labelWidth, label.getHeight());
        add(label);

        // Create text field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font(fontName, Font.BOLD, 16));  // Increased size for better visibility
        passwordField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);

//        // Make it rounded
//        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Inner padding
//        passwordField.setBackground(Color.WHITE);
//        passwordField.setOpaque(false); // Allow transparency for custom painting
//        passwordField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
//
//        // Apply a custom border for rounded effect
//        passwordField.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createLineBorder(Color.BLACK, 2, true),  // Outer rounded border
//                BorderFactory.createEmptyBorder(5, 10, 5, 10)  // Inner padding
//        ));
        makeRoundedTextField(passwordField, textFieldWidth, textFieldHeight, 20);

        add(passwordField);
        return passwordField;
    }
    //rounded buttons
    protected JButton addRoundedButton(String text, String fontName, int fontStyle, int fontSize,
                                     int x, int y, int width, int height, boolean opaque) {
        JButton button = new JButton(text);
        button.setFont(new Font(fontName, fontStyle, fontSize));
        button.setBounds(x, y, width, height);

        // Define colors
        Color normalColor = new Color(50, 150, 250);
        Color hoverColor = new Color(30, 130, 230);
        Color clickColor = new Color(20, 100, 200);

        // Set transparency properly
        if (!opaque) {
            button.setOpaque(false);
            button.setContentAreaFilled(false);
        } else {
            button.setOpaque(true);
            button.setContentAreaFilled(true);
            button.setBackground(normalColor);
        }

        // Set the rounded border
        button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));

        //remove the fucking annoying lil white box
        button.setFocusPainted(false);

        // Hover & Click Effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBorder(new RoundedBorder(20, hoverColor)); // Change border color
                button.setForeground(Color.WHITE); // Ensure text is visible
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBorder(new RoundedBorder(20, Color.DARK_GRAY)); // Revert border color
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                button.setBorder(new RoundedBorder(20, clickColor)); // Darker border on click

                if (opaque) {
                    button.setBackground(clickColor); // Change background only if opaque
                } else {
                    button.setForeground(new Color(200, 200, 200)); // Dim text for transparent button
                }

                // 🔥 **Temporary overlay effect for a click**
                button.setOpaque(true);
                button.repaint();
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (button.getBounds().contains(evt.getPoint())) {
                    button.setBorder(new RoundedBorder(20, hoverColor)); // Return to hover color

                    if (opaque) {
                        button.setBackground(hoverColor); // Keep hover color if opaque
                    } else {
                        button.setForeground(Color.WHITE); // Reset text for transparent button
                    }
                } else {
                    button.setBorder(new RoundedBorder(20, Color.DARK_GRAY)); // Reset border

                    if (opaque) {
                        button.setBackground(normalColor); // Reset background
                    } else {
                        button.setForeground(Color.WHITE); // Reset text color
                    }
                }

                // 🔥 **Restore transparency if needed**
                if (!opaque) {
                    button.setOpaque(false);
                }

                button.repaint();
            }

//            @Override
//            public void mousePressed(java.awt.event.MouseEvent evt) {
//                button.setBorder(new RoundedBorder(20, clickColor)); // Darker border on click
//
//                if (opaque) {
//                    button.setBackground(clickColor); // Change background only if opaque
//                } else {
//                    button.setForeground(new Color(200, 200, 200)); // Dim text for transparent button
//                }
//
//                //  **Remove white highlight**
//                button.setFocusPainted(false);
//                button.setContentAreaFilled(false);
//            }
//            @Override
//            public void mouseReleased(java.awt.event.MouseEvent evt) {
//                if (button.getBounds().contains(evt.getPoint())) {
//                    button.setBorder(new RoundedBorder(20, hoverColor)); // Return to hover color
//
//                    if (opaque) {
//                        button.setBackground(hoverColor); // Keep hover color if opaque
//                    } else {
//                        button.setForeground(Color.WHITE); // Reset text for transparent button
//                    }
//                } else {
//                    button.setBorder(new RoundedBorder(20, Color.DARK_GRAY)); // Reset border
//
//                    if (opaque) {
//                        button.setBackground(normalColor); // Reset background
//                    } else {
//                        button.setForeground(Color.WHITE); // Reset text color
//                    }
//                }
//
//                //  **Ensure full transparency (if needed)**
//                button.setFocusPainted(false);
//                button.setContentAreaFilled(false);
//            }
        });

        button.setForeground(Color.WHITE); // Text color
        add(button);
        return button;
    }

    //helper functions:
    //1. help in rounding up text field, quite literally
    private void makeRoundedTextField(JComponent textField, int width, int height, int arc) {
        textField.setPreferredSize(new Dimension(width, height));
        textField.setOpaque(false); // Ensure it's interactive
        textField.setBackground(Color.WHITE);

        // Apply the fixed rounded border
        textField.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(arc,Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding
        ));

        textField.setFocusable(true); // Ensure the field can be focused


    }


    public abstract void actionPerformed(ActionEvent b);
}





    //    //4:3 ratio kept
//    private final int widthWindow = 640;
//    private final int heightWindow = 480;
//    //    JLabel welcomeLabel, label2, label3;
////    private Image backgroundImage;
//    JTextField cardNumberField;
//    JPasswordField pinField;
//    JButton signInButton, clearButton, signUpButton;
//    public void LoginFirst() {
////        backgroundImage = new ImageIcon("C:/path/to/your/image/background.jpg").getImage();
//        setSize(widthWindow,heightWindow);
//        setTitle("Asteroid Destroyer");
//
//        //setting the logo at the top center
//        setLayout(null);
//
//
//        // Create an ImageIcon with your logo (adjust the path to the image file)
//        ImageIcon logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\bank.png");
//        addImage(logo, (widthWindow - 100) / 2, 20, 100, 100); // Logo at top center
////       addLogo(); this shit brings the center logo no clue how though now i use another method muehehehehehehe
////making the title/ label without a function trial 1:
////        welcomeLabel = new JLabel("Welcome to the Bank!");
////        welcomeLabel.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 24));
////        welcomeLabel.setFont(new Font("Courier New", Font.BOLD, 18));
////        welcomeLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 28));
////        // Calculate the position below the image
////        int labelX = (widthWindow - welcomeLabel.getPreferredSize().width) / 2; // Center the label horizontally
////        int labelY = 20 + 100 + 10; // 20 (top) + 100 (image height) + 10 (space between)
////        //Bounds for the label (x, y, width, height)
////        welcomeLabel.setBounds(labelX, labelY, welcomeLabel.getPreferredSize().width, 30);
////       add(welcomeLabel);
////          trial 1
////        //using function call instead:
////        addCustomLabel1("Welcome to the Bank!", "Lucida Calligraphy", Font.PLAIN, 24,
////                (widthWindow - new JLabel("Welcome to the Bank!").getPreferredSize().width) / 2, 20 + 100 + 10);
////        Username label (Left aligned with space for the text field)
////        addCustomLabel3("Username:", "Arial", Font.PLAIN, 18,
////                50, 20 + 100 + 10 + 75);  // Positioned 75px below Welcome
////
//// Password label (Left aligned, 40px below Username)
////        addCustomLabel3("Password:", "Arial", Font.PLAIN, 18,
////                50, 20 + 100 + 10 + 75 + 40);  // Positioned 40px below Username
////        label2 = new JLabel("Card Number");
////       welcomeLabel.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 24));
////        welcomeLabel.setFont(new Font("Courier New", Font.BOLD, 18));
//        //trial2
////        // Welcome label (Centered)
////        addCustomLabel4("Welcome to the Bank!", "Lucida Calligraphy", Font.PLAIN, 24,
////                (widthWindow - new JLabel("Welcome to the Bank!").getPreferredSize().width) / 2, 20 + 100 + 10);
////
////        // Username label (Left aligned with space for the text field)
////        addCustomLabel4("Username:", "Arial", Font.PLAIN, 18, 50, 20 + 100 + 10 + 75);  // Positioned 75px below Welcome
////
////        // Password label (Left aligned, 40px below Username)
////        addCustomLabel4("Password:", "Arial", Font.PLAIN, 18, 50, 20 + 100 + 10 + 75 + 40);  // Positioned 40px below Username
//
//        //trial 3
////        int xPosition = ((widthWindow - new JLabel("Welcome to the Bank!").getPreferredSize().width)) / 2;
////        addCustomLabel5("Welcome to the Bank!", "Lucida Calligraphy", Font.PLAIN, 24, xPosition, 20 + 100 + 10);
////
//
//        //trial 4
//        // Centered title
//        addLabel("Welcome to the Bank!", "Times New Roman Bold", Font.PLAIN, 34, 0, 130, true);
//        //trial 5 (4 does the stand-alone heading)
//// Left-aligned Username & Password labels
////        addLabel("Card Number:", "Times New Roman Bold", Font.BOLD, 20, 50, 205, false);
////        addLabel("PIN                 :", "Times New Roman Bold", Font.BOLD, 20, 50, 245, false);
//
//        //stand-alone text field
////        JTextField  cn = new JTextField();
////        cn.setBounds(325,190,230,30);
////        setFont(new Font("Times New Roman",Font.BOLD,14));
////        add(cn);
//        cardNumberField = addLabelWithTextField2("Card Number:", "Times New Roman", Font.BOLD, 20, 70, 205, 250, 30, 220, 15);
//        pinField = addLabelWithPasswordField2("PIN:", "Times New Roman", Font.BOLD, 20, 70, 245, 250, 30, 220, 15);
//
//        //butttttoooonnnnsssss
//        signInButton = addRoundedButton("Sign In", "Times New Roman", Font.BOLD, 18, 125, 300, 150, 40, false);
//        signInButton.addActionListener(this);
//        clearButton = addRoundedButton("Clear", "Times New Roman", Font.BOLD, 18, 300, 300, 150, 40, false);
//        clearButton.addActionListener(this);
//        signUpButton = addRoundedButton("Sign Up", "Times New Roman", Font.BOLD, 18, ((640 - 120) / 2)-20, 360, 120, 40, false);
//        signUpButton.addActionListener(this);
//
//
//
//        //Centering the pop-up
//        //using another function to get the center of the screen
//        //this uses the awt package
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int screenWidth = screenSize.width;
//        int screenHeight = screenSize.height;
//
//        //calculating the center position based on the screenWidth
//        int sideToWindowSize = (screenWidth - 640) / 2;  // (screenWidth - windowWidth) / 2
//        int topToWindow = (screenHeight - 480) / 2; // (screenHeight - windowHeight) / 2
//
//        setLocation(sideToWindowSize, topToWindow);
//
//
//        ImageIcon backgroundImage = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\layer-170971.jpg"); // Replace with actual path
//        addImage(backgroundImage,0,0, widthWindow, heightWindow);
//
//        setVisible(true);
//    } //main login shit
//
//
//
//
//
//
//
//
//    // below are most of the UI function try to move them to a class!
//
//    @Override
//    public void actionPerformed(ActionEvent b) {
//        try {
//            if(b.getSource()==signInButton){
//
//            } else if (b.getSource()==clearButton) {
//                cardNumberField.setText("");
//                pinField.setText("");
//            }else if (b.getSource()==signUpButton){
//
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    private void addImage(ImageIcon imageIcon, int x, int y, int width, int height) {
//        Image image = imageIcon.getImage();  // Get the Image from the ImageIcon
//        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);  // Resize the image
//        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
//
//        JLabel imageLabel = new JLabel(scaledImageIcon); // Create JLabel to hold the image
//        imageLabel.setBounds(x, y, width, height); // Set bounds for positioning
//        add(imageLabel); // Add the label with the image to the window
//    }
//
//
//    private void addLabel(String text, String fontName, int fontStyle, int fontSize, int x, int y, boolean center) {
//        JLabel label = new JLabel(text);
//        label.setFont(new Font(fontName, fontStyle, fontSize));
//
//        // Enable anti-aliasing for smoother text rendering
//        label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//        // Get preferred size
//        Dimension size = label.getPreferredSize();
//
//        // Add subtle padding dynamically (2-5px based on text length)
//        int padding = Math.min(5, size.width / 20); // Scale padding based on text size
//
//        // Apply an empty border for subtle spacing
//        label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
//
//        // Adjust size with subtle padding
//        label.setSize(size.width + padding * 2, size.height);
//
//        // If centering is required
//        if (center) {
//            x = (widthWindow - label.getWidth()) / 2;
//        }
//
//        // Set final position
//        //taking extra 5 px cuz no clue why the fuck it wont take it any other way!????
//        label.setBounds(x, y, label.getWidth()+5, label.getHeight());
//        add(label);
//    }
//    private JTextField addLabelWithTextField(String labelText, String fontName, int fontStyle, int fontSize,
//                                             int x, int y, int textFieldWidth, int textFieldHeight, int spacing) {
//        // Create Label
//        JLabel label = new JLabel(labelText);
//        label.setFont(new Font(fontName, fontStyle, fontSize));
//
//        // Calculate label size dynamically
//        label.setSize(label.getPreferredSize());
//        label.setBounds(x, y, label.getWidth(), label.getHeight());
//        add(label);
//
//        // Create Text Field
//        JTextField textField = new JTextField();
//        textField.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Consistent font for text fields
//
//        // **Calculate dynamic position** for the text field based on the label's width
//        int textFieldX = x + label.getWidth() + spacing;
//        textField.setBounds(textFieldX, y, textFieldWidth, textFieldHeight);
//        add(textField);
//
//        return textField; // Return text field if needed for future use
//    }
//    private JTextField addLabelWithTextField(String text, String fontName, int fontStyle, int fontSize,
//                                             int x, int y, int textFieldWidth, int textFieldHeight,
//                                             int labelWidth, int spacing) {
//        // Create label
//        JLabel label = new JLabel(text);
//        label.setFont(new Font(fontName, fontStyle, fontSize));
//
//        // Set a fixed width for alignment
//        label.setSize(labelWidth, label.getPreferredSize().height);
//        label.setBounds(x, y, labelWidth, label.getHeight());
//
//        add(label);
//
//        // Position the text field dynamically based on the label
//        JTextField textField = new JTextField();
//        textField.setFont(new Font(fontName, Font.BOLD, 14));  // Applying font for consistency
//        textField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);
//
//        add(textField);
//
//        return textField; // Return if needed
//    }
//
//    private JTextField addLabelWithTextField2(String text, String fontName, int fontStyle, int fontSize,
//                                              int x, int y, int textFieldWidth, int textFieldHeight,
//                                              int labelWidth, int spacing) {
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
//        textField.setFont(new Font(fontName, Font.BOLD, 16));  // Increased size for better visibility
//        textField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);
//
//        // Make it rounded
////        textField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Inner padding
////        textField.setBackground(Color.WHITE);
////        textField.setOpaque(false); // Allow transparency for custom painting
////        textField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
//
//        // Apply a custom border for rounded effect
////        textField.setBorder(BorderFactory.createCompoundBorder(
////                BorderFactory.createLineBorder(Color.BLACK, 2, true),  // Outer rounded border
////                BorderFactory.createEmptyBorder(5, 10, 5, 10)  // Inner padding
////        ));
//
////        makeRoundedField(passwordField);
////          Apply rounded corners here
//        makeRoundedTextField(textField, textFieldWidth, textFieldHeight, 20);
//        add(textField);
//        return textField;
//    }
//
//    private JPasswordField addLabelWithPasswordField2(String text, String fontName, int fontStyle, int fontSize,
//                                                      int x, int y, int textFieldWidth, int textFieldHeight,
//                                                      int labelWidth, int spacing) {
//        // Create label
//        JLabel label = new JLabel(text);
//        label.setFont(new Font(fontName, fontStyle, fontSize));
//        label.setForeground(Color.WHITE);
//        label.setSize(labelWidth, label.getPreferredSize().height);
//        label.setBounds(x, y, labelWidth, label.getHeight());
//        add(label);
//
//        // Create text field
//        JPasswordField passwordField = new JPasswordField();
//        passwordField.setFont(new Font(fontName, Font.BOLD, 16));  // Increased size for better visibility
//        passwordField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);
//
////        // Make it rounded
////        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Inner padding
////        passwordField.setBackground(Color.WHITE);
////        passwordField.setOpaque(false); // Allow transparency for custom painting
////        passwordField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
////
////        // Apply a custom border for rounded effect
////        passwordField.setBorder(BorderFactory.createCompoundBorder(
////                BorderFactory.createLineBorder(Color.BLACK, 2, true),  // Outer rounded border
////                BorderFactory.createEmptyBorder(5, 10, 5, 10)  // Inner padding
////        ));
//        makeRoundedTextField(passwordField, textFieldWidth, textFieldHeight, 20);
//
//        add(passwordField);
//        return passwordField;
//    }
//
////    private JButton addRoundedButton(String text, String fontName, int fontStyle, int fontSize,
////                                     int x, int y, int width, int height, boolean opaque) {
////        JButton button = new JButton(text);
////        button.setFont(new Font(fontName, fontStyle, fontSize));
////
////        // Set transparency based on `opaque` parameter
////        button.setOpaque(opaque);
////        button.setContentAreaFilled(opaque); // Ensures background is visible if opaque
////        button.setBorderPainted(true); // Ensures border is drawn
////
////        // Apply rounded border
////        button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
////
////        // Position the button
////        button.setBounds(x, y, width, height);
////
////        // Optional: Add hover effect (if needed)
////        button.addMouseListener(new java.awt.event.MouseAdapter() {
////            @Override
////            public void mouseEntered(java.awt.event.MouseEvent evt) {
////                button.setBackground(new Color(200, 200, 200)); // Light gray on hover
////            }
////            @Override
////            public void mouseExited(java.awt.event.MouseEvent evt) {
////                button.setBackground(Color.WHITE); // Reset on exit
////            }
////        });
////
////        add(button);
////        return button;
////    }
//
////private JButton addRoundedButton(String text, String fontName, int fontStyle, int fontSize,
////                                 int x, int y, int width, int height, boolean opaque) {
////    JButton button = new JButton(text) {
////        @Override
////        protected void paintComponent(Graphics g) {
////            if (!isOpaque()) {
////                Graphics2D g2 = (Graphics2D) g.create();
////                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
////
////                // Set the background color and clip it to a rounded rectangle
////                g2.setColor(getBackground());
////                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
////
////                g2.dispose();
////            }
////            super.paintComponent(g);
////        }
////
////        @Override
////        protected void paintBorder(Graphics g) {
////            Graphics2D g2 = (Graphics2D) g.create();
////            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
////            g2.setColor(Color.DARK_GRAY);
////            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
////            g2.dispose();
////        }
////    };
////
////    button.setFont(new Font(fontName, fontStyle, fontSize));
////
////    // Set transparency based on `opaque` parameter
////    button.setOpaque(false);
////    button.setContentAreaFilled(false);
////    button.setBorderPainted(false); // Border is drawn in `paintBorder()`
////
////    // Set button colors
////    button.setBackground(Color.WHITE);
////    button.setForeground(Color.BLACK);
////
////    // Position the button
////    button.setBounds(x, y, width, height);
////
////    // Hover effect (Optional)
////    button.addMouseListener(new java.awt.event.MouseAdapter() {
////        @Override
////        public void mouseEntered(java.awt.event.MouseEvent evt) {
////            button.setBackground(new Color(220, 220, 220)); // Light gray on hover
////        }
////        @Override
////        public void mouseExited(java.awt.event.MouseEvent evt) {
////            button.setBackground(Color.WHITE); // Reset on exit
////        }
////    });
////
////    add(button);
////    return button;
////}
//
////    private JButton addRoundedButton(String text, String fontName, int fontStyle, int fontSize,
////                                     int x, int y, int width, int height, boolean opaque) {
////        JButton button = new JButton(text);
////        button.setFont(new Font(fontName, fontStyle, fontSize));
////        button.setBounds(x, y, width, height);
////
////        // 🎨 Define colors
////        Color normalColor = new Color(50, 150, 250); // Default button color
////        Color hoverColor = new Color(30, 130, 230);  // Lighter shade for hover
////        Color clickColor = new Color(20, 100, 200);  // Darker shade for click
////
////        if (opaque) {
////            button.setOpaque(true);
////            button.setBackground(normalColor);
////        } else {
////            button.setOpaque(false);
////            button.setContentAreaFilled(false); // Transparent background
////        }
////
////        button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
////        button.setForeground(Color.WHITE); // Text color
////
////        // Hover Effect
////        button.addMouseListener(new java.awt.event.MouseAdapter() {
////            @Override
////            public void mouseEntered(java.awt.event.MouseEvent evt) {
////                button.setOpaque(true);  // Ensure background is visible
////                button.setBackground(hoverColor);
////            }
////
////            @Override
////            public void mouseExited(java.awt.event.MouseEvent evt) {
////                button.setBackground(normalColor);
////                if (!opaque) button.setOpaque(false); // Reapply transparency if needed
////            }
////
////            @Override
////            public void mousePressed(java.awt.event.MouseEvent evt) {
////                button.setBackground(clickColor);
////            }
////
////            @Override
////            public void mouseReleased(java.awt.event.MouseEvent evt) {
////                button.setBackground(hoverColor);
////            }
////        });
////
////        add(button);
////        return button;
////    }
//
//    private JButton addRoundedButton(String text, String fontName, int fontStyle, int fontSize,
//                                     int x, int y, int width, int height, boolean opaque) {
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
//        } else {
//            button.setOpaque(true);
//            button.setContentAreaFilled(true);
//            button.setBackground(normalColor);
//        }
//
//        // Set the rounded border
//        button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
//
//        //remove the fucking annoying lil white box
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
//            @Override
//            public void mousePressed(java.awt.event.MouseEvent evt) {
//                button.setBorder(new RoundedBorder(20, clickColor)); // Darker border on click
//
//                if (opaque) {
//                    button.setBackground(clickColor); // Change background only if opaque
//                } else {
//                    button.setForeground(new Color(200, 200, 200)); // Dim text for transparent button
//                }
//
//                // 🔥 **Temporary overlay effect for a click**
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
//                    }
//                } else {
//                    button.setBorder(new RoundedBorder(20, Color.DARK_GRAY)); // Reset border
//
//                    if (opaque) {
//                        button.setBackground(normalColor); // Reset background
//                    } else {
//                        button.setForeground(Color.WHITE); // Reset text color
//                    }
//                }
//
//                // 🔥 **Restore transparency if needed**
//                if (!opaque) {
//                    button.setOpaque(false);
//                }
//
//                button.repaint();
//            }
//
////            @Override
////            public void mousePressed(java.awt.event.MouseEvent evt) {
////                button.setBorder(new RoundedBorder(20, clickColor)); // Darker border on click
////
////                if (opaque) {
////                    button.setBackground(clickColor); // Change background only if opaque
////                } else {
////                    button.setForeground(new Color(200, 200, 200)); // Dim text for transparent button
////                }
////
////                //  **Remove white highlight**
////                button.setFocusPainted(false);
////                button.setContentAreaFilled(false);
////            }
////            @Override
////            public void mouseReleased(java.awt.event.MouseEvent evt) {
////                if (button.getBounds().contains(evt.getPoint())) {
////                    button.setBorder(new RoundedBorder(20, hoverColor)); // Return to hover color
////
////                    if (opaque) {
////                        button.setBackground(hoverColor); // Keep hover color if opaque
////                    } else {
////                        button.setForeground(Color.WHITE); // Reset text for transparent button
////                    }
////                } else {
////                    button.setBorder(new RoundedBorder(20, Color.DARK_GRAY)); // Reset border
////
////                    if (opaque) {
////                        button.setBackground(normalColor); // Reset background
////                    } else {
////                        button.setForeground(Color.WHITE); // Reset text color
////                    }
////                }
////
////                //  **Ensure full transparency (if needed)**
////                button.setFocusPainted(false);
////                button.setContentAreaFilled(false);
////            }
//        });
//
//        button.setForeground(Color.WHITE); // Text color
//        add(button);
//        return button;
//    }
//
//    private void makeRoundedTextField(JComponent textField, int width, int height, int arc) {
//        textField.setPreferredSize(new Dimension(width, height));
//        textField.setOpaque(false); // Ensure it's interactive
//        textField.setBackground(Color.WHITE);
//
//        // Apply the fixed rounded border
//        textField.setBorder(BorderFactory.createCompoundBorder(
//                new RoundedBorder(arc,Color.DARK_GRAY),
//                BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding
//        ));
//
//        textField.setFocusable(true); // Ensure the field can be focused
//
//
//    }
//
//    public static void main(String[] args) {
//        LoginFirst login = new LoginFirst();
//
//    }
//}
//class RoundedBorder2 implements Border {
//    private final int radius;
//    private final Color color;
//
//    public RoundedBorder(int radius, Color color) {
//        this.radius = radius;
//        this.color = color;
//    }
//
//    @Override
//    public Insets getBorderInsets(Component c) {
//        // Reduced insets to avoid shrinking the clickable area
//        return new Insets(4, 4, 4, 4);
//    }
//
//    @Override
//    public boolean isBorderOpaque() {
//        return false; // Ensure proper painting of the field
//    }
//
//    @Override
//    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.setColor(color);
//
//        // Adjusting the rectangle to avoid cutting the top part
//        g2.drawRoundRect(x+1, y+1, width - 2, height - 2, radius, radius);
//    }
//}
//
//
////old logo based methods + label based method
//
//
////    private void addLogo() {
////        // Create an ImageIcon with your logo (adjust the path to the image file)
////        ImageIcon logo = new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\bank.png");
////
////        if (logo.getIconWidth() == -1) {
////            System.out.println("Error: Logo image not found!");
////        } else {
////            System.out.println("Logo loaded successfully.");
////        }
////        // Resize the image to fit within 100x100 using getScaledInstance()
////        JLabel logoLabel = getjLabel(logo);
////
////        add(logoLabel);
////    }
////    private JLabel getjLabel(ImageIcon logo) {
////        Image logoImage = logo.getImage();  // Get the Image from the ImageIcon
////        Image scaledImage = logoImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
////        ImageIcon scaledLogo = new ImageIcon(scaledImage);
////
////        // Create a JLabel to hold the logo
////        JLabel logoLabel = new JLabel(scaledLogo);
////
////        // Set the size of the logo (100x100 pixels), positioning it a few pixels below the top center
////        logoLabel.setBounds((widthWindow - 100) / 2, 20, 100, 100); // Adjusting Y position to 20
////        return logoLabel;
//////    }
////private void addCustomLabel(String text, String fontName, int fontStyle, int fontSize, int x, int y) {
////    JLabel label = new JLabel(text);
////    label.setFont(new Font(fontName, fontStyle, fontSize));
////
////    // Dynamically calculate the width based on the font and text
////    int labelWidth = label.getFontMetrics(label.getFont()).stringWidth(text);
////    int labelHeight = label.getFontMetrics(label.getFont()).getHeight();
////
////    // Set the bounds for the label
////    label.setBounds(x, y, labelWidth, labelHeight);
////
////    // Add the label to the frame
////    add(label);
////}
////private void addCustomLabel1(String text, String fontName, int fontStyle, int fontSize, int x, int y) {
////    JLabel customLabel = new JLabel(text);
////    customLabel.setFont(new Font(fontName, fontStyle, fontSize));
////
////    // Calculate position dynamically
////    int labelWidth = customLabel.getPreferredSize().width;
////    int labelHeight = customLabel.getPreferredSize().height;
////
////    customLabel.setBounds((widthWindow - labelWidth) / 2, y, labelWidth, labelHeight);
////    add(customLabel);
////}
////private void addCustomLabel2(String text, String fontName, int fontStyle, int fontSize, int x, int y) {
////    JLabel customLabel = new JLabel(text);
////    customLabel.setFont(new Font(fontName, fontStyle, fontSize));
////
////    // Calculate size dynamically based on text content
////    customLabel.setPreferredSize(new Dimension(customLabel.getPreferredSize().width, customLabel.getPreferredSize().height));
////
////    // Set the bounds: dynamically calculate width and height
////    customLabel.setBounds(x, y, customLabel.getPreferredSize().width, customLabel.getPreferredSize().height);
////
////    add(customLabel);
////}
////private void addCustomLabel3(String text, String fontName, int fontStyle, int fontSize, int x, int y) {
////    JLabel customLabel = new JLabel(text);
////    customLabel.setFont(new Font(fontName, fontStyle, fontSize));
////
////    // Dynamically calculate the label's width and height based on its content
////    int labelWidth = customLabel.getPreferredSize().width;
////    int labelHeight = customLabel.getPreferredSize().height;
////
////    // Set bounds: dynamically calculate X position to center the label, Y position is passed directly
////    customLabel.setBounds(x, y, labelWidth, labelHeight);
////
////    add(customLabel);
////}
////private void addCustomLabel4(String text, String fontName, int fontStyle, int fontSize, int x, int y) {
////    JLabel customLabel = new JLabel(text);
////    customLabel.setFont(new Font(fontName, fontStyle, fontSize));
////
////    // Calculate position dynamically
////    int labelWidth = customLabel.getPreferredSize().width;
////    int labelHeight = customLabel.getPreferredSize().height;
////
////    // Now X position is passed as an argument, so we use the argument for X, and calculate Y dynamically
////    customLabel.setBounds(x, y, labelWidth, labelHeight);
////    add(customLabel);
////}
////private void addCustomLabel5(String text, String fontName, int fontStyle, int fontSize, int x, int y) {
////    JLabel customLabel = new JLabel(text);
////    customLabel.setFont(new Font(fontName, fontStyle, fontSize));
////
////    // Calculate position dynamically
////    int labelWidth = customLabel.getPreferredSize().width;
////    int labelHeight = customLabel.getPreferredSize().height;
////
////    // Set the position of the label (either custom x position or calculated for centering)
////    customLabel.setBounds(x, y, labelWidth, labelHeight);
////    add(customLabel);
////}
//
