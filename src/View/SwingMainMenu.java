package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static com.sun.glass.ui.Cursor.setVisible;
import static com.sun.javafx.fxml.expression.Expression.add;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by noahr on 5/3/2017.
 */

public class SwingMainMenu extends JFrame {
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JLabel message = new JLabel();
    JTextField cardNameField = new JTextField("Card name)");
    JTextField manaField = new JTextField("Card name)");
    private JButton submitButton = new JButton("Submit");
    private JButton cancelButton = new JButton("Cancel");
    private JButton reportButton = new JButton("Generate Report");
    private JLabel regInfo = new JLabel();

    public SwingMainMenu(){
        init();
    }


    /**
     * Initialize the contents of this UI
     */

    private void init(){
        TitledBorder registerBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "Register");
        registerBorder.setTitleJustification(TitledBorder.CENTER);
        add(tabbedPane, BorderLayout.NORTH);
        JPanel buttons = new JPanel();
        buttons.add(message);
        buttons.add(submitButton);
        buttons.add(cancelButton);
        buttons.add(reportButton);
        buttons.add(cardNameField);
        JPanel info = new JPanel(new BorderLayout());
        info.add(buttons, BorderLayout.EAST);
        regInfo.setBorder(registerBorder);
        info.add(regInfo, BorderLayout.WEST);
        add(info, BorderLayout.SOUTH);
        setTitle("Hearthstone Analytics");
        int initialHeight = 600;
        int initialWidth = 850;
        setMinimumSize(new Dimension(initialWidth, initialHeight));
        setSize(initialWidth, initialHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
