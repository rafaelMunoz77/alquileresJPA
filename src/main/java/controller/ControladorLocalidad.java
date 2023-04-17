package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Localidad;



public class ControladorLocalidad {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("alquileres");

	
	public static Localidad findById (int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Localidad l = (Localidad) em.find(Localidad.class, id);	
		em.close();
		return l;
	}
	
	
	public static List<Localidad> findAll() {
		
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM localidad;", Localidad.class);
		List<Localidad> l = (List<Localidad>) q.getResultList();
		
		em.close();
		return l;
	}
	
	
	public static List<Localidad> findByLikeDescripcion (String descripcion) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM localidad where descripcion like ?;", Localidad.class);
		q.setParameter(1, "%" + descripcion + "%");
		List<Localidad> l = (List<Localidad>) q.getResultList();
		
		em.close();
		return l;
	}
	
	
	public static void guardar (Localidad l) {
		if (l.getId() == 0) {
			insertar(l);
		}
		else {
			modificar(l);
		}
	}
	
	
	public static void insertar (Localidad l) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void modificar (Localidad l) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void eliminar (Localidad l) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		l = em.merge(l);
		em.remove(l);
		em.getTransaction().commit();
		em.close();
	}
	
}
