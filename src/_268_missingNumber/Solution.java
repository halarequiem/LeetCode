//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//For example,
//Given nums = [0, 1, 3] return 2.
//
//Note:
//Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
//
//Credits:
//Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
package _268_missingNumber;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.missingNumber(new int[]{0, 1, 3})); 
	}
	
    public int missingNumber(int[] nums) {
    	boolean[] tmp = new boolean[nums.length+1];
    	for(int i=0; i<nums.length; i++)
    		tmp[nums[i]]=true;
    	for(int i=0; i<tmp.length; i++)
    		if(!tmp[i])
    			return i;
    	return -1;
    }
}
