
/**
 * @author Administrator
 *
 */
package sysconfig;

import model.TestModel;
import plugin.RequestFilterHandler;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

import controller.PlayController;
import controller.TestController;
import controller.WelcomController;

public class SysConfig extends JFinalConfig{

	/**
	 * 配置常量
	 */
	@Override
	public void configConstant(Constants arg0) {
		// TODO Auto-generated method stub
		//加载数据库配置信息
		loadPropertyFile("db.properties");
		//开发模式
		arg0.setDevMode(true);
		//设置页面的基础路径
		arg0.setBaseViewPath("/WEB-INF/views/");
		//设置默认视图为JSP
		arg0.setViewType(ViewType.JSP);
		arg0.setEncoding("UTF-8");
		
		
	}

	/**
	 * 配置处理器
	 */
	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub
		//设置上下文路径
		arg0.add(new ContextPathHandler("contextPath"));
		arg0.add(new RequestFilterHandler());
	}

	/**
	 * 配置全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 配置插件
	 */
	@Override
	public void configPlugin(Plugins arg0) {
		// TODO Auto-generated method stub
		// 配置C3p0数据库连接池插件
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
		arg0.add("/test",TestController.class);
		arg0.add("/play",PlayController.class);
	}
	
}
