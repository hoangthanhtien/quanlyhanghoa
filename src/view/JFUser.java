package view;

import controller.IvtUserController;
import model.IvtUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JFUser {
    public static void main(String[] args) {
        // Creating instance of JFrame
        JFrame frame = new JFrame("Phần mềm quản lý hàng hóa");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Creating panel. This is same as a div tag in HTML
         * We can create several panels and add them to specific
         * positions in a JFrame. Inside panels we can add text
         * fields, buttons and other components.
         */
        JPanel panel = new JPanel();
        // adding panel to frame
        frame.add(panel);
        /* calling user defined method for adding components
         * to the panel.
         */
        placeComponents(panel);

        // Setting the frame visibility to true
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* We will discuss about layouts in the later sections
         * of this tutorial. For now we are setting the layout
         * to null
         */
        panel.setLayout(null);

        // Creating JLabel
        JLabel userLabel = new JLabel("User email");
        /* This method specifies the location and size
         * of component. setBounds(x, y, width, height)
         * here (x,y) are cordinates from the top left
         * corner and remaining two arguments are the width
         * and height of the component.
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        /* Creating text field where user is supposed to
         * enter user name.
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // Same process for password label and text field.
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /*This is similar to text field but it hides the user
         * entered data and displays dots instead to protect
         * the password like we normally see on login screens.
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // Creating login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(20, 90, 100, 30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordText.getText();
                String email = userText.getText();
                boolean logedIn = IvtUserController.login(email, password);
                if(logedIn){
                    System.out.println("OK");
                    JFItem itemView = new JFItem();
                    itemView.viewItem();
                }else{
                    JOptionPane.showMessageDialog(panel,"Mật khẩu hoặc tài khoản không chính xác");
                }
            }
        });
        panel.add(loginButton);
        // Creating SignUp button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(150,90,100,30);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordText.getText();
                String email = userText.getText();
                String userName = null;
                boolean emailExisted = IvtUserController.checkEmailExists(email);
                if(emailExisted == true){
                   JOptionPane.showMessageDialog(panel, "Đăng ký không thành công, email này đã tồn tại");
                }
                IvtUserController.signUp(userName, email, password);
                JOptionPane.showMessageDialog(panel, "Đăng ký thành công");
            }
        });
        panel.add(signUpButton);
    }
}