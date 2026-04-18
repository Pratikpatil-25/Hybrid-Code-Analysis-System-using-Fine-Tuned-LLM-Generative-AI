import java.util.*;

public class TopologicalSort {
    
    public static List<Integer> topologicalSort(int numVertices, List<List<Integer>> adjacencyList) {
        int[] inDegree = new int[numVertices];
        for (List<Integer> neighbors : adjacencyList) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numVertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            topologicalOrder.add(vertex);

            for (int neighbor : adjacencyList.get(vertex)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (topologicalOrder.size() != numVertices) {
            throw new IllegalStateException("Graph has at least one cycle");
        }

        return topologicalOrder;
    }

    public static void main(String[] args) {
                int numVertices = 6;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        adjacencyList.get(5).add(2);
        adjacencyList.get(5).add(0);
        adjacencyList.get(4).add(0);
        adjacencyList.get(4).add(1);
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(1);

        try {
            List<Integer> result = topologicalSort(numVertices, adjacencyList);
            System.out.println("Topological Sort: " + result);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}