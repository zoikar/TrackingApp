package app;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;
public class UserPage extends JFrame{
	private JLabel mainl, trackingnum;
	private JButton track, back;
	private JTextField trackingtf;
	private JPanel p, p1;
	public int tracknum = 0;
	ResultSet result;
	
	public UserPage(Statement statement) {
		
		mainl = new JLabel("Type your tracking number to find your package");
		
		trackingnum = new JLabel("Tracking Number: ");
		trackingtf = new JTextField();
		
		track = new JButton("Track");
		track.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text = trackingtf.getText();
                if (text.isEmpty()) {
                	JOptionPane.showMessageDialog(null, "You didn't give a tracking number");
                } else {
                	try {
                		result = statement.executeQuery("SELECT tracknum FROM PackageInfo WHERE tracknum = " + trackingtf.getText() + ";");

                		if (result.next()) {
                			tracknum = result.getInt(1);
                		} 
                		
                		if(tracknum != Integer.parseInt(text)) {
                			JOptionPane.showMessageDialog(null, "The tracking number you types is wrong. Try again");
                		}else {
                			new TrackingInfo(statement, tracknum).setVisible(true);
                        	dispose();
                		}
                    
                	} catch (SQLException e1) {
                		// TODO Auto-generated catch block
                		e1.printStackTrace();
                	}
                	
                }}
            });
		
		back = new JButton("Go Back");
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FirstFrame(statement).setVisible(true);
			}
		});
		
		p1 = new JPanel(new GridLayout(1,2));
		p1.add(back);
		p1.add(track);
		
		p = new JPanel(new GridLayout(1,2));
		p.add(trackingnum);
		p.add(trackingtf);
		
		add(mainl, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		add(p1, BorderLayout.SOUTH);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
