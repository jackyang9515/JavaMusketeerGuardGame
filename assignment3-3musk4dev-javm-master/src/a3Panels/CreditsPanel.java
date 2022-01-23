package a3Panels;

import a3App.View;
import a3Scenes.SettingsScene;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Controller for credits scene
 */
public class CreditsPanel extends AppPanel{

	@Override
	public void handle(MouseEvent e) {
		// TODO Auto-generated method stub
		String text = ((Button)e.getSource()).getText();
		switch (text) {
			case "Back To Settings":{
				View.getInstance().setScene(SettingsScene.class.getName());
				break;
			}
			default:{
				break;
			}
		}
	}
}
