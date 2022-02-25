package ensta.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Orientation {
	SOUTH(1), NORTH(-1), WEST(-1), EAST(1);

	private static final List<Orientation> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	private int increment;

	private Orientation(int increment) {
		this.increment = increment;
	}
	
	public int getIncrement() {
		return increment;
	}
	
	public static Orientation fromString(String sens) {
		if(sens.equals("north"))
			return Orientation.NORTH;
		else if (sens.equals("south"))
			return Orientation.SOUTH;
		else if (sens.equals("east"))
			return Orientation.EAST;
		else if (sens.equals("west"))
			return Orientation.WEST;
		return Orientation.EAST;
	}

	public static Orientation randomOrientation() {
		Orientation sens = VALUES.get(RANDOM.nextInt(SIZE));
		return sens;
	}
}