package com.persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lanzamiento database table.
 * 
 */
@Entity
@NamedQuery(name="Lanzamiento.findAll", query="SELECT l FROM Lanzamiento l")
public class Lanzamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LANZAMIENTO_ID")
	private int lanzamientoId;

	@Column(name="LANZAMIENTO_EMAIL")
	private String lanzamientoEmail;

	public Lanzamiento() {
	}

	public int getLanzamientoId() {
		return this.lanzamientoId;
	}

	public void setLanzamientoId(int lanzamientoId) {
		this.lanzamientoId = lanzamientoId;
	}

	public String getLanzamientoEmail() {
		return this.lanzamientoEmail;
	}

	public void setLanzamientoEmail(String lanzamientoEmail) {
		this.lanzamientoEmail = lanzamientoEmail;
	}

}