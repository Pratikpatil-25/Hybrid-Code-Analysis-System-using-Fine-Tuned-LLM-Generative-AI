public class SortGrid {



	

	public static void sort(Grid g) {

		quickSort(g, 0, g.size() * g.size() - 1);

	}



	

	private static void quickSort(Grid a, int start, int end) {

		if (start >= end)

			return;

		int left = start;

		int right = end;

		int pivot = getVal(a, end);

		while (left < right) {



			while (getVal(a, left) <= pivot && left < right) {

				left++;

			}



			while (getVal(a, right) >= pivot && right > left) {

				right--;

			}

			
			swap(a, left, right);

		}

		swap(a, left, end);



		quickSort(a, start, left - 1);

		quickSort(a, left + 1, end);



	}



	

	private static int getVal(Grid g, int i) {

		int width = g.size();

		int r = i / width;

		int c = i % width;

		return g.getIntVal(r, c);

	}



	

	private static int[] getIndices(Grid g, int i) {

		;

		int width = g.size();

		int r = i / width;

		int c = i % g.size();

		return new int[] { r, c };

	}



	

	private static int getLength(Grid g) {

		return g.size() * g.size();

	}



	

	private static void swap(Grid g, int x, int y) {

		int[] inds = getIndices(g, x);

		String temp = g.getVal(inds[0], inds[1]);

		int[] inds2 = getIndices(g, y);

		g.setVal(inds[0], inds[1], g.getVal(inds2[0], inds2[1]));

		g.setVal(inds2[0], inds2[1], temp);

	}



}