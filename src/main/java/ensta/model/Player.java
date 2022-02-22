package ensta.model;

import java.io.Serializable;
import java.util.List;
import java.util.Arrays;
import ensta.model.AbstractShip;
import ensta.util.Orientation;
import ensta.view.InputHelper;
import ensta.view.InputHelper.ShipInput;

public class Player {
	/*
	 * ** Attributs
	 */
	private Board board;
	protected Board opponentBoard;
	private int destroyedCount;
	protected AbstractShip[] ships;
	private boolean lose;

	/*
	 * ** Constructeur
	 */
	public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
		this.setBoard(board);
		this.ships = ships.toArray(new AbstractShip[0]);
		this.opponentBoard = opponentBoard;
	}

	/*
	 * ** Méthodes
	 */

	/**
	 * Read keyboard input to get ships coordinates. Place ships on given
	 * coodrinates.
	 */
	public void putShips() {
		boolean done = false;
		int i = 0;
		String[] validOrientations = { "north", "south", "east", "west" };
		do {

			AbstractShip ship = ships[i];
			boolean placed = false;
			do {
				String msg = String.format("placer %d : %s(%d)", i + 1, ship.getName(), ship.getTaille());
				System.out.println(msg);
				Orientation sens = Orientation.EAST;
				Coords place = new Coords();
				InputHelper.ShipInput res = InputHelper.readShipInput();
				switch (Arrays.asList(validOrientations).indexOf(res.orientation)) {
					case 0:
						sens = Orientation.NORTH;
						break;
					case 1:
						sens = Orientation.SOUTH;
						break;
					case 2:
						sens = Orientation.EAST;
						break;
					case 3:
						sens = Orientation.WEST;
						break;
				}
				ship.setSens(sens);
				place.setX(res.x);
				place.setY(res.y);
				placed = this.board.putShip(ship, place);
			} while (!placed);
			board.print();
			++i;
			done = i == 5;

			board.print();
		} while (!done);
	}

	public Hit sendHit(Coords coords) {
		boolean done = false;
		Hit hit = null;

		do {
			System.out.println("où frapper?");
			InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
			// TODO call sendHit on this.opponentBoard

			// TODO : Game expects sendHit to return BOTH hit result & hit coords.
			// return hit is obvious. But how to return coords at the same time ?
		} while (!done);

		return hit;
	}

	public AbstractShip[] getShips() {
		return ships;
	}

	public void setShips(AbstractShip[] ships) {
		this.ships = ships;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getDestroyedCount() {
		return destroyedCount;
	}

	public void setDestroyedCount(int destroyedCount) {
		this.destroyedCount = destroyedCount;
	}

	public boolean isLose() {
		return lose;
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}
}
