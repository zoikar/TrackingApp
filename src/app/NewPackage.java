package app;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.sql.*;

public class NewPackage extends JFrame{
	private JPanel p, p1;
	private JLabel mainl, track, tracknum, name, from, to;
	private JTextField nametf;
	private String[] str = {"ALEXANDROUPOLI", "KOMOTINI", "XANTHI", "DRAMA", "KAVALA", "THESSALONIKI", "POLIGIROS", "VEROIA", "KILKIS", "EDESSA", "KATERINI", "SERRES", "KOZANI", "FLORINA", "GREVENA", "KASTORIA", "IOANNINA", "ARTA", "PREVEZA", "IGOUMENITSA", "LARISA", "KARDITSA", "VOLOS", "TRIKALA", "LIVADIA", "XALKIDA", "KARPENISI", "AMFISSA", "LAMIA", "ARGOSTOLI", "KERKIRA", "LEUKADA", "ZAKINTHOS", "PATRA", "PIRGOS", "MESOLOGGI", "TRIPOLI", "NAUPLIO", "KORINTHOS", "SPARTI"," KALAMATA", "ATHINA", "PALLINI", "PIRAIAS", "ELEUSINA", "XIOS", "MITILINI", "SAMOS", "ERMOUPOLI", "RODOS", "IRAKLEIO", "XANIA", "AGIOS NIKOLAOS", "RETHIMNO", "KARIES"};
	JComboBox<String> fromcb = new JComboBox<>(str);
	JComboBox<String> tocb = new JComboBox<>(str);
	private JButton create, back;
	ResultSet result;
	public NewPackage(Statement statement, int trackn) {
		mainl = new JLabel("Fill in the info for the new package");
		
		track = new JLabel("Tracking Number: ");
		tracknum = new JLabel("" + trackn);
		
		name = new JLabel("Name: ");
		nametf = new JTextField();
		
		from = new JLabel("From: ");
		
		to = new JLabel("To: ");
		
		p = new JPanel(new GridLayout(4,2));
		p.add(track);
		p.add(tracknum);
		p.add(name);
		p.add(nametf);
		p.add(from);
		p.add(fromcb);
		p.add(to);
		p.add(tocb);
		
		create = new JButton("Create");
		create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					result = statement.executeQuery("INSERT INTO PackageInfo (tracknum, name, afrom, ato) VALUES ('" + tracknum.getText() + "', '" + nametf.getText() + "', '" + fromcb.getSelectedItem() + "', '" + tocb.getSelectedItem()  + "');");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

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
		p1.add(create);
		
		add(mainl, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		add(p1, BorderLayout.SOUTH);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
