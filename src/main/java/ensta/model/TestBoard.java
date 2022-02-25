package ensta.model;

import ensta.util.Orientation;
import ensta.model.ship.*;

public class TestBoard {
    public static void main(String args[]) {
        Board grille = new Board("grille 1");
        Submarine sub = new Submarine(Orientation.EAST);
        Destroyer des = new Destroyer(Orientation.WEST);
        Carrier car = new Carrier(Orientation.NORTH);
        Battleship bat = new Battleship(Orientation.SOUTH);
        Coords c1 = new Coords(0, 0);
        Coords c2 = new Coords(3, 1);
        Coords c21 = new Coords(2, 1);
        Coords c3 = new Coords(8, 7);
        Coords c4 = new Coords(7, 3);

        grille.putShip(sub, c1);
        grille.putShip(des, c2);
        grille.putShip(bat, c4);
        grille.putShip(car, c3);

        System.out.println(grille.sendHit(c2));

        System.out.println(grille.getHit(c2));
        System.out.println(grille.sendHit(c2));
        grille.print();
        System.out.println(grille.sendHit(c21));

        System.out.println(grille.getHit(c21));
        grille.print();

    }
}