package com.sis.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.sis.dao.TeacherServiceImpl;
import com.sis.entities.Teacher;
import com.sis.exceptions.TeacherNotFoundException;

public class TeacherController {
	Scanner s = new Scanner(System.in);
	TeacherServiceImpl teacher_service = new TeacherServiceImpl();
	public void addTeacher() throws SQLException
	{
		System.out.println("Add Teacher");
		System.out.println("Enter id of the Teacher:");
		int id = s.nextInt();
		s.nextLine();
		System.out.println("Enter firstname:\n");
		String fname = s.nextLine();
		System.out.println("Enter lastname:\n");
		String lname = s.nextLine();
		System.out.println("Enter email:\n");
		String email = s.nextLine();
		Teacher teacher = new Teacher(id, fname, lname, email);
		int res = teacher_service.saveTecaher(teacher);
		if (res == 1) {
			System.out.println("Teacher" + teacher.getFirst_name() + "inserted Successfully");
		} else {
			System.out.println("Try again");
		}
	}
	public void getTeacherById() throws SQLException
	{
		System.out.println("Enter id of the Teacher");
		int ip = s.nextInt();
		Teacher records = teacher_service.getDetailsById(ip);
		System.out.println(records);
	}
	public void addcourse() throws SQLException, TeacherNotFoundException
	{
		CourseController course_controller=new CourseController();
		course_controller.addCourse();
	}

}
