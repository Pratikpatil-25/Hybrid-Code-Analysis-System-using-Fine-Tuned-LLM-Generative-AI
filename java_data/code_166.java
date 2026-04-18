package Graphs.ShortestPathInGraph.ShortestPath_BellmanFordAlgorithm;
import java.util.ArrayList;
import java.util.Arrays;




public class BellmanFordAlgorithm {
    
            public int[] bellmanFordAlgorithm(int sourceVertex, int V, ArrayList<ArrayList<int[]>> adjList){

                ArrayList<Edge> edges = convertAdjacencyListToEdges(V, adjList);

                        int[] shortestPath = new int[V];
        Arrays.fill(shortestPath, (int) 1e9);
        shortestPath[sourceVertex] = 0;

                                                for (int i = 1; i <= V -1; i++){
            for (Edge edge : edges){
                if (shortestPath[edge.endVertex] > shortestPath[edge.startVertex] + edge.weight)
                    shortestPath[edge.endVertex] = shortestPath[edge.startVertex] + edge.weight;
            }
        }
        return shortestPath;
    }

        private ArrayList<Edge> convertAdjacencyListToEdges(int V, ArrayList<ArrayList<int[]>> adjList){
        ArrayList<Edge> edges = new ArrayList<>();

        for (int vertex = 0; vertex < V; vertex++){
            for (int[] neighbour : adjList.get(vertex)){
                int endVertex = neighbour[0];
                int edgeWeight = neighbour[1];
                edges.add(new Edge(vertex, endVertex, edgeWeight));
            }
        }
        return edges;
    }

            static class Edge{
        int startVertex, endVertex, weight;

        public Edge(int startVertex, int endVertex, int edgeWeight) {
            this.startVertex = startVertex;
            this.endVertex = endVertex;
            this.weight = edgeWeight;
        }
    }
}