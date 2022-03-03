package TD2;

import java.util.List;

public class Biblioteque {
    List<Document> documents;

    public void afficherAuteurs() {
        for (Document document : documents){
            if (document.asAutor()){
                Livre livre = (Livre) document;
                System.out.println(livre.getAuteur());
            }
        }
    }
}
