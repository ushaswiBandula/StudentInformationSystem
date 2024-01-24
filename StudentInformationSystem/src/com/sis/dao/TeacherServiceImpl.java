package com.sis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sis.entities.Teacher;
import com.sis.util.DBPropertyUtil;

public class TeacherServiceImpl implements TeacherService {


	@Override
	public int saveTecaher(Teacher teacher) throws SQLException {
		Connection conn=DBPropertyUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement(""
				+ "insert into teacher(teacher_id,first_name,last_name,email) values(?,?,?,?)");
		ps.setInt(1, teacher.getTeacher_id());
		ps.setString(2, teacher.getFirst_name());
		ps.setString(3, teacher.getLast_name());
		ps.setString(4, teacher.getEmail());
		int res=ps.executeUpdate();
		return res;
	}

	@Override
	public int updateTeacher(Teacher teacher) throws SQLException {
		Connection conn=DBPropertyUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement(""
				+ "update table teacher set first_name=?,last_name=?,email=? where teacher_id=?");
		ps.setString(1, teacher.getFirst_name());
		ps.setString(2, teacher.getLast_name());
		ps.setString(3, teacher.getEmail());
		ps.setInt(4, teacher.getTeacher_id());
		int res=ps.executeUpdate();
		return res;
	}
	public  Teacher getDetailsById(int id) throws SQLException
	{  
		    Teacher t=new Teacher();
	        Connection con=DBPropertyUtil.getConnection();
	        PreparedStatement ps=con.prepareStatement("select * from teacher where teacher_id=?"); 
	        ps.setInt(1, id);
	        ResultSet rs=(ResultSet) ps.executeQuery();  
	        while(rs.next()){  
	            t.setEmail(rs.getString("email"));
	            t.setFirst_name(rs.getString("first_name"));
	            t.setLast_name(rs.getString("last_name"));
	            t.setTeacher_id(rs.getInt("teacher_id"));
	        }  
	    return t;  
	} 
	public void getListOfCoursesAssigned(int teacher_id) throws SQLException
	{
		Connection con = DBPropertyUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select course_name from courses join teacher on courses.teacher_id=teacher.teacher_id where teacher.teacher_id=1;");
		ps.setInt(1, teacher_id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString("course_name"));
		}
		
	}
	

}
