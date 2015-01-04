
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
	 * ���ó���
	 */
	@Override
	public void configConstant(Constants arg0) {
		// TODO Auto-generated method stub
		//�������ݿ�������Ϣ
		loadPropertyFile("db.properties");
		//����ģʽ
		arg0.setDevMode(true);
		//����ҳ��Ļ���·��
		arg0.setBaseViewPath("/WEB-INF/views/");
		//����Ĭ����ͼΪJSP
		arg0.setViewType(ViewType.JSP);
		arg0.setEncoding("UTF-8");
		
		
	}

	/**
	 * ���ô�����
	 */
	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub
		//����������·��
		arg0.add(new ContextPathHandler("contextPath"));
		arg0.add(new RequestFilterHandler());
	}

	/**
	 * ����ȫ��������
	 */
	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * ���ò��
	 */
	@Override
	public void configPlugin(Plugins arg0) {
		// TODO Auto-generated method stub
		// ����C3p0���ݿ����ӳز��
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"),getProperty("user"),getProperty("password"));
		arg0.add(c3p0Plugin);
		
		ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(c3p0Plugin);
		activeRecordPlugin.setShowSql(true);
		arg0.add(activeRecordPlugin);
		activeRecordPlugin.addMapping("bvc_test", TestModel.class);
		
	}

	/**
	 * ����·��
	 */
	@Override
	public void configRoute(Routes arg0) {
		// TODO Auto-generated method stub
		arg0.add("/",WelcomController.class);
		arg0.add("/test",TestController.class);
		arg0.add("/play",PlayController.class);
	}
	
}
