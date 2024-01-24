package com.sis.entities;

public class Payment {
	private int payment_id;
	private int student_id;
	private int amount;
	private String payment_date;
    private Student student;
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Payment(int payment_id, int student_id, int amount, String payment_date, Student student) {
		super();
		this.payment_id = payment_id;
		this.student_id = student_id;
		this.amount = amount;
		this.payment_date = payment_date;
		this.student = student;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public Payment(int payment_id, int student_id, int amount, String payment_date) {
		super();
		this.payment_id = payment_id;
		this.student_id = student_id;
		this.amount = amount;
		this.payment_date = payment_date;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", student_id=" + student_id + ", amount=" + amount
				+ ", payment_date=" + payment_date + "]";
	}

}
