package Projekat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GUI7 {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI7 window = new GUI7();
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
	public GUI7() {
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
		
		JLabel lblNewLabel = new JLabel("Dodavanje novog prodajnog mjesta");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(173, 11, 385, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Grad");
		lblNewLabel_1.setBounds(40, 83, 118, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Drzava");
		lblNewLabel_2.setBounds(40, 130, 118, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Adresa");
		lblNewLabel_3.setBounds(40, 173, 118, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefon");
		lblNewLabel_4.setBounds(40, 216, 118, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(186, 80, 258, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 127, 258, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(186, 170, 258, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(186, 213, 258, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Sacuvaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String grad=textField.getText();
				String drzava=textField_1.getText();
				String adresa=textField_2.getText();
				if(adresa.equals(""))
					adresa=null;
				String telefon=textField_3.getText();
				if(grad.equals("") || drzava.equals("") || telefon.equals(""))
					JOptionPane.showMessageDialog(null, "Nisu uneseni svi podaci.");
				else {
				try {
					GUI1.pst=GUI1.con.prepareStatement("insert into prodajno_mjesto(grad, drzava, adresa, telefon)values(?, ?, ?, ?)");
					GUI1.pst.setString(1, grad);
					GUI1.pst.setString(2, drzava);
					GUI1.pst.setString(3, adresa);
					GUI1.pst.setString(4, telefon);
					GUI1.pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Novo prodajno mjesto je dodato.");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
				}
				catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
			}
		});
		btnNewButton.setBounds(40, 283, 118, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nazad");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(40, 324, 118, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}