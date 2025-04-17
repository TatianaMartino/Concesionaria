package com.sample.core.controller.encargado;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Encargado;
import com.sample.core.service.encargado.EncargadoService;
import com.sample.core.service.encargado.EncargadoServiceImpl;

@WebServlet(urlPatterns = "/LoadEncargadoForm")
public class LoadEncargadoForm extends HttpServlet {

	private EncargadoService encargadoService = new EncargadoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher ds = this.getServletContext().getRequestDispatcher("/empleadoForm.jsp");

		ds.forward(req, resp);
	}
}
