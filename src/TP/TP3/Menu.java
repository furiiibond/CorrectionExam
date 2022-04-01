package TP.TP3;

import java.util.ArrayList;

public class Menu {
    ArrayList<Consommable> items;
    int prix; // en cents


    public Menu(int prix, Entree e, PlatPrincipal p, Dessert d, Boisson b) throws Exception {
        //TODO : completer (question3 + question 5)
        this.prix = prix;
        items = new ArrayList<>();
        items.add(e);
        items.add(p);
        items.add(d);
        items.add(b);

        if (!verifPrixMenu())
            throw new Exception("Erreur: prix du menu incorrect");

    }

    public ArrayList<Consommable> getItems(){
        return this.items;
    }

    public int getPrix(){
        return this.prix;
    }

    public String toString(){  // EXEMPLE =>  “Menu composé de Salade verte, Pizza Reine, Tiramisu, Eau, au prix de 15 euros”
        StringBuilder message = new StringBuilder("Menu compose de ");
        for (Consommable consommable: items) {
            message.append(consommable.getNom());
            message.append(", ");
        }
        message.append("au prix de ");
        message.append(Math.round((prix / 100f)));
        message.append(" euros");
        return message.toString();
    }

    // Retourne une valeur vraie uniquement si la somme des prix des items composant un menu
    // est supérieure ou égale au prix du menu qui doit lui-même être strictement positif.
    private boolean verifPrixMenu(){
        int price = 0;
        for (Consommable consommable: items) {
            price += consommable.getPrix();
        }
        return (this.prix <= price && this.prix > 0);
    }

    // Retourne la somme des calories de tous les consommables du menu
    public int totalKCal() {
        int totalKloCal = 0;
        for (Consommable item : items) {
            Nutrition itemN = (Nutrition) item;
            totalKloCal += itemN.getKcal();
        }
        return totalKloCal;
    }
}
