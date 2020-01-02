import java.util.ArrayList;

public abstract class Employee {

	private String name;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String username;
	private String password;
	protected static ArrayList<Employee> employee = new ArrayList();

	public Employee(String name, String lastName, String address, String phoneNumber, String password) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.password = password;
		employee.add(this);
	}

	