package com.net.gt.modelos;
import java.sql.Date;



public class Tickets {
	
	public Tickets(){
		
	}
	
	private Integer idTicket;
	private String  titulo;
	private String  descripcion;
	private String  estado;
	private String  prioridad;
	private Integer porcentajeAvance;
	private Date    fechaCreacion;
	private Integer idUsuario;
	private Integer idAsignado;
	private String  nombreAsignado;
	
	
	
	public Tickets(Integer idTicket, String titulo, String descripcion, String estado, String prioridad,
			Integer porcentajeAvance, Date fechaCreacion, Integer idUsuario, Integer idAsignado,
			String nombreAsignado) {
		super();
		this.idTicket = idTicket;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.prioridad = prioridad;
		this.porcentajeAvance = porcentajeAvance;
		this.fechaCreacion = fechaCreacion;
		this.idUsuario = idUsuario;
		this.idAsignado = idAsignado;
		this.nombreAsignado = nombreAsignado;
	}
	
	public Integer getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	public Integer getPorcentajeAvance() {
		return porcentajeAvance;
	}
	public void setPorcentajeAvance(Integer porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdAsignado() {
		return idAsignado;
	}
	public void setIdAsignado(Integer idAsignado) {
		this.idAsignado = idAsignado;
	}
	public String getNombreAsignado() {
		return nombreAsignado;
	}
	public void setNombreAsignado(String nombreAsignado) {
		this.nombreAsignado = nombreAsignado;
	}

}
