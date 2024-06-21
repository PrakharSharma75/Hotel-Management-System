// import javax.swing.JComboBox;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JRadioButton;
// import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{

    JComboBox comboid;
    JTextField tfnumber, tfname, tfcountry, tfdeposite;
    JRadioButton rmale, rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add, back;
    
    AddCustomer(){
         
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setFont(new Font("Railway", Font.PLAIN, 19));
        text.setBackground(Color.blue);
        text.setBounds(100, 20, 300, 30);
        add(text);

         JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Railway", Font.PLAIN, 19));
        lblid.setBackground(Color.blue);
        lblid.setBounds(35, 80, 100, 30);
        add(lblid);

        String options[] = {"Aadhar Card", "Password", "Driving License", "Voter-id Card", "Rotation Card"};
        comboid = new JComboBox(options);
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

          JLabel lblnumber = new JLabel("NUMBER");
        lblnumber.setFont(new Font("Railway", Font.PLAIN, 19));
        lblnumber.setBackground(Color.blue);
        lblnumber.setBounds(35, 120, 100, 30);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200, 120, 150, 25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setFont(new Font("Railway", Font.PLAIN, 19));
        lblname.setBackground(Color.blue);
        lblname.setBounds(35, 160, 100, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);

         JLabel lblgender = new JLabel("GENDER");
        lblgender.setFont(new Font("Railway", Font.PLAIN, 19));
        lblgender.setBackground(Color.blue);
        lblgender.setBounds(35, 200, 100, 30);
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200, 200, 60, 25);
        add(rmale);

         rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270, 200, 100, 25);
        add(rfemale);

        JLabel lblcountry = new JLabel("COUNTRY");
        lblcountry.setFont(new Font("Railway", Font.PLAIN, 19));
        lblcountry.setBackground(Color.blue);
        lblcountry.setBounds(35, 240, 100, 30);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        add(tfcountry);

         JLabel lblroom = new JLabel("Room Number");
        lblroom.setFont(new Font("Railway", Font.PLAIN, 19));
        lblroom.setBackground(Color.blue);
        lblroom.setBounds(35, 280, 150, 30);
        add(lblroom);


        croom = new Choice();

        try{
          
          Conn conn = new Conn();
          String query = "Select * from room where availability = 'Available'";
          ResultSet rs = conn.s.executeQuery(query);
          while(rs.next()){
            croom.add(rs.getString("roomnumber"));
          }

        }catch(Exception e){
          e.printStackTrace();
        }
        croom.setBounds(200, 280, 150, 25);
        add(croom);

        JLabel lbltime = new JLabel("Checkin Time");
        lbltime.setFont(new Font("Railway", Font.PLAIN, 20));
        lbltime.setBounds(35, 320, 150, 25);
        add(lbltime);

         Date date = new Date();
         
         checkintime = new JLabel(""+date);
        checkintime.setFont(new Font("Railway", Font.PLAIN, 14));
        checkintime.setBackground(Color.blue);
        checkintime.setBounds(200, 320, 150, 25);
        add(checkintime);

         JLabel lbldeposite = new JLabel("Deposite");
        lbldeposite.setFont(new Font("Railway", Font.PLAIN, 19));
        lbldeposite.setBackground(Color.blue);
        lbldeposite.setBounds(35, 360, 100, 30);
        add(lbldeposite);

        tfdeposite = new JTextField();
        tfdeposite.setBounds(200, 360, 150, 25);
        add(tfdeposite);
 
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50, 410, 120, 30);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 410, 120, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(380,380,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);

        setBounds(350, 200, 800,550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
      
       if(ae.getSource() == add){

        String id = (String) comboid.getSelectedItem();
        String number = tfnumber.getText();
        String name = tfname.getText();
        String gender = null;

        if(rmale.isSelected()){
          gender = "Male";
        }else{
          gender = "Female";
        }

        String country = tfcountry.getText();
        String room = croom.getSelectedItem();
        String time = checkintime.getText();
        String deposite = tfdeposite.getText();

        try{

        String query = "insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+time+"', '"+deposite+"')";
        String query2 = "update rooom set  availability = 'Occupied' = '"+room+"' ";
  
        Conn conn = new Conn();
        
        conn.s.executeUpdate(query);
        conn.s.executeUpdate(query2);

        JOptionPane.showMessageDialog(null, "New Customer Added Successfully");

        setVisible(false);
        new Reception();
        
        }catch(Exception e){

         e.printStackTrace();
        }

       }else if(ae.getSource() == back){
          
        setVisible(false);
        new Reception();

       }

    }
    

    public static void main(String[] args) {
       new AddCustomer();
    }
}

