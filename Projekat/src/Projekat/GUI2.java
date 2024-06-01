package Projekat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GUI2 {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 window = new GUI2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public GUI2() {
		initialize();
		GUI1.konektuj();
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registracija novog kupca");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(231, 11, 296, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(33, 59, 185, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Korisnicko ime");
		lblNewLabel_2.setBounds(33, 84, 185, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ime");
		lblNewLabel_3.setBounds(33, 109, 185, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prezime");
		lblNewLabel_4.setBounds(33, 134, 185, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Lozinka");
		lblNewLabel_5.setBounds(33, 159, 185, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefon");
		lblNewLabel_6.setBounds(33, 184, 185, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Adresa");
		lblNewLabel_7.setBounds(33, 209, 185, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Grad");
		lblNewLabel_8.setBounds(33, 234, 185, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Drzava");
		lblNewLabel_9.setBounds(33, 259, 185, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Postanski broj");
		lblNewLabel_10.setBounds(33, 284, 185, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Pol");
		lblNewLabel_11.setBounds(33, 309, 185, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Email");
		lblNewLabel_12.setBounds(33, 334, 185, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
		textField = new JTextField();
		textField.setBounds(241, 56, 286, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(241, 81, 286, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(241, 106, 286, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(241, 131, 286, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(241, 156, 286, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(241, 181, 286, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(241, 206, 286, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(241, 231, 286, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(241, 256, 286, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(241, 281, 286, 20);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(241, 306, 286, 20);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(240, 331, 287, 20);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnNewButton = new JButton("Sacuvaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean uslov=true;
			    int id=Integer.parseInt(textField.getText());
				String korisnicko_ime=textField_1.getText();
				String ime=textField_2.getText();
				String prezime=textField_3.getText();
				String lozinka=textField_4.getText();
				String telefon=textField_5.getText();
				if(telefon.equals(""))
					telefon=null;
				String adresa=textField_6.getText();
				if(adresa.equals(""))
					adresa=null;
				String grad=textField_7.getText();
				String drzava=textField_8.getText();
				if(drzava.equals(""))
					drzava=null;
				String postanski_broj=textField_9.getText();
				if(postanski_broj.equals(""))
					postanski_broj=null;
				String pol=textField_10.getText();
				if(pol.equals(""))
					pol=null;
				String email=textField_11.getText();
				if(textField.getText().equals("") || ime.equals("") || prezime.equals("") || lozinka.equals("") || grad.equals("") || email.equals(""))
					JOptionPane.showMessageDialog(null, "Nisu uneseni svi podaci.");
				else {
					try {
						GUI1.pst=GUI1.con.prepareStatement("Select * from kupac where id=?");
						GUI1.pst.setInt(1, id);
						GUI1.rs=GUI1.pst.executeQuery();
						if(GUI1.rs.next()) {
							JOptionPane.showMessageDialog(null, "Uneseni id vec postoji.");
							uslov=false;
						}
						GUI1.pst=GUI1.con.prepareStatement("Select * from kupac where korisnicko_ime=?");
						GUI1.pst.setString(1, korisnicko_ime);
						GUI1.rs=GUI1.pst.executeQuery();
						if(GUI1.rs.next()) {
							JOptionPane.showMessageDialog(null, "Uneseno korisnicko ime vec postoji.");
							uslov=false;
						}
					}
					catch(SQLException ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
						if(uslov) {
							try {
								GUI1.pst=GUI1.con.prepareStatement("insert into kupac(id, korisnicko_ime, ime, prezime, lozinka, telefon, adresa, grad, drzava, postanski_broj, pol, email)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
								GUI1.pst.setInt(1, id);
								GUI1.pst.setString(2, korisnicko_ime);
								GUI1.pst.setString(3, ime);
								GUI1.pst.setString(4, prezime);
								GUI1.pst.setString(5, lozinka);
								GUI1.pst.setString(6, telefon);
								GUI1.pst.setString(7, adresa);
								GUI1.pst.setString(8, grad);
								GUI1.pst.setString(9, drzava);
								GUI1.pst.setString(10, postanski_broj);
								GUI1.pst.setString(11, pol);
								GUI1.pst.setString(12, email);
								GUI1.pst.executeUpdate();
								JOptionPane.showMessageDialog(null, "Kupac je registrovan.");
								textField.setText("");
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");
								textField_5.setText("");
								textField_6.setText("");
								textField_7.setText("");
								textField_8.setText("");
								textField_9.setText("");
								textField_10.setText("");
								textField_11.setText("");
							}
							catch(SQLException ex) {
								JOptionPane.showMessageDialog(null, ex);
							}
						}
					}
				}
		});
		btnNewButton.setBounds(33, 366, 185, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pocetna strana");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(33, 397, 185, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}