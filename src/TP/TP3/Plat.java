package TP.TP3;

public class Plat implements Consommable {
    private String nom;
    private int prix;

    public Plat(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public int getPrix() {
        return this.prix;
    }
}
