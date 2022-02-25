package ensta.model;

import java.util.Random;

public class Coords {
    private int X;
    private int Y;

    public Coords() {
    }

    public Coords(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return this.X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return this.Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public void setCoords(Coords newCoords) {
        this.X = newCoords.getX();
        this.Y = newCoords.getY();
    }

    public static Coords randomCoords(int x_max, int y_max) {
        Random x = new Random();
        Random y = new Random();
        Coords ret = new Coords(x.nextInt(x_max), y.nextInt(y_max));
        return ret;
    }

    public boolean isInBoard(int size) {
        if (this.X >= 0 && this.X < size && this.Y >= 0 && this.Y < size)
            return true;
        return false;
    }
}
