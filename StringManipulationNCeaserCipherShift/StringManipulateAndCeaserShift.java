import java.util.Random;

public class StringManipulateAndCeaserShift {
	
	public static Random number = new Random();
	
	public static String manipulateAndCShift(String input){
		String output = "";
		boolean flag = false;
		for(int i=0; i<input.length(); i++){
			if(!flag){
				if(input.charAt(i) == '|'){
					flag = true;
				}else{
					output += input.charAt(i)+"";
				}
			}else{
				if(input.charAt(i) != '|'){
					int rand = number.nextInt();
					if(rand < 0){ rand = rand*-1;}
					rand = rand % 26;
					String temp = input.charAt(i)+"";
					temp = temp.toUpperCase();
					int location = (int)temp.charAt(0);
					location = location - 65;
					location = (location + rand) % 26;
					location = location + 65;
					temp = ((char)location)+"";
					output += temp;
					flag = false;
				}
			}
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "we|like|t|o|program";
		//weliketoprogram
		String output = manipulateAndCShift(input);
		System.out.println(output);

	}

}
