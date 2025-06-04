package com.sample.core.controller.vendedor;

import java.io.IOException;
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

import com.sample.core.dao.config.Conexion;
import com.sample.core.service.vendedor.VendedorService;
import com.sample.core.service.vendedor.VendedorServiceImpl;

@WebServlet(urlPatterns = "/CrearEncargado")
public class VendedorController extends HttpServlet { // hereda de HttpServlet, lo que le permite manejar solicitudes
														// HTTP.

	VendedorService encargadoService = new VendedorServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Obtener datos del formulario en index
		// dentro de getParameter, cada parametro debe ser igual a los atributos "name"
		// de las etiquetas input del formulario

		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String usuario = req.getParameter("usuario");
		String contra = req.getParameter("contra");
		String correo = req.getParameter("correo");
		String idSucursalString = req.getParameter("idSucursal");
		int idSucursal = 0;

		// Conventir los valores de String a int
		try {
			idSucursal = Integer.parseInt(idSucursalString);
		} catch (NumberFormatException e) {
			req.setAttribute("mensajeError", "Error: El valor no es válido");
	        req.getRequestDispatcher("/loadEncargadoForm").forward(req, resp); //Redirige al formulario de nuevo (/loadAutoForm) para que el usuario corrija el error.
			return;
		}

		// Ver datos recibidos del formulario
		System.out.println("nombre: " + nombre);
		System.out.println("apellido: " + apellido);
		System.out.println("usuario: " + usuario);
		System.out.println("contra: " + contra);
		System.out.println("correo: " + correo);
		System.out.println("idSucursal: " + idSucursal);

		try {
			encargadoService.crearEncargado(nombre, apellido, usuario, contra, correo, idSucursal);
			/*
			 * RequestDispatcher dispatcher = req.getRequestDispatcher("/LeerDatosBebidas");
			 */
			/* dispatcher.forward(req, resp); */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
