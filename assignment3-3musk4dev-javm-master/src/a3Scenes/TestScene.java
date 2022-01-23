package a3Scenes;

import java.util.ArrayList;
import java.util.List;

import a3App.View;
import a3Resizables.RelGroup;
import a3Resizables.RelImgView;
import a3Resizables.RelTableColumn;
import a3Resizables.RelTableView;
import a3Resizables.RelTextField;
import assignment1.Cell;
import assignment1.Coordinate;
import assignment1.Move;
import assignment1.MoveTurn;
import assignment1.Piece;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

/**
 * A scene merely for testing purposes. Feel free to play around with this scene and build stuff
 *
 */
public class TestScene extends AppScene{

	public TestScene() {
		super();
		// TODO Auto-generated constructor stub
		RelGroup box = new RelGroup();
		box.setRelXYWH(0.25, 0.25, 0.5, 0.5);
		RelTextField tf = new RelTextField();
		tf.setRelXYWH(0, 0, 1, 0.1);
		box.getChildren().add(tf);
		((RelGroup) this.getRoot()).getChildren().add(box);
	}

	@Override
	protected void buildScene() {
		// TODO Auto-generated method stub
	}

}
