package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TSonghuoyuan;

/**
 * A data access object (DAO) providing persistence and search support for
 * TSonghuoyuan entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.model.TSonghuoyuan
 * @author MyEclipse Persistence Tools
 */

public class TSonghuoyuanDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TSonghuoyuanDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String AGE = "age";
	public static final String TEL = "tel";
	public static final String ADDRESS = "address";
	public static final String LOGINNAME = "loginname";
	public static final String LOGINPW = "loginpw";
	public static final String DEL = "del";

	protected void initDao() {
		// do nothing
	}

	public void save(TSonghuoyuan transientInstance) {
		log.debug("saving TSonghuoyuan instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TSonghuoyuan persistentInstance) {
		log.debug("deleting TSonghuoyuan instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TSonghuoyuan findById(java.lang.Integer id) {
		log.debug("getting TSonghuoyuan instance with id: " + id);
		try {
			TSonghuoyuan instance = (TSonghuoyuan) getHibernateTemplate().get(
					"com.model.TSonghuoyuan", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TSonghuoyuan instance) {
		log.debug("finding TSonghuoyuan instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TSonghuoyuan instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TSonghuoyuan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByLoginname(Object loginname) {
		return findByProperty(LOGINNAME, loginname);
	}

	public List findByLoginpw(Object loginpw) {
		return findByProperty(LOGINPW, loginpw);
	}

	public List findByDel(Object del) {
		return findByProperty(DEL, del);
	}

	public List findAll() {
		log.debug("finding all TSonghuoyuan instances");
		try {
			String queryString = "from TSonghuoyuan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TSonghuoyuan merge(TSonghuoyuan detachedInstance) {
		log.debug("merging TSonghuoyuan instance");
		try {
			TSonghuoyuan result = (TSonghuoyuan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TSonghuoyuan instance) {
		log.debug("attaching dirty TSonghuoyuan instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TSonghuoyuan instance) {
		log.debug("attaching clean TSonghuoyuan instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TSonghuoyuanDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TSonghuoyuanDAO) ctx.getBean("TSonghuoyuanDAO");
	}
}