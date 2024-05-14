package org.page_objects;


import org.openqa.selenium.By;
import org.utils.ReusableMethods;

public class HomePage extends ReusableMethods {
	
	public static By settingsIcon = By.xpath("//img[@alt='Settings']");
	public static  void MouseOverOnSettingsIcon() {
		MouseOver(settingsIcon);
		
	}
}
