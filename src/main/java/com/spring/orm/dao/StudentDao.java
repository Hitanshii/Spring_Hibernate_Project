package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.spring.orm.entity.Student;

public class StudentDao {
    
    private HibernateTemplate hibernateTemplate;
    
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    // Insert Student
    @Transactional  
    public int insert(Student student) {
        return (Integer) this.hibernateTemplate.save(student);
    }
    
    //get a single row
    @Transactional  
    public Student getStudent(int studentId) {
    Student student=this.hibernateTemplate.get(Student.class, studentId);
    	return student;
    }
    //get list of student
    @Transactional 
    public List<Student> getAllStudents(){
    	List<Student> students=this.hibernateTemplate.loadAll(Student.class);
    	return students;
    }
    
    //delete student
    @Transactional  
    public void delete(int studentId) {
    	Student student=this.hibernateTemplate.get(Student.class, studentId);
    	this.hibernateTemplate.delete(student);
    }
    
    //update
    @Transactional  
    public void update(Student student) {
    	this.hibernateTemplate.update(student);
    }
    
}
