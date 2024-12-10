package javaTask11;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Qsn01 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		waitForTime(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        
        Set<String> windowHandles = driver.getWindowHandles();
        String originalWindowHandle = driver.getWindowHandle();
        String newWindowHandle = "";

        
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                newWindowHandle = handle;
                break;
            }
        }
        
        driver.switchTo().window(newWindowHandle);
        
        String pageText = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
        if (pageText.contains("New Window")) {
            System.out.println("Text 'New Window' is present on the new window.");
        } else {
            System.out.println("Text 'New Window' is not found in the new window.");
        }
        
        driver.close();

        driver.switchTo().window(originalWindowHandle);

        String currentTitle = driver.getTitle();
        if (currentTitle.equals("The Internet")) {
            System.out.println("Original window is active.");
        } else {
            System.out.println("Original window is not active.");
        }

        driver.quit();

	}
	
	public static void waitForTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
