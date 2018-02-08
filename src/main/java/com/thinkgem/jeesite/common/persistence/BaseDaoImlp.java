package com.thinkgem.jeesite.common.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

import com.thinkgem.jeesite.common.utils.Reflections;

/**
 * BaseDao实现类
 * @ClassName: BaseDaoImlp
 * @author: chenbang
 * @version: Feb 8, 2018 5:47:44 PM
 */
public class BaseDaoImlp<T> implements BaseDao<T> {
	
	/**
	 * 获取实体工厂管理对象
	 */
	@PersistenceContext
	public EntityManager entityManager;
	
	/**
	 * 实体类类型(由构造方法自动复制)
	 */
	private Class<?> entityClass ;

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
	
	
	public BaseDaoImlp(Class<T> entityClass) {
		entityClass = Reflections.getClassGenricType(getClass());
	}
	
	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return (Session)getEntityManager().getDelegate();
	}

	@Override
	public void clear() {
		getSession().clear();
	}

	@Override
	public Page<T> find(Page<T> page, String qlString, Object... parameter) {
		//count
		int beginPos = qlString.toLowerCase().indexOf("from");
		String subSql = qlString.substring(beginPos);
		if(!page.isDisabled() && !page.isNotCount()) {
			String countQlString = "select count(*)"+subSql;
			page.setCount((Long)createSqlQuery(countQlString, parameter).getSingleResult());
			if(page.getCount()<1) {
				return page;
			}
		}
		
		//order by
		String ql =qlString;
		if(StringUtils.isNotBlank(page.getOrderBy())) {
			ql += "order by "+page.getOrderBy();
		}
		Query query = createQuery(ql, parameter);
		//set page
		if(!page.isDisabled()) {
			query.setFirstResult(page.getFirstResult());
			query.setMaxResults(page.getMaxResults());
		}
		page.setList(query.getResultList());
		return page;
	}

	@Override
	public List<T> find(String qlString, Object... parameter) {
		return createQuery(qlString, parameter).getResultList();
	}

	@Override
	public int update(String sqlString, Object... parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Query createQuery(String qlString, Object... parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> findBySql(Page<T> page, String qlString, Object... parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findBySql(String sqlString, Object... parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBySql(String sqlString, Object... parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Query createSqlQuery(String sqlString, Object... parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> find(Page<T> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> find(Page<T> page, DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> find(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DetachedCriteria createDetachedCriteria(Criterion... criterions) {
		// TODO Auto-generated method stub
		return null;
	}

}
