package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Linea_Pedido;

public interface IGestion_Linea_Pedido {

	public abstract Linea_Pedido consultar_porCodigoSinArticulos(Integer codigoLineaPedido);
	
	public abstract Linea_Pedido consultar_porCodigoConArticulos(Integer codigoLineaPedido);
	
	public abstract Linea_Pedido consulta_porNumeroPedido(Integer numeroPedido);

	public abstract List<Linea_Pedido> consultar_Todos();
	
	public abstract List<Linea_Pedido> consultar_TodosConArticulos();

	public abstract void modificacion_Linea_Pedido(Linea_Pedido lineaPedido);

	public abstract void baja_Linea_Pedido(Linea_Pedido lineaPedido);

	public abstract void alta_Linea_Pedido(Linea_Pedido lineaPedido);

}