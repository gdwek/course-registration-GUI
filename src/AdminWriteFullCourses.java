import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class AdminWriteFullCourses extends JFrame {

	public static JPanel contentPane;
	private JButton btnReturnToReports;
	private static JLabel lblTheFileHas;
	private static JLabel lblTheFileCouldNot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWriteFullCourses frame = new AdminWriteFullCourses();
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
	public AdminWriteFullCourses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnReturnToReports = new JButton("Return to reports menu");
		btnReturnToReports.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturnToReports.setBounds(431, 27, 194, 29);
		contentPane.add(btnReturnToReports);
		
		JLabel lblWriteFullCourses = new JLabel("Write Full Courses");
		lblWriteFullCourses.setForeground(Color.WHITE);
		lblWriteFullCourses.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblWriteFullCourses.setBounds(131, 56, 419, 71);
		contentPane.add(lblWriteFullCourses);
		
		lblTheFileHas = new JLabel("The file has been written.");
		lblTheFileHas.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTheFileHas.setForeground(Color.WHITE);
		lblTheFileHas.setBounds(203, 155, 242, 34);
		
		
		lblTheFileCouldNot= new JLabel("The file could not be written.");
		lblTheFileCouldNot.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTheFileCouldNot.setForeground(Color.RED);
		lblTheFileCouldNot.setBounds(203, 155, 242, 34);
		
	}
	/**
	 * @return the btnReturn
	 */
	public JButton getBtnReturnToReports() {
		return btnReturnToReports;
	}
	
	/**
	 * @return the lblTheFileHas
	 */
	public static JLabel getLblTheFileHas() {
		return lblTheFileHas;
	}
	
	/**
	 * @return the lblTheFileCouldNot
	 */
	public static JLabel getLblTheFileCouldNot() {
		return lblTheFileCouldNot;
	}

}
