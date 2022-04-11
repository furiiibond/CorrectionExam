package TP.TP4.V2.FSMIO;
import java.io.File;
import java.lang.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;

public class TestFSMIO {

    public static void main(String argv[]){
		State s1, s2, s3, s4;
		s1 = new State("s1");
		s2 = new State("s2");
		s3 = new State("s3");
		s4 = new State("s4");

		ArrayList<State> states = new ArrayList<State>();
		states.add(s1);
		states.add(s2);
		states.add(s3);
		states.add(s4);


		FSMIO<String, Integer> fsm = new FSMIO<String, Integer>(states, s1);

		// remarquez que l'ordre des arguments n'est pas le même que la V1. Pourquoi ?
		fsm.addTransition(s1, "a", 0, s2);
		fsm.addTransition(s1, "b", 0, s3);
		fsm.addTransition(s2, "a", 0, s3);
		fsm.addTransition(s2, "b", 1, s2);
		fsm.addTransition(s3, "a", 0, s4);
		fsm.addTransition(s3, "b", 0, s3);
		fsm.addTransition(s4, "a", 1, s2);
		fsm.addTransition(s4, "b", 1, s3);

		System.out.println(fsm);
		fsm.reset();

		String result = runAutomate(fsm, "abbaabbaaa");

		System.out.println(result);

		//Automate bonus
		// FSMIO à neuf State reconnaissant une suite de quatre 0 ou quatre 1
		State s5, s6, s7, s8, s9, s10, s11, s12, s13;
		s5 = new State("s5");
		s6 = new State("s6");
        s7 = new State("s7");
		s8 = new State("s8");
		s9 = new State("s9");
		s10 = new State("s10");
		s11 = new State("s11");
		s12 = new State("s12");
		s13 = new State("s13");
		ArrayList<State> states2 = new ArrayList<State>();
        states2.add(s5);
		states2.add(s6);
        states2.add(s7);
		states2.add(s8);
        states2.add(s9);
		states2.add(s10);
        states2.add(s11);
        states2.add(s12);
        states2.add(s13);
		FSMIO<String, Integer> fsm2 = new FSMIO<String, Integer>(states2, s5);

		// ajoute les transitions de l'automate 2 reconnaissant une suite de quatre 0 ou quatre 1
        fsm2.addTransition(s5, "0", 0, s6);
        fsm2.addTransition(s6, "0", 0, s8);
		fsm2.addTransition (s8, "0", 0, s10);
		fsm2.addTransition(s10, "0", 1, s12);
		fsm2.addTransition(s12, "0", 1, s12);
		fsm2.addTransition(s7, "0", 0, s6);
		fsm2.addTransition(s9, "0", 0, s6);
		fsm2.addTransition (s11, "0", 0, s6);
		fsm2.addTransition(s13, "0", 0, s6);
        fsm2.addTransition(s13, "0", 1, s13);

		fsm2.addTransition(s5, "1", 0, s7);
		fsm2.addTransition(s6,"1",0, s7);
		fsm2.addTransition(s7,"1",0, s9);
		fsm2.addTransition(s8,"1",0, s7);
		fsm2.addTransition(s9,"1",0, s11);
		fsm2.addTransition(s10,"1",0, s7);
		fsm2.addTransition(s11,"1",1, s13);
		fsm2.addTransition(s12,"1",0, s7);
		fsm2.addTransition(s13,"1",1, s13);

        System.out.println(fsm2);
		fsm2.reset();

        String result2 = runAutomate(fsm2, "001000011111000");
        System.out.println(result2);

		fsm2.reset();
		String chronogram = generateChronogram(fsm2, "001000011111000");
		System.out.println(chronogram);
    }

	private static String runAutomate(FSMIO<String, Integer> fsm, String mot){
		final StringBuilder result = new StringBuilder();
		final StringCharacterIterator iterator = new StringCharacterIterator(mot);
		char character = iterator.current();
		while (character != CharacterIterator.DONE) {
			result.append(fsm.getCurrentState());
			result.append("--(");
			result.append(character);
			result.append("/");
			result.append(fsm.doTransition(String.valueOf(character)));
			result.append(")--");
			character = iterator.next();
		}
		result.append(fsm.getCurrentState());
		result.append("--END");

		return result.toString();
	}

	//Un automate avec les alphabets {0, 1} et {0, 1} :
	//Prend la valeur '-' si les quatre transitions précédentes ont ”vu” quatre 0 (zéros) de
	//suite ou quatre 1 (uns) de suite.
	//Sinon, la sortie vaut '_'
	private static String generateChronogram(FSMIO<String, Integer> fsm, String mot){
		final StringBuilder chronogram = new StringBuilder();
		final StringCharacterIterator iterator = new StringCharacterIterator(mot);
		char character = iterator.current();
		while (character != CharacterIterator.DONE) {
			if (fsm.doTransition(String.valueOf(character)) == 1){
				chronogram.append("-");
			}
			else{
				chronogram.append("_");
			}
			character = iterator.next();
		}
		// la clock permettait de synchroniser, sans clock on obtient donc un chronogramme décalé de 1
		chronogram.insert(0, "_"); // ajout d'un état bas au début
		chronogram.deleteCharAt(chronogram.length()-1); // suppression du dernier état

		return chronogram.toString();
	}
}
