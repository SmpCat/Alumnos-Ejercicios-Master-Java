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

import com.atrium.hibernate.Articulos;

/**
 * DAO de Artículos
 * 
 * @see com.atrium.hibernate.Articulos
 * @author Sergio Sánchez García
 */

public class ArticulosDAO {
	private static final Logger log = LoggerFactory.getLogger(ArticulosDAO.class);

	// Constantes de búsqueda 
	private static final String CODIGO_ARTICULO = "codigoArticulo";
	private static final String DESCRIPCION_ARTICULO = "descripcionArticulo";
	private static final String PRECIO_UNIDAD_ARTICULO = "precioUnidadArticulo";
	
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

	public void save(Articulos transientInstance) {
		log.debug("saving Articulos instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Articulos persistentInstance) {
		log.debug("deleting Articulos instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Articulos findById(Integer codigoArticulo) {
		log.debug("getting Articulos instance with id: " + codigoArticulo);
		try {
			Articulos instance = (Articulos) getCurrentSession().get(
					"com.atrium.hibernate.Articulos", codigoArticulo);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Articulos> findByExample(Articulos instance) {
		log.debug("finding Articulos instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Articulos> results = (List<Articulos>) getCurrentSession()
					.createCriteria("com.atrium.hibernate.Articulos")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Articulos> findByProperty(String propertyName, Object value) {
		log.debug("finding Articulos instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Articulos as model where model."
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
	
	public List<Articulos> findByCodigoArticulo(Object codigoArticulo) {
		return findByProperty(CODIGO_ARTICULO, codigoArticulo);
	}
	public List<Articulos> findByDescripcionArticulo(Object descripcionArticulo) {
		return findByProperty(DESCRIPCION_ARTICULO, descripcionArticulo);
	}
	public List<Articulos> findByPrecioUnidadArticulo(Object precioUnidadArticulo) {
		return findByProperty(PRECIO_UNIDAD_ARTICULO, precioUnidadArticulo);
	}


	// Búsqueda de Todos los Articulos
	public List<Articulos> findAll() {
		log.debug("finding all Articulos instances");
		try {
			String queryString = "from Articulos";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Articulos merge(Articulos detachedInstance) {
		log.debug("merging Articulos instance");
		try {
			Articulos result = (Articulos) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Articulos instance) {
		log.debug("attaching dirty Articulos instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Articulos instance) {
		log.debug("attaching clean Articulos instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ArticulosDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ArticulosDAO) ctx.getBean("ArticulosDAO");
	}
}