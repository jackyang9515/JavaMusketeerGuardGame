package a3Resizables;

import a3App.View;
import a3Themes.AppTheme;
import a3Utils.Utils;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;

/**
 * A resizable button class
 *
 */
public class RelButton extends Button implements Resizable {
	private RelViewCoords relCoords = new RelViewCoords();
	
	/** The switch that allows the color of some buttons to remain constant while the theme is being updated.
	 * To be used in the buttons in themesScene.
	 */
	private boolean constColor = false;

	public RelButton(String text, boolean constColor) {
		super(text);
		this.constColor = constColor;
	}


	/** Resizes the button and the text, as well as updating the theme if needed. */
	@Override
	public void relResize(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		this.setLayoutX(this.relCoords.getAbsX(x + w * this.relCoords.getX()));
		this.setLayoutY(this.relCoords.getAbsY(y + h * this.relCoords.getY()));
		this.setPrefWidth(this.relCoords.getAbsW(w * this.relCoords.getW()));
		this.setPrefHeight(this.relCoords.getAbsH(h * this.relCoords.getH()));
		AppTheme theme = View.getCurrTheme();
		if (!constColor) {
			this.setStyle("-fx-background-color: " + Utils.getHexString(theme.getSecondaryColor()) + ";-fx-background-radius: " + View.getCurrTheme().getRelButtonRadius() + "em;");
			this.setTextFill(theme.getPrimaryColor());
		}
		this.setFont(Font.font(theme.getFontName(), theme.getRelFontSize() * this.relCoords.getAbsH(h * this.relCoords.getH())));
		if (this.isDisabled()) {
			this.setOpacity(0.5);
		} else {
			this.setOpacity(1.0);
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
