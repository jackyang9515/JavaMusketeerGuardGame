package a3Panels;

import a3App.View;
import a3Resizables.RelButton;
import a3Scenes.BoardSelectionScene;
import a3Scenes.ModeSelectionScene;
import a3Scenes.SettingsScene;
import assignment1.ThreeMusketeers;
import assignment1.ThreeMusketeers.GameMode;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ModeSelectionPanel extends AppPanel{
	private static final ThreeMusketeers model = ThreeMusketeers.getInstance();
	private static final ModeSelectionScene scene = (ModeSelectionScene) View.getInstance().getScene(ModeSelectionScene.class.getName());
	@Override
	public void handle(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof RelButton) {
			if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
				switch (((RelButton) e.getSource()).getText()) { //TODO
					case "Human vs Human":{
						ModeSelectionPanel.model.selectMode(GameMode.Human);
						break;
					}
					case "Human vs Random":{
						ModeSelectionPanel.model.selectMode(GameMode.HumanRandom);
						break;
					}
					case "Human vs Greedy":{
						ModeSelectionPanel.model.selectMode(GameMode.HumanGreedy);
						break;
					}
					case "Back":{
						View.getInstance().setScene(BoardSelectionScene.class.getName());
						break;
					}
				}
			} else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
				switch (((RelButton) e.getSource()).getText()) {
					case "Human vs Human":{
						ModeSelectionScene.getDescLabel().setText("Description:\n\n" + ModeSelectionScene.getHumanHumanDesc());
						break;
					}
					case "Human vs Random":{
						ModeSelectionScene.getDescLabel().setText("Description:\n\n" + ModeSelectionScene.getHumanRandomDesc());
						break;
					}
					case "Human vs Greedy":{
						ModeSelectionScene.getDescLabel().setText("Description:\n\n" + ModeSelectionScene.getHumanGreedyDesc());
						break;
					}
				}
				
			} else if (e.getEventType() == MouseEvent.MOUSE_EXITED) {
				ModeSelectionScene.getDescLabel().setText("Description:\n\n");
			}
		}
		
	}

}
