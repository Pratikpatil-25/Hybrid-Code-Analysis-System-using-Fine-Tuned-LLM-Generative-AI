package ch32_FutureParallelProgramming;

public class MergeSort {

	public static void sort(int[] arr) {
		split(arr, 0, arr.length - 1);
	}

	private static void split(int[] arr, int s, int e) {

		if (s >= e)
			return;
		int m = s + (e - s + 1) / 2;

		split(arr, s, m - 1);
		split(arr, m, e);

		merge(arr, s, m, e);
	}
	
	public static void merge (int [] list, int [] firsthalf, int [] secondhalf) {
		
		int i = 0;
		int j = 0;
		
		for (int itr = 0; itr < list.length; itr++) {
			if (i < firsthalf.length && j <secondhalf.length) {

				if (firsthalf[i] <= secondhalf[j]) {
					list[itr] = firsthalf[i++];
				} else {
					list[itr] = secondhalf[j++];
				}
			} else if (i == firsthalf.length) {
				list[itr] = secondhalf[j++];
			} else if (j >= secondhalf.length) {
				list[itr] = firsthalf[i++];
			}
		}
	}

	private static void merge(int[] a, int s, int m, int e) {

		int size = e - s + 1;

		int b[] = new int[size];

		int i = s;
		int j = m;

		for (int itr = 0; itr < size; itr++) {
			if (i < m && j <= e) {

				if (a[i] <= a[j]) {
					b[itr] = a[i++];
				} else {
					b[itr] = a[j++];
				}
			} else if (i == m) {
				b[itr] = a[j++];
			} else if (j > e) {
				b[itr] = a[i++];
			}
		}

		int ii = s;
		for (int x = 0; x < b.length; x++) {
			a[ii++] = b[x];
		}
	}

	public static void main(String args[]) {

		int[] a = { 3, 1, 55, 3, 4, 6, 7, 88, 99, 2,10};

		sort(a);

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + ", ");

	}

}