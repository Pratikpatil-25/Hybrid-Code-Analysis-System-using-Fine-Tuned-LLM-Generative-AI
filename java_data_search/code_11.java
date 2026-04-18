public class ll {
    Node head;
    private int size;

    ll(){
        size=0;
    }

    class Node{
        
        int data;
        Node next;

         Node(int data){
            this.data = data;
            this.next=null;
            size++;
         }
    }
        public void addFirst(int data){
        Node newnode = new Node(data);
        newnode.next= head;
        head= newnode;
    }
        public void addLast(int data){
        Node newnode = new Node(data);
        if(head==null){
            newnode.next=head;
            head=newnode;
        }

        Node lastnode=head;
        while(lastnode.next!=null){
            lastnode=lastnode.next;
        }
        lastnode.next=newnode;
    }
        public void deleteFirst(){
        if(head.next==null){
            return;
        }
        head=head.next;
        size--;
    }
    
    public void deleteLast(){
        if(head==null)return;

        size--;

        if(head.next==null){
            head=null;
            return;
        }

        Node secondlast = head;
        Node last = head.next;

        while(last.next!=null){
            secondlast= secondlast.next;
            last = last.next;
        }
        secondlast.next=null;
    }
    
    public int getSize(){
        return size;
    }

    public void printNode(){
        Node currNode=head;
        
        while(currNode!=null){
            System.out.print(currNode.data+"->");
            currNode=currNode.next;
        }

        
            System.out.print("NULL");
        
    }
    
    public boolean search(int key){
        Node currNode = head;
        while(currNode!=null){
            if(currNode.data==key)return true;
            currNode=currNode.next;
        }
        return false;
    }

    public static void main(String args[]){
        ll list = new ll();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.addLast(5);
        list.addLast(4);

                


        list.printNode();
        System.out.println("\n"+list.getSize());
        System.out.println(list.search(4));
    }
}