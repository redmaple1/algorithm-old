package com.graph;

import java.util.ArrayList;
import java.util.Vector;

public class SparseGraph {
	private int n; //图的顶点数
	private int m; //图的边数
	private boolean directed; //是否是有向图
	private Vector<Integer>[] g;
	
	public SparseGraph(int n,boolean directed){
		this.n = n;
		this.m = 0;
		this.directed = directed;
		g = (Vector<Integer>[])new Vector[n];
		for(int i = 0; i < n; i ++)
			g[i] = new Vector<Integer>();
	}
	
	public int V(){
		return n;
	}
	
	public int E(){
		return m;
	}
	
	public void addEdge(int v,int w){
		assert v >= 0 && v < n;
		assert w >= 0 && w < n;
		
		g[v].add(w);
		if(v != w && !directed)
			g[w].add(v);
		
		m ++;
	}
	
	public boolean hasEdge(int v,int w){
		assert v >= 0 && v < n;
		assert w >= 0 && w < n;
		
		for(int i = 0; i < g[v].size(); i ++)
			if(g[v].elementAt(i) == w)
				return true;
		return false;
	}
	
	class adjIterator{
		private SparseGraph G;
		private int v;
		private int index;
		
		public adjIterator(SparseGraph graph,int v) {
			this.G = graph;
			this.v = v;
			this.index = 0;
		}
		
		int begin(){
			index = 0;
			if(G.g[v].size() >= 0)
				return G.g[v].get(index);
			return -1;
		}
		
		int next(){
			index ++;
			if(index < G.g[v].size())
				return G.g[v].get(index);
			return -1;
		}
		
		boolean end(){
			return index >= G.g[v].size();
		}
		
	}


}
