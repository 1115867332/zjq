package school.project.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import school.project.dao.UserDao;
import school.project.model.User;
import school.project.util.DbUtil;

import javax.swing.JPanel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class UsersInterFrame extends JInternalFrame {
	private JTable table;
	private UserDao userDao = new UserDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersInterFrame frame = new UsersInterFrame();
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
	public UsersInterFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u7BA1\u7406\u5458");
		setBounds(100, 100, 733, 502);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 70, 643, 336);
		getContentPane().add(scrollPane_1);
		
		table = new JTable();
		table.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u7F16\u53F7", "\u59D3\u540D", "\u5730\u5740", "\u6027\u522B"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(49);
		table.getColumnModel().getColumn(1).setPreferredWidth(73);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(2).setMaxWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(57);
		table.getColumnModel().getColumn(3).setMinWidth(25);
		table.getColumnModel().getColumn(3).setMaxWidth(100);
		this.fillUserTable();
	}
	/*
	 * 初始化表格
	 */
	private void fillUserTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//格式化操作，设置成0行 = = 表格清空
		Connection con = null;
		try {
			con = DbUtil.getInstance().getConnection();
			ResultSet rs = userDao.list(con);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("username"));
				v.add(rs.getString("user_address"));
				v.add(rs.getString("user_sex"));
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
