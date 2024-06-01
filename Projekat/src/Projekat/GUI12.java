package Projekat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class GUI12 {
	
	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	static ArrayList<ProdajnoMjesto> lista_mogucih_prodajnih_mjesta=new ArrayList<ProdajnoMjesto>();
	private ArrayList<ArtikalNarudzbe> lista_novih_artikala_narudzbe=new ArrayList<ArtikalNarudzbe>();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String a = null;
					GUI12 window = new GUI12();
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
	public GUI12(Kupac kupac) {
		initialize(kupac);
		GUI1.konektuj();
	}
	
	public void table_update(ArrayList<Proizvod> proizvodi) {
		GUI1.konektuj();
		GUI1.df=(DefaultTableModel)table.getModel();
		GUI1.df.setRowCount(0);
		for(Proizvod p: proizvodi) {
			Vector v=new Vector();
			for(int a=1; a<=4; a++) {
				v.add(p.getId());
				v.add(p.getNaziv());
				v.add(p.getOpis());
				v.add(p.getCijena());
			}
			GUI1.df.addRow(v);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Kupac kupac) {
		ArrayList<Proizvod> lista_proizvoda=new ArrayList<Proizvod>();
		ArrayList<ProdajnoMjesto> lista_prodajnih_mjesta=new ArrayList<ProdajnoMjesto>();
		
		try {
			GUI1.konektuj();
			GUI1.pst=GUI1.con.prepareStatement("Select * from proizvod");
			GUI1.rs=GUI1.pst.executeQuery();
			while(GUI1.rs.next()) {
				int id=Integer.parseInt(GUI1.rs.getString(1));
				String naziv=GUI1.rs.getString(2);
				String opis=GUI1.rs.getString(3);
				Double cijena=Double.parseDouble(GUI1.rs.getString(4));
				Proizvod proizvod=new Proizvod(id, naziv, opis, cijena);
				lista_proizvoda.add(proizvod);
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
				ProdajnoMjesto prodajno_mjesto=new ProdajnoMjesto(id, grad, drzava, adresa, telefon);
				lista_prodajnih_mjesta.add(prodajno_mjesto);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Proizvodi");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(300, 11, 150, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(47, 90, 102, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Naziv");
		lblNewLabel_2.setBounds(47, 122, 102, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Opis");
		lblNewLabel_3.setBounds(47, 154, 102, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cijena");
		lblNewLabel_4.setBounds(47, 184, 102, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(170, 87, 168, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 119, 168, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 151, 168, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(170, 181, 168, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Naruci");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textField.getText());
				String naziv=textField_1.getText();
				String opis="";
				if(textField_2.getText().equals("null"))
					opis=null;
				else
					opis=textField_2.getText();
				Double cijena=Double.parseDouble(textField_3.getText());
				int kolicina=Integer.parseInt(textField_4.getText());
				ArtikalNarudzbe novi_artikal_narudzbe=new ArtikalNarudzbe(0, id, kolicina, cijena, 0);
				lista_novih_artikala_narudzbe.add(novi_artikal_narudzbe);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnNewButton.setBounds(47, 263, 168, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Zavrsi narucivanje");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String datum_narudzbe=textField_5.getText();
				for(ProdajnoMjesto pm: lista_prodajnih_mjesta) {
					if(pm.getDrzava().equals(kupac.getDrzava()))
						lista_mogucih_prodajnih_mjesta.add(pm);
				}
				if(lista_mogucih_prodajnih_mjesta.size()==0)
					for(ProdajnoMjesto pm: lista_prodajnih_mjesta)
						lista_mogucih_prodajnih_mjesta.add(pm);
				ArrayList<ArtikalNarudzbe> lista_novih_artikala_narudzbe_clone=(ArrayList<ArtikalNarudzbe>) lista_novih_artikala_narudzbe.clone();
				Narudzba nova_narudzba=new Narudzba(0, kupac.getId(), 0, datum_narudzbe, null, null, lista_novih_artikala_narudzbe_clone);
				GUI1.lista_novih_narudzbi.add(nova_narudzba);
				textField_5.setText("");
				for(ArtikalNarudzbe an: lista_novih_artikala_narudzbe_clone) 
					an.setNarudzba(nova_narudzba);
				lista_novih_artikala_narudzbe.clear();
			}
		});
		btnNewButton_1.setBounds(47, 297, 168, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI1.df=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				textField.setText(String.valueOf(GUI1.df.getValueAt(selectedIndex, 0)));
				textField_1.setText(GUI1.df.getValueAt(selectedIndex, 1).toString());
				textField_2.setText(String.valueOf(GUI1.df.getValueAt(selectedIndex, 2)));
				textField_3.setText(String.valueOf(GUI1.df.getValueAt(selectedIndex, 3)));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Naziv", "Opis", "Cijena"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(388, 90, 305, 230);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setBounds(388, 69, 62, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Naziv");
		lblNewLabel_6.setBounds(464, 69, 62, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Opis");
		lblNewLabel_7.setBounds(544, 69, 62, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Cijena");
		lblNewLabel_8.setBounds(631, 69, 62, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Kolicina");
		lblNewLabel_9.setBounds(47, 215, 102, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		textField_4 = new JTextField();
		textField_4.setBounds(170, 212, 168, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Datum narudzbe");
		lblNewLabel_10.setBounds(388, 339, 121, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(519, 336, 174, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Nazad");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(47, 335, 168, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		table_update(lista_proizvoda);
	}
}