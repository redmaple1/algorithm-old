package com.linkedlist;

public class _203RemoveLinkedListElements {
	
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
	
	public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        
        ListNode cur = dummyNode;
        while(cur.next != null){
        	if(cur.next.val == val){
        		ListNode delNode = cur.next;
        		cur.next = delNode.next;
        		delNode.next = null;
        	}else
        		cur = cur.next;
        }
        return dummyNode.next;
    }

	public static void main(String[] args) {
		int[] arr = {1,2,6,3,4,5,6};
		int n = arr.length;
		int val = 6;
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		ListNode head2 = removeElements(head, val);
		printLinkedList(head2);

	}

}
