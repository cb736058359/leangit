package com.thinkgem.jeesite.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;

/**
 * 控制类支持类
 * @ClassName: BaseController
 * @author: chenbang
 * @version: Feb 8, 2018 3:50:00 PM
 */
public class BaseController {
	/**
	 * 设置管理端访问路径（ADMIN_PATH或FRONT_PATH可允许一个为空）
	 * 1. 修改本类 ADMIN_PATH 常量
	 * 2. 修改 applicationContext-shiro.xml 中的 shiroFilter
	 * 3. 修改 decorators.xml 中的 default
	 * 4. 修改 spring-mvc.xml 中的 mvc:view-controller
	 */
	public static final String ADMIN_PATH = "/a";
	
	/**
	 * 设置网站前端路径（ADMIN_PATH或FRONT_PATH可允许一个为空）
	 * 1. 修改本类 FRONT_PATH 常量
	 * 2. 修改 spring-mvc.xml 中的 mvc:view-controller
	 */
	public static final String FRONT_PATH = "/f";

	/**
	 * 设置访问URL后缀
	 */
	public static final String URL_SUFFIX = ".html";
	
	/**
	 * 请求对象
	 */
	protected HttpServletRequest request;
	
	/**
	 * 响应对象
	 */
	protected HttpServletResponse response;
	
	/**
	 * 验证Bean实例对象
	 */
	@Autowired
	protected Validator validator;
}
