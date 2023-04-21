package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program Started..." );
        		// spring jdbc => JdbcTemplate
//        ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml"); //this is for xml based config
//        StudentDao studentDao = context.getBean("studentDao",StudentDao.class); 
       
        ApplicationContext context= new AnnotationConfigApplicationContext(JdbcConfig.class);   //for java based configuration
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
//        Student student= new Student();
//        student.setId(789);
//        student.setName("Nathan");
//        student.setCity("perth");
//        
//        int result = studentDao.insert(student);
//        System.out.println("student added " + result);
        
//        Student student=new Student();
//        student.setName("Johnny");
//        student.setCity("Malad");
//        student.setId(666);
//        int result = studentDao.change(student);
//        System.out.println("student changed " + result);
        
//          Student student=new Student();
//          student.setId(456);
//          int result = studentDao.delete(student);
//          System.out.println("student deleted " + result);
        
//        	Student student = studentDao.getStudent(222);
//        	System.out.println(student);
        
        	List<Student> allStudents = studentDao.getAllStudents();
        	for(Student s: allStudents) {
        	System.out.println(s);
        	}
          
        
    }
}
