package com.linkedlist;

public class _328OddEvenLinkedList {
	
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
	
	public static ListNode oddEvenList(ListNode head) {
		if(head == null)
			return null;
		ListNode oddHead = new ListNode(0);
		ListNode evenHead = new ListNode(0);
		ListNode curNode = head,odd = oddHead,even = evenHead;
		for(int i = 1;curNode != null;i ++){
			ListNode next = curNode.next;
			if(i % 2 != 0){
				odd.next = curNode;
				odd = odd.next;
				odd.next = null;
			}else{
				even.next = curNode;
				even = even.next;
				even.next = null;
			}
			curNode = next;
		}
		odd.next = evenHead.next;
		return oddHead.next;
        
    }
	

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int n = arr.length;
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		ListNode head2 = oddEvenList(head);
		printLinkedList(head2);

	}

}
