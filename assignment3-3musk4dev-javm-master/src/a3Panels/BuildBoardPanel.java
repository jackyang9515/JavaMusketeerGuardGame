package a3Panels;

import a3App.View;
import a3Resizables.RelButton;
import a3Resizables.RelImgView;
import a3Resizables.RelListView;
import a3Resizables.Resizable;
import a3Scenes.BoardScene;
import a3Scenes.BoardSelectionScene;
import a3Scenes.BuildBoardScene;
import a3Scenes.GameScene;
import a3Scenes.HomeScene;
import a3Scenes.ModeSelectionScene;
import a3Scenes.SaveScene;
import a3Scenes.SettingsScene;
import assignment1.Board;
import assignment1.Coordinate;
import assignment1.GenerateBoard;
import assignment1.Guard;
import assignment1.Musketeer;
import assignment1.Piece;
import assignment1.ThreeMusketeers;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class BuildBoardPanel extends AppPanel implements EventHandler<MouseEvent>{
	private static final ThreeMusketeers model = ThreeMusketeers.getInstance();
	private static BoardScene BoardScene;
	private static GenerateBoard newboard = new GenerateBoard();
	private static String side = "E";
	private static BuildBoardScene scene;
	
	public BuildBoardPanel(BuildBoardScene scene) {
		BuildBoardPanel.BoardScene = BuildBoardScene.getBoardScene();
		BoardScene.updatePreview(newboard.getBoard());
		BuildBoardPanel.scene = scene;
	}
	

	@Override
	public void handle(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof RelButton) {
			switch (((RelButton) e.getSource()).getText()) { //TODO
				case "Home":{
					View.getInstance().setScene(HomeScene.class.getName());
					break;
				}
				case "Load": {
					BuildBoardPanel.getBoardScene().updatePreview(newboard.getBoard());
					System.out.println(newboard.getBoard());
					changeButtonView();
					break;
				}
				case "Save":{
						SaveScene.setBackScene(BuildBoardScene.class.getName());
						View.getInstance().setScene(SaveScene.class.getName());
				}
				case "Clear Board":{
					newboard = new GenerateBoard();
					BuildBoardPanel.getBoardScene().updatePreview(newboard.getBoard());
					break;
				}
				case "Start":{
						model.setBoard(newboard.getBoard());
						View.getInstance().setScene(ModeSelectionScene.class.getName());
						
					}
					break;
				}
			}
		else if (e.getSource() instanceof RelListView) {
			newboard = new GenerateBoard("Boards/" + ((RelListView) e.getSource()).getSelectionModel().getSelectedItem());
		}
		else if (e.getSource() instanceof RelImgView) {
			if (BoardScene.getCoordinate((RelImgView) e.getSource()) != null) {
				addCell(BoardScene.getCoordinate((RelImgView) e.getSource()));
				BuildBoardPanel.getBoardScene().updatePreview(newboard.getBoard());
				
			}
			else if (((RelImgView) e.getSource()).getImage().equals(View.getCurrTheme().getMuskImg())) {
				BuildBoardPanel.side = "M";
			}else if (((RelImgView) e.getSource()).getImage().equals(View.getCurrTheme().getGuardImg())) {
				BuildBoardPanel.side = "G";
			}else if (((RelImgView) e.getSource()).getImage().equals(View.getCurrTheme().getEmptyImg())) {
				BuildBoardPanel.side = "E";
			}
		}
	}

	public static void saveBoard(String name) {
		newboard.saveBoard(name);
		BuildBoardScene.initBoardsList();
	}
	
	private void addCell(Coordinate c) {
		Piece p = null;
		if(BuildBoardPanel.side == "M") {
			p = new Musketeer();
		}else if(BuildBoardPanel.side == "G") {
			p = new Guard();
		}else if(BuildBoardPanel.side == "E") {
			
		}
		BoardScene.changeCell(c, p);
		newboard = new GenerateBoard(BoardScene.getBoard());
		changeButtonView();
	}
	private void changeButtonView() {
		System.out.println(newboard.isValidBoard());
		if(!newboard.isValidBoard()) {
			BuildBoardScene.getSaveButton().setDisable(true);
			BuildBoardScene.getStartButton().setDisable(true);
		}else if (newboard.isValidBoard()) {
			BuildBoardScene.getSaveButton().setDisable(false);
			BuildBoardScene.getStartButton().setDisable(false);
		}
		((Resizable) scene.getRoot()).relResize(0, 0, 1, 1);
	}
	private static BoardScene getBoardScene() {
		// TODO Auto-generated method stub
	
		return BoardScene;
	}
}