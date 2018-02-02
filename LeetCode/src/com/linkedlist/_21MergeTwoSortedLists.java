package com.linkedlist;

import com.linkedlist._82RemoveDuplicatesFromSortedListII.ListNode;

public class _21MergeTwoSortedLists {
	
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
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode cur = dummyHead;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				cur.next = l1;
				l1 = l1.next;
			}else{
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		cur.next = l1 == null ? l2 : l1;
		return dummyHead.next;
    }

	public static void main(String[] args) {
		int[] arr1 = {1,2,4};
		int n = arr1.length;
		int[] arr2 = {1,3,4};
		int m = arr2.length;
		
		ListNode l1 = createLinkedList(arr1, n);
		ListNode l2 = createLinkedList(arr2, m);
		printLinkedList(l1);
		printLinkedList(l2);
		
		ListNode merge = mergeTwoLists(l1, l2);
		printLinkedList(merge);

	}

}
