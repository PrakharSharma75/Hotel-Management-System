import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;


public class Checkout extends JFrame implements ActionListener{
    Choice ccustomer;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime;
    JButton checkout , back;
    
    Checkout() {

    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel text = new JLabel("Checkout");
    text.setBounds(100, 20, 100, 30);
    text.setForeground(Color.BLUE);
    text.setFont(new Font("Tohoma", Font.PLAIN, 20));
    add(text);

    JLabel lblid = new JLabel("Customer ID");
    lblid.setBounds(30, 80, 100, 30);
    lblid.setForeground(Color.BLUE);
    add(lblid);

    ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 120, 25);
        add(ccustomer);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/tick.png"));
         Image i2 = i1.getImage().getScaledInstance(20, 20 ,Image.SCALE_DEFAULT );
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(310, 80, 20, 20);
         add(image);

         JLabel lblroom = new JLabel("Room Number");
         lblroom.setBounds(30, 130, 100, 30);
         lblroom.setForeground(Color.BLUE);
         add(lblroom);

         lblroomnumber = new JLabel();
         lblroomnumber.setBounds(150, 130, 100, 30);
         add(lblroomnumber);

         JLabel lblcheckin = new JLabel("Checkin Time");
         lblcheckin.setBounds(30, 180, 100, 30);
         lblcheckin.setForeground(Color.BLUE);
         add(lblcheckin);

         lblcheckintime = new JLabel();
         lblcheckintime.setBounds(150, 180, 100, 30);
         add(lblcheckintime);

         JLabel lblcheckout = new JLabel("Checkout Time");
         lblcheckout.setBounds(30, 230, 100, 30);
         lblcheckout.setForeground(Color.BLUE);
         add(lblcheckout);

         Date date = new Date();

         lblcheckouttime = new JLabel("" + date);
         lblcheckouttime.setBounds(150, 230, 150, 30);
         add(lblcheckouttime);


         checkout = new JButton("Checkout");
         checkout.setBackground(Color.BLACK);
         checkout.setForeground(Color.WHITE);
         checkout.setBounds(30, 280, 120, 30);
         checkout.addActionListener(this);
         add(checkout);
         
         back = new JButton("Back");
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         back.setBounds(170, 280, 120, 30);
         back.addActionListener(this);
         add(back);

         try{

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while(rs.next()){
             ccustomer.add(rs.getString("number"));
             lblroomnumber.setText(rs.getString("room"));
             lblcheckintime.setText(rs.getString("checkintime"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }


         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Images/sixth.jpg"));
         Image i5 = i4.getImage().getScaledInstance(400, 250 ,Image.SCALE_DEFAULT );
         ImageIcon i6 = new ImageIcon(i5);
         JLabel imagep = new JLabel(i6);
         imagep.setBounds(350, 50, 400, 250);
         add(imagep);

     setBounds(300, 200, 800, 400);
     setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == checkout){
         String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
         String query2 = "update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"' " ;
         
         try{
          Conn conn = new Conn();
          conn.s.executeUpdate(query1);
          conn.s.executeUpdate(query2);

          JOptionPane.showMessageDialog(null, "Checkout done");

          setVisible(false);
          new Reception();

         }catch(Exception e){
            e.printStackTrace();
         }
      }else{
        setVisible(false);
        new Reception();
      }
    }
    public static void main(String[] args) {
        new Checkout();
    }
}
