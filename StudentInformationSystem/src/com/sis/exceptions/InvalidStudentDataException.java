package com.sis.exceptions;

public class InvalidStudentDataException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidStudentDataException(int id)
    {
		if(id==1)
		{
    	System.out.println("Please Enter the mobile number in 10 digits only");
		}
		else if(id==2)
		{
		    	System.out.println("Please Enter the email in a correct format");
		}
		else if(id==3)
		{
			System.out.println("please Enter the date of birth in DD-MM-YYYY Format only");
			System.out.println("Please try again");
		}
		else if(id==4)
		{
			System.out.println("Please Enter an existing student id");
		}
    }
	
}
