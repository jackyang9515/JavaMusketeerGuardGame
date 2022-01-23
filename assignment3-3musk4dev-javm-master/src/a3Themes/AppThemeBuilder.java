package a3Themes;

import java.io.File;
import java.util.Arrays;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * The Builder class for app theme
 * To be used in View instance.
 * See AppTheme class for description of the attributes.
 */
public class AppThemeBuilder {
	private File parent = new File("img");
	private String name = "Default";
	private Color primaryColor = Color.BLACK;
	private Color secondaryColor = Color.DIMGREY;
	private Color textColor = Color.DIMGREY;
	private Image muskImg = this.getMuskImg();
	private Image guardImg = this.getGuardImg();
	private Image emptyImg = this.getEmptyImg();
	private String fontName = "Arial";
	private double relFontSize = 0.3;
	private double relButtonRadius = 0.5;

	/** Setter of the primary color
	 * @param primaryColor
	 */
	protected void setPrimaryColor(Color primaryColor) {
		this.primaryColor = primaryColor;
	}

	/** Setter of the secondary color
	 * @param secondaryColor
	 */
	protected void setSecondaryColor(Color secondaryColor) {
		this.secondaryColor = secondaryColor;
	}

	protected void setTextColor(Color buttonTextColor) {
		this.textColor = buttonTextColor;
	}
	
	/** gets the musketeer image in the src\\img folder, according to the theme name set in the builder
	 * @return the corresponding musketeer image
	 */
	private Image getMuskImg() {
		if (Arrays.asList(this.parent.list()).contains(this.name + "Musk.png")) {
			return new Image("file:img/" + this.name + "Musk.png");
		}
		return new Image("file:img/DefaultMusk.png");
	}
	
	/** gets the guard image in the src\\img folder, according to the theme name set in the builder
	 * @return the corresponding guard image
	 */
	private Image getGuardImg() {
		if (Arrays.asList(this.parent.list()).contains(this.name + "Guard.png")) {
			return new Image("file:img/" + this.name + "Guard.png");
		}
		return new Image("file:img/DefaultGuard.png");
	}

	/** gets the empty image in the src\\img folder, according to the theme name set in the builder
	 * @return the corresponding empty image
	 */
	private Image getEmptyImg() {
		if (Arrays.asList(this.parent.list()).contains(this.name + "Empty.png")) {
			return new Image("file:img/" + this.name + "Empty.png");
		}
		return new Image("file:img/DefaultEmpty.png");
	}

	/** Setter of the font name.
	 * @param fontName: the font name
	 */
	protected void setFontName(String fontName) {
		if (Font.getFontNames().contains(fontName)) {
			this.fontName = fontName;
		}
	}

	/** Setter of the name of theme. Updates the images in the builder class accordingly.
	 * @param name: Name of the theme
	 */
	protected void setName(String name) {
		this.name = name;
		this.muskImg = this.getMuskImg();
		this.guardImg = this.getGuardImg();
		this.emptyImg = this.getEmptyImg();
	};


	/** Setter of the button radius
	 * @param relButtonRadius
	 */
	protected void setRelButtonRadius(double relButtonRadius) {
		this.relButtonRadius = relButtonRadius;
	}

	/** Setter of the font size
	 * @param relFontSize
	 */
	protected void setRelFontSize(double relFontSize) {
		this.relFontSize = relFontSize;
	};

	/** Builds a theme instances according to the attirbutes stored in the builder instance
	 * @return
	 */
	public AppTheme buildTheme() {
		return new AppTheme(this.name, this.primaryColor, this.secondaryColor, this.textColor, this.muskImg, this.guardImg, this.emptyImg, this.fontName, this.relFontSize, this.relButtonRadius);
	}

	public void reset() {
		this.name = "Default";
		this.primaryColor = Color.BLACK;
		this.secondaryColor = Color.DIMGREY;
		this.textColor = Color.DIMGREY;
		this.muskImg = this.getMuskImg();
		this.guardImg = this.getGuardImg();
		this.emptyImg = this.getEmptyImg();
		this.fontName = "Arial";
		this.relFontSize = 0.3;
		this.relButtonRadius = 0.5;
		
	}

	
}
