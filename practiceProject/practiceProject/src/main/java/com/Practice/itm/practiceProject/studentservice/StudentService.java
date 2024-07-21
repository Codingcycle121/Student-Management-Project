package com.Practice.itm.practiceProject.studentservice;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Practice.itm.practiceProject.entity.Student;
import java.util.Comparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentService implements Comparator<Integer> {

	List<Student> students =new ArrayList<Student>();
	 Logger logging = LoggerFactory.getLogger(StudentService.class);

	public boolean addStudent(Student s)
	{
		logging.info("New student adding");
		for(Student std : students)
		{
			if( std.getId()==s.getId() || std.equals(s)   )
			{
				logging.error("Student already added");
				return false;
			}
			if(std.getName().isBlank() && std.getBranch().isEmpty()  && std.getGender().isEmpty())
			{
				logging.error("student details must be filled");
				return false;
				
			}
		}
		logging.info("New student added");
		students.add(s);
		return true;
	}
	
	public Student getStudentById(long id)
	{
		logging.info("Check student through id");
		for (Student s : students)
		{
			if(s.getId()==id)
			{
				logging.error("Student already exits");
				return s;
			}
		}
		logging.info("Student found");
		return new Student();
	}
	
	public Student updateStudent(long id,String name)
	{
		logging.info("Update student name");
		for(Student s : students)
		{
			if(s.getId()==id)
			{
				logging.info("Student name successfully updated");
				s.setName(name);
				return s;
			}
		}
		logging.error("Student not found");
		return null;
	}
	
	public Student deleteStudentById(long id)
	{
		boolean flag =false;
		Student std=null;
		logging.info("Delete student by id");
		for (Student s : students)
		{
			if(s.getId()==id)
			{
				flag=true;
				std=s;
			}
		}
		if(flag)
		{
			logging.info("Student removed");
			students.remove(std);
			return std;
		}
		logging.info("Add New Student");
		return new Student();
	}
	
	public List<Student> getAllStudents()
	{
		return students;
	}

	public int compare(long id, long id2) {
		// TODO Auto-generated method stub
		return (int) (id-id2);
				}

	public int sortStudentById(long id) {
		// TODO Auto-generated method stub
		return compare(id, id);
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
