package TP.TP3;

public class Boisson implements Consommable, Nutrition {

    private int volume; // en centilitres
    private String nom;
    private int prix;
    private int kcal; // nb de kilo calories
    private float glucide; // gramme de glucide

    public Boisson(String nom, int prix, int volume, int kcal, float glucide){
        this.nom = nom;
        this.prix = prix;
        this.volume = volume;
        this.kcal = kcal;
        this.glucide = glucide;
    }

    // eau gratuite donc valeur nutritionnelle nulle
    public Boisson(String nom, int volume){
        this(nom, 0, volume, 0, 0);
    }

    public int getVolume(){
        return volume;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public int getPrix() {
        return prix;
    }

    @Override
    public int getKcal()  {
        return kcal;
    }

    @Override
    public float getGlucides() {
        return glucide;
    }
}
