package com.sis.entities;

import java.util.List;

public class Course {
	private int course_id;
	private String course_name;
	private int course_code;
	private int teacher_id;
	List<Enrollments> enrollments;

	public List<Enrollments> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollments> enrollments) {
		this.enrollments = enrollments;
	}

	public int getCourse_id() {
		return course_id;
	}

	public Course(int course_id, String course_name, int course_code, int teacher_id, List<Enrollments> enrollments) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_code = course_code;
		this.teacher_id = teacher_id;
		this.enrollments = enrollments;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getCourse_code() {
		return course_code;
	}

	public void setCourse_code(int course_code) {
		this.course_code = course_code;
	}
	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public Course(int course_id, String course_name, int course_code, int teacher_id) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_code = course_code;
		this.teacher_id = teacher_id;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_code=" + course_code
				+ ", teacher_id=" + teacher_id + "]";
	}

	

}
