package com.atrium.hibernate.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.LineaPedido;

/**
 * A data access object (DAO) providing persistence and search support for
 * LineaPedido entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.atrium.hibernate.LineaPedido
 * @author MyEclipse Persistence Tools
 */
@Component("lineas_dao")
@Scope("prototype")
public class LineaPedidoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LineaPedidoDAO.class);
	// property constants
	public static final String PRECIO_UNIDAD_ARTICULO = "precioUnidadArticulo";
	public static final String NUMERO_UNIDADES_ARTICULO = "numeroUnidadesArticulo";
	public static final String PORCENTAJE_DESCUENTO = "porcentajeDescuento";

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

	public void save(LineaPedido transientInstance) {
		log.debug("saving LineaPedido instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LineaPedido persistentInstance) {
		log.debug("deleting LineaPedido instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LineaPedido findById(java.lang.Long id) {
		log.debug("getting LineaPedido instance with id: " + id);
		try {
			LineaPedido instance = (LineaPedido) getCurrentSession().get(
					"com.atrium.hibernate.LineaPedido", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<LineaPedido> findByExample(LineaPedido instance) {
		log.debug("finding LineaPedido instance by example");
		try {
			List<LineaPedido> results = (List<LineaPedido>) getCurrentSession()
					.createCriteria("com.atrium.hibernate.LineaPedido")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding LineaPedido instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from LineaPedido as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<LineaPedido> findByPrecioUnidadArticulo(
			Object precioUnidadArticulo) {
		return findByProperty(PRECIO_UNIDAD_ARTICULO, precioUnidadArticulo);
	}

	public List<LineaPedido> findByNumeroUnidadesArticulo(
			Object numeroUnidadesArticulo) {
		return findByProperty(NUMERO_UNIDADES_ARTICULO, numeroUnidadesArticulo);
	}

	public List<LineaPedido> findByPorcentajeDescuento(
			Object porcentajeDescuento) {
		return findByProperty(PORCENTAJE_DESCUENTO, porcentajeDescuento);
	}

	public List findAll() {
		log.debug("finding all LineaPedido instances");
		try {
			String queryString = "from LineaPedido";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LineaPedido merge(LineaPedido detachedInstance) {
		log.debug("merging LineaPedido instance");
		try {
			LineaPedido result = (LineaPedido) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LineaPedido instance) {
		log.debug("attaching dirty LineaPedido instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LineaPedido instance) {
		log.debug("attaching clean LineaPedido instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LineaPedidoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (LineaPedidoDAO) ctx.getBean("LineaPedidoDAO");
	}
}