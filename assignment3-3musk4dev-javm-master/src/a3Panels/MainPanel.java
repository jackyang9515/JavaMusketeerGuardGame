package a3Panels;


import a3App.View;
import a3Resizables.RelListView;
import a3Scenes.BoardSelectionScene;
import a3Scenes.BuildBoardScene;
import a3Scenes.GameScene;
import a3Scenes.SettingsScene;
import assignment1.Board;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Controller for main scene
 *
 */
public class MainPanel extends AppPanel{

	@Override
	public void handle(MouseEvent e) {
		// TODO Auto-generated method stub
		String text = ((Button)e.getSource()).getText();
		switch (text) {
			case "Settings":{
				View.getInstance().setScene(SettingsScene.class.getName());
				break;
			}
			case "START":{
				BoardSelectionScene.initBoardsList();
				View.getInstance().setScene(BoardSelectionScene.class.getName());
				Board board = new Board("Boards/" + BoardSelectionScene.getListView().getSelectionModel().getSelectedItem());
				BoardSelectionPanel.getBoardScene().updatePreview(board);
				GameScene.updateinitBoardGUI();
				break;
			}
			case "Create Board":{
				BuildBoardScene.initBoardsList();
				View.getInstance().setScene(BuildBoardScene.class.getName());
				break;
			}
			default:{
				break;
			}
		}
	}

}
