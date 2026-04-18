package lec11;







public class Selection__Sort {



	public static void main(String[] args) {

		int[] arr= {2,13,-4,5,7};

		Sort(arr);

		for(int i = 0; i<arr.length;i++) {

			System.out.print(arr[i] + " ");

		}



	}

	public static void Sort(int[] arr) {

		for(int i = 1; i<arr.length;i++) {

			int picked = arr[i];

			int j = i- 1;

			while(j>=0 && arr[j]>picked) {

				arr[j+1] = arr[i];

				j--;

				

			}

			arr[j+1]=picked;

		}

	}

	}