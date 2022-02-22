package ensta.model;

import ensta.util.Orientation;

public class Carrier extends AbstractShip {

    public Carrier() {
        super('S', "Carrier", 5, Orientation.EAST);
    }

    public Carrier(Orientation sens) {
        super('S', "Carrier", 5, sens);
    }

}