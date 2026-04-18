package Arrays;



public class subarray {

  

    public static void SubArray(int number[]){
        int maxsum=Integer.MIN_VALUE ;
        int sum=0;

        for (int i = 0; i <number.length; i++) {

            for(int j=i;j<number.length;j++){
                sum=0;
                for(int k=i;k<=j;k++){
                    
                    sum+=number[k];
                   
                    if(sum>maxsum){
                        maxsum=sum;
                    }

                }
                System.out.println(sum);
            }
            
        }
        System.out.println("maximum sum of subarray:"+maxsum);
    }


        public static void prefixMethod(int numbers[]){

        int maxsum=Integer.MIN_VALUE;
        int cursum=0;

        int prefix[]=new int[numbers.length];
        prefix[0]=numbers[0];

                for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+numbers[i];
        }

        for(int i=0;i<numbers.length;i++){
            int start=i;

            for(int j=i;j<numbers.length;j++){
                int end=j;

                cursum=start==0?prefix[end]:prefix[end]-prefix[start-1];

                if(maxsum<cursum){
                    maxsum=cursum;
                }

                
            }
        }
        System.out.println(maxsum);
    }
    

public static void kadenes(int numbers[]){

    int maxsum=Integer.MIN_VALUE;
    int cursum=0;

    for(int i=0;i<numbers.length;i++){

        cursum+=numbers[i];
        if(cursum<0){
            cursum=0;
        }
        maxsum=Math.max(maxsum, cursum);
    }

    System.out.println(maxsum);
}

    public static void main(String[] args){

        int number[]={2,4,6,8,10};
        
        int arr[]={1,-2,6,-1,3};
                
        int array[]={-2,-3,4,-1,-2,1,5,-3};
        kadenes(number);
        kadenes(arr);
        kadenes(array);
    }
}