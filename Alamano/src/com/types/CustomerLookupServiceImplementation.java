package com.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.persistence.Usuario;
import com.results.Customer;

public class CustomerLookupServiceImplementation implements CustomerLookupService {

	@Override
	public Customer findCustomer(String userName, String password) {
		
		EntityManagerFactory emf = 	Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		Usuario usuario = null;
	
		Query queryCinco = em.createQuery("SELECT u FROM Usuario u Where u.email = :email and u.clave_pass= :clave");
		queryCinco.setParameter("email", userName);
		queryCinco.setParameter("clave_pass", password);
		
		List usuarios = (ArrayList)queryCinco.getResultList();
		
		if(usuarios != null){
			if(usuarios.size() > 0){
				usuario = (Usuario)usuarios.get(0);
			}
		}
				
		em.close();
		emf.close();
		
		if(usuario == null){
			return null;
		}else{
			Customer customer = new Customer();
			return customer;
		}
	}
}
