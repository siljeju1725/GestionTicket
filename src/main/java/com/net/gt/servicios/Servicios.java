package com.net.gt.servicios;

import java.util.List;

import com.net.gt.modelos.Tickets;
import com.net.gt.controladores.Controlador;

public class Servicios {

	public List<Tickets> obtenerDatos() {
		Controlador controlador = new Controlador();
		return controlador.obtenerDatos();
	}

	public Tickets obtenerTicket(int idTicket) {
		Controlador controlador = new Controlador();
		return controlador.obtenerTicket(idTicket);
	}

	public void insertar(Tickets p) {
		Controlador controlador = new Controlador();
		controlador.insertar(p);
	}

	public void actualizar(Tickets p) {
		Controlador controlador = new Controlador();
		controlador.actualizar(p);
	}

	public void eliminar(int id) {
		Controlador controlador = new Controlador();
		controlador.eliminar(id);
	}

	public static void main(String[] args) {
		Servicios servicios = new Servicios();
		servicios.obtenerDatos();
	}

}
