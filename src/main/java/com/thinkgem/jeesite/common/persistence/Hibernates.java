package com.thinkgem.jeesite.common.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLInnoDBDialect;
import org.hibernate.dialect.Oracle10gDialect;

/**
 * Hibernates工具类
 * @ClassName: Hibernates
 * @author: chenbang
 * @version: Feb 8, 2018 10:12:27 AM
 */
public class Hibernates {
	
	/**
	 * 从Datasource中取出connection，根据metadata判断jdbcUrl的Dialect类型
	 * @Title: initLazyproperty
	 * @return: void
	 */
	public static void initLazyproperty(Object proxyPropertyValue) {
		Hibernate.initialize(proxyPropertyValue);
	}
	
	public static String getDialect(DataSource datasource) {
		//从Datasource中取出jdbcUrl
		Connection connection =null;
		String dataurl = null;
		try {
			 connection = datasource.getConnection();
			 if(connection!=null) {
				 dataurl = connection.getMetaData().getURL();
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		if(StringUtils.contains(dataurl, ":h2:")) {
			return org.hibernate.dialect.H2Dialect.class.getName();
		}else if (StringUtils.contains(dataurl, ":mysql:")) {
			return MySQLInnoDBDialect.class.getName();
		}else if (StringUtils.contains(dataurl, ":oracle:")) {
			return Oracle10gDialect.class.getName();
		}else {
			throw new IllegalArgumentException("unknown Database");
		}
	}
	
	
}