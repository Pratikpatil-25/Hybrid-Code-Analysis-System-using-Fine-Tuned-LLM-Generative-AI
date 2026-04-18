import java.util.*;

public class MyStack<E> {

    private LinkedList<E> stack;

    public MyStack() {

        stack = new LinkedList<>();

    }

    public void push(E e) {

        stack.add(e);

    }

    public E peek(){

        return stack.getLast();

    }



    public E pop(){

        return stack.removeLast();

    }



    public int size(){

        return stack.size();

    }

    public boolean isEmpty(){

        return stack.isEmpty();

    }



    public int search(E e){

        if(!stack.contains(e))

            return -1;

        else

         return stack.size()-stack.lastIndexOf(e);

    }

}