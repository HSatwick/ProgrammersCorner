
public class Palindrom_By_Prefix {
	
	public static boolean is_palindrom(String s){
		
		for(int t=0; t<s.length()/2; t++){
			if(s.charAt(t) != s.charAt(s.length()-t-1)){
				return false;
			}
		}
		return true;	
	}
	
	public static String reverseStr(String s){
		String reversedStr = "";
		
		for(int k=s.length()-1; k>=0; k--){
			reversedStr += s.charAt(k)+"";
		}
		
		return reversedStr;
	}
	
	public static void min_prefix(String s){
		
		String tmp = "";
		int start = 0, end = s.length(), maxL = s.length();
		for(int j=0; j<s.length(); j++){
			tmp = reverseStr(s.substring(j, s.length())) + s;
			if(is_palindrom(tmp)){
				start = j;
				end = s.length();
				maxL = s.substring(j, s.length()).length();
			}
		}
		
		if(maxL == s.length()){
			System.out.print("");
		}else{
			for(int h=end-1; h>=start; h--){
				System.out.print(s.charAt(h));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input[] = {"abcc", "gta", "gertr", "aabcd", "mood", "bccba"};
		
		for(int i=0; i<input.length; i++){
			System.out.print("Adding '");
			min_prefix(input[i]);
			System.out.println("' as prefix will make the string '"+input[i]+"' a palindrom");
			System.out.println();
		}
	}

}
