package com.sis.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.sis.dao.EnrollmentServiceImpl;

public class EnrollmentController {
	private EnrollmentServiceImpl enroll_service = new EnrollmentServiceImpl();
	Scanner s = new Scanner(System.in);

	public void getStudent() throws SQLException {
		System.out.println("Enter Enrollment id");
		int eid = s.nextInt();
		enroll_service.getStudent(eid);
	}
    public void getCourse() throws SQLException
    {
    	System.out.println("Enter Enrollment id");
		int eid = s.nextInt();
		enroll_service.getCourse(eid);
    }
   
}
