package com.sis.dao;

import java.sql.SQLException;

import com.sis.entities.Course;
import com.sis.exceptions.TeacherNotFoundException;

public interface CourseService {
	public int assignCourse(Course course) throws SQLException, TeacherNotFoundException;
    public int updateCourse(Course course) throws SQLException;
    public int displayCourseInfo(int course_id) throws SQLException, Exception;
    public int getTeacherByCourseId(int course_id)throws Exception;
}
