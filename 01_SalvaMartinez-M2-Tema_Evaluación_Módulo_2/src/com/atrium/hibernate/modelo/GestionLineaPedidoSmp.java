package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.LineaPedidoSmp;
import com.atrium.hibernate.dao.LineaPedidoSmpDAO;

/**
 * 
 * Ejemplo de fachada para el uso de transacciones con spring. La definicion de
 * las transacciones con anotaciones en la clase.
 * 
 */

@Component("gestionLineaPedidoSmp")
@Scope("prototype")
public class GestionLineaPedidoSmp implements IGestionLineaPedidoSmp {

	private LineaPedidoSmpDAO lineaPedidoSmpDAO;
	
	// ***************** CONSULTAS DE ARTÍCULOS
	@Override
	@Transactional(readOnly = true)
	public LineaPedidoSmp consultarPorCodigoLineaPedido(Long codigoLineaPedido) {
		return lineaPedidoSmpDAO.findById(codigoLineaPedido);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LineaPedidoSmp> consultarLineaPedidoSmpTodos() {
		List<LineaPedidoSmp> lista = lineaPedidoSmpDAO.findAll();
		return lista;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<LineaPedidoSmp> consultarPorPedidoLineaPedido(Integer numeroPedido) {
		List<LineaPedidoSmp> lista = lineaPedidoSmpDAO.findByNumeroPedido(numeroPedido);
		return lista;
	}

	// *************** OPERACIONES CRUD ARTÍCULOS

	@Override
	@Transactional
	public void altaLineaPedidoSmp(LineaPedidoSmp lineaPedidoSmp) {
		lineaPedidoSmpDAO.save(lineaPedidoSmp);
	}

	@Override
	@Transactional
	public void bajaLineaPedidoSmp(LineaPedidoSmp lineaPedidoSmp) {
		lineaPedidoSmpDAO.delete(lineaPedidoSmp);
	}

	@Override
	@Transactional
	public void modificionLineaPedidoSmp(LineaPedidoSmp lineaPedidoSmp) {
		lineaPedidoSmpDAO.attachDirty(lineaPedidoSmp);
	}

	// ACCESORES PARA SPRING
	
	public void setLineaPedidoSmpDAO(LineaPedidoSmpDAO lineaPedidoSmpDAO) {
		this.lineaPedidoSmpDAO = lineaPedidoSmpDAO;
	}
}
