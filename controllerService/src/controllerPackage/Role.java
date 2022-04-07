package controllerPackage;

public enum Role {
	ACADEMIC_STAFF_MEMBER(0), STUDENT(1);
	
	private int rNum;
	private String names[] = {"Academic Staff Member", "Student"};
	
	private Role(int num) {
		rNum = num;
	}
	
	public String toString() {
		return names[rNum];
	}
}
