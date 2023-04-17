package test;

import controller.ControladorLocalidad;
import model.Localidad;

public class Principal {

	/**
	 * 
	 */
	public static void obtenerListaLike() {
		System.out.println("Lista");
		for (Localidad l : ControladorLocalidad.findByLikeDescripcion("nueva")) {
			System.out.println("Localidad: " + l.getDescripcion());
		}
	}

	public static void insercionYModificacion() {
		Localidad l = new Localidad();
		l.setDescripcion("Lucena");
		ControladorLocalidad.guardar(l);
		System.out.println("Lucena id: " + l.getId());
		l.setDescripcion("Rute");
		ControladorLocalidad.guardar(l);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Localidad l = ControladorLocalidad.findById(1251);
		if (l != null) {
			ControladorLocalidad.eliminar(l);
		}
	}

}
