
public class LoginTest extends TestCase{
	private String username; 
	private String password;
	
	public LoginTest(String expected, String actual, String status, String username, String password) {
		super("Login", expected, actual, status);
		this.username = username;
		this.password = password;
	}
	
	public LoginTest(String expected, String username, String password) {
		this(expected, "Unknown", "Unknown", username, password);
	}
	
	public LoginTest(String expected) {
		this(expected, "Unknown", "Unknown", "TBD", "TBD");
	}
	
	public LoginTest() {
		this("Unknown", "Unknown", "Unknown", "TBD", "TBD");
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
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
}
