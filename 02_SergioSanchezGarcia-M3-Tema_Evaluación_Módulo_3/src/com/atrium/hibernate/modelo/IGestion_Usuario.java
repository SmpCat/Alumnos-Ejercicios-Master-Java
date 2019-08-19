package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Usuarios;

public interface IGestion_Usuario {

	public Usuarios consultar_PorNombre(String codUsuario);

	public abstract List<Usuarios> consultar_Todos();
		
	public abstract void alta_Usuario(Usuarios usuario);

	public abstract void baja_Usuario(Usuarios usuario);

	public abstract void modificacion_Usuario(Usuarios usuario);

}