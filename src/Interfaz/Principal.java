package Interfaz;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entidades.CentroAdopcion;
import Entidades.Gato;
import Entidades.Mascota;
import Entidades.Perro;
import Entidades.Persona;

public class Principal {

	public static void main(String[] args) {
		CentroAdopcion centro=new CentroAdopcion("Centro Adopcion");//creacion de objeto de la clase adopcion		
		Scanner entrada=new Scanner(System.in);
		int opc=0;
		cargar(centro);
		do {
			opc=menu(entrada);
			switch(opc) {
			case 1:
				rescatarPerro(entrada,centro);
				break;
			case 2:
				Persona persona=adoptarMascota(entrada,centro);
				
				ArrayList<Mascota> mascotas=new ArrayList<>();
				centro.mostrarInternos();//llamado para mostrar la litsa de perros
				System.out.println("Digite el nombre de la mascota el cual desea adoptar");
				String nombre=entrada.nextLine();
				
				mascotas=centro.getInternos();
				Mascota mascota=centro.buscarMascota(nombre, mascotas);//llamado a la fcn buscar perro
				if(mascota==null) {
					System.out.println("La mascota buscada con ese nombre no esta en nuestra base de datos");
					break;
				}else
					System.out.println("Mascota adoptada correctamente :)");
					centro.darEnAdopcion(mascota, persona);//llamado a la fcn dar en adopcion
				break;
			case 3:
				cambioDeNombre(entrada, centro);
				break;
			case 4:
				System.out.println("1. Dejar en guarderia");
				System.out.println("2. Sacar guarderia");
				int opcion2=entrada.nextInt();
				
				while(opcion2<1 || opcion2>2) {
					System.out.println("Error, vuelva a digitar la opcion");
					opcion2=entrada.nextInt();
				}
				entrada.nextLine();
				switch(opcion2){
					case 1:
						dejarMascota(centro,entrada);
						break;
					case 2:
						sacarDeGuarderia(centro,entrada);
				}
				break;
			case 5:
				interactuar(centro,entrada);
				break;
			case 6:
				mostrarBaseDeDatos(entrada,centro);
				break;
			case 7:
				guardar(centro);
				System.out.println("Guardando y saliendo....");
				break;
			}
			
		}while(opc!=7);
	}
	public static int menu(Scanner entrada) {
		int opc;
		//impresion del menu
		System.out.println("1. Rescatar un mascota");
		System.out.println("2. Adoptar un mascota");
		System.out.println("3. Cambiar nombre de mascota");
		System.out.println("4. Dejar o sacar mascota de guarderia");
		System.out.println("5. Interactuar");
		System.out.println("6. ver clientes y mascotas");
		System.out.println("7. Salir y guardar");
		opc=pedirEntero(entrada);
		
		while(opc<1 || opc>7) {//while que controla el ingreso de ciertos numeros
			System.out.println("Error, vuelva a ingresar la opcion");
			opc=pedirEntero(entrada);
		}
		entrada.nextLine();
		return opc;
	}
	
