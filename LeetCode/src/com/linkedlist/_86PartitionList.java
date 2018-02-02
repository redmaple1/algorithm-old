package com.linkedlist;

public class _86PartitionList {
	
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
	
	public static ListNode partition(ListNode head, int x) {
        //思路：设置两个头指针lessHead 和 bigHead,两个链表，存放比x小的元素和比x大的元素，最后连接成一个新链表，返回
		if(head == null)
			return null;
		
		ListNode lessHead = new ListNode(0);
		ListNode bigHead = new ListNode(0);
		ListNode curNode = head,lessNode = lessHead,bigNode = bigHead;
		while(curNode != null){
			ListNode next = curNode.next;
			if(curNode.val < x){
				lessNode.next = curNode;
				lessNode = lessNode.next;
				lessNode.next = null;
			}else{
				bigNode.next = curNode;
				bigNode = bigNode.next;
				bigNode.next = null;
			}
			curNode = next;
		}
		lessNode.next = bigHead.next;
		return lessHead.next;
    }

	public static void main(String[] args) {
		int[] arr = {1,4,3,2,5,2};
		int n = arr.length;
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		ListNode head2 = partition(head, 3);
		printLinkedList(head2);

	}

}
