package Projekat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI9 {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI9 window = new GUI9();
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
	public GUI9() {
		initialize();
		table_update();
		GUI1.konektuj();
	}
	
	public void table_update() {
		int c;
		try {
			GUI1.konektuj();
			GUI1.pst=GUI1.con.prepareStatement("select * from proizvod");
			GUI1.rs=GUI1.pst.executeQuery();
			GUI1.rss=(ResultSetMetaData) GUI1.rs.getMetaData();
			c=GUI1.rss.getColumnCount();
			GUI1.df=(DefaultTableModel)table.getModel();
			GUI1.df.setRowCount(0);
			while(GUI1.rs.next()) {
				Vector v=new Vector();
				for(int a=1; a<=c; a++) {
					v.add(GUI1.rs.getInt("ID"));
					v.add(GUI1.rs.getString("Naziv"));
					v.add(GUI1.rs.getString("Opis"));
					v.add(GUI1.rs.getDouble("Cijena"));
				}
				GUI1.df.addRow(v);
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dodavanje i azuriranje proizvoda");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(203, 11, 352, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Naziv");
		lblNewLabel_1.setBounds(47, 90, 104, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Opis");
		lblNewLabel_2.setBounds(47, 122, 104, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cijena");
		lblNewLabel_3.setBounds(47, 159, 104, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(172, 87, 143, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 119, 143, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(172, 156, 143, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String naziv=textField.getText();
				String opis=textField_1.getText();
				if(opis.equals(""))
					opis=null;
				double cijena=Double.parseDouble(textField_2.getText());
				if(naziv.equals("") || textField_2.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Nisu uneseni svi podaci.");
				else {
				try {
					GUI1.pst=GUI1.con.prepareStatement("insert into proizvod(naziv, opis, cijena)values(?, ?, ?)");
					GUI1.pst.setString(1, naziv);
					GUI1.pst.setString(2, opis);
					GUI1.pst.setDouble(3, cijena);
					GUI1.pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Novi proizvod je dodat.");
					table_update();
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
				catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
			}
		});
		btnNewButton.setBounds(47, 196, 118, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Uredi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI1.df=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				int id=Integer.parseInt(GUI1.df.getValueAt(selectedIndex, 0).toString());
				String naziv=textField.getText();
				String opis=textField_1.getText();
				if(opis.equals(""))
					opis=null;
				double cijena=Double.parseDouble(textField_2.getText());
				if(naziv.equals("") || textField_2.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Nisu uneseni svi podaci.");
				else {
				try {
					GUI1.pst=GUI1.con.prepareStatement("update proizvod set naziv=?, opis=?, cijena=? where id=?");
					GUI1.pst.setString(1, naziv);
					GUI1.pst.setString(2, opis);
					GUI1.pst.setDouble(3, cijena);
					GUI1.pst.setInt(4, id);
					GUI1.pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Proizvod je uredjen.");
					table_update();
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
				catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
			}
		});
		btnNewButton_1.setBounds(47, 230, 118, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Izbrisi");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI1.df=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				try {
					int id=Integer.parseInt(GUI1.df.getValueAt(selectedIndex, 0).toString());
					GUI1.pst=GUI1.con.prepareStatement("delete from proizvod where id=?");
					GUI1.pst.setInt(1, id);
					GUI1.pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Proizvod je izbrisan.");
					table_update();
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
				catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnNewButton_2.setBounds(47, 264, 118, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GUI1.df=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				textField.setText(GUI1.df.getValueAt(selectedIndex, 1).toString());
				textField_1.setText(String.valueOf(GUI1.df.getValueAt(selectedIndex, 2)));
				textField_2.setText(String.valueOf(GUI1.df.getValueAt(selectedIndex, 3)));
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
		table.setBounds(349, 90, 361, 258);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBounds(348, 69, 75, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Opis");
		lblNewLabel_5.setBounds(453, 69, 75, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Naziv");
		lblNewLabel_6.setBounds(550, 69, 75, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cijena");
		lblNewLabel_7.setBounds(635, 69, 75, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton_3 = new JButton("Nazad");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(47, 325, 118, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
}