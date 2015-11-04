//Given an integer, write a function to determine if it is a power of two.
//
//Credits:
//Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
package _231_powerOfTwo;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isPowerOfTwo(-1));
	}

    public boolean isPowerOfTwo(int n) {
    	if(n<=0)
    		return false;
        while (n!=0) {
        	if((n&1)==1 && n!=1)
        		return false;
        	n>>=1;
        }
        return true;
    }
}
