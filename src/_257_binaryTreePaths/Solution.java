//Given a binary tree, return all root-to-leaf paths.
//
//For example, given the following binary tree:
//
//   1
// /   \
//2     3
// \
//  5
//All root-to-leaf paths are:
//
//["1->2->5", "1->3"]
//Credits:
//Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
package _257_binaryTreePaths;

import java.util.ArrayList;
import java.util.List;

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
    	Solution s = new Solution();
    	TreeNode r = new TreeNode(0);
    	TreeNode t1 = new TreeNode(1);
    	TreeNode t2 = new TreeNode(2);
    	TreeNode t3 = new TreeNode(3);
    	TreeNode t4 = new TreeNode(4);
    	r.left = t1;
    	r.right = t2;
    	t1.right = t3;
    	t1.left = t4;
    	
    	List<String> re = s.binaryTreePaths(r);
    	for(String i : re)
    		System.out.println(i);
	}
	
    public List<String> binaryTreePaths(TreeNode root) {
    	if(root==null)
    		return result;
    	search(root, new StringBuffer());
    	return result;
    }
    
    private List<String> result = new ArrayList<String>();
    
    private void search(TreeNode t, StringBuffer path) {
    	if(t.left==null && t.right==null) {
    		path.append(t.val);
    		result.add(path.toString());
    		return;
    	}
    	else {
    		path.append(t.val+"->");
    	}
    	
    	StringBuffer p = new StringBuffer(path.toString());
    	if(t.left!=null)
    		search(t.left, path);
    	if(t.right!=null)
    		search(t.right, p);
    }
}
