package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Pedidos;

public interface IGestion_Pedidos {

	public List<Pedidos> consultar_Pedidos();

	public abstract List<Pedidos> consultar_ConClientes();

}