import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
	
	static int whiteCount,blueCount=0;
	static int[][] arr;
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
	
		
		arr = new int[N][N];
		
				

				for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
								
			}
		}
		

	
						
						recursion(N,arr,0,0);
			System.out.println(whiteCount+"\n"+blueCount);
		
		

	}
	
	public static void recursion(int N,int[][] arr, int rowIndex,int colIndex) {
		
						if(N==1){
			
			if(arr[rowIndex][colIndex]==0) {
				whiteCount++;
			}
			
			else {
				blueCount++;
			}
			
			return;
		}
		
				
			
			int test = testOneColor(N, rowIndex,colIndex);
			
						if(test==0) {
								whiteCount++;
				return;
		
			}
					
						else if(test==1) {
								blueCount++;
				return;
			}
			
						else {
				
								
				recursion(N/2,arr,rowIndex,colIndex);
				recursion(N/2,arr,rowIndex,colIndex+N/2);
				recursion(N/2,arr,rowIndex+N/2,colIndex);
				recursion(N/2,arr,rowIndex+N/2,colIndex+N/2);
			}
			

		 
		
		
	}
	
		public static int testOneColor(int N,  int rowIndex, int colIndex){
		
		boolean allWhite=true;
		boolean allBlue=true;
				
				for(int i=rowIndex;i<rowIndex+N;i++) {
			
			for(int j=colIndex;j<colIndex+N;j++) {
				
					if(allWhite && arr[i][j]!=0) {
						allWhite=false;
					}
					
					if(allBlue && arr[i][j]!=1) {
						allBlue=false;
					}
				
			}
			
		}
						if(allWhite) {
			return 0;
		}
		
		else if(allBlue) {
			return 1;
		}
		
		else {
			
			return -1;
		}
	}

	
	
}