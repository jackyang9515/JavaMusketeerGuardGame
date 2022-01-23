package a3Resizables;

import javafx.scene.Group;
import javafx.scene.Node;

/**
 * Resizable Group class. Works more like a box class containing its children.
 *
 */
public class RelGroup extends Group implements Resizable{
	private RelViewCoords relCoords = new RelViewCoords();

	/** Resizes all the children of the instance with their corresponding relative coordinates to the entire screen.
	 */
	@Override
	public void relResize(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		for (Node child: this.getChildren()) {
			if (child instanceof Resizable) {
				((Resizable) child).relResize(
						x + w * this.relCoords.getX(),
						y + h * this.relCoords.getY(),
						w * this.relCoords.getW(),
						h * this.relCoords.getH());
				
			}
		}
	}

	@Override
	public void setRelX(double x) {
		// TODO Auto-generated method stub
		this.relCoords.setX(x);
	}

	@Override
	public void setRelY(double y) {
		// TODO Auto-generated method stub
		this.relCoords.setY(y);
	}

	@Override
	public void setRelW(double w) {
		// TODO Auto-generated method stub
		this.relCoords.setW(w);
	}

	@Override
	public void setRelH(double h) {
		// TODO Auto-generated method stub
		this.relCoords.setH(h);
	}

	@Override
	public double getRelX() {
		// TODO Auto-generated method stub
		return this.relCoords.getX();
	}

	@Override
	public double getRelY() {
		// TODO Auto-generated method stub
		return this.relCoords.getY();
	}

	@Override
	public double getRelW() {
		// TODO Auto-generated method stub
		return this.relCoords.getW();
	}

	@Override
	public double getRelH() {
		// TODO Auto-generated method stub
		return this.relCoords.getH();
	}

	@Override
	public void setRelXYWH(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		this.setRelX(x);
		this.setRelY(y);
		this.setRelW(w);
		this.setRelH(h);
	}

}
