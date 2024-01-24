package com.sis.exceptions;

public class TeacherNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TeacherNotFoundException(int id)
	{
		System.out.println("Teacher with id:"+id+" Not found");
    	System.out.println("Unable to add a course\nPlease enter correct id..!!");
	}

}
