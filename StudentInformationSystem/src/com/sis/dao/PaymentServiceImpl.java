package com.sis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sis.exceptions.StudentNotFoundException;
import com.sis.util.DBPropertyUtil;

public class PaymentServiceImpl implements PaymentService {

	@Override
	public void getPaymentDetails(int student_id) throws SQLException, StudentNotFoundException {
		Connection con = DBPropertyUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(
              "select s.first_name,p.amount,p.payment_date from payments p join student s on s.student_id=p.student_id where s.student_id=?;"
              );
		ps.setInt(1, student_id);
		ResultSet rs=ps.executeQuery();
		int row=0;
		while(rs.next())
		{
			System.out.println(rs.getString("first_name")+" "+rs.getString("amount")+" "+rs.getString("payment_date"));
			row++;
		}
		if(row==0)
		{
			throw new StudentNotFoundException(student_id);
		}
		
	}

	

}
