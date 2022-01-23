package a3Resizables;

import a3App.View;
import assignment1.MoveTurn;
import javafx.collections.ObservableList;
import javafx.scene.control.Skin;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.control.skin.TableViewSkinBase;
import javafx.scene.layout.Pane;

public class RelTableView<T> extends TableView<T> implements Resizable {

	private RelViewCoords relCoords = new RelViewCoords();
	private int noRows = 1;

	public RelTableView(ObservableList<T> tList) {
		super(tList);
	}

	@Override
	public void relResize(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		this.setLayoutX(this.relCoords.getAbsX(x + w * this.relCoords.getX()));
		this.setLayoutY(this.relCoords.getAbsY(y + h * this.relCoords.getY()));
		this.setPrefWidth(this.relCoords.getAbsW(w * this.relCoords.getW()));
		this.setPrefHeight(this.relCoords.getAbsH(h * this.relCoords.getH()));
		this.setStyle("-fx-font-size: " + (View.getStage().getHeight() - View.heightPadding)/(View.getInstance().getOrigHeight()) + "em");
		for (TableColumn<T, ?> column: this.getColumns()) {
			if (column instanceof Resizable) {
				((Resizable) column).relResize(0, 0, w * this.relCoords.getW(), 1);
			}
		}
		this.setFixedCellSize(1.0/this.noRows * (this.relCoords.getAbsH(h * this.relCoords.getH() * ((this.noRows - 1.0)/this.noRows)))); 
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

	public void setNoRows(int noRows) {
		this.noRows = noRows;
	}

}
