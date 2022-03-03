package TD1;

public class Main {
    public static void main(String[] args) {
        Chrono chrono1 = new Chrono();
        chrono1.setHeures(1);
        chrono1.setMinutes(30);

        while (chrono1.rebours()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(chrono1.getHeures()+":"+ chrono1.getMinutes()+":"+chrono1.getSecondes());
        }
    }
}
