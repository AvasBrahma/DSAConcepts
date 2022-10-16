package DS.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ExtractUniqueIntegers {
	

	public static ArrayList<Integer> removeDublicates(int[] arr) {
		
		HashMap<Integer,Integer> map=new HashMap<>();
		ArrayList<Integer> array=new ArrayList<>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
					{
				int frequencyNumber=map.get(arr[i]);
				map.put(arr[i], frequencyNumber+1);
				
					}
			else {
				
				map.put(arr[i], 1);
			}
			
			
		}
		Set<Integer> keys=map.keySet();

		  int max=0;
	        int maxKey=Integer.MIN_VALUE;
	        for(int i=0;i<arr.length;i++)
	        {
	            if(map.get(arr[i])>1)
	            {
	            	continue;
	            }
	            else {
	            	
	            	array.add(arr[i]);
	            	
	            }
	        }
	     
		
		
		return array;
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		int arr[]= {3,4,5,6,2,4,3,2,5};
		ArrayList<Integer> uniqueArray=removeDublicates(arr);
		
		System.out.println(uniqueArray);
		 for (int i = 0; i < uniqueArray.size(); i++) 
	            System.out.print(uniqueArray.get(i) + " "); 
	}


}
