package com.sis.exceptions;

public class CourseNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CourseNotFoundException(int id)
    {
    	System.out.println("Course with id:"+id+" Not found");
    	System.out.println("Please enter correct id..!!");
    }

}
