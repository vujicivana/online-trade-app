package Projekat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI5 {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI5 window = new GUI5();
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
	public GUI5() {
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
		
		JLabel lblNewLabel = new JLabel("Trgovac");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(345, 11, 88, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Korisnicko ime");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(54, 92, 166, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lozinka");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(54, 154, 166, 19);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(251, 93, 240, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(251, 155, 240, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Dalje");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String korisnicko_ime=textField.getText();
				String lozinka=textField_1.getText();
				try {
					GUI1.pst=GUI1.con.prepareStatement("Select * from trgovac where korisnicko_ime=? and lozinka=?");
					GUI1.pst.setString(1, korisnicko_ime);
					GUI1.pst.setString(2, lozinka);
					GUI1.rs=GUI1.pst.executeQuery();
					if(GUI1.rs.next()) {
						int id=Integer.parseInt(GUI1.rs.getString(1));
						String ime=GUI1.rs.getString(3);
						String prezime=GUI1.rs.getString(4);
						String pol=GUI1.rs.getString(6);
						String telefon=GUI1.rs.getString(7);
						String email=GUI1.rs.getString(8);
						int prodajno_mjesto_id=Integer.parseInt(GUI1.rs.getString(9));
						Trgovac trgovac=new Trgovac(id, korisnicko_ime, ime, prezime, lozinka, pol, telefon, email, prodajno_mjesto_id);
						JOptionPane.showMessageDialog(null, "Korisnicko ime i lozinka se poklapaju.");
						GUI6 gui6=new GUI6(trgovac);
						gui6.frame.setVisible(true);
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Korisnicko ime i lozinka se ne poklapaju.");
						textField.setText("");
						textField_1.setText("");;
					}
				}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
			}
		});
		btnNewButton.setBounds(54, 256, 196, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pocetna strana");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(53, 308, 197, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}