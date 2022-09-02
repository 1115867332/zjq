package school.project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import school.project.dao.BookTypeDao;
import school.project.model.BookType;
import school.project.util.DbUtil;
import school.project.util.StringUtil;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
/*
 * 图书类别管理
 */
public class BookTypeManager extends JFrame {

	private JPanel contentPane;
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt ;
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private JTable table;
	private JTextField bookTypeNameText;
	private JTextField idText2;
	private JTextField bookTypeNameTxt2;
	private JTextArea bookTypeDescTxt2 ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManager frame = new BookTypeManager();
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
	public BookTypeManager() {
		setTitle("\u6559\u6750\u7C7B\u522B\u7BA1\u7406");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 805, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 781, 550);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("添加类别", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6559\u6750\u7C7B\u522B \uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel.setBounds(63, 43, 194, 59);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6559\u6750\u7C7B\u522B\u63CF\u8FF0 \uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(24, 151, 194, 59);
		panel.add(lblNewLabel_1);
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		bookTypeNameTxt.setBounds(174, 44, 366, 65);
		panel.add(bookTypeNameTxt);
		bookTypeNameTxt.setColumns(10);
		
	    bookTypeDescTxt = new JTextArea();
		bookTypeDescTxt.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		bookTypeDescTxt.setBounds(173, 172, 503, 209);
		panel.add(bookTypeDescTxt);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addBookTypeListener(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeManager.class.getResource("/images/\u6DFB\u52A0(1).png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton.setBounds(121, 433, 200, 50);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 重置事件
				 */
				resetValue();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookTypeManager.class.getResource("/images/\u91CD\u7F6E(1).png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton_1.setBounds(433, 433, 200, 50);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("教材类别管理", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 71, 646, 181);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 表格监听
				 */
				bookTypeTableListener(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\u7F16\u53F7", "\u6559\u6750\u7C7B\u522B", "\u6559\u6750\u7C7B\u522B\u63CF\u8FF0"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(141);
		table.getColumnModel().getColumn(2).setPreferredWidth(312);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel(" \u6559\u6750\u7C7B\u522B\u540D\u79F0 \uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 10, 192, 51);
		panel_1.add(lblNewLabel_2);
		
		bookTypeNameText = new JTextField();
		bookTypeNameText.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		bookTypeNameText.setBounds(159, 6, 254, 58);
		panel_1.add(bookTypeNameText);
		bookTypeNameText.setColumns(10);
		fillBookTable(new BookType());
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bookTypeActionListener(e);
				/*
				 * 图书类型查询
				 */
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(BookTypeManager.class.getResource("/images/\u67E5\u8BE2(1).png")));
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton_2.setBounds(450, 7, 152, 57);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setToolTipText("");
		panel_2.setBounds(70, 283, 646, 208);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7 \uFF1A");
		lblNewLabel_3.setBounds(20, 21, 95, 39);
		panel_2.add(lblNewLabel_3);
		
		idText2 = new JTextField();
		idText2.setEditable(false);
		idText2.setBounds(73, 25, 112, 31);
		panel_2.add(idText2);
		idText2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u6559\u6750\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel_4.setBounds(249, 25, 112, 31);
		panel_2.add(lblNewLabel_4);
		
		bookTypeNameTxt2 = new JTextField();
		bookTypeNameTxt2.setBounds(347, 30, 236, 30);
		panel_2.add(bookTypeNameTxt2);
		bookTypeNameTxt2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u6559\u6750\u7C7B\u522B\u63CF\u8FF0");
		lblNewLabel_5.setBounds(10, 70, 101, 39);
		panel_2.add(lblNewLabel_5);
		
		bookTypeDescTxt2 = new JTextArea();
		bookTypeDescTxt2.setBounds(137, 77, 446, 61);
		panel_2.add(bookTypeDescTxt2);
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 表格更新
				 */
				bookTypeTableUpdate(e);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(BookTypeManager.class.getResource("/images/\u4FEE\u6539.png")));
		btnNewButton_3.setBounds(337, 152, 120, 39);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("\u5220\u9664");
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 删除
				 */
				deleteBookTypeListener(e);
			}
		});
		btnNewButton_3_1.setIcon(new ImageIcon(BookTypeManager.class.getResource("/images/\u5220\u9664.png")));
		btnNewButton_3_1.setBounds(497, 152, 120, 39);
		panel_2.add(btnNewButton_3_1);
		
	}
	/*
	 * 重置事件
	 */
	private void resetValue() {
		bookTypeNameTxt.setText("");
		bookTypeDescTxt.setText("");
		
	}
	/*
	 * 添加图书类型
	 */
	private void addBookTypeListener(MouseEvent e) {
		String bookTypeName = bookTypeNameTxt.getText();
		String bookTypeDesc = bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类型不能为空");
			return;
		}
		if(StringUtil.isEmpty(bookTypeDesc)) {
			JOptionPane.showMessageDialog(null, "图书类型描述不能为空");
			return;
		}
		BookType bookType = new BookType(bookTypeName,bookTypeDesc);
		Connection con = null;
		try {
			con = DbUtil.getInstance().getConnection();
			int n = bookTypeDao.add(con, bookType);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "图书类型添加成功");
				resetValue();
			}
			else {
				JOptionPane.showMessageDialog(null, "图书类型添加失败");
			}
		}catch(Exception exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书类型添加失败");
		}finally {
			try {
				DbUtil.getInstance().closeCon(con);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		fillBookTable(new BookType());
	}
	/*
	 * 图书类型查询
	 */
	private void bookTypeActionListener(MouseEvent ee) {
		String s_bookTypeName = bookTypeNameText.getText();
		BookType bookType = new BookType();
		//System.out.println(s_bookTypeName);
		//System.out.println("上面内条没有");
		bookType.setBookTypeName(s_bookTypeName);
		fillBookTable(bookType);
		
		
	}
	/*
	 * 表格初始化
	 */
	private void fillBookTable(BookType bookType) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//格式化操作，设置成0行 = = 表格清空
	    
		Connection con = null;
		try {
			con = DbUtil.getInstance().getConnection();
			ResultSet rs = bookTypeDao.list(con, bookType);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
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
	 * 表格行点击事件处理
	 */
	private void bookTypeTableListener(MouseEvent e) {
		int row = table.getSelectedRow();
		idText2.setText((String)table.getValueAt(row, 0));
		bookTypeNameTxt2.setText((String)table.getValueAt(row, 1));
		bookTypeDescTxt2.setText((String)table.getValueAt(row, 2));
		
		
	}
	/*
	 * 表格更新
	 */
	private void bookTypeTableUpdate(MouseEvent e) {
		String id = idText2.getText();
		String bookTypeName = bookTypeNameTxt2.getText();
		String bookTypeDesc = bookTypeDescTxt2.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "教材名称不能为空");
			return;
		}
		BookType bookType = new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
		Connection con = null;
		try {
			con = DbUtil.getInstance().getConnection();
			int modifyNum = bookTypeDao.update(con, bookType);
			if(modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				resetValue2();
				fillBookTable(new BookType());
			}
			else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch(Exception exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书类型添加失败");
		}finally {
			try {
				DbUtil.getInstance().closeCon(con);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	   }
   }
	/*
	 * 重置表单panel2
	 */
	private void resetValue2() {
		idText2.setText("");
		bookTypeNameTxt2.setText("");
		bookTypeDescTxt2.setText("");
		
	}
	/*
	 * 教材类型删除
	 */
	private void deleteBookTypeListener(MouseEvent e) {
		String id = idText2.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除记录吗");
		if(n==0) {
			Connection con = null;
			try {
				con = DbUtil.getInstance().getConnection();
				int deleteNum = bookTypeDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					resetValue();
					fillBookTable(new BookType());
				}
				else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception ee){
				ee.printStackTrace();
				JOptionPane.showMessageDialog(null, "修改失败");
			}finally {
				try {
					DbUtil.getInstance().closeCon(con);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
	}
}
