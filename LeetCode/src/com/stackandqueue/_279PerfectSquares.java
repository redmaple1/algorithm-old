package com.stackandqueue;

import java.util.LinkedList;

public class _279PerfectSquares {
	
	public static class ChildNode{
		int num;
		int step;
		public ChildNode(int num,int step){
			this.num = num;
			this.step = step;
		}
	}
	
	public static int numSquares(int n) {
		assert n > 0;
		
        LinkedList<ChildNode> q = new LinkedList<ChildNode>();
        q.addLast(new ChildNode(n, 0));
        
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        
        while(!q.isEmpty()){
        	ChildNode node = q.removeFirst();
        	int num = node.num;
        	int step = node.step;
        	
        	for(int i = 1; ;i ++){
        		int a = num - i * i;
        		if(a < 0)
        			break;
        		if(a == 0)
        			return step + 1;
        		if(!visited[a]){
        			q.addLast(new ChildNode(a, step + 1));
        			visited[a] = true;
        		}
        	}
        }
        	throw new IllegalArgumentException("No Solution.");
    }

	public static void main(String[] args) {
		int n = 12;
		int step = numSquares(n);
		System.out.println(step);

	}

}
