package com.graph;

import java.util.Vector;

/**
 * 稠密图 - 邻接矩阵
 * @author renmagical
 *
 */
public class DenseGraph {
	
	private int n; //图的顶点数
	private int m; //图的边数
	private boolean directed; //是否是有向图
	private Vector<Vector<Boolean>> g;
	
	public DenseGraph(int n,boolean directed) {
		this.n = n;
		this.m = 0;
		this.directed = directed;
		for(int i = 0; i < n; i++)
			g.add(new Vector<Boolean>(n));
	}
	
	public int V(){
		return n;
	}
	
	public int E(){
		return m;
	}
	
	void addEdge(int v,int w){
		assert v >= 0 && v < n;
		assert w >= 0 && w < n;
		
		if(hasEdge(v, w))
			return;
		g.get(v).set(w, true);
		if(!directed)
			g.get(w).set(v, true);
		
		m++;
	}
	
	boolean hasEdge(int v,int w){
		assert v >= 0 && v < n;
		assert w >= 0 && w < n;
		return g.get(v).get(w);
	}

}
