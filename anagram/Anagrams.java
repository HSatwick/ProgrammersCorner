package anagram;

import java.util.ArrayList;
import java.util.HashMap;

public class Anagrams {

	public static String obtainCode(String s) {
		String code = "";
		int codeArray[] = new int[26];
		for(int k=0; k<codeArray.length; k++){
			codeArray[k] = 0;
		}

		for (int j = 0; j < s.length(); j++) {
			int ascii = (int) s.charAt(j);
			ascii = ascii - 97;
			codeArray[ascii]++;
		}
		
		for(int k=0; k<codeArray.length; k++){
			code = code + Integer.toString(codeArray[k]);
		}

		return code;
	}

	public static HashMap<String, ArrayList<String>> getAnagrams(String[] s) {

		HashMap<String, ArrayList<String>> list = new HashMap<String, ArrayList<String>>();

		for (int i = 0; i < s.length; i++) {
			String code = obtainCode(s[i]);
			if (list.containsKey(code)) {
				ArrayList<String> l = list.get(code);
				l.add(s[i]);
			} else {
				ArrayList<String> l = new ArrayList<String>();
				l.add(s[i]);
				list.put(code, l);
			}
		}

		return list;
	}

	public static void printList(HashMap<String, ArrayList<String>> list) {

		for (String key : list.keySet()) {
			System.out.println(list.get(key).toString());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// given a list of strings, we need to group all the words that form
		// anagrams
		String s[] = { "cat", "act", "tom", "dog", "god", "tim", "mitt", "pit",
				"tip", "tac" };

		HashMap<String, ArrayList<String>> list = getAnagrams(s);
		printList(list);
	}

}
