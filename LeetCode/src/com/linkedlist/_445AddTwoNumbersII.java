package com.linkedlist;

import java.util.Stack;

import com.linkedlist._2AddTwoNumbers.ListNode;

public class _445AddTwoNumbersII {
	
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
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		while(l1 != null){
			s1.push(l1.val);
			l1 = l1.next;
		}
		while(l2 != null){
			s2.push(l2.val);
			l2 = l2.next;
		}
		int sum = 0;
		ListNode res = new ListNode(0);
		while(!s1.isEmpty() || !s2.isEmpty()){
			if(!s1.isEmpty()){
				sum += s1.peek();
				s1.pop();
			}
			if(!s2.isEmpty()){
				sum += s2.peek();
				s2.pop();
			}
			res.val = sum % 10;
			ListNode head = new ListNode(sum / 10);
			head.next = res;
			res = head;
			sum /= 10;
		}
        return res.val == 0 ? res.next : res;
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
