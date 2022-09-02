package school.project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import school.project.dao.OrdersDao;
import school.project.dao.UserDao;
import school.project.model.Orders;
import school.project.util.DbUtil;
import school.project.util.StringUtil;

import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;

public class StudentLoginFrame extends JFrame {

	private JPanel contentPane;
	private  JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private  JPanel panel = new JPanel();
	private JLabel lblNewLabel = new JLabel("ISBN :");
	private JTextField getIsbn = new JTextField();
	private JLabel lblNewLabel_1 = new JLabel("\u4E66\u540D :");
	private JTextField getBookName = new JTextField();
	private JLabel lblNewLabel_4 = new JLabel("\u6240\u9700\u6570\u91CF :");
	private JTextField getCount = new JTextField();
	private JLabel lblNewLabel_4_1 = new JLabel("\u5B66\u9662 :");
	private JTextField getSdept = new JTextField();
	private  JButton btnNewButton_1 = new JButton("\u63D0\u4EA4");
	private JTable table;
	private OrdersDao orderDao = new OrdersDao();
	private Orders ordersFind = new Orders();
	private JPanel panel_3 = new JPanel();
	private  JLabel lblNewLabel_2 = new JLabel("\u8BA2\u5355\u7F16\u53F7 \uFF1A");
	private JTextField DnoTxt = new JTextField();
	private JTextField nameTxt;
	private JLabel lblNewLabel_3_1 = new JLabel("\u6559\u6750\u540D\u79F0 \uFF1A");
	private JTextField IsbnTxt = new JTextField();
	private JLabel lblNewLabel_2_1 = new JLabel("\u5355\u4EF7 \uFF1A");
	private JTextField priceTxt = new JTextField();
	private JLabel lblNewLabel_3_2 = new JLabel("\u6570\u91CF \uFF1A");
	private JTextField countTxt = new JTextField();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLoginFrame frame = new StudentLoginFrame();
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
	public StudentLoginFrame() {
		DnoTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		DnoTxt.setEditable(false);
		DnoTxt.setBounds(112, 15, 123, 46);
		DnoTxt.setColumns(10);
		
		setTitle("\u5B66\u9662\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 569);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(0, 10, 801, 512);
		contentPane.add(tabbedPane);
		getIsbn.setBounds(111, 23, 212, 41);
		getIsbn.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		getIsbn.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("表单提交", null, panel_1, null);
		panel_1.setLayout(null);
		lblNewLabel.setBounds(10, 23, 64, 41);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		panel_1.add(lblNewLabel);
		
		panel_1.add(getIsbn);
		lblNewLabel_1.setBounds(10, 86, 64, 41);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		panel_1.add(lblNewLabel_1);
		getBookName.setBounds(111, 86, 212, 41);
		getBookName.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		getBookName.setColumns(10);
		
		panel_1.add(getBookName);
		lblNewLabel_4.setBounds(10, 158, 91, 52);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		panel_1.add(lblNewLabel_4);
		getCount.setBounds(111, 164, 212, 41);
		getCount.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		getCount.setColumns(10);
		
		panel_1.add(getCount);
		lblNewLabel_4_1.setBounds(10, 249, 80, 35);
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		panel_1.add(lblNewLabel_4_1);
		getSdept.setBounds(111, 243, 212, 46);
		getSdept.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		getSdept.setColumns(10);
		
		panel_1.add(getSdept);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addOrdersListener(e);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton_1.setBounds(350, 404, 113, 35);
		
		panel_1.add(btnNewButton_1);
		
		tabbedPane.addTab("查看表单", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 31, 662, 201);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 表格点击事件
				 */
				ordersAddActionListener(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u72B6\u6001", "\u8BA2\u5355\u7F16\u53F7", "ISBN", "\u6559\u6750\u540D\u79F0", "\u5355\u4EF7", "\u6570\u91CF"
			}
		));
		fillOrdersTable();
		scrollPane.setViewportView(table);
		panel_3.setBorder(new TitledBorder(null, "\u8BA2\u5355\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 254, 776, 201);
		
		panel.add(panel_3);
		panel_3.setLayout(null);
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 28, 112, 33);
		
		panel_3.add(lblNewLabel_2);
		
		panel_3.add(DnoTxt);
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		nameTxt.setBounds(577, 15, 149, 47);
		panel_3.add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ISBN \uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(245, 17, 91, 44);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(476, 22, 112, 44);
		
		panel_3.add(lblNewLabel_3_1);
		IsbnTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		IsbnTxt.setColumns(10);
		IsbnTxt.setBounds(317, 16, 149, 45);
		
		panel_3.add(IsbnTxt);
		lblNewLabel_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(48, 99, 112, 33);
		
		panel_3.add(lblNewLabel_2_1);
		priceTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		priceTxt.setEditable(false);
		priceTxt.setColumns(10);
		priceTxt.setBounds(112, 86, 123, 46);
		
		panel_3.add(priceTxt);
		lblNewLabel_3_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(256, 86, 91, 44);
		
		panel_3.add(lblNewLabel_3_2);
		countTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		countTxt.setColumns(10);
		countTxt.setBounds(332, 86, 149, 45);
		
		panel_3.add(countTxt);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 修改事件
				 */
				updateActionListener(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(StudentLoginFrame.class.getResource("/images/\u4FEE\u6539.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton.setBounds(549, 145, 104, 46);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 删除
				 */
				deleteOrdersActionListener(e);
				}
		});
		btnNewButton_2.setIcon(new ImageIcon(StudentLoginFrame.class.getResource("/images/\u5220\u9664.png")));
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton_2.setBounds(663, 145, 104, 46);
		panel_3.add(btnNewButton_2);
		
	}
	/*
	 * 申请订单
	 */
	private void addOrdersListener(MouseEvent e) {
		String isbn = getIsbn.getText();
		String bookName = getBookName.getText();
		String bookCount = getCount.getText();
		String sdept = getSdept.getText();
		String state = "待发货";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        String time = df.format(System.currentTimeMillis());
		if(StringUtil.isEmpty(isbn)) {
			JOptionPane.showMessageDialog(null, "isbn码不能为空");
			return;
		}
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "书名不能为空");
			return;
		}
		if(StringUtil.isEmpty(bookCount)) {
			JOptionPane.showMessageDialog(null, "数量不能为空");
			return;
		}
		if(StringUtil.isEmpty(sdept)) {
			JOptionPane.showMessageDialog(null, "系部不能为空");
			return;
		}
		Connection con = DbUtil.getInstance().getConnection();
		
		Orders currentOrders = new Orders(isbn,bookName,Integer.parseInt(bookCount),sdept,time);
	    ordersFind = currentOrders;
		try {
			orderDao.OrdersAdd(con, currentOrders);
			JOptionPane.showMessageDialog(null, "提交订单成功");
			fillOrdersTable();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/*
	 * 查找订单
	 * 
	 */
	void fillOrdersTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//格式化操作，设置成0行 = = 表格清空
		Connection con = null;
		try {
			con = DbUtil.getInstance().getConnection();
			ResultSet rs = orderDao.list(con,"");//待改
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("D_state"));
				v.add(rs.getInt("D_no"));
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
	 * 表格点击事件
	 */
	private void ordersAddActionListener(MouseEvent e) {
		int row = table.getSelectedRow();
		DnoTxt.setText(table.getValueAt(row, 1).toString());
		IsbnTxt.setText((String)table.getValueAt(row, 2));
		nameTxt.setText((String)table.getValueAt(row, 3));
		priceTxt.setText(table.getValueAt(row, 4).toString());
		countTxt.setText(table.getValueAt(row, 5).toString());

	}
	/*
	 * 修改事件
	 */
	private void updateActionListener(MouseEvent e) {
		int id = Integer.parseInt(DnoTxt.getText());
		String isbn = IsbnTxt.getText();
		String name = nameTxt.getText();
		Double price = Double.parseDouble(priceTxt.getText());
		int count = Integer.parseInt(countTxt.getText());
		Orders orders = new Orders(id,isbn,name,price,count);
		try {
			orderDao.updateOrders(orders);
			JOptionPane.showMessageDialog(null, "修改成功");
			fillOrdersTable();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private void deleteOrdersActionListener(MouseEvent e) {
		int id = Integer.parseInt(DnoTxt.getText());
		try {
			orderDao.deleteOrders(id);
			JOptionPane.showMessageDialog(null, "删除成功");
			fillOrdersTable();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
