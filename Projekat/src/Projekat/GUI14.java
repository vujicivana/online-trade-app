package Projekat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class GUI14 {

	JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI14 window = new GUI14();
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
	public GUI14(Trgovac trgovac) {
		initialize(trgovac);
		table_update(trgovac);
		GUI1.konektuj();
	}
	
	public void table_update(Trgovac trgovac) {
		 ArrayList<Narudzba> lista_odobrenih_narudzbi=new ArrayList<>();
			
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
					if(narudzba.getTrgovacId()==trgovac.getId())
					lista_odobrenih_narudzbi.add(narudzba);
				}
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
			
		GUI1.konektuj();
		GUI1.df=(DefaultTableModel)table.getModel();
		GUI1.df.setRowCount(0);
		for(Narudzba n: lista_odobrenih_narudzbi) {
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Trgovac trgovac) {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Odobrene narudzbe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(265, 11, 206, 25);
		frame.getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI1.df=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				textField.setText(String.valueOf(GUI1.df.getValueAt(selectedIndex, 4)));
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
		table.setBounds(26, 88, 643, 182);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(26, 64, 59, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kupac ID");
		lblNewLabel_2.setBounds(132, 63, 76, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Trgovac ID");
		lblNewLabel_3.setBounds(232, 64, 86, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Datum narudzbe");
		lblNewLabel_4.setBounds(345, 63, 118, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Datum isporuke");
		lblNewLabel_5.setBounds(473, 64, 110, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Napomena");
		lblNewLabel_6.setBounds(593, 63, 76, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Datum isporuke");
		lblNewLabel_7.setBounds(26, 284, 130, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(180, 281, 157, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI1.df=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				int id=(int) GUI1.df.getValueAt(selectedIndex, 0);
				String datum_isporuke=textField.getText();
				try {
					GUI1.pst=GUI1.con.prepareStatement("update narudzba set datum_isporuke=? where id=?");
					GUI1.pst.setString(1, datum_isporuke);
					GUI1.pst.setInt(2, id);
					GUI1.pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Datum isporuke je dodat.");
					table_update(trgovac);
					textField.setText("");
				}
				catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnNewButton.setBounds(26, 309, 144, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nazad");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(26, 343, 144, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}