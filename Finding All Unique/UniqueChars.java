import java.util.HashMap;

public class UniqueChars {
	
	//using substring and indexAt
	public static void find_unique_chars(String s){
		
		for(int i=0; i<s.length(); i++){
			if(s.substring(0, i).indexOf(s.charAt(i)) == -1 && s.substring(i+1, s.length()).indexOf(s.charAt(i)) == -1){
				System.out.print(s.charAt(i)+" ");
			}
		}
		
	}

	// using only arrays
	public static void find_all_unique_array(String s) {

		int helper[] = new int[s.length()];

		// initialization
		for (int i = 0; i < s.length(); i++) {
			helper[i] = -1;
		}
		
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			if (helper[i] == -1) {
				for(int reverse_counter = (s.length() - 1); reverse_counter != i; reverse_counter--) {
					if (s.charAt(i) == s.charAt(reverse_counter)) {
						helper[reverse_counter] = 0;
						flag = true;
					}
				}
			}
			if (flag) {
				flag = false;
				helper[i] = 0;
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (helper[i] == -1) {
				System.out.print(s.charAt(i) + " ");
			}
		}
		System.out.println();
	}

	// using HashMaps
	public static void find_all_unique(String s) {
		HashMap<String, Integer> helper = new HashMap<String, Integer>();
		HashMap<Integer, String> helping_helper = new HashMap<Integer, String>();

		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if (!helper.containsKey(s.charAt(i) + "")) {
				helper.put(s.charAt(i) + "", 1);
				helping_helper.put(count, s.charAt(i) + "");
				count++;
			} else {
				int occur = helper.get(s.charAt(i) + "");
				occur++;
				helper.put(s.charAt(i) + "", occur);
			}
		}

		for (int j = 1; j <= helping_helper.size(); j++) {
			if (helper.get(helping_helper.get(j)) == 1) {
				System.out.print(helping_helper.get(j) + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "adsdfkfgjtoijeio#58@ffkjfsdqyv";
		find_all_unique(input);
		find_all_unique_array(input);
		find_unique_chars(input);
	}

}
