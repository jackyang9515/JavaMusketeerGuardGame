package a3Scenes;

import a3Resizables.RelGroup;
import a3Resizables.Resizable;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * The resizable scene class.
 *
 */
public abstract class AppScene extends Scene{
	

	/** Constructor for AppScene class. Initializes with RelGroup() (Resizable Group) as the root node.
	 * 
	 */
	public AppScene() {
		super(new RelGroup());
		// TODO Auto-generated constructor stub
		this.buildScene();
		((Resizable) this.getRoot()).relResize(0, 0, 1, 1);
	}

	/** The scene builder method. Construction of subtrees and leaves go here.
	 * Every node in the scene tree must be Resizable.
	 * 
	 */
	protected abstract void buildScene();
	
}
