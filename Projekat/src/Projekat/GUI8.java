package Projekat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GUI8 {

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

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI8 window = new GUI8();
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
	public GUI8() {
		initialize();
		GUI1.konektuj();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dodavanje novog trgovca");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(201, 11, 294, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(29, 47, 171, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Korisnicko ime");
		lblNewLabel_2.setBounds(29, 72, 171, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ime");
		lblNewLabel_3.setBounds(29, 97, 171, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prezime");
		lblNewLabel_4.setBounds(29, 122, 171, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Lozinka");
		lblNewLabel_5.setBounds(29, 147, 171, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pol");
		lblNewLabel_6.setBounds(29, 172, 171, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Telefon");
		lblNewLabel_7.setBounds(29, 197, 171, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setBounds(29, 222, 171, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Prodajno mjesto ID");
		lblNewLabel_9.setBounds(29, 247, 171, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(275, 44, 294, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(275, 69, 294, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(275, 94, 294, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(275, 119, 294, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(275, 144, 294, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(275, 169, 294, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(275, 194, 294, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(275, 219, 294, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(275, 244, 294, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("Sacuvaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean uslov=true;
				int id=Integer.parseInt(textField.getText());
				String korisnicko_ime=textField_1.getText();
				String ime=textField_2.getText();
				String prezime=textField_3.getText();
				String lozinka=textField_4.getText();
				String pol=textField_5.getText();
				if(pol.equals(""))
					pol=null;
				String telefon=textField_6.getText();
				if(telefon.equals(""))
					telefon=null;
				String email=textField_7.getText();
				int prodajno_mjesto_id=Integer.parseInt(textField_8.getText());
				if(textField.getText().equals("") || korisnicko_ime.equals("") || ime.equals("") || prezime.equals("") || lozinka.equals("") || email.equals("") || textField_8.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Nisu uneseni svi podaci.");
				else {
					try {
						GUI1.pst=GUI1.con.prepareStatement("Select * from trgovac where id=?");
						GUI1.pst.setInt(1, id);
						GUI1.rs=GUI1.pst.executeQuery();
						if(GUI1.rs.next()) {
							JOptionPane.showMessageDialog(null, "Uneseni id vec postoji.");
							uslov=false;
						}
						GUI1.pst=GUI1.con.prepareStatement("Select * from trgovac where korisnicko_ime=?");
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
								GUI1.pst=GUI1.con.prepareStatement("insert into trgovac(id, korisnicko_ime, ime, prezime, lozinka, pol, telefon, email, prodajno_mjesto_id)values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
								GUI1.pst.setInt(1, id);
								GUI1.pst.setString(2, korisnicko_ime);
								GUI1.pst.setString(3, ime);
								GUI1.pst.setString(4, prezime);
								GUI1.pst.setString(5, lozinka);
								GUI1.pst.setString(6, pol);
								GUI1.pst.setString(7, telefon);
								GUI1.pst.setString(8, email);
								GUI1.pst.setInt(9, prodajno_mjesto_id);
								GUI1.pst.executeUpdate();
								JOptionPane.showMessageDialog(null, "Novi trgovac je dodat.");
								textField.setText("");
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");
								textField_5.setText("");
								textField_6.setText("");
								textField_7.setText("");
								textField_8.setText("");
							}
							catch(SQLException ex) {
								JOptionPane.showMessageDialog(null, ex);
							}
					}
				}
			}
		});
		btnNewButton.setBounds(29, 303, 141, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nazad");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(29, 337, 141, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}