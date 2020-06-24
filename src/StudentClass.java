import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
public class StudentClass extends User implements Student {
	private int id;
	public ArrayList <Course> myCourses  = new ArrayList <Course> ();
	/*
	 * Constructs a student object.
	 * @param first  the student's first name
	 * @param last   the student's last name
	 * @param username   the student's username
	 * @param password   the student's password
	 * @param id  the student's id number
	 */
	StudentClass(String first, String last, String username, String password, int id){
		super(first, last, username, password);
		this.id  = id;
	}
	/*
	 * Constructs a student object.
	 * @param first the student's first name
	 * @param last the student's last name
	 */
	StudentClass(String first, String last){
		this.first=  first;
		this.last =  last;
	}
	/*
	 * (non-Javadoc)
	 * @see Student#printOpenCourses()
	 */
	@Override
	public void printOpenCourses() {
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getRegistered() < CourseMenu.get(i).getMax()) 
				System.out.println(CourseMenu.get(i).studentToString());
		}
	}
	
	public void printOpenCoursesGUI() {
		String print  =  "";
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getRegistered() < CourseMenu.get(i).getMax()) 
				print+= (CourseMenu.get(i).studentToString() + "\n———————————————————————————————————————————————————————————————————\n" );
		}
		if(print.equals("")) 
			StudentViewOpen.contentPane.add(StudentViewOpen.getLblNoFull());
		else {
		StudentViewOpen.getTextArea().setText(print);
		StudentViewOpen.scrollPane  = new JScrollPane (StudentViewOpen.getTextArea());
		StudentViewOpen.scrollPane.setBounds(0, 124, 659, 561);
		StudentViewOpen.contentPane.add(StudentViewOpen.scrollPane);
		StudentViewOpen.contentPane.setVisible(false);
		StudentViewOpen.contentPane.setVisible(true);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see Student#register(java.lang.String, int, java.lang.String, java.lang.String)
	 */
	@Override
	public void register(String courseName, int section, String first, String last) {
		StudentClass correctStudent= null;
		Course correctCourse;
		for(int i  = 0; i<AdminClass.allStudents.size(); i++) {
			if(AdminClass.allStudents.get(i).first.equalsIgnoreCase(first) && AdminClass.allStudents.get(i).last.equalsIgnoreCase(last)) {
				correctStudent = (StudentClass) AdminClass.allStudents.get(i);
			}
		}
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getCourseName().equalsIgnoreCase(courseName) && CourseMenu.get(i).getSection() == section) {
				correctCourse = CourseMenu.get(i);
				if(correctCourse.getMax()== correctCourse.getRegistered()) {
					System.out.println("Sorry, that course is full.");
					return;
				}
				for(int k = 0; k<correctStudent.myCourses.size(); k++) {
					if(correctCourse.equals(myCourses.get(k))) {
						System.out.println("You are already registered in this course.");
						return;
					}
				}
				myCourses.add(CourseMenu.get(i));
				CourseMenu.get(i).getRegisteredStudents().add((correctStudent));
				CourseMenu.get(i).increaseRegistered();
				System.out.println("You have been successfully registered in the course");
				return;
			}
		}
		System.out.println("That course was not found.");
	}
	
	public void registerGUI(int index) {
		JLabel lblEnrolled = new JLabel("You are enrolled in " + CourseMenu.get(index).getCourseName() + ".");
		lblEnrolled.setForeground(Color.WHITE);
		lblEnrolled.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblEnrolled.setBounds(68, 640, 500, 20);
		StudentRegister.contentPane.remove(StudentRegister.getLblFull());
		StudentRegister.contentPane.remove(StudentRegister.getLblDouble());
		StudentRegister.contentPane.remove(lblEnrolled);
		//StudentRegister.contentPane.setVisible(false);
		StudentRegister.contentPane.setVisible(true);
		if(myCourses.contains(CourseMenu.get(index))) {
			StudentRegister.contentPane.add(StudentRegister.getLblDouble());
			StudentRegister.contentPane.setVisible(false);
			StudentRegister.contentPane.setVisible(true);
			return;
		}
		if(CourseMenu.get(index).getMax() == CourseMenu.get(index).getRegistered()) {
			StudentRegister.contentPane.add(StudentRegister.getLblFull());
			StudentRegister.contentPane.setVisible(false);
			StudentRegister.contentPane.setVisible(true);
			return;
		}
		myCourses.add(CourseMenu.get(index));
		CourseMenu.get(index).getRegisteredStudents().add((this));
		CourseMenu.get(index).increaseRegistered();
		StudentRegister.contentPane.add(lblEnrolled);
		StudentRegister.contentPane.setVisible(false);
		StudentRegister.contentPane.setVisible(true);
		return;
	}
	/* 
	 * (non-Javadoc)
	 * @see Student#withdraw(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void withdraw(String first, String last, String courseName) {
		StudentClass student;
		Course correctCourse;
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getCourseName().equalsIgnoreCase(courseName)) {
				correctCourse = CourseMenu.get(i);
				
			for(int j= 0; j< correctCourse.getRegisteredStudents().size(); j++) {
					if(correctCourse.getRegisteredStudents().get(j).getFullName().equalsIgnoreCase(first + " " + last)){
						student = correctCourse.getRegisteredStudents().get(j);
						student.myCourses.remove(correctCourse);
						correctCourse.getRegisteredStudents().remove(student);
						correctCourse.decreaseRegistered();
						System.out.println("You have been successfully removed from the course.");
						return;
					}
				}
				System.out.println("You are not registered in that course.");
				return;
			}
		}
		System.out.println("That course was not found.");
		
	}
	
	public void withdrawGUI(int index) {
		Course correctCourse = myCourses.get(index);
		myCourses.remove(index);
		correctCourse.getRegisteredStudents().remove(this);
		correctCourse.decreaseRegistered();
	}
	/*
	 * (non-Javadoc)
	 * @see Student#printMyCourses()
	 */
	@Override
	public void printMyCourses() {
		for(int i =  0; i<myCourses.size(); i++) {
			System.out.println(myCourses.get(i).studentToString());
		}
	}
	
	public void printMyCoursesGUI() {
		String courses = "";
		for(int i =  0; i<myCourses.size(); i++) {
			courses+= (myCourses.get(i).studentToString() +  "\n———————————————————————————————————————————————————————————————————\n");
		}
		if(courses.equals("")) 
			StudentViewMyCourses.contentPane.add(StudentViewMyCourses.getLblNoCourses());
		else {
			StudentViewMyCourses.getTextArea().setText(courses);
			StudentViewMyCourses.scrollPane  = new JScrollPane (StudentViewMyCourses.getTextArea());
			StudentViewMyCourses.scrollPane.setBounds(0, 124, 659, 561);
			StudentViewMyCourses.contentPane.add(StudentViewMyCourses.scrollPane);
			StudentViewMyCourses.contentPane.setVisible(false);
			StudentViewMyCourses.contentPane.setVisible(true);
		}
	}
	@Override
	/* (non-Javadoc)
	 * @see User#printCourseMenu()
	 */
	public void printCourseMenu() {
		for(int i =  0; i<CourseMenu.size(); i++) {
			System.out.println(CourseMenu.get(i).studentToString());
		}
	}
	
	public void printCourseMenuGUI() {
		String print  =  " ";
		for(int i =  0; i<CourseMenu.size(); i++) {
			print+= (CourseMenu.get(i).studentToString() + "\n———————————————————————————————————————————————————————————————————\n" );
		}
		StudentViewAllCourses.getTextArea().setText(print);
		StudentViewAllCourses.scrollPane  = new JScrollPane (StudentViewAllCourses.getTextArea());
		StudentViewAllCourses.scrollPane.setBounds(0, 124, 659, 561);
		StudentViewAllCourses.contentPane.add(StudentViewAllCourses.scrollPane);
		StudentViewAllCourses.contentPane.setVisible(false);
		StudentViewAllCourses.contentPane.setVisible(true);
	}
	
	/*
	 * (non-Javadoc)
	 * @see Student#getFullName()
	 */
	@Override
	public String getFullName() {
		return first + " " + last;
	}
	/* 
	 * (non-Javadoc)
	 * @see Student#getID()
	 */
	public int getID() {
		return id;
	}
	@Override
	public String getUser() {
		// TODO Auto-generated method stub
		return username;
	}
}
