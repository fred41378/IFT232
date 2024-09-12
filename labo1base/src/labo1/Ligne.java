package labo1;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Ligne extends Dessin {

    private final Point depart;
    private final Point fin;

    public Ligne(){
        depart = new Point();
        fin = new Point();
    }

    public void dessiner(Graphics2D graph){
        graph.drawLine(depart.getX(),depart.getY(),fin.getX(),fin.getY());
    }

    public void lire(Scanner reader){
        depart.lire(reader);
        fin.lire(reader);
    }

    public String toString(){
        return "("+depart.getX()+","+depart.getY()+") -> (" +fin.getX()+","+fin.getY()+")";
    }
}
