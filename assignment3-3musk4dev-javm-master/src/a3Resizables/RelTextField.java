package a3Resizables;

import a3App.View;
import javafx.scene.control.TextField;

public class RelTextField extends TextField implements Resizable {

	private RelViewCoords relCoords = new RelViewCoords();


	/** Resizes the rectangle and updates the color of it according to the theme.
	 */
	@Override
	public void relResize(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		this.setLayoutX(this.relCoords.getAbsX(x + w * this.relCoords.getX()));
		this.setLayoutY(this.relCoords.getAbsY(y + h * this.relCoords.getY()));
		this.setPrefWidth(this.relCoords.getAbsW(w * this.relCoords.getW()));
		this.setPrefHeight(this.relCoords.getAbsH(h * this.relCoords.getH()));
		this.setStyle("-fx-font-size: " + 1.5 * (View.getStage().getHeight() - View.heightPadding)/(View.getInstance().getOrigHeight()) + "em;");
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
