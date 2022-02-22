package ensta.model;

import ensta.util.Orientation;

public abstract class AbstractShip {
	protected char label;
	protected String name;
	protected int taille;

	protected Orientation sens;

	public AbstractShip(char label, String name, int taille, Orientation sens) {
		this.label = label;
		this.name = name;
		this.taille = taille;
		this.sens = sens;
	}

	public char getLabel() {
		return label;
	}

	public String getName() {
		return name;
	}

	public int getTaille() {
		return taille;
	}

	public Orientation getSens() {
		return sens;
	}

	public void setSens(Orientation sens) {
		this.sens = sens;
	}

}