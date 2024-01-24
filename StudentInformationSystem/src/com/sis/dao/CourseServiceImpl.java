package com.sis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sis.entities.Course;
import com.sis.exceptions.CourseNotFoundException;
import com.sis.exceptions.TeacherNotFoundException;
import com.sis.util.DBPropertyUtil;

public class CourseServiceImpl implements CourseService {
	@Override
	public int assignCourse(Course course) throws SQLException, TeacherNotFoundException {
		Connection conn=DBPropertyUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from Teacher where teacher_id=?");
		ps.setInt(1, course.getTeacher_id());
		ResultSet rs=ps.executeQuery();
		int row=0;
		while(rs.next())
		{
			row++;
		}
		if(row==0)
		{
			throw new TeacherNotFoundException(course.getTeacher_id());
		}
		ps=conn.prepareStatement(""
				+ "insert into Courses(course_id,course_name,course_code,teacher_id) values(?,?,?,?)");
		ps.setInt(1, course.getCourse_id());
		ps.setString(2, course.getCourse_name());
		ps.setInt(3, course.getCourse_code());
		ps.setInt(4, course.getTeacher_id());
		int res=ps.executeUpdate();
		return res;	
	
	}

	@Override
	public int updateCourse(Course course) throws SQLException {
		Connection conn=DBPropertyUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement(""
				+ "update Courses set course_name=?,course_code=?,teacher_id=? where course_id=?");
		ps.setString(1, course.getCourse_name());
		ps.setInt(2, course.getCourse_code());
		ps.setInt(3, course.getTeacher_id());
		ps.setInt(4, course.getCourse_id());
		int res=ps.executeUpdate();
		return res;	
	}

	@Override
	public int displayCourseInfo(int course_id) throws  Exception {
		 Connection con = DBPropertyUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"select * from courses where course_id=?");
			ps.setInt(1, course_id);
			ResultSet rs=ps.executeQuery();
			int rows=0;
			while(rs.next())
			{

				System.out.println("course_id:"+" "+rs.getInt("course_id")+"  "+"course_name:"+" "+rs.getString("course_name")+"   "+"course_code:"+" "+rs.getString("course_code")+"  "
						+"teacher_id:"+" "+rs.getString("teacher_id"));
				rows++;
			}
			if(rows==0)
			{
				throw new CourseNotFoundException(course_id);
			}
			
		return 0;
	}

	@Override
	public int getTeacherByCourseId(int course_id) throws Exception {
		Connection con = DBPropertyUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select first_name from teacher join courses on teacher.teacher_id=courses.teacher_id where course_id=?");
		ps.setInt(1, course_id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString("first_name"));
		}
		return 0;
	}
	public int getEnrollments(int course_id) throws SQLException
	{
		Connection con = DBPropertyUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"SELECT\r\n"
				+ "    s.student_id,CONCAT(s.first_name, ' ', s.last_name) AS student_name,c.course_name FROM\r\n"
				+ "    enrollments e  JOIN student s ON e.student_id = s.student_id JOIN courses c ON e.course_id = c.course_id\r\n"
				+ "WHERE\r\n"
				+ "    e.course_id = ?;\r\n"
				+ "");
		ps.setInt(1, course_id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString("student_id")+" "+rs.getString("student_name")+" "+rs.getString("course_name"));
		}
		return 0;
	}

}