	public static void rescatarPerro(Scanner entrada, CentroAdopcion centro) {//funcion la cual permite el ingreso de un perro
		boolean bandera = false;
		String nombre;
	    String raza;
	    Calendar fechaNacimiento = Calendar.getInstance();
	    float peso;
	    int opc=0;

	    System.out.println("Digite el nombre de la mascota");//ingreso de nombre
	    nombre = entrada.nextLine();
	    System.out.println("Digite la raza de la mascota");//ingreso de raza
	    raza = entrada.nextLine();
	    System.out.println("Digite la fecha de nacimiento de la mascota (formato dd-MM-yyyy)");//ingreso de fecha de nacimiento
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");//Se crea un objeto SimpleDateFormat para analizar la fecha

        do {
    	    String fechaNacimientoCapturar = entrada.nextLine();//Se lee la fecha de nacimiento ingresada por el usuario como una cadena de texto
            try {
                fechaNacimiento.setTime(dateFormat.parse(fechaNacimientoCapturar)); // Se intenta analizar la cadena de fecha y convertirla en un objeto Calendar
                bandera = true; // Establece la bandera en true si se logró parsear
            } catch (ParseException e) { // Si ocurre una excepción al analizar la fecha, imprime un mensaje de error
                System.out.println("Formato de fecha incorrecto. Use el formato dd-MM-yyyy");
                errores(e.getMessage()); // Llama a la función para manejar errores, pasando el mensaje de error
            }
        } while (!bandera);
	    
	    System.out.println("Digite el peso de la mascota");
	    peso = pedirFloat(entrada);
	    
	    System.out.println("La mascota es: ");
	    System.out.println("1. Perro");
	    System.out.println("2. Gato");
	    opc=entrada.nextInt();
	    
	    while(opc<1 || opc>2) {
	    	System.out.println("Error, vuelva a ingresar el dato");
	    	opc=entrada.nextInt();
	    }
	    
	    if(opc==1) {
	    	Perro perro= new Perro(raza,fechaNacimiento,peso,nombre);
	    	centro.rescatarMascota(perro);
	    }else {
	    	Gato gato= new Gato(raza,fechaNacimiento,peso,nombre);
	    	centro.rescatarMascota(gato);
	    }
	    entrada.nextLine();
	}
	
	public static Persona adoptarMascota(Scanner entrada,CentroAdopcion centro) {//fcn para adoptar perro
	    Persona persona;//declaracion de varaible de tipo persona
	    System.out.println("Digite su numero de cedula: ");//ingreso de numero de cedula
	    String cedula=pedirCedula(entrada);//iguala cedula al llamado de la fcn y obtiene los datos

	    persona=centro.buscarCliente(cedula);//Busca a la persona en la base de datos del centro de adopcion
	    
	    if(persona==null) {//if que controla el valor de persona
	        String nombre;
	        int edad;
	        String residencia;
	        
	        System.out.println("No se encuentra en la base de datos, lo vamos a registrar");
	        System.out.println("Digite su nombre");//pide el nombre al usuario
	        nombre=entrada.nextLine();
	        System.out.println("Digite su edad");//pide edad al usuario
	        edad=pedirEntero(entrada);
	        System.out.println("Digite su residencia");//pide residencia al usuario
	        entrada.nextLine();
	        residencia=entrada.nextLine();
	        //Crea un nuevo objeto Persona con los datos que se ingresaron
	        persona=new Persona(nombre,edad,residencia,cedula);
	        centro.agregarCliente(persona);//agrega la persona a la base de datos
	        return persona;//devulve la nueva persona creada
	    } else {
	        return persona;
	    }
	}
	
	public static void cambioDeNombre(Scanner entrada, CentroAdopcion centro) {//fcn para dar cambio de nombre al perro
		 
		String nombre;//variable para el nombre del perro
		String nombreNuevo;//variable para el nuevo nombre del perro
		String cedula;//variable para almacenar el numero de cedula
		System.out.println("Digite su cedula");//
		cedula=pedirCedula(entrada);//iguala cedula a la fcn pedirCedula
		Persona persona;
		persona=centro.buscarCliente(cedula);
		if(persona==null) {//verifica la persona
			System.out.println("Cliente no registrado");
		}else {
			System.out.println("Bienvenido: "+persona.getNombre());

			persona.mostrarMascotas();//llamado a mostrar mascota
			System.out.println("Digite el nombre, de la mascota a la que le va a cambiar el nombre");
			nombre=entrada.nextLine();//pide el nombre del perro a cambiar el nombre
			System.out.println("Digite el nuevo nombre del perro");
			nombreNuevo=entrada.nextLine();//pide el nuevo nombre
			
			ArrayList<Mascota> mascotas=new ArrayList<>();
			mascotas=persona.getMascotas();
			Mascota mascota=centro.buscarMascota(nombre, mascotas);
			if(mascota!=null) {
				persona.cambiarNombreMascota(mascota, nombreNuevo);
			}else {
				System.out.println("la mascota con ese nombre no esta dentro de sus mascotas");
			}
		}
	}
	
