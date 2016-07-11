package com.beans;

public class CleanBean {
	
	private int cantCuartos  = 1;
	private int cantBanos = 1;
	private boolean extraVentanas = false;
	private boolean extraHeladera = false;
	private boolean extraHorno = false;
	private boolean extraLavaRopa = false;
	private String aclaraciones = "";
	private int cantHorasEstimadas = 0;
	private int precioPorHora = 250;
	
	
	private final String strSaltoLinea = "\n";
	
	public String confirmarDetalleServicio(){
		return "";
	}
		
	public String getExtras(){
		String strExtra = "";
		if(extraVentanas)
			strExtra = strExtra + "Ventanas" + strSaltoLinea;
		if(extraHeladera)
			strExtra = strExtra + "Heladera" + strSaltoLinea;
		if(extraHorno)
			strExtra = strExtra + "Horno" + strSaltoLinea;
		if(extraLavaRopa)
			strExtra = strExtra + "Lava Ropa" + strSaltoLinea;
		return strExtra;
	}
	
	public String getEstimado(){
		String resFinal = " Horas";
		cantHorasEstimadas = 1;
		
		if(cantCuartos == 1 && cantBanos == 1){
			
		}
		
		if(cantCuartos > 1 && cantCuartos <= 3)
			cantHorasEstimadas++;
		else if(cantCuartos > 3){
			cantHorasEstimadas += 2;
		}
		
		if(cantBanos > 1 && cantBanos <= 3)
			cantHorasEstimadas ++;
		else if(cantBanos > 3){
			cantHorasEstimadas += 2;
		}
		
		if(extraHeladera || extraHorno || extraLavaRopa || extraVentanas)
			cantHorasEstimadas++;
		
		return String.valueOf(cantHorasEstimadas) + resFinal;
	}
	
	public String getPrecio(){
		double precio = cantHorasEstimadas * precioPorHora;
		
		return "$ " + precio;
	}
	
	public int getCantCuartos() {
		return cantCuartos;
	}
	public void setCantCuartos(int cantCuartos) {
		this.cantCuartos = cantCuartos;
	}
	public int getCantBanos() {
		return cantBanos;
	}
	public void setCantBanos(int cantBanos) {
		this.cantBanos = cantBanos;
	}
	public boolean isExtraVentanas() {
		return extraVentanas;
	}
	public void setExtraVentanas(boolean extraVentanas) {
		this.extraVentanas = extraVentanas;
	}
	public boolean isExtraHeladera() {
		return extraHeladera;
	}
	public void setExtraHeladera(boolean extraHeladera) {
		this.extraHeladera = extraHeladera;
	}
	public boolean isExtraHorno() {
		return extraHorno;
	}
	public void setExtraHorno(boolean extraHorno) {
		this.extraHorno = extraHorno;
	}
	public boolean isExtraLavaRopa() {
		return extraLavaRopa;
	}
	public void setExtraLavaRopa(boolean extraLavaRopa) {
		this.extraLavaRopa = extraLavaRopa;
	}
	public String getAclaraciones() {
		return aclaraciones;
	}
	public void setAclaraciones(String aclaraciones) {
		this.aclaraciones = aclaraciones;
	}
}
