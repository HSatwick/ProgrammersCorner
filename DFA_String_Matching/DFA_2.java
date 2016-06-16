import java.util.ArrayList;


public class DFA_2 {
	
	public enum States{
		Start,
		State_1,
		State_2,
		State_3,
		State_4,
		State_5
	}
	
	public static States state;
	
	public ArrayList<Integer> indices(String input){
		ArrayList<Integer> output = new ArrayList<Integer>();
		state = States.Start;
		
		for(int i=0; i<input.length(); i++){
			if(state == States.Start){
				if(input.charAt(i) == 'a'){
					state = States.State_1;
				}
			}
			else if(state == States.State_1){
				if(input.charAt(i) == 'c'){
					state = States.State_2;
				}
				else if(input.charAt(i) != 'a'){
					state = States.Start;
				}
			}
			else if(state == States.State_2){
				if(input.charAt(i) == 'a'){
					state = States.State_1;
				}
				else if(input.charAt(i) == 'b'){
					state = States.State_3;
				}
				else{
					state = States.Start;
				}
			}
			else if(state == States.State_3){
				if(input.charAt(i) == 'a'){
					state = States.State_1;
				}
				else if(input.charAt(i) == 'd'){
					state = States.State_4;
				}
				else{
					state = States.Start;
				}
			}
			else if(state == States.State_4){
				if(input.charAt(i) == 'a'){
					state = States.State_5;
					output.add(i-4);
				}
				else{
					state = States.Start;
				}
			}
			else if(state == States.State_5){
				if(input.charAt(i) == 'c'){
					state = States.State_2;
				}
				else if(input.charAt(i)== 'a'){
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