	public static void dejarMascota(CentroAdopcion centro,Scanner entrada) {
		String cedula;//variable para almacenar el numero de cedula
		String nombre;
		
		System.out.println("Digite su cedula");//
		cedula=pedirCedula(entrada);//iguala cedula a la fcn pedirCedula
		Persona persona;
		persona=centro.buscarCliente(cedula);
		if(persona==null) {//verifica la persona
			System.out.println("Cliente no registrado");
		}else {
			System.out.println("Bienvenido: "+persona.getNombre());
			ArrayList<Mascota> mascotas=new ArrayList<>();
			mascotas=persona.getMascotas();
			persona.mostrarMascotas();//llamado a mostrar mascota
			System.out.println("Digite el nombre de la mascota que desea dejar en la guarderia: ");
			nombre=entrada.nextLine();
			Mascota mascota=centro.buscarMascota(nombre, mascotas);

			if(mascota!=null) {
				System.out.println("Mascota en guarderia");
				centro.dejarMascotas(mascota, persona);
			}else {
				System.out.println("la mascota con ese nombre no esta dentro de sus mascotas");
			}
		}
	}
	
	public static void sacarDeGuarderia(CentroAdopcion centro,Scanner entrada) {
		String cedula;//variable para almacenar el numero de cedula
		String nombre;
		
		System.out.println("Digite su cedula");//
		cedula=pedirCedula(entrada);//iguala cedula a la fcn pedirCedula
		Persona persona;
		persona=centro.buscarCliente(cedula);
		if(persona==null) {//verifica la persona
			System.out.println("Cliente no registrado");
		}else {
			System.out.println("Bienvenido: "+persona.getNombre());

			ArrayList<Mascota> mascotas=new ArrayList<>();
			mascotas=centro.getGuarderia();
			
			for(Mascota m: mascotas) {
				if(m instanceof Perro) {
					System.out.println("Perro:");
				}else {
					System.out.println("Gato");
				}
				System.out.println("Nombre: "+m.getNombre());
				System.out.println("------------------------");
			}
			
			System.out.println("Digite el nombre de la mascota que esta en guarderia");
			nombre=entrada.nextLine();
			centro.recogerMascota(nombre, persona);
		}
	}
	
	public static void interactuar(CentroAdopcion centro,Scanner entrada) {
		String nombre;
		
		ArrayList<Mascota> mascotas=new ArrayList<>();
		mascotas=centro.getGuarderia();
		
		for(Mascota m: mascotas) {
			if(m instanceof Perro) {
				System.out.println("Perro:");
			}else {
				System.out.println("Gato");
			}
			System.out.println("Nombre: "+m.getNombre());
			System.out.println("------------------------");
		}
		System.out.println("Digite el nombre de la mascota con la cual desea interactuar");
		nombre=entrada.nextLine();
		Mascota mascota=centro.buscarMascota(nombre, mascotas);
	    if(mascota!=null) {
	    	centro.interactuar(mascota);
	    }else {
	    	System.out.println("Error, mascota no esta en guarderia");
	    }
	}
	
	public static void mostrarBaseDeDatos(Scanner entrada, CentroAdopcion centro) {//llamado a mostrar los datos
		centro.mostrarAdopciones();//fcn para mostrar la base de datos del centro de adopcion
		
	}
	
	public static int pedirEntero(Scanner entrada) {//fcn para solicitar el numero del usuario
        int numero = 0;//almacena el numero
        boolean entradaValida = false;//controlar si la entrada es valida
        
        do {
        	
            try {
            	numero = entrada.nextInt();
                entradaValida = true;//estrablece la bandera true si se obtiene un numero entero valido
            } catch (Exception e) {//captura cualquier excepcion que ocurra durante la conversion
                System.out.println("Error: Debe ingresar un número entero.");
                entrada.nextLine();
            	errores(e.getMessage());//llama la fcn para manejar errores
            }
        } while (!entradaValida);//continua solicitando hasta que se ingrese un numero valido
        return numero;
    }
	
