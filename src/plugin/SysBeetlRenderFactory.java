package plugin;

import org.beetl.ext.jfinal.BeetlRender;
import org.beetl.ext.jfinal.BeetlRenderFactory;

import com.jfinal.render.Render;

public class SysBeetlRenderFactory extends BeetlRenderFactory{
	@Override
	public Render getRender(String view) {
		// TODO Auto-generated method stub
		BeetlRender render=new BeetlRender(groupTemplate, view);
		return render;
	}
	
	@Override
	public String getViewExtension() {
		// TODO Auto-generated method stub
		return ".jsp";
	}
	
}
