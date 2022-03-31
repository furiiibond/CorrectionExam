package DSInter;

public class MotBinaire {
    // Contient un mot composé de 0 et de 1
// Le bit de poids le plus faible est mot[O];
    private int mot[];
    public MotBinaire(int taille){
        mot = new int[taille];
    }
    public void setBit(int position, int valeur){
        mot[position] = valeur;
    }
    public int getValeur(){
        int val = 0;
        for (int i=0; i<mot.length; i++){
            val += (int) (mot[i]*Math.pow(2,i));
        }
        return val;
    }
}

