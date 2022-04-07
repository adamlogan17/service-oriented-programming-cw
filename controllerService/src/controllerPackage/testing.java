package controllerPackage;

import studentservice.Students;

public class testing {

	public static void main(String[] args) {
		Controller x = new Controller();
		
		Students allStuds = new Students();
		
		allStuds = x.registration(1, allStuds);
		
		System.out.println(x.studentDetails(allStuds));
	}
}
