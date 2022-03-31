package TP.TP3;

import java.util.ArrayList;
import java.util.List;

public class Carte {
    private ArrayList<Consommable> entrees;
    private ArrayList<Consommable> platsPrincipaux;
    private ArrayList<Consommable> desserts;
    private ArrayList<Consommable> boissons;

    private ArrayList<Menu> menus;

    public Carte() {
        entrees = new ArrayList<Consommable>();
        platsPrincipaux = new ArrayList<Consommable>();
        desserts = new ArrayList<Consommable>();
        boissons = new ArrayList<Consommable>();
        menus = new ArrayList<Menu>();
    }

    public void addEntree(Entree e){
        if (verifCarte(e)) this.entrees.add(e);
    }

    public void addPlatPrincipal(PlatPrincipal p){
        if (verifCarte(p)) this.platsPrincipaux.add(p);
    }

    public void addDessert(Dessert d){
        if (verifCarte(d)) this.desserts.add(d);
    }

    public void addBoisson(Boisson b){
        if (verifCarte(b)) this.boissons.add(b);
    }

    public void addMenu(Menu m){
        if (verifMenu(m)){
            this.menus.add(m);
        }
    }

    public ArrayList<Consommable> getEntrees(){
        return this.entrees;
    }

    public ArrayList<Consommable> getPlatsPrincipaux(){
        return this.platsPrincipaux;
    }

    public ArrayList<Consommable> getDesserts(){
        return this.desserts;
    }

    public ArrayList<Consommable> getBoissons(){
        return this.boissons;
    }

    // Vérifie qu'il n'y a pas d'homonymes dans la carte
    // utiliser equals et des iterateurs
    //
    private boolean verifCarte(Consommable c){
        return contientPasNom(entrees, c) && contientPasNom(platsPrincipaux, c) && contientPasNom(desserts, c) && contientPasNom(boissons, c);
    }

    private boolean contientPasNom(ArrayList<Consommable> consommablesListe, Consommable c) {
        String nomItem = c.getNom();

        for (Consommable consommable: consommablesListe) {
            if (consommable.getNom().equals(nomItem))
                return true;
        }
        return false;
    }

    // Vérifie que les plats et boissons du menu sont bien dans la carte
    // Question 7 : réaliser verifMenu
    private boolean verifMenu(Menu m) {
        for (Consommable consommable : m.getItems()){
            if (!(entrees.contains(consommable) || platsPrincipaux.contains(consommable) || desserts.contains(consommable) || boissons.contains(consommable)))
                return false;
        }
        return true;
    }


    /* Calcule le prix de la commande. A priori, ce prix est la somme des prix des items
     * SAUF si une partie de ces items constituent un menu; dans ce cas, le tarif menu s'applique pour ces items.
     */
    // TODO Question 8 - calculerPrixCommande
    public int calculerPrixCommande(Commande c){
        // Parcours des menu => on prend le premier menu contenant un sous-ensemble des items commandés
        // Ensuite pour les items restent on applique le prix unitaire des consomables.
        int prixCommande = 0;
        Menu menuTrouve = null;
        for (Menu menu : this.menus){
            if (c.getItemsCommandés().containsAll(menu.getItems())){ // si on trouve un menu complet
                menuTrouve = menu;
                break;
            }
        }
        if (menuTrouve != null){   // si on trouve un menu
            prixCommande += menuTrouve.getPrix();  // prix du menu
            for (Consommable itemCom : c.getItemsCommandés()){
                if(! menuTrouve.getItems().contains(itemCom)){  // prix des suppléments au menu
                    prixCommande += itemCom.getPrix();
                }
            }
        } else { // si on ne trouve pas de menu
            for (Consommable itemCom : c.getItemsCommandés()){
                prixCommande += itemCom.getPrix();
            }
        }
        return prixCommande;
    }

    public void printCommande(Commande commande){
        System.out.println(commande.toString() + calculerPrixCommande(commande));
    }

    public void afficherMenu(){
        System.out.println("Liste des entrees:" + entrees);
        System.out.println("Liste des plats principaux:" + platsPrincipaux);
        System.out.println("Liste des desserts:" + desserts);
        System.out.println("Liste des boissons:" + boissons);
    }
}
