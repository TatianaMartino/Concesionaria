package com.sample.core.controller.auto;

import java.io.IOException;
import java.io.PrintWriter;

import com.sample.core.service.AutoService;
import com.sample.core.service.AutoServiceImpl;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AutoEliminar")
public class AutoEliminar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	AutoService autoService = new AutoServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String id = req.getParameter("id");
		
		//System.out.println("AutoEliminar - Entró al servlet");
		System.out.println("ID recibido: " + id);
			
        if (id == null || id.trim().isEmpty()) {
            req.setAttribute("mensajeError", "Error: La descripción no puede estar vacía.");
            req.getRequestDispatcher("/AutoFormBaja").forward(req, resp);
            return;     
        }
        
        int idInt = Integer.parseInt(id);
        try {
		  autoService.delete(idInt);
			
		  
		   PrintWriter out = resp.getWriter();
		   resp.setContentType("application/json");
		   resp.setCharacterEncoding("utf-8");
		   JsonObject obj = new JsonObject();
		   //resp.setStatus(200);
		   obj.addProperty("estatus","ok");
		   obj.addProperty("mensaje","Se elimino correctamente el registro");
		   out.print(obj.toString());
		   out.flush();	   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

	}
}