package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//      Student student=new Student(1191,"Mark Cameroon","Brussels");
//      int r = studentDao.insert(student);
//      System.out.println("done"+r);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go=true;
		while (go) {
		      System.out.println("PRESS 1 to add new student");
		      System.out.println("PRESS 2 to display all students");
		      System.out.println("PRESS 3 to display a single student");
		      System.out.println("PRESS 4 to delete students");
		      System.out.println("PRESS 5 to updare student");
		      System.out.println("PRESS 6 for exit");
		      
		      try {
		    	 int input = Integer.parseInt( br.readLine());
		    	 switch (input) {
				case 1:
					//add a new student
					//taking input from users
					System.out.println("Enter user id :");
					int uid = Integer.parseInt(br.readLine());
					
					System.out.println("Enter user name");
					String uName = br.readLine();
					
					System.out.println("Enter user city");
					String uCity = br.readLine();
					
					//creating student object and setting values
					Student s=new Student();
					s.setStudentId(uid);
					s.setStudentName(uName);
					s.setStudentCity(uCity);
					
					//saving student object to database by calling insert method of student dao
					int r = studentDao.insert(s);
					System.out.println(r+"student added");
					System.out.println("***********************");
					System.out.println();
					break;
				case 2:
					//display all student
					System.out.println("************************");
					List<Student> allStudents = studentDao.getAllStudents();					
					for(Student st:allStudents) {
						System.out.println("Id :" + st.getStudentId());
						System.out.println("Name : " + st.getStudentName());
						System.out.println("City : " + st.getStudentCity());
						System.out.println("______________________________");
					}
					System.out.println("*******************************");
					break;
				case 3:
					//display one student data
					System.out.println("Enter user id :");
					int userId = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(userId);
					System.out.println("Id :" + student.getStudentId());
					System.out.println("Name : " + student.getStudentName());
					System.out.println("City : " + student.getStudentCity());
					System.out.println("______________________________");
					
					
					break;
				case 4:
					//delete student
					System.out.println("Enter user id :");
					int Id = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(Id);
					System.out.println("student deleted");
					
					break;
					
				case 5:
					//update student
					System.out.println("Enter user id :");
					int upId = Integer.parseInt(br.readLine());
					Student upStudent = studentDao.getStudent(upId);
					
					System.out.println("Enter new user name");
					String upName = br.readLine();
					
					System.out.println("Enter new user city");
					String upCity = br.readLine();
					
					upStudent.setStudentName(upName);
					upStudent.setStudentCity(upCity);
					
					studentDao.updateStudent(upStudent);
					
					break;
				case 6:
					//exit
					go=false;
					break;
				}
				
			} catch (Exception e) {
				System.out.println("Invalid Input Try with another one!!");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Thank You for using my application");
		System.out.println("See you soon nigga");
	}
}
