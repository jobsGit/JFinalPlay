package controller;

import com.jfinal.core.Controller;

public class WelcomController extends Controller{
	
	public void welcome(){
		setAttr("name", "欢迎使用JFINAL，呵呵!");
		render("welcome.jsp");
	}
	
}
