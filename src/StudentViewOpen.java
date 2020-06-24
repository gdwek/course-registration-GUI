import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class StudentViewOpen extends JFrame {

	public static JPanel contentPane;
	private JButton btnReturn;
	private static JLabel lblNoOpen;
	private static TextArea textArea;
	static JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentViewOpen frame = new StudentViewOpen();
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
	public StudentViewOpen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFullCourseMenu = new JLabel("Open Courses");
		lblFullCourseMenu.setForeground(Color.WHITE);
		lblFullCourseMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblFullCourseMenu.setBounds(167, 51, 311, 67);
		contentPane.add(lblFullCourseMenu);
		
		btnReturn = new JButton("Return to main menu");
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturn.setBounds(431, 27, 194, 29);
		contentPane.add(btnReturn);
		
		lblNoOpen = new JLabel("There are no open courses to be displayed at this time.");
		lblNoOpen.setForeground(Color.RED);
		lblNoOpen.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNoOpen.setBounds(70, 307, 511, 34);
		
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
	public JButton getBtnReturn() {
		return btnReturn;
	}
	
	
	/**
	 * @return the lblNoFull
	 */
	public static JLabel getLblNoFull() {
		return lblNoOpen;
	}
	
	/**
	 * @return the textArea
	 */
	public static TextArea getTextArea() {
		return textArea;
	}
	
}
