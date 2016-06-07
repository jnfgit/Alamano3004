package com.persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PAGOS database table.
 * 
 */
@Entity
@Table(name="PAGOS")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PAGO")
	private int idPago;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="ESTADO_DEL_PAGO")
	private String estadoDelPago;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_DE_PAGO")
	private Date fechaDePago;

	@Column(name="ID_ORDEN")
	private int idOrden;

	@Column(name="ID_TRABAJO")
	private int idTrabajo;

	@Column(name="METODO_PAGO")
	private String metodoPago;

	@Column(name="PRECIO_FINAL")
	private float precioFinal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE")
	private Date updateDate;

	@Column(name="UPDATE_USER")
	private String updateUser;

	public Pago() {
	}

	public int getIdPago() {
		return this.idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEstadoDelPago() {
		return this.estadoDelPago;
	}

	public void setEstadoDelPago(String estadoDelPago) {
		this.estadoDelPago = estadoDelPago;
	}

	public Date getFechaDePago() {
		return this.fechaDePago;
	}

	public void setFechaDePago(Date fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public int getIdOrden() {
		return this.idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public int getIdTrabajo() {
		return this.idTrabajo;
	}

	public void setIdTrabajo(int idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public String getMetodoPago() {
		return this.metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public float getPrecioFinal() {
		return this.precioFinal;
	}

	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}