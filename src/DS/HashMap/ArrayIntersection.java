package DS.HashMap;

import java.util.HashMap;

public class ArrayIntersection {
		
	public static void intersection(int[] arr1, int[] arr2){
		
        HashMap<Integer,Integer> map=new HashMap<>();
        
        
		
		for(int i=0;i<arr1.length;i++)  // first we have taken the frequency of arr 1
		{
			if(map.containsKey(arr1[i]))
			{
				int frequencyNumber=map.get(arr1[i]);
				map.put(arr1[i], frequencyNumber+1);
				
			}
			else {
			map.put(arr1[i], 1);
			}
		}
		
		for(int i=0;i<arr2.length;i++)
		{
			if(map.containsKey(arr2[i])) // map should the arr2 value for array intersection
			{
			  int freq=map.get(arr2[i]); // we will get the frequency of arr1 key intersection.
			  if(freq>0) //If it is greater than that means it is an intersection
			  {
				  System.out.print(arr2[i] + " ");
				  map.put(arr2[i], freq-1); // Now we need to decrease the frequency.
			  }
				
			}
			
			
		}
		
		
	
	}
	
	public static void main(String[] args) {
		
		int[] arr= {4,3,2,3,5,6,7,4,4,5};
		int[] arr2= {4,7,9,8,4,7,6,3};
		intersection(arr,arr2);
		//System.out.println(outputArr);
	}
}
