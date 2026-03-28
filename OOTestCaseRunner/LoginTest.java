
public class LoginTest extends TestCase{
	private int testNumber;
	private String username; 
	private String password;
	private String testUsername;
	private String testPassword;
	
	public LoginTest(int testNumber, String expected, String actual, String status, String username, String password, String testUsername, String testPassword) {
		super("Login", expected, actual, status);
		this.username = username;
		this.password = password;
		this.testPassword = testPassword;
		this.testUsername = testUsername;
		this.testNumber = testNumber;
	}
	
	public LoginTest(int testNumber, String expected, String username, String password) {
		this(testNumber, expected, "Unknown", "Unknown", username, password, "unknown", "unknown");
	}
	
	public LoginTest(int testNumber, String expected) {
		this(testNumber, expected, "Unknown", "Unknown", "TBD", "TBD", "unknown", "unknown");
	}
	
	public LoginTest() {
		this(0, "Unknown", "Unknown", "Unknown", "TBD", "TBD", "unknown", "unknown");
	}
	
	public String getTestName() {
		return super.getTestName();
	}
	
	public int getTestNumber() {
		return this.testNumber;
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
	
	public void setTestNumber(int testNumber) {
		this.testNumber = testNumber;
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
	
	public void printTest() {
		System.out.println("Test: " + super.getTestName() + " " + this.testNumber);
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
