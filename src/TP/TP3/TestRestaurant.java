package TP.TP3;

public class TestRestaurant {

    public TestRestaurant() {
    }
    
    public static void main(String args[]){
        System.out.println("-----------Version 1 de l’application-----------");
        Consommable boisson = new Boisson("Coca cola", 500, 1, 1,3);
        Entree entree = new Entree("Salade", 1000, 0, 0);
        Entree entreeCharcutrie = new Entree("Charcutrie", 1100, 1, 0.2f);
        PlatPrincipal platPrincipal = new PlatPrincipal("Poulet", 1500, 1, 30.3f);
        Dessert dessert = new Dessert("Pomme golden", 200, 0, 11);
        System.out.println("-----------Test de menu Correct-----------");
        Menu menu = null;
        try {
            menu = new Menu(3000, entree, platPrincipal, dessert, (Boisson) boisson);
            System.out.println(menu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-----------Test de VerifMenu-----------");

        Carte carte = new Carte();
        carte.addBoisson((Boisson) boisson);
        carte.addDessert(dessert);
        carte.addEntree(entree);
        carte.addEntree(entreeCharcutrie);
        carte.addPlatPrincipal(platPrincipal);
        carte.addMenu(menu);
        carte.afficherMenu();
        System.out.println("-----------Affichage De la commande-----------");

        Commande commande = new Commande();
        commande.addItem(entree);
        commande.addItem(platPrincipal);
        commande.addItem(dessert);
        commande.addItem(boisson);
        commande.addItem(entreeCharcutrie);

        carte.printCommande(commande);

        /*System.out.println("-----------Test de menu InCorrect-----------");
        try {
            menu = new Menu(3300, entree, platPrincipal, dessert, (Boisson) boisson);  // menu
            System.out.println(menu);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        System.out.println("-----------V2 La diététique-----------");
        System.out.println("Nombre de calorie totales du menu1 : " + menu.totalKCal() + "kcal");
        carte.proposerMenu(3, 1);
    }
    
}
