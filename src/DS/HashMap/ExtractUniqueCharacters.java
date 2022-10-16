package DS.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ExtractUniqueCharacters {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static String removeDublicateChar(String str) {
//      
//		HashMap<String,Integer> map=new HashMap<>();
//		
//		for(int i=0;i<str.length();i++)
//		{
//		   if(map.containsKey(str.charAt(i)))
//		   {
//			   int strValue=map.get(str.charAt(i));
//			   map.put("\""+str.charAt(i)+"\"", strValue+1);
//			   
//		   }
//		   else
//		   {
//			   map.put("\""+str.charAt(i)+"\"", 1);
//			   System.out.print(str.charAt(i) + " " );
//		   }
//			
//		}
//		char uniqueChar[]=new char[str.length()];
//		for(int i=0;i<str.length();i++)
//		{
//		if(map.get(str.charAt(i))>1)
//		{
//			uniqueChar[i]=str.charAt(i);
//			
//		}
//		}
//		return String.valueOf(uniqueChar);
//		
		HashMap<Character,Boolean> h=new HashMap<>();
        String s="";
        for(int i=0;i<str.length();i++){
            if(h.containsKey(str.charAt(i)))
                continue;
            s=s+str.charAt(i);
            h.put(str.charAt(i),true);
        }
return s;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		String str = takeInput();
		//String uniqueChar=removeDublicateChar(str);
		
		System.out.println(removeDublicateChar(str));

	}
	
	 public static String takeInput() throws IOException {
	        String str = br.readLine(); 
	        return str;
	    }

}
