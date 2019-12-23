import java.util.ArrayList;

public class Client {

	private String name;
	private String lastName;
	private int age;
	private int id;
	private static int count;
	private String address;
	private ArrayList<Integer[][]> insurance = new ArrayList();

	public Client(String name, String lastName, int age, String address, ArrayList<Integer[][]> insurance) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.insurance = insurance;
		count++;
		id = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Integer[][]> getInsurance() {
		return insurance;
	}

	public void setInsurance(ArrayList<Integer[][]> insurance) {
		this.insurance = insurance;
	}

}
