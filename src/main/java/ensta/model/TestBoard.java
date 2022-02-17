package ensta.model;
public class TestBoard {
    public static void main(String args[]) {
        Board grille = new Board("grille 1");
        Board grille2 = new Board("grille2", 10, 11);
        grille.print();
        grille2.print();
    }
}