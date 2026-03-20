
public class TestCase {
	private String testName;
	private String expectedResults;
	private String actualResults;
	private String status;
	
	public TestCase(String testName, String expected, String actual, String status) {
		this.testName = testName;
		this.expectedResults = expected;
		this.actualResults = actual;
		this.status = status;
	}
	
	public TestCase(String testName, String expected) {
		this(testName, expected, "Unknown", "Unknown");
	}
	
	public TestCase() {
		this("No Test Set", "Nothing Expected", "Unknown", "Unknown");
	}
	
	public String getTestName() {
		return this.testName;
	}
	
	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	public String getExpectedResults() {
		return this.expectedResults;
	}
	
	public void setExpectedResults(String expected) {
		this.expectedResults = expected;
	}
	
	public String getActualResults() {
		return this.actualResults;
	}
	
	public void setActualResults(String actual) {
		this.actualResults = actual;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void printTest() {
		System.out.println("Test: " + this.testName);
		System.out.println("Expected Results: " + this.expectedResults);
		System.out.println("Actual Results: " + this.actualResults);
		System.out.println("Status: " + this.status);
		System.out.println();
	}
	

}
