package a3Scenes;

import a3App.View;
import a3Panels.SideSelectionPanel;
import a3Resizables.RelButton;
import a3Resizables.RelGroup;
import a3Resizables.RelImgView;
import a3Resizables.RelLabel;
import assignment1.ThreeMusketeers;
import javafx.scene.input.MouseEvent;

public class SideSelectionScene extends AppScene{


	@Override
	protected void buildScene() {
		// TODO Auto-generated method stub
		RelLabel heading = new RelLabel("Side Selection");
		RelLabel subHeading = new RelLabel("Click the corresponding image to start");
		RelImgView muskImgView = new RelImgView(View.getCurrTheme().getMuskImg());
		RelImgView guardImgView = new RelImgView(View.getCurrTheme().getGuardImg());
		RelLabel muskLabel = new RelLabel("Musketeer");
		RelLabel guardLabel = new RelLabel("Guard");
		RelGroup layoutBox = new RelGroup();
		RelButton backButton = new RelButton("Back", false);
		SideSelectionPanel panel = new SideSelectionPanel();
		layoutBox.setRelXYWH(0.1, 0.3, 0.8, 0.4);
		muskImgView.setRelXYWH(0.025, 0.025, 0.45, 0.675);
		guardImgView.setRelXYWH(0.525, 0.025, 0.45, 0.675);
		muskLabel.setRelXYWH(0, 0.75, 0.5, 0.25);
		guardLabel.setRelXYWH(0.5, 0.75, 0.5, 0.25);
		layoutBox.getChildren().addAll(muskImgView, guardImgView, muskLabel, guardLabel);
		heading.setRelXYWH(0, 0, 1, 0.2);
		subHeading.setRelXYWH(0, 0.125, 1, 0.05);
		backButton.setRelXYWH(0.4, 0.8, 0.2, 0.1);

		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		muskImgView.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		guardImgView.addEventHandler(MouseEvent.MOUSE_CLICKED, panel);
		((RelGroup) this.getRoot()).getChildren().addAll(heading, layoutBox, subHeading, backButton);
	}

}
