package TP.TP3;

public class Boisson implements Consommable {

    private int volume; // en centilitres
    private String nom;
    private int prix;

    public Boisson(String nom, int prix, int volume){
        this.volume = volume;
        this.nom = nom;
        this.prix = prix;
    }

    public Boisson(String nom, int volume){
        this(nom, 0, volume);
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
}
