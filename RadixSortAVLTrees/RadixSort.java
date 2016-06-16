import java.util.Random;

public class RadixSort {

	public Node tree_one_root;
	public Node tree_two_root;
	public static Random random;

	public RadixSort() {
		tree_one_root = new Node();
		tree_two_root = new Node();
	}

	public static void radix_Sort(int[] d, RadixSort[] r, int maxL) {
		int coveredL = 0;
		System.out.println("Iteration "+(coveredL+1)+" starts");
		for (int j = 0; j < d.length; j++) {
			if (d[j] < 0) {
				int totalL = Integer.toString(d[j]).length() - 2;
				if (coveredL <= totalL) {
					char s = Integer.toString(d[j]).charAt(
							totalL - coveredL + 1);
					r[Integer.parseInt(s + "")].tree_one_root.insert_into_tree(d[j], 1);
				} else {
					r[0].tree_one_root.insert_into_tree(d[j], 1);
				}
			}else{
				int totalL  = Integer.toString(d[j]).length()-1;
				if(coveredL <= totalL){
					char s = Integer.toString(d[j]).charAt(totalL - coveredL);
					r[Integer.parseInt(s+"")].tree_one_root.insert_into_tree(d[j], 1);
				}else{
					r[0].tree_one_root.insert_into_tree(d[j], 1);
				}
			}
		}//end of for loop
		printData(r);
		System.out.println("Iteration "+(coveredL+1)+" done");
		coveredL++;
		while(coveredL <= maxL){
			System.out.println("Iteration "+(coveredL+1)+" starts");
			for(int i=0; i<r.length; i++){
				Node temp = r[i].tree_one_root.get_data();
				while(temp != null){
					int data = temp.key;
					if(data < 0){
						int totalL = Integer.toString(data).length()-2;
						if(coveredL <= totalL){
							char s = Integer.toString(data).charAt(totalL - coveredL + 1);
							r[Integer.parseInt(s+"")].tree_two_root.insert_into_tree(temp.key, temp.occurance);
						}else{
							r[0].tree_two_root.insert_into_tree(temp.key, temp.occurance);
						}
					}else{
						int totalL = Integer.toString(data).length()-1;
						if(coveredL <= totalL){
							char s = Integer.toString(data).charAt(totalL - coveredL);
							r[Integer.parseInt(s+"")].tree_two_root.insert_into_tree(temp.key, temp.occurance);
						}else{
							r[0].tree_two_root.insert_into_tree(temp.key, temp.occurance);
						}
					}
					temp = r[i].tree_one_root.get_data();
				}//while loop ends
			}
			for(int i=0; i<r.length; i++){
				r[i].tree_one_root.key = r[i].tree_two_root.key;
				r[i].tree_one_root.occurance = r[i].tree_two_root.occurance;
				r[i].tree_one_root.height = r[i].tree_two_root.height;
				r[i].tree_one_root.left = r[i].tree_two_root.left;
				r[i].tree_one_root.right = r[i].tree_two_root.right;
				r[i].tree_two_root = new Node();
			}
			printData(r);
			System.out.println("Iteration "+(coveredL+1)+" done");
			coveredL++;
		}
	}
	
	public static void printRecursively(Node n){
		if(n.right == null){
			if(n.occurance > 0){
				for(int i=0; i<n.occurance; i++){
					System.out.print(n.key+" ");
				}
			}else{
				System.out.print(n.key+" ");
			}
			return;
		}
		printRecursively(n.left);
		printRecursively(n.right);
	}
	
	public static void printData(RadixSort[] t){
		
		for(int i=0; i<t.length; i++){
			System.out.println("Bucket "+i);
			printRecursively(t[i].tree_one_root);
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		random = new Random();
		RadixSort table[] = new RadixSort[10];
		for (int i = 0; i < 10; i++) {
			table[i] = new RadixSort();
		}
		int data[] = new int[20];
		System.out.println("Creating 20 random numbers from -20 to 20");
		for (int i = 0; i < 20; i++) {
			data[i] = random.nextInt(41) - 20;
			System.out.print(data[i] + " ");
		}
		System.out.println();
		int maxLength = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] < 0) {
				if (maxLength < (Integer.toString(data[i]).length() - 1)) {
					maxLength = Integer.toString(data[i]).length() - 1;
				}
			} else {
				if (maxLength < (Integer.toString(data[i]).length())) {
					maxLength = Integer.toString(data[i]).length();

				}
			}
		}

		radix_Sort(data, table, maxLength);
		//printData(table);

	}

}
