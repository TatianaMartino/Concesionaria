package com.sample.core.controller.cliente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.sample.core.service.AutoService;
import com.sample.core.service.AutoServiceImpl;
import com.sample.core.service.cliente.ClienteService;
import com.sample.core.service.cliente.ClienteServiceImp;

import domain.Auto;
import domain.Cliente;
import domain.Reserva;
import domain.Vendedor;
import utils.Disponibilidad;
import utils.SituacionPedidos;

@WebServlet(urlPatterns = "/GuardarDatosCliente")

public class ClienteController extends HttpServlet {

	ClienteService clienteService = new ClienteServiceImp();
	AutoService autoService = new AutoServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//provisorio hasta que este la partede login
		HttpSession session =  req.getSession(true);
		Vendedor vendedor = new Vendedor(1, "", "", "", "","" , 1);
		session.setAttribute("CURRENT_USER", vendedor );
		//fin provisorio
		
		//Llamando al vendedor
		Vendedor vendedor2 = (Vendedor) session.getAttribute("CURRENT_USER");
		if (vendedor2 == null) {
			//Aca si el vendedor es nulo tiene que tirar error y va a redirig a otro lado.
			//Si sale esto no puede iniciar sesion
			//Hay que hacerlo en todos los controller
		}
		 try {

			Cliente cliente = new Cliente();

			// Obtener datos del auto
			String idAuto = req.getParameter("id");// aca esta el id del formulario

			if (idAuto == null) {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID del auto no proporcionado.");
				return; 
			}
			
				int idAUtoParseado = Integer.parseInt(idAuto);
				Auto auto = autoService.consultarAuto(idAUtoParseado);
				// para consultar el id del auto que esta reservando el cliente
				
				if (auto.getSucursal_id()== vendedor.getIdsucursal()) {		
						
				}
			
				
				//cambiar el estado del auto
				Disponibilidad disponibilidad = null;
				 disponibilidad = Disponibilidad.RESERVADO;
				autoService.CambiarDisponibilidad(idAUtoParseado, disponibilidad);
				auto = autoService.consultarAuto(idAUtoParseado);
				
				System.out.println("Auto con ID " + idAUtoParseado + " actualizado a estado: " + auto.getDisponibilidad());
				
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
				Reserva reserva = new Reserva(auto, Disponibilidad.RESERVADO, cliente, SituacionPedidos.PAGOPROVISORIO);
				
				// Ver datos recibidos del formulario
				System.out.println("Datos del Pedido");
				System.out.println("Cliente: " + cliente.getNombre() + "" + cliente.getApellido());
				System.out.println("Auto: " + auto.getMarca() + ", " + auto.getModelo() + "," + auto.getDisponibilidad());

				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				resp.setCharacterEncoding("utf-8");

				JsonObject obj = new JsonObject();
				obj.addProperty("estatus", "ok");
				obj.addProperty("mensaje", "Se creó exitosamente el registro");

				out.print(obj.toString());
				out.flush();


			} catch (Exception e) {
				e.printStackTrace();
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar el formulario.");
			}
		}
}