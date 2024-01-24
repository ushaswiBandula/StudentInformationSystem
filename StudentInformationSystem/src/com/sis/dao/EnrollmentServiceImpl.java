package com.sis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sis.util.DBPropertyUtil;

public class EnrollmentServiceImpl implements EnrollmentService {


	@Override
	public void getStudent(int enrollment_id) throws SQLException {
	        Connection con=DBPropertyUtil.getConnection();
	        PreparedStatement ps=con.prepareStatement("select first_name from student join enrollments "
	        		+ "on student.student_id=enrollments.student_id where enrollment_id=?;"); 
	        ps.setInt(1, enrollment_id);
	        ResultSet rs=(ResultSet) ps.executeQuery();  
	        while(rs.next()){  
	           System.out.println(rs.getString("first_name"));
	        }  
	}

	@Override
	public void getCourse(int enrollment_id) throws SQLException {
		Connection con=DBPropertyUtil.getConnection();
        PreparedStatement ps=con.prepareStatement("select course_name from courses join enrollments "
        		+ "on  courses.course_id=enrollments.course_id where enrollment_id=?;"); 
        ps.setInt(1, enrollment_id);
        ResultSet rs=(ResultSet) ps.executeQuery();  
        while(rs.next()){  
           System.out.println(rs.getString("course_name"));
        }  
		
	}

}
