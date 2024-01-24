package com.sis.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.sis.dao.PaymentServiceImpl;
import com.sis.exceptions.StudentNotFoundException;

public class PaymentController {
	PaymentServiceImpl payment_service = new PaymentServiceImpl();
	Scanner s = new Scanner(System.in);
    public void getPaymentDetails() throws SQLException, StudentNotFoundException
    {
    	System.out.println("Enter the student_id\n");
    	int sid=s.nextInt();
    	payment_service.getPaymentDetails(sid);
    }

}
