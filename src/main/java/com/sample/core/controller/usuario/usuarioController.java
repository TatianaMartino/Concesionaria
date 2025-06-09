package com.sample.core.controller.usuario;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.sample.core.service.usuario.loginService;
import com.sample.core.service.usuario.loginServiceImp;

import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/Ingresar")

public class usuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	loginService usuarioservice = new loginServiceImp();

@WebServlet ( urlPatterns =  "/ingresarUsuario")
public class IngresarUsuario extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	loginService usuarioservice = new loginServiceImp();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String usuario = req.getParameter("usuario");
		String password = req.getParameter("password");		
		
		try {
			
			if (usuario.length()== 0 || usuario == null)
				throw new Exception("usuario vacio");
			
			if (password.length()== 0 || password == null)
				throw new Exception("password vacio");
					
			usuarioservice.consultarUsuario(usuario);
			
			usuarioservice.consultarUsuarioYpassword(usuario, password);
			
			HttpSession jsession = req.getSession(true);
			jsession.setAttribute("CURRENT_USER", usuario);
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
}
