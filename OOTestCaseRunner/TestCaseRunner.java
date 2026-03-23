
import java.util.*;

public class TestCaseRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//ArrayList<TestCase> testCases = new ArrayList<>();
		//String expectedResults = "";
		//String actualResults = "";
		//String status = "";
		String selectAnotherTest;
		
		boolean active = true;
		int testCase = 0;
		
		//run program while active = true;
		while (active) {
			displayMenu();
			
			//get input from user on what test to complete.
			
			try {
				testCase = input.nextInt();
				input.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Invalid selection, input must be a number.");
				
				active = false;
			}
			
			//this switch statement will call the method of the test gotten from the user
			switch (testCase) {
				case 1 : 
					runLoginTest(input);
					break;
				default : 
					System.out.println("Exiting Program");
					active = false;
			}
			
			System.out.println("Do you wish to conduct another test? Y or N");
			selectAnotherTest = input.nextLine().toUpperCase();
			
			if (selectAnotherTest.equals("N")) {
				active = false;
			}
		}
		
		input.close();
	}
	
	// method displays the initial menu
	public static void displayMenu() {
		System.out.println("Select a Test Case:");
		System.out.println("+++++++++++++++++++");
		System.out.println();
		System.out.println("1. Login");
		System.out.println("2. Search");
		System.out.println("3. Checkout");
		System.out.println("4. Exit");
	}
	
	// method runs the login test;
	public static void runLoginTest(Scanner input) {
		String expectedResults;
		String username;
		String password;
		String testUsername;
		String testPassword;
		boolean manual;
		
		System.out.println("Login Test");
		System.out.println("----------");
		
		// get input from the user on if the test is expecting successful logins, failed, or mix;
		System.out.println("Will you test Succesful or failed logins? Or a mix?");
		System.out.print("Type Success, fail, or mix: ");
		expectedResults = input.nextLine();
		System.out.println();
		
		System.out.print("Enter the Username that is going to be tested against : ");
		username = input.nextLine();
		System.out.println();
		
		System.out.print("Enter the Password that is going to be tested against : ");
		password = input.nextLine();
		System.out.println();
		
		System.out.println("Will the test be entered manually or from a file?");
		System.out.print("Press M for manual and F for file : ");
		manual = input.nextLine().toUpperCase().equals("M");
		System.out.println();
		
		if (manual) {
			System.out.print("Enter the username to test : ");
			testUsername = input.nextLine();
			System.out.println();
			
			System.out.print("Enter the password to test: ");
			testPassword = input.nextLine();
			System.out.println();
			
			
			
			//System.out.println("Login Test " + result);
			System.out.println();
		}
		
	}

}
