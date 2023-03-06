package model;

public class Student {
	//1.variables
	private long id;
	private String name;
	private String surname;
	private Faculty faculty;
	private String personCode;
	
	private static long studentCounter = 0;	//static - piekluves mainigais
	
	//2.get and set functions
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPersonCode() {
		return personCode;
	}
	
	public void setId() {
		id = studentCounter;
		studentCounter++;
	}

	//TODO take a look to regex101
	//setname("qwertyuiopasdfghjklzxcvbnm123456789")
	public void setName(String inputName) {
		if(inputName != null && inputName.matches("[A-ZĒŪĪĀĻŅČŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅČŽ]{1}[a-zēīāūļžņš]+)?")) {
			name = inputName;
		}
		else {
			name = "Unknown";
		}
		
	}
	public void setSurname(String inputSurname) {
		if(inputSurname != null && inputSurname.matches("[A-ZĒŪĪĀĻŅČŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅČŽ]{1}[a-zēīāūļžņš]+)?")) {
			surname = inputSurname;
			}
		else {
			surname = "Unknown";
			}
	}

	//TODO try to combine both regex masks
	//old personCode[0-9]{6}[-][0-9]{5}
	//new personCode 32{1}[0-9]{9}
	public void setPersonCode(String inputPersonCode) {
		if(inputPersonCode != null && inputPersonCode.matches("[0-9]{6}[-][0-9]{5}")) {
			personCode = inputPersonCode;
		}
		else {
			personCode = "000000-00000";
		}
	}
		
	public void setFaculty(Faculty inputFaculty){
		if(inputFaculty != null) {
			faculty = inputFaculty;
		}
		else {
			faculty = Faculty.other;
		}
	}
	
	//3.constructors
	//no-args constructor
	public Student() {
		setId();
		setName("Unknown");
		setSurname("Unknown");
		setFaculty(Faculty.other);
		setPersonCode("000000-00000");
	}
	
	//args constructor
	public Student(String name, String surname, Faculty faculty, String personCode) {
		setId();
		setName(name);
		setSurname(surname);
		setFaculty(faculty);
		setPersonCode(personCode);
	}
	
	//4.toString function
	public String toString() {
		return "" + id + ": " + name + " " + surname + ", " + personCode + ", " + faculty;	//sakuma uzrakstijam "", lai visas mainigas(kuri ir ne tikai string) vareti but izvaditi 
	}
	
	
	//5.additional functions
	
	
}
