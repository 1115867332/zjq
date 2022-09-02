package school.project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JDesktopPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	private JDesktopPane table = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu userMenu = new JMenu("\u7BA1\u7406\u5458\u7BA1\u7406");
	
		userMenu.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		menuBar.add(userMenu);
		
		JMenu addUserMenu = new JMenu("\u7BA1\u7406\u5458\u6DFB\u52A0");
		addUserMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserAddInterFrame userAddInterFrame = new UserAddInterFrame();
				userAddInterFrame.setVisible(true);
				table.add(userAddInterFrame);
				
			}
		});
		/*
		 * 管理员添加
		 */
		userMenu.add(addUserMenu);
		
		JMenu deleteUserMenu = new JMenu("\u7BA1\u7406\u5458\u5220\u9664");
		deleteUserMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 管理员删除
				 */
				UserDeleteInterFrame userDeleteInterFrame = new UserDeleteInterFrame();
				userDeleteInterFrame.setVisible(true);
				table.add(userDeleteInterFrame);
			}
		});
		userMenu.add(deleteUserMenu);
		
		JMenu mnNewMenu_4 = new JMenu("\u7BA1\u7406\u5458\u9884\u89C8");
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 管理员预览
				 */
				UsersInterFrame usersInterFrame = new UsersInterFrame();
				usersInterFrame.setVisible(true);
				table.add(usersInterFrame);
			}
		});
		userMenu.add(mnNewMenu_4);
		/*
		 * 安全退出
		 */
		
		JMenu mnNewMenu_1 = new JMenu("\u6559\u6750\u4FE1\u606F\u8868");
		
		menuBar.add(mnNewMenu_1);
		
		mnNewMenu_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JMenu mnNewMenu = new JMenu("\u6559\u6750\u7C7B\u578B\u7BA1\u7406");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 教材类型管理
				 */
				BookTypeManager bookTypeManager = new BookTypeManager();
				bookTypeManager.setVisible(true);
				table.add(bookTypeManager);
			}
		});
		mnNewMenu_1.add(mnNewMenu);
		
		JMenu mnNewMenu_3 = new JMenu("\u6559\u6750\u7BA1\u7406");
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 教材管理
				 */
				booksFrameListener(e);
			}
		});
		
		JMenu mnNewMenu_5 = new JMenu("\u51FA\u7248\u793E\u7BA1\u7406");
		mnNewMenu_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 出版社
				 */
				PublishingHouse publishHouse = new PublishingHouse();
				publishHouse.setVisible(true);
				table.add(publishHouse);
			}
		});
		mnNewMenu_1.add(mnNewMenu_5);
		mnNewMenu_1.add(mnNewMenu_3);
		
		JMenu mnNewMenu_6 = new JMenu("\u6559\u6750\u51FA\u5E93\u7BA1\u7406");
		mnNewMenu_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 教材出库
				 */
				ChuKuFrame chukuFrame = new ChuKuFrame();
				chukuFrame.setVisible(true);
				table.add(chukuFrame);
			}
		});
		mnNewMenu_6.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		mnNewMenu_6.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu_6);
		
		JMenu mnNewMenu_2 = new JMenu("\u5B89\u5168\u9000\u51FA");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result == 0) {
					dispose();
				}
			}
		});
		mnNewMenu_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_7 = new JMenu("\u6559\u6750\u8BA2\u8D2D\u7BA1\u7406");
		mnNewMenu_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DingGouFrame dingGouFrame = new DingGouFrame();
				dingGouFrame.setVisible(true);
				table.add(dingGouFrame);
			}
		});
		mnNewMenu_7.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_7);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//JDesktopPane table = new JDesktopPane();
		table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		contentPane.add(table, BorderLayout.CENTER);
		table.setLayout(null);
		this.setExtendedState(MAXIMIZED_BOTH);//全屏
	}
	/*
	 * 教材管理
	 */
	public void booksFrameListener(MouseEvent e) {
		BooksFrame booksFrame = new BooksFrame();
		booksFrame.setVisible(true);
		table.add(booksFrame);
	}
}
