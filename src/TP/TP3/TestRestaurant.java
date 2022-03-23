package TP.TP3;

public class TestRestaurant {

    public TestRestaurant() {
    }
    
    public static void main(String args[]){
        Consommable boisson = new Boisson("coca cola", 5, 1);
        System.out.println(boisson.getNom());
        Entree entree = new Entree("salade", 10);
        PlatPrincipal platPrincipal = new PlatPrincipal("Poulet", 15);
        Dessert dessert = new Dessert("Pomme golden", 2);
        Menu menu = new Menu(30, entree, platPrincipal, dessert, (Boisson) boisson);
        System.out.println(menu);
    }
    
}
