package school.project.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import school.project.dao.SdeptUserDao;
import school.project.dao.UserDao;
import school.project.model.SdeptUser;
import school.project.model.User;
import school.project.util.DbUtil;
import school.project.util.StringUtil;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogOnFrame {

	private JFrame frame;
	private JTextField userNameText;
	private JPasswordField passwordText;

	private UserDao userDao = new UserDao();
	private SdeptUserDao sdeptUserDao = new SdeptUserDao();
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrame window = new LogOnFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogOnFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		frame.setBounds(100, 100, 618, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		userNameText = new JTextField();
		userNameText.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		userNameText.setBounds(201, 100, 317, 65);
		frame.getContentPane().add(userNameText);
		userNameText.setColumns(10);
		
		JButton userLogin = new JButton("\u7BA1\u7406\u5458\u767B\u5F55");
		userLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}

			
		});
		userLogin.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		userLogin.setBounds(347, 286, 185, 79);
		frame.getContentPane().add(userLogin);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(23, 100, 156, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(23, 191, 156, 65);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u9AD8\u6821\u6559\u6750\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(46, 24, 507, 54);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordText = new JPasswordField();
		passwordText.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		passwordText.setBounds(201, 191, 317, 65);
		frame.getContentPane().add(passwordText);
		
		JButton studentLogin = new JButton("\u9662\u7CFB\u767B\u5F55");
		
		studentLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 学生登录
				 */
				studentsLoginListener(e);
			}
		});
		studentLogin.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		studentLogin.setBounds(82, 286, 185, 79);
		frame.getContentPane().add(studentLogin);
		
	}
    /*
     * 管理员登录事件处理
     */
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String useName = this.userNameText.getText();
		String password = new String(this.passwordText.getPassword());
		
		if(StringUtil.isEmpty(useName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		User user = new User(useName,password);
		
		try {
			Connection con = DbUtil.getInstance().getConnection();
			User currentUser = userDao.login(con,user);
			if(currentUser != null) {
				//JOptionPane.showMessageDialog(null, "登录成功");
			    frame.dispose();//当前窗口销毁
				new MainFrame().setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 学院登录事件处理
	 */
	public void studentsLoginListener(MouseEvent evt) {
		StudentLoginFrame studentLoginFrame = new StudentLoginFrame();
		
		String useName = this.userNameText.getText();
		String password = new String(this.passwordText.getPassword());
		
		if(StringUtil.isEmpty(useName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		SdeptUser sdeptUser = new SdeptUser(useName,password);
		try {
			Connection con = DbUtil.getInstance().getConnection();
			SdeptUser currentUser = sdeptUserDao.login(con,sdeptUser);
			if(currentUser != null) {
				//JOptionPane.showMessageDialog(null, "登录成功");
			    frame.dispose();//当前窗口销毁
		        studentLoginFrame.setVisible(true);
		        
			}
			else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
