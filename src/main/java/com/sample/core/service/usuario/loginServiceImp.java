package com.sample.core.service.usuario;

import com.sample.core.dao.usuario.loginDao;
import com.sample.core.dao.usuario.loginDaoImp;

public class loginServiceImp implements loginService {

	private loginDao loginDao = new loginDaoImp();

	
	
	public void consultarUsuario(String usuario) throws Exception {
		loginDao.existeUsuario(usuario);
	}


	public void consultarUsuarioYpassword(String usuario, String password) throws Exception {
		loginDao.existeUsuarioPassword(usuario, password);
	}
	

}