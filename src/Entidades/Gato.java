package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class Gato extends Mascota implements Serializable{
	
	
	private boolean uniasLargas;//atributo que indica si el gato tiene las uñas largas

	public Gato() {
		super();//Constructor por defecto que llama al constructor de la superclase Mascota
	}

	public Gato(String raza, Calendar fechaNacimiento, float peso, String nombre) {
		super(raza, fechaNacimiento, peso, nombre);//constructor que llama al constructor de la superclase Mascota para inicializar los atributos heredados
		this.uniasLargas=true;//inicializa el atributo uniasLargas a true, indicando que el gato tiene las uñas largas por defecto
	}

	public boolean isUniasLargas() {//metodo getter para obtener el valor de uniasLargas
		return uniasLargas;
	}

	public void setUniasLargas(boolean uniasLargas) {//metodo setter para establecer el valor de uniasLargas
		this.uniasLargas = uniasLargas;
	}
	
	public void cortarUnias() {
		System.out.println("Uñas cortadas."); //imprime un mensaje indicando que las uñas han sido cortadas
		this.uniasLargas=false;//establece uniasLargas a false, indicando que las uñas ya no están largas
	}
	
	public void jugar(int opc) {
	
		switch(opc) {
		//estructura de control switch para decidir que accion realizar segun el valor de opc
		case 1://caso cuando opc es 1
			System.out.println("Uñas afiladas");//imprime un mensaje indicando que el gato ha afilado sus uñas
			this.uniasLargas=true;//establece uniasLargas a true, indicando que las uñas estan largas
			break;
		case 2://caso cuando opc es 2
			System.out.println("Gato acariciado.");i//imprime un mensaje indicando que el gato ha sido acariciado
			break;
		}
		Calendar fecha= Calendar.getInstance();//obtiene la fecha y hora actuales
		super.setUltimaInteraccion(fecha);//establece la fecha de la ultima interaccióon el gato
	}
}
