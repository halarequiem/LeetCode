//Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
//
//For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
//
//Credits:
//Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
package _279_perfectSquares;

public class Solution {	
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.numSquares(15)); 
	}
	
    public int numSquares(int n) {
        return getNum(n, 1);
    }
    
//	private boolean isSqrt(int n) {
//		int b; 
//		b = (int) java.lang.Math.sqrt(n);	
//		return b*b==n;
//	}    
    
    /*1+3+5+7+....+(2*a-1)=a^2*/
    private boolean isSqrt(int n) {
    	for(int i=1; n>0; i+=2) 
    		n-=i;
    	return 0 == n;
    }  
    
//	/*(a+1)^2=a^2+(2a+1)*/
//	private boolean isSqrt(int n, int v, int k) {
//		/*               n不是平方数                  n是平方数                 v:a^2      k:2a-1*/
//		return (n < v) ? false : (n == v) ? true : isSqrt(n, v + k + 2, k + 2);
//	}
    
	/*n是否是m个平方数的和*/
	private boolean isSqrtSum(int n, int m, int v, int k) {
		if (n < v)
			return false;
		if (m == 1)
			return isSqrt(n);
		/*     n-v是否是m-1个平方数的和                                                         n是否是m个不包括v在内的平方数的和*/
		return isSqrtSum(n - v, m - 1, v, k) ? true : isSqrtSum(n, m, v + k + 2, k + 2);
	}
	
	/*n是几个平方数的和*/
	private int getNum(int n, int m) {
		/*     是m个嘛                                                               是m+1个嘛*/
		return isSqrtSum(n, m, 1, 1) ? m : getNum(n, m + 1);
	}

	
//定理 369(Lagrange 定理): 每个正整数都是四个平方数之和
//...
}
