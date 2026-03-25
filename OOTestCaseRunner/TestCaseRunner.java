
import java.util.*;

public class TestCaseRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String selectAnotherTest;
		boolean validInput = false;
		int numberOfOptions = 4;
		
		boolean active = true;
		int testCase = 0;
		
		//run program while active = true;
		while (active) {
			displayMenu();
			
			//get input from user on what test to complete.
			while (!validInput) {
				try {
					testCase = input.nextInt();
					if (testCase < 1 || testCase > numberOfOptions) {
						System.out.println("Invalid Selection, Please Try Again : ");
					} else {
						validInput = true;
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid selection, input must be a number.");
					System.out.print("Please Try Again : ");
					input.next();
					System.out.println();
				}
				
			} 
			input.nextLine(); // clear input from above, if not, it will cause an ininate loop during manual test
			
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
	
	// method starts the login test to verify if manual or from a file takes scanner as a parameter.
	public static void runLoginTest(Scanner input) {
		
		String testType;
		boolean manual;
		
		System.out.println("Login Test");
		System.out.println("----------");
		
		System.out.println("Press 'M' to run a test manually and 'F' to run from a file : ");
		testType = input.nextLine().toUpperCase();
		System.out.println();
		
		while (!testType.equals("M") && !testType.equals("F")) {
			System.out.print("Invalid input: Type 'M' for manual and 'F' for a file. ");
			testType = input.nextLine().toUpperCase();
			System.out.println();
		}
		
		manual = (testType.equals("M")) ? true : false;
		
		if (manual) {
			runManualLoginTest(input);
		}
		
		
		
	}
	
	/*
	 * runs the manual login test	
	 * @ param input is a scanner that is passed to the method. 
	 */
	public static void runManualLoginTest(Scanner input) {
		String expectedResults;
		String actualResults;
		String status;
		String username;
		String password;
		String testUsername;
		String testPassword;
		boolean runManualTest = true;
		int testNumber = 1;
		ArrayList<LoginTest> loginTestList = new ArrayList<LoginTest>();
		
		// run tests
		while (runManualTest) {
			// get input from the user on if the test is expecting successful logins, failed, or mix;
			System.out.println("Type the result that are expected. PASS OR FAIL");
			expectedResults = input.nextLine().toUpperCase();
			System.out.println();
					
			System.out.print("Enter the Username that is going to be tested against : ");
			username = input.nextLine();
			System.out.println();
					
			System.out.print("Enter the Password that is going to be tested against : ");
			password = input.nextLine();
			System.out.println();
			
			System.out.print("Enter the username that is going to be tested : ");
			testUsername = input.nextLine();
			System.out.println();
			
			System.out.print("Enter the password that is going to be tested : ");
			testPassword = input.nextLine();
			System.out.println();
			
			actualResults = (password.equals(testPassword) && username.equals(testUsername)) ? "PASS" : "FAIL";
			status = (expectedResults.equals(actualResults)) ? "Pass" : "Fail";
			
			loginTestList.add(new LoginTest(testNumber, expectedResults, actualResults, status, username, password, testUsername, testPassword));
			
			loginTestList.get(testNumber - 1).printTest();
			
			System.out.println("Press 'Y' to run another test : "); 
			String runAgain = input.nextLine();
			runManualTest = false;
		}
	}

}
