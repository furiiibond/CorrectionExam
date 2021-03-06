package TP.TP3;

import java.util.ArrayList;

public class Commande {
    private ArrayList<Consommable> itemsCommandes;
	
    public Commande() {
	this.itemsCommandes = new ArrayList<Consommable>();
    }
	
    public void addItem(Consommable c){
	this.itemsCommandes.add(c);
    }
	
    public ArrayList<Consommable> getItemsCommandés(){
	    return this.itemsCommandes;
    }

    //impression de la commande

    @Override
    public String toString() {
       StringBuilder message = new StringBuilder("Votre commande :\n");
        for (Consommable item : itemsCommandes){
            message.append(item.getNom());
            message.append(", ");
        }

        return message.toString();
    }
}
