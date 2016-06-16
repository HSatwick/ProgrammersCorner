package reversingLinkedList;

public class Node {
	
	private int text;
	private Node next;
	
	public Node(int n){
		text = n;
		next = null;
	}
	
	public Node getNext(){
		return this.next;
	}
	
	public void setNext(Node n){
		this.next = n;
	}
	
	public int getID(){
		return this.text;
	}

}
