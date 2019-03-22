package com.stackandqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _199BinaryTreeRightSideView {
	
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
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
        	return res;
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        LinkedList<LevelNode> queue = new LinkedList<LevelNode>();
        queue.addLast(new LevelNode(root,0));
        
        while(!queue.isEmpty()){
        	LevelNode front = queue.removeFirst();
        	TreeNode node = front.node;
        	int level = front.level;
        	if(level == list.size())
        		list.add(new ArrayList<Integer>());
        	list.get(level).add(node.val);
        	if(node.left != null)
        		queue.addLast(new LevelNode(node.left,level + 1));
        	if(node.right != null)
        		queue.addLast(new LevelNode(node.right,level + 1));
        }
        
        for(int i = 0; i < list.size(); i++){
        	List<Integer> tmp = list.get(i);
        	res.add(tmp.get(tmp.size() - 1));
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
