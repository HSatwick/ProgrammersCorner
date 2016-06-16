package findNeedle;

public class findNeedle {
	
	public static int substrings(char []f, char []n){
		int startIndex = -1;
		int matchedChars = 0;
		
		//complexity: O(N*M) where N is length of f and M is length of n
		for(int i=0; i<=f.length-n.length; i++){
			for(int j=0; j<n.length; j++){
				if(f[i+j] == n[j]){
					if(j==0){startIndex = i;}
					matchedChars++;
				}else{
					startIndex = -1;
					matchedChars = 0;
					break;
				}
				if(matchedChars == n.length){
					return startIndex;
				}
			}
		}
		
		return startIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = new String("abcxabcdabxabcdabcdabcy");
		String y = new String("abcdabcy");
		char f[] = x.toCharArray();
		char n[] = y.toCharArray();
		int index = substrings(f,n);
		System.out.println(index);
	}

}
