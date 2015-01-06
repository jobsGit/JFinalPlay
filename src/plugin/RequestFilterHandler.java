package plugin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class RequestFilterHandler extends Handler{
	@Override
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, boolean[] isHandled) {
		// TODO Auto-generated method stub
		if(target.endsWith(util.Constants.REQUEST_SUFFIX)){
			target = target.substring(0,target.length()-3);
			nextHandler.handle(target, request, response, isHandled);
		}
	}
}
