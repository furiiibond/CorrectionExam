package testAbstract;

public abstract class Vehicule {

    private final String marque;
    protected float vitesse;
    public static final int TAILLEMAX = 10;

    public Vehicule(String marque) {
        this.marque = marque;
    }

    public abstract int getNbRoues();

}
