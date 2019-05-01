package studentDatabaseApplication;

import java.util.Scanner;

public class Student {

	// private variables for encapsulation purposes.
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private int tuitionRemaining = 0;
	private String courses = "";
	// this value is always the same across the class, 
	// the value is not specific to an object but is for the class not the instance of the object
	private static int id = 1000;
	private static int tuition = 600;
	
	
	//constructor: prompt user to enter students name and year
	public Student() {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter students first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter students surname: ");
		this.lastName = in.nextLine();
		
		System.out.print("1 - Infant\n2 - for Junior\n3 for Secondary \n4 for College \nEnter students grade level: ");
		this.gradeYear = in.nextInt();
		
		setStudentID();
				
	}
	
	// generate unique 5 digit ID with the first number being their grade level.
	private void setStudentID() {
		// grade level + ID
		this.studentID =  gradeYear + "" +id;
		
		// increments the static value of ID to make sure no recurring ID's can occur.
		id++;
	}
	
	
	// enroll student on a course
	public void enroll() {
		// loop to allow users to enroll to multiple courses. exit 0 is submitted.
		do {
			System.out.print("Enter course to enroll (Type Q to finish): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			
			
			// if the value input is not Q then enroll onto the course adding this to the list of courses
			// and increasing the tuition that the student owes.
			if(!course.equals("Q")) {
				
				courses = courses + "\n" + course;
				tuitionRemaining = tuitionRemaining + tuition;
				
				
			// else breaks out of the loop.	
			} else {
				
				break; 
				
			}
			
		} while (1 !=0);
		
		System.out.println("Enrolled On: " + courses);
		
	}
	
	// view balance of tuition
	public void viewBalance() {
		System.out.println("Your Balance is: £" + tuitionRemaining);
	}
	
	// pay the tuition
	public void payTuition() {
		//shows current tuition owed
		viewBalance();
		
		System.out.println("Enter your payment: £");
		// takes an input from the user to determing the payment to process.
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		
		tuitionRemaining = tuitionRemaining - payment;
		System.out.println("Thank you for your payment of: £" + payment);
		// shows new balance.
		viewBalance();
		
	}
	
	// return name, ID, what courses they are enrolled on and the balance remaining on their tuition.
	public String showInfo() {
		return  "-------Current Details -------" + "\nName: " + firstName + " " + lastName +
				"\nGrade Level: " + gradeYear +
				"\nStudent ID: " + studentID +
				"\nCourses Enrolled: " + courses +
				"\nBalance: £" + tuitionRemaining;
	}
	
	
}
