package ValueObject;
public class seongjeok {
	
	private String name;
	private String gwamokName;
	private int year;
	private int semester;
	private char grade[] = new char[100];
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGwamokName() {
		return gwamokName;
	}
	public void setGwamokName(String gwamokName) {
		this.gwamokName = gwamokName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public char[] getGrade() {
		return grade;
	}
	public void setGrade(char[] grade) {
		this.grade = grade;
	}
	public int[] getKimal() {
		return kimal;
	}
	public void setKimal(int[] kimal) {
		this.kimal = kimal;
	}
	private int kimal[] = new int[100];





}
