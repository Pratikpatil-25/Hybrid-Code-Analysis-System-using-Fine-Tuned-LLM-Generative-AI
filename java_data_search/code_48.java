import java.time.LocalDate;


public class PQ {
	PQNode head;
	
	public PQ() {
		head=null;
	}
	public boolean isEmpty() {
		return head==null;
	}
	public void enqueue(Event e, LocalDate d) {
	    PQNode a = new PQNode(e, d);
	    PQNode current = head;
	    PQNode prev = null;

	    while (current != null && current.priority.compareTo(d) < 0) {
	        prev = current;
	        current = current.next;
	    }

	    if (prev == null) {
	        a.next = head;
	        head = a;
	    } else {
	        a.next = current;
	        prev.next = a;
	    }
	}

	public Event dequeue() {
	    if (isEmpty()) {
	        return null; 
	    }

	    Event t = head.data;
	    head = head.next;
	    return t;
	}
	public Event evAtPos(int i) {
		PQNode current=head;
		int count=1;
		while(current!=null && count<i) {
			count++;
			current=current.next;
		}
		return current.data;
	}
	public void display() {
		PQNode current=head;
		while(current.next!=null) {
			System.out.print(current.data.name+" - ");
			current=current.next;
		}
		System.out.print(current.data.name);
		
	}
	public int size() {
		int count=0;
		PQNode current=head;
		
		while(current!=null) {
			count++;
			current=current.next;
		}
		return count;
	}
	public boolean search(LocalDate d) {

		PQNode current=head;
		
		boolean flag=false;
		while(current!=null) {
			if (current.priority.compareTo(d)==0) {
				flag=true;
			}

			current=current.next;
		}
		return flag;
		
	}
}