	public static float pedirFloat(Scanner entrada) {//fcn para solicitar numero al usuario, debe ser flotante
        float numero = 0;
        boolean entradaValida = false;//controla que la entrada sea valida
        
        do {
        	
            try {
            	numero = entrada.nextFloat();
                entradaValida = true;//establece la bandera true si se obtiene un numero flotante
            } catch (Exception e) {//captura cualquier excepcion que ocurra en esta conversion
                System.out.println("Error: Debe ingresar un número Flotante.");
                entrada.nextLine();//limpia el buffer
            	errores(e.getMessage());//llama a la fcn para manejar errores
            }
        } while (!entradaValida);//sigue solicitando hasta que el numero sea valido
        return numero;
    }
	
	public static String pedirCedula(Scanner entrada) {//fcn para solicitar el numero de cedula
        String cadena = null;
        boolean entradaValida = false;
        int longitud = 0;
        do {
        	
            try {
            	cadena = entrada.nextLine();//lee lo ingresado por el usaurio
            	longitud = cadena.length();//obtiene su longitud
            	if(longitud==10) {
            		entradaValida = true;//establece bandera true, si  la long es la que se busca
            	}else {
                    throw new InputMismatchException("Error: La cedula debe tener 10 digitos");
                }
               
            } catch (InputMismatchException e) {
              System.out.println(e.getMessage());
          	errores(e.getMessage());//llama a la fcn para controlar errores
                
            }
        } while (!entradaValida);//sigue solicitando hasta que se cumpla la long pedida
        return cadena;//retorna lo ingresado por el usuario
    }
	
	public static void guardar(CentroAdopcion centro) {//fcn para guardar los datos de adopcion en un archivo bin
		try {//se crea un ObjectOutputStream para escribir los objetos en un archivo llamado adopcion.bin
			ObjectOutputStream archivo= new ObjectOutputStream(new FileOutputStream("adopcion.bin"));
			archivo.writeObject(centro.getInternos());//se escribe el arreglo
			archivo.close();//se cierra ObjectOutputStream
		}catch(Exception e) {//captura cualquier excepcion que ocurra
			e.printStackTrace();//imprime las excepciones
			errores(e.getMessage());//llama a la funcion para manejar errores
		}
	}
	
	public static void cargar(CentroAdopcion centro) {
		try {//fcn para cargar los datos de adopcion desde un archivo binario
			//Se crea un ObjectInputStream para leer objetos desde el archivo binario adopcion.bin
			ObjectInputStream leer=new ObjectInputStream(new FileInputStream("adopcion.bin"));
			//Se lee el ArrayList de Perro desde el archivo binario
			ArrayList<Mascota> mascotas = (ArrayList<Mascota>)leer.readObject();
			//Se establece el ArrayList de Perro en el centro de adopción con los datos leídos
			centro.setInternos(mascotas);
			leer.close();//Se cierra el ObjectInputStream
		}catch(Exception e) {//Captura cualquier excepción que ocurra durante la operación
			e.printStackTrace();//Imprime el rastreo de la pila de la excepción
			errores(e.getMessage());
		}
	}
	
	public static void errores(String error) {
		try {//fcn para registrar errores en el archivo
			//Se crea un BufferedWriter para escribir en el archivo errores.txt, con la opcion de agregar al final del archivo si ya existe
			BufferedWriter archivo= new BufferedWriter(new FileWriter("errores.txt",true));
		    //Se obtiene la fecha y hora actual
			Calendar fechaActual = Calendar.getInstance();
			//Se crea un formato para la fecha y hora
		    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            //Se formatea la fecha y hora actual
		    String fechaFormateada = formatoFecha.format(fechaActual.getTime());
			//Se escribe el mensaje de error en el archivo
            archivo.write(error);
			archivo.write(" Fecha del error: ");
            archivo.write(fechaFormateada);
            archivo.newLine(); //Agregar otra linea
			archivo.close();
		}catch(Exception e) {
			e.printStackTrace();//Imprime el rastreo de la pila de la excepción
		}
	}
	
}
