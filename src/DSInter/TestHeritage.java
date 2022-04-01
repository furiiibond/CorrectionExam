package DSInter;

import TD2.Document;
import TD2.Livre;
import TD2.Revue;

public class TestHeritage {
    public static void main(String[] args) {
        Document v = new Document(100, "tintin");
        Livre c = new Livre(150, "test", 120, "jc");
        Revue b = new Revue(140, "scence et vie", 12, 2022);
        v = c;
        c = (Livre) v;

    }
}
