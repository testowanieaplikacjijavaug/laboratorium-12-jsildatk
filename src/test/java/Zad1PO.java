import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zad1PO {
    
    @FindBy(id = "search_form_input_homepage")
    private WebElement searchInput;
    
    @FindBy(id = "search_button_homepage")
    private WebElement searchButton;
    
    private final WebDriver webDriver;
    
    public Zad1PO(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    
    public Zad1PO sendKeysToInput(String keys) {
        searchInput.sendKeys(keys);
        return this;
    }
    
    public Zad1PO clickSearchButton() {
        searchButton.click();
        return this;
    }
    
    public String getTitle() {
        return webDriver.getTitle();
    }
    
    public String getSource() {
        return webDriver.getPageSource();
    }
    
}
