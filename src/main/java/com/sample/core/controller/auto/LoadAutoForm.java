package com.sample.core.controller.auto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Auto;
import com.sample.core.service.AutoServiceImpl;
import com.sample.core.service.AutoService;
import com.sample.core.service.AutoServiceImpl;
import com.sample.core.service.AutoService;

@WebServlet(urlPatterns = "/loadAutoForm")
public class LoadAutoForm extends HttpServlet {

	private AutoService AutoService = new AutoServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	RequestDispatcher ds = this.getServletContext().getRequestDispatcher("/autoForm.jsp");
		
		try {
			req.setAttribute("auto", AutoService.listarAutos());
			String id = req.getParameter("id");
			 
			System.err.println(id);
			 
			 Auto Auto =  AutoService.consultarAuto( Integer.parseInt(id) );
			 
			req.setAttribute("auto", Auto);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ds.forward(req, resp);
		
	}
	
}
