package impl;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.GuitarDao;
import dbutil.DbUtil;
import doman.Guitar;
public class GuitarDaoImpl implements GuitarDao{

	  public void addGuitar(Guitar guitar) {
		String sql = "insert into guitar values(?,?,?,?,?,?,?)";
	    DbUtil.executeUpdate(sql, new Object[]{guitar.getSerialNumber(),guitar.getPrice(),guitar.getBuilder(),guitar.getModel(),guitar.getType(),guitar.getBackWood(),guitar.getTopWood()});
	  }

	  public Guitar getGuitar(String serialNumber) {
		  Guitar guitar=null;
			try{
				 ResultSet rs = DbUtil.executeQuery("select * form guitar where serialNumber=?", new Object[]{serialNumber});
				while(rs.next()){
					guitar=new Guitar();
					guitar.setSerialNumber(rs.getString(1));
					guitar.setPrice(rs.getDouble(2));
					guitar.setBuilder(rs.getString(3));
					guitar.setModel(rs.getString(4));
					guitar.setType(rs.getString(5));
					guitar.setBackWood(rs.getString(6));
					guitar.setTopWood(rs.getString(7));
				}					
			}catch(SQLException e){
				e.printStackTrace();
			}
			return guitar;  
	  }
	 
	public List<Guitar> getAll(){
		List<Guitar> results = new ArrayList<Guitar>();
		Guitar guitar;
		try{
			ResultSet rs =  DbUtil.executeQuery("select * from guitar;", new Object[]{});
			while(rs.next()){
				guitar = new Guitar();
				guitar.setSerialNumber(rs.getString(1));
				guitar.setPrice(rs.getDouble(2));
				guitar.setBuilder(rs.getString(3));
				guitar.setModel(rs.getString(4));
				guitar.setType(rs.getString(5));
				guitar.setBackWood(rs.getString(6));
				guitar.setTopWood(rs.getString(7));
				results.add(guitar);
			}					
		}catch(SQLException e){
			e.printStackTrace();
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<Guitar> search(String str) {
		List<Guitar> matchingGuitars =  getAll();
		List<Guitar> results = new ArrayList<Guitar>();
		try{
			for (Iterator<Guitar> i = matchingGuitars.iterator(); i.hasNext(); ) {
			      Guitar gui = (Guitar)i.next();
			      String[] desc = gui.toString().split("\\s+");
			    	String ll = "";
			    	for(Integer j = 0; j < desc.length; j++){
			    		ll += "(" + desc[j] + ")" + "{0,}"; 
			    	}
			    	String regEx =  ll.toLowerCase() ;
			    	Pattern pattern = Pattern.compile(regEx);
			    	String s = str.replace(" ", "").toLowerCase();
			    	 Matcher matcher = pattern.matcher(s);
			      if (!matcher.matches())
			        continue;
			      results.add(gui);
			    }
		}catch(Exception e){
			System.out.println(e.getMessage().toString());
		}
	    return results;
	  }
	
	public JSONArray search2(Guitar guitar) throws SQLException {  
		ResultSet matchingGuitars =   DbUtil.executeQuery("select * from guitar;", new Object[]{});
		ResultSetMetaData md = matchingGuitars.getMetaData();  
		int num = md.getColumnCount();  
		JSONArray array = new JSONArray();  
		while (matchingGuitars.next()) {  
		JSONObject mapOfColValues = new JSONObject();  
		for (int i = 1; i <= num; i++) {  
		mapOfColValues.put(md.getColumnName(i), matchingGuitars.getObject(i));  
		}  
		array.put(mapOfColValues);  
		}  
		return array;  
		}  
}
