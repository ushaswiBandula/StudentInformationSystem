package com.sis.exceptions;

public class StudentNotFoundException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(int id)
    {
    	System.out.println("Student with id:"+id+" Not found");
    	System.out.println("Please enter correct id..!!");
    }
}
