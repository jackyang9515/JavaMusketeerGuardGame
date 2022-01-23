package a3Scenes;


import a3App.View;
import a3Panels.MainPanel;
import a3Resizables.RelButton;
import a3Resizables.RelGroup;
import a3Resizables.RelImgView;
import a3Resizables.RelLabel;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * The main menu. To be shown at the start of the application.
 *
 */
public class HomeScene extends AppScene{

	@Override
	protected void buildScene() {
		// TODO Auto-generated method stub
		RelGroup box = new RelGroup();
		RelButton optionsButton = new RelButton("Settings", false);
		RelButton startButton = new RelButton("START", false);
		RelButton createButton = new RelButton("Create Board", false);
		RelLabel label = new RelLabel("ThreeMusketeers");
		MainPanel panel = new MainPanel();
		label.setRelXYWH(0, 0.1, 1, 0.2);
		box.setRelXYWH(0.2, 0.4, 0.6, 0.5);
		optionsButton.setRelXYWH(0, 0.6, 1, 0.2);
		startButton.setRelXYWH(0, 0, 1, 0.2);
		createButton.setRelXYWH(0,0.3,1,0.2);
		optionsButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		startButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		createButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		box.getChildren().addAll(optionsButton, startButton, createButton);
		((RelGroup) this.getRoot()).getChildren().addAll(box, label);
		
		
	}

}
