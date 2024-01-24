package com.sis.dao;

import java.sql.SQLException;

public interface EnrollmentService {
	public void getStudent(int enrollment_id)throws SQLException;
	public void getCourse(int enrollment_id)throws SQLException;
}
