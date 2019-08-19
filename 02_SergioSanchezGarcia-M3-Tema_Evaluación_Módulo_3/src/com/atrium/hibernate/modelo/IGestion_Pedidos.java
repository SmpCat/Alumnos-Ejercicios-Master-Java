package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Pedidos;

public interface IGestion_Pedidos {

	public Pedidos consultar_porNumeroPedido(Integer numero_pedido);
	
	public abstract Pedidos consultar_porNumeroPedidoVaga(Integer numeroPedido);

	public abstract List<Pedidos> consultar_todos(String nombreUsuario);
	
	public abstract List<Pedidos> consultar_todosVaga(String nombreUsuario);

	public abstract void modificacion_Pedido(Pedidos pedido);

	public abstract void baja_Pedido(Pedidos pedido);

	public abstract void alta_Pedido(Pedidos pedido);

}