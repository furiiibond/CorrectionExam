package DSInter;

import TP.TP3.Commande;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
    public static void main(String[] args) {
        List<String> listeFruits = new ArrayList<>();
        listeFruits.add("Pomme");
        listeFruits.add("Bannane");
        listeFruits.add("Poire");
        Iterator<String> it = listeFruits.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("WITH FOR LOOP");
        for (Iterator<String> iterator = listeFruits.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
}