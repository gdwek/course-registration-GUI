import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class AdminAddCourse extends JFrame {

	public JPanel contentPane;
	private JTextField name;
	private JTextField ID;
	private JTextField max;
	private JTextField instructor;
	private JTextField section;
	private JTextField location;
	private JButton btnReturnToCM;
	private JButton btnCreate;
	private String nameString;
	private String IDString;
	private String instructorString;
	private String sectionString;
	private String locationString;
	private int maxInt;
	private int sectionInt;
	private JLabel lbMaxInputError;
	private JLabel lbSectionInputError;
	private JLabel lblThatSectionAlready;
	private JLabel lblTheCourseHas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddCourse frame = new AdminAddCourse();
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
	public AdminAddCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddACourse = new JLabel("Add a Course");
		lblAddACourse.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblAddACourse.setForeground(Color.WHITE);
		lblAddACourse.setBounds(213, 81, 343, 58);
		contentPane.add(lblAddACourse);
		
		name = new JTextField();
		name.setBounds(251, 178, 194, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		ID = new JTextField();
		ID.setBounds(251, 237, 194, 26);
		contentPane.add(ID);
		ID.setColumns(10);
		
		max = new JTextField();
		max.setBounds(251, 294, 194, 26);
		contentPane.add(max);
		max.setColumns(10);
		
		instructor = new JTextField();
		instructor.setBounds(251, 352, 194, 26);
		contentPane.add(instructor);
		instructor.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(87, 183, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(87, 242, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Max # of students");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(87, 299, 152, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Instructor");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(87, 357, 90, 16);
		contentPane.add(lblNewLabel_4);
		
		lbMaxInputError = new JLabel("Please enter a number.");
		lbMaxInputError.setForeground(Color.RED);
		lbMaxInputError.setBounds(276, 324, 180, 16);
		
		
		lbSectionInputError = new JLabel("Please enter a number.");
		lbSectionInputError.setForeground(Color.RED);
		lbSectionInputError.setBounds(272, 431, 152, 16);
		
		
		section = new JTextField();
		section.setColumns(10);
		section.setBounds(251, 406, 194, 26);
		contentPane.add(section);
		
		location = new JTextField();
		location.setColumns(10);
		location.setBounds(251, 459, 194, 26);
		contentPane.add(location);
		
		JLabel lblSection = new JLabel("Section #");
		lblSection.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblSection.setForeground(Color.WHITE);
		lblSection.setBounds(87, 411, 90, 16);
		contentPane.add(lblSection);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setBounds(87, 464, 101, 16);
		contentPane.add(lblLocation);
		
		btnReturnToCM = new JButton("Return to course management menu");
		btnReturnToCM.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturnToCM.setBounds(325, 21, 307, 29);
		contentPane.add(btnReturnToCM);
		
		btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnCreate.setBounds(290, 522, 117, 29);
		contentPane.add(btnCreate);
		
		lblTheCourseHas = new JLabel("");
		lblTheCourseHas.setForeground(Color.WHITE);
		lblTheCourseHas.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTheCourseHas.setBounds(177, 573, 328, 16);
		
		
		lblThatSectionAlready = new JLabel("That section already exists. Please try again.");
		lblThatSectionAlready.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblThatSectionAlready.setForeground(Color.RED);
		lblThatSectionAlready.setBounds(192, 564, 331, 26);
		
		 
	}

	/**
	 * @return the nameString
	 */
	public String getNameString() {
		return nameString;
	}

	/**
	 * @param nameString the nameString to set
	 */
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	/**
	 * @return the iDString
	 */
	public String getIDString() {
		return IDString;
	}

	/**
	 * @param iDString the iDString to set
	 */
	public void setIDString(String iDString) {
		IDString = iDString;
	}

	/**
	 * @return the instructorString
	 */
	public String getInstructorString() {
		return instructorString;
	}

	/**
	 * @param instructorString the instructorString to set
	 */
	public void setInstructorString(String instructorString) {
		this.instructorString = instructorString;
	}

	/**
	 * @return the sectionString
	 */
	public String getSectionString() {
		return sectionString;
	}

	/**
	 * @param sectionString the sectionString to set
	 */
	public void setSectionString(String sectionString) {
		this.sectionString = sectionString;
	}

	/**
	 * @return the locationString
	 */
	public String getLocationString() {
		return locationString;
	}

	/**
	 * @param locationString the locationString to set
	 */
	public void setLocationString(String locationString) {
		this.locationString = locationString;
	}
	
	
	/**
	 * @return the maxInt
	 */
	public int getMaxInt() {
		return maxInt;
	}

	/**
	 * @param maxInt the maxInt to set
	 */
	public void setMaxInt(int maxInt) {
		this.maxInt = maxInt;
	}

	/**
	 * @return the sectionInt
	 */
	public int getSectionInt() {
		return sectionInt;
	}

	/**
	 * @param sectionInt the sectionInt to set
	 */
	public void setSectionInt(int sectionInt) {
		this.sectionInt = sectionInt;
	}

	/**
	 * @return the name
	 */
	public JTextField getNameField() {
		return name;
	}

	/**
	 * @return the iD
	 */
	public JTextField getID() {
		return ID;
	}

	/**
	 * @return the max
	 */
	public JTextField getMax() {
		return max;
	}

	/**
	 * @return the instructor
	 */
	public JTextField getInstructor() {
		return instructor;
	}

	/**
	 * @return the section
	 */
	public JTextField getSection() {
		return section;
	}

	/**
	 * @return the location
	 */
	public JTextField getLoc() {
		return location;
	}

	/**
	 * @return the btnReturnToCM
	 */
	public JButton getBtnReturnToCM() {
		return btnReturnToCM;
	}

	/**
	 * @return the btnCreate
	 */
	public JButton getBtnCreate() {
		return btnCreate;
	}

	/**
	 * @return the lbMaxInputError
	 */
	public JLabel getLbMaxInputError() {
		return lbMaxInputError;
	}

	/**
	 * @return the lbInputError2
	 */
	public JLabel getLbSectionInputError() {
		return lbSectionInputError;
	}

	/**
	 * @return the lblThatSectionAlready
	 */
	public JLabel getLblThatSectionAlready() {
		return lblThatSectionAlready;
	}

	/**
	 * @return the lblTheCourseHas
	 */
	public JLabel getLblTheCourseHas() {
		return lblTheCourseHas;
	}
	
	
	
}
