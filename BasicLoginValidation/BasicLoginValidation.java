// this is a basic program to validate login expected vs entered

import java.util.Scanner;
public class BasicLoginValidation {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String expectedUsername = "admin";
		String expectedPassword = "password";
		
		System.out.print("Enter UserName: ");
		String enteredUsername = input.next();
		System.out.println();
		
		System.out.print("Enter Password: "); 
		String enteredPassword = input.next();
		System.out.println();
		
		System.out.println("Expected:");
		System.out.println("Username: " + expectedUsername);
		System.out.println("Password: " + expectedPassword);
		System.out.println();
		
		System.out.println("Input:");
		System.out.println("Username: " + enteredUsername);
		System.out.println("Password: " + enteredPassword);
		System.out.println();
		
		System.out.println("Output:");
		
		String result = "FAILED";
		if (expectedUsername.equals(enteredUsername) && expectedPassword.equals(enteredPassword)) {
			result = "PASSED";
		}
		
		System.out.print("Login Test " + result);
		
	}

}
