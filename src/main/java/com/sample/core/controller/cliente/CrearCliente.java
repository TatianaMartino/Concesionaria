package com.sample.core.controller.cliente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.sample.core.service.cliente.ClienteService;
import com.sample.core.service.cliente.ClienteServiceImp;

@WebServlet(urlPatterns = "/CrearCliente")
public class CrearCliente {

	private static final long serialVersionUID = 1L;
	ClienteService clienteService = new ClienteServiceImp();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String correo = req.getParameter("correo");
		String dni = req.getParameter("dni");
		String codigo_postal = req.getParameter("codigo_postal");
		String dato_tarjeta = req.getParameter("dato_tarjeta");
		String telefono = req.getParameter("telefono");

		try {
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

	}
}