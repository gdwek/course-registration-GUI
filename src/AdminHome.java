import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminHome extends JFrame {

	private JPanel contentPane;
	public JButton btnLogout;
	public JButton btnCM;
	public JButton btnReports;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome Admin!");
		lblWelcomeAdmin.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblWelcomeAdmin.setForeground(Color.WHITE);
		lblWelcomeAdmin.setBounds(130, 87, 445, 79);
		contentPane.add(lblWelcomeAdmin);
		
		btnCM = new JButton("Course Management");
		btnCM.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnCM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCM.setBounds(50, 323, 269, 98);
		contentPane.add(btnCM);
		
		btnReports = new JButton("Reports");
		btnReports.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnReports.setBounds(341, 323, 260, 98);
		contentPane.add(btnReports);
		
		JLabel lblPleaseSelectA = new JLabel("Please select a menu below.");
		lblPleaseSelectA.setForeground(Color.WHITE);
		lblPleaseSelectA.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblPleaseSelectA.setBounds(152, 194, 394, 45);
		contentPane.add(lblPleaseSelectA);
		
		btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnLogout.setBounds(512, 25, 117, 29);
		contentPane.add(btnLogout);
	}
}
