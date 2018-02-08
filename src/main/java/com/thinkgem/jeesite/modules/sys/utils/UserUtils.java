package com.thinkgem.jeesite.modules.sys.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 用户工具类
 * @ClassName: UserUtils
 * @author: chenbang
 * @version: Feb 2, 2018 9:25:27 AM
 */
@Component
public class UserUtils implements ApplicationContextAware{

	private static UserDao userDao;
	private static MenuDao menuDao;
	private static AreaDao areaDao;
	private static OfficeDao officeDao;
	private static CategoryDao categoryDao;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		
	}
	
}
