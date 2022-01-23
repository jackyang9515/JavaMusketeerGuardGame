package a3Panels;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import a3App.View;
import a3Resizables.RelButton;
import a3Resizables.RelImgView;
import a3Resizables.Resizable;
import a3Scenes.BoardScene;
import a3Scenes.BoardSelectionScene;
import a3Scenes.GameScene;
import a3Scenes.HomeScene;
import a3Scenes.SaveScene;
import a3Scenes.SettingsScene;
import assignment1.Board;
import assignment1.Cell;
import assignment1.Coordinate;
import assignment1.HumanAgent;
import assignment1.Move;
import assignment1.ThreeMusketeers;
import assignment1.ThreeMusketeers.GameMode;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.*;

public class GamePanel extends AppPanel {

	private static ThreeMusketeers model = ThreeMusketeers.getInstance();
	private static Coordinate fromCellCoordinate;
	static String saveFileSuccess = "Saved board";
    static String saveFileExistsError = "Error: File already exists";
    static String saveFileNotTxtError = "Error: File must end with .txt";
    TextField saveFileNameTextField;
    Label saveFileErrorLabel;
	

	@Override
	public void handle(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof RelButton) {
			switch (((RelButton) e.getSource()).getText()) { //TODO
				case "Home":{
					View.getInstance().setScene(HomeScene.class.getName());
					GameScene.getTurnScene().currentTurnIndex = -1;
					model.resetMoves();
					
					break;
				}
				case "Undo":{
					GamePanel.fromCellCoordinate = null;
					GamePanel.undo();
					break;
				}
				case "Redo":{
					GamePanel.fromCellCoordinate = null;
					GamePanel.redo();
					break;
				}
				case "Save":{
					this.saveBoard();
					break;
				}
			}
		} else if (e.getSource() instanceof RelImgView) {
			Coordinate coord = GameScene.getBoardScene().getCoordinate((RelImgView) e.getSource());
			Cell cell = GamePanel.model.getBoard().getCell(coord);

			if (GamePanel.fromCellCoordinate != null && !GamePanel.model.getBoard().getPossibleCells().contains(cell)) {
				Cell fromCell = GamePanel.model.getBoard().getCell(GamePanel.fromCellCoordinate);
				((HumanAgent) GamePanel.model.getCurrAgent()).setMove(new Move(fromCell, cell));
				GamePanel.model.move();
				GameScene.getTurnScene().currentTurnIndex += 1;
				GamePanel.fromCellCoordinate = null;
			} else {
				GamePanel.fromCellCoordinate = coord;
			}
			GamePanel.updateGameScene();
		}
	}

	/**
	 * Updates all objects and embedded scenes in GameScene
	 */
	public static void updateGameScene() {
		GamePanel.updateBoardScene();
		GamePanel.updateTurnsScene();
        GameScene.getUndoButton().setDisable(GamePanel.model.getMoves().getCurrentMoveIndex() == 0);
        GameScene.getRedoButton().setDisable(!GamePanel.model.getMoves().iterator().hasNext());
		((Resizable) View.getInstance().getScene(GameScene.class.getName()).getRoot()).relResize(0, 0, 1, 1);
		
	}

	/** 
	 * Updates the BoardScene object embedded into the GameScene
	 * TODO: to complete the else-block on the bottom which handles game over situations
	 */
	private static void updateBoardScene() {
		GameScene.getBoardScene().updatePreview(GamePanel.model.getBoard());  // Refreshes BoardScene contents

		// Handles cell enabling/disabling
		GameScene.getBoardScene().disableAllCells();
		if (!GamePanel.model.getBoard().isGameOver()) {
			GameScene.turnLabel.setText(ThreeMusketeers.getInstance().getBoard().getTurn().getType());
			if (GamePanel.model.getCurrAgent() instanceof HumanAgent) {
				for (Cell cell: GamePanel.model.getBoard().getPossibleCells()) {
					GameScene.getBoardScene().getCellGUI(cell.getCoordinate()).setDisable(false);
				}
				if (GamePanel.fromCellCoordinate != null) {
					System.out.println(fromCellCoordinate);
					GameScene.getBoardScene().getCellGUI(GamePanel.fromCellCoordinate).setDisable(true);
					Board board = GamePanel.model.getBoard();
					Cell fromCell = board.getCell(fromCellCoordinate);
					for (Cell cell: board.getPossibleDestinations(fromCell)) {
						GameScene.getBoardScene().getCellGUI(cell.getCoordinate()).setDisable(false);
					}
				}
			} else {
				// In the case of computer moves, we run the move then we update the scene again
				GamePanel.model.move();
				GameScene.getTurnScene().currentTurnIndex += 1;
				GameScene.getBoardScene().updatePreview(GamePanel.model.getBoard());
				GamePanel.updateBoardScene();
				
			}
		} else {
			GameScene.turnLabel.setText(ThreeMusketeers.getInstance().getBoard().getWinner().getType() + " wins!");
			GameScene.turnLabel.setRelXYWH(0, 0.025, 1, 0.08);
		}
		
	}

	/** 
	 * TODO: Keep this method static and update the TurnsScene
     * 
	 * You can use the implementation of updateBoardScene() above as reference.
	 * 
	 * Basically:
	 * 
	 * 1. Create a static method in TurnScene.java to "refresh" the contents in the TableView,
	 *    similar to BoardScene.updatePreview(...), you would want the behavior of the
	 *    TableView object to be the same as during scene building (i.e. non-sortable, etc.)
	 * 
	 * 2. Call the static method here, and check whether it updates accordingly as we move, undo, redo.
	 * 
	 * 3. It should be safe to say that you should not consider the case where computer moves, computer
	 *    moves should already be handled in updateBoardsScene().
	 * 
	 * 
	 */
	private static void updateTurnsScene(){
		GameScene.getTurnScene().refreshTurnsTable(GamePanel.model.getMoves()); // Refreshes TurnScene's tursnTable
	}

	/**
	 * The undo handler, and updates the scene.
	 */
	private static void undo() {
        if (GamePanel.model.getMoves().getCurrentMoveIndex() == 0) {
            System.out.println("No moves to undo.");
        }
        else if (GamePanel.model.getMoves().size() == 1 || GamePanel.model.isHumansPlaying()) {
        	GamePanel.model.undoMove();
        	GameScene.getTurnScene().currentTurnIndex -= 1;
        	GamePanel.updateTurnsScene();
        }
        else {
        	GamePanel.model.undoMove();
        	GamePanel.model.undoMove();
        	GameScene.getTurnScene().currentTurnIndex -= 2;
        	GamePanel.updateTurnsScene();
        }
		GameScene.getBoardScene().updatePreview(GamePanel.model.getBoard());
		GamePanel.updateGameScene();
		((Resizable) View.getInstance().getScene(GameScene.class.getName()).getRoot()).relResize(0, 0, 1, 1);
	}

	/**
	 * The redo handler, and updates the scene.
	 */
	private static void redo() {
    	if (!GamePanel.model.getMoves().iterator().hasNext()) {
    		System.out.println("No moves to redo.");
    	}
    	else if (GamePanel.model.isHumansPlaying()) {
    		GamePanel.model.redoMove();
    		GameScene.getTurnScene().currentTurnIndex += 1;
    		GamePanel.updateTurnsScene();
    	}
    	else {
    		GamePanel.model.redoMove();
    		GamePanel.model.redoMove();
    		GameScene.getTurnScene().currentTurnIndex += 2;
    		GamePanel.updateTurnsScene();
    	}
		GameScene.getBoardScene().updatePreview(GamePanel.model.getBoard());
		GamePanel.updateGameScene();
	}
	
	//Save board handler
	private void saveBoard() {
		SaveScene.setBackScene(GameScene.class.getName());
		View.getInstance().setScene(SaveScene.class.getName());
	}


}
