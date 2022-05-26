package emailsapp;

import java.util.Scanner;

public class Email {
	
	//variable setup
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPassLength = 10;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	//Constructor to receive first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
//		System.out.println("EMAIL CREATED: " + this.firstName+ " " + this.lastName);
		
		this.department = setDepartment();
//		System.out.println("Department "+ this.department);
		
		//Return random password
		this.password = randPass(defaultPassLength);
//		System.out.println("Your Password: " + this.password);
		
		//Generate Email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix; 
//		System.out.println("Your email is: " + email);
	}
	
	//Check the departments
	private String setDepartment() {
		System.out.print("SELECT DEPARTMENT FOR: " + firstName + " " + lastName + "\n 1:Sales\n 2:Development\n 3:Accounting\n 0:None\n INPUT:");
		Scanner in = new Scanner(System.in);
		int depSelection = in.nextInt();
		if (depSelection == 1) {
			return "sales";
		} else if (depSelection == 2) {
			return "devs";
		} else if (depSelection == 3) {
			return "accounts";
		} else {
			return "";
		}
		
	}
	
	//Generate a random password
	private String randPass(int length) {
		String passSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz!£$^&*()@~#|";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int)(Math.random() * passSet.length());
			password[i] = passSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change the password
	public void changePass(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String printInfo() {
		return "NAME: " + firstName + " " + lastName + "\n" +
				"COMPANY EMAIL: " + email + "\n" +
				"PASSWORD: " + password + "\n" +
				"MAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
