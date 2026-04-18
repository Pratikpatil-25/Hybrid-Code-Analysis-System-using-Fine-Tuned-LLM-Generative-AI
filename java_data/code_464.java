package graphTheory;







public class BellmanFord {

	

	
	
	public static int[] bellmanFord(GraphAMWD g, int src) throws NegativeCycleException {

		int[] dist = new int[g.V];

		for (int i=0; i<g.V; i++)

			dist[i] = Integer.MAX_VALUE;

		

		dist[src] = 0;

		

		
		for (int i=0; i<g.V-1; i++) {

			for (int j=0; j<g.E; j++) {

				if (dist[g.adj[j][0]] != Integer.MAX_VALUE 

						&& dist[g.adj[j][0]] + g.adj[j][2] < dist[g.adj[j][1]]) {

					

					dist[g.adj[j][1]] = dist[g.adj[j][0]] + g.adj[j][2];

					

				}

			}

		}

		

		
		for (int i=0; i<g.E; i++) {

			int x = g.adj[i][0];

			int y = g.adj[i][1];

			int w = g.adj[i][2];

			if (dist[x] != Integer.MAX_VALUE && dist[x] + w < dist[y])

				throw new NegativeCycleException();

		}

		

		return dist;

	}
	

}






@SuppressWarnings("serial")

class NegativeCycleException extends Exception {

	

	NegativeCycleException(){

		super("The graph has a negative cycle.");

	}

	

}