package a3Scenes;

import a3App.View;
import a3Panels.CreditsPanel;
import a3Panels.SettingsPanel;
import a3Resizables.RelButton;
import a3Resizables.RelGroup;
import a3Resizables.RelImgView;
import a3Resizables.RelLabel;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;

/**
 * The credits scene.
 *
 */
public class CreditsScene extends AppScene{

	@Override
	protected void buildScene() { // #TODO
		// TODO Auto-generated method stub
		RelLabel credits = new RelLabel("Credits");
		RelLabel jack = new RelLabel("Jack Yang");
		RelLabel aedas = new RelLabel("Aedas Lai");
		RelLabel vicky = new RelLabel("Vicky Chen");
		RelLabel marko = new RelLabel("Marko Choi");
		RelGroup creditDetails = new RelGroup();
		
		credits.setRelXYWH(0.25, 0.1, 0.5, 0.2);
		jack.setRelXYWH(0.25, 0.25, 0.5, 0.15);
		aedas.setRelXYWH(0.25, 0.35, 0.5, 0.15);
		vicky.setRelXYWH(0.25, 0.45, 0.5, 0.15);
		marko.setRelXYWH(0.25, 0.55, 0.5, 0.15);
		
		credits.setAlignment(Pos.CENTER);
		jack.setAlignment(Pos.CENTER);
		aedas.setAlignment(Pos.CENTER);
		vicky.setAlignment(Pos.CENTER);		
		marko.setAlignment(Pos.CENTER);
		
		creditDetails.getChildren().addAll(credits, jack, aedas, vicky, marko);
		
		RelButton backButton = new RelButton("Back To Settings", false);
		CreditsPanel panel = new CreditsPanel();
		backButton.setRelXYWH(0.2, 0.8, 0.6, 0.1);
		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		
		
		((RelGroup) this.getRoot()).getChildren().addAll(creditDetails, backButton);
	}

}
