package app;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
public class TrackingInfo extends JFrame{
	JTable table = new JTable();
	private JLabel mainl;
	private JButton goBack;

	public TrackingInfo(Statement statement, int trackingnum) {
		goBack = new JButton("Go Back");
		goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new UserPage(statement).setVisible(true);
            	dispose();
            }
            });
		try {
            mainl = new JLabel("Tracking Number: " + trackingnum, SwingConstants.CENTER);
            // Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT location, date, status, details FROM TrackInfo WHERE tracknum ="+ trackingnum + " ORDER BY date ASC;;");

            // Create a TableModel to hold the data
            DefaultTableModel model = new DefaultTableModel();

            // Define custom column headers
            String[] columnHeaders = {"Location", "Date", "Status", "Details"};
            model.setColumnIdentifiers(columnHeaders);

            // Add rows to the model
            while (resultSet.next()) {
                Object[] rowData = new Object[columnHeaders.length];
                for (int columnIndex = 0; columnIndex < columnHeaders.length; columnIndex++) {
                    rowData[columnIndex] = resultSet.getObject(columnIndex + 1);
                }
                model.addRow(rowData);
            }

            // Set the model to the table
            table.setModel(model);

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add the table to the frame
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(mainl, BorderLayout.NORTH);
        add(goBack, BorderLayout.SOUTH);
        

        // Configure frame settings
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
}