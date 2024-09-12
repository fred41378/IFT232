package labo1;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NuagePoints extends Dessin {

    private final ArrayList<Point> points;


    public NuagePoints() {
        points = new ArrayList<>();
    }
    public void dessiner(Graphics2D graph){
        for (Point p : points) {
            p.dessiner(graph);
        }
    }

    public void lire(Scanner reader){
        int valeurInitiale = reader.nextInt();
        for (int i = valeurInitiale ; i > 0; i--) {
            Point p = new Point();
            p.lire(reader);
            points.add(p);
        }
    }

    public String toString(){
        String result = "";
        for (int i = 0; i < points.size(); i++) {
            result += points.get(i).toString() + "\n";
        }
        return result.toString();
    }
}
