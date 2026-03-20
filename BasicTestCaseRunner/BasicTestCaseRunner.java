import java.util.ArrayList;

public class BasicTestCaseRunner {

	public static void main(String[] args) {
		//This program is to create a list of test cases and run them
		ArrayList<String> testCase = new ArrayList<>();
		
		testCase.add("Login");
		testCase.add("Search");
		testCase.add("Checkout");
		
		for (String test : testCase) {
			System.out.println(test + ": Running");
		}

	}

}
