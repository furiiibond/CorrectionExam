public class Main {

    public static void main(String[] args) {
        System.out.println(Pomme.tailleMax);
        Pomme pomme = new Pomme("rouge", 5, 100);
        pomme.setColor("vert");
        pomme.setSize(50000);
        System.out.println(pomme);
    }
}
