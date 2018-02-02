package com.linkedlist;

import com.linkedlist._206ReverseLinkedList.ListNode;

public class _83RemoveDuplicatesFromSortedList {
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
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return null;
		
		ListNode preNode = head;
		ListNode curNode = preNode.next;
		while(curNode != null){
			if(curNode.val == preNode.val){
				preNode.next = curNode.next;
			}else{
				preNode = curNode;
			}
			curNode = curNode.next;
		}
		return head;        
    }
	
	public static void main(String[] args) {
		int[] arr = {1,1,2,3,3};
		int n = arr.length;
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		ListNode head2 = deleteDuplicates(head);
		printLinkedList(head2);
		
	}

}
