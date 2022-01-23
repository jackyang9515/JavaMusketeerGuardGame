package a3Panels;

import a3App.View;
import a3Resizables.RelButton;
import a3Resizables.RelLabel;
import a3Resizables.RelListView;
import a3Scenes.BoardScene;
import a3Scenes.BoardSelectionScene;
import a3Scenes.GameScene;
import a3Scenes.HomeScene;
import a3Scenes.ModeSelectionScene;
import assignment1.Board;
import assignment1.ThreeMusketeers;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Controller class for board selection scene
 *
 */
public class BoardSelectionPanel extends AppPanel{
	private static final ThreeMusketeers model = ThreeMusketeers.getInstance();
	private static BoardScene boardScene;
	private static RelLabel turnLabel;

	public BoardSelectionPanel() {
		BoardSelectionPanel.boardScene = BoardSelectionScene.getBoardScene();
		BoardSelectionPanel.turnLabel = BoardSelectionScene.getTurnLabel();
	}

	@Override
	public void handle(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof RelListView) {
			Board board = new Board("Boards/" + ((RelListView) e.getSource()).getSelectionModel().getSelectedItem());
			BoardSelectionPanel.getBoardScene().updatePreview(board);
			BoardSelectionPanel.turnLabel.setText(board.getTurn().getType());
			GameScene.updateinitBoardGUI();
		} else if (e.getSource() instanceof RelButton) {
			switch (((RelButton) e.getSource()).getText()) {
				case "Back":{
					View.getInstance().setScene(HomeScene.class.getName());
					break;
				}
				case "Next":{
					model.setBoard(BoardSelectionPanel.getBoardScene().getBoard());
					View.getInstance().setScene(ModeSelectionScene.class.getName());
					break;
				}
			}
			
		}
	}

	public static BoardScene getBoardScene() {
		return boardScene;
	}

}
