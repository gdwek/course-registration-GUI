import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class AdminStudentCourse2 extends JFrame {

	public static JPanel contentPane;
	private JButton btnReturnToPrevious;
	private static TextArea textArea;
	static JScrollPane scrollPane;
	private JLabel label;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStudentCourse2 frame = new AdminStudentCourse2();
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
	public AdminStudentCourse2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnReturnToPrevious = new JButton("Return to previous page");
		btnReturnToPrevious.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturnToPrevious.setBounds(423, 32, 209, 29);
		contentPane.add(btnReturnToPrevious);
		
		JLabel lblHeading = new JLabel("Here is the course list for the student you selected:");
		lblHeading.setForeground(Color.WHITE);
		lblHeading.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblHeading.setBounds(27, 73, 626, 29);
		contentPane.add(lblHeading);
		
		label = new JLabel("________________________________________________________________________________");
		label.setForeground(Color.WHITE);
		label.setBounds(47, 114, 627, 16);
		contentPane.add(label);
		
		textArea = new TextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
     	textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
     	textArea.setBounds(0, 124, 659, 561);
		textArea.setEditable(false);
	}

	/**
	 * @return the btnReturnToPrevious
	 */
	public JButton getBtnReturnToPrevious() {
		return btnReturnToPrevious;
	}
	
	/**
	 * @return the textArea
	 */
	public static TextArea getTextArea() {
		return textArea;
	
	}

}
