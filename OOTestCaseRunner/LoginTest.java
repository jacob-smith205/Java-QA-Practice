
public class LoginTest extends TestCase{
	private static int testNumber = 1;
	private String username; 
	private String password;
	private String testUsername;
	private String testPassword;
	
	public LoginTest() {
		super.setTestName("LoginTest " + testNumber);
		testNumber++;
	}
	
	public int getTestNumber() {
		return LoginTest.testNumber;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getTestUsername () {
		return this.testUsername;
	}
	
	public String getTestPassword() {
		return this.testPassword;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setTestPassword(String testPassword) {
		this.testPassword = testPassword;
	}
	
	public void setTestUsername(String testUsername) {
		this.testUsername = testUsername;
	}
	
	public void check() {
		boolean pass = this.username.equals(this.testUsername)&& this.password.equals(this.testPassword);
		String actual = (pass) ? "PASS" : "FAIL";
		super.setActualResults(actual);
		super.setStatus();
	}
	
	public void printTest() {
		System.out.println("Test: " + super.getTestName());
		System.out.println("Tested Against: ");
		System.out.println("  Username : " + this.username);
		System.out.println("  Password : " + this.password);
		System.out.println("Expected Results: " + super.getExpectedResults());
		System.out.println("Actual Results: " + super.getActualResults());
		System.out.println("Status: " + super.getStatus());
		System.out.println();
	}
	
	public void printDetailedReport() {
		System.out.println("Expected:");
		System.out.println("Username: " + this.username);
		System.out.println("Password: " + this.password);
		System.out.println();
		
		System.out.println("Input:");
		System.out.println("Username: " + this.testUsername);
		System.out.println("Password: " + this.testPassword);
		System.out.println();
		
		System.out.println("Output: " + super.getStatus());
		
	}
}
