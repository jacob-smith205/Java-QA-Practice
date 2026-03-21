
import java.util.ArrayList;
import java.util.Scanner;

public class TestCaseRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//ArrayList<TestCase> testCases = new ArrayList<>();
		String expectedResults = "";
		//String actualResults = "";
		//String status = "";
		
		boolean active = true;
		int testCase = 0;
		while (active) {
			System.out.println("Select a Test Case:");
			System.out.println("+++++++++++++++++++");
			System.out.println();
			System.out.println("1. Login");
			System.out.println("2. Search");
			System.out.println("3. Checkout");
			System.out.println("4. Exit");
			
			testCase = input.nextInt();
			if (testCase == 4) active = false;
			input.nextLine();
			
			switch (testCase) {
				case 1 : // sets up the login test object.
					System.out.println("Login Test");
					System.out.println("__________");
					System.out.println("Are there expected results? Y or N");
					String expected = input.nextLine();
					if (expected.toLowerCase().equals("y")) {
						System.out.println("What is the expected result(s)");
						expectedResults = input.nextLine();
					} else {
						expectedResults = "Unknown";
					}
					System.out.print("Do you know the username and password to be used? Y or N");
					if (input.nextLine().toUpperCase().equals("Y")) {
						System.out.println();
						System.out.print("What is the username that is to be tested against? ");
						String username = input.nextLine();
						System.out.println();
						System.out.print("What is the password that is to be tested against? ");
						String password = input.nextLine();
						System.out.println();
						
						LoginTest test = new LoginTest(expectedResults, username, password);
						test.printTest();
					} else {
						LoginTest test = new LoginTest(expectedResults);
						test.printTest();
					}
					break;
					
					
				default : active = false;
			}
			
		}
		
		input.close();
	}

}
