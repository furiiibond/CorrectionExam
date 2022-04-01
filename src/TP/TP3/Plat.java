package TP.TP3;

public class Plat implements Consommable, Nutrition {
    private String nom;
    private int prix;
    private int kcal; // nb de kilo calories
    private float glucide; // gramme de glucide en gramme

    public Plat(String nom, int prix, int kcal, float glucide) {
        this.nom = nom;
        this.prix = prix;
        this.kcal = kcal;
        this.glucide = glucide;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public int getPrix() {
        return this.prix;
    }

    @Override
    public int getKcal() {
        return kcal;
    }

    @Override
    public float getGlucides() {
        return glucide;
    }
}
