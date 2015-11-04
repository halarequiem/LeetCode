//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//According to the definition of LCA on Wikipedia: 
//¡°The lowest common ancestor is defined between two nodes v and w 
//as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).¡±
//
//        _______6______
//       /              \
//    ___2__          ___8__
//   /      \        /      \
//   0      _4       7       9
//         /  \
//         3   5
//For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2,
//since a node can be a descendant of itself according to the LCA definition.
package _235_lowestCommonAncestorOfABst;

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
    	TreeNode r = new TreeNode(6);
    	TreeNode t1 = new TreeNode(2);
    	TreeNode t2 = new TreeNode(8);
    	TreeNode t3 = new TreeNode(0);
    	TreeNode t4 = new TreeNode(4);
    	r.left = t1;
    	r.right = t2;
    	t1.right = t3;
    	t1.left = t4;
    	
    	System.out.println(s.lowestCommonAncestor(r, t1, t2).val);
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	List<TreeNode> pp = search(root, p);
    	List<TreeNode> qp = search(root, q);
    	for(int i = 0 ; i < (pp.size()<qp.size()?pp.size():qp.size()) ; i++)
    		if(pp.get(i)!=qp.get(i))
    			return pp.get(i-1);
    	return pp.size()<qp.size()?p:q;
    	
    }
    
    private List<TreeNode> search(TreeNode t , TreeNode x) {
    	List<TreeNode> r = new ArrayList<TreeNode>();
    	while (t!=null && t!=x) {
    		r.add(t);
    		if(t.val>x.val) 
    			t=t.left;
    		else
    			t=t.right;
    	}
    	r.add(t);
    	return r;
    }
}
