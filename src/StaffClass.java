
public class StaffClass extends PersonClass{

	/*
	 * State Variables
	 */
	private int floorAssignment; 
	private String sectionAssignment;
	
	/**
	 * Default constructor
	 */
	public StaffClass() {
		
	}
	
	/**
	 * Custom Constructor
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param personId
	 * @param floorAssignment
	 * @param sectionAssignment
	 */
	public StaffClass(String firstName, String lastName, String emailAddress, int personId ,int floorAssignment, String sectionAssignment) {
		super(firstName, lastName, emailAddress, personId);
		super.setUserType(2);
		this.floorAssignment = floorAssignment; 
		this.sectionAssignment = sectionAssignment;
	}
	
	/*
	 * Getters and Setters 
	 */
	public int getFloorAssignment() {
		return floorAssignment;
	}
	public void setFloorAssignment(int floorAssignment) {
		this.floorAssignment = floorAssignment;
	}
	public String getSectionAssignment() {
		return sectionAssignment;
	}
	public void setSectionAssignment(String sectionAssignment) {
		this.sectionAssignment = sectionAssignment;
	} 
	
	/**
	 * Override To String function to print book information
	 */
	@Override
	public String toString() {
		String result = "ID: " + super.getPersonId(); 
		result += "\nName: " + super.getFirstName() + " " + super.getLastName(); 
		result += "\nEmail: " + super.getEmailAddress(); 
		result += "\nFloor Assignment: " + this.getFloorAssignment();
		result += "\nSection Assignment: " + this.getSectionAssignment();
		
		return result; 
	}
}
