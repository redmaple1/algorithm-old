package com.linkedlist;

public class _25ReverseNodesInKGroup {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static ListNode createLinkedList(int[] arr,int n){
		if(n == 0)
			return null;
		
		ListNode head = new ListNode(arr[0]);
		ListNode curNode = head;
		for(int i = 1; i < arr.length; i++){
			curNode.next = new ListNode(arr[i]);
			curNode = curNode.next;
		}
		return head;
	}
	
	public static void printLinkedList(ListNode head){
		ListNode curNode = head;
		while(curNode != null){
			System.out.print(curNode.val + " -> ");
			curNode = curNode.next;
		}
		System.out.print("null" + "\n");
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummyHead = new ListNode(0);
		ListNode pre = dummyHead;
		ListNode cur = pre;
		dummyHead.next = head;
		int num = 0;
		while(cur != null && cur.next != null){
			cur = cur.next;
			++ num;
		}
		while(num >= k){
			cur = pre.next;
			for(int i = 1;i < k; i++){
				ListNode t = cur.next;
				cur.next = t.next;
				t.next = pre.next;
				pre.next = t;
			}
			pre = cur;
			num -= k;
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int n = arr.length;
		
		ListNode head = createLinkedList(arr, n);
		int k = 3;
		printLinkedList(head);
		
		ListNode head2 = reverseKGroup(head, k);
		printLinkedList(head2);

	}

}
