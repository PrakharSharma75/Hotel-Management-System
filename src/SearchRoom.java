import javax.swing.*;
 

import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import net.proteanit.sql.*;


public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back, submit;
    JComboBox bedTtype;
    JCheckBox available;
   SearchRoom(){
  
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);

       JLabel text = new JLabel("Search for Rooms");
       text.setFont(new Font("Tahoma", Font.PLAIN, 20));
       text.setBounds(400, 30, 200, 30);
       add(text);
      
        JLabel lblbed = new JLabel("Bed Type");
       lblbed.setBounds(50, 100, 100, 20);
       add(lblbed);

       bedTtype = new JComboBox(new String[]{"Single Bed", "Double Bed"});
       bedTtype.setBounds(150, 100, 150, 25);
       bedTtype.setBackground(Color.WHITE);
       add(bedTtype);

       available = new JCheckBox("Only diisplay Available");
       available.setBounds(650, 100, 150, 25);
       available.setBackground(Color.WHITE);
       add(available);

  
        JLabel l1 = new JLabel("Room Numbers");
        l1.setBounds(10, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(270, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(450, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(670, 160, 100, 20);
        add(l4);

         JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(87, 10, 100, 20);
        add(l5);               

         submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300, 520, 120, 30);
        add(submit);


        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500, 520, 120, 30);
        add(back);




        table = new JTable();
        table.setBounds(0, 200, 1000, 400);
        add(table);

        try{

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
           e.printStackTrace();
        }

        
       setBounds(300, 200, 1000, 600);
       setVisible(true);
    }

     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){

            try{

                String query1 = "select * from room where be_type = '"+bedTtype.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedTtype.getSelectedItem()+"'";

                Conn conn = new Conn();
                ResultSet rs;

                if(available.isSelected()){
                   rs = conn.s.executeQuery(query2);          
                }else {
                    rs = conn.s.executeQuery(query1);

                }
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch(Exception e){
                e.printStackTrace();
            }
        } else{
            setVisible(false);
            new Reception();
        }  
        setVisible(false);
           new Reception();
     }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
