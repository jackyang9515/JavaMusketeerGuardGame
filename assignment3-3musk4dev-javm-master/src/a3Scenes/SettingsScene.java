package a3Scenes;

import a3App.View;
import a3Panels.SettingsPanel;
import a3Resizables.RelButton;
import a3Resizables.RelGroup;
import a3Resizables.RelImgView;
import a3Resizables.RelLabel;
import javafx.scene.input.MouseEvent;

/**
 * The settings menu.
 *
 */
public class SettingsScene extends AppScene{

	@Override
	protected void buildScene() {
		// TODO Auto-generated method stub
		RelButton backButton = new RelButton("Back", false);
		RelButton creditsButton = new RelButton("Show Credits", false);
		RelButton themesButton = new RelButton("Themes", false);
		RelLabel heading = new RelLabel("Settings");
		SettingsPanel panel = new SettingsPanel();
		backButton.setRelXYWH(0.3, 0.7, 0.4, 0.1);
		themesButton.setRelXYWH(0.3, 0.3, 0.4, 0.1);
		creditsButton.setRelXYWH(0.3, 0.5, 0.4, 0.1);
		heading.setRelXYWH(0.2, 0.05, 0.6, 0.2);
		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		creditsButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		themesButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		((RelGroup) this.getRoot()).getChildren().addAll(backButton, creditsButton, themesButton, heading);
	}

}
