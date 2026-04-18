public class ss
{
    public:
        void quickSort(int arr[], int low, int high)
    {
      if(low<high){
          int NI =partition(arr,low,high);
          quickSort(arr,low ,NI-1);
          quickSort(arr,NI+1,high);
      }
    }

    int partition (int arr[], int low, int high)
    {
    int pivot = arr[high];
       int i= low;
      int j=high-1;
       while(true){
           while(i<=high && arr[i]<=pivot){
               i++;
           }
           while( j>=low && arr[j]>pivot){
               j--;
       }
       if(i>=j){
         break;
       }
       else{
         swap(arr[i],arr[j]);  
       }}
             swap(arr[high],arr[i]);
       return i;
        
    }
};