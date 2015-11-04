//Given a singly linked list, determine if it is a palindrome.
//
//Follow up:
//Could you do it in O(n) time and O(1) space?
package _234_palindromeLinkedList;

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
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(1);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		Solution s = new Solution();
		System.out.println(s.isPalindrome(n1));
	}

    public boolean isPalindrome(ListNode head) {
        l = head;
        return isP(head);
    }
    
    //������Ԫ��ѹ��ջ�У�Ȼ������ȡ�����ջ��Ԫ�رȽ�
    //ʹ�õݹ�ջ�����Լ�newһ��ջ��
    private ListNode l;
    private boolean isP(ListNode h) {
    	if(h==null)
    		return true;
    	if(!isP(h.next))
    		return false;
    	if(l.val==h.val) {
    		l=l.next;
    		return true;
    	}else
    		return false;
    }
}
