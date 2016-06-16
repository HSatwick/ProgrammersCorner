
public class Node {

	
	public int key;
	public int height;
	public int occurance;
	public Node left;
	public Node right;
	
	public Node(){
		key = Integer.MIN_VALUE;
		height = 0;
		occurance = 1;
		left = null;
		right = null;
	}
	
	public Node(int k){
		key = k;
		occurance = 0;
		left = null;
		right = null;
		height = 0;
	}
	
	public Node(int k,int o){
		key = k;
		height = 0;
		occurance = o;
		left = new Node(k);
		right = null;
	}
	
	public void left_rotation(Node n){
		Node temp;
		int temp_key;
		int temp_occur;
		temp = n.left;
		temp_key = n.key;
		temp_occur = n.occurance;
		n.left = n.right;
		n.key = n.right.key;
		n.occurance = n.right.occurance;
		n.right = n.left.right;
		n.left.right = n.left.left;
		n.left.left = temp;
		n.left.key = temp_key;
		n.left.occurance = temp_occur;
	}
	
	public void right_rotation(Node n){
		Node temp;
		int temp_key;
		int temp_occur;
		temp = n.right;
		temp_key = n.key;
		temp_occur = n.occurance;
		n.right = n.left;
		n.key = n.left.key;
		n.occurance = n.left.occurance;
		n.left = n.right.left;
		n.right.left = n.right.right;
		n.right.right = temp;
		n.right.key = temp_key;
		n.right.occurance = temp_occur;
	}
	
	
	public void insert_into_tree(int k, int occur){
		int finished;
		
		if(this.left == null){
			Node newNode = new Node(k, occur);
			this.key = newNode.key;
			this.occurance = newNode.occurance;
			this.height = newNode.height;
			this.left = newNode.left;
			this.right = newNode.right;
		}else{
			Stack rebal = new Stack();
			Node temp = this;
			while(temp.right != null){
				rebal.push(temp);
				if(temp.key > k){
					temp = temp.left;
				}else{
					temp = temp.right;
				}
			}
			if(temp.key == k){
				temp.occurance++;
			}else{
				Node new_leaf = new Node(k, occur);
				Node old_leaf = new Node(temp.key, temp.occurance);
				if(temp.key < k){
					 temp.left = old_leaf;
					 temp.right = new_leaf;
					 temp.key = k;
				}else{
					temp.left = new_leaf;
					temp.right = old_leaf;
				}
				temp.height = 1;
				
				//re balancing the tree
				finished = 0;
				while(finished != 1 && !rebal.is_empty()){
					int tmp_height, old_height;
					temp = rebal.pop();
					old_height = temp.height;
					if(temp.left.height - temp.right.height == 2){
						if(temp.left.left.height - temp.right.height == 1){
							right_rotation(temp);
							temp.right.height = temp.right.left.height + 1;
							temp.height = temp.right.height + 1;
						}else{
							left_rotation(temp.left);
							right_rotation(temp);
							tmp_height = temp.left.left.height;
							temp.left.height = tmp_height + 1;
							temp.right.height = tmp_height + 1;
							temp.height = tmp_height + 2;
						}
					}
					else if(temp.left.height - temp.right.height == -2){
						if(temp.right.right.height - temp.left.height == 1){
							left_rotation(temp);
							temp.left.height = temp.left.right.height + 1;
							temp.height = temp.left.height + 1;
						}else{
							right_rotation(temp.right);
							left_rotation(temp);
							tmp_height = temp.right.right.height;
							temp.left.height = tmp_height + 1;
							temp.right.height = tmp_height + 1;
							temp.height = tmp_height + 2;
						}
					}
					else{
						if(temp.left.height > temp.right.height){
							temp.height = temp.left.height + 1;
						}else{
							temp.height = temp.right.height + 1;
						}
					}
					if(temp.height == old_height){
						finished = 1;
					}
				}//while loop ends
			}//inner else
		}//outer else
	}
	
	//get the left most node and delete it.
	public Node get_data(){
		Node tmp_node, other_node = null, upper_node = null, delet_obj = null;
		int finished;
		if(this.left == null){
			return null;
		}
		else if(this.right == null){
			Node return_node = this;
			this.left = null;
			return return_node;
		}else{
			tmp_node = this;
			Stack rebal = new Stack();
			while(tmp_node.right != null){
				rebal.push(tmp_node);
				upper_node = tmp_node;
				other_node = upper_node.right;
				tmp_node = upper_node.left;
			}
			upper_node.key = other_node.key;
			upper_node.left = other_node.left;
			upper_node.right  = other_node.right;
			upper_node.occurance = other_node.occurance;
			upper_node.height = other_node.height;
			delet_obj = tmp_node;
			
			finished = 0;
			rebal.pop();
			while(!rebal.is_empty() && finished != 1){
				int tmp_height, old_height;
				tmp_node = rebal.pop();
				old_height = tmp_node.height;
				if(tmp_node.left.height - tmp_node.right.height == 2){
					if(tmp_node.left.left.height - tmp_node.right.height == 1){
						right_rotation(tmp_node);
						tmp_node.right.height = tmp_node.right.left.height + 1;
						tmp_node.height = tmp_node.right.height + 1;
					}else{
						left_rotation(tmp_node.left);
						right_rotation(tmp_node);
						tmp_height = tmp_node.left.left.height;
						tmp_node.left.height = tmp_height + 1;
						tmp_node.right.height = tmp_height + 1;
						tmp_node.height = tmp_height + 2;
					}
				}
				else if(tmp_node.left.height - tmp_node.right.height == -2){
					if(tmp_node.right.right.height - tmp_node.left.height == 1){
						left_rotation(tmp_node);
						tmp_node.left.height = tmp_node.left.right.height + 1;
						tmp_node.height = tmp_node.left.height + 1;
					}else{
						right_rotation(tmp_node.right);
						left_rotation(tmp_node);
						tmp_height = tmp_node.right.right.height;
						tmp_node.left.height = tmp_height + 1;
						tmp_node.right.height = tmp_height + 1;
						tmp_node.height = tmp_height + 2;
					}
				}
				else{
					if(tmp_node.left.height > tmp_node.right.height){
						tmp_node.height = tmp_node.left.height + 1;
					}else{
						tmp_node.height = tmp_node.right.height + 1;
					}
				}
				if(tmp_node.height == old_height){
					finished = 1;
				}
			}//while loop
		}//else
		return delet_obj;
	}
}
