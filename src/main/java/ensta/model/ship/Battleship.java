package ensta.model.ship;

import ensta.util.Orientation;

public class Battleship extends AbstractShip {

    public Battleship() {
        super('B', "Battleship", 4, Orientation.EAST);
    }

    public Battleship(Orientation sens) {
        super('B', "Battleship", 4, sens);
    }

}