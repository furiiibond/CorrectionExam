package TD2;

public class Revue extends Document {
    private int mois;
    private int annee;

    public Revue(int num, String title, int mois, int annee) {
        super(num, title);
        this.mois = mois;
        this.annee = annee;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public boolean asAutor(){
        return false;
    }

    @Override
    public String toString() {
        return "Revue{" +
                "mois=" + mois +
                ", annee=" + annee +
                "} " + super.toString();
    }
}
