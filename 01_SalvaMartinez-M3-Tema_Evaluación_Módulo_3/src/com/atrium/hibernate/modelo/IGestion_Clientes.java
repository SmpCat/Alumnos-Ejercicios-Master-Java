package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Clientes;

public interface IGestion_Clientes {

	public Clientes consultar_PorCodigo(Integer codigo_cliente);

}