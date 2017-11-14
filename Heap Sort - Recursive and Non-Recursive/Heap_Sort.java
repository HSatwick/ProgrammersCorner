import java.util.Random;


public class Heap_Sort {
	
	public static final int _size = 10;
	
	public static void swap(int arr[], int index_1, int index_2){
		int temp = arr[index_1];
		arr[index_1] = arr[index_2];
		arr[index_2] = temp;
	}
	
	/***
	 * Recursive implementation of Heapify - Max heapify
	 * @param arr
	 * @param size
	 * @param current
	 */
	public static void heapify_recursive(int arr[], int size, int current){
		
		int current_node = current;
		int left_node = current*2+1;
		int right_node = current*2+2;
		
		if(left_node < size && arr[left_node] > arr[current_node]){
			current_node = left_node;
		}
		if(right_node < size && arr[right_node] > arr[current_node]){
			current_node = right_node;
		}
		
		if(current_node != current){
			swap(arr, current_node, current);
			heapify_recursive(arr, size, current_node);
		}
		
	}
	
	/***
	 * Non-Recursive implementation of Heapify - Max heapify
	 * @param arr
	 * @param size
	 * @param current
	 */
	public static void heapify_non_recursive(int arr[], int size, int current){
		int current_node = current;
		
		while(current_node * 2 + 1 < size){
			int left_node = current_node*2+1;
			int right_node = current_node*2+2;
			
			if(arr[left_node] > arr[current_node]){
				current_node = left_node;
			}
			if(right_node < size && arr[right_node] > arr[current_node]){
				current_node = right_node;
			}
			
			if(current_node != current){
				swap(arr, current_node, current);
				current = current_node;
			}else{
				break;
			}
		}
	}
	
	public static void heap_sort_recursive(int array[]){
		
		int length = array.length;
		for(int i=(length/2)-1; i>=0; i--){
			heapify_recursive(array, length, i);
		}
		
		for(int i=length-1; i>=0; i--){
			swap(array, 0, i);
			heapify_recursive(array, i, 0);
		}
		
	}
	
	public static void heap_sort_non_recursive(int array[]){
		int length = array.length;
		for(int i=(length/2)-1; i>=0; i--){
			heapify_non_recursive(array, length, i);
		}
		
		for(int i=length-1; i>=0; i--){
			swap(array, 0, i);
			heapify_non_recursive(array, i, 0);
		}
	}
	
	public static int[] generate_list(){
		int array[] = new int[_size];
		Random input = new Random();
		for(int i=0; i<_size; i++){
			array[i] = input.nextInt(1000);
		}
		return array;
	}
	
	public static void printList(int array[]){
		for(int i=0; i<_size; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	public static int[] deep_copy(int array[]){
		int temp_array[] = new int[_size];
		
		for(int i=0; i<_size; i++){
			temp_array[i] = array[i];
		}
		return temp_array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array_one[] = new int[_size];
		array_one = generate_list();
		int array_two[] = deep_copy(array_one);
		System.out.println("Original List 1 - unsorted");
		printList(array_one);
		heap_sort_recursive(array_one);
		System.out.println("Sorted List using Heap Sort - Recursive");
		printList(array_one);
		System.out.println("Original List 2 - unsorted");
		printList(array_two);
		heap_sort_non_recursive(array_two);
		System.out.println("Sorted List using Heap Sort - Non-Recursive");
		printList(array_two);
	}

}
