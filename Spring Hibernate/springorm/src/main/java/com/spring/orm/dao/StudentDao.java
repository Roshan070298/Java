package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernatetemplate;
	
	//save student
	@Transactional
	public int insert(Student student) {
		//insert
		int i = (Integer) this.hibernatetemplate.save(student);
		return i;
		
	}
	
	//get the single data(object)
	public Student getStudent(int studentId) {
		Student student = this.hibernatetemplate.get(Student.class, studentId);
		return student;
		
	}
	//get all students(all rows)
	public List<Student> getAllStudents(){
		List<Student> students = this.hibernatetemplate.loadAll(Student.class);
		return students;
	}
	
	//deleting the data
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernatetemplate.get(Student.class, studentId);
		this.hibernatetemplate.delete(student);
	}
	
	//update data
	@Transactional
	public void updateStudent(Student student) {
		this.hibernatetemplate.update(student);
	}
	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}
	
}
