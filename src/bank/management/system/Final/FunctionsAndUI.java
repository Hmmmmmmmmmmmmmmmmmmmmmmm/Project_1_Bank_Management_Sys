package bank.management.system.Final;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FunctionsAndUI extends JFrame{

    private int width, height;

    //constructors:
    public FunctionsAndUI(){
        System.out.println("UI2 class called");
        setUndecorated(true);
    }

    public FunctionsAndUI(int width, int height, String title, boolean center,int x,int y) {
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
    //functions:
    //Image addition
    protected void addImage(ImageIcon imageIcon, int x, int y, int width, int height) {
        Image image = imageIcon.getImage();  // Get the Image from the ImageIcon
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);  // Resize the image
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledImageIcon); // Create JLabel to hold the image
        imageLabel.setBounds(x, y, width, height); // Set bounds for positioning
        add(imageLabel); // Add the label with the image to the window
    }//Image addition

    //Label Addition:
    protected JLabel addLabelWhichReturns(
            String text, String fontName, int fontStyle, int fontSize,
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


    //text field + labels:
    protected JTextField addLabelWithTextField(
            String labelText, String labelFontName, int labelFontStyle, int labelFontSize,
            int x, int y, int labelTextR, int labelTextG, int labelTextB, int labelWidth, int spacing,
            String textFieldFontName, int textFieldFontStyle, int textFieldFontSize,
            int textFieldWidth, int textFieldHeight,
            int textFieldColorR, int textFieldColorG, int textFieldColorB,
            int borderR, int borderG, int borderB, int bgR, int bgG, int bgB, int arc,
            boolean transparent, int opacityLevel,int textFieldX // text field x position override
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


//password fields and labels:

    protected JPasswordField addLabelWithPasswordField(
            String labelText, String labelFontName, int labelFontStyle, int labelFontSize,
            int x, int y, int labelTextR, int labelTextG, int labelTextB, int labelWidth, int spacing,
            String textFieldFontName, int textFieldFontStyle, int textFieldFontSize,
            int textFieldWidth, int textFieldHeight,
            int textFieldColorR, int textFieldColorG, int textFieldColorB,
            int borderR, int borderG, int borderB, int bgR, int bgG, int bgB, int arc,
            boolean transparent, int opacityLevel,int textFieldX // text field x position override
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



    //Buttons:
    //plain buttons:
    public JButton addRoundedButton(String text, String fontName, int fontStyle, int fontSize,
                                    int x, int y, int width, int height, boolean opaque, // Means fully opaque or not
                                    boolean transparent, int opacityLevel,
                                    int baseTextR, int baseTextG, int baseTextB,
                                    int baseBorderR, int baseBorderG, int baseBorderB,
                                    int baseBgR, int baseBgG, int baseBgB, int cornerRadius) {
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
        button.setBorder(new RoundedBorderFinal(cornerRadius, borderColor));
        button.setFocusPainted(false); // Remove the white focus box

        // 7. Hover & Click Effect
        Color normalColor = new Color(50, 150, 250);
        Color hoverColor = new Color(97, 24, 24);
        Color clickColor = new Color(97, 24, 24);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // Hover border & text
                button.setBorder(new RoundedBorderFinal(cornerRadius, hoverColor));
                button.setForeground(hoverColor);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Reset to base border & text
                button.setBorder(new RoundedBorderFinal(cornerRadius, borderColor));
                button.setForeground(new Color(baseTextR, baseTextG, baseTextB));
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                // Click border & maybe background
                button.setBorder(new RoundedBorderFinal(cornerRadius, clickColor));
//                if (!transparent) {
//                    button.setBackground(clickColor);
//                }
                button.setBackground(clickColor);
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (button.getBounds().contains(evt.getPoint())) {
                    button.setBorder(new RoundedBorderFinal(cornerRadius, hoverColor));
                    if (!transparent) {
                        button.setBackground(hoverColor);
                    }
                } else {
                    button.setBorder(new RoundedBorderFinal(cornerRadius, borderColor));
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

    //radio Buttons:
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
    //helper for these buttons:
    private void styleCustomRadioButton(JRadioButton radioButton) {
        radioButton.setOpaque(false);
        radioButton.setFocusPainted(false);
        radioButton.setContentAreaFilled(false);
        radioButton.setBorderPainted(false);

        // Set custom icons for default and selected states
        radioButton.setIcon(createRadioIcon(false));
        radioButton.setSelectedIcon(createRadioIcon(true));
    }
    //fk awt fk swing useless
    //gotta do it all:
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
                    g2.setColor(new Color(220,220,220)); // Default fill color
                    g2.fillOval(x + 2, y + 2, size - 4, size - 4);
                }
                g2.dispose();
            }

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


    //Calender with label
    protected JDateChooser addLabelWithTextFieldWithCalenderMewMew2(
            // Label parameters:
            String labelText, String labelFontName, int labelFontStyle, int labelFontSize,
            int x, int y, int labelTextR, int labelTextG, int labelTextB, int labelWidth, int spacing,

            // Date chooser parameters:
            String dateChooserFontName, int dateChooserFontStyle, int dateChooserFontSize,
            int dateChooserWidth, int dateChooserHeight,
            int dateChooserTextColorR, int dateChooserTextColorG, int dateChooserTextColorB,
            int borderR, int borderG, int borderB,
            int bgR, int bgG, int bgB, int arc,
            boolean transparent, int opacityLevel,
            // Optional override for the text field's x position
            int dateChooserX
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

        String calendarIconPath = "C:\\xtra\\Last_Chance\\BMS\\src\\icons\\calendar.png";

        // Create a custom panel that will serve as the date chooser container.
        JPanel dateChooserPanel = new JPanel() {
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
                super.paintComponent(g); // Draw any child components on top
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
        dateChooserPanel.setLayout(null);
        dateChooserPanel.setOpaque(false);

        // Set dateChooserPanel bounds
        int panelX = (dateChooserX > 0) ? dateChooserX : (x + labelWidth + spacing);
        dateChooserPanel.setBounds(panelX, y, dateChooserWidth, dateChooserHeight);

        // Create the JDateChooser
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setFont(new Font(dateChooserFontName, dateChooserFontStyle, dateChooserFontSize));
        dateChooser.setBounds(0, 0, dateChooserWidth, dateChooserHeight);
        dateChooser.setOpaque(false);
        dateChooser.setBackground(new Color(0, 0, 0, 0));

        // Get internal JTextField and make it transparent
        JTextField editor = (JTextField) dateChooser.getDateEditor().getUiComponent();
        editor.setOpaque(false);
        editor.setBackground(new Color(0, 0, 0, 0));
        editor.setBorder(null);
        editor.setForeground(new Color(dateChooserTextColorR, dateChooserTextColorG, dateChooserTextColorB));
        editor.setCaretColor(new Color(dateChooserTextColorR, dateChooserTextColorG, dateChooserTextColorB));
        editor.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 40)); // Add padding for the icon

        // 📅 Add Calendar Icon
        JButton calendarButton = dateChooser.getCalendarButton();
        ImageIcon calendarIcon = new ImageIcon(new ImageIcon(calendarIconPath)
                .getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH)); // Use custom icon
        calendarButton.setIcon(calendarIcon);
        calendarButton.setOpaque(false);
        calendarButton.setContentAreaFilled(false);
        calendarButton.setBorder(BorderFactory.createEmptyBorder());
        calendarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        calendarButton.setFocusable(false);

        // Position the calendar button on the right side inside the dateChooserPanel
        calendarButton.setBounds(dateChooserWidth - 35, (dateChooserHeight - 30) / 2, 30, 30);
        dateChooserPanel.add(calendarButton);

        // Add components to the panel
        dateChooserPanel.add(dateChooser);
        add(dateChooserPanel);

        return dateChooser;
    }

    //DropDown + +Label
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


    //CheckBox:
    protected JCheckBox createCheckButton(String text, String fontName, int fontStyle, int fontSize,
                                          int x, int y, int width, int height, Color textColor) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(new Font(fontName, fontStyle, fontSize));
        checkBox.setBounds(x, y, width, height);
        checkBox.setForeground(textColor);
        checkBox.setOpaque(false);
        checkBox.setFocusPainted(false);
        checkBox.setContentAreaFilled(false);
        checkBox.setBorderPainted(false);
        add(checkBox);// Apply existing styling
        return checkBox;
    }

    //    Additional Functions:
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

}
class RoundedBorderFinal implements Border {
    private final int radius;
    private final Color borderColor;
    private Color fillColor = null; // Optional fill color (null if no fill)

    public RoundedBorderFinal(int radius, Color borderColor) {
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

