
public class StringCompare {
	
	//-1 is a < b, 0 if a == b and 1 if a > b
	public static int compareTo(String a, String b){
		
		if(a.length() < b.length()){
			for(int i=0; i<a.length(); i++){
				if(a.charAt(i) < b.charAt(i)){
					return -1;
				}
				else if(a.charAt(i) > b.charAt(i)){
					return 1;
				}
			}
			return -1;
		}
		else if(a.length() > b.length()){
			for(int i=0; i<b.length(); i++){
				if(a.charAt(i) < b.charAt(i)){
					return -1;
				}
				else if(a.charAt(i) > b.charAt(i)){
					return 1;
				}
			}
			return 1;
		}
		else{
			for(int i=0; i<b.length(); i++){
				if(a.charAt(i) < b.charAt(i)){
					return -1;
				}
				else if(a.charAt(i) > b.charAt(i)){
					return 1;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aaedfffff";
		String b = "aa";
		
		System.out.println(compareTo(a,b));
		System.out.println(a.compareTo(b));
		
		String c = "rat";
		String d = "rattata";
		
		System.out.println(compareTo(c,d));
		System.out.println(c.compareTo(d));
		
		String e = "Cotton";
		String f = "cotton";
		
		System.out.println(compareTo(e,f));
		System.out.println(e.compareTo(f));
		
		String g = "football";
		String h = "football";
		
		System.out.println(compareTo(g,h));
		System.out.println(g.compareTo(h));

	}

}
