package TP.TP4.V1.FSMIO;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;
import java.lang.*;

public class TestFSMIO {

	public static void main(String argv[]){

	    String stateNames[] = new String[3];
	    char inputs[] = new char[2];
	    stateNames[0] = "s1";
	    stateNames[1] = "s2";
	    stateNames[2] = "s3";
	    inputs[0] = 'a';
	    inputs[1] = 'b';

	    SimpleFSMIO sfsm = new SimpleFSMIO(stateNames, "s1", inputs);
	    sfsm.addTransition("s1", 'a', "s1", 0);
	    sfsm.addTransition("s1", 'b', "s3", 0);
	    sfsm.addTransition("s2", 'a', "s1", 0);
	    sfsm.addTransition("s2", 'b', "s2", 1);
	    sfsm.addTransition ("s3", 'a', "s2", 1);
	    sfsm.addTransition("s3", 'b', "s3", 1);

	    sfsm.reset();

		final StringBuilder result = new StringBuilder();
		final StringCharacterIterator iterator = new StringCharacterIterator("abbaabbaaa");
		char character = iterator.current();
		while (character != CharacterIterator.DONE) {
			result.append(sfsm.getCurrentState());
			result.append("--(");
			result.append(character);
			result.append("/");
			result.append(sfsm.doTransition(character));
			result.append(")--");
			character = iterator.next();
		}
		result.append(sfsm.getCurrentState());
		result.append("--END");

		System.out.println(result);
	}
}
