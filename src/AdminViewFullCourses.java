import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;

public class AdminViewFullCourses extends JFrame {

	public static JPanel contentPane;
	private JButton btnReturnToReports;
	private static JLabel lblNoFull;
	private static TextArea textArea;
	static JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminViewFullCourses frame = new AdminViewFullCourses();
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
	public AdminViewFullCourses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFullCourseMenu = new JLabel("Full Course Menu");
		lblFullCourseMenu.setForeground(Color.WHITE);
		lblFullCourseMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblFullCourseMenu.setBounds(134, 54, 386, 67);
		contentPane.add(lblFullCourseMenu);
		
		btnReturnToReports = new JButton("Return to reports menu");
		btnReturnToReports.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturnToReports.setBounds(430, 28, 194, 29);
		contentPane.add(btnReturnToReports);
		
		lblNoFull = new JLabel("There are no full courses to be displayed at this time.");
		lblNoFull.setForeground(Color.RED);
		lblNoFull.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNoFull.setBounds(70, 307, 511, 34);
		
		textArea = new TextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
     	textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textArea.setBounds(0, 124, 659, 561);
		textArea.setEditable(false);
		
	
	}
	
	/**
	 * @return the btnReturn
	 */
	public JButton getBtnReturnToReports() {
		return btnReturnToReports;
	}
	
	/**
	 * @return the lblNoFull
	 */
	public static JLabel getLblNoFull() {
		return lblNoFull;
	}
	
	/**
	 * @return the textArea
	 */
	public static TextArea getTextArea() {
		return textArea;
	}
	
	
}