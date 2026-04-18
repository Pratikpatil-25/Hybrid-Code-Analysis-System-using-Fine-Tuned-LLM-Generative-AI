import java.util.*;
import java.io.*;

public class Main {

       public static void main(String [] args){

       Scanner scan = new Scanner(System.in);
       int test = scan.nextInt();
       
       while(test>0){
           
           int n = scan.nextInt();
           int alice = 0;
           int bob = 0;
           
           int [] candies = new int[n];           
           for(int i=0 ; i<n ;  i++){
               candies[i]=scan.nextInt();
           }
           
           ArrayList<Integer> list = new ArrayList<>();
           recursion(0,candies,alice,bob,list);
           
           if(list.size()>0) System.out.println("Yes");
           else System.out.println("No");
           
           test--;
       }
       
}

        public static void recursion(int start, int [] array, int alice , int bob , List<Integer> list){
            
            if(alice==bob && start==array.length){
                list.add(0);
                return;
            }
            
            if(start==array.length) return;

            if(list.size()==0){
                        alice+=array[start];
            recursion(start+1,array,alice,bob,list);
            alice -= array[start];
                        }

            if(list.size()==0){
            bob+=array[start];
                        recursion(start+1,array,alice,bob,list);
            bob -= array[start];
                        }

            
            return;
        }


}