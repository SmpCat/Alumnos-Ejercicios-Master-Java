package com.atrium.hibernate.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.LineaPedidoSmp;

/**
 * A data access object (DAO) providing persistence and search support for
 * LineaPedidoSmp entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.atrium.hibernate.LineaPedidoSmp
 * @author MyEclipse Persistence Tools
 */
@Repository("lineaPedidoSmpDAO")
@Scope("prototype")
public class LineaPedidoSmpDAO {
	private static final Logger log = LoggerFactory.getLogger(LineaPedidoSmpDAO.class);
	// property constants
	public static final String CODIGO_ARTICULO = "codigoArticulo";
	public static final String NUMERO_PEDIDO = "numeroPedido";
	public static final String PRECIO_UNIDAD_ARTICULO = "precioUnidadArticulo";
	public static final String NUMERO_UNIDADES_ARTICULO = "numeroUnidadesArticulo";
	public static final String PORCENTAJE_DESCUENTO = "porcentajeDescuento";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(LineaPedidoSmp transientInstance) {
		log.debug("saving LineaPedidoSmp instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LineaPedidoSmp persistentInstance) {
		log.debug("deleting LineaPedidoSmp instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LineaPedidoSmp findById(java.lang.Long id) {
		log.debug("getting LineaPedidoSmp instance with id: " + id);
		try {
			LineaPedidoSmp instance = (LineaPedidoSmp) getCurrentSession()
					.get("com.atrium.hibernate.LineaPedidoSmp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LineaPedidoSmp instance) {
		log.debug("finding LineaPedidoSmp instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.atrium.hibernate.LineaPedidoSmp")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding LineaPedidoSmp instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from LineaPedidoSmp as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCodigoArticulo(Object codigoArticulo) {
		return findByProperty(CODIGO_ARTICULO, codigoArticulo);
	}

	public List findByNumeroPedido(Object numeroPedido) {
		return findByProperty(NUMERO_PEDIDO, numeroPedido);
	}

	public List findByPrecioUnidadArticulo(Object precioUnidadArticulo) {
		return findByProperty(PRECIO_UNIDAD_ARTICULO, precioUnidadArticulo);
	}

	public List findByNumeroUnidadesArticulo(Object numeroUnidadesArticulo) {
		return findByProperty(NUMERO_UNIDADES_ARTICULO, numeroUnidadesArticulo);
	}

	public List findByPorcentajeDescuento(Object porcentajeDescuento) {
		return findByProperty(PORCENTAJE_DESCUENTO, porcentajeDescuento);
	}

	public List findAll() {
		log.debug("finding all LineaPedidoSmp instances");
		try {
			String queryString = "from LineaPedidoSmp";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LineaPedidoSmp merge(LineaPedidoSmp detachedInstance) {
		log.debug("merging LineaPedidoSmp instance");
		try {
			LineaPedidoSmp result = (LineaPedidoSmp) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LineaPedidoSmp instance) {
		log.debug("attaching dirty LineaPedidoSmp instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LineaPedidoSmp instance) {
		log.debug("attaching clean LineaPedidoSmp instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LineaPedidoSmpDAO getFromApplicationContext(ApplicationContext ctx) {
		return (LineaPedidoSmpDAO) ctx.getBean("LineaPedidoSmpDAO");
	}
}