package controller;

import java.util.HashMap;

import model.TestModel;

import com.jfinal.aop.ClearInterceptor;
import com.jfinal.aop.ClearLayer;
import com.jfinal.core.Controller;

public class WelcomController extends Controller{
	
	@ClearInterceptor(ClearLayer.ALL)
	public void toLogin(){
		render("welcome.jsp");
	}
	
	@ClearInterceptor(ClearLayer.ALL)
	public void login(){
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		try{
			TestModel testModel = getModel(TestModel.class);
			boolean flag = TestModel.me.login(testModel);
			if(flag){
				setSessionAttr("testModel", testModel);
				resultMap.put("success", true);
			}else{
				resultMap.put("success", false);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		renderJson(resultMap);
	}

}
