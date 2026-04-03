
public class TestCase {
	private String testName;
	private String expectedResults;
	private String actualResults;
	private String status;
	
	public TestCase() {
		this.testName = "";
		this.expectedResults = "";
		this.actualResults = "";
		this.status = "";
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
	
	public void setStatus() {
		this.status = (this.actualResults.equals(this.expectedResults)) ? "Pass" : "Fail";
	}
	
	public void printTest() {
		System.out.println("Test: " + this.testName);
		System.out.println("Expected Results: " + this.expectedResults);
		System.out.println("Actual Results: " + this.actualResults);
		System.out.println("Status: " + this.status);
		System.out.println();
	}
	

}
