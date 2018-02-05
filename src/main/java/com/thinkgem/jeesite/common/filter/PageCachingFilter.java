package com.thinkgem.jeesite.common.filter;
/**
 * 
 * <p>Title: PageCachingFilter.java<／p>
 * <p>Description: 页面高速过滤缓存<／p>
 * @author chenbang
 * @date Jan 31, 2018
 * @version 第一阶段
 */

import com.thinkgem.jeesite.common.utils.SpringContextHolder;

import net.sf.ehcache.CacheManager;

public class PageCachingFilter {
	private CacheManager cacheManager =SpringContextHolder.getBean(CacheManager.class);
	
	protected CacheManager getCacheManager() {
		return cacheManager;
	}
}
