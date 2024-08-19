package Entidades;//declara el paquete Entidades al que pertenece esta clase

import java.io.Serializable;//importa la interfaz Serializable, que permite que los objetos de esta clase sean serializados
import java.util.Calendar;//Importa la clase Calendar para manejar fechas y horas
import java.util.Date;//Importa la clase Date (aunque no se usa en este fragmento)

public class Perro extends Mascota implements Serializable {//declara la clase Perro que extiende la clase Mascota y implementa la interfaz Serializable
    
  
    
    private Calendar fechaBanio;//variable de instancia que almacena la fecha del ultimo baño del perro
    private boolean limpio;//variable de instancia que indica si el perro esta limpio

    public Perro() {
        super();//constructor por defecto que llama al constructor de la superclase Mascota
    }

    public Perro(String raza, Calendar fechaNacimiento, float peso, String nombre) {
        super(raza, fechaNacimiento, peso, nombre);//constructor que inicializa la instancia de Perro con los parámetros dados y llama al constructor de la superclase
        limpio = false;//inicializa la variable limpio a false, indicando que el perro no está limpio por defecto
    }

    public Calendar getFechaBanio() {
        return fechaBanio;//metodo getter para obtener la fecha del último baño del perro
    }

    public void setFechaBanio(Calendar fechaBanio) {
        this.fechaBanio = fechaBanio;//metodo setter para establecer la fecha del ultimo baño del perro
    }

    public boolean isLimpio() {
        return limpio;//metodo getter para saber si el perro esta limpio
    }

    public void setLimpio(boolean limpio) {
        this.limpio = limpio;//metodo setter para establecer si el perro esta limpio
    }

    public void baniar() {
        System.out.println("Perro bañado");//mprime un mensaje indicando que el perro ha sido bañado
        fechaBanio = Calendar.getInstance();//stablece la fecha del ultimo baño al momento actual
        limpio = true;//establece el estado limpio a true, indicando que el perro ahora está limpio
    }

	
	public void jugar(int opc) {//metodo jugar que toma un entero opc como parámetro
	    switch(opc) {//estructura de control switch para decidir qué accion realizar según el valor de opc
	        case 1://caso cuando opc es 1
	            System.out.println("Tirar pelota, realizado.");//imprime un mensaje indicando que la acción de tirar la pelota se ha realizado
	            break;
	        case 2://caso cuando opc es 2
	            System.out.println("Salir al parque, realizado.");//imprime un mensaje indicando que la acción de salir al parque se ha realizado
	            break;
	        case 3://caso cuando opc es 3
	            System.out.println("Jugar con otros perros, realizado.");//imprime un mensaje indicando que la acción de jugar con otros perros se ha realizado
	            this.limpio=false;//asigna el valor false a la variable de instancia limpio, indicando que el objeto ya no está limpio después de jugar con otros perros
	            break;
	    }
	    Calendar fecha= Calendar.getInstance();
		super.setUltimaInteraccion(fecha);
	}

}
