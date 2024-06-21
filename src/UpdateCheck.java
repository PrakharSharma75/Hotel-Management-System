import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener{

    Choice ccustomer;
    JTextField tfroom, tfname, tfcheckin, tfamount, tfamountpending;
    JButton check, update, back; 

    UpdateCheck(){
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setForeground(Color.blue);
        text.setBounds(90, 20, 200, 30);
        add(text);


        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);

        try{

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while(rs.next()){
             ccustomer.add(rs.getString("number"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 120, 100, 20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 25);
        add(tfroom);

         JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 160, 100, 20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);

         JLabel lblcheckin = new JLabel("CheckIn Time");
        lblcheckin.setBounds(30, 200, 100, 20);
        add(lblcheckin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 200, 150, 25);
        add(tfcheckin);

          JLabel lblamount = new JLabel("Amount Paid");
        lblamount.setBounds(30, 240, 100, 20);
        add(lblamount);

        tfamount = new JTextField();
        tfamount.setBounds(200, 240, 150, 25);
        add(tfamount);

        JLabel lblamountpending = new JLabel("Pending Amount");
        lblamountpending.setBounds(30, 280, 100, 20);
        add(lblamountpending);

        tfamountpending = new JTextField();
        tfamountpending.setBounds(200, 280, 150, 25);
        add(tfamountpending);

        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 340, 100, 30);
        check.addActionListener(this);
        add(check);


        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150, 340, 100, 30);
        update.addActionListener(this);
        add(update);
 

         back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,340, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("Images/nine.jpg"));
        JLabel image = new JLabel(l1);
        image.setBounds(400, 50, 500, 300);
        add(image);


       setBounds(300, 200, 980, 500);
       setVisible(true);

    }
    

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){

            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";

            try{

                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkin"));
                    tfamount.setText(rs.getString("deposite"));
                    
                } 

                ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfamount.getText());
                    tfamountpending.setText("" + amountPaid);
                } 
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == update){
          String number = ccustomer.getSelectedItem();
          String room = tfroom.getSelectedText();
          String name = tfname.getSelectedText();
          String checkin = tfcheckin.getSelectedText();
          String amount = tfamountpending.getSelectedText();
          
          try{
            Conn conn = new Conn();
            conn.s.executeUpdate("update customer set room = '"+room+"', checkintime = '"+checkin+"', deposite ='"+amount+"' where number = '"+number+"");

            JOptionPane.showMessageDialog(null, "Data Update Successfully");
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
        
        new UpdateCheck();
    }
}
