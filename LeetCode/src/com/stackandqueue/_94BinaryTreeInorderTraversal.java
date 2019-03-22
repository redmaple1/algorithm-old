package com.stackandqueue;

import java.util.ArrayList;
import java.util.List;

public class _94BinaryTreeInorderTraversal {
	
	List<Integer> list = new ArrayList<Integer>();
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null){
        	inorderTraversal(root.left);
        	list.add(root.val);
        	inorderTraversal(root.right);
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
