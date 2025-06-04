package com.sample.core.controller.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.service.AutoService;
import com.sample.core.service.AutoServiceImpl;
import com.sample.core.service.cliente.ClienteService;
import com.sample.core.service.cliente.ClienteServiceImp;

import domain.Auto;
import domain.Cliente;
import domain.Pedido;
import utils.Disponibilidad;
import utils.SituacionPedidos;

@WebServlet(urlPatterns = "/GuardarDatosCliente")

public class ClienteController extends HttpServlet {

	ClienteService clienteService = new ClienteServiceImp();
	AutoService autoService = new AutoServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			Cliente cliente = new Cliente();

			// Obtener datos del auto
			String idAuto = req.getParameter("id");// aca esta el id del formulario

			if (idAuto != null) {

				int idAUtoParseado = Integer.parseInt(idAuto);
				Auto auto = autoService.consultarAuto(idAUtoParseado);
				// para consultar el id del auto que esta reservando el cliente

				// Obtener datos del cliente
				String nombre = req.getParameter("nombre");
				String apellido = req.getParameter("apellido");
				String correo = req.getParameter("correo");
				String dni = req.getParameter("dni");
				String codigo_postal = req.getParameter("codigo_postal");
				String dato_tarjeta = req.getParameter("dato_tarjeta");
				String telefono = req.getParameter("telefono");

				// Crear cliente y guardar los datos del formulario
				clienteService.guardar_datos(nombre, apellido, correo, dni, codigo_postal, dato_tarjeta, telefono);

				// Se guardaan los datos del formulario en clase cliente
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setCorreo(correo);
				cliente.setDni(dni);
				cliente.setCodigoPostal(codigo_postal);
				cliente.setDatoTarjeta(dato_tarjeta);
				cliente.setTelefono(telefono);

				// Crear Pedido
				Pedido pedido = new Pedido(auto, Disponibilidad.RESERVADO, cliente, SituacionPedidos.PAGOPROVISORIO);
				
				// Ver datos recibidos del formulario
				System.out.println("Datos del Pedido");
				System.out.println("Cliente: " + cliente.getNombre() + "" + cliente.getApellido());
				System.out.println("Auto: " + auto.getMarca() + "" + auto.getModelo());

			} else {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID del auto no proporcionado."); // en caso de que el id este vacio
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect(req.getContextPath() + "/home.jsp");  // Redirige al inicio

	}
}