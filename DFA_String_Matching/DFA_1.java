import java.util.ArrayList;


public class DFA_1{	
	
	public enum States{
		Start,
		State_1,
		State_2
	}
	
	public static States state;
	
	
	public ArrayList<Integer> indices(String input){
		ArrayList<Integer> output = new ArrayList<Integer>();
		state = States.Start;
		
		for(int i=0; i<input.length(); i++){
			if(state == States.Start){
				if(input.charAt(i) == 'b'){
					state = States.State_1;
				}
			}
			else if(state == States.State_1){
				if(input.charAt(i) == 'c'){
					state = States.State_2;
					output.add((i-1));
				}
				else if(input.charAt(i) != 'b'){
					state = States.Start;
				}
			}
			if(state == States.State_2){
				if(input.charAt(i) == 'b'){
					state = States.State_1;
				}
				else{
					state = States.Start;
				}
			}
		}
		return output;
	}
	
}