package com.stackandqueue;

import java.util.ArrayList;
import java.util.List;

public class _145BinaryTreePostorderTraversal {
	
	List<Integer> list = new ArrayList<Integer>();
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null){
        	postorderTraversal(root.left);
        	postorderTraversal(root.right);
        	list.add(root.val);
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
