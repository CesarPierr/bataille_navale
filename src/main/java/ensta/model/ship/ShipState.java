package ensta.model.ship;

import ensta.model.ship.AbstractShip;

public class ShipState {
    private AbstractShip ship;
    private boolean struck;

    public ShipState() {
        this(null);
    }

    public ShipState(AbstractShip ship) {
        this.ship = ship;
        this.struck = false;
    }

    public boolean isStruck() {
        return struck;
    }

    public void setStruck(boolean struck) {
        this.struck = struck;
        if (ship != null)
            ship.addStrike();
    }

    @Override
    public String toString() {
        return String.valueOf(this.ship.getLabel());
    }

    public boolean isSunk() {
        return this.ship.isSunk();
    }

    public AbstractShip getShip() {
        return this.ship;
    }
}
