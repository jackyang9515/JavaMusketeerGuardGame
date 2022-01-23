package a3Themes;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * The theme class.
 *
 */
public class AppTheme {
	/**Name of theme */
	private String name;
	/**Color for background and text (textcolor may be extended) */
	private Color primaryColor;
	/**Color of UI buttons */
	private Color secondaryColor;
	/** */
	private Color textColor;
	/**Image of musketeer (See AppThemeBuilder for image name requirements)*/
	private Image muskImg;
	/**Image of the guard (See AppThemeBuilder for image name requirements)*/
	private Image guardImg;
	/**Image of the empty cells (See AppThemeBuilder for image name requirements)*/
	private Image emptyImg;
	/**Name of the font for the UI */
	private String fontName;
	/**Relative font size to the height of buttons and labels */
	private double relFontSize;
	/**Relative button radius in em */
	private double relButtonRadius;

	/** The constructor for AppTheme. Only to be called by AppThemeBuilder.
	 * @param name: Name of the theme.
	 * @param primaryColor: Background and text color of the theme (to be changed)
	 * @param secondaryColor: Button, label and rectangle color.
	 * @param muskImg: Musketeer image. Image name must be (this.name + "Musk.png")
	 * @param guardImg: Guard image. Image name must be (this.name + "Guard.png")
	 * @param emptyImg: The image for empty cells. Image name must be (this.name + "Empty.png")
	 * @param fontName: Family name of the font
	 * @param relFontSize: Relative font size to the height of the button
	 * @param relButtonRadius: Relative button radius in em
	 */
	protected AppTheme(String name, Color primaryColor, Color secondaryColor, Color textColor, Image muskImg, Image guardImg, Image emptyImg, String fontName, double relFontSize, double relButtonRadius) {
		this.name = name;
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.textColor = textColor;
		this.muskImg = muskImg;
		this.guardImg = guardImg;
		this.emptyImg = emptyImg;
		this.fontName = fontName;
		this.relFontSize = relFontSize;
		this.relButtonRadius = relButtonRadius;
	}

	/** Getter of the theme name.
	 * @return the theme name
	 */
	public String getName() {
		return this.name;
	}
	
	/** Getter of primary color
	 * @return primary color
	 */
	public Color getPrimaryColor() {
		return this.primaryColor;
	}

	/** Getter of secondary color
	 * @return secondary color
	 */
	public Color getSecondaryColor() {
		return this.secondaryColor;
	}

	public Color getTextColor() {
		return this.textColor;
	}

	/** Getter of musketeer image
	 * @return the musketeer image
	 */
	public Image getMuskImg() {
		return this.muskImg;
	}

	/** Getter of guard image
	 * @return the guard image
	 */
	public Image getGuardImg() {
		return this.guardImg;
	};

	/** Getter of empty image
	 * @return the empty image
	 */
	public Image getEmptyImg() {
		return this.emptyImg;
	};

	/** Getter of the font name as a string
	 * @return the font name
	 */
	public String getFontName() {
		return this.fontName;
	}

	/** Getter of the relative font size
	 * @return the font size
	 */
	public double getRelFontSize() {
		return this.relFontSize;
	}

	/** Getter of the button radius
	 * @return the button radius
	 */
	public double getRelButtonRadius() {
		return relButtonRadius;
	}
	
}
