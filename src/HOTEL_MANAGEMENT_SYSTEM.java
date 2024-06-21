//package PROJECTS;
//package "F:\PRAKHAR\JAVA PRAKHAR\PROJECTS";

import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HOTEL_MANAGEMENT_SYSTEM extends JFrame implements ActionListener{

    HOTEL_MANAGEMENT_SYSTEM(){
     setSize(1366, 565);
     setLocation(100, 100);
      setVisible(true);
     setLayout(null);
       

     ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("images/first.jpg"));
     JLabel image = new JLabel(il);
     image.setBounds(0,0,1400,560);
     add(image);

     JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
     text.setBounds(20,430 , 1000, 90);
     text.setForeground(Color.RED);
     text.setFont(new Font("serif",Font.PLAIN,50));
     image.add(text);

     JButton next = new JButton("LOGIN");
     next.setBounds(1150, 450, 150, 50);
     next.setBackground(Color.RED);
     next.setForeground(Color.WHITE);
     next.addActionListener(this);
     next.setFont(new Font("serif",Font.PLAIN, 24));
     image.add(next);

     while (true) {
        text.setVisible(false);
        try{
            Thread.sleep(500);
        } catch (Exception e){
            e.printStackTrace();
        }
        text.setVisible(true);
         try{
            Thread.sleep(500);
        } catch (Exception e){
            e.printStackTrace();
        }
     }
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
   public static void main(String[] args){
        new HOTEL_MANAGEMENT_SYSTEM();
    }
}