package controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class TestController extends Controller{
	
	@ActionKey("/test")
	public void test(){
		setAttr("name", "≤‚ ‘");
		render("test.jsp");
	}
	
	@ActionKey("/test1")
	public void test1(){
		setAttr("name", "≤‚ ‘1");
		render("test.jsp");
	}
	
}
