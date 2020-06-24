import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	public JPanel contentPane;
	public JPasswordField passwordField;
	public JTextField textField;
	public String adminUsername;
	public String adminPassword;
	public JButton btnEnter;
	public JLabel lbLoginError;
	private JButton btnReturn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(237, 391, 206, 36);
		contentPane.add(passwordField);
		
		JLabel lblEnterYourUsername = new JLabel("Enter your username and password below.");
		lblEnterYourUsername.setForeground(new Color(255, 255, 255));
		lblEnterYourUsername.setBackground(new Color(245, 245, 245));
		lblEnterYourUsername.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblEnterYourUsername.setBounds(121, 194, 592, 62);
		contentPane.add(lblEnterYourUsername);
		
		JLabel lblAdminLoginPortal = new JLabel("ADMIN LOGIN PORTAL");
		lblAdminLoginPortal.setForeground(new Color(255, 255, 255));
		lblAdminLoginPortal.setBackground(new Color(173, 216, 230));
		lblAdminLoginPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLoginPortal.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lblAdminLoginPortal.setBounds(81, 96, 491, 50);
		contentPane.add(lblAdminLoginPortal);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblUsername.setBounds(133, 317, 92, 16);
		contentPane.add(lblUsername);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblPassword.setBounds(133, 400, 81, 16);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(237, 308, 206, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		btnEnter = new JButton("ENTER");
		
		btnEnter.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnEnter.setBounds(272, 505, 117, 29);
		contentPane.add(btnEnter);
		
		btnReturn = new JButton("Return to main menu");
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnReturn.setBounds(416, 37, 195, 29);
		contentPane.add(btnReturn);
	}

	/**
	 * @return the btnReturn
	 */
	public JButton getBtnReturn() {
		return btnReturn;
	}
	
}
