package controller;

import java.util.HashMap;

import model.TestModel;

import com.jfinal.core.Controller;

public class WelcomController extends Controller{
	
	public void login(){
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		try{
			TestModel testModel = getModel(TestModel.class);
			boolean flag = TestModel.me.login(testModel);
			if(flag){
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
