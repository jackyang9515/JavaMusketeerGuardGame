package a3Panels;

import a3App.View;
import a3Resizables.RelButton;
import a3Resizables.RelLabel;
import a3Scenes.AppScene;
import a3Scenes.SettingsScene;
import a3Scenes.ThemesScene;
import a3Themes.AppTheme;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Controller for themes scene
 *
 */
public class ThemesPanel extends AppPanel{

	/** Label representing name of current theme*/
	RelLabel currName;
	/** Label representing name of new theme*/
	RelLabel newName;

	public ThemesPanel(RelLabel currName, RelLabel newName) {
		this.currName = currName;
		this.newName = newName;
	}

	/** Updates name labels on the scene accordingly when user hovers above buttons
	 * If user selects a different theme, then updates the symbols - and + accordingly
	 * to show user's selection.
	 * 
	 * In case of user hovering over new themes, displays it on newName
	 * 
	 * In case of user exiting new themes/hovering or clicking above original theme,
	 * erases text in newName
	 */
	@Override
	public void handle(MouseEvent e) {
		// TODO Auto-generated method stub
		AppScene scene = (AppScene) View.getStage().getScene();
		String text = ((Button)e.getSource()).getText();
		switch (text) {
			case "Back To Settings":{
				View.getInstance().setScene(SettingsScene.class.getName());
				break;
			}
			case "-":{
				int themeIndex = ((ThemesScene) scene).getIndexOfThemeButton((RelButton) e.getSource());
				if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
					
					View.getInstance().setTheme(themeIndex);
					this.newName.setText("");
					this.currName.setText(View.getCurrTheme().getName());
					((ThemesScene) scene).updateThemeButtons();
				} else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
					this.newName.setText(View.getInstance().getTheme(themeIndex).getName());
				} else if (e.getEventType() == MouseEvent.MOUSE_EXITED) {
					this.newName.setText("");
				}
			}

			case "+":{
				if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
					this.newName.setText("");
				}
			}
			
			default:{
				break;
			}
		}
	}

}
