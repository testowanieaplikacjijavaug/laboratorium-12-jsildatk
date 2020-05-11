import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SeleniumExtension.class)
public class Zad1Test {
    
    private final WebDriver webDriver;
    
    private final Zad1PO zad1PO;
    
    public Zad1Test(ChromeDriver chromeDriver) {
        this.webDriver = chromeDriver;
        zad1PO = new Zad1PO(webDriver);
    }
    
    @BeforeEach
    public void goToPage() {
        webDriver.get("https://duckduckgo.com/");
    }
    
    @Test
    public void testTitlePage() {
        assertEquals("DuckDuckGo — Privacy, simplified.", zad1PO.getTitle());
    }
    
    @Test
    public void testSource() {
        assertTrue(zad1PO.getSource()
                .contains("DuckDuckGo"));
    }
    
    @Test
    public void testClick() {
        zad1PO.sendKeysToInput("Mateusz Miotk")
                .clickSearchButton();
        assertEquals("Mateusz Miotk at DuckDuckGo", zad1PO.getTitle());
    }
    
}