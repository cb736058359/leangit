package com.thinkgem.jeesite.common.config;

import java.util.Map;

import com.ckfinder.connector.ServletContextFactory;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.utils.PropertiesLoader;
import com.thinkgem.jeesite.common.utils.StringUtils;

/**
 * 
 * <p>Title: Global.java<／p>
 * <p>Description: <／p>
 * @author chenbang
 * @date Jan 31, 2018
 * @version 第一阶段
 */
public class Global {
	/**
	 * 当前实例
	 */
	private static Global global = new Global();
	
	/**
	 * 保存全局变量
	 */
	private static Map<String,String> map= Maps.newHashMap();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader= new PropertiesLoader();
	
	/**
	 * 显示、隐藏
	 */
	private static  final String SHOW= "1";
	private static  final String HIDE= "2";
	
	/**
	 * 是/否
	 */
	public static final String YES = "1";
	public static final String NO = "0";
	
	/**
	 * 对/错
	 */
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	
	/**
	 * 上传文件基础虚拟路径
	 */
	public static final String USERFILES_BASE_URL = "/userfiles/";
	
	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
	
	/**
	 * 获取配置
	 * @see ${fns:getConfig('adminPath')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = loader.getProperty(key);
			map.put(key, value != null ? value : org.apache.commons.lang3.StringUtils.EMPTY);
		}
		return value;
	}
	
	/**
	 * 获取管理端根路径
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}
	
	/**
	 * 获取前端根路径
	 */
	public static String getFrontPath() {
		return getConfig("frontPath");
	}
	
	/**
	 * 获取URL后缀
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}
	
	public static Boolean isDemoMode() {
		String dm =getConfig("demoMode");
		return "true".equals(dm)||"1".equals(dm);
	}
	
	/**
	 * 在修改系统用户和角色时是否同步到Activiti
	 */
	public static Boolean isSynActivitiIndetity() {
		String dm = getConfig("activiti.isSynActivitiIndetity");
		return "true".equals(dm) || "1".equals(dm);
	}
    
	/**
	 * 页面获取常量
	 * @see ${fns:getConst('YES')}
	 */
	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception e) {
			// 异常代表无配置，这里什么也不做
		}
		return null;
	}
	
	public static String getUserfileBaseDir() {
		String dir = getConfig("userfile.basedir");
		if(StringUtils.isBlank(dir)) {
			try {
				dir=ServletContextFactory.getServletContext().getRealPath(dir);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return "";
			}
		}
		if(!dir.endsWith("/")) {
			dir += "/";
		}
//		System.out.println("userfiles.basedir: " + dir);
		return dir;
	}
	
	
}
