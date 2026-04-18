import java.util.*;

public class t {
    private int V;
    private LinkedList<Integer>[] adj; 
    static final int top= 400005;
    static final long INF = (long) 1e18;
    static final int MOD = 1000000007;
    public t(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
          functi1(sc);
     
  }
    static void functi1(Scanner scanner) {
        int t = scanner.nextInt();
        int[] n = new int[t];
        int[] k = new int[t];
 
        for (int i = 0; i < t; i++) {
            n[i] = scanner.nextInt();
        }
 
        for (int i = 0; i < t; i++) {
            k[i] = scanner.nextInt();         }
 
        int maxk = 0;
        for (int i = 0; i < t; i++) {
            maxk = Math.max(maxk, k[i]);         }
 
        long[] pow2 = new long[maxk + 1];
        pow2[0] = 1;         for (int i = 1; i <= maxk; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;         }
 
        for (int i = 0; i < t; i++) {
            System.out.println(pow2[k[i]]);         }
        }
  public static int gcd(int a, int b){
        if (b == 0)  return a;
        else return gcd(b, Math.abs(a - b));
    }
   public  static int lcm(int x, int y)  {  
return (x / gcd(x, y)) * y;  
  }
  public static void sort(int a[]){
    Arrays.sort(a);
  }  
  public static int completebinarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (array[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}
public static HashMap hashmap(int a[]){
    HashMap<Integer,Integer> h1 = new HashMap<Integer,Integer>();
   for(int i :a){
     h1.put(i,h1.getOrDefault(i,0)+1);
   }
   return h1;
}
void addEdge(int v, int w) {
    adj[v].add(w); }

private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
    System.out.print(v + " ");

        for (int n : adj[v]) {
        if (!visited[n])
            DFSUtil(n, visited);
    }
}

public void DFS(int startVertex) {
    boolean[] visited = new boolean[V];
    DFSUtil(startVertex, visited);
}

public void BFS(int startVertex) {
    boolean[] visited = new boolean[V];
    LinkedList<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
    queue.add(startVertex);

    while (queue.size() != 0) {
                startVertex = queue.poll();
        System.out.print(startVertex + " ");
        for (int n : adj[startVertex]) {
            if (!visited[n]) {
                visited[n] = true;
                queue.add(n);
            }
        }
    }
}
public static int binarySearch(int[] arr, int start, int end, int target) {
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            start = mid + 1;
        }
        else {
            end = mid - 1;
        }
    }
    return -1;
}
}