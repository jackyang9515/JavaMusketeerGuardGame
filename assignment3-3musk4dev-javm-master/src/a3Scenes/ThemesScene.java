package a3Scenes;

import java.util.ArrayList;

import a3App.View;
import a3Panels.ThemesPanel;
import a3Resizables.RelButton;
import a3Resizables.RelGroup;
import a3Resizables.RelLabel;
import a3Resizables.RelRect;
import a3Themes.AppTheme;
import a3Utils.Utils;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;

public class ThemesScene extends AppScene{
	private ArrayList<RelButton> themeButtons;

	@Override
	protected void buildScene() {
		// TODO Auto-generated method stub
		RelButton backButton = new RelButton("Back To Settings", false);
		RelLabel currLabel = new RelLabel("Current Theme:");
		RelLabel currName = new RelLabel(View.getCurrTheme().getName());
		RelLabel newLabel = new RelLabel("New Theme:");
		RelLabel newName = new RelLabel("");
		RelLabel heading = new RelLabel("Themes");
		RelGroup nameGroup = new RelGroup();
		RelRect themesBackground = new RelRect();
		ThemesPanel panel = new ThemesPanel(currName, newName);
		backButton.setRelXYWH(0.25, 0.85, 0.5, 0.075);
		heading.setRelXYWH(0.2, 0, 0.6, 0.2);
		nameGroup.setRelXYWH(0.2, 0.2, 0.6, 0.1);
		currLabel.setRelXYWH(0, 0, 0.5, 0.5);
		currName.setRelXYWH(0.5, 0, 0.5, 0.5);
		newLabel.setRelXYWH(0, 0.5, 0.5, 0.5);
		newName.setRelXYWH(0.5, 0.5, 0.5, 0.5);
		themesBackground.setRelH(0.5);
		themesBackground.setRelW(0.5 * View.getInstance().getOrigHeight()/View.getInstance().getOrigWidth());
		themesBackground.setRelY(0.3);
		themesBackground.setRelX((1-themesBackground.getRelW())/2);
		currLabel.setAlignment(Pos.CENTER_RIGHT);
		newLabel.setAlignment(Pos.CENTER_RIGHT);
		currName.setAlignment(Pos.CENTER_LEFT);
		newName.setAlignment(Pos.CENTER_LEFT);
		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		nameGroup.getChildren().addAll(currLabel, currName, newLabel, newName);
		((RelGroup)this.getRoot()).getChildren().addAll(themesBackground, nameGroup, heading, backButton);
		this.buildThemeButtons(panel);
		
	}

	private void buildThemeButtons(ThemesPanel panel) {
		RelGroup box = new RelGroup();
		this.themeButtons = new ArrayList<RelButton>();
		box.setRelH(0.5);
		box.setRelW(0.5 * View.getInstance().getOrigHeight()/View.getInstance().getOrigWidth());
		box.setRelY(0.3);
		box.setRelX((1-box.getRelW())/2);
		int size = (int) Math.ceil(Math.sqrt(View.getInstance().getThemesSize()));
		for (int i = 0; i < View.getInstance().getThemesSize(); i++) {
			RelButton btn = new RelButton("-", true);
			AppTheme theme = View.getInstance().getTheme(i);
			if (theme.equals(View.getCurrTheme())) {
				btn.setText("+");
			}
			btn.setStyle("-fx-background-color: " + Utils.getHexString(theme.getPrimaryColor()) + ";-fx-background-radius: " + View.getCurrTheme().getRelButtonRadius() + "em;");
			btn.setTextFill(theme.getSecondaryColor());
			btn.setRelXYWH(i%size * (1.0/size), i/size * (1.0/size), 1.0/size, 1.0/size);
			btn.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
			btn.addEventHandler(MouseEvent.MOUSE_ENTERED, panel);
			btn.addEventHandler(MouseEvent.MOUSE_EXITED, panel);
			this.themeButtons.add(btn);
			box.getChildren().add(btn);
		}
		((RelGroup)this.getRoot()).getChildren().addAll(box);
	}

	public int getIndexOfThemeButton(RelButton button) {
		return this.themeButtons.indexOf(button);
	}

	public void updateThemeButtons() {
		for (RelButton btn: this.themeButtons) {
			AppTheme theme = View.getInstance().getTheme(this.themeButtons.indexOf(btn));
			btn.setStyle("-fx-background-color: " + Utils.getHexString(theme.getPrimaryColor()) + ";-fx-background-radius: " + View.getCurrTheme().getRelButtonRadius() + "em;");
			btn.setTextFill(theme.getSecondaryColor());
			if (theme.equals(View.getCurrTheme())) {
				btn.setText("+");
			} else {
				btn.setText("-");
			}
		}
	}

}
