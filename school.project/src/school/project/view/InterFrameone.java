package school.project.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;

public class InterFrameone extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterFrameone frame = new InterFrameone();
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
	public InterFrameone() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setTitle("\u55E8\u5BB3");
		setToolTipText("");
		setBackground(Color.RED);
		setBounds(100, 100, 564, 436);

	}
}
