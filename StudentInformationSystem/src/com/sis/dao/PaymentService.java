package com.sis.dao;

import java.sql.SQLException;

import com.sis.exceptions.StudentNotFoundException;

public interface PaymentService {
	public void getPaymentDetails(int student_id) throws SQLException, StudentNotFoundException;

}
