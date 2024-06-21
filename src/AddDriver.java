import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener {

    JTextField tfname, tfmodel, tfage, tfcompany, tflocation;
    JButton add, cancel;
    JComboBox typeCombo, availableCombo, ageCombo,genderCombo;

    AddDriver(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD Drives");
        heading.setFont(new Font("Tahoma", Font.BOLD, 19));
        heading.setBounds(150, 10, 200, 20);
        add(heading);

         JLabel lblname = new JLabel("NAME :");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblname.setBounds(60, 70, 120, 30);
        add(lblname);

         tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 30);
        add(tfname);

         JLabel lblage = new JLabel(" AGE:");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblage.setBounds(60, 110, 120, 30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 110, 150, 30);
        add(tfage);

         JLabel lblgender = new JLabel(" GENDER :");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblgender.setBounds(60, 150, 120, 30);
        add(lblgender);

        String cleanOptions[] = {"MALE", "FEMALE"};
        genderCombo = new JComboBox(cleanOptions);
        genderCombo.setBounds(200, 150, 150, 30);
        genderCombo.setBackground(Color.white);
        add(genderCombo);

         JLabel lblprice = new JLabel("CAR COMPANY :");
         lblprice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblprice.setBounds(60, 190, 120, 30);
        add(lblprice);

        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);
        
         JLabel lbltype = new JLabel(" CAR MODEL :");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbltype.setBounds(60, 230, 120, 30);
        add(lbltype);

       tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);


        JLabel lblavailable = new JLabel(" Available :");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblavailable.setBounds(60, 270, 120, 30);
        add(lblavailable);

        String driverOptions[] = {"Available", "Busy"};
        availableCombo = new JComboBox(driverOptions);
        availableCombo.setBounds(200, 270, 150, 30);
        availableCombo.setBackground(Color.white);
        add(availableCombo);
         

         JLabel lbllocation = new JLabel(" LOCATION :");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbllocation.setBounds(60, 310, 120, 30);
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 150, 30);
        add(tflocation);

        add = new JButton("Add Driver");
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 370, 130, 30);
        add.addActionListener(this);
        add(add);

        
        cancel = new JButton("Cancel ");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 370, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 370);
        add(image);
        

       setBounds(300, 200, 980, 470);
       setVisible(true);     
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==add){

           String name = tfname.getText();
           String age = tfage.getText();
           String gender = (String) genderCombo.getSelectedItem();
           String company = tfcompany.getText();
           String model = tfmodel.getText();
           String availability = (String) availableCombo.getSelectedItem();
           String location = tflocation.getText();

           try{

            Conn conn = new Conn();
            String str = "insert into driver Values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+model+"', '"+availability+"', '"+location+"')";

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
       new AddDriver();
    }
}
