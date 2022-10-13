package DS.HashMap;

import java.util.HashMap;
import java.util.Set;

public class HashMapUse {
	
	public static void main(String[] args) {
		
		HashMap<String,Integer> map=new HashMap<>();
		
		//Insertion
		map.put("abc", 123);
		map.put("def", 456);
		
		//checking the keys in hash map
		if(map.containsKey("abc"))
		{
			System.out.println("abc contains in hashmap");
		}
		if(map.containsKey("abc1"))
		{
			System.out.println("abc1 contains in hashmap");
		}
		
		//for getting the values from key.
		int abcValue=map.get("abc");
		System.out.println(abcValue);
		
		System.out.println("Size of hashMap : " +map.size());
		
		
		
		//remove
		map.remove("abc");
		if(!map.containsKey("abc"))
		{
			System.out.println("abc key has been removed");
		}
		
		map.put("dd1", 123);
		map.put("dd2", 456);
		//iterate in keys
		
		Set<String> keys=map.keySet();
		for(String s:keys)
		{
		    System.out.println(s+ " = " +map.get(s));
		}
		
	}

}
