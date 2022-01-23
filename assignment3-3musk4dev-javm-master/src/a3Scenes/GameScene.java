package a3Scenes;

import a3App.View;
import a3Panels.GamePanel;
import a3Resizables.RelButton;
import a3Resizables.RelGroup;
import a3Resizables.RelLabel;
import a3Resizables.RelTableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class GameScene extends AppScene{
	private static BoardScene boardScene;
	private static TurnScene turnScene;
	public static RelLabel turnLabel = new RelLabel("");
	private static RelButton undoButton = new RelButton("Undo", false);
	private static RelButton redoButton = new RelButton("Redo", false);

	@Override
	protected void buildScene() {
		// TODO Auto-generated method stub
		GameScene.boardScene = new BoardScene();
		GameScene.updateinitBoardGUI();
		GameScene.turnScene = new TurnScene();
		RelGroup boardLayout = new RelGroup();
		RelGroup turnsRoot = (RelGroup) GameScene.turnScene.getRoot();
		GameScene.undoButton = new RelButton("Undo", false);
		GameScene.redoButton = new RelButton("Redo", false);
		RelButton saveButton = new RelButton("Save", false);
		RelButton homeButton = new RelButton("Home", false);
		GamePanel panel = new GamePanel();

		// The last argument here is to make sure that the boardLayout is a square
		boardLayout.setRelXYWH(0.2, 0.15, 0.6, 0.6 * View.getInstance().getOrigWidth()/View.getInstance().getOrigHeight());
		boardLayout.getChildren().addAll(GameScene.boardScene.getRoot());
		GameScene.undoButton.setRelXYWH(0.15, 0.85, 0.25, 0.1);
		GameScene.redoButton.setRelXYWH(0.6, 0.85, 0.25, 0.1);
		saveButton.setRelXYWH(0.725, 0.025, 0.25, 0.0875);
		homeButton.setRelXYWH(0.025, 0.025, 0.25, 0.0875);
		GameScene.turnLabel.setRelXYWH(0, 0, 1, 0.15);
		GameScene.turnLabel.setText("");
		turnsRoot.setRelXYWH(0.1, 0.65, 0.8, 0.175);

		GameScene.undoButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		GameScene.redoButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		homeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		GameScene.boardScene.attachPanel(MouseEvent.MOUSE_CLICKED, panel);
		
		((RelGroup) this.getRoot()).getChildren().addAll(boardLayout, GameScene.turnLabel, turnsRoot, undoButton, redoButton, saveButton, homeButton);
		
	}

	public static void updateinitBoardGUI() {
		GameScene.boardScene.updatePreview(BoardSelectionScene.getBoardScene().getBoard());
	}

	public static BoardScene getBoardScene() {
		return GameScene.boardScene;
	}

	public static RelButton getUndoButton() {
		return GameScene.undoButton;
	}

	public static RelButton getRedoButton() {
		return GameScene.redoButton;
	}
	
	public static TurnScene getTurnScene() {
		return GameScene.turnScene;
	}

}
