package reversingLinkedList;

public class LinkedList {

	public Node start;

	public LinkedList() {
		start = new Node(0);
	}
	
	public static LinkedList create_list(){
		return new LinkedList();
	}

	public static void insert(LinkedList n, int num) {
		Node next = n.start;

		while(next.getNext() != null){
			next = next.getNext();
		}
		Node new_node = new Node(num);
		next.setNext(new_node);
	}
	
	public static void printList(LinkedList n){
		Node node = n.start.getNext();
		while(node != null){
			System.out.print(node.getID()+" ");
			node = node.getNext();
		}
		System.out.println();
	}
	
	public static Node nonRecursiveReverse(LinkedList n){
		Node a = n.start.getNext();
		if(a == null){
			return n.start;
		}else if(a.getNext() == null){
			return n.start;
		}else if(a.getNext().getNext() == null){
			Node b = a.getNext();
			n.start.setNext(b);
			b.setNext(a);
			a.setNext(null);
			return n.start;
		}else{
			Node b = a.getNext();
			Node c = b.getNext();
			a.setNext(null);
			while(b != null){
				b.setNext(a);
				a = b;
				b = c;
				if(c != null){
					c = c.getNext();
				}
			}
			n.start.setNext(a);
		}
		return n.start;
	}
	
	public static Node listReversal(Node p, Node q){
		
		if(q == null){
			return p;
		}
		
		Node a = q;
		Node b = a.getNext();
		q.setNext(p);
		return listReversal(a,b);
		
	}
	
	public static Node recursiveReverse(LinkedList n){
		Node newNode1 = n.start.getNext();
		if(newNode1 == null){
			return n.start;
		}else{
			Node newNode2 = newNode1.getNext();
			if(newNode2 == null){
				return n.start;
			}else{
				newNode1.setNext(null);
				Node newNode = listReversal(newNode1, newNode2);
				n.start.setNext(newNode);
			}
		}
		return n.start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList n = create_list();
		
		for(int i=1; i<=1000; i++){
			insert(n,i);
		}
		System.out.println("Initial List: ");
		printList(n);
		
		n.start = nonRecursiveReverse(n);
		System.out.println("Reversed List (non-recursive): ");
		printList(n);
		
		n.start = recursiveReverse(n);
		System.out.println("Reversed List (recursive)");
		printList(n);
	}

}
