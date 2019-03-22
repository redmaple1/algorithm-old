package com.linkedlist;

import com.linkedlist._19RemoveNthNodeFromEndOfList.ListNode;

public class _61RotateList {
	
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
	
	public static ListNode rotateRight(ListNode head, int k) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
        //求链表长度
		int length = 0;
		ListNode cur = head;
		while(cur != null){
			cur = cur.next;
			length ++;
		}
		if(length == 0 || length == 1)
			return head;
		int t = k % length;
		if(t == 0)
			return head;
		
		ListNode p = dummyHead;
		ListNode q = dummyHead;
		for(int i = 0; i < t + 1; i ++){
			assert(q != null);
			q = q.next;
		}
		while(q != null){
			p = p.next;
			q = q.next;
		}
		ListNode rotateNode = p.next;
		while(rotateNode != null && rotateNode.next != null){
			rotateNode = rotateNode.next;
		}
		rotateNode.next = head;
		dummyHead.next = p.next;
		p.next = null;
		
		return dummyHead.next;
    }

	public static void main(String[] args) {
		int[] arr = {1};
		int n = arr.length;
		
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		int k = 0;
		ListNode head2 = rotateRight(head, k);
		printLinkedList(head2);

	}

}
