package com.sis.main;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws Exception {

		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Welcome to Student Management System....!!!\n");
			while (true) {
				System.out.println("\nDashboard\n"
						+ "  1.Student Functionalities\n"
						+ "  2.Teacher Details\n"
						+ "  3.Course Details\n"
						+ "  4.Enrollment Details\n"
						+ "  5.Payment Details\n");
				int choice = s.nextInt();
				if (choice == 1) {
					StudentController student_controller = new StudentController();
					System.out.println("Choose the fucntionalites:");
					System.out.println("1:Add a new Student\n" + "2:Update student details based on student_id\n"
							+ "3:Get student by ID\n"
							+ "4:Make Payment\n"
							+ "5:Enroll in a Course\n"
							+ "6:Get all Enrollments\n");
					int choose = s.nextInt();
					if (choose == 1) {
						student_controller.addStudent();
					} else if (choose == 2) {
						student_controller.updateStudent();
					} 
					else if (choose == 3) {
						student_controller.getStudentByID();
					}
					else if (choose == 4) {
						student_controller.makePayment();
					}
					else if (choose == 5) {
						student_controller.enroll();;
					}
					else if(choose==6)
					{
						student_controller.getAllEnrollments();
					}
						else {
						System.out.println("Enter correct choice");
					}

				} else if (choice == 2) {
					TeacherController teacher_controller = new TeacherController();
					System.out.println("Choose the fucntionalites:");
					System.out.println("1:Add a new Teacher\n" + 
					                   "2:Get Deatils of teacher by teacher_id\n"
					                   + "3:Add a Course\n");
					int choose = s.nextInt();
					if (choose == 1) {
						teacher_controller.addTeacher();
					} else if (choose == 2) {
						teacher_controller.getTeacherById();
					}else if(choose==3)
					{
						teacher_controller.addcourse();
					}
					else {
						System.out.println("Enter correct choice");
					}

				} else if (choice == 3) {
					CourseController course_controller = new CourseController();
					System.out.println("Choose the fucntionalites:");
					System.out.println("1:Add a new course\n" + ""
							+ "2:Update an existing course\n"
							+ "3:Get Teacher by cousre id\n"
							+ "4:Display info about a course\n"
							+ "5:Get Enrollments by course id\n");
					int choose = s.nextInt();
					if (choose == 1) {
						course_controller.addCourse();
					}
					else if (choose == 2) {
						course_controller.updateCourseInfo();
					}
					else if (choose == 3) {
						course_controller.getTeacherByCourseId();;
					}else if (choose == 4) {
						course_controller.displayCourseInfo();
					}
					else if (choose == 5) {
						course_controller.getEnrollmentsByCourseId();;
					}
					else {
						System.out.println("Enter correct choice");
					}
				} else if (choice == 4) {
					EnrollmentController enrollment_controller = new EnrollmentController();
					System.out.println("Choose the fucntionalites:");
					System.out.println(""
							+ "1:Get student name based on enrollment_id\n"
							+ "2:Get Course name based on enrollment_id\n");
					int choose = s.nextInt();
					if (choose == 1) {
						enrollment_controller.getStudent();
					} else if (choose == 2) {
						enrollment_controller.getCourse();
					} else {
						System.out.println("Enter correct choice");
					}
				} else if (choice == 5) {
					PaymentController payment_controller = new PaymentController();
					System.out.println("Choose the fucntionalites:");
					System.out.println("1:Get payment Deatails\n");
					int choose = s.nextInt();
					if(choose==1)
					{
						payment_controller.getPaymentDetails();
					}
					
				} else {
					break;
				}
			}
		}

	}

}
