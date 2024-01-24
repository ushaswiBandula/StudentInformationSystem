package com.sis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sis.entities.Enrollments;
import com.sis.entities.Payment;
import com.sis.entities.Student;
import com.sis.exceptions.InvalidEnrollmentDataException;
import com.sis.exceptions.InvalidStudentDataException;
import com.sis.exceptions.StudentNotFoundException;
import com.sis.util.DBPropertyUtil;

public class StudentServiceImpl implements StudentService {

	public int save(Student student) throws SQLException, InvalidStudentDataException {
		Connection con = DBPropertyUtil.getConnection();
		int c=0;
		if(student.getMobileNo().length()!=10)
		{
			c=1;
			throw new InvalidStudentDataException(c);
		}
		if(!student.getEmail().contains("@gmail.com"))
		{
			c=2;
			throw new InvalidStudentDataException(c);
		}
		if(student.getDateOfBirth().length()!=10)
		{
			c=3;
			throw new InvalidStudentDataException(c);
		}
		PreparedStatement ps = con.prepareStatement(
				"insert into student(student_id,first_name,last_name,date_of_birth,email,phone_number) values(?,?,?,?,?,?)");
		ps.setInt(1, student.getId());
		ps.setString(2, student.getFirstName());
		ps.setString(3, student.getLastName());
		ps.setString(4, student.getDateOfBirth());
		ps.setString(5, student.getEmail());
		ps.setString(6, student.getMobileNo());
		int status = ps.executeUpdate();
		return status;

	}

	@Override
	public int updateStudent(Student student) throws SQLException, InvalidStudentDataException {
		Connection con = DBPropertyUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select * from student where student_id=?");
		ps.setInt(1, student.getId());
		ResultSet rs=ps.executeQuery();
		int rows=0;
		while(rs.next()){
			rows++;
			}
		if(rows==0) { 
			int c=4;
			throw new InvalidStudentDataException(c);
			}
		 ps = con.prepareStatement(
				"update student set first_name=?,last_name=?,date_of_birth=?,email=?,phone_number=? where student_id=?");
		ps.setString(1, student.getFirstName());
		ps.setString(2, student.getLastName());
		ps.setString(3, student.getDateOfBirth());
		ps.setString(4, student.getEmail());
		ps.setString(5, student.getMobileNo());
		ps.setInt(6, student.getId());
		int status = ps.executeUpdate();
		return status;
	}
   public  void getStudentById(int id) throws  StudentNotFoundException, SQLException
   {
	    Connection con = DBPropertyUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select * from student where student_id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		int rows=0;
		while(rs.next())
		{
			System.out.println("Student_id: "+rs.getInt("student_id")+"  first_name: "+rs.getString("first_name")+"  last_name: "+rs.getString("last_name")+
					"  Email: "+rs.getString("email")+"  DOB: "+rs.getString("date_of_birth")+"  Contact No: "+rs.getString("phone_number"));
			rows++;
		}
		if(rows==0)
		{
			throw new StudentNotFoundException(id);
		}	
   }
	public int makePayment(Payment payment) throws SQLException {
		Connection conn=DBPropertyUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement(""
				+ "insert into Payments(payment_id,student_id,amount,payment_date) values(?,?,?,?)");
		ps.setInt(1, payment.getPayment_id());
		ps.setInt(2, payment.getStudent_id());
		ps.setInt(3, payment.getAmount());
		ps.setString(4, payment.getPayment_date());
		int res=ps.executeUpdate();
		return res;	
	}
	public int enroll(Enrollments e) throws SQLException, InvalidEnrollmentDataException {
		Connection con = DBPropertyUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"select * from student where student_id=?");
		ps.setInt(1, e.getStudent_id());
		ResultSet rs=ps.executeQuery();
		int rows=0;
		while(rs.next()){
			rows++;
			}
		if(rows==0) { 
			throw new InvalidEnrollmentDataException(e.getStudent_id());
			}
		ps=con.prepareStatement(""
				+ "insert into Enrollments(enrollment_id,student_id,course_id,enrollment_date) values(?,?,?,?)");
		ps.setInt(1, e.getEnrollment_id());
		ps.setInt(2, e.getStudent_id());
		ps.setInt(3, e.getCourse_id());
		ps.setString(4, e.getDate());
		int res=ps.executeUpdate();
		return res;	
		
	}

	@Override
	public List<Enrollments> getEnrollments(int id) throws SQLException {
		List<Enrollments> res=new ArrayList<>();
		Connection conn=DBPropertyUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement("select *from enrollments where student_id=?");
		ps.setInt(1, id);
		 ResultSet rs=ps.executeQuery();  
		 while(rs.next()) {
			 Enrollments enrollments=new Enrollments();
			 enrollments.setCourse_id(rs.getInt("course_id"));
			 enrollments.setEnrollment_id(rs.getInt("enrollment_id"));
			 enrollments.setStudent_id(rs.getInt("student_id"));
			 enrollments.setDate(rs.getString("enrollment_date"));
			 res.add(enrollments);
		 }
		
		return res;
	}

}
