package com.linkedlist;

public class _24SwapNodesInPairs {
	
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
	
	public static ListNode swapPairs(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		
		ListNode p = dummyHead;
		while(p.next != null && p.next.next != null){
			ListNode node1 = p.next;
			ListNode node2 = node1.next;
			ListNode next = node2.next;
			
			node2.next = node1;
			node1.next = next;
			p.next = node2;
			
			p = node1;
		}
        return dummyHead.next;
    }

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int n = arr.length;
		
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		ListNode head2 = swapPairs(head);
		printLinkedList(head2);

	}

}
