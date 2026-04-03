
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
		
		try {
			if (manual) {
				runManualLoginTest(input);
			} else {
				runAutoTest(input);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/*
	 * runs the manual login test	
	 * @ param input is a scanner that is passed to the method. 
	 */
	public static void runManualLoginTest(Scanner input) throws FileNotFoundException {
		boolean runManualTest = true;
		ArrayList<LoginTest> loginTestList = new ArrayList<LoginTest>();
		
		// run tests
		while (runManualTest) {
			// get input from the user on if the test is expecting successful logins, failed, or mix;
			
			String expectedResults;
			String username;
			String password;
			String testUsername;
			String testPassword;
			LoginTest test = new LoginTest();			
			
			System.out.println("Type the result that are expected. PASS OR FAIL");
			expectedResults = input.nextLine().toUpperCase();
			System.out.println();
			test.setExpectedResults(expectedResults);
					
			System.out.print("Enter the Username that is going to be tested against : ");
			username = input.nextLine();
			System.out.println();
			test.setUsername(username);
					
			System.out.print("Enter the Password that is going to be tested against : ");
			password = input.nextLine();
			System.out.println();
			test.setPassword(password);
			
			System.out.print("Enter the username that is going to be tested : ");
			testUsername = input.nextLine();
			System.out.println();
			test.setTestUsername(testUsername);
			
			System.out.print("Enter the password that is going to be tested : ");
			testPassword = input.nextLine();
			System.out.println();
			test.setTestPassword(testPassword);
			
			test.check();			
			
			loginTestList.add(test);
			
			test.printTest();
			
			System.out.println("Press 'Y' to run another test : "); 
			String runAgain = input.nextLine().toUpperCase();
			runManualTest = (runAgain.equals("Y")) ? true : false;
		}
		
		System.out.println("Would you like to save your results to a file? Y or N"); 
		if (input.next().toUpperCase().equals("Y")) {
			saveTest(loginTestList, input);
		}
		
	}
	
	public static void runAutoTest(Scanner input) throws FileNotFoundException {
		String passwords;
		String usernames;
		boolean userFileFound = false;
		boolean passFileFound = false;
		Scanner userReader = null;
		Scanner passReader = null;
		ArrayList<String> usernameList = new ArrayList<>();
		ArrayList<String> passwordList = new ArrayList<>();
		
		
		System.out.println("Running Login Test from a file ");
		System.out.println();
		
		while (!userFileFound) {
			try {
				System.out.print("Enter the file name that contains the test usernames");
				usernames = input.next();
				File userFile = new File(usernames);
				userReader = new Scanner(userFile);
				userFileFound = true;
			} catch (FileNotFoundException e) {
				System.out.println("File not found, try again. ");
			}
		}
			
			while (!passFileFound) {
				try {
					System.out.print("Enter the file name that contains the test passwords : ");
					passwords = input.next();
					File passFile = new File(passwords);
					passReader = new Scanner(passFile);
					System.out.println();
					passFileFound = true;
				} catch (FileNotFoundException e) {
					System.out.println("File not found, try again. ");
				}
			/*
			 * There is definitely a way to have one test method that gets passed the fileScanners
			 * and can run both manual and auto.
			 */
		}
			
		while (userReader.hasNextLine()) {
			usernameList.add(userReader.nextLine());
		}
		while (passReader.hasNextLine()) {
			passwordList.add(passReader.nextLine());
		}
		passReader.close();
		userReader.close();
		
		System.out.println(usernameList);
		System.out.println(passwordList);
		
	}
	
	public static void saveTest(ArrayList<LoginTest> testInfo, Scanner input) throws FileNotFoundException {
		String fileName;
		System.out.println("What name would you like to save the file as? ");
		fileName = input.next();
		String testName = testInfo.get(0).getTestName();
		
		try (PrintWriter fileWriter = new PrintWriter(fileName)) {
			fileWriter.println(testName + " Results");
			fileWriter.println("==============");
			for (int i = 0; i < testInfo.size(); i++) {
				fileWriter.println();
				fileWriter.println("Test: " + testName + " " + testInfo.get(i).getTestNumber());
				fileWriter.println("Expected : ");
				fileWriter.println("   Username : " + testInfo.get(i).getUsername());
				fileWriter.println("   Password : " + testInfo.get(i).getPassword());
				fileWriter.println("   Result   : " + testInfo.get(i).getExpectedResults());
				fileWriter.println("Actual   : ");
				fileWriter.println("   Username : " + testInfo.get(i).getTestUsername());
				fileWriter.println("   Password : " + testInfo.get(i).getTestPassword());
				fileWriter.println("   Result   : " + testInfo.get(i).getActualResults());
				fileWriter.println("Status : " + testInfo.get(i).getStatus());				
			}
		}
		
		
		
	}

}
