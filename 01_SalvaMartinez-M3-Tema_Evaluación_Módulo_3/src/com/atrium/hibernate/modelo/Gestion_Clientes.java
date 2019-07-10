package com.atrium.hibernate.modelo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Clientes;
import com.atrium.hibernate.dao.ClientesDAO;

@Component("gestion_clientes")
@Scope("prototype")
public class Gestion_Clientes implements IGestion_Clientes {

	private ClientesDAO cliente_dao;

	@Override
	@Transactional(readOnly = true)
	public Clientes consultar_PorCodigo(Integer codigo_cliente) {
		return cliente_dao.findById(codigo_cliente);
	}

	// ACCESORES PARA SPRING
	public void setCliente_dao(ClientesDAO cliente_dao) {
		this.cliente_dao = cliente_dao;
	}

}
