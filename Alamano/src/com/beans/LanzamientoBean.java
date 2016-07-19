package com.beans;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.persistence.Lanzamiento;

public class LanzamientoBean {
	
	private String correo;
	
	public String confirmar(){
		try {
			EntityManagerFactory emf = 	Persistence.createEntityManagerFactory("prueba", new HashMap());
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Lanzamiento l = new Lanzamiento();
			
			l.setLanzamientoEmail(getCorreo());
			em.persist(l);
			em.getTransaction().commit();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
