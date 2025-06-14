package com.sample.core.controller.vendedor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.sample.core.dao.config.Conexion;
import com.sample.core.service.vendedor.VendedorService;
import com.sample.core.service.vendedor.VendedorServiceImpl;

import domain.Vendedor;

@WebServlet(urlPatterns = "/Ingresar" )
public class VendedorController extends HttpServlet { // hereda de HttpServlet, lo que le permite manejar solicitudes
														// HTTP.

	VendedorService vendedorService = new VendedorServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String usuario = req.getParameter("usuario");
		String password = req.getParameter("password");		
		
		try {
			
			if (usuario.length()== 0 || usuario == null)
				throw new Exception("usuario vacio");
			
			if (password.length()== 0 || password == null)
				throw new Exception("password vacio");
					
			//vendedorService.existeUsuario(usuario);;
			//vendedorService.existeUsuarioPassword(usuario, password);
			
			/*	HttpSession jsession = req.getSession(true);
			jsession.setAttribute("CURRENT_USER", usuario);
			resp.addCookie(new Cookie("JSESSIONID", jsession.getId()));
			*/
			
			 Vendedor vendedor = vendedorService.login(usuario, password);
			 
			  HttpSession jsession = req.getSession(true);
		        jsession.setAttribute("CURRENT_USER", vendedor.getUsuario());
		        jsession.setAttribute("SUCURSAL_ID", vendedor.getIdsucursal());		
		        resp.addCookie(new Cookie("JSESSIONID", jsession.getId()));
			 

			setOutResponse("se logeo corretamente", resp, 200, "ok");

		} catch (Exception e) {
			setOutResponse(e.getMessage(), resp, 400, "error");
			
		}

	}
	
	private void setOutResponse(String mensaje,HttpServletResponse resp, int code, String status) throws IOException {
		 PrintWriter out = resp.getWriter();
		 resp.setContentType("application/json");
		 resp.setCharacterEncoding("utf-8");
		 JsonObject obj = new JsonObject();
		 resp.setStatus(code);
		 obj.addProperty("estatus", status);
		 obj.addProperty("mensaje",mensaje);
		 out.print(obj.toString());
		 out.flush();
	}
		
		
		
	}

