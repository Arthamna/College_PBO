/**
 * Write a description of class LoginFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 

public class LoginFrame
{
    private final String USERNAME = "testing1";
    private final String PASSWORD = "pass";

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().go());
    }
    public void go(){  
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Username:"), c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.WEST;
        txtUsername = new JTextField(15);
        panel.add(txtUsername, c);

        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Password:"), c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.WEST;
        txtPassword = new JPasswordField(15); 
        panel.add(txtPassword, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        JPanel btnPanel = new JPanel();
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new LoginListener());
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new CancelListener());
        btnPanel.add(btnLogin);
        btnPanel.add(btnCancel);
        panel.add(btnPanel, c);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }  
    public class LoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String enteredUser = txtUsername.getText();
            String enteredPass = new String(txtPassword.getPassword()); 

            String msg;
            if (USERNAME.equals(enteredUser) && PASSWORD.equals(enteredPass)) {
                msg = "Login Granted!";
            } else {
                msg = "Login Denied";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
        }
    public class CancelListener implements ActionListener{  
        public void actionPerformed(ActionEvent event){  
          txtUsername.setText("");  
          txtPassword.setText("");  
          txtUsername.requestFocusInWindow();  
        }  
      }  
}