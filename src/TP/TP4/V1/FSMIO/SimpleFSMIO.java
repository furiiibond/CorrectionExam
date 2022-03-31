package TP.TP4.V1.FSMIO;

public class SimpleFSMIO {
    private SimpleTransitionFunction t;
    private String initialState;
    private String currentState;
    private String states[];
    private char inputs[];

    // Yes, these methods would need a bit more documentation.
    public SimpleFSMIO(String states[], String initialState, char inputs[]) {
		this.t = new SimpleTransitionFunction(states, inputs);
		this.states = states;
		this.inputs = inputs;
		this.currentState = this.initialState = initialState;
    }
    
    public void addTransition(String fromState, char inputVal, String destState, int output){

		boolean fromStateValid = false;
		boolean destStateValid = false;
		boolean inputValid = false;

		for(int ie = 0; ie < this.states.length && (!fromStateValid || !destStateValid); ie++){
			if(fromState.equals(this.states[ie])) fromStateValid = true;
			if(destState.equals(this.states[ie])) destStateValid = true;
		}

		for(int i = 0; i < this.inputs.length && !inputValid; i++){
			inputValid = (inputVal == this.inputs[i]);
		}

		if (fromStateValid && destStateValid && inputValid){
			t.addTransition(fromState, inputVal, destState, output);
		}
    }
	
    public int doTransition(char val) {
		int output = -1;
		try {
			output = getOutput(this.currentState, val);
			this.currentState = getNextState(this.currentState, val);
		} catch (Exception e) {
			System.out.println("Erreur de transition : " + e.getMessage());
		}
		return output;
    }
    
    public void reset(){
	this.currentState = this.initialState;
    }
	
    public String getCurrentState(){
	return this.currentState;
    }
	
    public String getNextState(String s, char e) {
		String nextState;
		try {
			nextState = this.t.getNextState(s, e);
		} catch (Exception exept){
			nextState = "ERROR : getNextState";
			System.out.println("Erreur de getNextState : " + exept.getMessage());
		}
		return nextState;
    }

	
    public int getOutput(String s, char e) {
		int res;
		try {
			res = this.t.getOutput(s, e);
		} catch (Exception exept){
			res = -1;
			System.out.println("Erreur de getOutput : " + exept.getMessage());
		}

		return res;
    }
}
