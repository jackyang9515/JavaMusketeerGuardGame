package a3Scenes;

import java.text.SimpleDateFormat;
import java.util.Date;

import a3App.View;
import a3Panels.BuildBoardPanel;
import a3Resizables.RelButton;
import a3Resizables.RelGroup;
import a3Resizables.RelLabel;
import a3Resizables.RelTextField;
import assignment1.ThreeMusketeers;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class SaveScene extends AppScene{
	
	RelTextField saveFileNameTextField;
	RelButton s_button;
	RelButton b_button;
	RelLabel message;
	RelLabel inputPrompt;
	static AppScene backScene;
	
	@Override
	protected void buildScene () {
		backScene = View.getInstance().getScene(HomeScene.class.getName());
		String boardName = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.saveFileNameTextField = new RelTextField();
        saveFileNameTextField.setText(boardName);
        inputPrompt = new RelLabel("Filename: ");
        s_button = new RelButton("save", false);
        this.message = new RelLabel("");
        b_button = new RelButton("back", false);
        
        inputPrompt.setRelXYWH(0, 0, 1, 0.2);
        saveFileNameTextField.setRelXYWH(0.2, 0.2, 0.6, 0.1);
        s_button.setRelXYWH(0.2, 0.35, 0.6, 0.1);
		b_button.setRelXYWH(0.2, 0.5, 0.6, 0.1);
		message.setRelXYWH(0.4, 0.85, 0.2, 0.075);
        
        s_button.setOnAction(event -> {
        	if (backScene instanceof GameScene) {
            	ThreeMusketeers.getInstance().getBoard().saveCustomBoard(saveFileNameTextField.getText());
        	} else if (backScene instanceof BuildBoardScene) {
        		BuildBoardPanel.saveBoard(saveFileNameTextField.getText());
        	}
        	message.setText("saved");
        });
        b_button.setOnAction(event -> {
        	View.getInstance().setScene(backScene.getClass().getName());
        });
        
        ((RelGroup) this.getRoot()).getChildren().addAll(saveFileNameTextField, s_button, b_button, message,
        		inputPrompt);    
	}

	public static AppScene getBackScene() {
		return backScene;
	}

	public static void setBackScene(String sceneName) {
		backScene = View.getInstance().getScene(sceneName);
	}
}
