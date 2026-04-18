import java.util.Scanner;

public class CFG {
    static int np = 0;
        static String  grammer[][] = {{"S", "AB", "BC"}, {"A", "BA", "a"}, {"B", "CC", "b"}, {"C", "AB", "a"}};
    
        static String check(String a){
        String to_ret = "";
        int count = 0;
        for(int i = 0; i < np; i++) {
            for(count = 0; count < grammer[i].length; count++){
                if(grammer[i][count].equals(a)){
                    to_ret += grammer[i][0];
                }
            }
        }
        return to_ret;
    }
    
        static String combinat(String a, String b){
        String to_ret = "", temp = "";
            for(int i = 0; i < a.length(); i++){
                for(int j = 0; j < b.length(); j++){
                    temp = "";
                    temp += a.charAt(i) + "" +  b.charAt(j);
                    to_ret += check(temp);
                }
            }
        return to_ret;
    }
    public static void main(String[] args) {
        String start;
        int n = 0;
        Scanner in = new Scanner(System.in);
                start = "S";
                np = grammer.length;
        String temp;
        System.out.println("Enter the string to be checked >>");
        String str = in.nextLine(), st = "", r = "";
        int count;
        String ans_mat[][] = new String[10][10];
        
                for(int i = 0; i < str.length(); i++){
            r = "";
            st = "" + str.charAt(i);
            for(int j = 0; j < np; j++){
                for(count = 1; count < grammer[j].length; count++){
                    if(grammer[j][count].equals(st)){
                        r += grammer[j][0];
                    }
                }      
            }
            ans_mat[i][i] = r;
        }
        
                for(int i = 1; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                r = "";
                for(int k = j - i; k < j; k++){
                    r += combinat(ans_mat[j - i][k], ans_mat[k + 1][j]);
                }
                ans_mat[j - i][j] = r;
            }
        }
        
                if(ans_mat[0][str.length() - 1].indexOf(start) >= 0){
            accept();
        }
        else{
            reject();
        }
        
    }
    
    public static void accept(){
        System.out.println("String is accepted");
        System.exit(0);
    }
    public static void reject(){
        System.out.println("String is rejected");
        System.exit(0);
    }
    
}