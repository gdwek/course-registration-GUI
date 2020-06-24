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

public class AdminSortCourses extends JFrame {

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
					AdminSortCourses frame = new AdminSortCourses();
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
	public AdminSortCourses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSortCourses = new JLabel("Sorted Course List");
		lblSortCourses.setBounds(113, 73, 445, 54);
		lblSortCourses.setForeground(Color.WHITE);
		lblSortCourses.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		contentPane.add(lblSortCourses);
		
	    btnReturnToReports = new JButton("Return to reports menu");
		btnReturnToReports.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturnToReports.setBounds(400, 32, 200, 29);
		contentPane.add(btnReturnToReports);
		
		JLabel lblNewLabel = new JLabel("Courses have been sorted based on amount of registered students.");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(32, 129, 586, 22);
		contentPane.add(lblNewLabel);
		
		textArea = new TextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
     	textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textArea.setBounds(0, 124, 659, 561);
		textArea.setEditable(false);
	}

	/**
	 * @return the btnReturnToReports
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
