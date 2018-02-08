package com.thinkgem.jeesite.common.persistence;

import javax.sql.DataSource;

import org.hibernate.Hibernate;

/**
 * Hibernates 工具类
 * @ClassName: Hibernates
 * @author: chenbang
 * @version: Feb 7, 2018 9:35:25 AM
 */
public class Hibernates {
	
	/**
	 * Initialzie the lazy property value,eq.
	 * @Title: initLazyProperty
	 * @return: void
	 */
	public static void initLazyProperty(Object proxyedPropertyValue) {
		Hibernate.initialize(proxyedPropertyValue);
	}

	/**
	 * 从datasource中取connection,根据connection的matadata中的jdbcUrl判断Dialect类型
	 */
	private static void getDialect(DataSource dataSource) {
		
	}
}
