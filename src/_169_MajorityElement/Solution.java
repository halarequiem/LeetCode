//Given an array of size n, find the majority element. 
//The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//You may assume that the array is non-empty and the majority element always exist in the array.
//
//Credits:
//Special thanks to @ts for adding this problem and creating all test cases.
package _169_MajorityElement;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.majorityElement(new int[]{1,1,1,1,2,3,4,4,5,1,1,1}));
	}

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
    	for (int i : nums)
    		if(m.containsKey(i))
    			if(m.get(i)>=nums.length/2)
    				return i;
    			else
    				m.put(i, m.get(i)+1);
    		else
    			m.put(i, 1);
    	return nums[0];
    }
/*  这个算法的时间复杂度是O(n)，另外用了两个辅助变量。
    k用于临时存储数组中的数据，j用于存储某个数出现的次数。
    开始时k存储数组中的第一个数,j为0，如果数组出现的数于k相等，则j加1，否则就减1，如果j为0，就把当前数组中的数赋给k
    因为指定的数出现的次数大于数组长度的一半，所有j++与j--相抵消之后，最后j的值是大于等于1的，k中存的那个数就是出现最多的那个数。

   下面这个算法只适合数组中数组中某个数的出现次数超过数组长度一半的数组，符合题意。*/
}
