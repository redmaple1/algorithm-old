package com.linkedlist;

public class _234PalindromeLinkedList {
	
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
	
	public static boolean isPalindrome(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        }
        
        ListNode second = slow.next;
        slow.next = null;
        //求reverse
        ListNode pre = null;
        ListNode cur = second;
        while(cur != null){
        	ListNode next = cur.next;
        	cur.next = pre;
        	pre = cur;
        	cur = next;
        }
        while(pre != null && head != null){
        	if(pre.val == head.val){
        		pre = pre.next;
        		head = head.next;
        	}else{
        		return false;
        	}
        }
        return true;
    }

	public static void main(String[] args) {
		int[] arr = {1,2,3,3,2,1};
		int n = arr.length;
		
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		boolean res = isPalindrome(head);
		System.out.println(res);

	}

}
