package testSets;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objects.*;
import utilities.*;

@RunWith(value = Parameterized.class)
public class BasicTestSets {
	WebDriver driver;
	LogInPage loginPage;
	PropertyReader prop;

	@Test
	public void testLogInTMS() throws IOException {
		WebElement loginImg;
		loginPage.LogInPageFactory(driver, prop);

		if (loginPage.getAuthority().equals("oktató")) {
			try {
				if (loginPage.getBrowserType().equals("ie")) {
					loginImg = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-education']"));
				} else {
					loginImg = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-briefcase']"));
				}
				assertTrue(loginImg.isDisplayed());
				assertTrue(loginImg.isDisplayed());
			} catch (NoSuchElementException nsee) {
				System.out.println("The Icon was not located.");
			} catch (AssertionError ae) {
				System.out.println("The Icon was located, but not displayed.");
			}
		} else if (loginPage.getAuthority().equals("hallgató")) {
			try {
				loginImg = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-pencil']"));
				assertTrue(loginImg.isDisplayed());
			} catch (NoSuchElementException nsee) {
				System.out.println("The Icon was not located.");
			} catch (AssertionError ae) {
				System.out.println("The Icon was located, but not displayed.");
			}
		} else if (loginPage.getAuthority().equals("mindkettõ")) {
			try {
				if (loginPage.getBrowserType().equals("ie")) {
					loginImg = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-education']"));
				} else {
					loginImg = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-briefcase']"));
				}
				assertTrue(loginImg.isDisplayed());
			} catch (NoSuchElementException nsee) {
				System.out.println("The Icon was not located.");
			} catch (AssertionError ae) {
				System.out.println("The Icon was located, but not displayed.");
			}
			try {
				loginImg = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-pencil']"));
				assertTrue(loginImg.isDisplayed());
			} catch (NoSuchElementException nsee) {
				System.out.println("The Icon was not located.");
			} catch (AssertionError ae) {
				System.out.println("The Icon was located, but not displayed.");
			}
		}
		assertTrue(driver.getPageSource().contains("Kilépés"));

	}

	@Before
	public void setUp() throws IOException {
		this.prop = new PropertyReader();
		driver = DriverFactory.open(loginPage.getBrowserType(), prop);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getUrl());
	}

	@After
	public void tearDown() throws IOException {
		driver.close();
	}

	@Parameters
	public static List<String[]> getdata() throws InvalidFormatException, IOException {
		PropertyReader prop = new PropertyReader();
		ExcelReader reader = new ExcelReader();
		reader.run(prop.getFilename());
		return reader.getArrayExcelData();
	}

	public BasicTestSets(String neptunId, String name, String password, String authority, String browserType) {
		loginPage = new LogInPage(neptunId, name, password, authority, browserType);
	}
}
