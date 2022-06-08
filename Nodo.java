/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructura;

public class Nodo {
	String informacion;
	Nodo enlace;
	public Nodo(String informacion) {
		super();
		this.informacion = informacion;
		this.enlace=null;
	}
	public Nodo(String informacion, Nodo enlace) {
		super();
		this.informacion = informacion;
		this.enlace = enlace;
	}
	public String getInformacion() {
		return informacion;
	}
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	public Nodo getEnlace() {
		return enlace;
	}
	public void setEnlace(Nodo enlace) {
		this.enlace = enlace;
	}

}
