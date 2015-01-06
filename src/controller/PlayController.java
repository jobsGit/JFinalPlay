package controller;

import java.util.HashMap;
import java.util.List;

import model.TestModel;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;

public class PlayController extends Controller{
	

	public void play(){
		Page<TestModel> pageModel = TestModel.me.queryAll(1,10);
		List<TestModel> modelList = pageModel.getList();
		setAttr("modelList",modelList);
		render("show.jsp");
	}
	
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
			e.printStackTrace();
			resultMap.put("success", false);
		}
		renderJson(resultMap);
	}
	
	public void delTest(){
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		try{
			int flag = Db.update("delete from bvc_test where id = ?", getPara("id"));
			if(flag>0){
				resultMap.put("success", true);
			}else{
				resultMap.put("success", false);
			}
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("success", false);
		}
		renderJson(resultMap);
	}
	
	
	public void toEditPage(){
		try{
			TestModel testModel = getModel(TestModel.class).findById(getPara("id"));
			setAttr("testModel", testModel);
		}catch(Exception e){
			e.printStackTrace();
		}
		render("edit.jsp");
	}
	
	
	public void editTest(){
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		try{
			TestModel testModel = getModel(TestModel.class);
			boolean flag = testModel.update();
			if(flag){
				resultMap.put("success", true);
			}else{
				resultMap.put("success", false);
			}
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("success", false);
		}
		renderJson(resultMap);
	}
	
	
}
