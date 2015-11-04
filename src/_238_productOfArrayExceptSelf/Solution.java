//Given an array of n integers where n > 1, nums, 
//return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//Solve it without division and in O(n).
//
//For example, given [1,2,3,4], return [24,12,8,6].
//
//Follow up:
//Could you solve it with constant space complexity? 
//(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
package _238_productOfArrayExceptSelf;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] r=s.productExceptSelf(new int[]{1,2,3,4});
		for(int i=0; i<r.length; i++)
			System.out.println(r[i]);
	}
	
	/*
	 *  1, ..., i-1, i, i+1, ..., n
	 *  |¡û loop 1 ¡ú|    |¡û loop 2 ¡ú|
	 */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        result[0] = 1;
        for(int i=1; i<nums.length; i++)
        	result[i] = result[i-1]*nums[i-1];
        
        int product = 1;
        for(int i=nums.length-2; i>=0; i--) {
        	product*=nums[i+1];
        	result[i] *= product;
        }
        	
        return result;
    }
}
