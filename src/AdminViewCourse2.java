import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AdminViewCourse2 extends JFrame {

	public static JPanel contentPane;
	private JButton btnReturnToPrevious;
	private static TextArea textArea;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminViewCourse2 frame = new AdminViewCourse2();
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
	public AdminViewCourse2() {
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
		
		JLabel lblNewLabel = new JLabel("Here is the information for the course you selected:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(27, 73, 626, 29);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("________________________________________________________________________________");
		label.setForeground(Color.WHITE);
		label.setBounds(47, 114, 627, 16);
		contentPane.add(label);
		
		textArea = new TextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
     	textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		textArea.setBounds(100, 200, 800, 700);
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
