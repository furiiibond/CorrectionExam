package DSInter;

public class TestQ1 {
    public static void main(String[] args) {
        int a = 1, b = 1, c=2;
        int x = a | 4 + c >> b & 7 | b >> a % 3;
        System.out.println(x);
        b = 2;
        x = a | 4 + c >> b & 7 | b >> a % 3;
        System.out.println(x) ;
    }
}
