package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DriverUtils {

    public static void scrollToTop(WebDriver driver) {
        String script = "window.scrollTo(0, 0);";
        ((JavascriptExecutor) driver).executeScript(script);
    }
}
