package com.sample.core.dao.traslado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;

import domain.Traslado;

public class TrasladoDaoImp implements TrasladoDao{

	private Conexion conexion = Conexion.getInstance();

    @Override
    public void crear(Traslado traslado) throws Exception {
        String sql = "INSERT INTO solicitud_traslado (auto_id, sucursalOrigen_id, sucursalDestino_id, estado) VALUES (?, ?, ?, 'PENDIENTE')";
        try (PreparedStatement stmt = conexion.dameConnection().prepareStatement(sql)) {
            stmt.setInt(1, traslado.getAutoId());
            stmt.setInt(2, traslado.getSucursalOrigenId());
            stmt.setInt(3, traslado.getSucursalDestinoId());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Traslado> listarPorSucursalOrigen(int sucursalOrigenId) throws Exception {
        String sql = "SELECT * FROM solicitud_traslado WHERE sucursalOrigen_id = ? AND estado = 'PENDIENTE'";
        List<Traslado> lista = new ArrayList<>();
        try (PreparedStatement stmt = conexion.dameConnection().prepareStatement(sql)) {
            stmt.setInt(1, sucursalOrigenId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Traslado t = new Traslado(
                    rs.getInt("id"),
                    rs.getInt("auto_id"),
                    rs.getInt("sucursalOrigen_id"),
                    rs.getInt("sucursalDestino_id")
                );
                lista.add(t);
            }
        }
        return lista;
    }

    @Override
    public void aceptarTraslado(int trasladoId) throws Exception {
        Connection conn = conexion.dameConnection();
        String updateTraslado = "UPDATE solicitud_traslado SET estado = 'APROBADO' WHERE id = ?";
        String select = "SELECT auto_id, sucursalDestino_id FROM solicitud_traslado WHERE id = ?";
        String updateAuto = "UPDATE autos SET sucursal_id = ? WHERE id = ?";

        try (
            PreparedStatement psSelect = conn.prepareStatement(select);
            PreparedStatement psUpdateTraslado = conn.prepareStatement(updateTraslado);
            PreparedStatement psUpdateAuto = conn.prepareStatement(updateAuto);
        ) {
            psSelect.setInt(1, trasladoId);
            ResultSet rs = psSelect.executeQuery();
            if (rs.next()) {
                int autoId = rs.getInt("auto_id");
                int nuevaSucursal = rs.getInt("sucursalDestino_id");

                psUpdateTraslado.setInt(1, trasladoId);
                psUpdateTraslado.executeUpdate();

                psUpdateAuto.setInt(1, nuevaSucursal);
                psUpdateAuto.setInt(2, autoId);
                psUpdateAuto.executeUpdate();
            }
        }
    }
}
