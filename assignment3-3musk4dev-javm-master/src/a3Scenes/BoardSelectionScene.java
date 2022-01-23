package a3Scenes;

import java.io.File;

import a3App.View;
import a3Panels.BoardSelectionPanel;
import a3Resizables.RelButton;
import a3Resizables.RelGroup;
import a3Resizables.RelLabel;
import a3Resizables.RelListView;
import a3Resizables.RelRect;
import assignment1.Board;
import javafx.scene.input.MouseEvent;

public class BoardSelectionScene extends AppScene{
	private static RelListView relListView = new RelListView();
	private static BoardScene boardScene;
	private static RelLabel turnLabel = new RelLabel("");;

	@Override
	protected void buildScene() {
		// TODO Auto-generated method stub
		BoardSelectionScene.boardScene = new BoardScene();
		RelButton backButton = new RelButton("Back", false);
		RelButton nextButton = new RelButton("Next", false);
		BoardSelectionPanel panel = new BoardSelectionPanel();
		RelGroup layoutBox = new RelGroup();
		RelRect rect2 = new RelRect();
		RelGroup boardLayout = new RelGroup();
		RelLabel boardsLabel = new RelLabel("Boards");
		RelLabel previewLabel = new RelLabel("Preview");
		RelLabel heading = new RelLabel("Board Selection");
		BoardSelectionScene.initBoardsList();

		BoardSelectionScene.relListView.setRelXYWH(0, 0.2, 0.5, 0.8);
		heading.setRelXYWH(0, 0, 1, 0.2);
		boardsLabel.setRelXYWH(0, 0, 0.5, 0.2);
		previewLabel.setRelXYWH(0.5, 0, 0.5, 0.2);
		// The last argument here is to make sure that the boardLayout is a square
		boardLayout.setRelXYWH(0.5, 0.2, 0.5, 0.8 * View.getInstance().getOrigWidth()/View.getInstance().getOrigHeight());
		boardLayout.setRelY(0.2 + (0.8 - boardLayout.getRelH())/2);
		boardLayout.getChildren().addAll(BoardSelectionScene.boardScene.getRoot());
		BoardSelectionScene.turnLabel.setRelXYWH(0.5, 1.2 - boardLayout.getRelY(), 0.5, 1);
		BoardSelectionScene.turnLabel.setRelH(1 - BoardSelectionScene.turnLabel.getRelY());
		layoutBox.getChildren().addAll(BoardSelectionScene.relListView, boardsLabel, previewLabel, boardLayout, BoardSelectionScene.turnLabel);
		layoutBox.setRelXYWH(0.1, 0.2, 0.8, 0.5);
		backButton.setRelXYWH(0.1, 0.8, 0.3, 0.1);
		nextButton.setRelXYWH(0.6, 0.8, 0.3, 0.1);
		nextButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		BoardSelectionScene.relListView.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		((RelGroup) this.getRoot()).getChildren().addAll(nextButton, backButton, layoutBox, heading);
	}

	public static void initBoardsList(){
		BoardSelectionScene.relListView.getItems().clear();
		File parent = new File("boards");
		for (String file: parent.list()) {
			if (file.endsWith(".txt")) {
				BoardSelectionScene.relListView.getItems().add(file);
			}
			if (file.equals("Starter.txt")) {
				BoardSelectionScene.relListView.getSelectionModel().select(file);
			}
		}
		Board board = new Board("Boards/" + BoardSelectionScene.relListView.getSelectionModel().getSelectedItem());
		BoardSelectionScene.turnLabel.setText(board.getTurn().getType());
	}

	public static RelLabel getTurnLabel() {
		return BoardSelectionScene.turnLabel;
	}

	public static BoardScene getBoardScene() {
		return BoardSelectionScene.boardScene;
	}

	public static RelListView getListView() {
		return BoardSelectionScene.relListView;
	}

}
