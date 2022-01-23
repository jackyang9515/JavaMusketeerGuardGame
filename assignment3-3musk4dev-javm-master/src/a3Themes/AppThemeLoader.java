package a3Themes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import a3Utils.Utils;

public class AppThemeLoader {
	private Scanner scanner;
	private File[] themeFiles = this.getThemeFiles();
	private final String currThemeConfigName = "__DO_NOT_RENAME.txt";
	private final String primaryColorTag = "Primary Color: ";
	private final String secondaryColorTag = "Secondary Color: ";
	private final String textColorTag = "Text Color: ";
	private final String fontNameTag = "Font: ";
	private final String relFontSizeTag = "Relative Font Size: ";
	private final String relButtonRadiusTag = "Relative Button Radius: ";

	private File[] getThemeFiles() {
		ArrayList<File> arr = new ArrayList<File>();
		File parent = new File("themes");
		for (String themeFileName: parent.list()) {
			if (!themeFileName.equals(this.currThemeConfigName)) {
				arr.add(new File("themes/" + themeFileName));
			}
		}
		File[] ans = new File[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			ans[i] = arr.get(i);
		}
		return ans;
		
	}

	public int getCurrThemeIndex() {
		int ans = 0;
		File currThemeConfig = new File("themes/" + this.currThemeConfigName);
		try {
			this.scanner = new Scanner(currThemeConfig);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("themes/" + this.currThemeConfigName + " not found.");
			System.exit(1);
		}
		if (this.scanner.hasNextLine()) {
            ans = Integer.parseInt(scanner.nextLine());
		}
		this.scanner.close();
		return ans;
	}

	public void loadThemes(ArrayList<AppTheme> themes, AppThemeBuilder builder) {
		for (File themeFile: this.themeFiles) {
			this.loadTheme(themeFile, builder);
			themes.add(builder.buildTheme());
			builder.reset();
			
		}
	}

	public void saveCurrTheme(int index) {
		String indexString = String.valueOf(index);
		File currThemeConfig = new File("themes/" + this.currThemeConfigName);
		FileWriter configWriter;
		try {
			configWriter = new FileWriter(currThemeConfig, false);
			configWriter.write(indexString);
			configWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to store current theme into index.");
			System.exit(1);
		}
	}

	private void loadTheme(File themeFile, AppThemeBuilder builder) {
		try {
			this.scanner = new Scanner(themeFile);
			String themeName = themeFile.getName().substring(0, themeFile.getName().lastIndexOf(".txt"));
			builder.setName(themeName);
			while (this.scanner.hasNextLine()) {
				String line = this.scanner.nextLine();
				if (line.startsWith(this.primaryColorTag)) {
					builder.setPrimaryColor(Utils.getColor(line.substring(this.primaryColorTag.length())));
				} else if (line.startsWith(this.secondaryColorTag)) {
					builder.setSecondaryColor(Utils.getColor(line.substring(this.secondaryColorTag.length())));
				} else if (line.startsWith(this.textColorTag)) {
					builder.setTextColor(Utils.getColor(line.substring(this.textColorTag.length())));
				} else if (line.startsWith(this.fontNameTag)) {
					builder.setFontName(line.substring(this.fontNameTag.length()));
				} else if (line.startsWith(this.relFontSizeTag)) {
					builder.setRelFontSize(Double.parseDouble(line.substring(this.relFontSizeTag.length())));
				} else if (line.startsWith(this.relButtonRadiusTag)) {
					builder.setRelButtonRadius(Double.parseDouble(line.substring(this.relButtonRadiusTag.length())));
				}
			}
			this.scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(themeFile.getName() + " not found.");
		}
		
	}

}
