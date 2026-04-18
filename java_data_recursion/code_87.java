class First{
    static void show(int i){
                        if(i == 5){
            return ;         }
        System.out.println(i);         show(i+1);         System.out.println(i); 
    }
    public static void main(String[] args) {
        show(1);
    }
}