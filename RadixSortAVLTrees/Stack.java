
public class Stack {
	
	private int length;
	private Node data;
	private Stack next;
	
	
	public Stack(){
		this.length = 0;
		this.data = null;
		this.next = null;
	}
	
	public Stack get_next(){
		return next;
	}
	
	public void set_next(Stack s){
		next = s;
	}
	
	public void set_data(Node n){
		data = n;
	}
	
	public Node get_data(){
		return data;
	}
	
	public void push(Node n){
		Stack s = this.get_next();
		Stack d = new Stack();
		d.set_data(n);
		d.set_next(s);
		this.set_next(d);
	}
	
	public Node pop(){
		Node n = this.get_next().get_data();
		Stack next = this.get_next().get_next();
		this.set_next(next);
		return n;
	}
	
	public boolean is_empty(){
		if(this.get_next() == null){
			return true;
		}else{
			return false;
		}
	}
	
}
