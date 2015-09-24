package org.springframework.issues;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReproTests {

	private static WebDriver webDriver;
	private static String newLineCharacter = System.getProperty("line.separator");
	private static String baseUrl = System.getProperty("baseUrl", "http://localhost:8080/SPR-13503/echo");

	@BeforeClass
	public static void setUpWebDriver() {
		webDriver = new FirefoxDriver();
	}

	@AfterClass
	public static void quitWebDriver() {
		webDriver.quit();
	}

	@Test
	public void testSpringTextareaTag() {
		webDriver.get(baseUrl);
		{
			webDriver.findElement(By.id("text1")).sendKeys(newLineCharacter + "input value");
			webDriver.findElement(By.id("confirmButton")).click();
		}
		{
			webDriver.findElement(By.id("redoButton")).click();
			assertThat(webDriver.findElement(By.id("text1")).getAttribute("value"), is(newLineCharacter + "input value"));
		}
	}

	@Test
	public void testHTMLStandardTextareaTag() {
		webDriver.get(baseUrl);
		{
			webDriver.findElement(By.id("text2")).sendKeys(newLineCharacter + "input value");
			webDriver.findElement(By.id("confirmButton")).click();
		}
		{
			webDriver.findElement(By.id("redoButton")).click();
			assertThat(webDriver.findElement(By.id("text2")).getAttribute("value"), is(newLineCharacter + "input value"));
		}
	}

}
