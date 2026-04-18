package com.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class TopologicalSort {
	
	Graph g;
	public TopologicalSort(Graph g) {
		this.g= g;
	}

	
	public void postOrderTopologicalSort() {
		boolean visited[] = new boolean[g.vertexCount];
		Queue<Integer> q  = new LinkedList<>();
		for(int i=0; i < g.vertexCount; i++) {
			if(!visited[i]) {
				dfs(i, visited,q);
			}
		}
		System.out.println("\n"+q.toString());
	}
	
	
	public void dfs(int v, boolean visited[], Queue<Integer> q) {
		visited[v] = true;
		for(int neighbor : g.adj(v)) {
			if(!visited[neighbor]) {
				dfs(neighbor, visited,q);
			}
		}
		q.offer(v);
	}
	
	
		public void kahnTopologicalSort() {
						int indegree[] = new int[g.vertexCount];

						for (int i = 0; i < g.vertexCount; i++) {
			ArrayList<Integer> temp = (ArrayList<Integer>) g.nodes[i];
			for (int node : temp) {
				indegree[node]++;
			}
		}

						Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < g.vertexCount; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}

				int cnt = 0;

						Vector<Integer> topOrder = new Vector<Integer>();
		while (!q.isEmpty()) {
									int u = q.poll();
			topOrder.add(u);

												for (int node : g.nodes[u]) {
								if (--indegree[node] == 0)
					q.add(node);
			}
			cnt++;
		}

				if (cnt != g.vertexCount) {
			System.out.println("There exists a cycle in the graph");
			return;
		}

				for (int i : topOrder) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
				         Graph g=new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("Following is a Topological Sort");
        TopologicalSort k = new TopologicalSort(g);
        k.kahnTopologicalSort();
        k.postOrderTopologicalSort();
        
	}

}