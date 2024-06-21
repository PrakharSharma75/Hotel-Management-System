import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;

public class Addrooms extends JFrame implements ActionListener {

    JTextField tfroom, tfprice;
    JButton add, cancel;
    JComboBox typeCombo, availableCombo, cleanCombo;
    Addrooms(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 19));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

         JLabel lblroomnumber = new JLabel("ROOM NO. :");
        lblroomnumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblroomnumber.setBounds(60, 80, 120, 30);
        add(lblroomnumber);

         tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);

         JLabel lblavailable = new JLabel(" AVAILABLE:");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);

        String availableOptions[] = {"Available", "Occupied"};
        availableCombo = new JComboBox(availableOptions);
        availableCombo.setBounds(200, 130, 150, 30);
        availableCombo.setBackground(Color.white);
        add(availableCombo);

         JLabel lblclean = new JLabel(" CLEANING STATUS :");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);

        String cleanOptions[] = {"Clean", "Dirty"};
        cleanCombo = new JComboBox(cleanOptions);
        cleanCombo.setBounds(200, 180, 150, 30);
        cleanCombo.setBackground(Color.white);
        add(cleanCombo);

         JLabel lblprice = new JLabel("PRICE :");
         lblprice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblprice.setBounds(60, 230, 120, 30);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);
        
         JLabel lbltype = new JLabel(" BED TYPE :");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbltype.setBounds(60, 280, 120, 30);
        add(lbltype);

        String typeOptions[] = {"Single Bed", "Double Bed"};
         typeCombo = new JComboBox(typeOptions);
        typeCombo.setBounds(200, 280, 150, 30);
        typeCombo.setBackground(Color.white);
        add(typeCombo);

        add = new JButton("Add Room");
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);

        
        cancel = new JButton("Cancel ");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 370);
        add(image);
        

       setBounds(330, 200, 940, 470);
       setVisible(true);     
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==add){

           String roomnumber = tfroom.getText();
           String availability = (String) availableCombo.getSelectedItem();
           String status = (String) cleanCombo.getSelectedItem();
           String price = tfprice.getText();
           String type = (String) typeCombo.getSelectedItem();

           try{

            Conn conn = new Conn();
            String str = "insert into room Values('"+roomnumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"')";

            conn.s.executeUpdate(str);

            JOptionPane.showMessageDialog(null, "Updated successfully ");
            setVisible(false);

           }catch(Exception e){
            e.printStackTrace();
           }

        }else{
            setVisible(false);
        }
 
    }
        
    public static void main(String[] args) {
        new Addrooms();
    }
}
