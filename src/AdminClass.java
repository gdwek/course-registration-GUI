import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Serializable;
/*
 * Creates an admin object.
 * Extends the user class.
 * Contains an arraylist of all the students in the system, allStudents.
 */
public class AdminClass extends User implements Admin  {
	/*
	 * Constructs an admin object using the parent constructor
	 * @param username the admin's username
	 * @param password the admin's password
	 * @param first the admin's first name
	 * @param last the admin's last name
	 */
	AdminClass(String username, String password, String first, String last){
		super(username, password, first, last);
	}
	public static ArrayList <User> allStudents = new ArrayList <User> ();
	/*	
	 * (non-Javadoc)
	 * @see Admin#createNewCourse(java.lang.String, java.lang.String, int, int, java.util.ArrayList, java.lang.String, int, java.lang.String)
	 */
	@Override
	public void createNewCourse(String courseName, String id, int max, int registered, ArrayList<StudentClass> registeredStudents, String instructor, int section,
			String location) {
		Course newCourse = new Course(courseName, id, max, registered, registeredStudents, instructor, section, location);
		CourseMenu.add(newCourse);
		System.out.println("The course has been successfully added.");
	}
	/* 
	 * (non-Javadoc)
	 * @see Admin#deleteCourse(java.lang.String, int)
	 */
	@Override
	public void deleteCourse(String courseName, int section) {
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getCourseName().equalsIgnoreCase(courseName) && CourseMenu.get(i).getSection()== section) {
				CourseMenu.remove(i);
				System.out.println("The course has been successfully deleted.");
				return;
			}
		}
		System.out.println("The course has not been found");
	}

	/* 
	 * (non-Javadoc)
	 * @see Admin#deleteCourse(java.lang.String, java.lang.String)
	 * overloads the previous method
	 */
	@Override
	public void deleteCourse(String courseName, String id) {
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getCourseName().equalsIgnoreCase(courseName) && CourseMenu.get(i).getID().equalsIgnoreCase(id)) {
				CourseMenu.remove(i);
				System.out.println("The course has been successfully deleted.");
				return;
			}
		}
		System.out.println("The course has not been found");
	}
	
	
	public void deleteCourseGUI(int index) {
		Course correctCourse = CourseMenu.get(index);
		for(int i = 0; i<correctCourse.getRegisteredStudents().size(); i++) {
			correctCourse.getRegisteredStudents().get(i).myCourses.remove(correctCourse);
		}
		CourseMenu.remove(index);
	}
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see Admin#editCourse(java.lang.String, int)
	 */
	public void editCourse(String courseName, int section) {
		Scanner input = new Scanner(System.in);
		boolean run = true;
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getCourseName().equalsIgnoreCase(courseName) && (CourseMenu.get(i).getSection() == section)) {
				while(run) {
					try{ System.out.println("What would you like to change? Enter 1 for maximum students, 2 for instructor, 3 for section, 4 for location, and 5 to return to the Course Management Menu.");
						int answer = input.nextInt();
						input.nextLine();
						if(answer == 1){
							System.out.println("Please enter the new number for the maximum amount of students allowed in this course below.");
							CourseMenu.get(i).setMax(input.nextInt());
							System.out.println("Updated course information: ");
							printCourseInfo(CourseMenu.get(i).getID());
						}
						else if(answer == 2) {
							System.out.println("Please enter the new instructor's name below.");
							CourseMenu.get(i).setInstructor(input.next());
							System.out.println("Updated course information: ");
							printCourseInfo(CourseMenu.get(i).getID());
						}
						else if(answer == 3) {
							System.out.println("Please enter the new section number below.");
							CourseMenu.get(i).setSection(input.nextInt());
							System.out.println("Updated course information: ");
							printCourseInfo(CourseMenu.get(i).getID());
						}
						else if(answer == 4) {
							System.out.println("Please enter the new location below.");
							CourseMenu.get(i).setLocation(input.next());
							System.out.println("Updated course information: ");
							printCourseInfo(CourseMenu.get(i).getID());
						}
						else if(answer == 5) {
							return;
						}
						else {
							throw new InputMismatchException();
						}
						}
					catch(Exception e) {
						System.out.println("Invalid input. Please try again.");
					}
				}
			}
		}
		System.out.println("That course was not found.");
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Admin#printCourseInfo(java.lang.String)
	 */
	public void printCourseInfo(String id) {
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getID().equalsIgnoreCase(id)) {
				System.out.println(CourseMenu.get(i).adminToString());
				return;
			}
		}
		System.out.println("The course has not been found.");
	}
	
	public void printCourseInfoGUI(int index) {
		AdminViewCourse2.getTextArea().setText(CourseMenu.get(index).adminToString());
		AdminViewCourse2.contentPane.add(AdminViewCourse2.getTextArea());
		AdminViewCourse2.contentPane.setVisible(false);
		AdminViewCourse2.contentPane.setVisible(true);
	}
	

	@Override
	/*
	 * (non-Javadoc)
	 * @see Admin#addStudent(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 */
	public void addStudent(String first, String last, String username, String password, int id) {
		StudentClass newStudent =  new StudentClass (first, last, username, password, id);
		allStudents.add(newStudent);
		System.out.println("The student has been added.");
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Admin#printFullCourses()
	 */
	public void printFullCourses() {
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getRegistered() == CourseMenu.get(i).getMax()) 
				System.out.println(CourseMenu.get(i).adminToString());
			
		}
	}
	
	public void printFullCoursesGUI() {
		String print = "";
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getRegistered() == CourseMenu.get(i).getMax()) 
				print+= ((CourseMenu.get(i).adminToString()) + "\n———————————————————————————————————————————————————————————————————\n" );
		}
		if(print.equals("")) 
			AdminViewFullCourses.contentPane.add(AdminViewFullCourses.getLblNoFull());
		else {
		AdminViewFullCourses.getTextArea().setText(print);
		AdminViewFullCourses.scrollPane  = new JScrollPane (AdminViewFullCourses.getTextArea());
		AdminViewFullCourses.scrollPane.setBounds(0, 124, 659, 561);
		AdminViewFullCourses.contentPane.add(AdminViewFullCourses.scrollPane);
		AdminViewFullCourses.contentPane.setVisible(false);
		AdminViewFullCourses.contentPane.setVisible(true);
		}
	}


	/*
	 * (non-Javadoc)
	 * @see Admin#writeFullCoursestoFile()
	 */
	public void writeFullCoursestoFile() {
		try {
			BufferedWriter file = new BufferedWriter(new FileWriter("FullCourses.txt"));
			for(int i =  0; i<CourseMenu.size(); i++) {
				if(CourseMenu.get(i).getRegistered() == CourseMenu.get(i).getMax()) 
					file.write(CourseMenu.get(i).adminToString());
			}
			System.out.println("The file was successfully written.");
			file.close();
		}
		catch(Exception e) {
			System.out.println("The file could not be written.");
		}
	}
	public void writeFullCoursestoFileGUI() {
		try {
			BufferedWriter file = new BufferedWriter(new FileWriter("FullCourses.txt"));
			for(int i =  0; i<CourseMenu.size(); i++) {
				if(CourseMenu.get(i).getRegistered() == CourseMenu.get(i).getMax()) 
					file.write(CourseMenu.get(i).adminToString());
			}
			AdminWriteFullCourses.contentPane.add(AdminWriteFullCourses.getLblTheFileHas());
			file.close();
		}
		catch(Exception e) {
			AdminWriteFullCourses.contentPane.add(AdminWriteFullCourses.getLblTheFileCouldNot());
		}
	}
	@Override
	/*
	 * (non-Javadoc)
	 * @see Admin#studentsInCourse(java.lang.String, java.lang.String)
	 */
	public void studentsInCourse(String courseName, String id) {
		for(int i =  0; i<CourseMenu.size(); i++) {
			if(CourseMenu.get(i).getCourseName().equalsIgnoreCase(courseName) && CourseMenu.get(i).getID().equalsIgnoreCase(id)) {
				System.out.println(CourseMenu.get(i).printRegisteredStudents());
				return;
				}
			}
		System.out.println("That course was not found.");
		}
	
	public void studentsInCourseGUI(int index){
		AdminStudentsInCourse2.getTextArea().setText(CourseMenu.get(index).printRegisteredStudentsGUI());
		AdminStudentsInCourse2.scrollPane  = new JScrollPane (AdminStudentsInCourse2.getTextArea());
		AdminStudentsInCourse2.scrollPane.setBounds(0, 124, 659, 561);
		AdminStudentsInCourse2.contentPane.add(AdminStudentsInCourse2.scrollPane);
		AdminStudentsInCourse2.contentPane.setVisible(false);
		AdminStudentsInCourse2.contentPane.setVisible(true);
	}
	
	@Override
	
	/*
	 * (non-Javadoc)
	 * @see User#printCourseMenu()
	 */
	public void printCourseMenu() {
		for(int i =  0; i<CourseMenu.size(); i++) {
			System.out.println(CourseMenu.get(i).adminToString());
		}
	}
	public String printCourseMenuGUI() {
		String print  =  " ";
		for(int i =  0; i<CourseMenu.size(); i++) {
			print+= (CourseMenu.get(i).adminToString() + "\n———————————————————————————————————————————————————————————————————\n" );
			
		}
		return print;
	}
	public void viewAllCoursesGUI() {
		AdminViewAllCourses.getTextArea().setText(printCourseMenuGUI());
		AdminViewAllCourses.scrollPane  = new JScrollPane (AdminViewAllCourses.getTextArea());
		AdminViewAllCourses.scrollPane.setBounds(0, 124, 659, 561);
		AdminViewAllCourses.contentPane.add(AdminViewAllCourses.scrollPane);
		AdminViewAllCourses.contentPane.setVisible(false);
		AdminViewAllCourses.contentPane.setVisible(true);
	}
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see Admin#studentsCourses(java.lang.String, java.lang.String)
	 */
	public void studentsCourses(String first, String last){
		StudentClass correctStudent = null;
		for(int i =  0; i<allStudents.size(); i++) {
			if(allStudents.get(i).first.equalsIgnoreCase(first) && allStudents.get(i).last.equalsIgnoreCase(last)) {
				correctStudent = (StudentClass) allStudents.get(i);
				for(int j =  0; j<correctStudent.myCourses.size(); j++) {
					System.out.println(correctStudent.myCourses.get(i).adminToString());
				}
			return;
		}
		}
		System.out.println("That student was not found.");
	}
	public void studentsCoursesGUI(int index){
		String courses = "";
		for(int i =  0; i<  ((StudentClass) allStudents.get(index)).myCourses.size(); i++) {
			courses+=(((StudentClass) allStudents.get(index)).myCourses.get(i).adminToString() + "\n———————————————————————————————————————————————————————————————————\n");
		}
		AdminStudentCourse2.getTextArea().setText(courses);
		AdminStudentCourse2.scrollPane  = new JScrollPane (AdminStudentCourse2.getTextArea());
		AdminStudentCourse2.scrollPane.setBounds(0, 124, 659, 561);
		AdminStudentCourse2.contentPane.add(AdminStudentCourse2.scrollPane);
		AdminStudentCourse2.contentPane.setVisible(false);
		AdminStudentCourse2.contentPane.setVisible(true);
	}
	@Override
	/*
	 * (non-Javadoc)
	 * @see Admin#sortCourses()
	 */
	public void sortCourses() {
		Course temp;
		for(int i =  0; i<CourseMenu.size(); i++) {
			for(int j= i +1; j<CourseMenu.size(); j++) {
				if(CourseMenu.get(i).getRegistered()<CourseMenu.get(j).getRegistered()) {
					temp = CourseMenu.get(i);
					CourseMenu.set(i, CourseMenu.get(j));
					CourseMenu.set(j, temp);
				}
			}
		}
		System.out.println("Here is the sorted course list.");
		printCourseMenu();
	}
	
	public void sortCoursesGUI() {
		Course temp;
		for(int i =  0; i<CourseMenu.size(); i++) {
			for(int j= i +1; j<CourseMenu.size(); j++) {
				if(CourseMenu.get(i).getRegistered()<CourseMenu.get(j).getRegistered()) {
					temp = CourseMenu.get(i);
					CourseMenu.set(i, CourseMenu.get(j));
					CourseMenu.set(j, temp);
				}
			}
		}
		AdminSortCourses.getTextArea().setText(printCourseMenuGUI());
		AdminSortCourses.scrollPane  = new JScrollPane (AdminSortCourses.getTextArea());
		AdminSortCourses.scrollPane.setBounds(0, 160, 659, 561);
		AdminSortCourses.contentPane.add(AdminSortCourses.scrollPane);
		AdminSortCourses.contentPane.setVisible(false);
		AdminSortCourses.contentPane.setVisible(true);
	}
	
	
}
