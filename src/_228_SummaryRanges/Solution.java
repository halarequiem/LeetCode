//Given a sorted integer array without duplicates, return the summary of its ranges.
//
//For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
//
//Credits:
//Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
package _228_SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		List<String> r=s.summaryRanges(new int[]{0,1,2,3});
		for(String ss:r)
			System.out.println(ss);
	}

    public List<String> summaryRanges(int[] nums) {
    	List<String> r = new ArrayList<String>();
    	if(nums.length==0)
    		return r;
    	int front = 0;
    	if(nums.length>1)
	        for(int i = 1 ; i < nums.length; i++) {
	        	if(nums[i-1]+1!=nums[i]){
	        		if(front==i-1)
	            		r.add(""+nums[front]);
	        		else
	        			r.add(nums[front]+"->"+nums[i-1]);
	        		front = i;
	        	}
	        }
        if(front==nums.length-1)
    		r.add(""+nums[front]);
		else
			r.add(nums[front]+"->"+nums[nums.length-1]);
        return r;
    }
}
