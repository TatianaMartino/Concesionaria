package com.sample.core.controller.auto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.core.dao.config.Conexion;
import com.sample.core.service.*;
import com.sample.core.dao.auto.*;
import java.sql.Statement;

/**
 * Servlet implementation class AutoListarEstados
 */
@WebServlet("/autosReservados")
public class AutoListarEstados extends HttpServlet {

    private AutoService AutoService = new AutoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("autosReservados", AutoService.listarAutosReservados());
            req.getRequestDispatcher("/listarAutosReservados.jsp").forward(req, resp); // Crea este JSP
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
