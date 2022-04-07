package studentService;

public class testing {

	public static void main(String[] args) {
		StudentsImpl x = new StudentsImpl();
		
		Students allStuds = new Students();
		
		x.addStudent(1, allStuds);
		
		System.out.println(x.studentDetails(allStuds));
	}

}
