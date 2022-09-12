package openbootcamp_ejercicio3;


public class Main {

	public static void main(String[] args) {
		
		Persona gustavo = new Persona();
		gustavo.setName("Gustavo");
		gustavo.setAge(23);
		gustavo.setPhone(55555);
		
		System.out.println(gustavo.getName());
		System.out.println(gustavo.getAge());
		System.out.println(gustavo.getPhone());
	}

}

class Persona {
	private String name;
	private int age;
	private int phone;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getPhone() {
		return this.phone;
	}
}
