package ensta.model.ship;

import ensta.util.Orientation;

public class Destroyer extends AbstractShip {

    public Destroyer() {
        super('D', "Destroyer", 2, Orientation.EAST);
    }

    public Destroyer(Orientation sens) {
        super('D', "Destroyer", 2, sens);
    }

}