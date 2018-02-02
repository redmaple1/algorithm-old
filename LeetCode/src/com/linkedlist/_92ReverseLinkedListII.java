package com.linkedlist;

public class _92ReverseLinkedListII {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode newHead = new ListNode(-1);
		newHead.next = head;
		
		if(head == null || head.next == null)
			return newHead.next;
		
		ListNode start = newHead; //start指向需要开始reverse的前一个
		ListNode node1 = null; //需要reverse到后面的节点
		ListNode node2 = null; //需要reverse到前面的节点
		
		for(int i = 0; i < n; i++){
			if(i < m - 1){
				start = start.next;
			}else if(i == m - 1){ //开始第一轮
				node1 = start.next;
				node2 = node1.next;
			}else{
				node1.next = node2.next; //将node1交换到node2后面
				node2.next = start.next; //node2交换到最开始
				start.next = node2; //node2作为新的节点
				node2 = node1.next; //node2回归到node1的下一个，继续遍历	
			}
		}
		return newHead.next;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
