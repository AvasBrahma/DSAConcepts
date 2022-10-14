package DS.HashMap;

import java.util.HashMap;

public class PairSumArray {
	
	public static int PairSum(int[] input, int size) {
		
		int count = 0; 
        for (int i = 0; i < size; i++)
            for (int j = i + 1; j < size; j++)
            	
                if ((input[i] + input[j]) == 0)
                    count++;
 
         
        
        return count;

        }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2 1 -2 2 3
		int[] arr= {2,1,-2,2,3};
		//int[] arr2= {4,7,9,8,4,7,6,3};
		int totalPair=PairSum(arr,5);
		System.out.println(totalPair);

	}

}
