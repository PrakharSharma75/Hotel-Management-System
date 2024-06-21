import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {

  JButton newCustomer, rooms, department, allEmployee, managerInfo, customers, searchRoom,checkout, Update , roomStatus, pickup, logout;
  Reception(){


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

         newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.black);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);

         rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
         department = new JButton("Department");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.black);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

         allEmployee = new JButton("All Employee");
        allEmployee.setBounds(10, 150, 200, 30);
        allEmployee.setBackground(Color.black);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

         customers = new JButton("Customer Info");
        customers.setBounds(10, 190, 200, 30);
        customers.setBackground(Color.black);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);

        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10, 230, 200, 30);
        managerInfo.setBackground(Color.black);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);

        checkout = new JButton("Checkout");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);


        Update = new JButton("Update Status");
        Update.setBounds(10, 310, 200, 30);
        Update.setBackground(Color.black);
        Update.setForeground(Color.WHITE);
        add(Update);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setBackground(Color.black);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);

        pickup = new JButton("Pickup Service");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);

          JButton search = new JButton("Search Room");
        search.setBounds(10, 430, 200, 30);
        search.setBackground(Color.black);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        logout = new JButton("Logout");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,470,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250, 30, 500, 470);
        add(image);

        setBounds(350, 200, 800, 570 );
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){

      if(ae.getSource() == newCustomer){

        setVisible(false);
        new AddCustomer();
      }else if(ae.getSource() == rooms){
        setVisible(false);
        new Room();
      }else if(ae.getSource() == department){
        setVisible(false);
        new Department();
      }else if(ae.getSource() == allEmployee){
        setVisible(false);
        new Employee();
      }else if(ae.getSource() == managerInfo ){
        setVisible(false);
        new ManagerInfo();
      }else if(ae.getSource() == customers){
        setVisible(false);
        new CustomerInfo();
      }else if(ae.getSource() == roomStatus){
        setVisible(false);
        new Updateroom();
      }else if(ae.getSource() == pickup){
        setVisible(false);
        new Pickup();
      }else if (ae.getSource() == Update){
        setVisible(false);
        new UpdateCheck();
      } else if(ae.getSource() == checkout){
        setVisible(false);
        new Checkout();
      }else if(ae.getSource() == logout){
        setVisible(false);
       // System.exit(0);
      }
     }
    public static void main(String[] args) {
        new Reception();
    }
}
