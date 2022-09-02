package school.project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import school.project.dao.PublishDao;
import school.project.model.Publish;
import school.project.util.DbUtil;
import school.project.util.StringUtil;

import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PublishingHouse extends JFrame {

	private JPanel contentPane;
	private JTextField publishNameTxt;
	private JTextField publishPhoneTxt;
	private JTextField publishPeopleTxt;
	private JTextField publishAddressTxt;
	private JTextField publishNameFindText;
	private JTable table;
	private JTextField idText;
	private JTextField publishNameText;
	private JTextField publishPhoneText;
	private JTextField publishPeopleText;
	private JTextField publishAddressText;
	private PublishDao publishDao = new PublishDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublishingHouse frame = new PublishingHouse();
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
	public PublishingHouse() {
		setTitle("\u51FA\u7248\u793E\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 691, 510);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("出版社添加", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u51FA\u7248\u793E\u540D\u79F0 \uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 36, 160, 43);
		panel.add(lblNewLabel);
		
		publishNameTxt = new JTextField();
		publishNameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		publishNameTxt.setBounds(136, 31, 239, 52);
		panel.add(publishNameTxt);
		publishNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u51FA\u7248\u793E\u7535\u8BDD \uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 109, 160, 43);
		panel.add(lblNewLabel_1);
		
		publishPhoneTxt = new JTextField();
		publishPhoneTxt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		publishPhoneTxt.setColumns(10);
		publishPhoneTxt.setBounds(137, 105, 239, 52);
		panel.add(publishPhoneTxt);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u8D1F\u8D23\u4EBA \uFF1A");
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(47, 194, 160, 43);
		panel.add(lblNewLabel_1_1);
		
		publishPeopleTxt = new JTextField();
		publishPeopleTxt.setBounds(139, 189, 237, 48);
		panel.add(publishPeopleTxt);
		publishPeopleTxt.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u5730\u5740 \uFF1A");
		lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(68, 269, 160, 43);
		panel.add(lblNewLabel_1_1_1);
		
		publishAddressTxt = new JTextField();
		publishAddressTxt.setColumns(10);
		publishAddressTxt.setBounds(137, 271, 237, 48);
		panel.add(publishAddressTxt);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		/*
		 * 添加出版社
		 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addPublishmouseClicked(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(PublishingHouse.class.getResource("/images/\u6DFB\u52A0(1).png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton.setBounds(114, 369, 196, 64);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		/*
		 * 重置事件
		 */
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rePublishMouseClicked();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(PublishingHouse.class.getResource("/images/\u91CD\u7F6E(1).png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton_1.setBounds(415, 366, 196, 64);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("出版社管理", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u51FA\u7248\u793E\u540D\u79F0 \uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 21, 189, 34);
		panel_1.add(lblNewLabel_2);
		
		publishNameFindText = new JTextField();
		publishNameFindText.setBounds(143, 21, 323, 48);
		panel_1.add(publishNameFindText);
		publishNameFindText.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 查询
				 */
				publishSearchListener(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(PublishingHouse.class.getResource("/images/\u67E5\u8BE2(1).png")));
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton_2.setBounds(503, 21, 106, 48);
		panel_1.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 100, 600, 118);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				publishTableListener(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u540D\u79F0", "\u7535\u8BDD", "\u8D1F\u8D23\u4EBA", "\u5730\u5740"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(38, 252, 600, 191);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7 \uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 23, 96, 34);
		panel_2.add(lblNewLabel_3);
		
		idText = new JTextField();
		idText.setEditable(false);
		idText.setBounds(71, 20, 143, 34);
		panel_2.add(idText);
		idText.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u540D\u79F0 \uFF1A");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(253, 21, 96, 39);
		panel_2.add(lblNewLabel_4);
		
		publishNameText = new JTextField();
		publishNameText.setBounds(310, 20, 213, 40);
		panel_2.add(publishNameText);
		publishNameText.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u7535\u8BDD \uFF1A");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(12, 74, 97, 38);
		panel_2.add(lblNewLabel_5);
		
		publishPhoneText = new JTextField();
		publishPhoneText.setColumns(10);
		publishPhoneText.setBounds(71, 76, 177, 40);
		panel_2.add(publishPhoneText);
		
		JLabel lblNewLabel_5_1 = new JLabel("\u8D1F\u8D23\u4EBA \uFF1A");
		lblNewLabel_5_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_5_1.setBounds(263, 74, 97, 38);
		panel_2.add(lblNewLabel_5_1);
		
		publishPeopleText = new JTextField();
		publishPeopleText.setColumns(10);
		publishPeopleText.setBounds(330, 76, 177, 40);
		panel_2.add(publishPeopleText);
		
		JLabel lblNewLabel_5_2 = new JLabel("\u5730\u5740 \uFF1A");
		lblNewLabel_5_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_5_2.setBounds(10, 131, 97, 38);
		panel_2.add(lblNewLabel_5_2);
		
		publishAddressText = new JTextField();
		publishAddressText.setColumns(10);
		publishAddressText.setBounds(71, 133, 267, 40);
		panel_2.add(publishAddressText);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 表单更新
				 */
				updatePublishTableListener(e);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(PublishingHouse.class.getResource("/images/\u4FEE\u6539.png")));
		btnNewButton_3.setBounds(373, 133, 96, 39);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 删除事件
				 */
				deletePublishListener(e);
			}
		});
		btnNewButton_3_1.setIcon(new ImageIcon(PublishingHouse.class.getResource("/images/\u5220\u9664.png")));
		btnNewButton_3_1.setBounds(479, 133, 96, 39);
		panel_2.add(btnNewButton_3_1);
		fillPublishTable(new Publish());
	}
	/*
	 * 重置事件
	 */
	private void rePublishMouseClicked() {
		publishNameTxt.setText("");
		publishPhoneTxt.setText("");
		publishPeopleTxt.setText("");
		publishAddressTxt.setText("");
	}
	/*
	 * 添加出版社
	 */
	private void addPublishmouseClicked(MouseEvent e) {
		String name = publishNameTxt.getText();
		String phone = publishPhoneTxt.getText();
		String people = publishPeopleTxt.getText();
		String address = publishAddressTxt.getText();
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "出版社名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(phone)) {
			JOptionPane.showMessageDialog(null, "出版社电话不能为空");
			return;
		}
		if(StringUtil.isEmpty(people)) {
			JOptionPane.showMessageDialog(null, "出版社联系人不能为空");
			return;
		}
		if(StringUtil.isEmpty(address)) {
			JOptionPane.showMessageDialog(null, "出版社地址不能为空");
			return;
		}
		Publish publish = new Publish(name,phone,people,address);
		Connection con = null;
		try {
			con = DbUtil.getInstance().getConnection();
			int n = publishDao.add(con, publish);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "出版社添加成功");
				rePublishMouseClicked();
			}
			else {
				JOptionPane.showMessageDialog(null, "出版社添加失败");
			}
		}catch(Exception exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "出版社添加失败");
		}finally {
			try {
				DbUtil.getInstance().closeCon(con);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		fillPublishTable(new Publish());
	}
	/*
	 * 初始化表单
	 * 
	 */
	private void fillPublishTable(Publish publish) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//格式化操作，设置成0行 = = 表格清空
	    
		Connection con = null;
		try {
			con = DbUtil.getInstance().getConnection();
			ResultSet rs = publishDao.list(con, publish);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Cbs_id"));
				v.add(rs.getString("Cbs_name"));
				v.add(rs.getString("Cbs_tel"));
				v.add(rs.getString("Cbs_cp"));
				v.add(rs.getString("Cbs_dz"));
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
	 * 查询
	 */
	private void publishSearchListener(MouseEvent e) {
		String name = publishNameFindText.getText();
		Publish publish = new Publish();
		publish.setCbsName(name);
		fillPublishTable(publish);
	}
	/*
	 * 更新
	 */
	private void updatePublishTableListener(MouseEvent e) {
		
		String id = idText.getText();
		String name = publishNameText.getText();
		String phone = publishPhoneText.getText();
		String peo = publishPeopleText.getText();
		String address = publishAddressText.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "出版社名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(phone)) {
			JOptionPane.showMessageDialog(null, "出版社电话不能为空");
			return;
		}
		if(StringUtil.isEmpty(peo)) {
			JOptionPane.showMessageDialog(null, "出版社负责人不能为空");
			return;
		}
		if(StringUtil.isEmpty(address)) {
			JOptionPane.showMessageDialog(null, "出版社地址不能为空");
			return;
		}
		Publish publish = new Publish(Integer.parseInt(id),name,phone,peo,address);
		Connection con = null;
		try {
			con = DbUtil.getInstance().getConnection();
			int modifyNum = publishDao.update(con, publish);
			if(modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				rePublishMouseClicked();
				fillPublishTable(new Publish());
			}
			else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch(Exception exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "出版社添加失败");
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
	 * 表格点击事件
	 */
	/*
		 * publishNameText;
	private JTextField publishPhoneText;
	private JTextField publishPeopleText;
	private JTextField publishAddressText;
		 */
	private void publishTableListener(MouseEvent e) {
		int row = table.getSelectedRow();
		idText.setText((String)table.getValueAt(row, 0));
		publishNameText.setText((String)table.getValueAt(row, 1));
		publishPhoneText.setText((String)table.getValueAt(row, 2));
		publishPeopleText.setText((String)table.getValueAt(row, 3));
		publishAddressText.setText((String)table.getValueAt(row, 4));
	}
	/*
	 * 删除
	 */
	private void deletePublishListener(MouseEvent e) {
		String id = idText.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除记录吗");
		if(n==0) {
			Connection con = null;
			try {
				con = DbUtil.getInstance().getConnection();
				int deleteNum = publishDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					rePublishMouseClicked();
					fillPublishTable(new Publish());
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
