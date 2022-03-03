package TD2;

public class Manuel extends Livre{
    private int niveau;

    public Manuel(int num, String title, int nbPage, String auteur, int niveau) {
        super(num, title, nbPage, auteur);
        this.niveau = niveau;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "Manuel{" +
                "niveau=" + niveau +
                "} " + super.toString();
    }
}
