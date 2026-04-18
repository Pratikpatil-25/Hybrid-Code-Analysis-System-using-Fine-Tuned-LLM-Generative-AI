package linkedlist;


public class ReverseIteratively {
    public static void main(String[] args) {
                SingleLinkedList list = new SingleLinkedList(10);
        Node node = list.getHead();
        while (null != node) {
            System.out.println(node.getData());
            node = node.getNext();
        }
        System.out.println("-----");
                node = traverse(list.getHead());
        while (null != node) {
            System.out.println(node.getData());
            node = node.getNext();
        }
        System.out.println("-----");
                
    }

    
    public static Node traverse(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
                Node pre = head;
                Node cur = head.getNext();
        while (null != cur.getNext()) {
                        Node next = cur.getNext();
                        cur.setNext(pre);
                        pre = cur;
                        cur = next;
        }
                cur.setNext(pre);
                head.setNext(null);
        return cur;
    }

    
    public static Node recursion(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node revHead = recursion(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return revHead;
    }

    
    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    
    public static class SingleLinkedList {
        private Node head;

        public SingleLinkedList(int size) {
            Node head = new Node(0);
            Node cur = head;
            for (int i = 1; i < size; i++) {
                Node tmp = new Node(i);
                cur.setNext(tmp);
                cur = tmp;
            }
            this.head = head;
        }

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }
    }
}