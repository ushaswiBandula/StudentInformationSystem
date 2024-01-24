package com.sis.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sis.dao.StudentServiceImpl;
import com.sis.entities.Enrollments;
import com.sis.entities.Payment;
import com.sis.entities.Student;
import com.sis.exceptions.InvalidEnrollmentDataException;
import com.sis.exceptions.InvalidStudentDataException;
import com.sis.exceptions.StudentNotFoundException;

public class StudentController {
	private Scanner s = new Scanner(System.in);
	private StudentServiceImpl student_service = new StudentServiceImpl();

	public void addStudent() throws SQLException, InvalidStudentDataException {
		System.out.println("Enter the New Student Details...");
		Student obj = new Student();
		System.out.println("Enter id:");
		int id = s.nextInt();
		s.nextLine();
		System.out.println("Enter firstname:");
		String fname = s.nextLine();
		System.out.println("Enter lastname:");
		String lname = s.nextLine();
		System.out.println("please Enter the date of birth in DD-MM-YYYY Format");
		System.out.println("Enter dateofbirth:");
		String dob = s.nextLine();
		System.out.println("Enter email:");
		String email = s.nextLine();
		System.out.println("Enter mobile no:");
		String mblno = s.nextLine();
		obj.setId(id);
		obj.setFirstName(fname);
		obj.setLastName(lname);
		obj.setDateOfBirth(dob);
		obj.setEmail(email);
		obj.setMobileNo(mblno);
		int res = student_service.save(obj);
		if (res == 1) {
			System.out.println("Student  " + obj.getFirstName() + "  registered Successfully");
		} else {
			System.out.println("Try again");
		}
	}

	public void updateStudent() throws SQLException, InvalidStudentDataException {
		System.out.println("Updating Student Details");
		Student obj = new Student();
		System.out.println("Enter id of the student:");
		int id = s.nextInt();
		System.out.println("Enter firstname:\n");
		String fname = s.next();
		System.out.println("Enter lastname:\n");
		String lname = s.next();
		System.out.println("Enter dateofbirth:\n");
		String dob = s.next();
		System.out.println("Enter email:\n");
		String email = s.next();
		System.out.println("Enter mobile no:\n ");
		String mblno = s.next();
		obj.setId(id);
		obj.setFirstName(fname);
		obj.setLastName(lname);
		obj.setDateOfBirth(dob);
		obj.setEmail(email);
		obj.setMobileNo(mblno);
		int res = student_service.updateStudent(obj);
		if (res == 1) {
			System.out.println("Student" + obj.getFirstName() + "updated Successfully");
		} else {
			System.out.println("Try again");
		}
	}

	public void getStudentByID() throws SQLException, StudentNotFoundException {
		System.out.println("Enter id of the student:");
		int id = s.nextInt();
		student_service.getStudentById(id);
	}

	public  void makePayment() throws SQLException {
		System.out.println("Pay Here...");
		System.out.println("Enter student id:");
		int student_id = s.nextInt();
		s.nextLine();
		System.out.println("Enter payment_id:");
		int pid = s.nextInt();
		System.out.println("Enter amount to be paid:");
		int amount = s.nextInt();
		s.nextLine();
		System.out.println("Enter date:");
		String payment_date = s.nextLine();
		Payment payment = new Payment(pid, student_id, amount, payment_date);
		int res = student_service.makePayment(payment);
		if (res == 1) {
			System.out.println("Payment of " + payment.getAmount() + " of student with id " + payment.getStudent_id()
					+ " done Successfully");
		} else {
			System.out.println("Try again");
		}
	}

	public void enroll() throws SQLException, InvalidEnrollmentDataException {
		StudentController sc=new StudentController();
		sc.makePayment();
		System.out.println("Enroll Here...");
		System.out.println("Enter student id:");
		int student_id = s.nextInt();
		s.nextLine();
		System.out.println("Enter Courseid:");
		int cid = s.nextInt();
		System.out.println("Enter Enrollment id:");
		int enroll_id = s.nextInt();
		s.nextLine();
		System.out.println("Enter date:");
		String date = s.nextLine();
		Enrollments e = new Enrollments(enroll_id, student_id, cid, date);
		int res = student_service.enroll(e);
		if (res == 1) {
			System.out.println("Enrolled in course " + e.getCourse_id() + " Successfully");
		} else {
			System.out.println("Try again");
		}
	}

	public void getAllEnrollments() throws SQLException {
		System.out.println("Fetching Enrollments...");
		System.out.println("Enter student id:");
		int student_id = s.nextInt();
		List<Enrollments> res = student_service.getEnrollments(student_id);
		for (Enrollments e : res) {
			System.out.println(e);
		}
	}
}
