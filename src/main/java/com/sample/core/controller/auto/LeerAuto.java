package com.sample.core.controller.auto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.core.dao.config.Conexion;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sample.core.service.AutoService;
import com.sample.core.service.AutoServiceImpl;
import domain.Auto;

@WebServlet(urlPatterns = "/LeerAuto")

public class LeerAuto extends HttpServlet {

	/*
	 * Este servlet consulta todos los autos guardados en la base de datos y los
	 * pasa al home.jsp
	 */

	private static final long serialVersionUID = 1L;
	AutoService AutoService = new AutoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			List<Auto> autos = AutoService.listarAutos();
			req.setAttribute("autos", autos);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
