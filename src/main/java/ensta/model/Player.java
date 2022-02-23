package ensta.model;

import java.io.Serializable;
import java.util.List;

import ensta.model.AbstractShip;
import ensta.util.Orientation;
import ensta.view.InputHelper;

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

		do {
			AbstractShip ship = ships[i];
			String msg = String.format("placer %d : %s(%d)", i + 1, ship.getName(), ship.getTaille());
			System.out.println(msg);
			InputHelper.ShipInput res = InputHelper.readShipInput();
			// TODO set ship orientation
			// TODO put ship at given position
			// TODO when ship placement successful
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
			Coords send = new Coords(hitInput.x, hitInput.y);
			// TODO call sendHit on this.opponentBoard
			Hit result = this.opponentBoard.sendHit(send);
			if (result != null) {
				System.out.println(result);
				coords = send;
				return result;
			} else {
				System.out.println("warning, can't send hit. Try again");
			}
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
