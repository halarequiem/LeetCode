//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//
//Note: 
//You may assume k is always valid, 1 ¡Ü k ¡Ü BST's total elements.
//
//Follow up:
//What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
//How would you optimize the kthSmallest routine?
//
//Hint:
//
//Try to utilize the property of a BST.
//What if you could modify the BST node's structure?
//The optimal runtime complexity is O(height of BST).

package _230_KthSmallestElementInBST;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int kthSmallest(TreeNode root, int k) {
    	count = 0;
    	K=k;
    	kth(root);
    	return result;
    }
    
    private void kth(TreeNode t) {
    	if(t==null)
    		return;
    	kth(t.left);
    	count++;
    	if(count == K)
    		result = t.val;
    	kth(t.right);
    }
    
    private int count;
    private int K;
    private int result;
}
