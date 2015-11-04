//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//
//According to the definition of LCA on Wikipedia: 
//¡°The lowest common ancestor is defined between two nodes v and w 
//as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).¡±
//
//        _______3______
//       /              \
//    ___5__          ___1__
//   /      \        /      \
//   6      _2       0       8
//         /  \
//         7   4
//For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, 
//since a node can be a descendant of itself according to the LCA definition.
package _236_lowestCommonAncestorOfABinaryTree;

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
    	
    	System.out.println(s.lowestCommonAncestor(r, t1, t4).val);
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	List<TreeNode> pp = new ArrayList<TreeNode>();
    	search(root, p, pp);
    	List<TreeNode> qp = new ArrayList<TreeNode>();
    	search(root, q, qp);
    	for(int i = 0 ; i < (pp.size()<qp.size()?pp.size():qp.size()) ; i++)
    		if(pp.get(i)!=qp.get(i))
    			return pp.get(i-1);
    	return pp.size()<qp.size()?p:q;
    	
    }
    
    private boolean search(TreeNode t , TreeNode x , List<TreeNode> path) {
    	if(t == null)
    		return false;
    	path.add(t);
    	if(t == x)
    		return true;
    	if(search(t.left, x, path))
    		return true;
    	if(search(t.right, x, path))
    		return true;
    	path.remove(path.size()-1);
    	return false;
    }
}
