package com.sample.core.controller.auto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.sample.core.dao.config.Conexion;
import com.sample.core.service.AutoService;
import com.sample.core.service.AutoServiceImpl;

import utils.Disponibilidad;

@WebServlet(urlPatterns = {"/crearAuto", "/actualizarEstadoAuto"}) //creamos dos url, una para actualizarEstado y uno para crearAuto

public class AutoController extends HttpServlet {

	AutoService AutoService = new AutoServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();  // Saber qué URL fue llamada

		 if ("/crearAuto".equals(path)) {
		
		// Ver datos recibidos del formulario en pantalla de Eclipse

		String modelo = req.getParameter("modelo");
		String marca = req.getParameter("marca");
		String descripcion = req.getParameter("descripcion");
		String stockString = req.getParameter("stock");
		String precioString = req.getParameter("precio");
		String sucursalIdString = req.getParameter("sucursal_id");
		String disponibilidad = req.getParameter("disponibilidad");
		int stockInt = 0;
		int precioInt = 0;
		int sucursalId = 0;

		// Convertir los valores de String a int
		precioInt = Integer.parseInt(precioString);
		stockInt = Integer.parseInt(stockString);
		sucursalId = Integer.parseInt(sucursalIdString);

		// Ver datos recibidos del formulario en pantalla de Eclipse
		// id, modelo, marca, descripcion, precio, sucursal_id, stock, disponibilidad
		System.out.println("modelo: " + modelo);
		System.out.println("marca: " + marca);
		System.out.println("descripcion: " + descripcion);
		System.out.println("stock: " + stockString);
		System.out.println("precio: " + precioString);
		System.out.println("sucursal id: " + sucursalId);
		System.out.println("Disponibilidad: " + disponibilidad);

		try {
			AutoService.crearAuto(modelo, marca, descripcion, stockInt, precioInt, sucursalId, disponibilidad);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			JsonObject obj = new JsonObject();
			// resp.setStatus(200);
			obj.addProperty("estatus", "ok");
			obj.addProperty("mensaje", "Se creo exitosamente el registro");
			out.print(obj.toString());
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else if ("/actualizarEstadoAuto".equals(path)) {
            procesarActualizarEstadoAuto(req, resp);

        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
		 
		 @Override
		    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		        String path = req.getServletPath();

		        if ("/actualizarEstadoAuto".equals(path)) {
		            procesarActualizarEstadoAuto(req, resp);
		        } else {
		            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		        }
		    }

		    private void procesarActualizarEstadoAuto(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		        String autoIdStr = req.getParameter("autoId");
		        String accion = req.getParameter("accion");

		        int Id;
		        Id = Integer.parseInt(autoIdStr);
		        
		        Disponibilidad disponibilidad = null;
		        if ("reservar".equalsIgnoreCase(accion)) {
		            disponibilidad = Disponibilidad.RESERVADO;
		        } else if ("comprar".equalsIgnoreCase(accion)) {
		            disponibilidad = Disponibilidad.COMPRADO;
		        } else if ("cancelar".equalsIgnoreCase(accion)) {
		            disponibilidad = Disponibilidad.DISPONIBLE;
		        }else {
		            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción inválida");
		            return;
		        }

		        try {
		            AutoService.CambiarDisponibilidad(Id, disponibilidad);

		        } catch (Exception e) {
		            e.printStackTrace();
		            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar estado");
		        }
		        
		        resp.sendRedirect(req.getContextPath() + "/LeerAuto"); 

		    }
		 

	}
