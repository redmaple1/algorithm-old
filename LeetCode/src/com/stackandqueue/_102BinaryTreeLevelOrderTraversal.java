package com.stackandqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102BinaryTreeLevelOrderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private class LevelNode{
		TreeNode node;
		int level;
		
		LevelNode(TreeNode node,int level){
			this.node = node;
			this.level = level;
		}
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
        	return res;
        
        LinkedList<LevelNode> queue = new LinkedList<LevelNode>();
        queue.addLast(new LevelNode(root,0));
        while(!queue.isEmpty()){
        	LevelNode front = queue.removeFirst();
        	TreeNode node = front.node;
        	int level = front.level;
        	
        	if(level == res.size())
        		res.add(new ArrayList<Integer>());
        	assert level < res.size();
        	
        	res.get(level).add(node.val);
        	if(node.left != null)
        		queue.addLast(new LevelNode(node.left,level + 1));
        	if(node.right != null)
        		queue.addLast(new LevelNode(node.right,level + 1));
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
