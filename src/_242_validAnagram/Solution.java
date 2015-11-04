//Given two strings s and t, write a function to determine if t is an anagram of s.
//
//For example,
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.
//
//Note:
//You may assume the string contains only lowercase alphabets.
package _242_validAnagram;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isAnagram("rat", "tar"));
	}

    public boolean isAnagram(String s, String t) {
    	char[] ss = s.toCharArray();
    	char[] tt = t.toCharArray();
        int[] bits = new int[26];
        for(char sc : ss)
        	bits[sc-'a']++;
        for(char tc : tt)
        	bits[tc-'a']--;
        for(int b : bits)
        	if(b!=0)
        		return false;
        return true;
    }
}
