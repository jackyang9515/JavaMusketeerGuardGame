package a3Panels;

import a3App.View;
import a3Resizables.RelButton;
import a3Resizables.RelImgView;
import a3Resizables.Resizable;
import a3Scenes.GameScene;
import a3Scenes.ModeSelectionScene;
import assignment1.Piece;
import assignment1.ThreeMusketeers;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SideSelectionPanel extends AppPanel {

	private static final ThreeMusketeers model = ThreeMusketeers.getInstance();
	private static ThreeMusketeers.GameMode mode = ThreeMusketeers.GameMode.Human; //Just for default

	@Override
	public void handle(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof RelButton) {
			switch (((RelButton) e.getSource()).getText()) {
				case "Back":{
					View.getInstance().setScene(ModeSelectionScene.class.getName());
				}
			}
		} else if (e.getSource() instanceof RelImgView) {
			if (((RelImgView) e.getSource()).getImage().equals(View.getCurrTheme().getMuskImg())) {
				model.setSide(SideSelectionPanel.mode, Piece.Type.MUSKETEER);
			} else if (((RelImgView) e.getSource()).getImage().equals(View.getCurrTheme().getGuardImg())) {
				model.setSide(SideSelectionPanel.mode, Piece.Type.GUARD);
			}
	    	View.getInstance().setScene(GameScene.class.getName());
			GamePanel.updateGameScene();
			((Resizable) View.getInstance().getScene(GameScene.class.getName()).getRoot()).relResize(0, 0, 1, 1);
		}
	}

	public static void setMode(ThreeMusketeers.GameMode mode) {
		SideSelectionPanel.mode = mode;
	}

}
