package com.beans;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import com.persistence.Usuario;

import db.admin.DataBaseHelper;

public class PerfilBean {
	
	private Integer idUsuario;
	private String nombre;
	private String apellido;
	private String correo;
	private Integer telefono;
	private String ci;
	private String sexo;
	private String fechaNac;
	private String barrio;
	private String calle;
	private Integer apto;
	private String numero;
	
	private String password;
	private String password2;
	
	/*public PerfilBean(){
	
		
	}*/
	
	@PostConstruct
	public void onload(){
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		LoginBean loginBean = (LoginBean) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context, null, "loginBean");
		
		if(loginBean.getEmailAddress()== null){
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			try {
				externalContext.redirect("inicio.jsf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		EntityManagerFactory emf = 	Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u where u.email=:email", Usuario.class);
		query.setParameter("email", loginBean.getEmailAddress());
		List<Usuario> results = query.getResultList();
		
		if (results.size()> 0){
			setIdUsuario(results.get(0).getIdUsuario());
			setNombre(results.get(0).getNombre());
			setApellido(results.get(0).getApellido());
			setCorreo(results.get(0).getEmail());
			setTelefono(results.get(0).getTelefono());
			setCi(results.get(0).getCi());
			setSexo(results.get(0).getSexo());
			setFechaNac(results.get(0).getFechaNacimiento().toString());
			setBarrio(results.get(0).getBarrio());
			setCalle(results.get(0).getCalle());
			setApto(results.get(0).getApto());
			setNumero(results.get(0).getNumero());
			
			
		}
		em.close();
		emf.close();
	}

	
	public String confirmar(){
		EntityManagerFactory emf = 	Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u where u.idUsuario=:idUsuario", Usuario.class);
		query.setParameter("idUsuario", getIdUsuario());
		List<Usuario> results = query.getResultList();
		
		//TODO falta validar correo y validar contraseñas.
		
		if (results.size()> 0){
			Usuario u = results.get(0);
			u.setIdUsuario(getIdUsuario());
			u.setNombre(getNombre());
			u.setApellido(getApellido());
			u.setEmail(getCorreo());
			u.setTelefono(getTelefono());
			u.setCi(getCi());
			u.setSexo(getSexo());
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		   
			try {
				u.setFechaNacimiento(sdf.parse(getFechaNac()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			u.setBarrio(getBarrio());
			u.setCalle(getCalle());
			u.setApto(getApto());
			u.setNumero(getNumero());
			
			DataBaseHelper hel = new DataBaseHelper();
			String pass = hel.getSHA1FromPassword(getPassword());
			u.setClavePass(pass);

			em.persist(u);
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			return "home";
		}
		return "";
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getApto() {
		return apto;
	}
	public void setApto(Integer apto) {
		this.apto = apto;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
}
