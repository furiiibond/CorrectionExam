package TP.TP4.V3;

import TP.TP4.V2.FSMIO.FSMIO;
import info.leadinglight.jdot.Graph;

public class TestMain {
    public static void main(String[] args) {
        // automate Bonus de la V2
        FSMIOString fsmquatreval = new FSMIOString("quatrevalprecedentes.fsm");
        FSMIO<String, String> quatrevalprec = fsmquatreval.getFSM();
        System.out.println(quatrevalprec);

        // automate Bonus qui reconnait les chaines finissant par "ab" sur l'alphabet {a,b}
        FSMIOString fsmfiniparlachaineab = new FSMIOString("finiparlachaineab.fsm");
        FSMIO<String, String> finiparlachaineab = fsmfiniparlachaineab.getFSM();
        System.out.println(finiparlachaineab);

        FSMIOString fsm = new FSMIOString("coffeemachine.fsm");
        FSMIO<String, String> fsmio = fsm.getFSM();
        System.out.println(fsmio);
        Graph g = GraphDisplay.display(fsmio);
        //Graph.setDefaultCmd("C:/Users/jeanc/IdeaProjects/CorrectionExam/Graphviz/bin/dot.exe");
        Graph.setDefaultCmd("dot.exe");
        g.viewSvg();
    }
}
