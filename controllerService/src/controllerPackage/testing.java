package controllerPackage;

public class testing {

	public static void main(String[] args) {
		Controller x = new Controller();
		
		//allStuds = x.registration(1, allStuds);
		
		//System.out.println(x.studentDetails(allStuds));
		x.registration(Role.STUDENT, 1);
		
	}
}
