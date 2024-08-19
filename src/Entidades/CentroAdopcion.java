package Entidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CentroAdopcion implements Serializable{
	//creacion de variables
	private String nombre; 
	private int ganancias;
	private ArrayList<Persona> clientes;
	private ArrayList<Mascota> internos;
	private ArrayList<Mascota> guarderia;
	
	
	
	public CentroAdopcion() {//constructor vacio
		super();
	}

	public CentroAdopcion(String nombre) {//constructor con nombre y arreglo de clientes
		super();
		this.nombre = nombre;
		this.ganancias=0;
		this.clientes = new ArrayList<>();
		this.internos = new ArrayList<>();
		this.guarderia=new ArrayList<>();
	}

	public String getNombre() {//metodo getter para obtener nombre
		return nombre;
	}

	public void setNombre(String nombre) {//setter para establecer el nombre
		this.nombre = nombre;
	}

	public ArrayList<Persona> getClientes() {//metodo getter para obretener la lista de clientes
		return clientes;
	}

	public void setClientes(ArrayList<Persona> clientes) {//metodo setter para establecer la lista de clientes 
		this.clientes = clientes;
	}

	public ArrayList<Mascota> getInternos() {//metodo getter para obtener la lista de mascotas en adopcion
		return internos;
	}

	public void setInternos(ArrayList<Mascota> internos) {//metodo setter para establecer la lista de mascotas en adopcion
		this.internos = internos;
	}

	public ArrayList<Mascota> getGuarderia() {//metodo getter para obtener la lista de masctoa en guarderia
		return guarderia;
	}

	public void setGuarderia(ArrayList<Mascota> guarderia) {//metodo setter para establecer la lista de mascota en guarderia
		this.guarderia = guarderia;
	}

	public int getGanancias() {//metodo getter para obtener ganancias del centro de adopcion
		return ganancias;
	}

	public void setGanancias(int ganancias) {//metodo setter para establecer las ganancias del centro de adopcion
		this.ganancias = ganancias;
	}

	public void rescatarMascota(Mascota mascota) {//funcion que verifica el valor de "internos"
		if(internos==null) {
			internos=new ArrayList<>();
		}
		
		 try {//intenta calcular la edad de la mascota
	        	float edad=mascota.calcularEdad();
	        	
	        	if(edad>30) { //verifica si la edad de la mascota es mayor a 30
	        		throw new InputMismatchException("Mascota demasiado vieja muy viejo");//si la edad es mayor a 30, lanza una excepcion InputMismatchException con un mensaje especifico
	        		
	        	} else {//si la edad es 30 o menor, verifica el tipo de la mascota
	        		if(mascota instanceof Perro) {//si la mascota es un Perro, imprime un mensaje indicando que un perro ha sido rescatado
	        			System.out.println("Perro rescatado");
	        			//añade la mascota a la lista de internos
	        			internos.add(mascota);
	        		}else {//si la mascota no es un Perro (se asume que es un Gato), imprime un mensaje indicando que un gato ha sido rescatado
	        			System.out.println("Gato rescatado");
	        			internos.add(mascota);//añade la mascota a la lista de internos
	        		}
	        	}
	        		
	        } catch (InputMismatchException e) {
	          System.out.println(e.getMessage());
	            
	        }
	}
	public void mostrarInternos() {//funcion para imprimir todo lo del perro
		for(Mascota m: internos) {
			if(m.calcularEdad()>1) {
				if(m instanceof Perro) {
					System.out.println("Perro:");
				}else {
					System.out.println("Gato");
				}
				System.out.println("Nombre: "+m.getNombre());
				System.out.println("Raza: "+m.getRaza());
				System.out.println("Peso: "+m.getPeso());
				System.out.println("------------------------");
			}
		}
	}
	
	public void darEnAdopcion(Mascota mascota, Persona persona) {//funcion que asigna un dueño a perro
		persona.adoptarMascota(mascota);
		mascota.setDueno(persona);
		internos.remove(mascota);
	}
	
	public void agregarCliente(Persona persona) {//funcion que agrega la persona en caso de no ser nula
		if(clientes==null) {
			clientes=new ArrayList<>();
		}
		
		Persona p=buscarCliente(persona.getCedula());
		if(p==null){
			clientes.add(persona);//se agrega
		}
	}
	
	public Persona buscarCliente(String cedula) {//funcion que recorre y compara si existe o no la persona desde el numero de cedula
		Persona persona=null;
		
		for(Persona p: clientes){//for que recorre y mira si existe o no la persona
			if(cedula.equals(p.getCedula())) {
				persona=p;
			}
		}
		return persona;
	}
	
	public Mascota buscarMascota(String nombre,ArrayList<Mascota> mascotas) {
		
		for(Mascota m:mascotas) {
			if(nombre.equals(m.getNombre())) {
				return m;
			}
		}
		return null;
	}
	
	public void mostrarAdopciones() {//funcion la cual muestra la lista de adopciones del cliente 
		if(clientes != null) {
			for(Persona p:clientes) {
				System.out.println("Cliente: "+p.getNombre());
				p.mostrarMascotas();
			}
		}
	}
	
	public void dejarMascotas(Mascota mascota,Persona persona) {
		if(this.guarderia==null) {
			guarderia=new ArrayList<>();
		}
		guarderia.add(mascota);
		persona.getMascotas().remove(mascota);
	}
	
	public void recogerMascota(String nombre,Persona persona) {
		Mascota m=buscarMascota(nombre,guarderia);
		
		if(m==null) {
			System.out.println("Error, mascota no esta en guarderia");
		}else{
			if(m.getDueno().getNombre()==persona.getNombre()) {
				System.out.println("Mascota entregada");
				guarderia.remove(m);
				persona.getMascotas().add(m);
			}else {
				System.out.println("Esa mascota no es suya");
			}
		}
	}
	
	public void interactuar(Mascota mascota) {
		Scanner entrada=new Scanner(System.in);
		
		if(mascota instanceof Perro) {
			System.out.println("1. Tirar pelota");
			System.out.println("2. Salir al parque");
			System.out.println("3. Jugar con otros perros");
			System.out.println("4. Bañar perro");
			int opc=entrada.nextInt();
			
			while(opc<1 || opc>4) {
				System.out.println("Error vuelva a digitar la opcion");
				opc=entrada.nextInt();
			}
			if(opc==4) {
				Perro perro=(Perro) mascota;
				perro.baniar();
			}else {
				mascota.jugar(opc);
			}
		}else {
			System.out.println("1. Afilar uñas");
			System.out.println("2. Acariciar");
			System.out.println("3. Cortar uñas");
			int opc=entrada.nextInt();
			
			while(opc<1 || opc>3) {
				System.out.println("Error vuelva a digitar la opcion");
				opc=entrada.nextInt();
			}
			if(opc==3) {
				Gato gato=(Gato) mascota;
				gato.cortarUnias();
			}else {
				mascota.jugar(opc);
			}
		}
		
		this.ganancias+=10;
		System.out.println("Ganacias: "+this.ganancias);
		entrada.nextLine();
	}
	
	
	
	

}
