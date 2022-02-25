package ensta.model;

import java.io.Serializable;

import java.util.List;

import ensta.model.ship.AbstractShip;
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
		boolean done = false, done2 = false;
		int i = 0;

		do {
			AbstractShip ship = ships[i];
			do {
				String msg = String.format("placer %d : %s(%d)", i + 1, ship.getName(), ship.getTaille());
				System.out.println(msg);
				InputHelper.ShipInput res = InputHelper.readShipInput();
				Orientation sens = Orientation.fromString(res.orientation);
				ship.setSens(sens);
				done2 = board.putShip(ship, new Coords(res.x,res.y));
	
				// TODO set ship orientation
				// TODO put ship at given position
				// TODO when ship placement successful
			} while (!done2);
			done2 = false;
			++i;
			done = i == 5;

			board.print();
		} while (!done);
	}

	public Hit sendHit(Coords coords) {
		System.out.println("où frapper?");
		InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
		Coords send = new Coords(hitInput.x, hitInput.y);
		// TODO call sendHit on this.opponentBoard
		Hit result = this.opponentBoard.sendHit(send);
		coords.setCoords(send);
			// TODO : Game expects sendHit to return BOTH hit result & hit coords.
			// return hit is obvious. But how to return coords at the same time ?
		
		return result;
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
