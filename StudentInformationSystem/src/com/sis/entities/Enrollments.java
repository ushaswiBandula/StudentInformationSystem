package com.sis.entities;

public class Enrollments {
	private int enrollment_id;
	private int student_id;
	private int course_id;
	private String date;
    private Student student;
	public Enrollments(int enrollment_id, int student_id, int course_id, String date, Student student) {
		super();
		this.enrollment_id = enrollment_id;
		this.student_id = student_id;
		this.course_id = course_id;
		this.date = date;
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getEnrollment_id() {
		return enrollment_id;
	}

	public void setEnrollment_id(int enrollment_id) {
		this.enrollment_id = enrollment_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Enrollments(int enrollment_id, int student_id, int course_id, String date) {
		super();
		this.enrollment_id = enrollment_id;
		this.student_id = student_id;
		this.course_id = course_id;
		this.date = date;
	}

	public Enrollments() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Enrollments [enrollment_id=" + enrollment_id + ", student_id=" + student_id + ", course_id=" + course_id
				+ ", date=" + date + "]";
	}

}
