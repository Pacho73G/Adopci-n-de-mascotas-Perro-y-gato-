package Entidades;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class Persona {
	//creacion de variables
	private String nombre;
	private int edad;
	private String residencia;
	private String cedula;
	private ArrayList<Mascota> mascotas;

	
	public Persona() {//constructor vacio
		super();
	}
	public Persona(String nombre, int edad, String residencia, String cedula) {
		super();//constructor con todos los atributos de persona
		this.nombre = nombre;
		this.edad = edad;
		this.residencia = residencia;
		this.cedula = cedula;
		this.mascotas = new ArrayList<>();
	}
	public ArrayList<Mascota> getMascotas() {//getter para buscar las mascotas de la lista
		return mascotas;
	}
	public void setMascotas(ArrayList<Mascota> mascotas) {//setter para asignar la mascota a la lista
		this.mascotas = mascotas;
	}
	public String getNombre() {//recibe el nombre de la persona
		return nombre;
	}
	public void setNombre(String nombre) {//asigna el nombre de la persoan
		this.nombre = nombre;
	}
	public int getEdad() {//recibe la edad de el usuario
		return edad;
	}
	public void setEdad(int edad) {//asigna la edad a la persona
		this.edad = edad;
	}
	public String getResidencia() {//recibe la residencia
		return residencia;
	}
	public void setResidencia(String residencia) {//asigna la residencia de la persona
		this.residencia = residencia;
	}
	public String getCedula() {//recibe la cedula de la persona
		return cedula;
	}
	public void setCedula(String cedula) {//le asigna la cedula a la persona
		this.cedula = cedula;
	}
	
	public void adoptarMascota(Mascota mascota) {////Metodo el cual asigna a una persona una mascota y asi mismo a una mascota un dueño
		if(mascotas==null) {
			this.mascotas=new ArrayList<>();
		}
		mascotas.add(mascota);
		mascota.setDueno(this); //se le asigno el objeto Persona como dueño del perro
		Calendar fechaActual = Calendar.getInstance();
		mascota.setFechaAdopcion(fechaActual);
	}
	
	public void cambiarNombreMascota(Mascota mascota,String nombreNuevo) {
		if(nombreNuevo.equals(mascota.getNombre())) {
			System.out.println("el nombre a cambiar es igual");
		}else {
			mascota.setNombre(nombreNuevo);
		}
	}
	
	public void mostrarMascotas() {//funcion la cual muestra la mascota de la persona junto con su nombre y raza o en caso tal, no tiene mascota
		if(mascotas==null) {
			System.out.println(this.nombre+" no tiene mascotas :(");
		}
		else
			System.out.println("Mascotas de: "+this.nombre);
			for(Mascota m:mascotas) {
				System.out.println("Nombre: "+m.getNombre());
				System.out.println("Raza: "+m.getRaza());
		}
	}
	
	
	
}