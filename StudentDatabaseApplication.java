package studentDatabaseApplication;

import java.util.Scanner;

public class StudentDatabaseApplication {

	public static void main(String[] args) {
		
		// ask how many new users will be added
		System.out.println("Enter number of new students to enroll: ");
		Scanner in = new Scanner(System.in);
		
		// Create n number of new students
		int numOfStudents = in.nextInt();
		Student[] students = new Student[numOfStudents];
		
		for (int n = 0; n < numOfStudents; n++) {
			Student stu = new Student();
			stu.enroll();
			stu.payTuition();
			System.out.println(stu.showInfo());
			
			// splits prints in console to show where one students details end and another begins.
			if(numOfStudents != n +1) {
				System.out.println("-------------------NEXT STUDENT--------------------");
			}
			
			
		}
		
		

	}

}
