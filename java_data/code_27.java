import java.util.*;


public class DFS {

	public static boolean dfs(Graph g, Node src, Node dest) {
		src.marked = true;
		if(src == dest)
			return true;
		else {
			for(Node u : src.getAdjacent()) {
				if(!u.marked && dfs(g, u, dest)) 
					return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		Graph g = Graph.readGraph();
	}
}