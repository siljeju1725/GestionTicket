package com.net.gt.controladores;
import java.util.List;

import com.net.gt.modelos.Tickets;

public interface ControladorTransacciones {
	
	public List<Tickets> obtenerDatos();
	
	public Tickets obtenerTicket(int idTicket);
	
	public void insertar (Tickets p);
	
	public void actualizar (Tickets p);
	
	public void eliminar (int id);


}
