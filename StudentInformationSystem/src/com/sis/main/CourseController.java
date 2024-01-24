package com.sis.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.sis.dao.CourseServiceImpl;
import com.sis.entities.Course;
import com.sis.exceptions.TeacherNotFoundException;

public class CourseController {
	CourseServiceImpl course_service = new CourseServiceImpl();
	Scanner s = new Scanner(System.in);

	public void addCourse() throws SQLException, TeacherNotFoundException {
		System.out.println("Entering a course...");
		Course course = new Course();
		System.out.println("Enter Teacher id:");
		int teacher_id = s.nextInt();
		s.nextLine();
		System.out.println("Enter Courseid:");
		int cid = s.nextInt();
		s.nextLine();
		System.out.println("Enter CourseName:");
		String cname = s.nextLine();
		System.out.println("Enter Coursecode:");
		int course_code = s.nextInt();
		course.setCourse_code(course_code);
		course.setCourse_id(cid);
		course.setTeacher_id(teacher_id);
		course.setCourse_name(cname);
		int res = course_service.assignCourse(course);
		if (res == 1) {
			System.out.println("Course  " + course.getCourse_name() + " added Successfully");
		} else {
			System.out.println("Try again");
		}
	}
    public void updateCourseInfo() throws SQLException, TeacherNotFoundException
    {
    	System.out.println("Updating a course...");
		Course course = new Course();
		System.out.println("Enter Teacher id:");
		int teacher_id = s.nextInt();
		s.nextLine();
		System.out.println("Enter Courseid:");
		int cid = s.nextInt();
		s.nextLine();
		System.out.println("Enter CourseName:");
		String cname = s.nextLine();
		System.out.println("Enter Coursecode:");
		int course_code = s.nextInt();
		course.setCourse_code(course_code);
		course.setCourse_id(cid);
		course.setTeacher_id(teacher_id);
		course.setCourse_name(cname);
		int res = course_service.assignCourse(course);
		if (res == 1) {
			System.out.println("Course  " + course.getCourse_name() + " added Successfully");
		} else {
			System.out.println("Try again");
		}
    }
    public void displayCourseInfo() throws Exception
    {
    	System.out.println("Display Course Details...");
		System.out.println("Enter Courseid:");
		int cid = s.nextInt();
		course_service.displayCourseInfo(cid);
    }
    public void getTeacherByCourseId() throws Exception
    {
    	System.out.println("Displaying teacher...");
		System.out.println("Enter Courseid:");
		int cid = s.nextInt();
		course_service.getTeacherByCourseId(cid);
    }
    public void getEnrollmentsByCourseId() throws Exception
    {
    	System.out.println("Displaying Enrollment Details...");
		System.out.println("Enter Courseid:");
		int cid = s.nextInt();
		course_service.getEnrollments(cid);
    }
    
}
