package events;


/**
 * Chapter 6: Training using a Genetic Algorithm
 * 
 * City: Holds the location of a city for the traveling salesman problem.
 * 
 * @author Jeff Heaton
 * @version 2.1
 */
class City {

	/**
	 * The city's x position.
	 */
	int xpos;

	/**
	 * The city's y position.
	 */
	int ypos;

	/**
	 * Constructor.
	 * 
	 * @param x
	 *            The city's x position
	 * @param y
	 *            The city's y position.
	 */
	City(final int x, final int y) {
		this.xpos = x;
		this.ypos = y;
	}

	/**
	 * Return's the city's x position.
	 * 
	 * @return The city's x position.
	 */
	int getx() {
		return this.xpos;
	}

	/**
	 * Returns the city's y position.
	 * 
	 * @return The city's y position.
	 */
	int gety() {
		return this.ypos;
	}

	/**
	 * Returns how close the city is to another city.
	 * 
	 * @param cother
	 *            The other city.
	 * @return A distance.
	 */
	int proximity(final City cother) {
		return proximity(cother.getx(), cother.gety());
	}

	/**
	 * Returns how far this city is from a a specific point. This method uses
	 * the pythagorean theorum to calculate the distance.
	 * 
	 * @param x
	 *            The x coordinate
	 * @param y
	 *            The y coordinate
	 * @return The distance.
	 */
	int proximity(final int x, final int y) {
		final int xdiff = this.xpos - x;
		final int ydiff = this.ypos - y;
		return (int) Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}
}
