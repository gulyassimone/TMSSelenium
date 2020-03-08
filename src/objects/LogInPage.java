package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.PropertyReader;

public class LogInPage {
	private String neptunId;
	private String name;
	private String email;
	private String authority;
	private String browserType;

	public LogInPage(String neptunId, String name, String email, String authority, String browserType) {
		this.neptunId = neptunId;
		this.name = name;
		this.email = email;
		this.authority = authority;
		this.browserType = browserType;
	}

	public void LogInPageFactory(WebDriver driver, PropertyReader prop) {
		WebElement loginFormNeptun, loginFormName, loginFormEmail, loginFormIsStudent, loginFormIsTeacher, loginButtom;

		loginFormNeptun = driver.findElement(By.xpath(prop.getLoginFormNeptunXpath()));
		loginFormName = driver.findElement(By.xpath(prop.getLoginFormNameXpath()));
		loginFormEmail = driver.findElement(By.xpath(prop.getLoginFormEmailXpath()));
		loginFormIsStudent = driver.findElement(By.xpath(prop.getLoginFormIsStudentXpath()));
		loginFormIsTeacher = driver.findElement(By.xpath(prop.getLoginFormIsTeacherXpath()));
		loginButtom = driver.findElement(By.xpath(prop.getLoginButtomXpath()));

		loginFormNeptun.sendKeys(neptunId);
		loginFormName.sendKeys(name);
		loginFormEmail.sendKeys(email);
		if (authority.equals("oktató")) {
			loginFormIsTeacher.click();
			if (loginFormIsStudent.isSelected()) {
				loginFormIsStudent.click();
			}

		} else if (authority.equals("hallgató")) {
			if (!loginFormIsStudent.isSelected()) {
				loginFormIsStudent.click();
			}
		} else if (authority.equals("mindkettõ")) {
			loginFormIsTeacher.click();
			if (!loginFormIsStudent.isSelected()) {
				loginFormIsStudent.click();
			}
		}
		loginButtom.submit();
	}

	public String getName() {
		return name;
	}

	public String getAuthority() {
		return authority;
	}

	public String getNeptunId() {
		return neptunId;
	}

	public String getEmail() {
		return email;
	}

	public String getBrowserType() {
		return browserType;
	}

}
