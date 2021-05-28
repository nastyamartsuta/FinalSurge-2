package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StringUtils {

    public static String format(String pattern, String value) {
        return String.format(pattern, value);
    }

    private static String getDirectNodeText(WebDriver driver, WebElement element) {
        String script = "if(arguments[0].hasChildNodes()){var r='';var C=arguments[0].childNodes;for(var n=0;n<C.length;n++){if(C[n].nodeType==Node.TEXT_NODE){r+=' '+C[n].nodeValue}}return r.trim()}else{return arguments[0].innerText}";

        return (String) ((JavascriptExecutor)driver).executeScript(script, element);
    }

    public static String getWebElementText(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        return StringUtils.getDirectNodeText(driver, element);
    }
}
