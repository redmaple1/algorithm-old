package com.linkedlist;

public class _148SortList {
	
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
	
	public static ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		//定义两个指针
		ListNode fast = head,slow = head;
		//慢指针找到中间节点
		while(fast.next != null && fast.next.next != null){
			//快指针一次两步
			fast = fast.next.next;
			//慢指针一次一步
			slow = slow.next;
		}
		//从中间断开
		fast = slow.next;
		slow.next = null;
		//前段排序
		ListNode left = sortList(head);
		//后段排序
		ListNode right = sortList(fast);
		//前后段合并
		return mergeTwoLists(left,right);
		
    }
	
	private static ListNode mergeTwoLists(ListNode l1,ListNode l2){
		ListNode dummyHead = new ListNode(0);
		ListNode cur = dummyHead;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				cur.next = l1;
				l1 = l1.next;
			}else{
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		cur.next = l1 == null ? l2 : l1;
		return dummyHead.next;
	}

	public static void main(String[] args) {
		int[] arr = {2,1,4,3,6,5};
		int n = arr.length;
		
		ListNode head = createLinkedList(arr, n);
		printLinkedList(head);
		
		ListNode head2 = sortList(head);
		printLinkedList(head2);

	}

}
