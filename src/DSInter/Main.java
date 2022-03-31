package DSInter;

public class Main {
    public static void main(String[] args) {
        MotBinaire nouveau = new MotBinaire(3);
        nouveau.setBit(0, 0);
        nouveau.setBit(1,1);
        nouveau.setBit(2,1);
        System.out.println(nouveau.getValeur());
    }
}