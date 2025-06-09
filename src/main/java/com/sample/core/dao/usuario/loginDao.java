package com.sample.core.dao.usuario;

public interface loginDao {

	public void existeUsuario(String usuario) throws Exception;

	public void existeUsuarioPassword(String usuario, String password) throws Exception;

	public void agregarReintento(String usuario) throws Exception;

}