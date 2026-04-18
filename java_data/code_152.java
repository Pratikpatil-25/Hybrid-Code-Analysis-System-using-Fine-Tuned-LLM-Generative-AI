package algorithms.sort;


public class QuickSort {

    private QuickSort(){}

    
    public static <T extends Comparable<T>> void quickSort(T[] array){
        quickSort(array, 0, array.length - 1);
    }

    
    public static <T extends Comparable<T>> void quickSort(T[] array, int minIndex, int maxIndex){
        if(minIndex < maxIndex){
            int pivotIndex = partition(array, minIndex, maxIndex);

            quickSort(array, minIndex, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, maxIndex);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int minIndex, int maxIndex){
        int pivotIndex = medianPivot(array, minIndex, maxIndex);

        swap(array, pivotIndex, maxIndex);

        T pivot = array[maxIndex];

        int i = minIndex - 1;
        for(int j = minIndex; j < maxIndex; j++){
            if(array[j].compareTo(pivot) <= 0){
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, maxIndex);

        return i + 1;

    }

    private static <T extends Comparable<T>> int medianPivot(T[] array, int minIndex, int maxIndex) {
        int mid = minIndex + (maxIndex - minIndex) / 2;

        if(array[minIndex].compareTo(array[mid]) > 0){
            swap(array, minIndex, mid);
        }
        if(array[minIndex].compareTo(array[maxIndex]) > 0){
            swap(array, minIndex, maxIndex);
        }
        if(array[mid].compareTo(array[maxIndex]) > 0){
            swap(array, mid, maxIndex);
        }

        return mid;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}