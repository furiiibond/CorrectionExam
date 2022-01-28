package DS2021;

public class Additionneur extends CircuitCombinatoire{
    int nbBits;
    public Additionneur(int nbBits) throws Exception {
        super(nbBits*2, nbBits+1);
        this.nbBits =nbBits;
    }

    @Override
    public boolean[] compute(boolean[] input) {
        // verification de la taille
        if (input.length != nbBits){
            return input; // on fini avec une erreur
        }
        boolean [] op1 = new boolean[this.getNbInputs()/2];
        boolean [] op2 = new boolean[this.getNbInputs()/2];

        // added
        for (int i = 0; i < input.length; i++) {
            if (i<input.length/2){
                op1[i] = input[i];
            } else {
                op2[i-input.length/2] = input[i];
            }
        }
        //
        return this.add(op1,op2);
    }

    private boolean[] add(boolean[] op1, boolean[] op2) {
        boolean [] res = new boolean[Math.max(op1.length, op2.length)+1];
        for (int i = 1; i < op1.length; i++) {
            res[res.length-i] = op1[op1.length-i];
        }
        //TODO continue
        for (int j = 0; j < op2.length; j++) {
            if (res[j] && op2[j]){
                // retenue
            } else {
                //
            }
        }
        return res;
    }

}
