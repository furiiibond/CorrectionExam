package TD1;

public class Chrono {
    private int heures;
    private int minutes;
    private int secondes;

    public Chrono(){
        heures = 0;
        minutes = 0;
        secondes = 0;
    }
    public boolean rebours(){
        if(secondes == 0){
            if(minutes==0){
                if(heures==0){
                    return false;
                } else {
                    heures--;
                    minutes=59;
                }
            } else {
                minutes--;
                secondes=59;
            }
        }else{
            secondes--;
        }
        return true;
    }
    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSecondes() {
        return secondes;
    }

    public void setSecondes(int secondes) {
        this.secondes = secondes;
    }
}
