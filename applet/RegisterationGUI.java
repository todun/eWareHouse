import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisterationGUI extends JApplet implements ActionListener {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int CHAR45 = 45;
    public static final int CHAR30 = 30;
    public static final int CHAR12 = 12;

    JTextField userNameField;
    JTextField passwordField;
    JTextField contactInfoField;
    JTextField localeField;

    public void init() {
        setLayout(new GridLayout(9, 1));
        JLabel userNameLabel = new JLabel("Username:");//30 char max
        JLabel passwordLabel = new JLabel("Password:");//12 char max
        JLabel contactInfoLabel = new JLabel("Phone Number:");//12 char max
        JLabel localeLabel = new JLabel("Campus:");//45 char max
        userNameField = new JTextField(CHAR30);
        passwordField = new JTextField(CHAR12);
        contactInfoField = new JTextField(CHAR12);
        localeField = new JTextField(CHAR45);
        JButton saveButton = new JButton("SAVE");
        add(userNameLabel);
        add(userNameField);
        add(passwordLabel);
        add(passwordField);
        add(contactInfoLabel);
        add(contactInfoField);
        add(localeLabel);
        add(localeField);
        add(saveButton);
        saveButton.addActionListener(this);
    }
        
        public void actionPerformed(ActionEvent e) {
            try {
                String userName = userNameField.getText();
                String password = passwordField.getText();
                String contactInfo =
                    contactInfoField.getText();
                String locale = localeField.getText();
                PrintWriter outputStream =
                    new PrintWriter(new FileOutputStream("tempDatabase.txt",
                        true));
                outputStream.print(userName + " ");
                outputStream.print(password + " ");
                outputStream.print(contactInfo + " ");
                outputStream.println(locale + " ");
                outputStream.close();
            } catch (NullPointerException error) {
                JOptionPane.showMessageDialog(null,
                    "A(Several) infomation field(s) is(are) left blank.");
            } catch (FileNotFoundException error) {
                JOptionPane.showMessageDialog(null,
                    "A FileNotFoundException was thrown. Save failed");
            }
        }
}
