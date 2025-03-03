//package bank.management.system;
//
//import com.toedter.calendar.JDateChooser;
//
//import javax.swing.*;
//import javax.swing.plaf.basic.BasicComboBoxUI;
//import javax.swing.text.*;
//import java.awt.*;
//import java.awt.event.FocusAdapter;
//import java.awt.event.FocusEvent;
//
//public class temp2 {
//    package bank.management.system;
//import com.toedter.calendar.JDateChooser;
//
//import javax.swing.*;
//import javax.swing.plaf.ColorUIResource;
//import javax.swing.plaf.basic.BasicComboBoxUI;
//import javax.swing.plaf.basic.BasicRadioButtonUI;
//import javax.swing.text.*;
//import javax.swing.text.AbstractDocument;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.FocusAdapter;
//import java.awt.event.FocusEvent;
//    public class UI2 extends JFrame {
//
//        private int width, height;
//
//        //constructor for all basic details required per page
//        public UI2(int width, int height, String title) {
//            this.width = width;
//            this.height = height;
//
//            setSize(width, height);
//            setTitle(title);
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            setLayout(null);
//
//            // Centering the pop-up dynamically
//            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//            int centerX = (screenSize.width - width) / 2;
//            int centerY = (screenSize.height - height) / 2;
//            setLocation(centerX, centerY);
//        }
//
//        //Image addition
//        protected void addImage(ImageIcon imageIcon, int x, int y, int width, int height) {
//            Image image = imageIcon.getImage();  // Get the Image from the ImageIcon
//            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);  // Resize the image
//            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
//
//            JLabel imageLabel = new JLabel(scaledImageIcon); // Create JLabel to hold the image
//            imageLabel.setBounds(x, y, width, height); // Set bounds for positioning
//            add(imageLabel); // Add the label with the image to the window
//        }
//
//        //Label
//        protected void addLabel(String text, String fontName, int fontStyle, int fontSize, int x, int y, boolean center, boolean colorChange, String color) {
//            JLabel label = new JLabel(text); //object thingy
//            label.setFont(new Font(fontName, fontStyle, fontSize));//using parameters
//            // Enable antialiasing for smoother text rendering
//            label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//            // Get preferred size
//            Dimension size = label.getPreferredSize();
//
//            // Add subtle padding dynamically (2-5px based on text length)
//            int padding = Math.min(5, size.width / 20); // Scale padding based on text size
//
//            // Apply an empty border for subtle spacing
//            label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
//
//            // Adjust size with subtle padding
//            label.setSize(size.width + padding * 2, size.height);
//
//            // If centering is required
//            if (center) {
//                x = (width - label.getWidth()) / 2;
//            }
//            if (colorChange) {
//                label.setForeground(Color.decode(color)); // Set font color
//            }
//
//            // Set final position
//            //taking extra 5 px cuz no clue why the fuck it wont take it any other way!????
//            label.setBounds(x, y, label.getWidth()+5, label.getHeight());
//            add(label);
//        }
//
//
//        protected JTextField addLabelWithTextField2(String text, String fontName, int fontStyle, int fontSize,
//                                                    int x, int y, boolean colorChange, String color, int textFieldWidth, int textFieldHeight,
//                                                    int labelWidth, int spacing, boolean transparent,
//                                                    int opacityLevel, int textFieldX) {
//            // Create label
//            JLabel label = new JLabel(text); //object thingy
//            label.setFont(new Font(fontName, fontStyle, fontSize));//using parameters
//            // Enable antialiasing for smoother text rendering
//            label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//            // Get preferred size
//            Dimension size = label.getPreferredSize();
//
//            // Add subtle padding dynamically (2-5px based on text length)
//            int padding = Math.min(5, size.width / 20); // Scale padding based on text size
//
//            // Apply an empty border for subtle spacing
//            label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
//
//            // Adjust size with subtle padding
//            label.setSize(size.width + padding * 2, size.height);
//
//            if (colorChange) {
//                try {
//                    // Use reflection to convert the string to a Color object
//                    Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
//                    label.setForeground(labelColor);
//                } catch (Exception e) {
//                    // Default to white if the color name is invalid
//                    label.setForeground(Color.WHITE);
//                    System.out.println("Invalid color name: " + color + ". Defaulting to white.");
//                }
//            }
//
//            // Set final position
//            //taking extra 5 px cuz no clue why the fuck it wont take it any other way!????
//            label.setBounds(x, y, label.getWidth()+5, label.getHeight());
//            add(label);
//
//
//            // Create text field
//            JTextField textField = new JTextField();
//            textField.setFont(new Font(fontName, Font.BOLD, 16));
//
//            // If textFieldX is provided (> 0), use it, else calculate as before
//            int effectiveTextFieldX = (textFieldX > 0) ? textFieldX : x + labelWidth + spacing;
//            textField.setBounds(effectiveTextFieldX, y, textFieldWidth, textFieldHeight);
//
//            // Apply transparency settings
//            makeRoundedTextField(textField, textFieldWidth, textFieldHeight, 20, transparent, opacityLevel);
//
//            if (transparent) {
//                textField.setOpaque(false);
//                textField.setBackground(new Color(255, 255, 255, opacityLevel));
//            }
//
//            add(textField);
//            return textField;
//        }
//
//        protected JTextField addLabelWithTextField2(String text, String fontName, int fontStyle, int fontSize,
//                                                    int x, int y, int textFieldWidth, int textFieldHeight,
//                                                    int labelWidth, int spacing, boolean transparent,
//                                                    int opacityLevel, int textFieldX) {
//            // Create label
//            JLabel label = new JLabel(text);
//            label.setFont(new Font(fontName, fontStyle, fontSize));
//            label.setForeground(Color.WHITE);
//            label.setBounds(x, y, labelWidth, textFieldHeight); // Label position and size
//            add(label);
//            //new label?
//
//
//            // Create text field
//            JTextField textField = new JTextField();
//            textField.setFont(new Font(fontName, Font.BOLD, 16));
//
//            // If textFieldX is provided (> 0), use it, else calculate as before
//            int effectiveTextFieldX = (textFieldX > 0) ? textFieldX : x + labelWidth + spacing;
//            textField.setBounds(effectiveTextFieldX, y, textFieldWidth, textFieldHeight);
//
//            // Apply transparency settings
//            makeRoundedTextField(textField, textFieldWidth, textFieldHeight, 20, transparent, opacityLevel);
//
//            if (transparent) {
//                textField.setOpaque(false);
//                textField.setBackground(new Color(255, 255, 255, opacityLevel));
//            }
//
//            add(textField);
//            return textField;
//        }
//
//
//
//        protected JPasswordField addLabelWithPasswordField2(String text, String fontName, int fontStyle, int fontSize,
//                                                            int x, int y, int textFieldWidth, int textFieldHeight,
//                                                            int labelWidth, int spacing, boolean transparent, int opacityLevel) {
//            // Create label
//            JLabel label = new JLabel(text);
//            label.setFont(new Font(fontName, fontStyle, fontSize));
//            label.setForeground(Color.WHITE);
//            label.setBounds(x, y, labelWidth, textFieldHeight); // Ensuring label height matches text field
//            add(label);
//
//            // Create password field
//            JPasswordField passwordField = new JPasswordField();
//            passwordField.setFont(new Font(fontName, Font.BOLD, 16));
//            passwordField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);
//
//            // Apply transparency settings
//            makeRoundedTextField(passwordField, textFieldWidth, textFieldHeight, 20, transparent, opacityLevel);
//
//            if (transparent) {
//                passwordField.setOpaque(false); // Set after applying styles
//                passwordField.setBackground(new Color(255, 255, 255, opacityLevel));
//            }
//
//            add(passwordField);
//            return passwordField;
//        }
//
//        protected JPasswordField addLabelWithPasswordField2(String text, String fontName, int fontStyle, int fontSize,
//                                                            int x, int y,boolean colorChange, String color, int textFieldWidth, int textFieldHeight,
//                                                            int labelWidth, int spacing, boolean transparent, int opacityLevel) {
//            // Create label
//            JLabel label = new JLabel(text); //object thingy
//            label.setFont(new Font(fontName, fontStyle, fontSize));//using parameters
//            // Enable antialiasing for smoother text rendering
//            label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//            // Get preferred size
//            Dimension size = label.getPreferredSize();
//
//            // Add subtle padding dynamically (2-5px based on text length)
//            int padding = Math.min(5, size.width / 20); // Scale padding based on text size
//
//            // Apply an empty border for subtle spacing
//            label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
//
//            // Adjust size with subtle padding
//            label.setSize(size.width + padding * 2, size.height);
//
//            if (colorChange) {
//                try {
//                    // Use reflection to convert the string to a Color object
//                    Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
//                    label.setForeground(labelColor);
//                } catch (Exception e) {
//                    // Default to white if the color name is invalid
//                    label.setForeground(Color.WHITE);
//                    System.out.println("Invalid color name: " + color + ". Defaulting to white.");
//                }
//            }
//
//            // Set final position
//            //taking extra 5 px cuz no clue why the fuck it wont take it any other way!????
//            label.setBounds(x, y, label.getWidth()+5, label.getHeight());
//            add(label);
//
//
//            // Create password field
//            JPasswordField passwordField = new JPasswordField();
//            passwordField.setFont(new Font(fontName, Font.BOLD, 16));
//            passwordField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);
//
//            // Apply transparency settings
//            makeRoundedTextField(passwordField, textFieldWidth, textFieldHeight, 20, transparent, opacityLevel);
//
//            if (transparent) {
//                passwordField.setOpaque(false); // Set after applying styles
//                passwordField.setBackground(new Color(255, 255, 255, opacityLevel));
//            }
//
//            add(passwordField);
//            return passwordField;
//        }
//
//        protected void addLabelWithRadioButton2(String text, String fontName, int fontStyle, int fontSize,
//                                                int x, int y, int labelWidth, int radioFontSize,
//                                                int rx1, int ry1, int rx2, int ry2,
//                                                int radioWidth, int radioHeight, int radioWidth2,
//                                                String radioButtonLabel1, String radioButtonLabel2,
//                                                boolean transparent, int opacityLevel) {
//            // Create label
//            JLabel label = new JLabel(text);
//            label.setFont(new Font(fontName, fontStyle, fontSize));
//            label.setForeground(Color.WHITE);
//            label.setSize(labelWidth, label.getPreferredSize().height);
//            label.setBounds(x, y, labelWidth, label.getHeight());
//            add(label);
//
//            // Create radio buttons
//            JRadioButton r1 = new JRadioButton(radioButtonLabel1);
//            r1.setFont(new Font(fontName, fontStyle, radioFontSize));
//            r1.setBounds(rx1, ry1, radioWidth, radioHeight);
//            r1.setForeground(Color.BLACK);
//
//            JRadioButton r2 = new JRadioButton(radioButtonLabel2);
//            r2.setFont(new Font(fontName, fontStyle, radioFontSize));
//            r2.setBounds(rx2, ry2, radioWidth2, radioHeight);
//            r2.setForeground(Color.BLACK);
//
//            // Apply transparency only if needed
//            if (transparent) {
//                makeTransparentRadioButton(r1, transparent, opacityLevel);
//                makeTransparentRadioButton(r2, transparent, opacityLevel);
//            }
//
//            add(r1);
//            add(r2);
//
//            // Group buttons so only one can be selected at a time
//            ButtonGroup buttonGroup = new ButtonGroup();
//            buttonGroup.add(r1);
//            buttonGroup.add(r2);
//        }
//
//
//        protected JDateChooser addLabelWithTextFieldWithCalendar2(String text, String fontName, int fontStyle, int fontSize,
//                                                                  int x, int y, int textFieldWidth, int textFieldHeight,
//                                                                  int labelWidth, int spacing, boolean transparent, int opacityLevel) {
//            // Create label
//            JLabel label = new JLabel(text);
//            label.setFont(new Font(fontName, fontStyle, fontSize));
//            label.setForeground(Color.WHITE);
//            label.setSize(labelWidth, label.getPreferredSize().height);
//            label.setBounds(x, y, labelWidth, label.getHeight());
//            add(label);
//
//            // Load calendar icon
//            ImageIcon calendarIcon = new ImageIcon(new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\calendar.png")
//                    .getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
//
//            // Create JDateChooser
//            JDateChooser dateChooser = new JDateChooser();
//            dateChooser.setFont(new Font(fontName, Font.BOLD, 16));
//            dateChooser.setBounds(x + spacing, y, textFieldWidth, textFieldHeight);
//            dateChooser.setBorder(null);
//
//            // Apply transparency settings
//            if (transparent) {
//                dateChooser.setOpaque(false);
//                dateChooser.setBackground(new Color(255, 255, 255, opacityLevel));
//            } else {
//                dateChooser.setOpaque(true);
//                dateChooser.setBackground(Color.WHITE);
//            }
//
//            // Get internal JTextField and apply transparency
//            JTextField editor = (JTextField) dateChooser.getDateEditor().getUiComponent();
//            if (transparent) {
//                editor.setOpaque(false);
//                editor.setBackground(new Color(255, 255, 255, opacityLevel));
//            }
//            editor.setBorder(null);
//            editor.setForeground(Color.WHITE);
//            editor.setCaretColor(Color.WHITE);
//
//            // Get calendar button
//            JButton calendarButton = dateChooser.getCalendarButton();
//            calendarButton.setIcon(calendarIcon);
//            calendarButton.setOpaque(false);
//            calendarButton.setContentAreaFilled(false);
//            calendarButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
//            calendarButton.setMargin(new Insets(2, 2, 2, 2));
//            calendarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//
//            // Ensure the button is correctly positioned within the layout
//            calendarButton.setFocusable(false);
//            editor.setFocusable(true);
//
//            // Force UI refresh
//            SwingUtilities.invokeLater(() -> {
//                dateChooser.updateUI();
//                dateChooser.revalidate();
//                dateChooser.repaint();
//            });
//
//            // 🔥 **Call makeRoundedCalendarField to apply the border**
//            makeRoundedCalendarField(dateChooser, textFieldWidth, textFieldHeight, 20, transparent, opacityLevel);
//
//            add(dateChooser);
//            return dateChooser;
//        }
//        //this bitch
//        protected JDateChooser addLabelWithTextFieldWithCalender(String text, String fontName, int fontStyle, int fontSize,
//                                                                 int x, int y,boolean colorChange, String color, int textFieldWidth, int textFieldHeight,
//                                                                 int labelWidth, int spacing) {
//            // Create label
//            JLabel label = new JLabel(text); //object thingy
//            label.setFont(new Font(fontName, fontStyle, fontSize));//using parameters
//            // Enable antialiasing for smoother text rendering
//            label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//            // Get preferred size
//            Dimension size = label.getPreferredSize();
//
//            // Add subtle padding dynamically (2-5px based on text length)
//            int padding = Math.min(5, size.width / 20); // Scale padding based on text size
//
//            // Apply an empty border for subtle spacing
//            label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
//
//            // Adjust size with subtle padding
//            label.setSize(size.width + padding * 2, size.height);
//
//            if (colorChange) {
//                try {
//                    // Use reflection to convert the string to a Color object
//                    Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
//                    label.setForeground(labelColor);
//                } catch (Exception e) {
//                    // Default to white if the color name is invalid
//                    label.setForeground(Color.WHITE);
//                    System.out.println("Invalid color name: " + color + ". Defaulting to white.");
//                }
//            }
//
//            // Set final position
//            //taking extra 5 px cuz no clue why the fuck it wont take it any other way!????
//            label.setBounds(x, y, label.getWidth()+5, label.getHeight());
//            add(label);
//
//            //icon for calender!!!!!
//            ImageIcon calendarIcon = new ImageIcon(new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\calendar.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
//
//// Create JDateChooser
//            JDateChooser dateChooser = new JDateChooser();
//            dateChooser.setFont(new Font(fontName, Font.BOLD, 16));
//            dateChooser.setBounds(x + spacing, y, textFieldWidth, textFieldHeight);
//
//// Remove border & background
//            dateChooser.setBorder(null);
//            dateChooser.setOpaque(false);
//            dateChooser.setBackground(new Color(0, 0, 0, 0));
//
//// Get internal JTextField and make it transparent
//            JTextField editor = (JTextField) dateChooser.getDateEditor().getUiComponent();
//            editor.setOpaque(false);
//            editor.setBackground(new Color(0, 0, 0, 0));
//            editor.setBorder(null);
//            editor.setForeground(Color.WHITE);
//            editor.setCaretColor(Color.WHITE); // Ensure cursor is visible
//
//// Get the calendar button
//            JButton calendarButton = dateChooser.getCalendarButton();
//            calendarButton.setIcon(calendarIcon);
//            calendarButton.setOpaque(false);
//            calendarButton.setContentAreaFilled(false);
//            calendarButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // Adjust outer spacing
//            calendarButton.setMargin(new Insets(2, 2, 2, 2)); // Adjust padding inside the button
//            calendarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//
//// Ensure the button is correctly positioned within the layout
//            calendarButton.setFocusable(false);
//            editor.setFocusable(true);
//
//// Force UI refresh
//            SwingUtilities.invokeLater(() -> {
//                dateChooser.updateUI();
//                dateChooser.revalidate();
//                dateChooser.repaint();
//            });
//            // Apply rounded border
//            makeRoundedCalenderField(dateChooser, textFieldWidth, textFieldHeight, 20);
//
//            add(dateChooser);
//            return dateChooser;
//        } // uses another function to make the things rounded! aka
//
//
//        //    protected JButton addRoundedButton(String text, String fontName, int fontStyle, int fontSize,
////                                       int x, int y, int width, int height, boolean opaque, boolean transparent, int opacityLevel) {
////        JButton button = new JButton(text);
////        button.setFont(new Font(fontName, fontStyle, fontSize));
////        button.setBounds(x, y, width, height);
////
////        // Define colors
////        Color normalColor = new Color(50, 150, 250);
////        Color hoverColor = new Color(30, 130, 230);
////        Color clickColor = new Color(20, 100, 200);
////
////        // Set transparency based on parameters
////        if (transparent) {
////            button.setOpaque(false);
////            button.setContentAreaFilled(false);
////            button.setBackground(new Color(255, 255, 255, opacityLevel));
////        } else {
////            button.setOpaque(true);
////            button.setContentAreaFilled(true);
////            button.setBackground(normalColor);
////        }
////
////        // Set the rounded border
////        button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
////        button.setFocusPainted(false);
////
////        // Hover & Click Effect
////        button.addMouseListener(new java.awt.event.MouseAdapter() {
////            @Override
////            public void mouseEntered(java.awt.event.MouseEvent evt) {
////                button.setBorder(new RoundedBorder(20, hoverColor));
////                button.setForeground(Color.WHITE);
////            }
////
////            @Override
////            public void mouseExited(java.awt.event.MouseEvent evt) {
////                button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
////            }
////
////            @Override
////            public void mousePressed(java.awt.event.MouseEvent evt) {
////                button.setBorder(new RoundedBorder(20, clickColor));
////                if (!transparent) {
////                    button.setBackground(clickColor);
////                }
////            }
////
////            @Override
////            public void mouseReleased(java.awt.event.MouseEvent evt) {
////                if (button.getBounds().contains(evt.getPoint())) {
////                    button.setBorder(new RoundedBorder(20, hoverColor));
////                    if (!transparent) {
////                        button.setBackground(hoverColor);
////                    }
////                } else {
////                    button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
////                    if (!transparent) {
////                        button.setBackground(normalColor);
////                    }
////                }
////                if (transparent) {
////                    button.setOpaque(false);
////                }
////                button.repaint();
////            }
////        });
////
////        button.setForeground(Color.WHITE);
////        add(button);
////        return button;
////    }
////
//        protected JButton addRoundedButton(String text, String fontName, int fontStyle, int fontSize,
//                                           int x, int y, int width, int height, boolean opaque,
//                                           boolean transparent, int opacityLevel) {
//            JButton button = new JButton(text);
//            button.setFont(new Font(fontName, fontStyle, fontSize));
//            button.setBounds(x, y, width, height);
//
//            // Define colors
//            Color normalColor = new Color(50, 150, 250);
//            Color hoverColor = new Color(30, 130, 230);
//            Color clickColor = new Color(20, 100, 200);
//
//            // Set transparency based on parameters
//            if (transparent) {
//                button.setOpaque(false);
//                button.setContentAreaFilled(false);
//                button.setBackground(new Color(255, 255, 255, opacityLevel)); // Semi-transparent
//            } else {
//                button.setOpaque(true);
//                button.setContentAreaFilled(true);
//                button.setBackground(normalColor);
//            }
//
//            // Set the rounded border
//            button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
//            button.setFocusPainted(false); // Remove the white focus box
//
//            // Hover & Click Effect
//            button.addMouseListener(new java.awt.event.MouseAdapter() {
//                @Override
//                public void mouseEntered(java.awt.event.MouseEvent evt) {
//                    button.setBorder(new RoundedBorder(20, hoverColor));
//                    button.setForeground(Color.WHITE);
//                }
//
//                @Override
//                public void mouseExited(java.awt.event.MouseEvent evt) {
//                    button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
//                }
//
//                @Override
//                public void mousePressed(java.awt.event.MouseEvent evt) {
//                    button.setBorder(new RoundedBorder(20, clickColor));
//                    if (!transparent) {
//                        button.setBackground(clickColor);
//                    }
//                }
//
//                @Override
//                public void mouseReleased(java.awt.event.MouseEvent evt) {
//                    if (button.getBounds().contains(evt.getPoint())) {
//                        button.setBorder(new RoundedBorder(20, hoverColor));
//                        if (!transparent) {
//                            button.setBackground(hoverColor);
//                        }
//                    } else {
//                        button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
//                        if (!transparent) {
//                            button.setBackground(normalColor);
//                        }
//                    }
//                    if (transparent) {
//                        button.setOpaque(false);
//                    }
//                    button.repaint();
//                }
//            });
//
//            button.setForeground(Color.WHITE);
//            add(button);
//            return button;
//        }
//        protected JRadioButton createRadioButton(String text, String fontName, int fontStyle, int fontSize,
//                                                 int x, int y, int width, int height, Color textColor) {
//            JRadioButton radioButton = new JRadioButton(text);
//            radioButton.setFont(new Font(fontName, fontStyle, fontSize));
//            radioButton.setBounds(x, y, width, height);
//            radioButton.setForeground(textColor);
//            styleCustomRadioButton(radioButton);
//            add(radioButton);// Apply existing styling
//            return radioButton;
//        }
//
//
//
//        protected void applyInputFilter(JTextComponent field, String regexField, String warningMsg, String hardRegex) {
//            // Real-time input filter
//            ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
//                @Override
//                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
//                    String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
//                    if (newText.matches(regexField) || newText.isEmpty()) {
//                        super.replace(fb, offset, length, text, attrs);
//                    } else {
//                        Toolkit.getDefaultToolkit().beep(); // Small feedback for invalid input
//                    }
//                }
//            });
//
//            // Focus Listener to show warning if needed
//            field.addFocusListener(new FocusAdapter() {
//                @Override
//                public void focusLost(FocusEvent e) {
//                    String input = field.getText().trim();
//                    if (!input.matches(hardRegex)) {
//                        JOptionPane.showMessageDialog(null, warningMsg, "Warning", JOptionPane.WARNING_MESSAGE);
//                    }
//                }
//            });
//
//        }
//        protected void applyInputFilter(JPasswordField field, String regexField, String warningMsg, String hardRegex) {
//            // Real-time input filter
//            ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
//                @Override
//                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
//                    String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
//                    if (newText.matches(regexField) || newText.isEmpty()) {
//                        super.replace(fb, offset, length, text, attrs);
//                    } else {
//                        Toolkit.getDefaultToolkit().beep(); // Small feedback for invalid input
//                    }
//                }
//            });
//
//            // Focus Listener to show warning if needed
//            field.addFocusListener(new FocusAdapter() {
//                @Override
//                public void focusLost(FocusEvent e) {
//                    String input = field.getText().trim();
//                    if (!input.matches(hardRegex)) {
//                        JOptionPane.showMessageDialog(null, warningMsg, "Warning", JOptionPane.WARNING_MESSAGE);
//                    }
//                }
//            });
//
//        }
//
//        //    protected JButton addRoundedButton(String text, String fontName, int fontStyle, int fontSize,
////                                       int x, int y, int width, int height, boolean opaque, int opacityLevel) {
////        JButton button = new JButton(text);
////        button.setFont(new Font(fontName, fontStyle, fontSize));
////        button.setBounds(x, y, width, height);
////
////        // Define colors
////        Color normalColor = new Color(50, 150, 250);
////        Color hoverColor = new Color(30, 130, 230);
////        Color clickColor = new Color(20, 100, 200);
////
////        // Set transparency properly
////        if (!opaque) {
////            button.setOpaque(false);
////            button.setContentAreaFilled(false);
////
////            // 🟢 **Enable semi-transparency** (Comment this out if you want full transparency)
////            button.setBackground(new Color(50, 150, 250, opacityLevel)); // Adjust transparency
////        } else {
////            button.setOpaque(true);
////            button.setContentAreaFilled(true);
////            button.setBackground(normalColor);
////        }
////
////        // Set the rounded border
////        button.setBorder(new RoundedBorder(20, Color.DARK_GRAY));
////
////        // Remove the annoying white focus box
////        button.setFocusPainted(false);
////
////        // Hover & Click Effect
////        button.addMouseListener(new java.awt.event.MouseAdapter() {
////            @Override
////            public void mouseEntered(java.awt.event.MouseEvent evt) {
////                button.setBorder(new RoundedBorder(20, hoverColor)); // Change border color
////                button.setForeground(Color.WHITE); // Ensure text is visible
////            }
////
////            @Override
////            public void mouseExited(java.awt.event.MouseEvent evt) {
////                button.setBorder(new RoundedBorder(20, Color.DARK_GRAY)); // Revert border color
////            }
////
////            @Override
////            public void mousePressed(java.awt.event.MouseEvent evt) {
////                button.setBorder(new RoundedBorder(20, clickColor)); // Darker border on click
////
////                if (opaque) {
////                    button.setBackground(clickColor); // Change background only if opaque
////                } else {
////                    button.setForeground(new Color(200, 200, 200)); // Dim text for transparent button
////
////                    // 🟢 **Apply temporary solid color effect on click** (Comment out for full transparency)
////                    button.setBackground(new Color(20, 100, 200, opacityLevel));
////                }
////                button.setOpaque(true);
////                button.repaint();
////            }
////
////            @Override
////            public void mouseReleased(java.awt.event.MouseEvent evt) {
////                if (button.getBounds().contains(evt.getPoint())) {
////                    button.setBorder(new RoundedBorder(20, hoverColor)); // Return to hover color
////
////                    if (opaque) {
////                        button.setBackground(hoverColor); // Keep hover color if opaque
////                    } else {
////                        button.setForeground(Color.WHITE); // Reset text for transparent button
////
////                        // 🟢 **Restore semi-transparency after click** (Comment out for full transparency)
////                        button.setBackground(new Color(50, 150, 250, opacityLevel));
////                    }
////                } else {
////                    button.setBorder(new RoundedBorder(20, Color.DARK_GRAY)); // Reset border
////
////                    if (opaque) {
////                        button.setBackground(normalColor); // Reset background
////                    } else {
////                        button.setForeground(Color.WHITE); // Reset text color
////
////                        // 🟢 **Restore semi-transparency after click** (Comment out for full transparency)
////                        button.setBackground(new Color(50, 150, 250, opacityLevel));
////                    }
////                }
////
////                // 🔥 **Restore transparency if needed**
////                if (!opaque) {
////                    button.setOpaque(false);
////                }
////                button.repaint();
////            }
////        });
////
////        button.setForeground(Color.WHITE); // Text color
////        add(button);
////        return button;
////    }
//        protected JComboBox<String> addLabelWithDropdown(String text, String fontName, int fontStyle, int fontSize,
//                                                         int x, int y, boolean colorChange, String color,
//                                                         int dropdownWidth, int dropdownHeight,
//                                                         int labelWidth, int spacing,
//                                                         String[] options, boolean opaque, float opacityLevel) {
//
//            // 🔖 Create Label
//            JLabel label = new JLabel(text);
//            label.setFont(new Font(fontName, fontStyle, fontSize));
//            label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//            // Dynamic Padding
//            Dimension size = label.getPreferredSize();
//            int padding = Math.min(5, size.width / 20);
//            label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
//            label.setSize(size.width + padding * 2, size.height);
//
//            // Color Management
//            if (colorChange) {
//                try {
//                    Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
//                    label.setForeground(labelColor);
//                } catch (Exception e) {
//                    label.setForeground(Color.WHITE);
//                    System.out.println("Invalid color name: " + color + ". Defaulting to white.");
//                }
//            }
//
//            // Positioning the Label
//            label.setBounds(x, y, label.getWidth() + 5, label.getHeight());
//            add(label);
//            // Optional: Load a custom arrow icon (like the calendar icon)
//            ImageIcon arrowIcon = new ImageIcon(
//                    new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\arrowDown.png")
//                            .getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH)
//            );
//// Create the JComboBox
//            JComboBox<String> comboBox = new JComboBox<>(options);
//            comboBox.setFont(new Font(fontName, Font.BOLD, fontSize));
//            comboBox.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);
//
//// Force heavyweight popup to avoid layering artifacts
//            comboBox.setLightWeightPopupEnabled(false);
//
//// Make main combo box transparent
//            comboBox.setOpaque(false);
//            comboBox.setBackground(new Color(0, 0, 0, 0));
//            comboBox.setForeground(Color.WHITE);
//            comboBox.setBorder(null);
//            comboBox.setFocusable(true);  // Keep focusable if you want keyboard navigation
//
//// Transparent arrow button (optional)
//            JButton arrowButton = (JButton) comboBox.getComponent(0);
//            arrowButton.setOpaque(false);
//            arrowButton.setContentAreaFilled(false);
//            arrowButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
//            arrowButton.setMargin(new Insets(2, 2, 2, 2));
//            arrowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//            arrowButton.setFocusPainted(false);
//
//// Custom renderer for items
//            comboBox.setRenderer(new DefaultListCellRenderer() {
//                @Override
//                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//                    JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//                    renderer.setFont(new Font(fontName, Font.PLAIN, fontSize));
//
//                    // Use a solid background to avoid ghosting/layering artifacts
//                    if (isSelected) {
//                        renderer.setBackground(new Color(50, 50, 50)); // Solid gray for selected item
//                        renderer.setForeground(Color.YELLOW);
//                        renderer.setOpaque(true);
//                    } else {
//                        renderer.setBackground(new Color(30, 30, 30)); // Slightly lighter gray for non-selected
//                        renderer.setForeground(Color.WHITE);
//                        renderer.setOpaque(true);
//                    }
//                    return renderer;
//                }
//            });
//
//// Force UI refresh (like the calendar approach)
//            SwingUtilities.invokeLater(() -> {
//                comboBox.updateUI();
//                comboBox.revalidate();
//                comboBox.repaint();
//            });
//
//// Apply a rounded border, just like `makeRoundedCalenderField`
//            makeRoundedComboBox(comboBox, dropdownWidth, dropdownHeight, 20);
//
//            add(comboBox);
//            return comboBox;
//
////        // Create the JComboBox
////        JComboBox<String> comboBox = new JComboBox<>(options);
////        comboBox.setFont(new Font(fontName, fontStyle, fontSize));
////        comboBox.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);
////
////// Remove border & background
////        comboBox.setBorder(null);
////        comboBox.setOpaque(false);
////        comboBox.setBackground(new Color(0, 0, 0, 0));
////        comboBox.setForeground(Color.WHITE);
////        comboBox.setFocusable(false);
////
////// Custom renderer for transparency and custom item colors
////        comboBox.setRenderer(new DefaultListCellRenderer() {
////            @Override
////            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
////                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
////                renderer.setOpaque(isSelected); // Make the selected item opaque only
////                renderer.setFont(new Font(fontName, fontStyle, fontSize));
////                renderer.setForeground(isSelected ? Color.YELLOW : Color.WHITE);
////                renderer.setBackground(isSelected ? new Color(0, 0, 0, 150) : new Color(0, 0, 0, 0)); // Transparent bg
////                return renderer;
////            }
////        });
////
////// Transparent arrow button
////        JButton arrowButton = (JButton) comboBox.getComponent(0);
////        arrowButton.setOpaque(false);
////        arrowButton.setContentAreaFilled(false);
////        arrowButton.setBorder(BorderFactory.createEmptyBorder());
////        arrowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
////
////// Apply rounded border using the existing helper function
////        makeRoundedComboBox(comboBox, dropdownWidth, dropdownHeight, 20);
////
////        add(comboBox);
////        return comboBox;
//
//
//        }
//        protected JComboBox<String> addLabelWithDropdown3(String text, String fontName, int fontStyle, int fontSize,
//                                                          int x, int y, boolean colorChange, String color,
//                                                          int dropdownWidth, int dropdownHeight,
//                                                          int labelWidth, int spacing,
//                                                          String[] options, boolean opaque, float opacityLevel) {
//
//            // 🔖 Create Label
//            JLabel label = new JLabel(text);
//            label.setFont(new Font(fontName, fontStyle, fontSize));
//            label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//            // Dynamic Padding
//            Dimension size = label.getPreferredSize();
//            int padding = Math.min(5, size.width / 20);
//            label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
//            label.setSize(size.width + padding * 2, size.height);
//
//            // Color Management
//            if (colorChange) {
//                try {
//                    Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
//                    label.setForeground(labelColor);
//                } catch (Exception e) {
//                    label.setForeground(Color.WHITE);
//                    System.out.println("Invalid color name: " + color + ". Defaulting to white.");
//                }
//            }
//
//            // Positioning the Label
//            label.setBounds(x, y, label.getWidth() + 5, label.getHeight());
//            add(label);
//            // Optional: Load a custom arrow icon (like the calendar icon)
//            ImageIcon arrowIcon = new ImageIcon(
//                    new ImageIcon("C:\\xtra\\Last_Chance\\BMS\\src\\icons\\arrowDown.png")
//                            .getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH)
//            );
//// Create the JComboBox
//            JComboBox<String> comboBox = new JComboBox<>(options);
//            comboBox.setFont(new Font(fontName, Font.BOLD, fontSize));
//            comboBox.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);
//
//// Force heavyweight popup to avoid layering artifacts
//            comboBox.setLightWeightPopupEnabled(false);
//
//// Make main combo box transparent
//            comboBox.setOpaque(false);
//            comboBox.setBackground(new Color(0, 0, 0, 0));
//            comboBox.setForeground(Color.WHITE);
//            comboBox.setBorder(null);
//            comboBox.setFocusable(true);  // Keep focusable if you want keyboard navigation
//
//// Transparent arrow button (optional)
//            JButton arrowButton = (JButton) comboBox.getComponent(0);
//            arrowButton.setOpaque(false);
//            arrowButton.setContentAreaFilled(false);
//            arrowButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
//            arrowButton.setMargin(new Insets(2, 2, 2, 2));
//            arrowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//            arrowButton.setFocusPainted(false);
//
//// Custom renderer for items
//            comboBox.setRenderer(new DefaultListCellRenderer() {
//                @Override
//                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//                    JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//                    renderer.setFont(new Font(fontName, Font.PLAIN, fontSize));
//
//                    // Use a solid background to avoid ghosting/layering artifacts
//                    if (isSelected) {
//                        renderer.setBackground(new Color(50, 50, 50)); // Solid gray for selected item
//                        renderer.setForeground(Color.YELLOW);
//                        renderer.setOpaque(true);
//                    } else {
//                        renderer.setBackground(new Color(30, 30, 30)); // Slightly lighter gray for non-selected
//                        renderer.setForeground(Color.WHITE);
//                        renderer.setOpaque(true);
//                    }
//                    return renderer;
//                }
//            });
//
//// Force UI refresh (like the calendar approach)
//            SwingUtilities.invokeLater(() -> {
//                comboBox.updateUI();
//                comboBox.revalidate();
//                comboBox.repaint();
//            });
//
//// Apply a rounded border, just like `makeRoundedCalenderField`
//            makeRoundedComboBox(comboBox, dropdownWidth, dropdownHeight, 20);
//
//            add(comboBox);
//            return comboBox;
//
////        // Create the JComboBox
////        JComboBox<String> comboBox = new JComboBox<>(options);
////        comboBox.setFont(new Font(fontName, fontStyle, fontSize));
////        comboBox.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);
////
////// Remove border & background
////        comboBox.setBorder(null);
////        comboBox.setOpaque(false);
////        comboBox.setBackground(new Color(0, 0, 0, 0));
////        comboBox.setForeground(Color.WHITE);
////        comboBox.setFocusable(false);
////
////// Custom renderer for transparency and custom item colors
////        comboBox.setRenderer(new DefaultListCellRenderer() {
////            @Override
////            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
////                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
////                renderer.setOpaque(isSelected); // Make the selected item opaque only
////                renderer.setFont(new Font(fontName, fontStyle, fontSize));
////                renderer.setForeground(isSelected ? Color.YELLOW : Color.WHITE);
////                renderer.setBackground(isSelected ? new Color(0, 0, 0, 150) : new Color(0, 0, 0, 0)); // Transparent bg
////                return renderer;
////            }
////        });
////
////// Transparent arrow button
////        JButton arrowButton = (JButton) comboBox.getComponent(0);
////        arrowButton.setOpaque(false);
////        arrowButton.setContentAreaFilled(false);
////        arrowButton.setBorder(BorderFactory.createEmptyBorder());
////        arrowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
////
////// Apply rounded border using the existing helper function
////        makeRoundedComboBox(comboBox, dropdownWidth, dropdownHeight, 20);
////
////        add(comboBox);
////        return comboBox;
//
//
//        }
//
//        protected JComboBox<String> addLabelWithDropdown2(String text, String fontName, int fontStyle, int fontSize,
//                                                          int x, int y, boolean colorChange, String color,
//                                                          int dropdownWidth, int dropdownHeight,
//                                                          int labelWidth, int spacing,
//                                                          String[] options, boolean opaque, float opacityLevel) {
//
//            // 🔖 Create Label
//            JLabel label = new JLabel(text);
//            label.setFont(new Font(fontName, fontStyle, fontSize));
//            label.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//            // Dynamic Padding
//            Dimension size = label.getPreferredSize();
//            int padding = Math.min(5, size.width / 20);
//            label.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
//            label.setSize(size.width + padding * 2, size.height);
//
//            // Color Management
//            if (colorChange) {
//                try {
//                    Color labelColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
//                    label.setForeground(labelColor);
//                } catch (Exception e) {
//                    label.setForeground(Color.WHITE);
//                    System.out.println("Invalid color name: " + color + ". Defaulting to white.");
//                }
//            }
//
//            // Positioning the Label
//            label.setBounds(x, y, label.getWidth() + 5, label.getHeight());
//            add(label);
//
//            // 🎨 Create Dropdown Box (JComboBox)
//            JComboBox<String> dropdown = new JComboBox<>(options);
//            dropdown.setFont(new Font(fontName, fontStyle, fontSize));
//            dropdown.setBounds(x + spacing, y, dropdownWidth, dropdownHeight);
//            dropdown.setForeground(Color.WHITE);
//            dropdown.setOpaque(opaque);
//
//            // Custom Background and Border
//            dropdown.setBackground(new Color(0, 0, 0, 0));
//            dropdown.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//
//            // Custom Renderer for Transparency
//            dropdown.setRenderer(new DefaultListCellRenderer() {
//                @Override
//                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//                    JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//
//                    // Set custom colors
//                    label.setOpaque(true);
//                    if (isSelected) {
//                        label.setBackground(new Color(85, 84, 84, 200)); // Semi-transparent black
//                        label.setForeground(Color.YELLOW); // Highlighted text color
//                    } else {
//                        label.setBackground(new Color(255, 255, 255, 150)); // Semi-transparent black
//                        label.setForeground(Color.WHITE); // Normal text color
//                    }
//
//                    label.setFont(new Font("Times New Roman", Font.BOLD, 20));
//                    return label;
//                }
//            });
//
//            // Make Dropdown Transparent and Styled
//            dropdown.setUI(new BasicComboBoxUI() {
//                @Override
//                protected JButton createArrowButton() {
//                    JButton arrowButton = new JButton("\u25BC"); // Downward arrow symbol
//                    arrowButton.setFont(new Font("Arial", Font.BOLD, 14));
//                    arrowButton.setForeground(Color.WHITE);
//                    arrowButton.setOpaque(false);
//                    arrowButton.setContentAreaFilled(false);
//                    arrowButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
//                    arrowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//                    return arrowButton;
//                }
//            });
//
//            // Apply Rounded Border
//            makeRoundedDropdown(dropdown, dropdownWidth, dropdownHeight, 20);
//
//            add(dropdown);
//            return dropdown;
//        }
//
//        //helper functions:
//        private void makeRoundedTextField(JComponent textField, int width, int height, int arc, boolean transparent, int opacityLevel) {
//            textField.setPreferredSize(new Dimension(width, height));
//            textField.setFocusable(true);
//
//            if (transparent) {
//                textField.setOpaque(false);
//                textField.setBackground(new Color(255, 255, 255, Math.min(opacityLevel, 255))); // Ensures valid opacity
//            } else {
//                textField.setOpaque(true);
//                textField.setBackground(Color.WHITE);
//            }
//
//            // Apply the fixed rounded border
//            textField.setBorder(BorderFactory.createCompoundBorder(
//                    new RoundedBorder(arc, Color.DARK_GRAY),
//                    BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding inside
//            ));
//
//            // Force repainting
//            textField.repaint();
//        }
//
//        private void makeRoundedTextField2(JComponent textField, int width, int height, int arc, boolean transparent, int opacityLevel) {
//            textField.setPreferredSize(new Dimension(width, height));
//            if (transparent) {
//                textField.setOpaque(false);
//                textField.setBackground(new Color(255, 255, 255, opacityLevel));
//            } else {
//                textField.setOpaque(true);
//                textField.setBackground(Color.WHITE);
//            }
//
//            // Apply the fixed rounded border
//            textField.setBorder(BorderFactory.createCompoundBorder(
//                    new RoundedBorder(arc, Color.DARK_GRAY),
//                    BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding
//            ));
//
//            textField.setFocusable(true);
//        }
//        private void makeRoundedComponent(JComponent component, int width, int height, int arc, boolean transparent, int opacityLevel) {
//            component.setPreferredSize(new Dimension(width, height));
//
//            if (transparent) {
//                component.setOpaque(false);
//                component.setBackground(new Color(255, 255, 255, opacityLevel));
//            } else {
//                component.setOpaque(true);
//                component.setBackground(Color.WHITE);
//            }
//
//            component.setBorder(BorderFactory.createCompoundBorder(
//                    new RoundedBorder(arc, Color.DARK_GRAY),
//                    BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding
//            ));
//
//            component.setFocusable(true);
//        }
//        private void makeTransparentRadioButton(JRadioButton radioButton, boolean transparent, int opacityLevel) {
//            if (transparent) {
//                radioButton.setOpaque(false);
//                radioButton.setContentAreaFilled(false);
//                radioButton.setBorderPainted(false);
//            } else {
//                // Apply a semi-transparent background if not fully transparent
//                radioButton.setOpaque(true);
//                radioButton.setBackground(new Color(255, 255, 255, opacityLevel)); // Opacity applied here
//            }
//        }
//        private void makeRoundedCalendarField(JDateChooser dateChooser, int width, int height, int arc, boolean transparent, int opacityLevel) {
//            dateChooser.setPreferredSize(new Dimension(width, height));
//
//            // Apply transparency settings
//            if (transparent) {
//                dateChooser.setOpaque(false);
//                dateChooser.setBackground(new Color(255, 255, 255, Math.min(opacityLevel, 255))); // Ensure valid opacity
//            } else {
//                dateChooser.setOpaque(true);
//                dateChooser.setBackground(Color.WHITE);
//            }
//
//            // Apply the fixed rounded border
//            dateChooser.setBorder(BorderFactory.createCompoundBorder(
//                    new RoundedBorder(arc, Color.DARK_GRAY),
//                    BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding inside
//            ));
//
//            // Ensure focusability
//            dateChooser.setFocusable(true);
//        }
//        private void makeRoundedCalenderField(JDateChooser dateChooser, int width, int height, int arc) {
//            dateChooser.setPreferredSize(new Dimension(width, height));
//            dateChooser.setOpaque(false); // Ensure it's interactive
//            dateChooser.setBackground(Color.WHITE);
//
//            // Apply the fixed rounded border
//            dateChooser.setBorder(BorderFactory.createCompoundBorder(
//                    new RoundedBorder(arc,Color.DARK_GRAY),
//                    BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding
//            ));
//
//            dateChooser.setFocusable(true); // Ensure the field can be focused
//
//
//        }
//        //    private void makeFullyTransparentRadioButton1(JRadioButton radioButton) {
////        //old makeRoundedRadioButton(JRadioButton radioButton, int width, int height, int arc) {
//////        radioButton.setPreferredSize(new Dimension(width, height));
////        radioButton.setOpaque(false); // Remove background
////        radioButton.setContentAreaFilled(false); // Remove button area fill
////        radioButton.setBorderPainted(false); // No borders
////        radioButton.setFocusPainted(false); // Remove focus ring
//////        radioButton.setBackground(new Color(0, 0, 0, 0));
//////        radioButton.setIcon(createTransparentIcon());
//////        radioButton.setSelectedIcon(createSelectedTransparentIcon());
////        // Apply custom UI to remove background rendering
//////        radioButton.setBorder(new RoundedBorder(arc, Color.BLACK));
////    }
////    private void makeTransparentRadioButton1(JRadioButton radioButton) {
////        radioButton.setOpaque(false);
////        radioButton.setContentAreaFilled(false);
////        radioButton.setBorderPainted(false);
////        radioButton.setForeground(Color.BLACK); // Keep text visible
////
////        // Custom UI to remove the white background inside the button
////        radioButton.setUI(new BasicRadioButtonUI() {
////            @Override
////            public void paint(Graphics g, JComponent c) {
////                Graphics2D g2 = (Graphics2D) g.create();
////                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
////
////                // Draw the default radio button without the white box
////                super.paint(g2, c);
////                g2.dispose();
////            }
////        });
////    }
////    private void makeTransparentRadioButton(JRadioButton radioButton) {
////        radioButton.setOpaque(false);
////        radioButton.setContentAreaFilled(false);
////        radioButton.setBorderPainted(false);
////        radioButton.setUI(new CustomRadioButtonUI()); // Apply the custom UI
////    }
//        // 🔍 Helper function to style radio buttons with a rounded border
//        private void styleRoundedRadioButton2(JRadioButton radioButton, int radius, Color borderColor) {
//            radioButton.setOpaque(false);
//            radioButton.setContentAreaFilled(false);
//            radioButton.setFocusPainted(false);
//            radioButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//
//            // Add a custom border with rounded corners
//            radioButton.setBorder(BorderFactory.createCompoundBorder(
//                    BorderFactory.createLineBorder(borderColor, 1, true), // Rounded line border
//                    BorderFactory.createEmptyBorder(5, 5, 5, 5) // Padding
//            ));
//        }
//        private void styleCustomRadioButton(JRadioButton radioButton) {
//            radioButton.setOpaque(false);
//            radioButton.setFocusPainted(false);
//            radioButton.setContentAreaFilled(false);
//            radioButton.setBorderPainted(false);
//
//            // Set custom icons for default and selected states
//            radioButton.setIcon(createRadioIcon(false));
//            radioButton.setSelectedIcon(createRadioIcon(true));
//        }
//        // 🎨 Custom Icon for Rounded Radio Button
//        private Icon createRadioIcon(boolean selected) {
//            int size = 15;
//            return new Icon() {
//                @Override
//                public void paintIcon(Component c, Graphics g, int x, int y) {
//                    Graphics2D g2 = (Graphics2D) g.create();
//                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//                    // Draw the outer circle (white ring if selected, dark gray otherwise)
//                    if (selected) {
//                        g2.setColor(Color.WHITE);
//                    } else {
//                        g2.setColor(Color.DARK_GRAY);
//                    }
//                    g2.fillOval(x, y, size, size);
//
//                    // Draw the inner circle for selection (grey fill if selected, light gray otherwise)
//                    if (selected) {
//                        g2.setColor(Color.DARK_GRAY); // New grey fill when selected
//                        g2.fillOval(x + 4, y + 4, size - 8, size - 8);
//                    } else {
//                        g2.setColor(Color.LIGHT_GRAY); // Default fill color
//                        g2.fillOval(x + 2, y + 2, size - 4, size - 4);
//                    }
//                    g2.dispose();
//                }
////                // Draw the outer circle
////                g2.setColor(Color.DARK_GRAY);
////                g2.fillOval(x, y, size, size);
////
////                // Draw the inner circle for selection
////                if (selected) {
////                    g2.setColor(Color.BLACK); // Selection color
////                    g2.fillOval(x + 4, y + 4, size - 8, size - 8);
////                } else {
////                    g2.setColor(Color.LIGHT_GRAY); // Default fill color
////                    g2.fillOval(x + 2, y + 2, size - 4, size - 4);
////                }
////                g2.dispose();
////            }
//
//                @Override
//                public int getIconWidth() {
//                    return size;
//                }
//
//                @Override
//                public int getIconHeight() {
//                    return size;
//                }
//            };
//        }
//        private void makeRoundedDropdown(JComponent component, int width, int height, int radius) {
//            component.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//            component.setPreferredSize(new Dimension(width, height));
//            component.setBorder(BorderFactory.createCompoundBorder(
//                    BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true),
//                    BorderFactory.createEmptyBorder(5, 5, 5, 5)
//            ));
//        }
//        protected void makeRoundedComboBox(JComboBox<?> comboBox, int width, int height, int arc) {
//            comboBox.setPreferredSize(new Dimension(width, height));
//            comboBox.setOpaque(false); // Same as the calender approach
//            comboBox.setBackground(new Color(0, 0, 0, 0)); // Transparent
//
//            comboBox.setBorder(BorderFactory.createCompoundBorder(
//                    new RoundedBorder(arc, Color.DARK_GRAY),
//                    BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding
//            ));
//
//            comboBox.setFocusable(true);
//        }
//
//
//
//    }
//
////    //label + text Field
////    protected JTextField addLabelWithTextField2(String text, String fontName, int fontStyle, int fontSize,
////                                                int x, int y, int textFieldWidth, int textFieldHeight,
////                                                int labelWidth, int spacing) {
////        // Create label
////        JLabel label = new JLabel(text);
////        label.setFont(new Font(fontName, fontStyle, fontSize));
////        label.setForeground(Color.WHITE);
////        label.setSize(labelWidth, label.getPreferredSize().height);
////        label.setBounds(x, y, labelWidth, label.getHeight());
////        add(label);
////
////        // Create text field
////        JTextField textField = new JTextField();
////        textField.setFont(new Font(fontName, Font.BOLD, 16));
////        textField.setBounds(x + spacing, y, textFieldWidth, textFieldHeight);
////
////        // Set semi-transparent background (adjust alpha as needed)
////        textField.setOpaque(false);
////        textField.setBackground(new Color(255, 255, 255, 80));  // Adjust opacity (0-255)
////
////        makeRoundedTextField(textField, textFieldWidth, textFieldHeight, 20);
////        add(textField);
////        return textField;
////    }
////
////    //label + password Field (same as above just hide things)
////    protected JPasswordField addLabelWithPasswordField2(String text, String fontName, int fontStyle, int fontSize,
////                                                        int x, int y, int textFieldWidth, int textFieldHeight,
////                                                        int labelWidth, int spacing) {
////        // Create label
////        JLabel label = new JLabel(text);
////        label.setFont(new Font(fontName, fontStyle, fontSize));
////        label.setForeground(Color.WHITE);
////        label.setSize(labelWidth, label.getPreferredSize().height);
////        label.setBounds(x, y, labelWidth, label.getHeight());
////        add(label);
////
////        // Create password field
////        JPasswordField passwordField = new JPasswordField();
////        passwordField.setFont(new Font(fontName, Font.BOLD, 16));
////        passwordField.setBounds(x + labelWidth + spacing, y, textFieldWidth, textFieldHeight);
////
////        // Set semi-transparent background
////        passwordField.setOpaque(false);
////        passwordField.setBackground(new Color(255, 255, 255, 80)); // Adjust transparency
////
////        makeRoundedTextField(passwordField, textFieldWidth, textFieldHeight, 20);
////        add(passwordField);
////        return passwordField;
////    }
////
////
////    //to make radio button with label:
////    protected void addLabelWithRadioButton2(String text, String fontName, int fontStyle, int fontSize,
////                                            int x, int y, int labelWidth, int radioFontSize, int rx1, int ry1, int rx2, int ry2,
////                                            int radioWidth, int radioHeight, int radioWidth2,
////                                            String radioButtonLabel1, String radioButtonLabel2) {
////        // Create label
////        JLabel label = new JLabel(text);
////        label.setFont(new Font(fontName, fontStyle, fontSize));
////        label.setForeground(Color.WHITE);
////        label.setSize(labelWidth, label.getPreferredSize().height);
////        label.setBounds(x, y, labelWidth, label.getHeight());
////        add(label);
////
////        // Create radio buttons
////        JRadioButton r1 = new JRadioButton(radioButtonLabel1);
////        r1.setFont(new Font(fontName, fontStyle, radioFontSize));
////        r1.setBounds(rx1, ry1, radioWidth, radioHeight);
////        r1.setForeground(Color.BLACK);
////        makeTransparentRadioButton(r1);
////        add(r1);
////
////        JRadioButton r2 = new JRadioButton(radioButtonLabel2);
////        r2.setFont(new Font(fontName, fontStyle, radioFontSize));
////        r2.setBounds(rx2, ry2, radioWidth2, radioHeight);
////        r2.setForeground(Color.BLACK);
////        makeTransparentRadioButton(r2);
////        add(r2);
////
////        // Group the radio buttons
////        ButtonGroup buttonGroup = new ButtonGroup();
////        buttonGroup.add(r1);
////        buttonGroup.add(r2);
////    }
////
////
////    //calender for DOB
////    protected JDateChooser addLabelWithTextFieldWithCalender(String text, String fontName, int fontStyle, int fontSize,
////                                                             int x, int y, int textFieldWidth, int textFieldHeight,
////                                                             int labelWidth, int spacing) {
////        // Create label
////        JLabel label = new JLabel(text);
////        label.setFont(new Font(fontName, fontStyle, fontSize));
////        label.setForeground(Color.WHITE);
////        label.setSize(labelWidth, label.getPreferredSize().height);
////        label.setBounds(x, y, labelWidth, label.getHeight());
////        add(label);
////
////        // Create date chooser
////        JDateChooser dateChooser = new JDateChooser();
////        dateChooser.setFont(new Font(fontName, Font.BOLD, 16));
////        dateChooser.setBounds(x + spacing, y, textFieldWidth, textFieldHeight);
////        dateChooser.setBorder(null);
////        dateChooser.setOpaque(false);
////        dateChooser.setBackground(new Color(255, 255, 255, 80)); // Semi-transparent
////
////        // Get internal JTextField and make it transparent
////        JTextField editor = (JTextField) dateChooser.getDateEditor().getUiComponent();
////        editor.setOpaque(false);
////        editor.setBackground(new Color(0, 0, 0, 0));
////        editor.setBorder(null);
////        editor.setForeground(Color.WHITE);
////        editor.setCaretColor(Color.WHITE);
////
////        // Calendar button
////        JButton calendarButton = dateChooser.getCalendarButton();
////        calendarButton.setOpaque(false);
////        calendarButton.setContentAreaFilled(false);
////        calendarButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
////
////        // Apply rounded border
////        makeRoundedCalenderField(dateChooser, textFieldWidth, textFieldHeight, 20);
////
////        add(dateChooser);
////        return dateChooser;
////    }
//
//
////helper
//
//
//
////private void makeRoundedTextField(JComponent textField, int width, int height, int arc) {
////    textField.setPreferredSize(new Dimension(width, height));
////    textField.setOpaque(false);
////    textField.setBackground(new Color(255, 255, 255, 80)); // Semi-transparent
////    textField.setBorder(BorderFactory.createCompoundBorder(
////            new RoundedBorder(arc, Color.DARK_GRAY),
////            BorderFactory.createEmptyBorder(5, 10, 5, 10)
////    ));
////    textField.setFocusable(true);
////}
////
////private void makeRoundedCalenderField(JDateChooser dateChooser, int width, int height, int arc) {
////    dateChooser.setPreferredSize(new Dimension(width, height));
////    dateChooser.setOpaque(false);
////    dateChooser.setBackground(new Color(255, 255, 255, 80)); // Semi-transparent
////    dateChooser.setBorder(BorderFactory.createCompoundBorder(
////            new RoundedBorder(arc, Color.DARK_GRAY),
////            BorderFactory.createEmptyBorder(5, 10, 5, 10)
////    ));
////    dateChooser.setFocusable(true);
////}
////
////private void makeTransparentRadioButton(JRadioButton radioButton) {
////    radioButton.setOpaque(false);
////    radioButton.setContentAreaFilled(false);
////    radioButton.setBorderPainted(false);
////}
////
////
////protected void addLabelWithRadioButton21(String text, String fontName, int fontStyle, int fontSize,
////                                         int x, int y, int labelWidth, int radioFontSize, int rx1, int ry1, int rx2, int ry2,
////                                         int radioWidth, int radioHeight, int radioWidth2,
////                                         String radioButtonLabel1, String radioButtonLabel2,
////                                         boolean transparent) {
////    // Create label
////    JLabel label = new JLabel(text);
////    label.setFont(new Font(fontName, fontStyle, fontSize));
////    label.setForeground(Color.WHITE);
////    label.setSize(labelWidth, label.getPreferredSize().height);
////    label.setBounds(x, y, labelWidth, label.getHeight());
////    add(label);
////
////    // Create radio buttons
////    JRadioButton r1 = new JRadioButton(radioButtonLabel1);
////    r1.setFont(new Font(fontName, fontStyle, radioFontSize));
////    r1.setBounds(rx1, ry1, radioWidth, radioHeight);
////    r1.setForeground(Color.BLACK);
////
////    JRadioButton r2 = new JRadioButton(radioButtonLabel2);
////    r2.setFont(new Font(fontName, fontStyle, radioFontSize));
////    r2.setBounds(rx2, ry2, radioWidth2, radioHeight);
////    r2.setForeground(Color.BLACK);
////
//////        if (transparent) {
//////            makeTransparentRadioButton(r1, transparent, opacityLevel);
//////            makeTransparentRadioButton(r2, transparent, opacityLevel);
//////
//////        }
////
////    add(r1);
////    add(r2);
////
////    // Group buttons so only one can be selected
////    ButtonGroup buttonGroup = new ButtonGroup();
////    buttonGroup.add(r1);
////    buttonGroup.add(r2);
////}
////
//
//}
