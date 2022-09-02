package school.project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import school.project.dao.ChuKuDao;
import school.project.dao.OrdersDao;
import school.project.util.DbUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChuKuFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField isbnTxt;
	private JTextField nameTxt;
	private JTextField priceTxt;
	private JTextField countTxt;
	private OrdersDao orderDao = new OrdersDao();
	private ChuKuDao chukuDao = new ChuKuDao();
	private JTextField idTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChuKuFrame frame = new ChuKuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChuKuFrame() {
		setTitle("\u51FA\u5E93");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 814, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 27, 735, 219);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * µã»÷±í¸ñÊÂ¼þ
				 */
				chukuTableListener(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u7F16\u53F7", "\u72B6\u6001", "\u63D0\u4EA4\u65F6\u95F4", "ISBN", "\u6559\u6750\u540D\u79F0", "\u5355\u4EF7", "\u6570\u91CF"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 279, 735, 257);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u51FA\u5E93");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * ³ö¿â
				 */
				chukuListener(e);
			}
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton.setBounds(581, 203, 144, 44);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ISBN \uFF1A");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 28, 98, 33);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6559\u6750\u540D\u79F0 \uFF1A");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(367, 28, 118, 33);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u5355\u4EF7 \uFF1A");
		lblNewLabel_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 121, 118, 33);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u6570\u91CF \uFF1A");
		lblNewLabel_1_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(408, 121, 118, 33);
		panel.add(lblNewLabel_1_2);
		
		isbnTxt = new JTextField();
		isbnTxt.setEditable(false);
		isbnTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		isbnTxt.setBounds(83, 28, 221, 44);
		panel.add(isbnTxt);
		isbnTxt.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setEditable(false);
		nameTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		nameTxt.setColumns(10);
		nameTxt.setBounds(481, 28, 221, 44);
		panel.add(nameTxt);
		
		priceTxt = new JTextField();
		priceTxt.setEditable(false);
		priceTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		priceTxt.setColumns(10);
		priceTxt.setBounds(83, 108, 221, 44);
		panel.add(priceTxt);
		
		countTxt = new JTextField();
		countTxt.setEditable(false);
		countTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		countTxt.setColumns(10);
		countTxt.setBounds(481, 108, 221, 44);
		panel.add(countTxt);
		
		JLabel ida = new JLabel("\u8BA2\u5355\u7F16\u53F7 :");
		ida.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		ida.setBounds(10, 188, 98, 44);
		panel.add(ida);
		
		idTxt = new JTextField();
		idTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		idTxt.setEditable(false);
		idTxt.setBounds(123, 190, 181, 42);
		panel.add(idTxt);
		idTxt.setColumns(10);
		fillOrdersTable();
	}
	void fillOrdersTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//¸ñÊ½»¯²Ù×÷£¬ÉèÖÃ³É0ÐÐ = = ±í¸ñÇå¿Õ
		Connection con = null;
		try {
			con = DbUtil.getInstance().getConnection();
			ResultSet rs = orderDao.list(con,"");//´ý¸Ä
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("D_no"));
				v.add(rs.getString("D_state"));
				v.add(rs.getString("D_time"));
				v.add(rs.getString("D_isbn"));
				v.add(rs.getString("D_tmname"));
				v.add(rs.getDouble("D_price"));
				v.add(rs.getInt("D_count"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtil.getInstance().closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*
	 * ±í¸ñ
	 */
	private void chukuTableListener(MouseEvent e) {
		int row = table.getSelectedRow();
		
		isbnTxt.setText((String)table.getValueAt(row, 3));
		nameTxt.setText((String)table.getValueAt(row, 4));
		priceTxt.setText((String)table.getValueAt(row, 5).toString());
		countTxt.setText(table.getValueAt(row, 6).toString());
		idTxt.setText(table.getValueAt(row, 0).toString());
	}
	/*
	 * ³ö¿â
	 */
	private void chukuListener(MouseEvent e) {
		int sum = Integer.parseInt(countTxt.getText());
		Connection con = null;
		
		try {
			con = DbUtil.getInstance().getConnection();
			chukuDao.chuku(con,isbnTxt.getText(), sum,Integer.parseInt(idTxt.getText()));
			JOptionPane.showMessageDialog(null, "³ö¿â³É¹¦");
			fillOrdersTable();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
