import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageObject.class);
    private WebDriver driver;

    public WebDriver getDriver() throws Exception {
        LOGGER.debug("Starting Driver");
        return driver = new SelendroidDriver(new SelendroidCapabilities(System.getProperty("application")));
    }

    public void click(WebElement element) {
        LOGGER.debug("User is clicking on element: {}.", element);
        element.click();
    }

    public void fill(WebElement element, String value) {
        LOGGER.debug("User is filling element: {} with value: {}", element, value);
        element.clear();
        element.sendKeys(value);
    }


    public boolean textIsPresentOnPage(String text) {
        LOGGER.debug("Verifing text on the page: {}", text);
        WebElement element = null;
        try {
            element.findElement(By.xpath("//*[contains(text()," + text + ")]"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
