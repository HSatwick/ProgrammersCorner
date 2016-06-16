
public class List {
	
	private Node dummy;
	
	public List(){
		dummy = new Node(Integer.MIN_VALUE);
	}
	
	public Node get_dummy(){
		return dummy;
	}
	
	//insert in ascending order
	public void insert_data(int d){
		Node temp_node = this.get_dummy();
		
		if(temp_node.get_next() == null){
			Node new_node = new Node(d);
			temp_node.set_next(new_node);
		}else{
			Node prev_node = temp_node;
			Node next_node = temp_node.get_next();
			while(next_node != null){
				if(next_node.get_data() <= d){
					prev_node = next_node;
					next_node = next_node.get_next();
				}else{
					break;
				}
			}
			Node new_node = new Node(d);
			prev_node.set_next(new_node);
			new_node.set_next(next_node);
		}
	}
	
	//print a given list
	public void print_list(){
		Node print_node = get_dummy().get_next();
		while(print_node != null){
			System.out.print(print_node.get_data()+" ");
			print_node = print_node.get_next();
		}
		System.out.println();
	}
	
	//rearranging the nodes
	public Node delete_node(int d){
		Node temp_del = get_dummy();
		if(temp_del.get_next() == null){
			return null;
		}else{
			Node prev_node = temp_del;
			Node next_node = temp_del.get_next();
			while(next_node != null){
				if(next_node.get_data() == d){
					temp_del = next_node;
					prev_node.set_next(next_node.get_next());
					temp_del.set_next(null);
					return prev_node.get_next();
				}else if(next_node.get_data() < d){
					prev_node = next_node;
					next_node = next_node.get_next();
				}else{
					break;
				}
			}
		}
		return null;
	}

}
