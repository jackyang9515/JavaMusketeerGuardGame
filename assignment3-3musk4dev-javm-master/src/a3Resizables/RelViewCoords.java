package a3Resizables;

import a3App.View;

/**
 * The relative coordinate class. To be used in concrete Resizables.
 *
 */
public class RelViewCoords {
	/** Relative x-coordinate to the parent object */
	private double x = 0;

	/** Relative y-coordinate to the parent object */
	private double y = 0;

	/** Relative width to the parent object */
	private double w = 1;

	/** Relative height to the parent object */
	private double h = 1;

	/** Getter of the relative x-coordinate to the parent object
	 * @return the relative x-coordinate to the parent object
	 */
	public double getX() {
		return x;
	}
	
	
	/** Setter of the relative x-coordinate to the parent object
	 * @param x: the relative x-coordinate to the parent object
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/** Getter of the relative y-coordinate to the parent object
	 * @return the relative y-coordinate to the parent object
	 */
	public double getY() {
		return y;
	}

	/** Setter of the relative y-coordinate to the parent object
	 * @param y: the relative y-coordinate to the parent object
	 */
	public void setY(double y) {
		this.y = y;
	}

	/** Getter of the relative width to the parent object
	 * @return the relative width to the parent object
	 */
	public double getW() {
		return w;
	}

	/** Setter of the relative width to the parent object
	 * @param w: the relative width to the parent object
	 */
	public void setW(double w) {
		this.w = w;
	}

	/** Getter of the relative height to the parent object
	 * @return the relative height to the parent object
	 */
	public double getH() {
		return h;
	}
	
	/** Setter of the relative height to the parent object
	 * @param h: the relative height to the parent object
	 */
	public void setH(double h) {
		this.h = h;
	}

	/** Getter of the absolute x-coordinate in the stage (not the screen)
	 * @param relX: Relative x-coordinate to the screen
	 * @return the absolute x-coordinate
	 */
	public double getAbsX(double relX) {
		return relX * (View.getStage().getWidth() - View.widthPadding);
		
	}

	/** Getter of the absolute y-coordinate in the stage (not the screen)
	 * @param relY: Relative y-coordinate to the screen
	 * @return the absolute y-coordinate
	 */
	public double getAbsY(double relY) {
		return relY * (View.getStage().getHeight() - View.heightPadding);
	}
	
	/** Getter of the absolute width in the stage (not the screen)
	 * @param relW: Relative width to the screen
	 * @return the absolute width
	 */
	public double getAbsW(double relW) {
		return relW * (View.getStage().getWidth() - View.widthPadding);
	}

	/** Getter of the absolute height in the stage (not the screen)
	 * @param relW: Relative height to the screen
	 * @return the absolute height
	 */
	public double getAbsH(double relH) {
		return relH * (View.getStage().getHeight() - View.heightPadding);
	}

}
