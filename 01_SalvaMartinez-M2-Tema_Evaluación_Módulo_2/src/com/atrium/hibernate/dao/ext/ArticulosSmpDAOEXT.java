package com.atrium.hibernate.dao.ext;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.atrium.hibernate.ArticulosSmp;
import com.atrium.hibernate.dao.ArticulosSmpDAO;

@Repository("articuloSmpDAOEXT")
@Scope("prototype")
public class ArticulosSmpDAOEXT extends ArticulosSmpDAO{

	public List<ArticulosSmp> consultarTodosArticulosOrdenados() {
		// ABRIMOS LA CONSULTA
		Criteria criteria = getCurrentSession().createCriteria(ArticulosSmp.class);
		// ORDENACIÓN POR CÓDIGO DE ARTÍCULO
		criteria.addOrder(Order.asc("codigoArticulo"));
		// RETORNAMOS EL VALOR DE LA CONSULTA
		return criteria.list();
	}
}
