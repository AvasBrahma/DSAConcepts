package DS.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MaxFrequencyNumber {
	
	
	
public static int maxFrequencyNumber(int[] arr){
		
		HashMap<Integer,Integer> map=new HashMap<>();
		
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
	            if(map.get(arr[i])>max){
	                max=map.get(arr[i]);
	                maxKey=arr[i];}
	        }
	     
		

	        return maxKey;
	
		
		
	}

	
	public static void main(String[] args) {
		
		
		int[] arr= {4,3,2,3,5,6,7,4,4,5};
		int outputArr=maxFrequencyNumber(arr);
		System.out.println(outputArr);
		
		
	}

}
