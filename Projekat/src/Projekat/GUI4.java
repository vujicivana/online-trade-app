package Projekat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GUI4 {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String a = null;
					GUI4 window = new GUI4();
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
	public GUI4(Kupac kupac) {
		initialize(kupac);
		GUI1.konektuj();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Kupac kupac) {
		ArrayList<Narudzba> lista_narudzbi=new ArrayList<>();
		ArrayList<Narudzba> lista_obavljenih_narudzbi=new ArrayList<>();
		ArrayList<Narudzba> lista_narudzbi_na_cekanju=new ArrayList<>();
		ArrayList<ArtikalNarudzbe> lista_artikala_narudzbe=new ArrayList<>();
		
		try {
			GUI1.konektuj();
			GUI1.pst=GUI1.con.prepareStatement("Select * from narudzba");
			GUI1.rs=GUI1.pst.executeQuery();
			while(GUI1.rs.next()) {
				int id=Integer.parseInt(GUI1.rs.getString(1));
				int kupac_id=Integer.parseInt(GUI1.rs.getString(2));
				int trgovac_id=Integer.parseInt(GUI1.rs.getString(3));
				String datum_narudzbe=GUI1.rs.getString(4);
				String datum_isporuke=GUI1.rs.getString(5);
				String napomena=GUI1.rs.getString(6);
				Narudzba narudzba=new Narudzba(id, kupac_id, trgovac_id, datum_narudzbe, datum_isporuke, napomena);
				lista_narudzbi.add(narudzba);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
		try {
			GUI1.konektuj();
			GUI1.pst=GUI1.con.prepareStatement("Select * from artikal_narudzbe");
			GUI1.rs=GUI1.pst.executeQuery();
			while(GUI1.rs.next()) {
				int narudzba_id=Integer.parseInt(GUI1.rs.getString(1));
				int proizvod_id=Integer.parseInt(GUI1.rs.getString(2));
				int kolicina=Integer.parseInt(GUI1.rs.getString(3));
				double cijena_po_komadu=Double.parseDouble(GUI1.rs.getString(4));
				int id=Integer.parseInt(GUI1.rs.getString(5));
				ArtikalNarudzbe artikal_narudzbe=new ArtikalNarudzbe(narudzba_id, proizvod_id, kolicina, cijena_po_komadu, id);
				lista_artikala_narudzbe.add(artikal_narudzbe);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
		int bon=0;
		int bnc=0;
		double vnc=0;
		
		for(Narudzba n: lista_narudzbi) {
			if(n.getKupacId()==kupac.getId() && n.getDatumIsporuke()!=null) {
				lista_obavljenih_narudzbi.add(n);
				bon++;
			}
			if(n.getKupacId()==kupac.getId() && n.getDatumIsporuke()==null) {
				lista_narudzbi_na_cekanju.add(n);
				bnc++;
		}
		}
		
		int nid=0;
		
		for(Narudzba nc: lista_narudzbi_na_cekanju) {
			nid=nc.getId();
			for(ArtikalNarudzbe an: lista_artikala_narudzbe) {
				if(nid==an.getNarudzbaId())
					vnc+=an.getKolicina()*an.getCijenaPoKomadu();
			}
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kupac");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(346, 11, 84, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(30, 47, 179, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ime");
		lblNewLabel_2.setBounds(30, 72, 179, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Prezime");
		lblNewLabel_3.setBounds(30, 97, 179, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefon");
		lblNewLabel_4.setBounds(30, 122, 179, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Adresa");
		lblNewLabel_5.setBounds(30, 147, 179, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Grad");
		lblNewLabel_6.setBounds(30, 172, 179, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Drzava");
		lblNewLabel_7.setBounds(30, 197, 179, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Postanski broj");
		lblNewLabel_8.setBounds(30, 222, 179, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Pol");
		lblNewLabel_9.setBounds(30, 247, 179, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Email");
		lblNewLabel_10.setBounds(30, 272, 179, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Broj obavljenih narudzbi");
		lblNewLabel_11.setBounds(30, 297, 179, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Broj narudzbi na cekanju");
		lblNewLabel_12.setBounds(30, 322, 179, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Vrijednost narudzbi na cekanju");
		lblNewLabel_13.setBounds(30, 347, 179, 14);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel(Integer.toString(kupac.getId()));
		lblNewLabel_14.setBounds(251, 47, 179, 14);
		frame.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel(kupac.getIme());
		lblNewLabel_15.setBounds(251, 72, 179, 14);
		frame.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel(kupac.getPrezime());
		lblNewLabel_16.setBounds(251, 97, 179, 14);
		frame.getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel(kupac.getTelefon());
		lblNewLabel_17.setBounds(251, 122, 179, 14);
		frame.getContentPane().add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel(kupac.getAdresa());
		lblNewLabel_18.setBounds(251, 147, 179, 14);
		frame.getContentPane().add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel(kupac.getGrad());
		lblNewLabel_19.setBounds(251, 172, 179, 14);
		frame.getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel(kupac.getDrzava());
		lblNewLabel_20.setBounds(251, 197, 179, 14);
		frame.getContentPane().add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel(kupac.getPostanskiBroj());
		lblNewLabel_21.setBounds(251, 222, 179, 14);
		frame.getContentPane().add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel(kupac.getPol());
		lblNewLabel_22.setBounds(251, 247, 179, 14);
		frame.getContentPane().add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel(kupac.getEmail());
		lblNewLabel_23.setBounds(251, 272, 179, 14);
		frame.getContentPane().add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel(Integer.toString(bon));
		lblNewLabel_24.setBounds(251, 297, 179, 14);
		frame.getContentPane().add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel(Integer.toString(bnc));
		lblNewLabel_25.setBounds(251, 322, 179, 14);
		frame.getContentPane().add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel(Double.toString(vnc));
		lblNewLabel_26.setBounds(251, 347, 179, 14);
		frame.getContentPane().add(lblNewLabel_26);
		
		JButton btnNewButton = new JButton("Obavljene narudzbe");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI10 gui10=new GUI10(kupac);
				gui10.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(458, 43, 250, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Narudzbe na cekanju");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI11 gui11=new GUI11(kupac);
				gui11.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(458, 93, 250, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Proizvodi");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI12 gui12=new GUI12(kupac);
				gui12.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(458, 143, 250, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Pocetna strana");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(30, 372, 179, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
}