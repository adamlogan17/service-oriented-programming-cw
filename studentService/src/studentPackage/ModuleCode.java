package studentPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public enum ModuleCode {
	CSC1022(0), CSC1023(1), CSC1024(2), CSC1025(3), CSC1026(4), CSC1027(5), CSC1028(6),
	CSC1029(7), CSC1030(8), CSC1031(9);
	
	private int mcNum;
	private String names[] = {"CSC1022", "CSC1023", "CSC1024", "CSC1025", "CSC1026", "CSC1027",
			"CSC1028", "CSC1029", "CSC1030", "CSC1031"};
	
	private ModuleCode(int num) {
		mcNum = num;
	}
	
	public String toString() {
		return names[mcNum];
	}
}
