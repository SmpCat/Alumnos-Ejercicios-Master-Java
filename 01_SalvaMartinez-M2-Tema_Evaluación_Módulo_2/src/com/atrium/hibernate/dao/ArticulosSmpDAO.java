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

import com.atrium.hibernate.ArticulosSmp;

/**
 * A data access object (DAO) providing persistence and search support for
 * ArticulosSmp entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.atrium.hibernate.ArticulosSmp
 * @author MyEclipse Persistence Tools
 */

@Repository("articuloSmpDAO")
@Scope("prototype")
public class ArticulosSmpDAO {
	private static final Logger log = LoggerFactory.getLogger(ArticulosSmpDAO.class);
	// property constants
	public static final String DESCRIPCION_ARTICULO = "descripcionArticulo";
	public static final String PRECIO_UNIDAD_ARTICULO = "precioUnidadArticulo";
	public static final String CANTIDAD = "cantidad";

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

	public void save(ArticulosSmp transientInstance) {
		log.debug("saving ArticulosSmp instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ArticulosSmp persistentInstance) {
		log.debug("deleting ArticulosSmp instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ArticulosSmp findById(java.lang.Integer id) {
		log.debug("getting ArticulosSmp instance with id: " + id);
		try {
			ArticulosSmp instance = (ArticulosSmp) getCurrentSession().get("com.atrium.hibernate.ArticulosSmp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ArticulosSmp instance) {
		log.debug("finding ArticulosSmp instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.atrium.hibernate.ArticulosSmp")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ArticulosSmp instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from ArticulosSmp as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDescripcionArticulo(Object descripcionArticulo) {
		return findByProperty(DESCRIPCION_ARTICULO, descripcionArticulo);
	}

	public List findByPrecioUnidadArticulo(Object precioUnidadArticulo) {
		return findByProperty(PRECIO_UNIDAD_ARTICULO, precioUnidadArticulo);
	}

	public List findByCantidad(Object cantidad) {
		return findByProperty(CANTIDAD, cantidad);
	}

	public List findAll() {
		log.debug("finding all ArticulosSmp instances");
		try {
			String queryString = "from ArticulosSmp";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ArticulosSmp merge(ArticulosSmp detachedInstance) {
		log.debug("merging ArticulosSmp instance");
		try {
			ArticulosSmp result = (ArticulosSmp) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ArticulosSmp instance) {
		log.debug("attaching dirty ArticulosSmp instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ArticulosSmp instance) {
		log.debug("attaching clean ArticulosSmp instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ArticulosSmpDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ArticulosSmpDAO) ctx.getBean("ArticulosSmpDAO");
	}
}