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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class GUI13 {

	JFrame frame;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI13 window = new GUI13();
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
	public GUI13(Trgovac trgovac) {
		initialize(trgovac);
		GUI1.konektuj();
	}
	
	public void table_update_n(Trgovac trgovac, ArrayList<Narudzba> narudzbe) {
		for(ProdajnoMjesto pm: GUI12.lista_mogucih_prodajnih_mjesta)
			if(pm.getId()==trgovac.getProdajnoMjestoId()) {
				GUI1.konektuj();
				GUI1.df=(DefaultTableModel)table.getModel();
				GUI1.df.setRowCount(0);
				for(Narudzba n: narudzbe) {
					Vector v=new Vector();
					for(int a=1; a<=3; a++) {
						v.add(n.getKupacId());
						v.add(n.getDatumNarudzbe());
						v.add(n.getNapomena());
					}
					GUI1.df.addRow(v);
				}
			}
	}
	
	public void table_update_an(ArrayList<ArtikalNarudzbe> artikli_narudzbe) {
		GUI1.konektuj();
		GUI1.df=(DefaultTableModel)table_1.getModel();
		GUI1.df.setRowCount(0);
		for(ArtikalNarudzbe an: artikli_narudzbe) {
			Vector v=new Vector();
			for(int a=1; a<=3; a++) {
				v.add(an.getProizvodId());
				v.add(an.getKolicina());
				v.add(an.getCijenaPoKomadu());
			}
			GUI1.df.addRow(v);
		}
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Trgovac trgovac) {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Narudzbe koje nisu prihvacene");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(209, 11, 314, 25);
		frame.getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI1.df=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				int kupac_id=(int) GUI1.df.getValueAt(selectedIndex, 0);
				String datum_narudzbe=(String) GUI1.df.getValueAt(selectedIndex, 1);
				String napomena=(String) GUI1.df.getValueAt(selectedIndex, 2);
				table_update_an(GUI1.lista_novih_narudzbi.get(selectedIndex).getListaArtikalaNarudzbe());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Kupac ID", "Datum narudzbe", "Napomena"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(55, 89, 290, 204);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Kupac ID");
		lblNewLabel_1.setBounds(55, 64, 87, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Datum narudzbe");
		lblNewLabel_2.setBounds(152, 64, 92, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Napomena");
		lblNewLabel_3.setBounds(253, 64, 92, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Prihvati");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI1.df=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				Narudzba prihvacena_narudzba=GUI1.lista_novih_narudzbi.get(selectedIndex);
				try {
					GUI1.pst=GUI1.con.prepareStatement("insert into narudzba(kupac_id, trgovac_id, datum_narudzbe, napomena)values(?, ?, ?, ?)");
					GUI1.pst.setInt(1, prihvacena_narudzba.getKupacId());
					GUI1.pst.setInt(2, trgovac.getId());
					GUI1.pst.setString(3, prihvacena_narudzba.getDatumNarudzbe());
					GUI1.pst.setString(4,  prihvacena_narudzba.getNapomena());
					GUI1.pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Nova narudzba je dodata.");
				}
				catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}					
				try {
					GUI1.pst=GUI1.con.prepareStatement("Select * from narudzba where kupac_id=? and trgovac_id=? and datum_narudzbe=?");
					GUI1.pst.setInt(1, prihvacena_narudzba.getKupacId());
					GUI1.pst.setInt(2, trgovac.getId());
					GUI1.pst.setString(3, prihvacena_narudzba.getDatumNarudzbe());
					GUI1.rs=GUI1.pst.executeQuery();
					int nid=0;
					if(GUI1.rs.next())
					nid=Integer.parseInt(GUI1.rs.getString(1));
					for(int i=0; i<GUI1.lista_novih_narudzbi.get(selectedIndex).getListaArtikalaNarudzbe().size(); i++) {
					GUI1.pst=GUI1.con.prepareStatement("insert into artikal_narudzbe(narudzba_id, proizvod_id, kolicina, cijena_po_komadu)values(?, ?, ?, ?)");
		            GUI1.pst.setInt(1, nid);
		            GUI1.pst.setInt(2, GUI1.lista_novih_narudzbi.get(selectedIndex).getListaArtikalaNarudzbe().get(i).getProizvodId());
		            GUI1.pst.setInt(3, GUI1.lista_novih_narudzbi.get(selectedIndex).getListaArtikalaNarudzbe().get(i).getKolicina());
		            GUI1.pst.setDouble(4, GUI1.lista_novih_narudzbi.get(selectedIndex).getListaArtikalaNarudzbe().get(i).getCijenaPoKomadu());
					GUI1.pst.executeUpdate();
				}
				}
				catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}		
				GUI1.lista_novih_narudzbi.remove(selectedIndex);
				table_update_n(trgovac, GUI1.lista_novih_narudzbi);
				table_update_an(new ArrayList<ArtikalNarudzbe>());
			}
		});
		btnNewButton.setBounds(55, 312, 122, 23);
		frame.getContentPane().add(btnNewButton);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Kolicina", "Cijena"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.setBounds(414, 89, 290, 204);
		frame.getContentPane().add(table_1);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBounds(414, 64, 65, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Kolicina");
		lblNewLabel_5.setBounds(532, 64, 65, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cijena");
		lblNewLabel_6.setBounds(639, 64, 65, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Nazad");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(55, 346, 122, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		table_update_n(trgovac, GUI1.lista_novih_narudzbi);
	}
}