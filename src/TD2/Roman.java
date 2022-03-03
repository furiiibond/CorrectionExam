package TD2;

public class Roman extends Livre{
    private Prix prixLitteraire;

    public Roman(int num, String title, int nbPage, String auteur, Prix prixLitteraire) {
        super(num, title, nbPage, auteur);
        this.prixLitteraire = prixLitteraire;
    }

    public Prix getPrixLitteraire() {
        return prixLitteraire;
    }

    public void setPrixLitteraire(Prix prixLitteraire) {
        this.prixLitteraire = prixLitteraire;
    }

    @Override
    public String toString() {
        return "Roman{" +
                "prixLitteraire=" + prixLitteraire +
                "} " + super.toString();
    }
}
