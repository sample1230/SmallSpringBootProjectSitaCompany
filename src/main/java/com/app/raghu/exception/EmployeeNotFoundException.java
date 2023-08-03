package com.app.raghu.exception;
@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException {
	public   EmployeeNotFoundException () {
		super();
		
	}
	public   EmployeeNotFoundException (String message) {
		super(message);

}
}