package controller;

import java.util.HashMap;
import java.util.List;

import model.TestModel;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class PlayController extends Controller{
	
	@ActionKey("/play1")
	public void play1(){
		setAttr("name", "ÕÊ¡À");
		render("play.jsp");
	}
	
	@ActionKey("/play")
	public void play(){
		Page<TestModel> pageModel = TestModel.me.queryAll(1,10);
		List<TestModel> modelList = pageModel.getList();
		setAttr("modelList",modelList);
		render("play.jsp");
	}
	
	@ActionKey("/addTest")
	public void addTest(){
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		try{
			TestModel testModel = getModel(TestModel.class);
			boolean flag = testModel.save();
			if(flag){
				resultMap.put("success", true);
			}else{
				resultMap.put("success", false);
			}
		}catch(Exception e){
			resultMap.put("success", false);
		}
		renderJson(resultMap);
	}
}
