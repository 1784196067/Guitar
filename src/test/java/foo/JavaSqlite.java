package foo;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dbutil.DbUtil;
import doman.Guitar;


public class JavaSqlite {

    public static void main(String[] args) {
    	
    	Guitar guitar = new Guitar("Fender", "Stratocastor", "electric",
                "Alder", "Alder");
    	String str = "Fender Stratocastor Alder";
    	String[] desc = guitar.toString().split("\\s+");
    	String ll = "";
    	for(Integer i = 0; i < desc.length; i++){
    		ll += "(" + desc[i] + ")" + "{0,}"; 
    	}
    	String regEx =  ll.toLowerCase() ;
    	Pattern pattern = Pattern.compile(regEx);
    	String s = str.replace(" ", "").toLowerCase();
    	 Matcher matcher = pattern.matcher(s);
    	 System.out.println(regEx);
    	 System.out.println(s);
    	System.out.println(matcher.matches());

    }

}
