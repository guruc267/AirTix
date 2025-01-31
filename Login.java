package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.lang.*;


class Myframe extends JFrame implements ActionListener
{
    JTextField t1;
    JPasswordField password;
    JButton Reset,submit,close;

    ;
    JLabel l1,l2,l3,Top,l4;
    Myframe(){

//        JFrame f=new JFrame("Airline Management System");
         Top=new JLabel("DENVER AIRLINES");

        Top.setBounds(80,80,300,30);
        Top.setFont((new Font(Font.SERIF,Font.BOLD,30)));
        Top.setForeground(new Color(210,51,105));
        add(Top);

        l4=new JLabel();

        l4.setIcon(new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/direct-flight.png")));
        l4.setBounds(0,50,120,80);


         l1=new JLabel();

       l1.setIcon(new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/latest login.png")));
        l1.setBounds(160,130,120,70);
//        l1.setForeground(Color.BLACK);
//        l1.setFont((new Font(Font.SERIF,Font.BOLD,25)));

         l2=new JLabel("Username :");
        l2.setBounds(10,220,100,20);
        l2.setForeground(Color.BLACK);
        l2.setFont((new Font(Font.SERIF,Font.PLAIN,20)));



        l3=new JLabel("Password :");
        l3.setBounds(10,270,100,20);
        l3.setForeground(Color.BLACK);
        l3.setFont((new Font(Font.SERIF,Font.PLAIN,20)));


         t1=new JTextField(20);
        t1.setBounds(140,220,100,20);

        password=new JPasswordField(20);
        password.setBounds(140,270,100,20);

         submit=new JButton("Submit");
        submit.setBounds(130,360,100,30);
        submit.setForeground(Color.black);
        submit.setFont((new Font(Font.SERIF,Font.BOLD,15)));
        submit.setBackground(Color.white);
        submit.setOpaque(true);

         Reset=new JButton("Reset");
        Reset.setBounds(0,360,100,30);
        Reset.setForeground(Color.white);
        Reset.setFont((new Font(Font.SERIF,Font.BOLD,15)));
        Reset.setBackground(Color.BLACK);
        Reset.setOpaque(true);

        close=new JButton("Close");
        close.setBounds(260,360,100,30);
        close.setForeground(Color.white);
        close.setFont((new Font(Font.SERIF,Font.BOLD,15)));
        close.setBackground(Color.BLACK);
        close.setOpaque(true);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(password);
        add(t1);
        add(submit);
        add(Reset);
        add(close);


        setSize(400,500);
        setLayout(null);
        setVisible(true);
        setResizable(false);
//        setResizable(false);
//        ImageIcon image=new ImageIcon("travelling.png");
//        f.setIconImage(image.getImage());
        getContentPane().setBackground(new Color(188, 234, 213));
        submit.addActionListener(this);
        Reset.addActionListener(this);
        close.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==Reset){

            t1.setText("");
            password.setText("");
	}
       if(ae.getSource()==close){
           System.exit(0);
	}
     if(ae.getSource()==submit)
         try{
//                conn c1 = new conn();
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                Connection c = DriverManager.getConnection("jdbc:mysql:///project4","root","");
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/project4","root","");
//                Connection c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/project4", "root", "");

                Statement s =c.createStatement();
                String s1 = t1.getText();
                String s2 = password.getText();
//             String query = "INSERT INTO login values('" + t1 + "','" + password +"')";
                String str = "select * from login where username = '"+s1+"' and password = '"+s2+"'";
//             ResultSet rs = s.executeQuery(query );
                ResultSet rs = s.executeQuery(str);

                if(rs.next()){
                    new Mainframe();
                    setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                    setVisible(false);
                }

            }catch(Exception e){}

	}
    }


public class Login {
    public static void main(String[] args) {
        Myframe frame=new Myframe();
    }

}