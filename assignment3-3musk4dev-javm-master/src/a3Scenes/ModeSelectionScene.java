package a3Scenes;

import a3Panels.ModeSelectionPanel;
import a3Resizables.RelButton;
import a3Resizables.RelGroup;
import a3Resizables.RelLabel;
import assignment1.ThreeMusketeers;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextAlignment;

public class ModeSelectionScene extends AppScene{
	private static final String humanHumanDesc = "Two humans playing";
	private static final String humanRandomDesc = "A human vs a computer who generates random moves";
	private static final String humanGreedyDesc = "A human vs a computer which computes moves to its own advantage";
	private static final RelLabel descLabel = new RelLabel("Description:\n\n");

	@Override
	protected void buildScene() {
		// TODO Auto-generated method stub
		RelLabel heading = new RelLabel("Mode Selection");
		RelButton humanHumanButton = new RelButton("Human vs Human", false);
		RelButton humanRandomButton = new RelButton("Human vs Random", false);
		RelButton humanGreedyButton = new RelButton("Human vs Greedy", false);
		RelButton backButton = new RelButton("Back", false);
		ModeSelectionPanel panel = new ModeSelectionPanel();
		
		heading.setRelXYWH(0, 0, 1, 0.2);
		humanHumanButton.setRelXYWH(0.2, 0.2, 0.6, 0.1);
		humanRandomButton.setRelXYWH(0.2, 0.35, 0.6, 0.1);
		humanGreedyButton.setRelXYWH(0.2, 0.5, 0.6, 0.1);
		backButton.setRelXYWH(0.4, 0.85, 0.2, 0.075);
		ModeSelectionScene.descLabel.setRelXYWH(0.15, 0.65, 0.7, 0.2);
		ModeSelectionScene.descLabel.setAlignment(Pos.TOP_LEFT);
		ModeSelectionScene.descLabel.setRelFontSize(1.0/3);
		ModeSelectionScene.descLabel.setWrapText(true);
		

		humanHumanButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		humanHumanButton.addEventHandler(MouseEvent.MOUSE_ENTERED, panel);
		humanHumanButton.addEventHandler(MouseEvent.MOUSE_EXITED, panel);

		humanRandomButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		humanRandomButton.addEventHandler(MouseEvent.MOUSE_ENTERED, panel);
		humanRandomButton.addEventHandler(MouseEvent.MOUSE_EXITED, panel);

		humanGreedyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		humanGreedyButton.addEventHandler(MouseEvent.MOUSE_ENTERED, panel);
		humanGreedyButton.addEventHandler(MouseEvent.MOUSE_EXITED, panel);

		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		
		((RelGroup) this.getRoot()).getChildren().addAll(heading, humanHumanButton,
				humanRandomButton, humanGreedyButton, backButton, ModeSelectionScene.descLabel);
	}

	public static String getHumanHumanDesc() {
		return ModeSelectionScene.humanHumanDesc;
	}

	public static String getHumanRandomDesc() {
		return ModeSelectionScene.humanRandomDesc;
	}

	public static String getHumanGreedyDesc() {
		return ModeSelectionScene.humanGreedyDesc;
	}

	public static RelLabel getDescLabel() {
		return ModeSelectionScene.descLabel;
	}

}
