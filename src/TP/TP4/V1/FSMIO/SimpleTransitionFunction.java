package TP.TP4.V1.FSMIO;

public class SimpleTransitionFunction {
    private String stateNames[];
    private char inputs[];
    private String nextState[][];
    private int output[][];

    public SimpleTransitionFunction(String stateNames[], char inputs[]) {
        this.stateNames = stateNames;
        this.inputs = inputs;
        int stateLen = stateNames.length;
        int inputsLen = inputs.length;

        this.nextState = new String[stateLen][inputsLen];
        this.output = new int[stateLen][inputsLen];

        for (int x = 0; x < stateLen; x++){
            for (int y = 0; y < inputsLen; y++){
                this.nextState[x][y] = "";
                this.output[x][y] = -1;
            }
        }

        //To debug, you can uncomment the following line
        //System.out.println("transition table of size "+stateNames.length+" x "+inputs.length);
    }

    // Cherche l'index d'un état donné par sa chaîne.
    private int getStateIndex(String etat) throws Exception{
        int i = 0;
        while(i < this.stateNames.length && !this.stateNames[i].equals(etat))
            i++;
        if (i == this.stateNames.length)
            throw new Exception("Etat inexistant");
        return i;
    }

    // identiquement...
    private int getInputIndex(char input) throws Exception{
        int i = 0;
        while(i < this.inputs.length && this.inputs[i] != input)
            i++;
        if (i == this.inputs.length) throw new Exception("Input inexistante");
        return i;
    }

    public void addTransition(String fromStateName, char input, String nomEtatDest, int output){
        try {
            int currentStateIndex = getStateIndex(fromStateName);
            int currentInputIndex = getInputIndex(input);
            this.nextState[currentStateIndex][currentInputIndex] = nomEtatDest;
            this.output[currentStateIndex][currentInputIndex] = output;
        } catch (Exception e) {
            System.out.println("ERROR: Can not add transition");
            e.printStackTrace();
        }
    }

    public String getNextState(String fromStateName, char input) throws Exception{
        int currentStateIndex = getStateIndex(fromStateName);
        int currentInputIndex = getInputIndex(input);
        return this.nextState[currentStateIndex][currentInputIndex];
    }

    public int getOutput(String fromStateName, char input) throws Exception{
        int currentStateIndex = getStateIndex(fromStateName);
        int currentInputIndex = getInputIndex(input);
        return this.output[currentStateIndex][currentInputIndex];
    }
}
