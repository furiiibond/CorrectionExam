package testAbstract;

public class Main {
    public static void main(String[] args) {
        System.out.println(Voiture.TAILLEMAX);
        Vehicule vehicule = new Voiture("Aston martin");
        System.out.println(vehicule.getNbRoues());
    }
}
