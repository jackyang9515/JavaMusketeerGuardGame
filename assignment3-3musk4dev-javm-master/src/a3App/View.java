package a3App;

import java.util.ArrayList;

import a3Resizables.Resizable;
import a3Scenes.AppScene;
import a3Scenes.BoardScene;
import a3Scenes.BoardSelectionScene;
import a3Scenes.BuildBoardScene;
import a3Scenes.CreditsScene;
import a3Scenes.GameScene;
import a3Scenes.SaveScene;
import a3Scenes.HomeScene;
import a3Scenes.ModeSelectionScene;
import a3Scenes.SettingsScene;
import a3Scenes.SideSelectionScene;
import a3Scenes.TestScene;
import a3Scenes.ThemesScene;
import a3Scenes.TurnScene;
import a3Themes.AppTheme;
import a3Themes.AppThemeBuilder;
import a3Themes.AppThemeLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * The scene manager class.
 *
 */
public class View {
	/** The original height of the screen, excluding padding */
	private double origHeight;
	/** The original width of the screen, excluding padding */
	private double origWidth;
	/** Instance of View object */
	private static View view;
	/** Instance of Stage object */
	private static Stage stage;
	/** Instance of current theme used */
	private static AppTheme theme;
	/** Instance of ThemeBuilder object. Used in loadThemes() */
	private static AppThemeBuilder themeBuilder = new AppThemeBuilder();
	/** Instance of ThemeLoader object. Used in loadThemes() */
	private static AppThemeLoader themeLoader = new AppThemeLoader();
	/** Switch for resize detection */
	private int resizeClick = 0;
	/** Switch for maximize stage detection */
	private int fullScreenClick = 0;
	/** The whole collection of themes */
	private ArrayList<AppTheme> themes = new ArrayList<AppTheme>();
	/** All scenes used in the application */
	private ArrayList<AppScene> scenes = new ArrayList<AppScene>();
	/** Height padding to make resizing work as desired */
	public static double heightPadding = 35;
	/** Width padding to make resizing work as desired */
	public static double widthPadding = 12.5;

	/** The hidden constructor
	 * @param stage: Stage of application
	 * @param width: Width of screen, excluding padding
	 * @param height: Height of screen, excluding padding
	 * 
	 */
	private View(Stage stage, double width, double height) {
		View.stage = stage;
		this.origWidth = width;
		this.origHeight = height;
		stage.setWidth(width + View.widthPadding);
		stage.setHeight(height + View.heightPadding);
		View.stage.show();
		this.stageSetup();
	}

	/** Setter of screen height
	 * @param height: Height of screen, excluding padding
	 * 
	 */
	public void setOrigHeight(double height) {
		this.origHeight = height;
		stage.setHeight(height + View.heightPadding);
	}

	
	/** Getter of screen height
	 * @return height of screen, excluding padding
	 */
	public double getOrigHeight() {
		return this.origHeight;
	}

	/** Setter of screen width
	 * @param height: Width of screen, excluding padding
	 */
	public void setOrigWidth(double width) {
		this.origWidth = width;
		stage.setWidth(width + View.widthPadding);
	}

	/** Getter of screen width
	 * @return width of screen, excluding padding
	 */
	public double getOrigWidth() {
		return this.origWidth;
	}
	
	/** Sets a scene to Stage instance
	 * @param scene: Scene to be shown
	 */
	private void setScene(AppScene scene) {
		View.stage.setScene(scene);
		View.stage.getScene().setFill(View.theme.getPrimaryColor());
		((Resizable) scene.getRoot()).relResize(0, 0, 1, 1);
	}

	/** Sets a scene to Stage instance
	 * This method should be called by View.getInstance().setScene(AppScene.class.getName())
	 * @param className: name of the class of the AppScene
	 *
	 */
	public void setScene(String className) {
		for (AppScene scene: this.scenes) {
			if (scene.getClass().getName() == className) {
				this.setScene(scene);
				return;
			}
		}
	}

	public AppScene getScene(String className) {
		for (AppScene scene: this.scenes) {
			if (scene.getClass().getName() == className) {
				return scene;
			}
		}
		return null;
	}

	/** Getter of all scenes in the application
	 * @return the collection of scenes
	 */
	public ArrayList<AppScene> getScenes() {
		return this.scenes;
	}

