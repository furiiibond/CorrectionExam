package TD3;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("LOADING");
        Scanner scan  = new Scanner(System.in);

        System.out.print("[");
        for (int i = 0; i < 50; i++) {
            Thread.sleep(300);
            System.out.print(".");
        }
        System.out.println("ERRORRR");
        //System.out.println("---------------------> Let's go");
        System.out.println("PRESS A KEY TO EXIT");
        System.out.println(scan.next());

    }
}
