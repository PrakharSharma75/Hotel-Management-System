import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame {

    JComboBox comboid;
    JTextField tfnumber, tfname;
    JRadioButton rmale, rfemale;
    
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
        lblgender.setBounds(35, 160, 100, 30);
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200, 200, 60, 25);
        add(rmale);

         rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270, 200, 100, 25);
        add(rfemale);


        setBounds(350, 200, 800,550);
        setVisible(true);
    }



    public static void main(String[] args) {
       new AddCustomer();
    }
}
