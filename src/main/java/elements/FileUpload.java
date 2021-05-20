package elements;

import components.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;

@Log4j2
public class FileUpload extends AbstractComponent {

    public final By INPUT_FILE_UPLOAD = By.id("TCXFile");
    public final By UPLOAD_FILE_BUTTON = By.xpath("//span[@class='btn btn-file']");

    public FileUpload(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return false;
    }

    public void chooseFile() {
        log.info("Select the file to add ");
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
        WebElement fileObject = driver.findElement(INPUT_FILE_UPLOAD);
        WebElement uploadButton = driver.findElement(UPLOAD_FILE_BUTTON);
        uploadButton.click();
        fileObject.sendKeys(System.getProperty("user.dir") + "\\SpeedCoach.fit");

        //TODO закрыть окно после добавления файла
    }
}
