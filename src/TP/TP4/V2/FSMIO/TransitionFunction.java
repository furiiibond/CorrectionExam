package TP.TP4.V2.FSMIO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransitionFunction <T1, T2>{
    private List<Transition<T1, T2>> transitions;

    public TransitionFunction( ) {
	this.transitions = new ArrayList<Transition<T1, T2>>();
    }

    public void addTransition(State orig, T1 input, State dest, T2 output){
	this.transitions.add(new Transition<T1, T2>(orig, new Tag<T1, T2>(input, output), dest));
    }
	
    // Inspection methods
    // Get a transition from a state
    public Transition<T1, T2> getTransition(State orig, T1 input){
	Iterator<Transition<T1, T2>> iter = this.transitions.iterator();
	Transition<T1, T2> t = null;
	boolean found = false;
	while(iter.hasNext() && !found){
	    t = iter.next();
	    found = t.getOrig().equals(orig) && t.getTag().getInput().equals(input);
	}
	if (!found) return null; else return t;
    }
	
    // Get all transitions from a state
    public ArrayList<Transition<T1, T2>> getTransitions(State s){
	ArrayList<Transition<T1, T2>> lt = new ArrayList<Transition<T1, T2>>();
	for(Transition<T1, T2> t : this.transitions){
	    if (t.getOrig().equals(s)) lt.add(t);
	}
	return lt;
    }

	/*
		s1 -> s2 Tag= a/0 s1 -> s3 Tag= b/0s2 -> s3 Tag= a/0s2 -> s2 Tag= b/1s3 -> s4 Tag= a/0s3 -> s3 Tag= b/0s4 -> s2 Tag= a/1s4 -> s3 Tag= b/1
	 */
    public String toString(){
		StringBuilder res = new StringBuilder();
        for(Transition<T1, T2> t : this.transitions) {
			res.append(t.getOrig().toString());
			res.append(" -> ");
			res.append(t.getDest().toString());
			res.append(" Tag= ");
			res.append(t.getTag().toString());
			res.append("\n");
		}

		return res.toString();
    }
}
