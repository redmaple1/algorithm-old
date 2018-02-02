package com.linkedlist;

public class _147InsertionSortList {
	
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
	
	public static ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        while(head != null){
        	ListNode tmp = head.next;
        	ListNode cur = dummyHead;
        	while(cur.next != null && cur.next.val < head.val){
        		cur = cur.next;
        	}
        	//插入
        	head.next = cur.next;
        	cur.next = head;
        	//恢复head
        	head = tmp;
        }
        return dummyHead.next;
    }
	
	public static void printLinkedList(ListNode head){
		ListNode curNode = head;
		while(curNode != null){
			System.out.print(curNode.val + " -> ");
			curNode = curNode.next;
		}
		System.out.print("null" + "\n");
	}

	public static void main(String[] args) {
		int[] arr = {2,1,4,3};
		int n = arr.length;
		
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		ListNode head2 = insertionSortList(head);
		printLinkedList(head2);

	}

}
