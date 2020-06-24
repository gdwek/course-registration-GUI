import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.List;
import java.awt.TextArea;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class AdminViewAllCourses extends JFrame {

	public static JPanel contentPane;
	private JButton btnReturnToReports;
	private static TextArea textArea;
	static JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminViewAllCourses frame = new AdminViewAllCourses();
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
	public AdminViewAllCourses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setForeground(Color.WHITE);
		lblCourses.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblCourses.setBounds(244, 60, 163, 58);
		contentPane.add(lblCourses);
		
		btnReturnToReports = new JButton("Return to reports menu");
		btnReturnToReports.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturnToReports.setBounds(431, 27, 194, 29);
		contentPane.add(btnReturnToReports);
		
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
	 * @return the textArea
	 */
	public static TextArea getTextArea() {
		return textArea;
	}
}

