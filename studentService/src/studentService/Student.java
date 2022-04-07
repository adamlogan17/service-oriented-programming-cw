package studentService;

public class Student {
	private int id;
	private ModuleCode[] enrolledMcs = new ModuleCode[20];
	private Module[] enrolledModules = new Module[20];
	
	public Student(int newID) {
		this.id = newID;
	}
	
	public int getId() {
		return id;
	}
}
