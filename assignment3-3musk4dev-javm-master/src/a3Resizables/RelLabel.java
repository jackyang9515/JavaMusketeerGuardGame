package a3Resizables;

import a3App.View;
import a3Themes.AppTheme;
import a3Utils.Utils;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * A resizable label class (RelLabel = Relative Label)
 *
 */
public class RelLabel extends Label implements Resizable{
	private RelViewCoords relCoords = new RelViewCoords();
	private double relFontSize = 1;

	/** Centers the text in the label as default
	 * @param text: The text to be shown.
	 */
	public RelLabel(String text) {
		super(text);
		this.setAlignment(Pos.CENTER);
	}


	/** Updates the absolute coordinates and size of the label.
	 * Updates the size of the text and the theme of the label according to the View instance.
	 */
	@Override
	public void relResize(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		this.setLayoutX(this.relCoords.getAbsX(x + w * this.relCoords.getX()));
		this.setLayoutY(this.relCoords.getAbsY(y + h * this.relCoords.getY()));
		this.setPrefWidth(this.relCoords.getAbsW(w * this.relCoords.getW()));
		this.setPrefHeight(this.relCoords.getAbsH(h * this.relCoords.getH()));
		AppTheme theme = View.getCurrTheme();
		this.setFont(Font.font(theme.getFontName(), this.relFontSize * theme.getRelFontSize() * this.relCoords.getAbsH(h * this.relCoords.getH())));
		this.setTextFill(theme.getTextColor());
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


	public void setRelFontSize(double relFontSize) {
		this.relFontSize = relFontSize;
	}

}
