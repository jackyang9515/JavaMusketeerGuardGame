package a3Panels;

import a3App.View;
import a3Scenes.CreditsScene;
import a3Scenes.HomeScene;
import a3Scenes.ThemesScene;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Controller for settings scene
 *
 */
public class SettingsPanel extends AppPanel {

	@Override
	public void handle(MouseEvent e) {
		// TODO Auto-generated method stub
		String text = ((Button)e.getSource()).getText();
		switch (text) {
			case "Back":{
				View.getInstance().setScene(HomeScene.class.getName());
				break;
			}
			case "Show Credits":{
				View.getInstance().setScene(CreditsScene.class.getName());
				break;
			}
			case "Themes":{
				View.getInstance().setScene(ThemesScene.class.getName());
				break;
			}
			
			default:{
				break;
			}
		}
	}

}
