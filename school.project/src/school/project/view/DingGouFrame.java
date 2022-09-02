package school.project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import school.project.dao.DingDanDao;
import school.project.dao.GongYingShangDao;
import school.project.model.BookType;
import school.project.model.DingDan;
import school.project.model.GongYingShang;
import school.project.model.Publish;
import school.project.util.DbUtil;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DingGouFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTxt;
	private JTextField telTxt;
	private JTextField peoTxt;
	private JTextField dzTxt;
	private JTextField isbnTxt;
	private JTextField nameText;
	private JTextField countTxt;
	private GongYingShangDao gysDao = new GongYingShangDao();
	private JComboBox gysComboBox;
	private DingDanDao dingDanDao = new DingDanDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DingGouFrame frame = new DingGouFrame();
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
	public DingGouFrame() {
		setTitle("\u6559\u6750\u8BA2\u8D2D\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 846, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 23, 812, 505);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("¶©¹ºÉÌ¹ÜÀí", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0 \uFF1A");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 35, 130, 44);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u7535\u8BDD \uFF1A");
		lblNewLabel_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(72, 122, 130, 44);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u8D1F\u8D23\u4EBA \uFF1A");
		lblNewLabel_1_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(56, 198, 130, 44);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("\u5730\u5740 \uFF1A");
		lblNewLabel_1_1_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(72, 284, 130, 44);
		panel.add(lblNewLabel_1_1_2);
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		nameTxt.setBounds(139, 32, 280, 50);
		panel.add(nameTxt);
		nameTxt.setColumns(10);
		
		telTxt = new JTextField();
		telTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		telTxt.setColumns(10);
		telTxt.setBounds(139, 119, 280, 50);
		panel.add(telTxt);
		
		peoTxt = new JTextField();
		peoTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		peoTxt.setColumns(10);
		peoTxt.setBounds(139, 198, 280, 50);
		panel.add(peoTxt);
		
		dzTxt = new JTextField();
		dzTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		dzTxt.setColumns(10);
		dzTxt.setBounds(139, 281, 280, 50);
		panel.add(dzTxt);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * Ìí¼Ó¹©Ó¦ÉÌ
				 */
				addGysListener(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(DingGouFrame.class.getResource("/images/\u6DFB\u52A0(1).png")));
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton.setBounds(139, 381, 205, 57);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setIcon(new ImageIcon(DingGouFrame.class.getResource("/images/\u91CD\u7F6E(1).png")));
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton_1.setBounds(448, 381, 205, 57);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("½Ì²Ä¶©¹º", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6559\u6750\u7F16\u53F7 \uFF1A");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 23, 215, 56);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\u6559\u6750\u540D\u79F0 \uFF1A");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 101, 215, 56);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u8BA2\u8D2D\u5355\u4F4D \uFF1A");
		lblNewLabel_2_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(10, 191, 215, 56);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\u8BA2\u8D2D\u6570\u91CF \uFF1A");
		lblNewLabel_2_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(10, 286, 215, 56);
		panel_1.add(lblNewLabel_2_1_1);
		
		isbnTxt = new JTextField();
		isbnTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		isbnTxt.setBounds(124, 34, 254, 43);
		panel_1.add(isbnTxt);
		isbnTxt.setColumns(10);
		
		nameText = new JTextField();
		nameText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		nameText.setColumns(10);
		nameText.setBounds(124, 112, 254, 43);
		panel_1.add(nameText);
		
		countTxt = new JTextField();
		countTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		countTxt.setColumns(10);
		countTxt.setBounds(124, 287, 254, 43);
		panel_1.add(countTxt);
		
		gysComboBox = new JComboBox();
		gysComboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		gysComboBox.setBounds(124, 196, 254, 51);
		panel_1.add(gysComboBox);
		
		JButton btnNewButton_2 = new JButton("\u8BA2\u8D2D");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dingGou(e);
			}
		});
		btnNewButton_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton_2.setBounds(257, 375, 266, 56);
		panel_1.add(btnNewButton_2);
		fillGysType();
	}
	/*
	 * Ìí¼Ó¹©Ó¦ÉÌ
	 */
	/*
	 * private JTextField nameTxt;
	private JTextField telTxt;
	private JTextField peoTxt;
	private JTextField dzTxt;
	 */
	public void addGysListener(MouseEvent e) {
		String name = nameTxt.getText();
		String tel = telTxt.getText();
		String peo = peoTxt.getText();
		String dz = dzTxt.getText();
		GongYingShang gongYingShang = new GongYingShang(peo,dz,tel,name);
		try {
			gysDao.add(gongYingShang);
			JOptionPane.showMessageDialog(null, "¹©Ó¦ÉÌÌí¼Ó³É¹¦");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "¹©Ó¦ÉÌÌí¼ÓÊ§°Ü");
			e1.printStackTrace();
		}
		
	}
	/*
	 * ³õÊ¼»¯¹©Ó¦ÉÌÏÂÀ­¿ò
	 */
	private void fillGysType() {
		GongYingShang gongYingShang = null;
		try {
			ResultSet rs = gysDao.list(new GongYingShang());
			while(rs.next()) {
				gongYingShang = new GongYingShang();
				gongYingShang.setGys_name(rs.getString("gys_name"));
				gysComboBox.addItem(gongYingShang);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * ¶©¹º
	 */
	/*
	 * private JTextField isbnTxt;
	private JTextField nameText;
	private JTextField countTxt;
	 */
	private void dingGou(MouseEvent e) {
		String isbn = isbnTxt.getText();
		String name = nameText.getText();
		int count = Integer.parseInt(countTxt.getText());
		GongYingShang gongYingShang = (GongYingShang)gysComboBox.getSelectedItem();
		String gys = gongYingShang.getGys_name();
		DingDan dingdan = new DingDan(isbn,name,gys,count);
		try {
			dingDanDao.add(dingdan);
			JOptionPane.showMessageDialog(null, "Ìí¼Ó¶©µ¥³É¹¦");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
