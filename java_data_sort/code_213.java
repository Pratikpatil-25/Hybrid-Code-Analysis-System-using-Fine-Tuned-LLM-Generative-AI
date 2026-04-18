package dataStructure.sort;


public class XiEr {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]=(int)(Math.random()*800000);
        }
        long begin = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        System.out.println(arr.length+"条数据希尔排序(交换法)耗时："+(end-begin));

        long begin2 = System.currentTimeMillis();
        shellSort2(arr);
        long end2 = System.currentTimeMillis();
        System.out.println("希尔排序(后移法)耗时："+(end2-begin2));
    }

    
    public static void shellSort(int[] arr){
        int temp =0 ;
                        for (int gap = arr.length/2; gap > 0; gap/=2) {
                        for (int i = gap; i < arr.length; i++) {
                                for(int j=i-gap;j>=0;j-=gap){
                                        if(arr[j]>arr[j+gap]){
                        temp=arr[j+gap];
                        arr[j+gap]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
        }
    }

    
    public static void shellSort2(int[] arr){
        for (int gap = arr.length/2; gap > 0; gap/=2) {
                        for (int i = gap; i < arr.length; i++) {
                                int insertIndex = i;
                int insertVal = arr[i];
                                if(insertVal < arr[insertIndex-gap]){
                    while (insertIndex-gap>=0 && insertVal<arr[insertIndex-gap]){
                        arr[insertIndex] = arr[insertIndex-gap];
                        insertIndex -= gap;
                    }
                    arr[insertIndex] = insertVal;
                }
            }
        }
    }
}