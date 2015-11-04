//Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
//
//Hint:
//
//Expected runtime complexity is in O(log n) and the input is sorted.

package _275_hIndex_ii;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.hIndex(new int[]{1})); 
	}

    public int hIndex(int[] citations) {
    	int l = citations.length;
    	return l-find(citations, 0, l);//不用l-1的原因：看{1}和{0}的debug过程
    }
    
	private int find(int[] citations, int a, int b) {
		if(a==b) {
			return a;
		}
		int i = a/2+b/2;
		if(citations[i]>=citations.length-i) {
			return find(citations, a, i);
		} else {
			return find(citations, i+1, b);
		}
	}
}
