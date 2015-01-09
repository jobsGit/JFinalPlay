
/**
 * @author Administrator
 *
 */
package sysconfig;

import plugin.AuthInterceptor;
import plugin.RequestFilterHandler;
import model.TestModel;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

import controller.PlayController;
import controller.WelcomController;

public class SysConfig extends JFinalConfig{

	/**
	 * 项目配置信息
	 */
	@Override
	public void configConstant(Constants arg0) {
		// TODO Auto-generated method stub
		//加载数据库配置
		loadPropertyFile("db.properties");
		//设置开发模式
		arg0.setDevMode(true);
		//基础访问路径
		arg0.setBaseViewPath("/WEB-INF/views/");
		//展示视图设置
		arg0.setViewType(ViewType.JSP);
		arg0.setEncoding("UTF-8");
	}

	/**
	 * 过虑配置
	 */
	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub
		//上下文路径
		arg0.add(new ContextPathHandler("contextPath"));
		arg0.add(new RequestFilterHandler());
	}

	/**
	 * 拦截器配置
	 */
	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub
		//拦截session
		arg0.add(new AuthInterceptor());
	}
	
	/**
	 * 插件配置
	 */
	@Override
	public void configPlugin(Plugins arg0) {
		// TODO Auto-generated method stub
		// 配置数据库
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"),getProperty("user"),getProperty("password"));
		arg0.add(c3p0Plugin);
		
		ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(c3p0Plugin);
		activeRecordPlugin.setShowSql(true);
		arg0.add(activeRecordPlugin);
		activeRecordPlugin.addMapping("bvc_test", TestModel.class);
		
	}

	/**
	 * 配置路由
	 */
	@Override
	public void configRoute(Routes arg0) {
		// TODO Auto-generated method stub
		arg0.add("/",WelcomController.class);
		arg0.add("/play",PlayController.class);
	}
	
}
