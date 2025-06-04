package com.sample.core.controller.vendedor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.service.vendedor.VendedorService;
import com.sample.core.service.vendedor.VendedorServiceImpl;

import domain.Vendedor;

@WebServlet(urlPatterns = "/LoadEncargadoForm")
public class LoadVendedorForm extends HttpServlet {

	private VendedorService encargadoService = new VendedorServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher ds = this.getServletContext().getRequestDispatcher("/empleadoForm.jsp");

		ds.forward(req, resp);
	}
}
