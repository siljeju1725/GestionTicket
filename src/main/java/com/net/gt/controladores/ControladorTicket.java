package com.net.gt.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.net.gt.modelos.Tickets;
import com.net.gt.servicios.Servicios;

@Named
@RequestScoped

public class ControladorTicket {

	private List<Tickets> listaTickets = new ArrayList<Tickets>();
	private Tickets tickets;
	private Servicios crud = new Servicios();
	
	public ControladorTicket(){
		setTickets(new Tickets());
	}

	// metodos
	public List<Tickets> enlistarTickets() {
		listaTickets.clear();
		listaTickets = crud.obtenerDatos();
		return listaTickets;
	}

	public Tickets obtenerTicket(int idTicket) {
		this.tickets = crud.obtenerTicket(idTicket);
		return this.tickets;
	}

	public String insertar() {
		crud.insertar(tickets);
		tickets = new Tickets();
		enlistarTickets();
		return null;
	}

	public String actualizar() {
		crud.actualizar(tickets);
		tickets = new Tickets();
		enlistarTickets();
		return null;
	}

	public String eliminar(int id) {
		crud.eliminar(id);
		tickets = new Tickets();
		enlistarTickets();
		return null;
	}
	//

	public List<Tickets> getListaTickes() {
		return listaTickets;
	}

	public void setListaTickes(List<Tickets> listaTickes) {
		this.listaTickets = listaTickes;
	}

	public Tickets getTickets() {
		return tickets;
	}

	public void setTickets(Tickets tickets) {
		this.tickets = tickets;
	}

	public static void main(String[] args) {
		ControladorTicket controladorTicket = new ControladorTicket();
		controladorTicket.enlistarTickets();

	}

}
