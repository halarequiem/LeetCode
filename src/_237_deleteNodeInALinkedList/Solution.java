//Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
//
//Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
//the linked list should become 1 -> 2 -> 4 after calling your function.
package _237_deleteNodeInALinkedList;

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
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		Solution s =new Solution();
		s.deleteNode(n1);
		ListNode node =n1;
		while(node!=null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

    public void deleteNode(ListNode node) {
        while(node.next.next != null) {
        	node.val = node.next.val;
        	node = node.next;
        }
    	node.val = node.next.val;
        node.next = null;
    }
}
