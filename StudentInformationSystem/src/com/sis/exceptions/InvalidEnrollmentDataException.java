package com.sis.exceptions;

public class InvalidEnrollmentDataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidEnrollmentDataException(int id)
    {
    	System.out.println("Student with id:"+id+" Not found");
    	System.out.println("Please enter correct id..!!");
    }

}
