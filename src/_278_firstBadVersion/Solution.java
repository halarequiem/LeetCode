//You are a product manager and currently leading a team to develop a new product. 
//Unfortunately, the latest version of your product fails the quality check. 
//Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//
//Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
//
//You are given an API bool isBadVersion(version) which will return whether version is bad. 
//Implement a function to find the first bad version. You should minimize the number of calls to the API.
//
//Credits:
//Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
package _278_firstBadVersion;

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */
public class Solution extends VersionControl {
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.firstBadVersion(2126753390)); //超出int范围
	}
	
	public int firstBadVersion(int n) {
        return find(1, n);
    }
	
	private int find(int a, int b) {
		if(a==b) {
			return a;
		}
		if(isBadVersion(a/2+b/2)) {
			return find(a, a/2+b/2);
		} else {
			return find(a/2+b/2+1, b);
		}
	}
}

//超出int范围
//2 version, 2 is firstBadVersion 边界
//初始不是(0, n)
