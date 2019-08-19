package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Linea_Pedido;
import com.atrium.hibernate.dao.ext.Linea_Pedido_DAOExt;

/**
 * Clase para la Gestion de Linea_Pedido
 * 
 * @author Sergio Sánchez García 
 * @version 1.0
 * @since 10/05/2019
 *
 */
@Repository("gestion_linea_pedido")
@Scope("prototype") 
public class Gestion_Linea_Pedido implements IGestion_Linea_Pedido {

	private Linea_Pedido_DAOExt lineaPedido_dao;

	// **** CONSULTAS DE PEDIDOS ****
	@Override
	@Transactional(readOnly = true)
	public Linea_Pedido consultar_porCodigoSinArticulos(Integer codigoLineaPedido) {
		return lineaPedido_dao.findByCodigoLineaPedido(codigoLineaPedido).get(0); 
	}
	
	@Override
	@Transactional(readOnly = true)
	public Linea_Pedido consultar_porCodigoConArticulos(Integer codigoLineaPedido) {
		return lineaPedido_dao.consultar_porCodigoConArticulos(codigoLineaPedido);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Linea_Pedido consulta_porNumeroPedido(Integer numeroPedido) {
		return lineaPedido_dao.findByNumeroPedido(numeroPedido).get(0); 
	}

	@Override
	@Transactional(readOnly = true)
	public List<Linea_Pedido> consultar_Todos() {
		List<Linea_Pedido> lista = lineaPedido_dao.findAll();
		return lista;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Linea_Pedido> consultar_TodosConArticulos() {
		List<Linea_Pedido> lista = lineaPedido_dao.consultar_TodoConArticulos();
		return lista;
	}

	// ***** OPERACIONES CRUD ******

	@Override
	@Transactional
	public void alta_Linea_Pedido(Linea_Pedido Lineapedido) {
		lineaPedido_dao.save(Lineapedido);
	}

	@Override
	@Transactional
	public void baja_Linea_Pedido(Linea_Pedido Lineapedido) {
		lineaPedido_dao.delete(Lineapedido);
	}

	@Override
	@Transactional
	public void modificacion_Linea_Pedido(Linea_Pedido Lineapedido) {
		lineaPedido_dao.attachDirty(Lineapedido);
	}
	
	// Accesor Spring
	public void setLineaPedido_dao(Linea_Pedido_DAOExt linea_pedido_dao) {
		this.lineaPedido_dao = linea_pedido_dao;
	}

}
