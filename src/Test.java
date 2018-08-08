import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMINIBM\\Desktop\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://localhost:8443/sepm");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		driver.findElement(By.xpath("//td[@align='left']//font[text()='LAUNCH']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='JPanel loginBanner']")));
		
		
		
		boolean staleElement = true; 
		while(staleElement){
		  try{
			  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
			  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("$Aransai95020");
		      staleElement = false;

		  } catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
		}driver.findElement(By.xpath("//div[@class='JButton enabled']//div[@class='htmlString'][contains(text(),'Log')]")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()='Close']")));
		driver.findElement(By.xpath("//div[text()='Close']")).click();
		//driver.close();
		
	}

}
