//Given an array nums, 
//write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//
//Note:
//You must do this in-place without making a copy of the array.
//Minimize the total number of operations.
//Credits:
//Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
package _283_moveZeroes;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] r = new int[]{0, 1, 0, 3, 12};
		s.moveZeroes(r);
		for(int i=0; i<r.length; i++)
			System.out.println(r[i]);
	}

    public void moveZeroes(int[] nums) {
    	int forEx;
    	int j;
        for(int i=0; i<nums.length; i++) {
        	if(nums[i] == 0) {
        		j = i;
        		while(j<nums.length && nums[j] == 0)
        			j++;
        		if(j==nums.length)
        			break;
        		forEx = nums[j];
        		nums[j] = nums[i];
        		nums[i] = forEx;
        	}
        }
    }
}
