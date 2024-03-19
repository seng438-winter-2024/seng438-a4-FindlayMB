// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class SearchCustomerServiceTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void searchCustomerService() {
    driver.get("https://www.ebay.ca/");
    driver.findElement(By.linkText("Help & Contact")).click();
    {
      WebElement element = driver.findElement(By.id("sr-input"));
      Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
      assertTrue(isEditable);
    }
    driver.findElement(By.id("sr-input")).click();
    driver.findElement(By.id("sr-input")).sendKeys("Reset Password");
    driver.findElement(By.id("sr-input")).sendKeys(Keys.ENTER);
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("li:nth-child(1) > .item"));
      assert(elements.size() > 0);
    }
    assertThat(driver.findElement(By.cssSelector("li:nth-child(1) .main_title")).getText(), is("Reset your password"));
  }
}
