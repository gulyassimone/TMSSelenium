package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	private String chromeDriverPath;
	private String firefoxDriverPath;
	private String ieDriverPath;
	private String filename;
	private String url;
	

	private String loginFormNeptunXpath;
	private String loginFormNameXpath;
	private String loginFormEmailXpath;
	private String loginFormIsStudentXpath;
	private String loginFormIsTeacherXpath;
	private String loginButtomXpath;

	public PropertyReader() throws IOException {
		InputStream inputStream = null;
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			// get the property value
			this.chromeDriverPath = prop.getProperty("chrome");
			this.firefoxDriverPath = prop.getProperty("firefox");
			this.ieDriverPath = prop.getProperty("ie");
			this.filename = prop.getProperty("filename");
			this.url = prop.getProperty("url");

			this.loginFormNeptunXpath = prop.getProperty("loginFormNeptunXpath");
			this.loginFormNameXpath = prop.getProperty("loginFormNameXpath");
			this.loginFormEmailXpath = prop.getProperty("loginFormEmailXpath");
			this.loginFormIsStudentXpath = prop.getProperty("loginFormIsStudentXpath");
			this.loginFormIsTeacherXpath = prop.getProperty("loginFormIsTeacherXpath");
			this.loginButtomXpath = prop.getProperty("loginButtomXpath");

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}

	public String getChromeDriverPath() {
		return chromeDriverPath;
	}

	public String getFilename() {
		return filename;
	}

	public String getUrl() {
		return url;
	}

	public String getLoginFormNeptunXpath() {
		return loginFormNeptunXpath;
	}

	public String getLoginFormNameXpath() {
		return loginFormNameXpath;
	}

	public String getLoginFormEmailXpath() {
		return loginFormEmailXpath;
	}

	public String getLoginFormIsStudentXpath() {
		return loginFormIsStudentXpath;
	}

	public String getLoginFormIsTeacherXpath() {
		return loginFormIsTeacherXpath;
	}

	public String getLoginButtomXpath() {
		return loginButtomXpath;
	}

	public String getFirefoxDriverPath() {
		return firefoxDriverPath;
	}

	public String getIeDriverPath() {
		return ieDriverPath;
	}
}
