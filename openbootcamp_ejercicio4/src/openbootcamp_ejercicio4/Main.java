package openbootcamp_ejercicio4;

public class Main {
	
	public static void main(String[] args) {
		Trabajador worker = new Trabajador();
		Cliente client = new Cliente();
		
		client.setEdad(23);
		client.setNombre("Gustavo");
		client.setNumeroTelefono(123456789);
		client.setCredito(10000);
		
		System.out.println("Cliente " + client.getNombre() + 
				" tiene " + client.getEdad() + 
				" anios y su telefono es: " + client.getNumeroTelefono() + 
				". Su credito es, " + client.getCredito());
		
		worker.setEdad(23);
		worker.setNombre("Gustavo");
		worker.setNumeroTelefono(123456789);
		worker.setSalario(200);
		
		System.out.println("Trabajador " + worker.getNombre() + 
				" tiene " + worker.getEdad() + 
				" anios y su telefono es: " + worker.getNumeroTelefono() + 
				". Su salario es, " + worker.getSalario());
	}
}

class Persona {
	private int edad;
	private int numeroTelefono;
	private String nombre;
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getNumeroTelefono() {
		return this.numeroTelefono;
	}
	
	public int getEdad() {
		return this.edad;
	}
}

class Cliente extends Persona{
	private int credito;
	
	public void setCredito(int credito) {
		this.credito = credito;
	}
	
	public int getCredito() {
		return this.credito;
	}
}

class Trabajador extends Persona{
	private int salario;
	
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	public int getSalario() {
		return this.salario;
	}
}