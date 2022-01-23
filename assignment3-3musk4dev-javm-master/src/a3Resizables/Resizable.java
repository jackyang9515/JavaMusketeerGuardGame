package a3Resizables;

/**
 * A resizable interface for rect objects.
 * Concrete classes will have a RelViewCoords as their attribute, and the methods in this interface will make use of that class. See RelViewCoords for details.
 * A relative window has x, y, w, h.
 * x and y are the relative xy positions in the screen (not the stage). Usually they are 0 to 1 inclusive.
 * w and h are the relative size parameters for the rect in the screen. Usually they are 0 to 1 inclusive.
 * 1 means the width or height of the screen, while 0 means 0.
 */
public interface Resizable {
	/** Resizes the Resizable by adjusting the absolute coordinates and size of the object
	 * This is called whenever the stage is resized.
	 * 
	 * @param x: The relative x-coordinate of the parent to the entire screen.
	 * @param y: The relative y-coordinate of the parent to the entire screen.
	 * @param w: The relative width of the parent to the entire screen.
	 * @param h: The relative height of the parent to the entire screen.
	 */
	void relResize(double x, double y, double w, double h);

	/** Setter of the relative x-coordinate of the current object.
	 * @param x: The new relative x-coordinate
	 */
	void setRelX(double x);

	/** Setter of the relative y-coordinate of the current object.
	 * @param x: The new relative x-coordinate
	 */
	void setRelY(double y);
	
	/** Setter of the relative width of the current object.
	 * @param w: The new relative width
	 */
	void setRelW(double w);

	/** Setter of the relative height of the current object.
	 * @param h: The new relative height
	 */
	void setRelH(double h);
	
	/** Sets all relative parameters at once. It is equivalent as setting the parameters individually.
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	void setRelXYWH(double x, double y, double w, double h);
	
	/** Getter of the relative x-coordinate of the object
	 * @return the relative x-coordinate
	 */
	double getRelX();
	
	/** Getter of the relative y-coordinate of the object
	 * @return the relative y-coordinate
	 */
	double getRelY();

	/** Getter of the relative width of the object
	 * @return the relative width
	 */
	double getRelW();

	/** Getter of the relative height of the object
	 * @return the relative height
	 */
	double getRelH();
}
