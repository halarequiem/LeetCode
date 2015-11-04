//Write a program to find the n-th ugly number.
//
//Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
//For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16 is the sequence of the first 10 ugly numbers.
//
//Note that 1 is typically treated as an ugly number.
//
//Hint:
//
//The naive approach is to call isUgly for every number until you reach the nth one. 
//Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
//
//An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
//
//The key is how to maintain the order of the ugly numbers. 
//Try a similar approach of merging from three sorted lists: L1, L2, and L3.
//
//Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
package _264_uglyNumber_ii;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.nthUglyNumber(12)); 
	}
	
    public int nthUglyNumber(int n) {
    	int[] result = new int[n];
    	result[0] = 1;
    	int[] candidate = new int[]{2, 3, 5};
    	int[] base = new int[]{0, 0, 0};
    	for(int i=1; i<n; i++) {
			if (candidate[0] <= candidate[1] && candidate[0] <= candidate[2]) {
				result[i] = candidate[0];				
				if (candidate[0] == candidate[1])
					candidate[1] = 3*result[++base[1]];
				if (candidate[0] == candidate[2])
					candidate[2] = 5*result[++base[2]];
				candidate[0] = 2*result[++base[0]];
			} else if (candidate[1] <= candidate[0] && candidate[1] <= candidate[2]) {
				result[i] = candidate[1];
				if (candidate[1] == candidate[0])
					candidate[0] = 2*result[++base[0]];
				if (candidate[1] == candidate[2])
					candidate[2] = 5*result[++base[2]];
				candidate[1] = 3*result[++base[1]];
			} else if (candidate[2] <= candidate[1] && candidate[2] <= candidate[0]) {
				result[i] = candidate[2];
				if (candidate[2] == candidate[0])
					candidate[0] = 2*result[++base[0]];
				if (candidate[2] == candidate[1])
					candidate[1] = 3*result[++base[1]];
				candidate[2] = 5*result[++base[2]];
			}
    	}
    	
    	return result[n-1];
    }	
    	
/*wrong*/  
//	public int nthUglyNumber(int n) {
//		if (n == 1)
//			return 1;
//		int[] candidate = new int[] { 2, 3, 5 };
//		int result = 2;
//		for (int i = 2; i <= n; i++) {
//			if (candidate[0] <= candidate[1] && candidate[0] <= candidate[2]) {
//				result = candidate[0];
//				candidate[0] += 2;
//				if (candidate[0] == candidate[1])
//					candidate[1] += 3;
//				if (candidate[0] == candidate[2])
//					candidate[2] += 5;
//			} else if (candidate[1] <= candidate[0] && candidate[1] <= candidate[2]) {
//				result = candidate[1];
//				candidate[1] += 3;
//				if (candidate[1] == candidate[0])
//					candidate[0] += 2;
//				if (candidate[1] == candidate[2])
//					candidate[2] += 5;
//			} else if (candidate[2] <= candidate[1] && candidate[2] <= candidate[0]) {
//				result = candidate[2];
//				candidate[2] += 5;
//				if (candidate[2] == candidate[0])
//					candidate[0] += 2;
//				if (candidate[2] == candidate[1])
//					candidate[1] += 3;
//			}
//		}
//		return result;
//	}

/*solution on csdn blog*/
//    int min(int a, int b, int c){
//        int minNum = a > b ? b : a;
//        return minNum > c ? c : minNum;
//    }
//    //求第N个丑数
//    int nthUglyNumber(int n) {
//        int *ugly = new int[n];
//        memset(ugly, 0, sizeof(int) * n);
//        ugly[0] = 1;
//
//        int factor2 = 2, factor3 = 3, factor5 = 5;
//        int index2, index3, index5;
//        index2 = index3 = index5 = 0;
//
//        for(int i=1; i<n; i++){
//            int minNum = min(factor2, factor3, factor5);
//            ugly[i] = minNum;
//
//            if(factor2 == minNum)
//                 factor2 = 2 * ugly[++index2];
//            if(factor3 == minNum)
//                 factor3 = 3 * ugly[++index3];
//            if(factor5 == minNum)
//                 factor5 = 5 * ugly[++index5];
//        }
//
//        return ugly[n-1];
//    }
    
}
