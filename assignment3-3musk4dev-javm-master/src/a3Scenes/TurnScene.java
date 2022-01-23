package a3Scenes;

import java.util.ArrayList;
import java.util.List;

import a3App.View;
import a3Resizables.RelGroup;
import a3Resizables.RelTableColumn;
import a3Resizables.RelTableView;
import assignment1.Cell;
import assignment1.Coordinate;
import assignment1.Move;
import assignment1.MoveTurn;
import assignment1.MovesHistory;
import assignment1.Piece;
import assignment1.ThreeMusketeers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class TurnScene extends AppScene {
	private static RelTableView<MoveTurn> turnsTable;
	public int currentTurnIndex = -1;

	@Override
	protected void buildScene() {
		this.refreshTurnsTable(new MovesHistory());
	}

	// TODO: Add a static method to refresh turnsTable
	
	public void refreshTurnsTable(MovesHistory movesList) {
		// Example
		// =======================================================
		//     Turn	   |  Player	|	From Move	|	To Move
		// 		1			GUARD			C5			  D5
		
		ObservableList<MoveTurn> moves = FXCollections.observableArrayList(movesList.getMoves());
		
		TurnScene.turnsTable = new RelTableView<MoveTurn>(moves);
		TurnScene.turnsTable.setItems(moves);

		RelTableColumn<MoveTurn, String> turn = new RelTableColumn<>("Turn");
		turn.setCellValueFactory(new PropertyValueFactory<>("Turn"));
		turn.setSortable(false);
		turn.setRelW(0.2);
		
		RelTableColumn<MoveTurn, String> piece = new RelTableColumn<>("Piece");
		piece.setCellValueFactory(new PropertyValueFactory<>("Piece"));
		piece.setSortable(false);
		piece.setRelW(0.3);

		RelTableColumn<MoveTurn, String> fromCol = new RelTableColumn<>("From");
		fromCol.setCellValueFactory(new PropertyValueFactory<>("FromCellCoord"));
		fromCol.setSortable(false);
		fromCol.setRelW(0.25);

		RelTableColumn<MoveTurn, String> toCol = new RelTableColumn<>("To");
		toCol.setCellValueFactory(new PropertyValueFactory<>("ToCellCoord"));
		toCol.setSortable(false);
		toCol.setRelW(0.25);
		
		TableViewSelectionModel selectionModel = TurnScene.turnsTable.getSelectionModel();
		selectionModel.select(currentTurnIndex);
//		TurnScene.turnsTable.setNoRows(5);

		TurnScene.turnsTable.getColumns().setAll(turn, piece, fromCol, toCol);

		((RelGroup) this.getRoot()).getChildren().add(TurnScene.turnsTable);
		 
	}

}
