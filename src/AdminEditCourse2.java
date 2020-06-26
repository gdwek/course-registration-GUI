import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class AdminEditCourse2 extends JFrame {

	public JPanel contentPane;
	private JButton btnReturnToPrevious;
	private JTextField max;
	private JTextField instructor;
	private JTextField section;
	private JTextField location;
	private int maxInt;
	private String instructorString;
	private int sectionInt;
	private String locationString;
	private JLabel lblMaxError;
	private JLabel lblSecError;
	private JLabel lblTheChangesHave;
	private JLabel lblThatSectionAlready;
	private JButton btnEditMax;
	private JButton btnEditIns;
	private JButton btnEditSec;
	private JButton btnEditLoc;
	

	
	/**
	 * Create the frame.
	 */
	public AdminEditCourse2(int index) {
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
		
		JLabel label = new JLabel("Edit A Course");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		label.setBounds(184, 73, 319, 79);
		contentPane.add(label);
		
		JLabel lblEnterAnyChanges = new JLabel("Enter any changes into the textfields below.");
		lblEnterAnyChanges.setForeground(Color.WHITE);
		lblEnterAnyChanges.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblEnterAnyChanges.setBounds(136, 177, 397, 22);
		contentPane.add(lblEnterAnyChanges);
		
		JLabel lblNewLabel_3 = new JLabel("Max # of students");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(87, 263, 152, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Instructor");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(87, 329, 90, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblSection = new JLabel("Section #");
		lblSection.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblSection.setForeground(Color.WHITE);
		lblSection.setBounds(87, 396, 90, 16);
		contentPane.add(lblSection);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setBounds(87, 464, 101, 16);
		contentPane.add(lblLocation);
		
		max = new JTextField(Integer.toString(User.CourseMenu.get(index).getMax()));
		max.setBounds(251, 259, 194, 26);
		contentPane.add(max);
		max.setColumns(10);
		
		instructor = new JTextField(User.CourseMenu.get(index).getInstructor());
		instructor.setBounds(251, 325, 194, 26);
		contentPane.add(instructor);
		instructor.setColumns(10);
		
		section = new JTextField(Integer.toString(User.CourseMenu.get(index).getSection()));
		section.setColumns(10);
		section.setBounds(251, 392, 194, 26);
		contentPane.add(section);
		
		location = new JTextField(User.CourseMenu.get(index).getLocation());
		location.setColumns(10);
		location.setBounds(251, 459, 194, 26);
		contentPane.add(location);
		
		btnEditMax = new JButton("Edit");
		btnEditMax.setBounds(472, 259, 61, 29);
		contentPane.add(btnEditMax);
		
		btnEditIns = new JButton("Edit");
		btnEditIns.setBounds(472, 325, 61, 29);
		contentPane.add(btnEditIns);
		
		btnEditSec = new JButton("Edit");
		btnEditSec.setBounds(472, 392, 61, 29);
		contentPane.add(btnEditSec);
		
		btnEditLoc = new JButton("Edit");
		btnEditLoc.setBounds(472, 460, 61, 29);
		contentPane.add(btnEditLoc);
		
		lblThatSectionAlready = new JLabel("That section already exists.");
		lblThatSectionAlready.setForeground(Color.RED);
		lblThatSectionAlready.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblThatSectionAlready.setBounds(251, 430, 194, 16);
		
		
		lblTheChangesHave = new JLabel("The changes have been saved.");
		lblTheChangesHave.setForeground(Color.WHITE);
		lblTheChangesHave.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblTheChangesHave.setBounds(237, 584, 216, 40);
	
		
		lblMaxError = new JLabel("Please enter a number.");
		lblMaxError.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblMaxError.setForeground(Color.RED);
		lblMaxError.setBounds(263, 297, 163, 16);
		
		lblSecError = new JLabel("Please enter a number.");
		lblSecError.setForeground(Color.RED);
		lblSecError.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblSecError.setBounds(261, 431, 163, 16);
		
	}

	/**
	 * @return the btnReturnToPrevious
	 */
	public JButton getBtnReturnToPrevious() {
		return btnReturnToPrevious;
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
	 * @return the lblMaxError
	 */
	public JLabel getLblMaxError() {
		return lblMaxError;
	}

	/**
	 * @return the lblSecError
	 */
	public JLabel getLblSecError() {
		return lblSecError;
	}

	/**
	 * @return the lblTheChangesHave
	 */
	public JLabel getLblTheChangesHave() {
		return lblTheChangesHave;
	}
	
	/**
	 * @return the lblThatSectionAlready 
	 */
	public JLabel getLblThatSectionAlready() {
		return lblThatSectionAlready;
	}

	/**
	 * @return the btnEditMax
	 */
	public JButton getBtnEditMax() {
		return btnEditMax;
	}

	/**
	 * @return the btnEditIns
	 */
	public JButton getBtnEditIns() {
		return btnEditIns;
	}

	/**
	 * @return the btnEditSec
	 */
	public JButton getBtnEditSec() {
		return btnEditSec;
	}

	/**
	 * @return the btnEditLoc
	 */
	public JButton getBtnEditLoc() {
		return btnEditLoc;
	}
	
	
}
