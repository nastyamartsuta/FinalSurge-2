package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

@Log4j2
public class FileUpload extends AbstractElements {

    private final By INPUT_FILE_UPLOAD = By.id("TCXFile");
    private final By UPLOAD_FILE_BUTTON = By.xpath("//span[@class='btn btn-file']");

    public FileUpload(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return false;
    }

    public void chooseFile() {
        log.info("Select the file to add ");
        WebElement fileObject = driver.findElement(INPUT_FILE_UPLOAD);
        WebElement uploadButton = driver.findElement(UPLOAD_FILE_BUTTON);
        uploadButton.click();
        fileObject.sendKeys(System.getProperty("user.dir") + File.separator + "SpeedCoach.fit");
    }
}
