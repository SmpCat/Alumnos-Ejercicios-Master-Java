package com.atrium.hibernate.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.atrium.hibernate.Linea_Pedido;

/**
 * DAO de Linea_Pedido
 * 
 * @see com.atrium.hibernate.Linea_Pedido
 * @author Sergio Sánchez García
 */

public class LineaPedidoDAO {
	private static final Logger log = LoggerFactory.getLogger(LineaPedidoDAO.class);

	// Constantes de búsqueda 
	private static final String CODIGO_LINEA_PEDIDO = "codigoLineaPedido";
	private static final String CODIGO_ARTICULO = "codigoArticulo";
	private static final String NUMERO_PEDIDO = "numeroPedido";
	private static final String PRECIO_UNIDAD_ARTICULO = "precioUnidadArticulo";
	private static final String NUMERO_UNIDADES_ARTICULO = "numeroUnidadesArticulo";
	private static final String PORCENTAJE_DESCUENTO = "porcentajeDescuento";
	
	// Session 
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Linea_Pedido transientInstance) {
		log.debug("saving Linea_Pedido instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Linea_Pedido persistentInstance) {
		log.debug("deleting Linea_Pedido instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Linea_Pedido findById(Integer codigoLineaPedido) {
		log.debug("getting Linea_Pedido instance with id: " + codigoLineaPedido);
		try {
			Linea_Pedido instance = (Linea_Pedido) getCurrentSession().get(
					"com.atrium.hibernate.Linea_Pedido", codigoLineaPedido);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Linea_Pedido> findByExample(Linea_Pedido instance) {
		log.debug("finding Linea_Pedido instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Linea_Pedido> results = (List<Linea_Pedido>) getCurrentSession()
					.createCriteria("com.atrium.hibernate.Linea_Pedido")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Linea_Pedido> findByProperty(String propertyName, Object value) {
		log.debug("finding Linea_Pedido instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Linea_Pedido as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	
	// Métodos de búsqueda por caracteristica 
	
	public List<Linea_Pedido> findByCodigoLineaPedido(Object codigoLineaPedido) {
		return findByProperty(CODIGO_LINEA_PEDIDO, codigoLineaPedido);
	}
	public List<Linea_Pedido> findByCodigoArticulo(Object codigoArticulo) {
		return findByProperty(CODIGO_ARTICULO, codigoArticulo);
	}
	public List<Linea_Pedido> findByNumeroPedido(Object numeroPedido) {
		return findByProperty(NUMERO_PEDIDO, numeroPedido);
	}
	public List<Linea_Pedido> findByPrecioUnidadArticulo(Object precioUnidadArticulo) {
		return findByProperty(PRECIO_UNIDAD_ARTICULO, precioUnidadArticulo);
	}
	public List<Linea_Pedido> findByNumeroUnidadesArticulo(Object numeroUnidadesArticulo) {
		return findByProperty(NUMERO_UNIDADES_ARTICULO, numeroUnidadesArticulo);
	}
	public List<Linea_Pedido> findByPorcentajeDescuento(Object porcentajeDescuento) {
		return findByProperty(PORCENTAJE_DESCUENTO, porcentajeDescuento);
	}

	// Búsqueda de Todas las Lineas de Pedido 
	public List<Linea_Pedido> findAll() {
		log.debug("finding all Linea_Pedido instances");
		try {
			String queryString = "from Linea_Pedido";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Linea_Pedido merge(Linea_Pedido detachedInstance) {
		log.debug("merging Linea_Pedido instance");
		try {
			Linea_Pedido result = (Linea_Pedido) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Linea_Pedido instance) {
		log.debug("attaching dirty Linea_Pedido instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Linea_Pedido instance) {
		log.debug("attaching clean Linea_Pedido instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LineaPedidoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (LineaPedidoDAO) ctx.getBean("LineaPedidoDAO");
	}
}