//Given an array nums, 
//there is a sliding window of size k which is moving from the very left of the array to the very right. 
//You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
//For example,
//Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//Therefore, return the max sliding window as [3,3,5,5,6,7].
//
//Note: 
//You may assume k is always valid, ie: 1 ¡Ü k ¡Ü input array's size for non-empty array.
//
//Follow up:
//Could you solve it in linear time?
//
//Hint:
//
//How about using a data structure such as deque (double-ended queue)?
//The queue size need not be the same as the window¡¯s size.
//Remove redundant elements and the queue should store only elements that need to be considered.
package _239_slidingWindowMaximum;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {
		Solution s =new Solution();
		//System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,3,-1,-3,-5,13,6,7}, 2)));
		System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7}, 7)));
	}

//	public int[] maxSlidingWindow(int[] nums, int k) {
//		if(k==0) return new int[0];
//		
///*		LinkedList<Integer> c = new LinkedList<Integer>();
//		int[] r = new int[nums.length - k + 1];
//		for (int i = 0; i < nums.length; i++) {			
//			while(!c.isEmpty() && nums[i]>=c.getLast())
//				c.removeLast();
//			c.add(nums[i]);
//			if(c.size()>k) //wrong
//		  		c.removeFirst();
//			if(i+1>=k) r[i-k+1] = c.getFirst();  
//		}
//		return r;*/
//    
//		LinkedList<Integer> c = new LinkedList<Integer>();
//		int[] r = new int[nums.length - k + 1];
//		for (int i = 0; i < nums.length; i++) {
//			while (!c.isEmpty() && nums[i] >= nums[c.getLast()])
//				c.removeLast();
//			c.addLast(i);
//
//			if (i - c.getFirst() + 1 > k) 
//				c.removeFirst();
//			if (i + 1 >= k)
//				r[i - k + 1] = nums[c.getFirst()];
//		}
//		return r;
//	}
	
    public int[] maxSlidingWindow(int[] nums, int k) {
		int[] r = new int[nums.length - k + 1];
		int pos = -1;
		for (int i = 0; i < r.length; i++) {
			if (pos < 0) {
				r[i] = nums[i];
				for (int j = 0; j < k; j++)
					if (r[i] < nums[i+j]) {
						r[i] = nums[i+j];
						pos = j-1;
					}
				continue;
			}
			if (r[i - 1] <= nums[i + k - 1]) {
				r[i] = nums[i + k - 1];
				pos = k - 2;//notice
			} else {
				r[i] = r[i - 1];
				pos--;
			}
        }
		return r;
    }
}
