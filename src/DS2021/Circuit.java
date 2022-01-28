package DS2021;

abstract public class Circuit {
    private int nbInputs;
    private int nbOutputs;

    public Circuit(int nbInputs, int nbOutputs) throws Exception {  // added
        //added
        if (nbInputs<0 || nbOutputs <0){
            throw new Exception("nb Inputs and OutPuts may not be negative");
        }
        //added
        this.nbInputs = nbInputs;
        this.nbOutputs = nbOutputs;
    }

    public int getNbInputs() {
        return nbInputs;
    }

    public int getNbOutputs() {
        return nbOutputs;
    }

    abstract public boolean[] compute(boolean[] input);
}