	/** Sets the theme of the application
	 * @param theme: Theme to be shown
	 */
	private void setTheme(AppTheme theme) {
		View.theme = theme;
		if (View.stage.getScene() != null) {
			((Resizable) View.stage.getScene().getRoot()).relResize(0, 0, 1, 1);
			View.stage.getScene().setFill(View.theme.getPrimaryColor());
		}
	}

	/** Sets the theme of the application
	 * @param themeIndex: Index of theme in this.themes
	 */
	public void setTheme(int themeIndex) {
		this.setTheme(this.themes.get(themeIndex));
		View.themeLoader.saveCurrTheme(themeIndex);
	}

	

	/** Getter of current theme
	 * @return the current theme
	 */
	public static AppTheme getCurrTheme() {
		return View.theme;
	}

	/** Getter of a given theme
	 * @param index: Index of given theme in this.themes
	 * @return the given theme
	 */
	public AppTheme getTheme(int index) {
		return this.themes.get(index);
	}

	/**
	 * @return the size of this.themes
	 */
	public int getThemesSize() {
		return this.themes.size();
	}

	/** Getter of View instance
	 * Should be called when accessing public non-static methods
	 * @return View instance
	 */
	public static View getInstance() {
		return View.view;
	}

	/** Getter of Stage instance
	 * @return stage instance
	 */
	public static Stage getStage() {
		return View.stage;
	}

	/** The public constructor of View. Creates an instance only when there is none
	 * @param stage: Stage to be used
	 * @param width: Width of the screen, excluding padding
	 * @param height: Height of the screen, excluding padding
	 */
	public static void createInstance(Stage stage, double width, double height) {
		if (View.view == null) {
			View.view = new View(stage, width, height);
			View.getInstance().loadThemes();
			View.getInstance().loadScenes();
		}
	}


	/** Adds listeners to detect both width and height resizes, as well as full screen button detection.
	 * Fixes the width-height ratio, and disables the full screen button.
	 */
	private void stageSetup() {
		View.stage.widthProperty().addListener(
				(obs, oldVal, newVal) -> {
					if (this.resizeClick == 0 && this.fullScreenClick == 0) {
						this.resizeClick = 1;
						View.stage.setHeight((View.stage.getWidth()-View.widthPadding) * this.origHeight/this.origWidth + View.heightPadding);
						((Resizable) View.stage.getScene().getRoot()).relResize(0, 0, 1, 1);
					}
					this.resizeClick = 0;
				});

		View.stage.heightProperty().addListener(
				(obs, oldVal, newVal) -> {
					if (this.resizeClick == 0 && this.fullScreenClick == 0) {
						this.resizeClick = 1;
						View.stage.setWidth((View.stage.getHeight() - View.heightPadding) * this.origWidth/this.origHeight + View.widthPadding);
						((Resizable) View.stage.getScene().getRoot()).relResize(0, 0, 1, 1);
					}
					this.resizeClick = 0;
				});
		View.stage.maximizedProperty().addListener(
				(obs, oldVal, newVal) -> {
					this.fullScreenClick = 1;
					View.stage.setMaximized(false);
					this.fullScreenClick = 0;
				});
	}

	/** Loader of scenes.
	 * Will be put into loader classes in the future.
	 */
	private void loadScenes() { // #TODO
		this.scenes.add(new TestScene());
		this.scenes.add(new HomeScene());
		this.scenes.add(new BuildBoardScene());
		this.scenes.add(new SettingsScene());
		this.scenes.add(new CreditsScene());
		this.scenes.add(new ThemesScene());
		this.scenes.add(new BoardSelectionScene());
		this.scenes.add(new ModeSelectionScene());
		this.scenes.add(new SideSelectionScene());
		this.scenes.add(new GameScene());
		this.scenes.add(new SaveScene());
		
		// this.setScene(TestScene.class.getName());
		this.setScene(HomeScene.class.getName());
		
	}

	/** Loader of themes. Indexing of themes depends on loader.
	 * Will be put into loader classes in the future.
	 */
	private void loadThemes() { // #TODO
		this.themes.add(View.themeBuilder.buildTheme());
		View.themeLoader.loadThemes(this.themes, View.themeBuilder);
		this.setTheme(View.themeLoader.getCurrThemeIndex());
	}

}
