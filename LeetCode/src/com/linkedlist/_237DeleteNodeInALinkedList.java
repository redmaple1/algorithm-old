package com.linkedlist;

import com.linkedlist._148SortList.ListNode;

public class _237DeleteNodeInALinkedList {
	
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
	
	public static void deleteNode(ListNode node) {
        if(node == null)
        	return;
        
        if(node.next == null)
        	node = null;
        
        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
    }

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int n = arr.length;
		
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		deleteNode(head.next.next);
		printLinkedList(head);
		

	}

}
