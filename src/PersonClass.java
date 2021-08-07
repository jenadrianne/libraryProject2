
public class PersonClass implements personPolicies {
	private String firstName;
	private String lastName; 
	private String emailAddress; 
	private int personId;
	private int userType;
	
	/**
	 * Default constructor
	 */
	public PersonClass() {
	}
	/**
	 * Custom constructor
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param personId
	 */
	public PersonClass(String firstName, String lastName, String emailAddress, int personId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.personId = personId;
		if(validateEmailAddres(emailAddress)) {
			this.emailAddress = emailAddress;
		}else {
			this.emailAddress = ""; 
			System.out.println("Not a valid email address"); 
		}
	}

	//getters and setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	/**
	 * Validate email Address 
	 */
	@Override
	public boolean validateEmailAddres(String email) {
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+[a-zA-Z0-9]{2,4}$";
		return email.matches(regex);
	
		/*^ matches the starting of the sentence.
		[a-zA-Z0-9+_.-] matches one character from the English alphabet (both cases), digits, “+”, “_”, “.” and, “-” before the @ symbol.
		+ indicates the repetition of the above-mentioned set of characters one or more times.
		@ matches itself.
		[a-zA-Z0-9.-] matches one character from the English alphabet (both cases), digits, “.” and “–” after the @ symbol.
		$ indicates the end of the sentence.*/
	}	
}
