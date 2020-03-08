package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	public static WebDriver open(String browserType, PropertyReader prop){
		WebDriver driver = null;
		if(browserType.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getFirefoxDriverPath());
			driver = new FirefoxDriver();
			System.out.println("Using firefox!");
		}
		else if(browserType.equals("ie")) {
			System.setProperty("webdriver.ie.driver", prop.getIeDriverPath());

			DesiredCapabilities ieCapabilities=DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver
			 .INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			ieCapabilities.setCapability("requireWindowFocus", true);
			driver = new InternetExplorerDriver(ieCapabilities);
			System.out.println("Using internet explorer!");
		}
		else {
			System.setProperty("webdriver.chrome.driver", prop.getChromeDriverPath());
			driver = new ChromeDriver();
			System.out.println("Using chrome!");
		}
		return driver;
	}
}
