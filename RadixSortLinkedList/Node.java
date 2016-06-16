
public class Node {
	
	private int data;
	private Node next;
	
	public Node(int d){
		data = d;
		next = null;
	}
	
	public Node get_next(){
		return this.next;
	}
	
	public void set_next(Node d){
		this.next = d;
	}
	
	public int get_data(){
		return this.data;
	}

}
