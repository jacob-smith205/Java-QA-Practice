
import java.util.ArrayList;
import java.util.Scanner;

public class TestCaseRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ArrayList<TestCase> testCases = new ArrayList<>();
		
		testCases.add(new TestCase("UserName", "Admin"));
		
		System.out.println(testCases.get(0).getTestName());

	}

}
