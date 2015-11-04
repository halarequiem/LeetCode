//Given an array of citations (each citation is a non-negative integer) of a researcher, 
//write a function to compute the researcher's h-index.
//
//According to the definition of h-index on Wikipedia: 
//"A scientist has index h if h of his/her N papers have at least h citations each, 
//and the other N �? h papers have no more than h citations each."
//
//For example, given citations = [3, 0, 6, 1, 5], 
//which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. 
//Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, 
//his h-index is 3.
//
//Note: If there are several possible values for h, the maximum one is taken as the h-index.
//
//Hint:
//
//An easy approach is to sort the array first.
//What are the possible values of h-index?
//A faster approach is to use extra space.
//Credits:
//Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

package _274_hIndex;

public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.hIndex(new int[]{0})); 
	}
	
	public int hIndex(int[] citations) {
		quickSort(citations);
		for(int i = 0; i<citations.length; i++)
			if(citations[i]<i+1) //优化�?
				return i;
		return citations.length;
    }
	
	/*由大到小排序*/
	private void quickSort(int[] a) {
		quickSort(a, 0, a.length-1);
	}
	
	private void quickSort(int[] a, int low ,int high) {
		if(low<high){
			int i = partition(a, low, high);
			quickSort(a, low, i-1);
			quickSort(a, i+1, high);
		}
	}
	
	private int partition(int[] a, int low ,int high) {
		int key = a[low];
		while (low < high) {
			while (low < high && a[high] <= key)
				high--;
			swap(a, low, high);
			while (low < high && a[low] >= key)
				low++;
			swap(a, low, high);
		}
		return low;
	}
	
	private void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
	
//	/*try to reduce useless compare with using parts of quick sort*/
//	public int hIndex(int[] citations) {
//		return hIndex(citations, 0 ,citations.length-1);
//    }
//	
//	
//	private int hIndex(int[] a, int low ,int high) {
//		if(low<high){//how to?...
//			int i = partition(a, low, high);
//			if(a[i]<i+1) {
//				return hIndex(a, low, i-1);
//			}else {
//				return hIndex(a, i+1, high);
//			}
//		}
//	}
//	private int partition(int[] a, int low ,int high) {
//		int key = a[low];
//		while (low < high) {
//			while (low < high && a[high] <= key)
//				high--;
//			swap(a, low, high);
//			while (low < high && a[low] >= key)
//				low++;
//			swap(a, low, high);
//		}
//		return low;
//	}
//	
//	private void swap(int[] a, int x, int y) {
//		int tmp = a[x];
//		a[x] = a[y];
//		a[y] = tmp;
//	}
}
