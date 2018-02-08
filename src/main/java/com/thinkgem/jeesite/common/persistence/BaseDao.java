package com.thinkgem.jeesite.common.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

/**
 * 
 * <p>Title: BaseDao.java<／p>
 * <p>Description: Dao支持类实现<／p>
 * @author chenbang
 * @date Feb 1, 2018
 * @version 第一阶段
 */
public interface BaseDao<T> {
	
	/**
	 * 获取实体工厂管理对象
	 * @Title: getEntityManager
	 * @return: EntityManager
	 */
	public EntityManager getEntityManager();
	
	/**
	 * 获取sesson
	 */
	public Session getSession();
	
	
	/**
	 * 清除缓存
	 */
	public void clear();
	
	
	/**
	 * 分页查询
	 */
	public Page<T> find(Page<T> page,String qlString,Object ...paramter);
	
	/**
	 * 查询
	 */
	public List<T> find(String qlString,Object ...paramter);
	
	
	/**
	 * QL 更新
	 * @param sqlString
	 * @param parameter
	 * @return
	 */
	public int update(String sqlString, Object... parameter);
	
	/**
	 * 创建 QL 查询对象
	 * @param qlString
	 * @param parameter
	 * @return
	 */
	public Query createQuery(String qlString, Object... parameter);
	
	// -------------- SQL Query --------------

    /**
	 * SQL 分页查询
	 * @param page
	 * @param qlString
	 * @param parameter
	 * @return
	 */
    public Page<T> findBySql(Page<T> page, String qlString, Object... parameter);

	/**
	 * SQL 查询
	 * @param sqlString
	 * @param parameter
	 * @return
	 */
	public List<T> findBySql(String sqlString, Object... parameter);
	
	/**
	 * SQL 更新
	 * @param sqlString
	 * @param parameter
	 * @return
	 */
	public int updateBySql(String sqlString, Object... parameter);
	
	/**
	 * 创建 SQL 查询对象
	 * @param sqlString
	 * @param parameter
	 * @return
	 */
	public Query createSqlQuery(String sqlString, Object... parameter);
	
	//------------Criteria-------------
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	public Page<T> find(Page<T> page);
	
	/**
	 * 使用检索标准对象分页查询
	 * @param detachedCriteria
	 * @param page
	 * @return
	 */
	public Page<T> find(Page<T> page, DetachedCriteria detachedCriteria);

	/**
	 * 使用检索标准对象查询
	 * @param detachedCriteria
	 * @return
	 */
	public List<T> find(DetachedCriteria detachedCriteria);
	
	/**
	 * 使用检索标准对象查询记录数
	 * @param detachedCriteria
	 * @return
	 */
	public long count(DetachedCriteria detachedCriteria);

	/**
	 * 创建与会话无关的检索标准对象
	 * @param criterions Restrictions.eq("name", value);
	 * @return 
	 */
	public DetachedCriteria createDetachedCriteria(Criterion... criterions);
	
	
}	
