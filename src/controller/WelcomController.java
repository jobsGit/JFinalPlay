package controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class WelcomController extends Controller{
	
	@ActionKey("/welcome")
	public void welcome(){
		setAttr("name", "��ӭ");
		render("welcome.jsp");
	}
	
}
