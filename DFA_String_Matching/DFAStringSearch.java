import java.util.ArrayList;


public class DFAStringSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "bcacdbabcabcddacd";
		DFA_1 dfa1 = new DFA_1();
		DFA_2 dfa2 = new DFA_2();
		ArrayList<Integer> output = dfa1.indices(input);
		System.out.println("String Pattern: 'bc' found at location(s) for "+input);
		System.out.println(output.toString());
		output = dfa2.indices(input);
		System.out.println("String Pattern: 'acbda' found at location(s) for "+input);
		System.out.println(output.toString());
		
		input = "cbdbcacbdaacbdacbc";
		output = dfa1.indices(input);
		System.out.println("String Pattern: 'bc' found at location(s) for "+input);
		System.out.println(output.toString());
		output = dfa2.indices(input);
		System.out.println("String Pattern: 'acbda' found at location(s) for "+input);
		System.out.println(output.toString());
	}

}
