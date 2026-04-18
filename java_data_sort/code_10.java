import java.util.*;



class Main {

    static class Node {

        int data;

        Node prev, next;

        Node(int data) { this.data = data; }

    }



    static class DoublyLinkedList {

        Node head;



        void append(int data) {

            Node newNode = new Node(data);

            if (head == null) { head = newNode; return; }

            Node temp = head;

            while (temp.next != null) temp = temp.next;

            temp.next = newNode;

            newNode.prev = temp;

        }



        void sort() {

            List<Integer> vals = new ArrayList<>();

            for (Node t = head; t != null; t = t.next) vals.add(t.data);

            Collections.sort(vals);

            head = null;

            for (int v : vals) append(v);

        }



        void print() {

            for (Node t = head; t != null; t = t.next) {

                System.out.print(t.data);

                if (t.next != null) System.out.print(" <-> ");

            }

        }

    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        DoublyLinkedList dll = new DoublyLinkedList();

        for (int i = 0; i < n; i++) dll.append(sc.nextInt());

        dll.sort();

        dll.print();

    }

}