package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import doman.Guitar;
import service.GuitarService;

public class searchAction extends ActionSupport {
		private GuitarService guitarService = new GuitarService();
		private InputStream inputStream;
		private String desc;
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public InputStream getResult(){
				return inputStream;
		}
		public String search() throws Exception{
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
			List<Guitar> gList = guitarService.search(desc);
			JSONArray jsonArray = new JSONArray();
			for(Guitar g : gList){
				JSONObject jo = new JSONObject();
				jo.put("serialNumber", g.getSerialNumber());
				jo.put("price", g.getPrice());
				jo.put("builder",g.getBuilder());
				jo.put("model", g.getModel());
				jo.put("type", g.getType());
				jo.put("backWood", g.getBackWood());
				jo.put("topWood", g.getTopWood());
				jsonArray.put(jo);
			}
			inputStream =new ByteArrayInputStream(jsonArray.toString()
					.getBytes("UTF-8"));
			 System.out.println(jsonArray.toString());
			return SUCCESS;
		}	
}
