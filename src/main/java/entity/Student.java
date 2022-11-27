package entity;

public class Student {
	private int id;
	private String name;
	private String email;
	private String password;
	private String gender;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String email, String password, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}

	public Student(int id, String name, String email, String password, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", gender="
//				+ gender + "]";
//	}

}
