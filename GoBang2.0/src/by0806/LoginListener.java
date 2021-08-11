package by0806;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    private JTextField jTFUser;
    private JTextField jTFPassword;
    BiangGoBangUI goBangUi;
    //JFrame startJf ;
    JFrame loginJf ;

    public void setjTFUser(JTextField jTFUser) {this.jTFUser = jTFUser; }
    public void setjTFPassword(JTextField jTFPassword) {this.jTFPassword = jTFPassword; }
    public void setGoBangUi(BiangGoBangUI goBangUi) {this.goBangUi = goBangUi; }
    //public void setStartJf(JFrame startJf) {this.startJf = startJf; }
    public void setLoginJf(JFrame loginJf) {this.loginJf = loginJf; }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnStr = e.getActionCommand();
        String jTFUserStr = jTFUser.getText();
        String jTFPasswordStr = jTFPassword.getText();
        if(btnStr.equals("登录")){
            if(jTFUserStr.equals("Stefan") && jTFPasswordStr.equals("0410")){

                loginJf.setVisible(false);
                goBangUi.startGame();
            }
        }
    }
}
