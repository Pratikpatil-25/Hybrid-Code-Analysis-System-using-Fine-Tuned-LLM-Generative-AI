import java.util.ArrayList;

public class run {

    


    public static void main(String[] args) {


        Graph graph = new Graph();

        int[][] adjacencyMatrix = {
            {0, 800, 600, 650, 260, 0, 0, 750, 60, 0, 0, 190, 400},
            {800, 0, 100, 0, 0, 0, 0, 50, 0, 0, 0, 0, 350},
            {600, 100, 0, 140, 0, 0, 0, 0, 0, 0, 0, 0, 300},
            {650, 0, 140, 0, 0, 0, 0, 0, 0, 0, 0, 0, 350},
            {260, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 10, 0, 30, 0, 50, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 30, 0, 50, 0, 0, 0, 0, 0},
            {750, 50, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 0},
            {60, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 80, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 80, 0, 150, 0},
            {190, 0, 0, 0, 0, 0, 0, 0, 0, 0, 150, 0, 500},
            {400, 350, 300, 350, 0, 0, 0, 0, 0, 0, 0, 500, 0}
        };

        char [] nodeValues = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n'};

                for (char nodeValue : nodeValues) {
            graph.addNode(new Node(nodeValue));
        }

                ArrayList<Node> nodesList = graph.getNodes();

                for (int i = 0; i < nodeValues.length; i++) {
            for (int j = 0; j < nodeValues.length; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    graph.addEdge(new Edge(nodesList.get(i), nodesList.get(j), adjacencyMatrix[i][j]));
                }
            }
        }

                for (Node node : nodesList) {
            for (Edge edge : graph.getEdges()) {
                if (edge.getStart().getValue() == node.getValue()) {
                    node.addNeighbour(edge.getEnd());
                }
            }
        }



                                                
        
                                                
                                                                
                                                                
                                                                                                                                
        
        run run = new run();



        System.out.println(run.algorithm(graph, nodesList.get(0)));
        
    }

    
    public String algorithm (Graph graph, Node start) {

        ArrayList<Edge> edges = graph.getEdges();

        Node current = start;

        ArrayList<Node> visited = new ArrayList<Node>();
        ArrayList<Node> unvisited = new ArrayList<Node>();

                for (Node node : graph.getNodes()) {
            node.setPrevNode(new Node());
        }


        for (Node node : graph.getNodes()) {
            unvisited.add(node);
        }

                for (Node node : graph.getNodes()) {
            if (node.equals(start)) {
                node.setWeight(0);
            }
        }

        while (!unvisited.isEmpty()) {
            visited.add(current);
            unvisited.remove(current);
            for (Node neighbour : current.getNeighbours()) {
                if (visited.contains(neighbour)) {
                    continue;
                } 
                else {
                    
                    for (Edge edge : edges) {
                        if ((edge.getStart().getValue() == current.getValue() && edge.getEnd().getValue() == neighbour.getValue()) || (edge.getStart().getValue() == neighbour.getValue() && edge.getEnd().getValue() == current.getValue())) {
                            int weight = current.getWeight() + edge.getWeight();
                            if (weight < neighbour.getWeight()) {
                                neighbour.setWeight(weight);
                                neighbour.setPrevNode(current);
                            }
                        }
                    }

                }  
            }

                                    if (!unvisited.isEmpty()) {
                unvisited.sort((Node n1, Node n2) -> n1.getWeight() - n2.getWeight());
                current = unvisited.get(0);
            }      
            
        }

        return graph.toString();

    }



    


}