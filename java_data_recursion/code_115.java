public class Recursion {
    public long getFact(int num){
        if(num >= 1){
            return num * getFact(num-1);
        }
        else return 1;
    }

    public int pattern(int num){
        if(num <=0) return 0;
        pattern(num-1);
        for(int i = 0; i < num; i++){
            System.out.print("*");
        }
        System.out.println();
        return 0;
    }

    public int getSumt(int num){
        if(num >=1)
            return num + getSumt(num-1);
        else return 0;
    }

    
}