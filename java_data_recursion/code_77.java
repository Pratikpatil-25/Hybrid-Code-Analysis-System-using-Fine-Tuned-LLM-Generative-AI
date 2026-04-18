import java.util.Scanner;
public class DFS {

	public static void printHelper(int arr[][],int vertice,boolean visited[]) {
				System.out.println(vertice);
				visited[vertice] = true;
				for(int i=0;i<arr.length;i++) {
			if(arr[vertice][i]==1 && visited[i]!=true) {
				printHelper(arr,i,visited);
			}
		}
	}
	public static void print(int arr[][]) {
		boolean visited[] = new boolean[arr.length];
				for(int i=0;i<arr.length;i++) {
						if(visited[i]==false)
				printHelper(arr,i,visited);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No of Vertices : ");
		int vertices = sc.nextInt();
		System.out.println("Enter No of edges : ");
		int edges = sc.nextInt();
		int graph[][] = new int[vertices][vertices];
		for(int i=0;i<edges;i++) {
			System.out.println("Enter Starting point");
			int fv = sc.nextInt();
			System.out.println("Enter Ending point");
			int sv = sc.nextInt();
			graph[fv][sv]=1;
			graph[sv][fv]=1;
			
		}
		print(graph);
		
	}

}