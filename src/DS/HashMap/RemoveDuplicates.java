package DS.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
	
	
	public static ArrayList<Integer> removeDuplicates(int[] arr){
		
		ArrayList<Integer> result=new ArrayList<>();
		HashMap<Integer,Boolean> map=new HashMap<>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
			{
				continue;
			}
			result.add(arr[i]);
			map.put(arr[i], true);
		}
		
		return result;
		
		
	}
	
	public static void main(String[] args) {
		
		int[] arr= {4,3,2,3,5,6,7,4,4,5};
		ArrayList<Integer> outputArr=removeDuplicates(arr);
		System.out.println(outputArr);
	}

}
