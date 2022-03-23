package TP.TP3;

import java.util.ArrayList;

public class Menu {
    ArrayList<Consommable> items;
    int prix; // en cents


    public Menu(int prix, Entree e, PlatPrincipal p, Dessert d, Boisson b){
        //TODO : completer (question3 + question 5)
        this.prix = prix;
        items = new ArrayList<>();
        items.add(e);
        items.add(p);
        items.add(d);
        items.add(b);

        if (!verifPrixMenu())
            System.out.println("ERREUR => PRIX DU MENU INCORRECT");

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
        message.append(prix);
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
}
