package sorting;

import java.util.Arrays;

public class HeapSort
{
    void sort(int[] arr){
        int n = arr.length;
        int lastNonLeaf = (n/2)-1;
        
        for(int i = lastNonLeaf; i>=0; i--){
            heapify(arr,n,i);
        }
        
        for(int i=n-1; i>=0 ; i--){
            int temp =arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            
            heapify(arr,i,0);
        }
    }
    
    
    void heapify(int[] arr,int n,int i){
        int largest = i;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        
        
                if(leftChild<n && arr[leftChild] > arr[largest]){
            largest = leftChild;
        }
        if(rightChild<n && arr[rightChild] > arr[largest]){
            largest = rightChild;
        }
        
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
                        heapify(arr,n,largest);
        }
    }
    
    public static void main(String[] args)
    {
        int[] arr = new int[]{8,3,4,1,6,7,2};
        HeapSort heapSort = new HeapSort();
        System.out.println(Arrays.toString(arr));
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}