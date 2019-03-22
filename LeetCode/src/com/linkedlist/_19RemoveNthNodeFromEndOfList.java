package com.linkedlist;

import com.linkedlist._237DeleteNodeInALinkedList.ListNode;

public class _19RemoveNthNodeFromEndOfList {
	
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
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		assert(n >= 0);
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for(int i = 0; i < n + 1; i ++){
        	assert(q != null);
        	q = q.next;
        }
        while(q != null){
        	p = p.next;
        	q = q.next;
        }
        
        ListNode delNode = p.next;
        p.next = delNode.next;
        
        return dummyHead.next;
    }

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int n = arr.length;
		
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		int m = 2;
		ListNode head2 = removeNthFromEnd(head, m);
		printLinkedList(head2);

	}

}
