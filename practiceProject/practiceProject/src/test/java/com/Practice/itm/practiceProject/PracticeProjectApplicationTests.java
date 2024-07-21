package com.Practice.itm.practiceProject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.Practice.itm.practiceProject.entity.Student;
import com.Practice.itm.practiceProject.studentservice.StudentService;

@SpringBootTest
class PracticeProjectApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void testStudentClass()
	{
		Student s= new Student();
		Assert.isTrue(s instanceof Student,"Student object creation failed");
	}
	
	@Test
	void testStudentObject()
	{
		Student s =new Student(10,"ram","csc","male");
		Assert.isTrue(10==s.getId(), "getter was failed");
		Assert.isTrue("ram".equals(s.getName()), "getter was failed");
		Assert.isTrue("csc".equals(s.getBranch()), "getter was failed");
		Assert.isTrue("male".equals(s.getGender()), "getter was failed");
	}
	
	@Test
	void testUpdateObject()
	{
		Student s= new Student();
		s.setId(10);
		s.setName("ram");
		s.setBranch("csc");
		s.setGender("male");
		Assert.isTrue(10==s.getId(), "getter was failed");
		Assert.isTrue("ram".equals(s.getName()), "getter was failed");
		Assert.isTrue("csc".equals(s.getBranch()), "getter was failed");
		Assert.isTrue("male".equals(s.getGender()), "getter was failed");
	}
	
	@Test
	void testEqualAndHashcodeMethods()
	{
		Student s =new Student(10,"ram","csc","male");
		Student s1 =new Student(10,"ram","csc","male");
		Assert.isTrue(s.equals(s1), "");
		Assert.isTrue(s.hashCode()== s1.hashCode(), "");
	   
	}
	

	@Test
	void testTostring()
	{
		String str="Student(id=10, name=ram, branch=csc, gender=male)";
		Student s =new Student(10,"ram","csc","male");
		Assert.isTrue(str.equals(s.toString()),"method failed");
	}
	
	@Test
	void testaddStudent()
	{
		Student s =new Student();
		StudentService ss=new StudentService();
		boolean flag =ss.addStudent(s);
		Assert.isTrue(flag, "student adding method is failed");
	}

	@Test 
	void testgetStudentById()
	{
		Student s= new Student();
		StudentService ss=new StudentService();
		StudentService ss1=new StudentService();
	    ss.getStudentById(0);
	    ss.getStudentById(0);
	}
	
	@Test
	void testgetAllStudents()
	{
		StudentService ss=new StudentService();
		ss.getAllStudents();
	}
	
	@Test
	void testUpadateStudent()
	{
		Student s= new Student();
		Student s1=new Student();
		StudentService ss=new StudentService();
		StudentService ss1=new StudentService();
		ss.addStudent(s);
		ss1.addStudent(s1);
		ss.updateStudent(0, "");
		ss.addStudent(s1);
		ss.addStudent(s1);
		ss1.updateStudent(0, "");
	}
	
	@Test
	void testDeleteStudentById()
	{
		Student s= new Student();
		StudentService ss=new StudentService();
		ss.addStudent(s);
		ss.deleteStudentById(0);
		ss.deleteStudentById(0);
	}
}
