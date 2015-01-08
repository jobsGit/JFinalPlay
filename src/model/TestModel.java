package model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("all")
public class TestModel extends Model<TestModel>{
	
	public static TestModel me  = new TestModel();
	
	public Page<TestModel> queryAll(int pageNumber,int pageSize){
		return paginate(pageNumber, pageSize, "select *", "from bvc_test");
	}
	
	
	public boolean delTest(String id){
		boolean flag = false;
		try{
			int row = Db.update("delete from bvc_test where id = ?", id);
			flag = row>0?true:false;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public boolean login(TestModel testModel){
		boolean flag = false;
		try{
			List<TestModel> testModelList = Db.query("select * from bvc_test where name=? and age=?", testModel.get("name"),testModel.get("age"));
			if(!testModelList.isEmpty()){
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	
}	
