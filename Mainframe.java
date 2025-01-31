package airline.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Mainframe extends JFrame{

    public static void main(String[] args) {

        new Mainframe().setVisible(true);
    }
    
    public Mainframe() {
        super("AIRLINE RESERVATION MANAGEMENT SYSTEM");
        initialize();
    }

    
    private void initialize() {
	
        setForeground(Color.CYAN);
        setLayout(null); 



        
        JLabel AirlineManagementSystem = new JLabel("Welcome To Denver Airline");
	AirlineManagementSystem.setForeground(new Color(210,51,105));
        AirlineManagementSystem.setFont(new Font("SERIF", Font.BOLD, 60));
	AirlineManagementSystem.setBounds(400, 100, 1500, 90);
	add(AirlineManagementSystem);

        JLabel NewLabel = new JLabel(" Your home in the sky");
        NewLabel.setForeground(Color.BLACK);
        NewLabel.setFont(new Font("SERIF", Font.PLAIN, 30));
        NewLabel.setBounds(900, 180, 1500, 90);
        add( NewLabel);



        JLabel l1=new JLabel();

        l1.setIcon(new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/add-user.jpg")));
        l1.setBounds(750,300,150,80);
        add(l1);

        JLabel l2=new JLabel();

        l2.setIcon(new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/cancel-ticket.png")));
        l2.setBounds(600,400,150,80);
        add(l2);

        JLabel l3=new JLabel();

        l3.setIcon(new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/booking.png")));
        l3.setBounds(900,400,150,80);
        add(l3);

        JLabel l4=new JLabel();

        l4.setIcon(new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/airplane.png")));
        l4.setBounds(750,500,150,80);
        add(l4);


        JLabel l6=new JLabel();

        l6.setIcon(new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/click (1).png")));
        l6.setBounds(50,0,150,80);
        add(l6);






        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu AirlineSystem = new JMenu("AIRLINE SYSTEM");
        AirlineSystem.setForeground(new Color(153, 0, 0));
	menuBar.add(AirlineSystem);
		
        JMenuItem FlightDetails = new JMenuItem("FLIGHT_INFO");
	AirlineSystem.add(FlightDetails);
		
	JMenuItem ReservationDetails = new JMenuItem("ADD_CUSTOMER_DETAILS");
	AirlineSystem.add(ReservationDetails);
		
	JMenuItem PassengerDetails = new JMenuItem("JOURNEY_DETAILS");
	AirlineSystem.add(PassengerDetails);
		
	JMenuItem SectorDetails_1 = new JMenuItem("PAYMENT_DETAILS");
	AirlineSystem.add(SectorDetails_1);
		
	JMenuItem Cancellation = new JMenuItem("CANCELLATION");
	AirlineSystem.add(Cancellation);
		
//	JMenu Ticket = new JMenu("TICKET");
//        Ticket.setForeground(Color.RED);
//	menuBar.add(Ticket);
//
//        JMenu List = new JMenu("LIST");
//        List.setForeground(Color.BLUE);
//	menuBar.add(List);
//
//	JMenu Misc = new JMenu("MISC");
//        Misc.setForeground(Color.RED);
//	menuBar.add(Misc);
        
		
	FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                new Flight_Info();
            }
	});
        
	ReservationDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Add_Customer();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
            }
	});
		
        PassengerDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Journey_Details();
                } catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        SectorDetails_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Payment_Details();
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        Cancellation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Cancel();
            }
	});
        getContentPane().setBackground(new Color(188, 234, 213));
        setSize(1950,1090);
	 setVisible(true);

    }
}
