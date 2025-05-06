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
import domain.Pedido;
import utils.Disponibilidad;

@WebServlet(urlPatterns = "/GuardarDatosCliente")

public class ClienteController extends HttpServlet {

	ClienteService clienteService = new ClienteServiceImp();
	AutoService autoService = new AutoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
				Auto auto = null;

				Pedido pedido; //Generamos un pedido
				
			   String idAuto = req.getParameter("id");
				int idAUtoParseado = Integer.parseInt(idAuto);
				
				
					try {
					 auto =	autoService.consultarAuto(idAUtoParseado); //para consultar el id del auto que esta reservando el cliente
					 pedido = new Pedido(auto, Disponibilidad.RESERVADO);
					 
					 
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			   
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String correo = req.getParameter("correo");
		String dni = req.getParameter("dni");
		String codigo_postal = req.getParameter("codigo_postal");
		String dato_tarjeta = req.getParameter("dato_tarjeta");
		String telefono = req.getParameter("telefono");

		
		// Ver datos recibidos del formulario
		System.out.println("nombre: " + nombre);
		System.out.println("apellido: " + apellido);
		System.out.println("correo: " + correo);
		System.out.println("dni: " + dni);
		System.out.println("codigo_postal: " + codigo_postal);
		System.out.println("dato_tarjeta: " + correo);
		System.out.println("telefono: " + telefono);

		try {
			clienteService.guardar_datos(nombre, apellido, correo, dni, codigo_postal, dato_tarjeta, telefono);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
