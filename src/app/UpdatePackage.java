package app;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class UpdatePackage extends JFrame{
	private JPanel p, p1;
	private JLabel mainl, tracknum, location, date, status, details;
	private JTextField tracknumtf, datetf, statustf, detailstf;
	private JButton update, back;
	private String[] locationstr = {"ALEXANDROUPOLI", "KOMOTINI", "XANTHI", "DRAMA", "KAVALA", "THESSALONIKI", "POLIGIROS", "VEROIA", "KILKIS", "EDESSA", "KATERINI", "SERRES", "KOZANI", "FLORINA", "GREVENA", "KASTORIA", "IOANNINA", "ARTA", "PREVEZA", "IGOUMENITSA", "LARISA", "KARDITSA", "VOLOS", "TRIKALA", "LIVADIA", "XALKIDA", "KARPENISI", "AMFISSA", "LAMIA", "ARGOSTOLI", "KERKIRA", "LEUKADA", "ZAKINTHOS", "PATRA", "PIRGOS", "MESOLOGGI", "TRIPOLI", "NAUPLIO", "KORINTHOS", "SPARTI"," KALAMATA", "ATHINA", "PALLINI", "PIRAIAS", "ELEUSINA", "XIOS", "MITILINI", "SAMOS", "ERMOUPOLI", "RODOS", "IRAKLEIO", "XANIA", "AGIOS NIKOLAOS", "RETHIMNO", "KARIES"};
	JComboBox<String> locationcb = new JComboBox<>(locationstr);
	private String[] statuses = {"Shipment Created", "Customs status updated", "Shipment Picked up", "Parcel Order Scanned", "Departed Processing Center", "In transit", "Delivered", "Failed Attempt", "Not Found", "Out for Delivery", "Returned to Sender"};
	JComboBox<String> statuscb = new JComboBox<>(statuses);
	ResultSet result;

	public UpdatePackage(Statement statement) {
		locationcb.setBounds(80, 50, 140, 20);
		mainl = new JLabel("Type the information to update the package");
		
		p = new JPanel(new GridLayout(5,2));
		tracknum = new JLabel("Tracking Number: ");
		tracknumtf = new JTextField();
		location = new JLabel("Location: ");
		
		date = new JLabel("Date DD/MM/YYYY: ");
		datetf = new JTextField();
		status = new JLabel("Status: ");
		details = new JLabel("Details: ");
		detailstf = new JTextField();
		
		p.add(tracknum);
		p.add(tracknumtf);
		p.add(location);
		p.add(locationcb);
		p.add(date);
		p.add(datetf);
		p.add(status);
		p.add(statuscb);
		p.add(details);
		p.add(detailstf);
		
		update = new JButton("Update");
		update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
        			result = statement.executeQuery("INSERT INTO TrackInfo (tracknum, location, date, status, details) VALUES ('" + tracknumtf.getText() + "', '" + locationcb.getSelectedItem() + "', '" + datetf.getText() + "', '" + statuscb.getSelectedItem() + "', '" + detailstf.getText() + "');");

                    
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            	dispose();
            }
            });
		
		back = new JButton("Go Back");
		back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	new EmployeePage(statement).setVisible(true);

            }
            });
		
		p1 = new JPanel(new GridLayout(1,2));
		p1.add(back);
		p1.add(update);
		
		
		
		add(mainl, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		add(p1, BorderLayout.SOUTH);
		
		// Configure frame settings
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
		
	}

}
