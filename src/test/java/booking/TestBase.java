package booking;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class TestBase {

	public static Properties config = null;
	public static WebDriver webdriver = null;
	public static EventFiringWebDriver driver = null;

	@Before
	public void initialize() throws IOException {

		config = new Properties();
		
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\config\\config.properties");
		config.load(fp);

		ChromeDriverManager.getInstance().setup();

		if (config.getProperty("browser").equals("chrome")) {
			webdriver = new ChromeDriver();

		} else if (config.getProperty("browser").equals("firefox")) {
			webdriver = new FirefoxDriver();
		} else if (config.getProperty("browser").equals("ie")) {
			webdriver = new InternetExplorerDriver();
		}

		driver = new EventFiringWebDriver(webdriver);
		driver.navigate().to(config.getProperty("baseurl"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
