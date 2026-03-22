
import java.util.ArrayList;
import java.util.Scanner;

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
		while (active) {
			displayMenu();
			
			testCase = input.nextInt();
			input.nextLine();
			switch (testCase) {
				case 1 : 
					runLoginTest();
					break;
				default : 
					System.out.println("Exiting Program");
					active = false;
			}
			
			System.out.println("Do you wish to conduct another test? Y or N");
			selectAnotherTest = input.nextLine();
			
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
	public static void runLoginTest() {
		System.out.println("Login Test");
		System.out.println("----------");
		
		
	}

}
