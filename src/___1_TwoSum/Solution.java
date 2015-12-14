//Given an array of integers, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, 
//where index1 must be less than index2. 
//Please note that your returned answers (both index1 and index2) are not zero-based.
//
//You may assume that each input would have exactly one solution.
//
//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2
package ___1_TwoSum;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] r =s.twoSum(new int[]{11,15,2,7}, 9);
		System.out.println(r[0]+","+r[1]);
	}

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
        	int x = target - nums[i];
        	for(int j = i+1; j<nums.length; j++)//can be replaced by map
        		if(nums[j]==x)
        			return new int[]{i+1,j+1};
        }
        return new int[]{};
    }
}
/*
public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
       int[] defaultResult = {0, 0};
       for (int i = 0; i < nums.length; i++) {
           if (map.get(target-nums[i]) != null ) {
               int[] result = {map.get(target-nums[i]) + 1, i + 1 };
               return result;
           }
           map.put(nums[i], i);
       }
       return defaultResult;
   }
   */