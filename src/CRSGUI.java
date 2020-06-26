import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.*;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class CRSGUI {


	public static JFrame frame;
	public static User admin = new AdminClass ("Gabrielle", "Dwek", "Admin", "Admin001");
	public static String filename  = ("SerializeOut2");

	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRSGUI window = new CRSGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			FileInputStream file = new FileInputStream(filename);	
			ObjectInputStream deserialize = new ObjectInputStream(file);
			User.CourseMenu = (ArrayList <Course> ) deserialize.readObject();
			AdminClass.allStudents = (ArrayList <User> ) deserialize.readObject();
			System.out.println("Successfully deserialized.");
		}
		catch (IOException | ClassNotFoundException e){
		System.out.println("Could Not Deserialize, reading from csv");
		File file = new File ("MyUniversityCourses.csv");
		Scanner scan = new Scanner (file);
		String [] list;
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			list = line.split(",");
			User.CourseMenu.add(new Course(list[0], list[1], Integer.parseInt(list[2]), Integer.parseInt(list[3]),  new ArrayList <StudentClass> () , list[5], Integer.parseInt(list[6]), list[7]));
		}
		}
		Scanner scan2 = new Scanner(System.in);
		boolean run =  true; 
	}

	/**
	 * Create the application.
	 */
	public CRSGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		frame.setBounds(500, 100, 659,707);
		
		JButton btnStudent = new JButton("STUDENT");
		btnStudent.setBackground(new Color(152, 251, 152));
		btnStudent.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnStudent.setBounds(170, 417, 309, 87);
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StudentLogin studentLogin = new StudentLogin();
				studentLogin.setVisible(true);
				studentLogin.getBtnReturn().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						studentLogin.dispose();
						frame.setVisible(true);
					}
				});
				studentLogin.getBtnEnter().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						studentLogin.setUsername(studentLogin.getTextField().getText());
						studentLogin.setPassword(studentLogin.getPasswordField().getText());
						StudentHome home = new StudentHome();
						for(User student: AdminClass.allStudents) {
							if(student.getUsername().equalsIgnoreCase(studentLogin.getUsername()) && student.getPassword().equals(studentLogin.getPassword())) {
								StudentClass correctStudent = (StudentClass) student;
								studentLogin.dispose();
								home.setVisible(true);
								home.getBtnLogout().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										home.dispose();
										serialize();
										System.exit(0);
									}
								});
								JLabel lblWelcomeStudent = new JLabel("Welcome " + correctStudent.getName() + "!");
								lblWelcomeStudent.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
								lblWelcomeStudent.setForeground(Color.WHITE);
								lblWelcomeStudent.setBounds(130, 87, 445, 79);
								home.contentPane.add(lblWelcomeStudent);
								home.getBtnViewAll().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										StudentViewAllCourses viewAll = new StudentViewAllCourses();
										home.dispose();
										viewAll.setVisible(true);
										correctStudent.printCourseMenuGUI();
										viewAll.getBtnReturn().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												viewAll.dispose();
												home.setVisible(true);
											}
										});
									}
								});
								home.getBtnViewOpenCourses().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										StudentViewOpen open = new StudentViewOpen();
										home.dispose();
										open.setVisible(true);
										correctStudent.printOpenCoursesGUI();
										open.getBtnReturn().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												open.dispose();
												home.setVisible(true);
											}
										});
									}
								});
								home.getBtnViewMyCourses().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										StudentViewMyCourses myCourses = new StudentViewMyCourses();
										home.dispose();
										myCourses.setVisible(true);
										correctStudent.printMyCoursesGUI();
										myCourses.getBtnReturn().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												myCourses.dispose();
												home.setVisible(true);
											}
										});
									}
								});
								home.getBtnRegisterInA().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										StudentRegister register = new StudentRegister();
										home.dispose();
										register.setVisible(true);
										register.getBtnReturn().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												register.dispose();
												home.setVisible(true);
											}
										});
										register.getBtnRegister().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												int index = register.getJlist().getSelectedIndex();
												correctStudent.registerGUI(index);
												serialize();
											}
										});
									}
								});
								home.getBtnWithdrawFromA().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										StudentWithdraw withdraw = new StudentWithdraw(correctStudent);
										home.dispose();
										withdraw.setVisible(true);
										withdraw.getBtnReturn().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												withdraw.dispose();
												home.setVisible(true);
											}
										});
										withdraw.getBtnWithdraw().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												int index = withdraw.getJlist().getSelectedIndex();
												correctStudent.withdrawGUI(index);
												withdraw.list.removeElementAt(index);
												serialize();
												withdraw.setVisible(false);
												withdraw.setVisible(true);
											}
										});
									}
								});
								return;
							}
						}
						studentLogin.setLbLoginError(new JLabel("Invalid username or password. Please try again.")); 
						studentLogin.getLbLoginError().setForeground(new Color(255, 0, 0));
						studentLogin.getLbLoginError().setFont(new Font("Lucida Grande", Font.BOLD, 14));
						studentLogin.getLbLoginError().setBounds(157, 458, 415, 16);
						studentLogin.contentPane.add(studentLogin.getLbLoginError());
						studentLogin.setVisible(false);
						studentLogin.setVisible(true);	
					}
				});
			} 
		});
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.setBackground(new Color(245, 245, 220));
		btnAdmin.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnAdmin.setBounds(170, 308, 309, 87);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminLogin login = new AdminLogin();
				login.setVisible(true);
				login.getBtnReturn().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						login.dispose();
						frame.setVisible(true);
					}
				});
				login.btnEnter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						login.adminUsername = login.textField.getText();
						login.adminPassword = login.passwordField.getText();
						AdminHome home = new AdminHome();
						if(login.adminUsername.equalsIgnoreCase("Admin") && login.adminPassword.equals("Admin001")) {
							login.dispose();
							home.setVisible(true);
							home.btnLogout.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									home.dispose();
									serialize();
									System.exit(0);
								}
							});
							home.btnCM.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									AdminCM cm = new AdminCM();
									home.dispose();
									cm.setVisible(true);
									cm.btnReturn.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											cm.dispose();
											home.setVisible(true);
										}
									});
									cm.btnAdd.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											cm.dispose();
											AdminAddCourse addCourse = new AdminAddCourse();
											addCourse.setVisible(true);
											addCourse.getBtnReturnToCM().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													addCourse.dispose();
													cm.setVisible(true);
												}
											});
											addCourse.getBtnCreate().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {	
													addCourse.setNameString(addCourse.getNameField().getText());
													addCourse.setIDString(addCourse.getID().getText());
													addCourse.setInstructorString(addCourse.getInstructor().getText());
													addCourse.setLocationString(addCourse.getLoc().getText());
													addCourse.contentPane.remove(addCourse.getLbMaxInputError());
													addCourse.contentPane.remove(addCourse.getLbSectionInputError());
													addCourse.contentPane.remove(addCourse.getLblThatSectionAlready());
													addCourse.contentPane.remove(addCourse.getLblTheCourseHas());
													addCourse.setVisible(false);
													addCourse.setVisible(true);
													ArrayList<StudentClass> registeredStudents= new ArrayList <StudentClass>();
													int sameSec  = 0;
													int maxError = 0;
													int secError = 0;
													try {
														addCourse.setMaxInt(Integer.parseInt(addCourse.getMax().getText()));
													}
													catch (Exception k){
														maxError++;
													}
													try {
														addCourse.setSectionInt(Integer.parseInt(addCourse.getSection().getText()));
													}
													catch (Exception k){
														secError++;
													}
													for(int i = 0; i<User.CourseMenu.size(); i++) {
														if(User.CourseMenu.get(i).getCourseName().equals(addCourse.getNameString()) && User.CourseMenu.get(i).getSection() == addCourse.getSectionInt())
															sameSec++;
													}
													if(sameSec> 0) {
														addCourse.contentPane.add(addCourse.getLblThatSectionAlready());
														addCourse.setVisible(false);
														addCourse.setVisible(true);
													}
													else if(maxError>0 && secError==0) {
														addCourse.contentPane.add(addCourse.getLbMaxInputError());
														addCourse.setVisible(false);
														addCourse.setVisible(true);
													}
													else if(secError>0 && maxError==0) {
														addCourse.contentPane.add(addCourse.getLbSectionInputError());
														addCourse.setVisible(false);
														addCourse.setVisible(true);
													}
													else if(maxError>0 && secError>0) {
														addCourse.contentPane.add(addCourse.getLbMaxInputError());
														addCourse.contentPane.add(addCourse.getLbSectionInputError());
														addCourse.setVisible(false);
														addCourse.setVisible(true);
													}
													else {
														((AdminClass) admin).createNewCourse(addCourse.getNameString(), addCourse.getIDString() ,addCourse.getMaxInt(), 0, registeredStudents, addCourse.getInstructorString(), addCourse.getSectionInt(), addCourse.getLocationString());
														addCourse.getLblTheCourseHas().setText(addCourse.getNameString()+ " has been successfully added.");
														addCourse.contentPane.add(addCourse.getLblTheCourseHas());
														serialize();
													}
													}
											});
										}
									});
									cm.getBtnDelete().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											AdminDeleteCourse delete  = new AdminDeleteCourse();
											cm.dispose();
											delete.setVisible(true);
											delete.getBtnReturn().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													delete.dispose();
													cm.setVisible(true);
												}
											});
											delete.getBtnDelete().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													int index = delete.getJlist().getSelectedIndex();
													((AdminClass) admin).deleteCourseGUI(index);
													delete.list.removeElementAt(index);
													serialize();
													delete.setVisible(false);
													delete.setVisible(true);
												}
											});
										}
									});
									cm.getBtnRegisterAStudent().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											AdminRegisterStudent register  = new AdminRegisterStudent();
											cm.dispose();
											register.setVisible(true);
											register.getBtnReturn().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													register.dispose();
													cm.setVisible(true);
												}
											});
											register.getBtnRegister().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													 register.setFirstString(register.getTxtFirst().getText());
													 register.setLastString(register.getTxtLast().getText());
													 register.setUserString(register.getTxtUser().getText());
													 register.setPassString(register.getTxtPass().getText());
													 register.contentPane.remove(register.getLblUsernameAlreadyExists());
													 register.contentPane.remove(register.getLblIdAlreadyExists());
													 register.contentPane.remove(register.getLblPleaseEnterA());
													 register.contentPane.remove(register.getLblTheStudentHas());
													 register.setVisible(false);
													 register.setVisible(true);
													 int sameUser  = 0;
													 int sameID  = 0;
													try {
														 register.setID(Integer.parseInt(register.getTxtID().getText()));
													}	
													catch (Exception k){
														register.contentPane.add(register.getLblPleaseEnterA());
														return;
													}
													for(int i = 0; i< AdminClass.allStudents.size(); i++) {
														if(register.getUserString().equalsIgnoreCase(((StudentClass) AdminClass.allStudents.get(i)).getUser())) 
															sameUser++;
														if(register.getID() == ((StudentClass) AdminClass.allStudents.get(i)).getID()) 
															sameID++;
													
													}	
													if(sameUser>0 && sameID == 0) {
														register.contentPane.add(register.getLblUsernameAlreadyExists());
														register.setVisible(false);
														register.setVisible(true);
													}
													else if(sameID>0 && sameUser ==0) {
														register.contentPane.add(register.getLblIdAlreadyExists());
														register.setVisible(false);
														register.setVisible(true);
													}
													else if(sameUser>0 && sameID>0) {
														register.contentPane.add(register.getLblUsernameAlreadyExists());
														register.contentPane.add(register.getLblIdAlreadyExists());
														register.setVisible(false);
														register.setVisible(true);
													}
													else {
														((AdminClass) admin).addStudent(register.getFirstString(), register.getLastString(), register.getUserString(), register.getPassString(), register.getID());
														register.getLblTheStudentHas().setText(register.getFirstString() + " " + register.getLastString()+ " has been registered!");
														register.contentPane.add(register.getLblTheStudentHas());
														serialize();
													}
												}
											});
											
										}
									});
									cm.getBtnViewCourseInfo().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											AdminViewCourse viewOne  = new AdminViewCourse();
											cm.dispose();
											viewOne.setVisible(true);
											viewOne.getBtnReturn().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													viewOne.dispose();
													cm.setVisible(true);
												}
											});
											viewOne.getBtnView().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													int index = viewOne.getJlist().getSelectedIndex();
													AdminViewCourse2 info  = new AdminViewCourse2();
													viewOne.dispose();
													info.setVisible(true);
													info.getBtnReturnToPrevious().addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															info.dispose();
															viewOne.setVisible(true);
														}
													});
													((AdminClass) admin).printCourseInfoGUI(index); 
												}
											});
										}
									});
									cm.getBtnEditACourse().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											AdminEditCourse edit = new AdminEditCourse();
											cm.dispose();
											edit.setVisible(true);
											edit.getBtnReturn().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													edit.dispose();
													cm.setVisible(true);
												}
											});
											edit.getBtnEdit().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													try {
														int index = edit.getJlist().getSelectedIndex();
														AdminEditCourse2 edit2  = new AdminEditCourse2(index);
														edit2.dispose();
														edit2.setVisible(true);
														edit2.getBtnReturnToPrevious().addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																edit2.dispose();
																edit.getList().removeAllElements();
																for(int i= 0; i<User.CourseMenu.size(); i++) {
																	edit.getList().add(i, User.CourseMenu.get(i).getCourseName() + " (Section: " + User.CourseMenu.get(i).getSection() + ")");
																}
																edit.getJlist().setModel(edit.getList());
																edit.scrollPane.setViewportView(edit.getJlist());
																edit.getJlist().setLayoutOrientation(JList.VERTICAL);
																edit.contentPane.add(edit.scrollPane);
																edit.setVisible(true);
															}
														});
														 edit2.getBtnEditMax().addActionListener(new ActionListener() {
															 public void actionPerformed(ActionEvent e) {
																 edit2.contentPane.remove(edit2.getLblMaxError());
																 edit2.contentPane.remove(edit2.getLblTheChangesHave());
																 edit2.setVisible(false);
																 edit2.setVisible(true);
															    try {
																	 edit2.setMaxInt(Integer.parseInt(edit2.getMax().getText()));
																}
																catch (Exception k){
																	edit2.contentPane.add(edit2.getLblMaxError());
																	edit2.setVisible(false);
																    edit2.setVisible(true);
																    return;
																}
																AdminClass.CourseMenu.get(index).setMax(edit2.getMaxInt());
																edit2.contentPane.add(edit2.getLblTheChangesHave());
																serialize();
															 }
														 });
														 edit2.getBtnEditIns().addActionListener(new ActionListener() {
															 public void actionPerformed(ActionEvent e) {
																 edit2.setInstructorString(edit2.getInstructor().getText());
																 edit2.contentPane.remove(edit2.getLblTheChangesHave());
																 edit2.setVisible(false);
																 edit2.setVisible(true);
																 AdminClass.CourseMenu.get(index).setInstructor(edit2.getInstructorString());
																 edit2.contentPane.add(edit2.getLblTheChangesHave());
																 serialize();
															 }
														 });
														 edit2.getBtnEditSec().addActionListener(new ActionListener() {
															 public void actionPerformed(ActionEvent e) {
																 edit2.contentPane.remove(edit2.getLblSecError());
																 edit2.contentPane.remove(edit2.getLblThatSectionAlready());
																 edit2.contentPane.remove(edit2.getLblTheChangesHave());
																 edit2.setVisible(false);
																 edit2.setVisible(true);
																 int sameSection = 0;
																 System.out.println("The value of same section is: " + sameSection);
															    try {
															    	 edit2.setSectionInt(Integer.parseInt(edit2.getSection().getText()));
																}
																catch (Exception k){
																	edit2.contentPane.add(edit2.getLblSecError());
																	edit2.setVisible(false);
																    edit2.setVisible(true);
																    return;
																}
															    for(int i = 0; i< User.CourseMenu.size(); i++) {
															    	if(	User.CourseMenu.get(i).getCourseName().equals(User.CourseMenu.get(index).getCourseName()) && 
															    		User.CourseMenu.get(i).getSection()== edit2.getSectionInt()) {
																    		edit2.contentPane.add(edit2.getLblThatSectionAlready());
																	    	edit2.setVisible(false);
																	    	edit2.setVisible(true);
																	    	return;
															    	}		
															    }
															    AdminClass.CourseMenu.get(index).setSection(edit2.getSectionInt());
																edit2.contentPane.add(edit2.getLblTheChangesHave());
																serialize();
															 }
														 });
														 edit2.getBtnEditLoc().addActionListener(new ActionListener() {
															 public void actionPerformed(ActionEvent e) {
																 edit2.setLocationString(edit2.getLoc().getText());
																 edit2.contentPane.remove(edit2.getLblTheChangesHave());
																 edit2.setVisible(false);
																 edit2.setVisible(true);
																 AdminClass.CourseMenu.get(index).setLocation(edit2.getLocationString());
																 edit2.contentPane.add(edit2.getLblTheChangesHave());
																 serialize();
															 }
														 });
													}
													catch (IndexOutOfBoundsException k) {
														edit.setVisible(true);
													}
												}
											});
										}
									});	
								}
							});
							home.btnReports.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									AdminReports reports = new AdminReports();
									home.dispose();
									reports.setVisible(true);
									reports.btnReturn.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											reports.dispose();
											home.setVisible(true);
										}
									});
									reports.btnViewAllCourses.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											AdminViewAllCourses viewAll = new AdminViewAllCourses();
											reports.dispose();
											viewAll.setVisible(true);
											((AdminClass)admin).viewAllCoursesGUI();
											viewAll.getBtnReturnToReports().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													viewAll.dispose();
													reports.setVisible(true);
												}
											});
										}
									});
									reports.getBtnSortCourses().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											AdminSortCourses sort = new AdminSortCourses();
											reports.dispose();
											sort.setVisible(true);
											((AdminClass) admin).sortCoursesGUI();
											serialize();
											sort.getBtnReturnToReports().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													sort.dispose();
													reports.setVisible(true);
												}
											});
										}
									});
									reports.getBtnViewAStudents().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											AdminStudentCourses studentCourse = new AdminStudentCourses();
											reports.dispose();
											studentCourse.setVisible(true);
											studentCourse.getBtnReturnToReports().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													studentCourse.dispose();
													reports.setVisible(true);
												}
											});
											studentCourse.getBtnView().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													int index = studentCourse.getJlist().getSelectedIndex();
													AdminStudentCourse2 courseList  = new AdminStudentCourse2();
													studentCourse.dispose();
													courseList.setVisible(true);
													courseList.getBtnReturnToPrevious().addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															courseList.dispose();
															studentCourse.setVisible(true);
														}
													});
													((AdminClass) admin).studentsCoursesGUI(index); 
												}
											});
										}
									});
									reports.getBtnViewFullCourses().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											AdminViewFullCourses full = new AdminViewFullCourses();
											reports.dispose();
											full.setVisible(true);
											full.getBtnReturnToReports().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													full.dispose();
													reports.setVisible(true);
												}
											});
											((AdminClass) admin).printFullCoursesGUI(); 
										}
									});
									reports.getBtnWriteFull().addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											AdminWriteFullCourses fullWrite = new AdminWriteFullCourses();
											reports.dispose();
											fullWrite.setVisible(true);
											fullWrite.getBtnReturnToReports().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													fullWrite.dispose();
													reports.setVisible(true);
												}
											});
											((AdminClass) admin).writeFullCoursestoFileGUI(); 
										}
									});
									reports.getBtnViewRoster() .addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											AdminStudentsInCourse roster = new AdminStudentsInCourse();
											reports.dispose();
											roster.setVisible(true);
											roster.getBtnReturnToReports().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													roster.dispose();
													reports.setVisible(true);
												}
											});
											
											roster.getBtnView().addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													int index = roster.getJlist().getSelectedIndex();
													AdminStudentsInCourse2 list  = new AdminStudentsInCourse2();
													roster.dispose();
													list.setVisible(true);
													list.getBtnReturnToPrevious().addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															list.dispose();
															roster.setVisible(true);
														}
													});
													((AdminClass) admin).studentsInCourseGUI(index); 
												}
											});
										}
									});
								}
							});
						}
						else {
							login.lbLoginError = new JLabel("Invalid username or password. Please try again.");
							login.lbLoginError.setForeground(new Color(255, 0, 0));
							login.lbLoginError.setFont(new Font("Lucida Grande", Font.BOLD, 14));
							login.lbLoginError.setBounds(157, 458, 415, 16);
							login.contentPane.add(login.lbLoginError);
							login.setVisible(false);
							login.setVisible(true);
						}
					}
				});
			}
		});
		
		
		
		frame.getContentPane().add(btnAdmin);
		frame.getContentPane().add(btnStudent);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(175, 238, 238));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/Users/Gabrielle/Desktop/Unknown.png"));
		lblNewLabel.setBounds(223, 36, 210, 186);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblWelcomeToCourse = new JLabel(" Welcome to Course Registration! Are you an adminstrator or a student?");
		lblWelcomeToCourse.setForeground(new Color(255, 255, 255));
		lblWelcomeToCourse.setBackground(new Color(230, 230, 250));
		lblWelcomeToCourse.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblWelcomeToCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToCourse.setBounds(-40, 202, 752, 135);
		frame.getContentPane().add(lblWelcomeToCourse);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(-16, 297, 73, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
	
	}
	public void serialize() {
		ArrayList <Course> copy = User.CourseMenu;
		ArrayList <User> copy2= AdminClass.allStudents;
		
		try {
			FileOutputStream data = new FileOutputStream (filename);
			ObjectOutputStream out = new ObjectOutputStream(data);
			out.writeObject(copy);
			out.writeObject(copy2);
			out.close();
			data.close();
			System.out.println("The data has been serialized.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//edit2.setInstructorString(edit2.getInstructor().getText());
//edit2.setLocationString(edit2.getLoc().getText());
//edit2.contentPane.remove(edit2.getLblMaxError());
//edit2.contentPane.remove(edit2.getLblSecError());
//edit2.contentPane.remove(edit2.getLblTheChangesHave());
//edit2.setVisible(false);
//edit2.setVisible(true);
//int maxError  = 0;
//int secError  = 0;
//int sameSection  = 0;
//int originalSec  = User.CourseMenu.get(index).getSection();
//try {
//	 edit2.setMaxInt(Integer.parseInt(edit2.getMax().getText()));
//}
//catch (Exception k){
//	maxError++;
//}
//try {
//	 edit2.setSectionInt(Integer.parseInt(edit2.getSection().getText()));
//}
//catch (Exception k){
//	secError++;
//}
//for(int i = 0; i< User.CourseMenu.size(); i++) {
//	if(	User.CourseMenu.get(i).getCourseName().equals(User.CourseMenu.get(index).getCourseName()) && 
//		User.CourseMenu.get(i).getSection()== User.CourseMenu.get(index).getSection()  &&
//		User.CourseMenu.get(i)!= User.CourseMenu.get(index))
//		sameSection++;
//}	
//if(sameSection>0) {
//	edit2.contentPane.add(edit2.getLblThatSectionAlready());
//	edit2.setVisible(false);
//	edit2.setVisible(true);
//	return;
//}
//if(maxError>0 && secError == 0) {
//	edit2.contentPane.add(edit2.getLblMaxError());
//	edit2.setVisible(false);
//   edit2.setVisible(true);
//}
//else if(maxError == 0 && secError>0) {
//	edit2.contentPane.add(edit2.getLblSecError());
//	edit2.setVisible(false);
//   edit2.setVisible(true);
//}
//else if(maxError>0 && secError>0) {
//	edit2.contentPane.add(edit2.getLblMaxError());
//	edit2.contentPane.add(edit2.getLblSecError());
//	edit2.setVisible(false);
//	edit2.setVisible(true);
//}
//else {
//	AdminClass.CourseMenu.get(index).setMax(edit2.getMaxInt());
//	AdminClass.CourseMenu.get(index).setInstructor(edit2.getInstructorString());
//	AdminClass.CourseMenu.get(index).setSection(edit2.getSectionInt());
//	AdminClass.CourseMenu.get(index).setLocation(edit2.getLocationString());
//	edit2.contentPane.add(edit2.getLblTheChangesHave());
//	serialize();
//}
//}
//});