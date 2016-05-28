package com.persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the trabajo database table.
 * 
 */
@Entity
@NamedQuery(name="Trabajo.findAll", query="SELECT t FROM Trabajo t")
public class Trabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TRABAJO")
	private int idTrabajo;

	private float comision;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_FIN")
	private Date fechaFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;

	@Column(name="HORARIO_DISP_FIN")
	private BigDecimal horarioDispFin;

	@Column(name="HORARIO_DISP_INI")
	private BigDecimal horarioDispIni;

	@Column(name="ID_SERVICIO")
	private int idServicio;

	@Column(name="PRECIO_HORA")
	private float precioHora;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE")
	private Date updateDate;

	@Column(name="UPDATE_USER")
	private String updateUser;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="ID_PROVEEDOR")
	private Proveedor proveedor;

	public Trabajo() {
	}

	public int getIdTrabajo() {
		return this.idTrabajo;
	}

	public void setIdTrabajo(int idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public float getComision() {
		return this.comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public BigDecimal getHorarioDispFin() {
		return this.horarioDispFin;
	}

	public void setHorarioDispFin(BigDecimal horarioDispFin) {
		this.horarioDispFin = horarioDispFin;
	}

	public BigDecimal getHorarioDispIni() {
		return this.horarioDispIni;
	}

	public void setHorarioDispIni(BigDecimal horarioDispIni) {
		this.horarioDispIni = horarioDispIni;
	}

	public int getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public float getPrecioHora() {
		return this.precioHora;
	}

	public void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
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

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

}