package com.linkedlist;

public class _2AddTwoNumbers {
	
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
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode addHead = new ListNode(0);
        if(l1 == null && l2 == null)
        	return addHead;
        int sum = 0,carry = 0;
        ListNode addNode = addHead;
        while(l1 != null || l2 != null){
        	int num1 = l1 == null ? 0 : l1.val;
        	int num2 = l2 == null ? 0 : l2.val;
        	sum = num1 + num2 + carry;
        	addNode.next = new ListNode(sum % 10);
        	addNode = addNode.next;
        	carry = sum / 10;
        	l1 = l1 == null ? null : l1.next;
        	l2 = l2 == null ? null : l2.next;        	
        }
        if(carry != 0){
        	addNode.next = new ListNode(carry);
        }
        return addHead.next;
    }

	public static void main(String[] args) {
		int[] arr1 = {2,4,3};
		int n = arr1.length;
		int[] arr2 = {5,6,4};
		int m = arr2.length;
		
		ListNode l1 = createLinkedList(arr1, n);
		ListNode l2 = createLinkedList(arr2, m);
		printLinkedList(l1);
		printLinkedList(l2);
		
		ListNode res = addTwoNumbers(l1, l2);
		printLinkedList(res);

	}

}
