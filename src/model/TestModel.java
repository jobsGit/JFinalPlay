package model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("all")
public class TestModel extends Model<TestModel>{
	
	public static TestModel me  = new TestModel();
	
	public Page<TestModel> queryAll(int pageNumber,int pageSize){
		return paginate(pageNumber, pageSize, "select *", "from bvc_test");
	}
	
	
}	
