import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
         setBounds(0, 0, 1500, 1000);
         setVisible(true);
         setLayout(null);

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//third.jpg"));
         Image i2 = i1.getImage().getScaledInstance(1550, 970 ,Image.SCALE_DEFAULT );
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0, 0, 1550, 1000);
         add(image);

         JLabel text = new JLabel("THE LILA PALACE WELCOMES YOU");
         text.setBounds(400, 80, 1000, 50);
         text.setFont(new Font("Tahoma", Font.PLAIN, 50));
         text.setForeground(Color.white);
         image.add(text);

         JMenuBar mb = new JMenuBar();
         mb.setBounds(0, 0, 1550, 30);
         image.add(mb);

         JMenu hotel = new JMenu("HOTEL MANAGEMENT");
         hotel.setForeground(Color.RED);
         hotel.setFont(new Font("serif",Font.PLAIN,20));
         mb.add(hotel);

         JMenuItem reception = new JMenuItem("RECEPTION");
         reception.addActionListener(this);
         hotel.add(reception);

         JMenu admin = new JMenu("ADMIN");
         admin.setForeground(Color.BLUE);
         admin.setFont(new Font("serif",Font.PLAIN,20));
         mb.add(admin);

         JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
         addemployee.addActionListener(this);
         admin.add(addemployee);

          JMenuItem addrooms = new JMenuItem("ADD ROOMS");
          addrooms.addActionListener(this);
         admin.add(addrooms);

          JMenuItem adddrivers = new JMenuItem("ADD DRIVER");
          adddrivers.addActionListener(this);
         admin.add(adddrivers);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }else if(ae.getActionCommand().equals("ADD ROOMS")){
            new Addrooms();
        }else if(ae.getActionCommand().equals("ADD DRIVER")){
            new AddDriver();
        }else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    public static void main(String[] args) {
        new Dashboard();
    }
}