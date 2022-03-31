package testAbstract;

public class Voiture extends Vehicule {

    public Voiture(String marque) {
        super(marque);
    }

    @Override
    public int getNbRoues() {
        return 4;
    }

    // ...

}
