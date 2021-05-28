package steps;

import org.openqa.selenium.WebDriver;
import pages.BikePage;
import pages.EquipmentPage;
import pages.ShoesPage;

public abstract class AbstractEquipmentsSteps extends AbstractStep {

    EquipmentPage equipmentPage = new EquipmentPage(driver);
    ShoesPage shoesPage = new ShoesPage(driver);
    BikePage bikePage = new BikePage(driver);

    public AbstractEquipmentsSteps(WebDriver driver) {
        super(driver);
    }

    public void openEquipmentPage() {
        equipmentPage.openPage();
        validateComponentIsLoaded(equipmentPage);
    }
}
