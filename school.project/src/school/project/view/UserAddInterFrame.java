package school.project.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import school.project.dao.UserDao;
import school.project.model.User;
import school.project.util.DbUtil;
import school.project.util.StringUtil;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class UserAddInterFrame extends JInternalFrame {
	private JTextField addUserName;
	private JTextField addUserSex;
	private JTextField addUserAddress;
	private JPasswordField addUserPassword;
	
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAddInterFrame frame = new UserAddInterFrame();
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
	public UserAddInterFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u7BA1\u7406\u5458\u6DFB\u52A0");
		setBounds(100, 100, 521, 366);
		getContentPane().setLayout(null);
		
		addUserName = new JTextField();
		addUserName.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		addUserName.setBounds(124, 33, 235, 34);
		getContentPane().add(addUserName);
		addUserName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D \uFF1A");
		lblNewLabel.setIcon(new ImageIcon(UserAddInterFrame.class.getResource("/images/\u59D3\u540D(1).png")));
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 30, 117, 45);
		getContentPane().add(lblNewLabel);
		
		addUserSex = new JTextField();
		addUserSex.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		addUserSex.setBounds(124, 85, 235, 33);
		getContentPane().add(addUserSex);
		addUserSex.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027\u522B \uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(UserAddInterFrame.class.getResource("/images/\u6027\u522B(1).png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(20, 85, 92, 38);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u5730\u5740 \uFF1A");
		lblNewLabel_1_1.setIcon(new ImageIcon(UserAddInterFrame.class.getResource("/images/\u5730\u5740(1).png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(20, 133, 92, 38);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u5BC6\u7801 \uFF1A");
		lblNewLabel_1_2.setIcon(new ImageIcon(UserAddInterFrame.class.getResource("/images/\u5BC6\u7801(1).png")));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(20, 181, 92, 38);
		getContentPane().add(lblNewLabel_1_2);
		
		addUserAddress = new JTextField();
		addUserAddress.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		addUserAddress.setColumns(10);
		addUserAddress.setBounds(124, 141, 235, 31);
		getContentPane().add(addUserAddress);
		
		JButton addButton = new JButton("\u6DFB\u52A0");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//resetValueActionPerformed(e);
				addUserActionPerformed(e);
			}
		});
		addButton.setIcon(new ImageIcon(UserAddInterFrame.class.getResource("/images/\u6DFB\u52A0(1).png")));
		addButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		addButton.setBounds(44, 271, 138, 38);
		getContentPane().add(addButton);
		
		JButton ReButton = new JButton("\u91CD\u7F6E");
		ReButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUserName.setText("");
				addUserSex.setText("");
				addUserAddress.setText("");
				addUserPassword.setText("");
			}
		});
		
		/*
		 * ÖØÖÃÊÂ¼þ
		 */
		ReButton.setIcon(new ImageIcon(UserAddInterFrame.class.getResource("/images/\u91CD\u7F6E(1).png")));
		ReButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		ReButton.setBounds(280, 271, 138, 38);
		getContentPane().add(ReButton);
		
		addUserPassword = new JPasswordField();
		addUserPassword.setBounds(124, 194, 235, 34);
		getContentPane().add(addUserPassword);

	}
	/*
	 * ×¢²áÊÂ¼þ
	 */
	private void addUserActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "ÊÔÍ¼×¢²á");
		String userName = this.addUserName.getText();
		String userSex = this.addUserSex.getText();
		String userAddress = this.addUserAddress.getText();
		String password = new String(this.addUserPassword.getPassword());
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "ÓÃ»§Ãû²»ÄÜÎª¿Õ");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "ÃÜÂë²»ÄÜÎª¿Õ");
			return;
		}
		
		try {
			
			Connection con = DbUtil.getInstance().getConnection();
		    User currentUser = new User(userName,userSex,userAddress,password);
			userDao.userAdd(con,currentUser);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
