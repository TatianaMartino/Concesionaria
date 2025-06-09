package com.sample.core.service.usuario;

import java.util.List;
import domain.Usuario;

public interface loginService {

	public void consultarUsuario(String usuario) throws Exception;

	public void consultarUsuarioYpassword(String usuario, String password) throws Exception;

}
