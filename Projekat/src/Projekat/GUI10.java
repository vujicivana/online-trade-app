package Projekat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI10 {

	JFrame frame;
	private JTable table;
	private JTable table_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI10 window = new GUI10();
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
	public GUI10(Kupac kupac) {
		initialize(kupac);
		GUI1.konektuj();
	}

	public void table_update_on(ArrayList<Narudzba> lista_obavljenih_narudzbi) {
		GUI1.konektuj();
		GUI1.df=(DefaultTableModel)table.getModel();
		GUI1.df.setRowCount(0);
		for(Narudzba n: lista_obavljenih_narudzbi) {
			Vector v=new Vector();
			for(int a=1; a<=6; a++) {
				v.add(n.getId());
				v.add(n.getKupacId());
				v.add(n.getTrgovacId());
				v.add(n.getDatumNarudzbe());
				v.add(n.getDatumIsporuke());
				v.add(n.getNapomena());
			}
			GUI1.df.addRow(v);
		}
	}
	
	public void table_update_an(int id, ArrayList<ArtikalNarudzbe> lista_artikala_narudzbe) {
		GUI1.konektuj();
		GUI1.df=(DefaultTableModel)table_1.getModel();
		GUI1.df.setRowCount(0);
		for(ArtikalNarudzbe an: lista_artikala_narudzbe) {
			if(an.getNarudzbaId()==id) {
				Vector v=new Vector();
				for(int a=1; a<=5; a++) {
					v.add(an.getNarudzbaId());
					v.add(an.getProizvodId());
					v.add(an.getKolicina());
					v.add(an.getCijenaPoKomadu());
					v.add(an.getId());
			}
			GUI1.df.addRow(v);
		}
	}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Kupac kupac) {
		ArrayList<Narudzba> lista_obavljenih_narudzbi=new ArrayList<>();
		ArrayList<ArtikalNarudzbe> lista_artikala_narudzbe=new ArrayList<>();
		ArrayList<Trgovac> lista_trgovaca=new ArrayList<>();
		ArrayList<ProdajnoMjesto> lista_prodajnih_mjesta=new ArrayList<>();
		
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
				if(narudzba.getKupacId()==kupac.getId() && narudzba.getDatumIsporuke()!=null)
				lista_obavljenih_narudzbi.add(narudzba);
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
		
		try {
			GUI1.konektuj();
			GUI1.pst=GUI1.con.prepareStatement("Select * from trgovac");
			GUI1.rs=GUI1.pst.executeQuery();
			while(GUI1.rs.next()) {
				int id=Integer.parseInt(GUI1.rs.getString(1));
				String korisnicko_ime=GUI1.rs.getString(2);
				String ime=GUI1.rs.getString(3);
				String prezime=GUI1.rs.getString(4);
				String lozinka=GUI1.rs.getString(5);
				String pol=GUI1.rs.getString(6);
				String telefon=GUI1.rs.getString(7);
				String email=GUI1.rs.getString(8);
				int prodajno_mjesto_id=Integer.parseInt(GUI1.rs.getString(9));
				Trgovac novi_trgovac=new Trgovac(id, korisnicko_ime, ime, prezime, lozinka, pol, telefon, email, prodajno_mjesto_id);
				lista_trgovaca.add(novi_trgovac);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
		try {
			GUI1.konektuj();
			GUI1.pst=GUI1.con.prepareStatement("Select * from prodajno_mjesto");
			GUI1.rs=GUI1.pst.executeQuery();
			while(GUI1.rs.next()) {
				int id=Integer.parseInt(GUI1.rs.getString(1));
				String grad=GUI1.rs.getString(2);
				String drzava=GUI1.rs.getString(3);
				String adresa=GUI1.rs.getString(4);
				String telefon=GUI1.rs.getString(5);
				ProdajnoMjesto novo_prodajno_mjesto=new ProdajnoMjesto(id, grad, drzava, adresa, telefon);
				lista_prodajnih_mjesta.add(novo_prodajno_mjesto);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Obavljene narudzbe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(249, 11, 229, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_12 = new JLabel("Prodajno mjesto");
		lblNewLabel_12.setBounds(405, 332, 124, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setBounds(548, 332, 124, 14);
		frame.getContentPane().add(lblNewLabel_13);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI1.df=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				int id=(int) GUI1.df.getValueAt(selectedIndex, 0);
				int trgovac_id=(int) GUI1.df.getValueAt(selectedIndex, 2);
				Trgovac trazeni_trgovac=null;
				for(Trgovac t: lista_trgovaca)
					if(t.getId()==trgovac_id) 
						trazeni_trgovac=t;
			    ProdajnoMjesto trazeno_prodajno_mjesto=null;
				for(ProdajnoMjesto pm: lista_prodajnih_mjesta)
					if(pm.getId()==trazeni_trgovac.getProdajnoMjestoId()) 
						trazeno_prodajno_mjesto=pm;
				lblNewLabel_13.setText(trazeno_prodajno_mjesto.getGrad());
				table_update_an(id, lista_artikala_narudzbe);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Kupac ID", "Trgovac ID", "Datum narudzbe", "Datum isporuke", "Napomena"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(28, 89, 326, 227);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Narudzba ID", "Proizvod ID", "Kolicina", "Cijena po komadu", "ID"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, Double.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.setBounds(405, 89, 326, 227);
		frame.getContentPane().add(table_1);
		
		lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(28, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Kupac ID");
		lblNewLabel_2.setBounds(84, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Trgovac ID");
		lblNewLabel_3.setBounds(140, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Datum narudzbe");
		lblNewLabel_4.setBounds(196, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Datum isporuke");
		lblNewLabel_5.setBounds(252, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Napomena");
		lblNewLabel_6.setBounds(308, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Narudzba ID");
		lblNewLabel_7.setBounds(405, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Proizvod ID");
		lblNewLabel_8.setBounds(475, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Kolicina");
		lblNewLabel_9.setBounds(548, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Cijena po komadu");
		lblNewLabel_10.setBounds(617, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("ID");
		lblNewLabel_11.setBounds(685, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		btnNewButton = new JButton("Nazad");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(28, 341, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		table_update_on(lista_obavljenih_narudzbi);
	}
}