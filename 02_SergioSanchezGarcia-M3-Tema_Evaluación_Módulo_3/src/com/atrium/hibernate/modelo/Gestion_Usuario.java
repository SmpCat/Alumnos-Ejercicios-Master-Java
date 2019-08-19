package com.atrium.hibernate.modelo;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

@Component("gestion_usuario")
@Scope("prototype")
public class Gestion_Usuario implements IGestion_Usuario, Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
	private UsuariosDAO usuario_dao;

	@Override
	@Transactional(readOnly = true)
	public Usuarios consultar_PorNombre(String codUsuario) {
		return usuario_dao.findById(codUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuarios> consultar_Todos() {
		return usuario_dao.findAll();
	}
	
	// ***** OPERACIONES CRUD ******

	@Override
	@Transactional
	public void alta_Usuario(Usuarios usuario) {
		usuario_dao.save(usuario);
	}

	@Override
	@Transactional
	public void baja_Usuario(Usuarios usuario) {
		usuario_dao.delete(usuario);
	}

	@Override
	@Transactional
	public void modificacion_Usuario(Usuarios usuario) {
		usuario_dao.attachDirty(usuario);
	}

	// ACCESORES PARA SPRING
	public void setUsuario_dao(UsuariosDAO usuario_dao) {
		this.usuario_dao = usuario_dao;
	}

}
