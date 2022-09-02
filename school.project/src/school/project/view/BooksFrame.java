package school.project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import school.project.dao.BookDao;
import school.project.dao.BookTypeDao;
import school.project.dao.PublishDao;
import school.project.model.Book;
import school.project.model.BookType;
import school.project.model.Publish;
import school.project.util.DbUtil;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BooksFrame extends JFrame {

	private JPanel contentPane;
	private JTextField isbnTxt;
	private JTextField nameTxt;
	private JTextField sdTxt;
	private JTextField wTxt;
	private JTextField pageTxt;
	private JTextField countTxt;
	private JTextField priceTxt;
	private JTextField cbTimeTxt;
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private PublishDao publishDao = new PublishDao();
	private JComboBox typeComboBox = new JComboBox();
	private JComboBox cbsComboBox = new JComboBox();
	private BookDao bookDao = new BookDao();
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BooksFrame frame = new BooksFrame();
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
	public BooksFrame() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 820, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 786, 531);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("ΩÃ≤ƒÃÌº”", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("isbn :");
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		lblNewLabel.setBounds(63, 27, 83, 35);
		panel.add(lblNewLabel);
		
		isbnTxt = new JTextField();
		isbnTxt.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		isbnTxt.setBounds(143, 25, 232, 38);
		panel.add(isbnTxt);
		isbnTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6559\u6750\u540D\u79F0 :");
		lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(20, 89, 113, 35);
		panel.add(lblNewLabel_1);
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		nameTxt.setColumns(10);
		nameTxt.setBounds(143, 87, 232, 38);
		panel.add(nameTxt);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u8BA2\u4E66\u5355\u4F4D :");
		lblNewLabel_1_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(20, 157, 113, 35);
		panel.add(lblNewLabel_1_1);
		
		sdTxt = new JTextField();
		sdTxt.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		sdTxt.setColumns(10);
		sdTxt.setBounds(143, 154, 232, 38);
		panel.add(sdTxt);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u6559\u6750\u7C7B\u578B :");
		lblNewLabel_1_1_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(20, 215, 113, 35);
		panel.add(lblNewLabel_1_1_1);
		
		typeComboBox = new JComboBox();
		typeComboBox.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		typeComboBox.setBounds(143, 214, 232, 45);
		panel.add(typeComboBox);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\u51FA\u7248\u793E :");
		lblNewLabel_1_1_1_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(20, 290, 113, 35);
		panel.add(lblNewLabel_1_1_1_1);
		
	    cbsComboBox = new JComboBox();
	    cbsComboBox.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		cbsComboBox.setBounds(143, 280, 232, 45);
		panel.add(cbsComboBox);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("\u4F5C\u8005 :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(450, 27, 113, 35);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("\u5370\u5F20 :");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(450, 89, 113, 35);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("\u5E93\u5B58 :");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(450, 157, 113, 35);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		wTxt = new JTextField();
		wTxt.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		wTxt.setColumns(10);
		wTxt.setBounds(519, 25, 232, 38);
		panel.add(wTxt);
		
		pageTxt = new JTextField();
		pageTxt.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		pageTxt.setColumns(10);
		pageTxt.setBounds(519, 87, 232, 38);
		panel.add(pageTxt);
		
		countTxt = new JTextField();
		countTxt.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		countTxt.setColumns(10);
		countTxt.setBounds(519, 154, 232, 38);
		panel.add(countTxt);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * ÃÌº”Õº È
				 */
				addBookActionListener(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BooksFrame.class.getResource("/images/\u6DFB\u52A0(1).png")));
		btnNewButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		btnNewButton.setBounds(174, 402, 201, 57);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setIcon(new ImageIcon(BooksFrame.class.getResource("/images/\u91CD\u7F6E(1).png")));
		btnNewButton_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		btnNewButton_1.setBounds(436, 402, 201, 57);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("\u5355\u4EF7 :");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(450, 229, 113, 35);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		priceTxt = new JTextField();
		priceTxt.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		priceTxt.setColumns(10);
		priceTxt.setBounds(519, 226, 232, 38);
		panel.add(priceTxt);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("\u51FA\u7248\u65F6\u95F4 :");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(416, 290, 113, 35);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1_1);
		
		cbTimeTxt = new JTextField();
		cbTimeTxt.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		cbTimeTxt.setColumns(10);
		cbTimeTxt.setBounds(519, 287, 232, 38);
		panel.add(cbTimeTxt);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("ΩÃ≤ƒπ‹¿Ì", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 761, 221);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u6559\u6750\u540D\u79F0", "\u6559\u6750\u7F16\u53F7", "\u7C7B\u578B\u7F16\u53F7", "\u51FA\u7248\u793E\u540D\u79F0", "\u51FA\u7248\u793E\u7F16\u53F7", "\u51FA\u7248\u65F6\u95F4", "\u4F5C\u8005", "\u5370\u5F20", "\u5E93\u5B58", "\u4EF7\u683C"
			}
		));
		scrollPane.setViewportView(table);
		fillBookType();
		fillCbsType();
		fillOrdersTable();
	}
	/*
	 * ≥ı ºªØΩÃ≤ƒ¿‡–Õœ¬¿≠øÚ
	 */
	private void fillBookType() {
		Connection con = null;
		BookType bookType = null;
		try {
			con = DbUtil.getInstance().getConnection();
			ResultSet rs = bookTypeDao.list(con, new BookType());
			while(rs.next()) {
				bookType = new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				typeComboBox.addItem(bookType);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * ≥ı ºªØ≥ˆ∞Ê…Áœ¬¿≠øÚ
	 */
	private void fillCbsType() {
		Connection con = null;
		Publish publish = null;
		try {
			con = DbUtil.getInstance().getConnection();
			ResultSet rs = publishDao.list(con, new Publish());
			while(rs.next()) {
				publish = new Publish();
				publish.setId(rs.getInt("Cbs_id"));
				publish.setCbsName(rs.getString("Cbs_name"));
				cbsComboBox.addItem(publish);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * ÃÌº”Õº È
	 */
	
	private void addBookActionListener(MouseEvent e) {
		String isbn = isbnTxt.getText();
		String name = nameTxt.getText();
		String sd = sdTxt.getText();
		String writer = wTxt.getText();
		int  page = Integer.parseInt(pageTxt.getText());
		int  count = Integer.parseInt(countTxt.getText());
		double  price = Double.parseDouble(priceTxt.getText());
		String  cbTime = cbTimeTxt.getText();
		/*
		 * typeComboBox = new JComboBox();
	private JComboBox cbsComboBox 
		 */
		BookType bookType = (BookType)typeComboBox.getSelectedItem();
		int bookTypeId = bookType.getId();
		Publish publish = (Publish)cbsComboBox.getSelectedItem();
		String Cbs = publish.getCbsName();
		String bookTypeName = bookType.getBookTypeName();
		Book book = new Book(isbn,name,bookTypeId,sd,Cbs,cbTime,writer,page,count,price);
		try {
			bookDao.add(book);
			JOptionPane.showMessageDialog(null, "ÃÌº”≥…π¶");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ÃÌº” ß∞‹");
			e1.printStackTrace();
		}
	}
	/*
	 * ±Ì∏Ò≥ı ºªØ
	 */
	void fillOrdersTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//∏Ò ΩªØ≤Ÿ◊˜£¨…Ë÷√≥…0–– = = ±Ì∏Ò«Âø’
		Connection con = null;
		try {
			con = DbUtil.getInstance().getConnection();
			ResultSet rs = bookDao.list(con);//¥˝∏ƒ
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Tm_isbn"));
				v.add(rs.getString("Tm_name"));
				v.add(rs.getInt("Tm_typeid"));
				v.add(rs.getString("Tm_sd"));
				v.add(rs.getString("Tm_cbs"));
				v.add(rs.getString("Tm_pd"));
				v.add(rs.getString("Tm_w"));
				v.add(rs.getInt("Tm_page"));
				v.add(rs.getInt("Tm_Count"));
				v.add(rs.getDouble("Tm_price"));
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
}
