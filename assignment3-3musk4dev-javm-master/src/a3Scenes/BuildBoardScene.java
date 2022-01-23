package a3Scenes;

import java.io.File;

import a3App.View;
import a3Panels.AppPanel;
import a3Panels.BuildBoardPanel;
import a3Panels.GamePanel;
import a3Resizables.RelButton;
import a3Resizables.RelGroup;
import a3Resizables.RelImgView;
import a3Resizables.RelLabel;
import a3Resizables.RelListView;
import assignment1.Board;
import assignment1.GenerateBoard;
import assignment1.Guard;
import assignment1.Musketeer;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class BuildBoardScene extends AppScene{
	private static RelListView relListView = new RelListView();
	private static BoardScene boardScene;
	private static GenerateBoard generateboard;
	private RelImgView[][] cellsGUI;
	private AppPanel boardpanel;
	private EventType<MouseEvent> event;
	private static RelButton SaveButton, StartButton;
	
	@Override
	protected void buildScene() {
		// TODO Auto-generated method stub
		
		RelGroup layoutBox = new RelGroup();
		RelGroup cellLayout = new RelGroup();
		BuildBoardScene.boardScene = new BoardScene();
		RelGroup boardLayout = new RelGroup();
		BuildBoardPanel panel = new BuildBoardPanel(this);
		boardLayout.setRelXYWH(0.35, 0.135, 0.65, 0.5);

		BuildBoardScene.initBoardsList();
		BuildBoardScene.boardScene.attachPanel(MouseEvent.MOUSE_CLICKED, panel);

		BuildBoardScene.relListView.setRelXYWH(0, 0, 0.4, 0.7);
		BuildBoardScene.relListView.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		
		RelButton HomeButton = new RelButton("Home", false);
		HomeButton.setRelXYWH(0.025, 0.025, 0.25, 0.0875);
		HomeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		
		SaveButton = new RelButton("Save", false);
		SaveButton.setRelXYWH(0.023, 0.50, 0.308, 0.0875);
		SaveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		SaveButton.setDisable(true);
		
		RelButton ClearButton = new RelButton("Clear Board", false);
		ClearButton.setRelXYWH(0.65, 0.025, 0.35, 0.0875);
		ClearButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		
		RelButton LoadButton = new RelButton("Load", false);
		LoadButton.setRelXYWH(0.023, 0.37, 0.308, 0.087);
		LoadButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		
		StartButton = new RelButton("Start", false);
		StartButton.setRelXYWH(0.40, 0.9, 0.308, 0.0875);
		StartButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		StartButton.setDisable(true);
		
		RelImgView muskImgView = new RelImgView(View.getCurrTheme().getMuskImg());
		RelImgView guardImgView = new RelImgView(View.getCurrTheme().getGuardImg());
		RelImgView empetyImgView = new RelImgView(View.getCurrTheme().getEmptyImg());
		RelLabel muskLabel = new RelLabel("Musketeer");
		RelLabel guardLabel = new RelLabel("Guard");
		RelLabel empetyLabel = new RelLabel("Empty");
		muskImgView.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		guardImgView.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		empetyImgView.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);

		muskImgView.setRelXYWH(0.405, 0.025, 0.28, 0.675);
		guardImgView.setRelXYWH(0.755, 0.025, 0.28, 0.675);
		empetyImgView.setRelXYWH(0.0, 0.025, 0.28, 0.675);
		empetyLabel.setRelXYWH(-0.1, 0.75, 0.5, 0.25);
		muskLabel.setRelXYWH(0.315, 0.75, 0.5, 0.25);
		guardLabel.setRelXYWH(0.660, 0.75, 0.5, 0.25);
		
		cellLayout.setRelXYWH(0.1, 0.66, 0.8, 0.25);
		cellLayout.getChildren().addAll(muskImgView, guardImgView, empetyImgView, muskLabel, guardLabel, empetyLabel);
		layoutBox.setRelXYWH(0.025, 0.135, 0.75, 0.29);
		boardLayout.getChildren().addAll(BuildBoardScene.boardScene.getRoot());
		layoutBox.getChildren().addAll(BuildBoardScene.relListView);
		((RelGroup) this.getRoot()).getChildren().addAll(HomeButton, SaveButton, ClearButton, LoadButton, StartButton, boardLayout, layoutBox, cellLayout);
		
		
	}
	
	public static void initBoardsList(){
		BuildBoardScene.relListView.getItems().clear();
		File parent = new File("boards");
		for (String file: parent.list()) {
			if (file.endsWith(".txt")) {
				BuildBoardScene.relListView.getItems().add(file);
			}
			if (file.equals("Starter.txt")) {
				BuildBoardScene.relListView.getSelectionModel().select(file);
			}
		}
		Board boards = new Board("Boards/" + BuildBoardScene.relListView.getSelectionModel().getSelectedItem());
	}
	
	public static void updateinitBoardGUI() {
		BuildBoardScene.boardScene.updatePreview(BoardSelectionScene.getBoardScene().getBoard());
	}
	
	public static BoardScene getBoardScene() {
		return BuildBoardScene.boardScene;
	}
	
	public static RelButton getSaveButton() {
		return SaveButton;
	}
	
	public static RelButton getStartButton() {
		return StartButton;
	}

}
