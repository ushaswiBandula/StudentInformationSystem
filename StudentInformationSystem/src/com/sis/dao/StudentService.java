package com.sis.dao;

import java.sql.SQLException;
import java.util.List;

import com.sis.entities.Enrollments;
import com.sis.entities.Student;
import com.sis.exceptions.InvalidStudentDataException;
import com.sis.exceptions.StudentNotFoundException;

public interface StudentService {

	public int save(Student student) throws SQLException, InvalidStudentDataException;

	public void getStudentById(int id) throws StudentNotFoundException, SQLException;

	public int updateStudent(Student student) throws SQLException, InvalidStudentDataException;
	
	public List<Enrollments> getEnrollments(int id) throws SQLException;

}
