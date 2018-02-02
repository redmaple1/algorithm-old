package com.linkedlist;

public class _82RemoveDuplicatesFromSortedListII {
	
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
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while(cur != null){
        	while(cur.next != null && cur.val == cur.next.val){
        		cur = cur.next;
        	}
        	if(pre.next == cur){
        		pre = pre.next;
        	}else{
        		pre.next = cur.next;
        	}
        	cur = cur.next;
        }
        return dummyHead.next;
    }

	public static void main(String[] args) {
		int[] arr = {1,1,1};
		int n = arr.length;
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		ListNode head2 = deleteDuplicates(head);
		printLinkedList(head2);

	}

}
