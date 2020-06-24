import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AdminRegisterStudent extends JFrame {

	public JPanel contentPane;
	private JButton btnReturn;
	private JButton btnRegister;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JTextField txtID;
	private String firstString;
	private String lastString;
	private String userString;
	private String passString;
	private int ID;
	private JLabel lblUsernameAlreadyExists;
	private JLabel lblIdAlreadyExists;
	private JLabel lblTheStudentHas;
	private JLabel lblPleaseEnterA;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegisterStudent frame = new AdminRegisterStudent();
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
	public AdminRegisterStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterAStudent = new JLabel("Register a Student");
		lblRegisterAStudent.setForeground(Color.WHITE);
		lblRegisterAStudent.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblRegisterAStudent.setBounds(126, 76, 412, 79);
		contentPane.add(lblRegisterAStudent);
		
		btnReturn = new JButton("Return to course management menu");
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturn.setBounds(327, 35, 307, 29);
		contentPane.add(btnReturn);
		
		txtFirst = new JTextField();
		txtFirst.setBounds(251, 202, 171, 26);
		contentPane.add(txtFirst);
		txtFirst.setColumns(10);
		
		txtLast = new JTextField();
		txtLast.setColumns(10);
		txtLast.setBounds(251, 270, 171, 26);
		contentPane.add(txtLast);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(251, 340, 171, 26);
		contentPane.add(txtUser);
		
		txtPass = new JPasswordField();
		txtPass.setColumns(10);
		txtPass.setBounds(251, 416, 171, 26);
		contentPane.add(txtPass);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(251, 493, 171, 26);
		contentPane.add(txtID);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblFirstName.setBounds(153, 204, 86, 20);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblLastName.setBounds(153, 272, 86, 20);
		contentPane.add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblUsername.setBounds(153, 345, 86, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPassword.setBounds(153, 418, 86, 20);
		contentPane.add(lblPassword);
		
		JLabel lblId = new JLabel("ID number");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblId.setBounds(153, 493, 86, 20);
		contentPane.add(lblId);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnRegister.setBounds(275, 559, 117, 29);
		contentPane.add(btnRegister);
		
		lblUsernameAlreadyExists = new JLabel("Username already exists. Please try again.");
		lblUsernameAlreadyExists.setForeground(Color.RED);
		lblUsernameAlreadyExists.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblUsernameAlreadyExists.setBounds(181, 388, 320, 16);
		
		lblIdAlreadyExists = new JLabel("ID already exists. Please try again.");
		lblIdAlreadyExists.setForeground(Color.RED);
		lblIdAlreadyExists.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblIdAlreadyExists.setBounds(215, 531, 261, 16);
		
		lblTheStudentHas = new JLabel("");
		lblTheStudentHas.setForeground(Color.WHITE);
		lblTheStudentHas.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTheStudentHas.setBounds(163, 609, 490, 40);
		
		
		lblPleaseEnterA = new JLabel("Please enter a number.");
		lblPleaseEnterA.setForeground(Color.RED);
		lblPleaseEnterA.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPleaseEnterA.setBounds(255, 531, 261, 16);
	}

	/**
	 * @return the btnReturn
	 */
	public JButton getBtnReturn() {
		return btnReturn;
	}

	/**
	 * @return the txtFirst
	 */
	public JTextField getTxtFirst() {
		return txtFirst;
	}

	/**
	 * @return the txtLast
	 */
	public JTextField getTxtLast() {
		return txtLast;
	}

	/**
	 * @return the txtUser
	 */
	public JTextField getTxtUser() {
		return txtUser;
	}

	/**
	 * @return the txtPass
	 */
	public JPasswordField getTxtPass() {
		return txtPass;
	}

	/**
	 * @return the txtID
	 */
	public JTextField getTxtID() {
		return txtID;
	}

	/**
	 * @return the btnRegister
	 */
	public JButton getBtnRegister() {
		return btnRegister;
	}

	/**
	 * @return the contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * @return the firstString
	 */
	public String getFirstString() {
		return firstString;
	}
	
	/**
	 * @param firstString the firstString to set
	 */
	public void setFirstString(String firstString) {
		this.firstString = firstString;
	}

	/**
	 * @return the lastString
	 */
	public String getLastString() {
		return lastString;
	}
	
	/**
	 * @param lastString the lastString to set
	 */
	public void setLastString(String lastString) {
		this.lastString = lastString;
	}
	
	/**
	 * @return the userString
	 */
	public String getUserString() {
		return userString;
	}
	
	/**
	 * @param userString the userString to set
	 */
	public void setUserString(String userString) {
		this.userString = userString;
	}
	/**
	 * @return the passString
	 */
	public String getPassString() {
		return passString;
	}
	
	/**
	 * @param passString the passString to set
	 */
	public void setPassString(String passString) {
		this.passString = passString;
	}

	/**
	 * @return the iDString
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}	
	
	
	/**
	 * @return the lblUsernameAlreadyExists
	 */
	public JLabel getLblUsernameAlreadyExists() {
		return lblUsernameAlreadyExists;
	}

	/**
	 * @return the lblIdAlreadyExists
	 */
	public JLabel getLblIdAlreadyExists() {
		return lblIdAlreadyExists;
	}

	/**
	 * @return the lblTheCourseHas
	 */
	public JLabel getLblTheStudentHas() {
		return lblTheStudentHas;
	}

	/**
	 * @return the lblPleaseEnterA
	 */
	public JLabel getLblPleaseEnterA() {
		return lblPleaseEnterA;
	}
}
