package TP.TP3;

public class Boisson implements Consommable, Nutrition {

    private int volume; // en centilitres
    private String nom;
    private int prix;

    public Boisson(String nom, int prix, int volume){
        this.volume = volume;
        this.nom = nom;
        this.prix = prix;
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
