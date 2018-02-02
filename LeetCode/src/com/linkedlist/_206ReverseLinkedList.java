package com.linkedlist;

import javax.sound.sampled.ReverbType;

public class _206ReverseLinkedList {
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
	
	public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
           	ListNode next = cur.next;
           	cur.next = pre;
           	pre = cur;
           	cur = next;
        }
        return pre;
    }

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int n = arr.length;
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		ListNode head2 = reverseList(head);
		printLinkedList(head2);
		

	}

}
