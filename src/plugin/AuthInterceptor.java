package plugin;

import model.TestModel;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

public class AuthInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		// TODO Auto-generated method stub
		Controller controller  = ai.getController();
		TestModel testModel = controller.getSessionAttr("testModel");
		if(null != testModel){
			ai.invoke();
		}else{
			controller.redirect("/toLogin.do");
		}
	}

}
