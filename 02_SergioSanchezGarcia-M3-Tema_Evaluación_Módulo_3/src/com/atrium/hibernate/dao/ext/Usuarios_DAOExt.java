package com.atrium.hibernate.dao.ext;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

/**
 * Clase para añadir consultas propies y consultas con resolución de "Carga Vaga" de Pedidos
 * 
 * @author Sergio Sánchez García 
 * @version 1.0
 * @since 10/05/2019
 *
 */

@Repository("usuario_dao")
@Scope("prototype")
public class Usuarios_DAOExt extends UsuariosDAO implements Serializable {

	/**
	 * ID serial Version 
	 */
	private static final long serialVersionUID = 1L;

	public Usuarios consultar_ConPedidos(String codUsuario) {
		// 1. Apertura de la consulta
		Criteria criteria = getCurrentSession().createCriteria(Usuarios.class);
		// 2. JOIN entre las tablas para resolver la relación
		criteria.setFetchMode("pedidos", FetchMode.JOIN);
		criteria.setFetchMode("pedidos.lineaPedido", FetchMode.JOIN);
		// 3. Resolucion de la relacion con los Artículos 
		criteria.setFetchMode("pedidos.lineaPedido.articulos", FetchMode.JOIN); 
		// 4. Clave primaria
		criteria.add(Restrictions.idEq(codUsuario));
		// 5. Realizamos la consulta
		List<Usuarios> lista =  criteria.list();
		Usuarios usuarios = null;
		if (!lista.isEmpty()) {
			usuarios = lista.get(0);
		}
		
		return usuarios;
	}

	public List<Usuarios> consultar_Todo() {
		// 1. Apertura de la consulta
		Criteria criteria = getCurrentSession().createCriteria(Usuarios.class);
		// 2. JOIN entre las tablas para resolver la relación
		criteria.setFetchMode("pedidos", FetchMode.JOIN);
		criteria.setFetchMode("pedidos.lineaPedido", FetchMode.JOIN);
		// 3. Resolucion de la relacion con los Artículos 
		criteria.setFetchMode("pedidos.lineaPedido.articulos", FetchMode.JOIN);
		// 4. Resolvemos producto cartesiano
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		// 5. Realizamos la consulta
		List<Usuarios> lista =  criteria.list();
		return lista;
	}
}
