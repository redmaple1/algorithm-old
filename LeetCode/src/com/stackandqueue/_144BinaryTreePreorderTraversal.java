package com.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144BinaryTreePreorderTraversal {
	
	List<Integer> list = new ArrayList<Integer>();
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public class Command {
		String s;
		TreeNode node;
		Command(String s,TreeNode node){s = this.s; node = this.node;}
	}
	
	/**
	 * 递归实现
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		
        if(root != null){
        	list.add(root.val);
        	preorderTraversal(root.left);
        	preorderTraversal(root.right);
        }
        return list;
    }
	
	/**
	 * 非递归实现
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal1(TreeNode root) {
		
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
        	return res;
        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));
        while(!stack.isEmpty()){
        	Command command = stack.pop();        	
        	
        	if(command.s.equals("print"))
        		res.add(command.node.val);
        	else{
        		assert command.s.equals("go");
        		stack.push(new Command("print",command.node));
        		if(command.node.right != null)
        			stack.push(new Command("go",command.node.right));
        		if(command.node.left != null)
        			stack.push(new Command("go",command.node.left));
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
