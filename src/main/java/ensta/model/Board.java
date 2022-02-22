package ensta.model;

import ensta.model.IBoard;
import ensta.util.Orientation;

public class Board implements IBoard {

    private String name;
    private char[][] ship_board;
    private boolean[][] touched;
    private int width, height;

    public Board(String name, int height, int width) {
        this.name = name;
        this.ship_board = new char[height][width];
        this.touched = new boolean[height][width];
        this.width = width;
        this.height = height;
        for (int row = 0; row < this.height; row++) {

            for (int col = 0; col < this.width; col++) {
                this.ship_board[row][col] = '.';
                this.touched[row][col] = false;
            }
        }
    }

    public Board(String name) {
        this.name = name;
        this.ship_board = new char[10][10];
        this.touched = new boolean[10][10];
        this.width = 10;
        this.height = 10;
        for (int row = 0; row < this.height; row++) {

            for (int col = 0; col < this.width; col++) {
                this.ship_board[row][col] = '.';
                this.touched[row][col] = false;
            }
        }
    }

    public char[][] getShip_board() {
        return this.ship_board;
    }

    public void setShip_board(char[][] ship_board) {
        this.ship_board = ship_board;
    }

    public boolean[][] getTouched() {
        return this.touched;
    }

    public void setTouched(boolean[][] touched) {
        this.touched = touched;
    }

    public String get_name() {
        return this.name;
    }

    public void set_name(String new_name) {
        this.name = new_name;
    }

    public void print() {

        System.out.print("Navires :");
        for (int i = 0; i < width - 2; i++)
            System.out.print("   ");
        System.out.println("Frappes :");

        for (int row = 0; row <= this.height; row++) {

            int largeur = this.width + 1;
            for (int col = 0; col <= 2 * largeur - 1; col++) {
                if (row == 0 && col % largeur >= 1) {
                    System.out.printf("%3c", (char) (col % largeur + 64));
                } else if (row == 0 && col % largeur == 0) {
                    System.out.print("   ");
                } else if (col % largeur == 0 && row >= 1) {
                    System.out.printf("%3d", row);
                } else {
                    if (col / largeur == 0)
                        System.out.printf("%3c", this.ship_board[col - 1][row - 1]);
                    else if (col / largeur >= 1) {
                        boolean value = this.touched[col % largeur - 1][row - 1];
                        if (value) {
                            System.out.printf("%3c", 'x');
                        } else {
                            System.out.printf("%3c", '.');
                        }
                    }

                }
                if (col == largeur - 1)
                    System.out.print("   ");
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }

    @Override
    public int getSize() {
        return this.width;
    }

    @Override
    public boolean putShip(AbstractShip ship, Coords coords) {
        Orientation sens = ship.getSens();
        if (!this.canPutShip(ship, coords))
            return false;

        switch (sens) {
            case EAST:
                for (int i = 0; i < ship.getTaille(); i++) {
                    this.ship_board[coords.getX() + i][coords.getY()] = ship.getLabel();
                }
                break;
            case WEST:
                for (int i = 0; i < ship.getTaille(); i++) {
                    this.ship_board[coords.getX() - i][coords.getY()] = ship.getLabel();
                }
                break;
            case NORTH:
                for (int i = 0; i < ship.getTaille(); i++) {
                    this.ship_board[coords.getX()][coords.getY() - i] = ship.getLabel();
                }
                break;
            case SOUTH:
                for (int i = 0; i < ship.getTaille(); i++) {
                    this.ship_board[coords.getX()][coords.getY() + i] = ship.getLabel();
                }
                break;
        }
        return true;
    }

    @Override
    public boolean hasShip(Coords coords) {
        if (this.ship_board[coords.getX()][coords.getY()] != '.')
            return true;
        return false;
    }

    @Override
    public void setHit(boolean hit, Coords coords) {
        this.touched[coords.getX()][coords.getY()] = hit;
    }

    @Override
    public Boolean getHit(Coords coords) {
        return this.touched[coords.getX()][coords.getY()];
    }

    @Override
    public Hit sendHit(Coords res) {
        if (this.ship_board[res.getX()][res.getY()] == '.')
            return Hit.MISS;
        this.setHit(true, res);
        return Hit.STRIKE;
    }

    @Override
    public boolean canPutShip(AbstractShip ship, Coords coords) {
        Orientation sens = ship.getSens();
        if (coords.getX() < 0 || coords.getX() >= this.width || coords.getY() < 0 || coords.getY() >= this.height) {
            System.out.println("wrong coord X or Y");
            return false;
        }
        switch (sens) {
            case EAST:
                if (coords.getX() + ship.getTaille() > this.width)
                    return false;

                for (int i = 0; i < ship.getTaille(); i++) {
                    if (this.ship_board[coords.getX() + i][coords.getY()] != '.')
                        return false;
                }
                break;
            case WEST:
                if (coords.getX() - ship.getTaille() < -1)
                    return false;

                for (int i = 0; i < ship.getTaille(); i++) {
                    if (this.ship_board[coords.getX() - i][coords.getY()] != '.')
                        return false;
                }
                break;
            case NORTH:
                if (coords.getY() - ship.getTaille() < -1)
                    return false;

                for (int i = 0; i < ship.getTaille(); i++) {
                    if (this.ship_board[coords.getX()][coords.getY() - i] != '.')
                        return false;
                }
                break;
            case SOUTH:
                if (coords.getY() + ship.getTaille() > this.height)
                    return false;

                for (int i = 0; i < ship.getTaille(); i++) {
                    if (this.ship_board[coords.getX()][coords.getY() + i] != '.')
                        return false;
                }
                break;
        }
        return true;
    }

}
