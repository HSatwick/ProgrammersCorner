import java.util.*;

public class matchingBrackets {

	public static HashMap<String, String> patterns = new HashMap<String, String>();
	
	public static void main(String[] args) {
		
		patterns.put("{", "}");
		patterns.put("[", "]");
		patterns.put("(", ")");
		
		Stack<String> stacks = new Stack<String>();
		
		String inputStream = "{()}";
		
		boolean matches = matchParenthesis(stacks,inputStream);
		System.out.println("the parenthesis pattern is "+inputStream);
		System.out.println("the pattern matches! "+matches);
		
	}
	
	public static boolean matchParenthesis(Stack<String> s, String input){
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{'){
				s.push(input.charAt(i)+"");
			}else if(input.charAt(i) == ')'){
				String newChar = s.pop();
				if(!newChar.equals("(")){
					return false;
				}
			}else if(input.charAt(i) == ']'){
				String newChar = s.pop();
				if(!newChar.equals("[")){
					return false;
				}
			}else if(input.charAt(i) == '}'){
				String newChar = s.pop();
				if(!newChar.equals("{")){
					return false;
				}
			}
		}
		if(s.size() == 0){
			return true;
		}
		return false;
	}

}
