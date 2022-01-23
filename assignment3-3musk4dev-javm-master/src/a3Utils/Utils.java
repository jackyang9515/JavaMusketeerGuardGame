package a3Utils;

import javafx.scene.paint.Color;

/**
 * Useful functions to be used elsewhere in the project.
 *
 */
public class Utils {
	/** A color to hex string converter to be used in CSS formatting. (e.g. Color.WHITE => "#ffffff")
	 * 
	 * @param color: a color that is represented in Color instance
	 * @return the CSS hex string
	 */
	public static String getHexString(Color color) {
		return "#" + Utils.hexString(color.getRed()) + Utils.hexString(color.getGreen()) + Utils.hexString(color.getBlue());
	}

	
	/** Converts a 0 to 1 double into a hex value, 00 to FF, in string format. (e.g. 1.0 => "ff")
	 * @param proportion: a double ranging from 0 to 1, inclusive.
	 * @return the hex value in string.
	 */
	private static String hexString(double proportion) {
		String ans = Integer.toHexString((int)(proportion * 255));
		if (ans.length() == 1) {
			ans = "0" + ans;
		}
		return ans;
	}

	/**
	 * @param hexString: in the format #XXXXXX
	 * @return the corresponding color
	 */
	public static Color getColor(String hexString) {
		
		int r = Integer.parseInt(hexString.substring(1, 3), 16);
		int g = Integer.parseInt(hexString.substring(3, 5), 16);
		int b = Integer.parseInt(hexString.substring(5, 7), 16);
		return Color.rgb(r, g, b);
	}

}
