import java.util.Random;


public class RadixSort {
	
	private List list;
	public static Random random;
	
	public RadixSort(){
		list = new List();
	}
	
	public List get_list(){
		return this.list;
	}
	
	public static void radix_Sort(int []d, RadixSort []r, int maxL){
		
		int coveredL = 0;
		for(int j=0; j<d.length; j++){
			if(d[j] < 0){
				int totalL  = Integer.toString(d[j]).length()-2;
				if(coveredL <= totalL){
					char s = Integer.toString(d[j]).charAt(totalL - coveredL + 1);
					r[Integer.parseInt(s+"")].get_list().insert_data(d[j]);
				}else{
					r[0].get_list().insert_data(d[j]);
				}
			}else{
				int totalL  = Integer.toString(d[j]).length()-1;
				if(coveredL <= totalL){
					char s = Integer.toString(d[j]).charAt(totalL - coveredL);
					r[Integer.parseInt(s+"")].get_list().insert_data(d[j]);
				}else{
					r[0].get_list().insert_data(d[j]);
				}
			}
		}//end of for loop
		for(int p=0; p<r.length; p++){
			System.out.print("Printing List "+p+": ");
			r[p].get_list().print_list();
		}
		System.out.println();
		coveredL++;
		while(coveredL <= maxL){
			for(int i=0; i<r.length; i++){
				Node temp = r[i].get_list().get_dummy().get_next();
				while(temp != null){
					int data = temp.get_data();
					if(data < 0){
						int totalL = Integer.toString(data).length()-2;
						if(coveredL <= totalL){
							char s = Integer.toString(data).charAt(totalL - coveredL + 1);
							if(i != Integer.parseInt(s+"")){
								temp = r[i].get_list().delete_node(data);
								r[Integer.parseInt(s+"")].get_list().insert_data(data);
							}else{
								temp = temp.get_next();
							}
						}else{
							if(i != 0){
								temp = r[i].get_list().delete_node(data);
								r[0].get_list().insert_data(data);
							}else{
								temp = temp.get_next();
							}
						}
					}else{
						int totalL = Integer.toString(data).length()-1;
						if(coveredL <= totalL){
							char s = Integer.toString(data).charAt(totalL - coveredL);
							if(i != Integer.parseInt(s+"")){
								temp = r[i].get_list().delete_node(data);
								r[Integer.parseInt(s+"")].get_list().insert_data(data);
							}else{
								temp = temp.get_next();
							}
						}else{
							if(i != 0){
								temp = r[i].get_list().delete_node(data);
								r[0].get_list().insert_data(data);
							}else{
								temp = temp.get_next();
							}
						}
					}
				}//while interior
			}//for loop
			for(int p=0; p<r.length; p++){
				System.out.print("Printing List "+p+": ");
				r[p].get_list().print_list();
			}
			System.out.println();
			coveredL++;
		}//while loop
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		random = new Random();
		RadixSort table[] = new RadixSort[10];
		for(int i=0; i<10; i++){
			table[i] = new RadixSort();
		}
		int data[] = new int[20];
		System.out.println("Creating 20 random numbers from -20 to 20");
		for(int i=0; i<20; i++){
			data[i] = random.nextInt(41) - 20;
			System.out.print(data[i]+" ");
		}
		System.out.println();
		int maxLength = 0;
		for(int i=0; i<data.length; i++){
			if(data[i] < 0){
				if(maxLength < (Integer.toString(data[i]).length()-1)){
					maxLength = Integer.toString(data[i]).length()-1;
				}
			}else{
				if(maxLength < (Integer.toString(data[i]).length())){
					maxLength = Integer.toString(data[i]).length();
					
				}
			}
		}
		
		radix_Sort(data, table, maxLength);
		
		/*for(int i=0; i<table.length; i++){
			System.out.print("Printing List "+i+": ");
			table[i].get_list().print_list();
		}*/
		
	}

}
