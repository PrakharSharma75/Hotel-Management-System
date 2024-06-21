import java.awt.Color;
import java.awt.event.AWTEventListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {

    JTextField username_tf, password_tf;
    JButton login, cancel;
    /**
     * 
     */
    Login(){
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);

        JLabel user_l = new JLabel("Username");
        user_l.setBounds(40, 20, 100, 30);
        add(user_l);  
          
        username_tf = new JTextField();
        username_tf.setBounds(150, 20, 150, 30);
        add(username_tf);

        JLabel password_l = new JLabel("Password");
        password_l.setBounds(40, 70, 100, 30);
        add(password_l);  
      
        password_tf = new JTextField();
        password_tf.setBounds(150, 70, 150, 30);
        add(password_tf);
        
        login = new JButton("LOGIN");
        login.setBounds(40, 150, 120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("CANCEL");
        cancel.setBounds(180, 150, 120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
         JLabel Image = new JLabel(i3);
        Image.setBounds(350, 10, 200, 200);
        add(Image);

    setBounds(500, 200, 600,  300);
     setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       
        if(ae.getSource() == login){
       
        String user = username_tf.getText();
         String pass = password_tf.getText();
         
         try{
           Conn c = new Conn();

           String query = "select * from login where username = '"+ user +"' and password ='"+ pass +"'";
  
           ResultSet rs= c.s.executeQuery(query);


           if(rs.next()){
            setVisible(false);
            new Dashboard();
            
          }else{
            JOptionPane.showMessageDialog(null, "Invalid username and password ");
            setVisible(false);
           }

         }catch(Exception e){
           e.printStackTrace();
         }

        }else if (ae.getSource() == cancel){
               setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
