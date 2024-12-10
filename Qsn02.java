package javaTask11;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Qsn02 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("frame-top");
		
		WebElement leftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		WebElement rightFrame = driver.findElement(By.xpath("//frame[@name='frame-right']"));
		waitForTime(3000);
		driver.switchTo().frame(leftFrame);
        String leftText = driver.findElement(By.tagName("body")).getText();
        if (leftText.equalsIgnoreCase("LEFT")) {
            System.out.println("Left frame text is correct: " + leftText);
        } else {
            System.out.println("Left frame text is incorrect.");
        }
        
        driver.switchTo().parentFrame();

        driver.switchTo().frame(middleFrame);
        String middleText = driver.findElement(By.tagName("body")).getText();
        if (middleText.equalsIgnoreCase("MIDDLE")) {
            System.out.println("Middle frame text is correct: " + middleText);
        } else {
            System.out.println("Middle frame text is incorrect.");
        }
        
        driver.switchTo().parentFrame();

        driver.switchTo().frame(rightFrame);
        String rightText = driver.findElement(By.tagName("body")).getText();
        if (rightText.equalsIgnoreCase("RIGHT")) {
            System.out.println("Right frame text is correct: " + rightText);
        } else {
            System.out.println("Right frame text is incorrect.");
        }
        
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-bottom");
        String bottomText = driver.findElement(By.tagName("body")).getText();
        if (bottomText.equalsIgnoreCase("BOTTOM")) {
            System.out.println("Bottom frame text is correct: " + bottomText);
        } else {
            System.out.println("Bottom frame text is incorrect.");
        }
        
        driver.switchTo().parentFrame();

        String pageTitle = driver.getTitle();
        if (pageTitle.equalsIgnoreCase("Frames")) {
            System.out.println("Page title is correct: " + pageTitle);
        } else {
            System.out.println("Page title is incorrect.");
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
