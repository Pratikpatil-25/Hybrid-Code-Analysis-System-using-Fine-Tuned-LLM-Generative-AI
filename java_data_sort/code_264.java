import java.util.* ;
import java.io.*; 
public class Solution { 
    static ArrayList<ArrayList<Integer>>adjList;
    static boolean [] visited;
    static Stack<Integer>stack;
    
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
                stack=new Stack<>();
        adjList=new ArrayList<>(v);
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int j=0;j<e;j++){
            int vertex1=edges.get(j).get(0);
            int vertex2=edges.get(j).get(1);
            adjList.get(vertex1).add(vertex2);
        }
        visited=new boolean[v+1];
        for(int i=0;i<v;i++){
            if(!visited[i]){ 
                dfs(i);
            }
        }
        ArrayList<Integer>res=new ArrayList<>();
        while(!stack.isEmpty())
            res.add(stack.pop());
        return res;

    }
    public static void dfs(int source){
        visited[source]=true;
        for(int neighbour:adjList.get(source)){
            if(!visited[neighbour]){ 
                dfs(neighbour);
            }
        }
        stack.push(source);
    }
    
}