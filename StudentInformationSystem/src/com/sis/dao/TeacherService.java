package com.sis.dao;

import java.sql.SQLException;

import com.sis.entities.Teacher;

public interface TeacherService {
	public int saveTecaher(Teacher teacher) throws SQLException;

	public int updateTeacher(Teacher teacher) throws SQLException;
	
	public Teacher getDetailsById(int id) throws SQLException;

}
