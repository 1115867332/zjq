package school.project.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import school.project.dao.UserDao;
import school.project.util.DbUtil;
import school.project.util.StringUtil;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class UserDeleteInterFrame extends JInternalFrame {
	private JTextField textField;
	private UserDao userDao = new UserDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDeleteInterFrame frame = new UserDeleteInterFrame();
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
	public UserDeleteInterFrame() {
		setTitle("\u7BA1\u7406\u5458\u5220\u9664");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		textField.setBounds(193, 42, 216, 49);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		Label label = new Label("\u7BA1\u7406\u5458id :");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label.setAlignment(Label.CENTER);
		label.setBounds(10, 37, 159, 54);
		getContentPane().add(label);
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.setIcon(new ImageIcon(UserDeleteInterFrame.class.getResource("/images/user(1).png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = Integer.parseInt(textField.getText()) ;
				if(StringUtil.isEmpty(textField.getText())) {
					JOptionPane.showMessageDialog(null, "id²»ÄÜÎª¿Õ");
				}
				else {
				Connection con = DbUtil.getInstance().getConnection();
				try {
					userDao.userDelete(con,id);
					JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton.setBounds(112, 154, 196, 54);
		getContentPane().add(btnNewButton);

	}
}
