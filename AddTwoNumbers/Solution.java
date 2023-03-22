/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode newList = new ListNode();
		ListNode currentNode = newList;
		int prev = 0; // The number to be carried
		while(l1 != null && l2 != null) {
			int val = l1.val + l2.val + prev;
			ListNode newNode = new ListNode(val % 10); // Create a new node that is just the ones position of the value	
			prev = val / 10; // Set amt to be carried 
			currentNode.next = newNode;
			currentNode = newNode;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null) {
			int val = l1.val + prev;
			ListNode newNode = new ListNode(val % 10);
			prev = val / 10;
			currentNode.next = newNode;
			currentNode = newNode;
			l1 = l1.next;
		}
		while(l2 != null) {
			int val = l2.val + prev;
			ListNode newNode = new ListNode(val % 10);
			prev = val / 10;
			currentNode.next = newNode;
			currentNode = newNode;
			l2 = l2.next;
		}
		if(prev != 0) {
			currentNode.next = new ListNode(prev);
		}
		return newList.next;
	}
}
