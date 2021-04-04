package com.net.gt.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.net.gt.modelos.Tickets;
import java.sql.*;
import com.net.gt.conexion.ConexionBD;

public class Controlador implements ControladorTransacciones {

	private ConexionBD conexion;

	public Controlador() {
		conexion = new ConexionBD();

	}

	@Override
	public List<Tickets> obtenerDatos() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn = conexion.conectar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Tickets> listaTickets = new ArrayList<Tickets>();
		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT idTicket , titulo, descripcion , estado, prioridad, fechaCreacion, nombreAsignado  FROM db_tickets.tickets");

			while (rs.next()) {
				Tickets tickets = new Tickets(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						null,
						null,//rs.getDate(6),
						null,
						null,
						null//rs.getString(7)
						);
			
				listaTickets.add(tickets);

			}
		} catch (Exception e) {
			System.out.println("Me cai no se porque me caigo :" + e);
		}
		try {
			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaTickets;
	}

	@Override
	public Tickets obtenerTicket(int idTicket) {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn = conexion.conectar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Tickets tic = null;

		try {
			String sentencia = "SELECT * FROM db_tickets.tickets where idTicket =?";
			ResultSet rs = null;
			PreparedStatement ps = null;
			ps = conn.prepareStatement(sentencia);
			ps.setInt(1, idTicket);
			rs = ps.executeQuery();
			System.out.println("Realiza ejecucuion");
			if (rs.next()) {
				tic = new Tickets(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getString(10));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(tic.getNombreAsignado());

		return tic;
	}

	@Override
	public void insertar(Tickets p) {
		String sentencia = "insert into db_tickets.tickets  (titulo, descripcion , estado,  prioridad, porcentajeAvance, fechaCreacion,"
				+ " idUsuario, idAsignado, nombreAsignado)\r\n"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		try {
			PreparedStatement ps = null;
			Connection conn = conexion.conectar();
			ps = conn.prepareStatement(sentencia);
			ps.setString(1, p.getTitulo());
			ps.setString(2, p.getDescripcion());
			ps.setString(3, p.getEstado());
			ps.setString(4, p.getPrioridad());
			ps.setInt(5, p.getPorcentajeAvance());
			ps.setDate(6, p.getFechaCreacion());
			ps.setInt(7, p.getIdUsuario());
			ps.setInt(8, p.getIdAsignado());
			ps.setString(9, p.getNombreAsignado());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actualizar(Tickets p) {
		String sentencia = "insert into db_tickets.tickets  (titulo=?, descripcion=?, estado=?,  prioridad=?, porcentajeAvance=?, fechaCreacion=?, idUsuario=?, idAsignado=?, nombreAsignado=?) ";
		try {
			PreparedStatement ps = null;
			Connection conn = conexion.conectar();
			ps = conn.prepareStatement(sentencia);
			ps.setString(1, p.getTitulo());
			ps.setString(2, p.getDescripcion());
			ps.setString(3, p.getEstado());
			ps.setString(4, p.getPrioridad());
			ps.setInt(5, p.getPorcentajeAvance());
			ps.setDate(6, p.getFechaCreacion());
			ps.setInt(7, p.getIdUsuario());
			ps.setInt(8, p.getIdAsignado());
			ps.setString(9, p.getNombreAsignado());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void eliminar(int id) {
		String sentencia = "delete * from db_tickets.tickets where id=?";

		try {
			PreparedStatement ps = null;
			Connection conn = conexion.conectar();
			ps = conn.prepareStatement(sentencia);
		} catch (Exception e) {
			
		}
	}

	public static void main(String[] args) {
		Controlador conexionprueba = new Controlador();
		conexionprueba.obtenerTicket(1);
	}

}
