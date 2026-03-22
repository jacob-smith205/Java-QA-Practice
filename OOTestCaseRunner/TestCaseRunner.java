
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
			displayMenu();
			
			testCase = input.nextInt();
			if (testCase == 4) active = false;
			input.nextLine();
			
		}
		
		input.close();
	}
	
	public static void displayMenu() {
		System.out.println("Select a Test Case:");
		System.out.println("+++++++++++++++++++");
		System.out.println();
		System.out.println("1. Login");
		System.out.println("2. Search");
		System.out.println("3. Checkout");
		System.out.println("4. Exit");
	}

}
