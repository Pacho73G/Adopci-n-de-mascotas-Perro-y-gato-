package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public abstract class Mascota implements Serializable {
	
	
	private String raza;
	private Calendar fechaNacimiento;
	private float peso;
	private String nombre;
	private Calendar fechaAdopcion;
	private Calendar ultimaInteraccion;
	private Persona dueno;
	
	public Mascota() {
		super();
	}

	public Mascota(String raza, Calendar fechaNacimiento, float peso, String nombre) {
	    super();//llama al constructor de la superclase Object Aunque no es estrictamente necesario, es una buena práctica
	    this.raza=raza;//inicializa el atributo raza con el valor del parametro proporcionado
	    this.fechaNacimiento=fechaNacimiento; //inicializa el atributo fechaNacimiento con el valor del parámetro proporcionado
	    this.peso=peso;//inicializa el atributo peso con el valor del parámetro proporcionado
	    this.nombre=nombre;//inicializa el atributo nombre con el valor del parámetro proporcionado
	}


	public String getRaza() {//metodo getter para obtener raza
		return raza;
	}

	public void setRaza(String raza) {//meodo setter para asignar raza
		this.raza = raza;
	}

	public Calendar getFechaNacimiento() {//metodo getter para recibir la fecha de nacimiento
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {//metodo setter para establecer la fecha de nacimiento
		this.fechaNacimiento = fechaNacimiento;
	}

	public float getPeso() {//metodo getter para obtener el peso
		return peso;
	}

	public void setPeso(float peso) {//metodo setter para establecer el peso
		this.peso = peso;
	}

	public String getNombre() {//metodo getter para obtener el nombre
		return nombre;
	}

	public void setNombre(String nombre) {//metodo setter para establecer el nombre
		this.nombre = nombre;
	}

	public Calendar getFechaAdopcion() {//metodo getter para obtener la fecha de adopcion
		return fechaAdopcion;
	}

	public void setFechaAdopcion(Calendar fechaAdopcion) {//metodo setter para establecer la fecha de adopcion
		this.fechaAdopcion = fechaAdopcion;
	}

	public Calendar getUltimaInteraccion() {//Metodo getter para obtener la fecha de la última interacción con la mascota
		return ultimaInteraccion;
	}

	public void setUltimaInteraccion(Calendar ultimaInteraccion) {//Metodo setter para establecer la fecha de la última interacción con la mascota
		this.ultimaInteraccion = ultimaInteraccion;
	}

	public Persona getDueno() {//Metodo setter para establecer el dueño de la mascota
		return dueno;
	}

	public void setDueno(Persona dueno) {
		this.dueno = dueno;
	}
	public abstract void jugar(int opc);
	
	public float calcularEdad() {//Obtener la fecha actual
	    Calendar fechaActual = Calendar.getInstance();

	    //Calcular la diferencia en milisegundos entre la fecha actual y la fecha de nacimiento
	    long diferenciaEnMillis = fechaActual.getTimeInMillis() - fechaNacimiento.getTimeInMillis();

	    //Convertir la diferencia de milisegundos a años, meses y días
	    long años = diferenciaEnMillis / (1000L * 60L * 60L * 24L * 365L);
	    long meses = diferenciaEnMillis / (1000L * 60L * 60L * 24L * 30L) % 12;
	    long dias = diferenciaEnMillis / (1000L * 60L * 60L * 24L) % 30;

	    // Calcular la parte decimal de los años
	    float parteDecimalAnios = (meses / 12.0f) + (dias / 365.0f);

	    // Calcular la edad total como un float
	    float edad = años + parteDecimalAnios;
       
	    return edad; 
	}
	
}
