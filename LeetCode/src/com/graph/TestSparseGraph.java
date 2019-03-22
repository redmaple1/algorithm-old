package com.graph;

import com.graph.SparseGraph.adjIterator;

public class TestSparseGraph {

	public static void main(String[] args) {
		int N = 20;
		int M = 100;
		
		SparseGraph g1 = new SparseGraph(N, false);
		for(int i = 0; i < M; i ++){
			int a = (int)Math.random() % N;
			int b = (int)Math.random() % N;
			g1.addEdge(a, b);
		}
		
		for(int v = 0; v < N; v ++){
			System.out.print(v + " : ");
			SparseGraph.adjIterator adj = g1.new adjIterator(g1, v);
			for(int w = adj.begin(); !adj.end(); w = adj.next())
				System.out.print(w + " ");
			System.out.println();
		}

	}

}
