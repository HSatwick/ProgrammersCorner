import java.math.BigInteger;
import java.util.ArrayList;

public class Rabin_Karp_Algo {
	
	public static int prime = 17;
	
	public static BigInteger obtainPatternHash(String pattern){
		BigInteger hash = new BigInteger("0");
		for(int i=0; i<pattern.length(); i++){
			int pow = (int)Math.pow(prime, i);
			BigInteger power = new BigInteger(pow+"");
			BigInteger charInt = new BigInteger((int)pattern.charAt(pattern.length()-i-1)+"");
			charInt = charInt.multiply(power);
			hash = hash.add(charInt);
		}
		return hash;
	}
	
	public static boolean compareHash(String input, BigInteger hash){
		BigInteger inputHash = obtainPatternHash(input);
		if(inputHash.equals(hash)){
			return true;
		}
		return false;
	}
	
	public static ArrayList<Integer> rabinKarp(String input, String pattern){
		ArrayList<Integer> output = new ArrayList<Integer>();
		BigInteger hash = obtainPatternHash(pattern);
		for(int  i=0; i<=input.length()-pattern.length(); i++){
			if(compareHash(input.substring(i, i+pattern.length()),hash)){
				if(input.substring(i, i+pattern.length()).equals(pattern)){
					output.add(i);
				}
			}
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abcdbcadefacefdeda";
		String pattern[] = {"cd","ab","a", "f", "c", "bc", "r"};
		for(int i=0; i<pattern.length; i++){
			ArrayList<Integer> patternLocation = new ArrayList<Integer>();
			patternLocation = rabinKarp(input, pattern[i]);
			System.out.println("Pattern '"+pattern[i]+"' found at index: ");
			System.out.println(patternLocation.toString());
		}
	}

}
