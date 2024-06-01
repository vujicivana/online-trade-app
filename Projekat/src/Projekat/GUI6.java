package Projekat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI6 {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI6 window = new GUI6();
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
	public GUI6(Trgovac trgovac) {
		initialize(trgovac);
		GUI1.konektuj();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Trgovac trgovac) {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trgovac");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(321, 11, 81, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(44, 49, 131, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ime");
		lblNewLabel_2.setBounds(44, 83, 131, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Prezime");
		lblNewLabel_3.setBounds(44, 117, 131, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pol");
		lblNewLabel_4.setBounds(44, 151, 131, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefon");
		lblNewLabel_5.setBounds(44, 185, 131, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setBounds(44, 219, 131, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Prodajno mjesto ID");
		lblNewLabel_7.setBounds(44, 253, 131, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(Integer.toString(trgovac.getId()));
		lblNewLabel_8.setBounds(217, 47, 185, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(trgovac.getIme());
		lblNewLabel_9.setBounds(217, 83, 185, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(trgovac.getPrezime());
		lblNewLabel_10.setBounds(217, 117, 185, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel(trgovac.getPol());
		lblNewLabel_11.setBounds(217, 151, 185, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel(trgovac.getTelefon());
		lblNewLabel_12.setBounds(217, 185, 185, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel(trgovac.getEmail());
		lblNewLabel_13.setBounds(217, 219, 185, 14);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel(Integer.toString(trgovac.getProdajnoMjestoId()));
		lblNewLabel_14.setBounds(217, 253, 185, 14);
		frame.getContentPane().add(lblNewLabel_14);
		
		JButton btnNewButton = new JButton("Narudzbe koje nisu prihvacene");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI13 gui13=new GUI13(trgovac);
				gui13.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(412, 45, 261, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Odobrene narudzbe");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI14 gui14=new GUI14(trgovac);
				gui14.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(412, 83, 261, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Dodavanje novog prodajnog mjesta");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI7 gui7=new GUI7();
				gui7.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(412, 121, 261, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Dodavanje novog trgovca");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI8 gui8=new GUI8();
				gui8.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(412, 159, 261, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Dodavanje i azuriranje proizvoda");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI9 gui9=new GUI9();
				gui9.frame.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(412, 197, 259, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Pocetna strana");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_5.setBounds(44, 328, 141, 23);
		frame.getContentPane().add(btnNewButton_5);
	}
}