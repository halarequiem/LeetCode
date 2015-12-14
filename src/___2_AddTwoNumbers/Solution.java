//You are given two linked lists representing two non-negative numbers. 
//The digits are stored in reverse order and each of their nodes contain a single digit. 
//Add the two numbers and return it as a linked list.
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
package ___2_AddTwoNumbers;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n11 = new ListNode(5);
		ListNode n12 = new ListNode(4);
		ListNode n13 = new ListNode(3);
		n11.next=n12;
		n12.next=n13;
		ListNode n21 = new ListNode(5);
		ListNode n22 = new ListNode(6);
		ListNode n23 = new ListNode(4);
		n21.next=n22;
		n22.next=n23;
		ListNode r= s.addTwoNumbers(n11, n21);
		while(r!=null){
			System.out.print(r.val);
			r=r.next;
		}	
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1==null)
    		return l2;
    	if(l2==null)
    		return l1;
    	ListNode r=new ListNode((l1.val+l2.val)%10);
    	int carry = (l1.val+l2.val)/10;
    	ListNode i=r;
    	l1=l1.next;
    	l2=l2.next;
        while (l1!=null||l2!=null) {
        	int n = (l1==null?0:l1.val)+(l2==null?0:l2.val)+carry;
        	i.next=new ListNode(n%10);
        	carry = n/10;
        	i=i.next;
        	l1=l1==null?null:l1.next;
        	l2=l2==null?null:l2.next;
        }
        if(carry!=0)
        	i.next=new ListNode(1);
        return r;
    }

}
