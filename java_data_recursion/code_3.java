public class Recursion{
    public static int first =-1;
    public static int last =-2;
    public static void findOccurance(String str,int idx,char element){
        if(idx ==str.length()){
            System.out.println("First Occurance of " + element + " is at index: " + first);
            System.out.println("Last Occurance of " + element + " is at index: " + last);
            return;
        }   
        char currChar=str.charAt(idx);
        if(currChar ==element){
            if(first==-1){
                first=idx;
                
            }else{
                last=idx;
            }
        }
        findOccurance(str,idx+1,element);


    }
    public static void main(String args[]){
        String str =="abaacdaefaah";
        findOccurance(str,0,'a');
    }
}