public class String_Reversal {

	public static String reverse(String str, int start, int end, int len) {
		
		int leng = end - start;
		
		for(int i=0; i<leng/2; i++){
			str = str.substring(0, start + i)
					+ str.substring(start + leng-i-1, start + leng - i)
					+ str.substring(start + i + 1, start + leng-i-1)
					+ str.substring(start + i, start + i+1)
					+ str.substring(start + leng-i, start + leng)
					+ str.substring(start + leng, len);
		}
		
		return str;
	}
	
	public static int nextPointer(String str, int counter){
		
		for(int i=counter; i<str.length(); i++){
			if(str.charAt(i) != ' '){
				return i;
			}
		}
		return -1;
	}

	public static String reverse_String(String str) {

		str = reverse(str, 0, str.length(), str.length());

		int len = str.length();
		int counter = 0;
		int first_pointer = counter;

		while (counter < len) {
			if (str.charAt(counter) == ' ') {
				str = reverse(str, first_pointer, counter, len);
				first_pointer = nextPointer(str, counter);
				counter = first_pointer;
			}else{
				counter++;
			}
		}
		str = reverse(str, first_pointer, counter, len);

		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "Hello World";
		String output = "World Hello";
		word = reverse_String(word);
		System.out.println(word);

		word = "You know nothing Jon Snow";
		output = "Snow Jon nothing know You";
		word = reverse_String(word);
		System.out.println(word);

	}

}
