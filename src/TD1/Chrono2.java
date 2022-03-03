package TD1;

public class Chrono2 {
    private int nbSecondes;

    public Chrono2 (){
        nbSecondes = 0;
    }

    public boolean rebours(){
        if (this.nbSecondes==0){
            return false;
        } else {
            this.nbSecondes--;
            return true;
        }
    }

    public int getHeures() {
        return nbSecondes/360;
    }

    public void setHeures(int heures) {
        this.nbSecondes = getSecondes()+getMinutes()+heures*3600;
    }

    public int getMinutes() {
        return (nbSecondes/60)%60;
    }

    public void setMinutes(int minutes) {
        this.nbSecondes = getSecondes()+getHeures()+minutes*60;
    }

    public int getSecondes() {
        return nbSecondes%60;
    }

    public void setSecondes(int secondes) {
        this.nbSecondes = getHeures()+getMinutes()+secondes;
    }
}
