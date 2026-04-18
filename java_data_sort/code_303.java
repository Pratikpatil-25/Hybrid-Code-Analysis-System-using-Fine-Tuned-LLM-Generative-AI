package door;

import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {
		int[] ages = {25, 26, 3, 2, 6};
		show(ages);
		
		Arrays.sort(ages);
		System.out.println("===");
		show(ages);

	}

	private static void show(int[] ages) {
		for(int i = 0; i < ages.length; i++) {
			System.out.print(ages[i] + " ");
		}
	}

}