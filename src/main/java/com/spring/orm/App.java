package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entity.Student;


public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
    	
    	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    	 StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
    	 System.out.println("Successfull");
    	
    	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	  
    	  boolean go =true;
    	  while(go) {
    		  System.out.println("PRESS 1 TO ADD A NEW STUDENT");
    		  System.out.println("PRESS 2 TO  GET A SINGLE  STUDENT DETAIL");
    		  System.out.println("PRESS 3 TO GET ALL STUDENT DETAILS");
    		  System.out.println("PRESS 4 TO DELETE A NEW STUDENT");
    		  System.out.println("PRESS 5 TO UPDATE A NEW STUDENT");
    		  System.out.println("PRESS 6 TO EXIT");
    		  
    		  
    		  
    		  try {
    			  int input=Integer.parseInt(br.readLine());
    			  switch(input) {
    			  case 1:
    				  //add a Stude int row= 0;
    				  System.out.println("Enter user name");
    				  String name=br.readLine();
    				  
    				  System.out.println("Enter user city");
    				  String city=br.readLine();
    				  
    				  Student s=new Student();
    				  s.setStudentName(name);
    				  s.setStudentCity(city);
    				  studentDao.insert(s);
    				 
    				  
    				  break;
    			  case 2: 
    				  // get a single student detail
    				  System.out.println("enter id of the user");
    				  int id=Integer.parseInt(br.readLine());
    				   Student s1=studentDao.getStudent(id);
    				   System.out.println("-----------------------------------------------");
    				   System.out.println(s1.getStudentId());
    				  System.out.println(s1.getStudentName());
    				  System.out.println(s1.getStudentCity());
    				  System.out.println("----------------------------------------------------");
    				  break;
    			  case 3: 
    				  // get all students
    				  List<Student> allStudents=studentDao.getAllStudents();
    				  for(Student st:allStudents ) {
    					   System.out.println("-----------------------------------------------");
    					  System.out.println(st.getStudentId());
    					  System.out.println(st.getStudentCity());
    					  System.out.println(st.getStudentName());
    					   System.out.println("-----------------------------------------------");
    					  
    					  
    				  }
    				  break;
    			  case 4: 
    				  //delete a student
    				  System.out.println("enter id of the user");
    				  int uid=Integer.parseInt(br.readLine());
    				  studentDao.delete(uid);
    				  System.out.println("Successfully deleted");
    				  
    				  break;
    			  case 5 :
    				  //update a student
    				  Student s11=new Student(568 ,"janu Singh", "Gudha Gorji");
    				  studentDao.update( s11);
    				  System.out.println("Successfully updated");
    				  
    				  break;
    			  case 6:
    				  System.out.println("thank you  for using our application");
    				  System.out.println("See You Soon !!");
    				  go=false;
    				  break;
    			  }
    		  }
    		  catch(Exception e) {
    			  System.out.println("Invalid student");
    			  System.out.println(e.getMessage());
    			  	
    		  }
    	  }
    	  
    	
    }
}
