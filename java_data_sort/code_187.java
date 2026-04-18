package homeWorks.homeWork32.homeWork32_1;

import java.util.Stack;

public class MainApp {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        fillRandomStack(stack,10,100);
        System.out.println(stack);
        stack=sort(stack);
        System.out.println(stack);
    }
    public static void fillRandomStack(Stack<Integer> stack,int size,int maxRand){
        for(int i=0;i<size;i++){
            stack.push((int)(Math.random()*maxRand+1));
        }
    }
    public static Stack<Integer> sort(Stack<Integer> stack){
        Stack<Integer> stack2=new Stack<>();
        while (!stack.isEmpty()){
            int temp=stack.pop();
            while (!stack2.isEmpty() && stack2.peek()<temp){
                stack.push(stack2.pop());
            }
            stack2.push(temp);
        }
        return stack2;
    }


}