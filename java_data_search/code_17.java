import java.util.Scanner;
public class LL {
    Node head;
    private int size;

    LL() {
        size = 0;
    }

    public class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;

                        size++;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node lastNode = head;
        while(lastNode.next != null){
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;
    }


    public void printList(){
        Node currNode = head;


        while(currNode != null){
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }

        System.out.print("null");
    }

    public void removeFirst() {
        if(head == null) {
            System.out.println("Empty List, nothing to delete.");
            return; 
        }

        head = this.head.next;
        size--;
    }


    public void removeLast() {

        
        if(head == null){
            System.out.println("Empty List, nothing to delete.");
            return;
        }

        size--;
        if(head.next == null){
            head = null;
            return;
        }

        Node currNode = head;
        Node lastNode = head.next;

        while(lastNode.next != null){
            currNode = currNode.next;
            lastNode = lastNode.next;
        }

        currNode.next = null;
    }

    public int getSize() {
        return size;
    }


    public int search(int data) {
        if(head == null){
            return -1;
        }

        int index=0;
        Node currNode = head;
        while(currNode != null){
            if(currNode.data == data){
                return index;
            }

            ++index;
            currNode = currNode.next;
        }

        return -1;
    }

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        LL list = new LL();

        int[] arr = {1, 5, 7, 3 , 8, 2, 3};
        for(int i: arr){
            list.addLast(i);
        }

        list.removeLast();
        list.printList();

        System.out.println("Enter the element you want to search from the Linked List: ");
        int data = sc.nextInt();

        System.out.println("The element is at the index position: " + list.search(data));
        sc.close();

    }
}