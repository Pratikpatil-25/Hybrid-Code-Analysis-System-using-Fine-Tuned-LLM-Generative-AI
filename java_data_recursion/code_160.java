package dsa.recursion.assignment2.patterns;



public class Pattern7 {
	
	private static void printSpace(int row) {
		
				if(row == 0) {
			return ;
		}
		
				System.out.print(" ");
		
				printSpace(row-1);
		
	}
	
	private static void printStar(int star) {
		
				if(star == 0)
			return;
		
				System.out.print("* ");
		
		
				printStar(star-1);
	
	}
	
	private static void printLine(int row, int star) {
				if(row == 0)
			return ;
		
				printSpace(row -1);
		printStar(star);
		System.out.println();
		
		
				printLine(row-1, star+1);
	}

	public static void main(String[] args) {
				
				
		int row = 5;
		int star = 1;
		
				printLine(row, star);
	

	}
}