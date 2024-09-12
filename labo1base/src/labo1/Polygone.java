package labo1;

import java.awt.*;
        import java.util.ArrayList;
import java.util.Scanner;

public class Polygone extends Dessin {

    private final ArrayList<Ligne> lignes;


    public Polygone() {
        lignes = new ArrayList<>();
    }

    public void dessiner(Graphics2D graph){
        for (Ligne l : lignes) {
            l.dessiner(graph);
        }
    }

    public void lire(Scanner reader){
        int valeurInitiale = reader.nextInt();
        for (int i = valeurInitiale ; i > 0; i--) {
            Ligne l = new Ligne();
            l.lire(reader);
            lignes.add(l);
        }
    }

    public String toString(){
        String result = "";
        for (int i = 0; i < lignes.size(); i++) {
            result += lignes.get(i).toString() + "\n";
        }
        return result.toString();
    }
}
