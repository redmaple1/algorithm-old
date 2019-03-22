package com.linkedlist;

import com.linkedlist._61RotateList.ListNode;

public class _143ReorderList {
	
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
	
	public static void reorderList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        }
        ListNode middle = slow;
        ListNode pre = null;
        ListNode secondHalf = middle.next;
        //置空前半部分
        slow.next = null;
        //将后半部分reverse
        ListNode next = null;
        while(secondHalf != null){
        	next = secondHalf.next;
        	secondHalf.next = pre;
        	pre = secondHalf;        	
        	secondHalf = next;
        }
        secondHalf = pre;
        
        while(secondHalf != null){
        	//暂存第一个的后续节点
        	ListNode next1 = head.next;
        	head.next = secondHalf;
        	secondHalf = secondHalf.next;
        	head = head.next;
        	head.next = next1;
        	head = head.next;
        }
        
    }

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int n = arr.length;
		
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		reorderList(head);
		printLinkedList(head);
		

	}

}
