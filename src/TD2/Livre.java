package TD2;

public class Livre extends Document {
    private int nbPage;
    private String auteur;

    public Livre(int num, String title, int nbPage, String auteur) {
        super(num, title);
        this.nbPage = nbPage;
        this.auteur = auteur;
    }

    public int getNbPage() {
        return nbPage;
    }

    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public boolean asAutor(){
        return true;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "nbPage=" + nbPage +
                ", auteur='" + auteur + '\'' +
                "} " + super.toString();
    }
}
