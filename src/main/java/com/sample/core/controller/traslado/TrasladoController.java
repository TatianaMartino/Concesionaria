package com.sample.core.controller.traslado;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.sample.core.dao.config.Conexion;
import com.sample.core.service.traslado.*;

import domain.Traslado;

/**
 * Servlet implementation class TrasladoController
 */
@WebServlet(urlPatterns = { "/verPedidos", "/aceptarTraslado", "/crearTraslado" })
public class TrasladoController extends HttpServlet {

	private TrasladoService trasladoService = new TrasladoServiceImp();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ruta = req.getServletPath();

		if (ruta.equals("/verPedidos")) {
			// Integer sucursalOrigen =
			// Integer.parseInt(req.getParameter("sucursalOrigen")); // fija: 1 o 2

			Integer sucursalOrigen = (Integer) req.getSession().getAttribute("SUCURSAL_ID");
			try {
				List<Traslado> pedidos = trasladoService.listarPedidosRecibidos(sucursalOrigen);
				req.setAttribute("pedidos", pedidos);
				req.getRequestDispatcher("/pedidos.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
				resp.sendError(500, "Error al obtener pedidos");
			}
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ruta = req.getServletPath();

		try {
			if (ruta.equals("/aceptarTraslado")) {
				int trasladoId = Integer.parseInt(req.getParameter("id"));
				trasladoService.aceptarTraslado(trasladoId);

				// resp.sendRedirect("verPedidos?sucursalOrigen=" +
				// req.getParameter("sucursalOrigen"));
				resp.sendRedirect("verPedidos");

			} else if (ruta.equals("/crearTraslado")) {
				int autoId = Integer.parseInt(req.getParameter("autoId"));
				int origen = Integer.parseInt(req.getParameter("sucursalOrigen"));
				int destino = Integer.parseInt(req.getParameter("sucursalDestino"));
				trasladoService.crearTraslado(new Traslado(autoId, origen, destino));
				resp.sendRedirect(req.getContextPath() + "/verPedidos");
			
				 resp.setContentType("text/plain");
				    PrintWriter out = resp.getWriter();
				    out.print("ok");
				    out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500, "Error en traslado");
		}
	}

}
