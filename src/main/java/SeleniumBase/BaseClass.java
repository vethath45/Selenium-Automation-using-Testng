package SeleniumBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;


public class BaseClass implements  SeleniumApi{
 RemoteWebDriver driver =null;
	WebDriverWait wait=null;
	long maxWaitTime=10;
	
	
	

	@Override
	public void setup(String link) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(link);
		
	}
	
	

	@Override
	public void setup(String BrowserName, String link) {
	     switch(BrowserName) {
	     case  "chrome":
	    	  driver = new ChromeDriver();
	    	 break;
	     case  "firefox":
	    	 driver= new FirefoxDriver();
	    	 break;
	     case  "edge":
	    	 driver= new EdgeDriver();
	    	 break;
	    	 default :
	    		System.err.println("driver is not defined");
	    		 
	     }
	     
	     driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(link);
	
		
	}
	
	

	@Override
	public WebElement element(String type, String value) {
		switch(type.toLowerCase()) {
	case "id":
		WebElement web = driver.findElement(By.id(value));
		return web;
    case "name":
        return driver.findElement(By.name(value));
    case "classname":
        return driver.findElement(By.className(value));
    case "tagname":
        return driver.findElement(By.tagName(value));
    case "cssselector":
        return driver.findElement(By.cssSelector(value));
    case "xpath":
        return driver.findElement(By.xpath(value));
    case "linktext":
        return driver.findElement(By.linkText(value));
    case "partiallinktext":
        return driver.findElement(By.partialLinkText(value));
		default:
			break;
	}
		return null;
		
	}
	
	
	
	

	@Override
	public void SwitchWindow(int i) {
	Set<String> windowhandles=driver.getWindowHandles();
		ArrayList<String> list = new ArrayList(windowhandles);
		driver.switchTo().window(list.get(i));
	}

	@Override
	public void SelectByvalue(WebElement elm, String value) {
		Select select = new Select(elm);
        select.selectByValue(value);
		
	}

	@Override
	public void SelectByText(WebElement elm, String value) {
		Select select = new Select(elm);
        select.selectByVisibleText(value);
		
	}

	@Override
	public void SelectByIndex(WebElement elm, int position) {
		 Select select = new Select(elm);
	        select.selectByIndex(position);
		
	}

	@Override
	public void click(WebElement elm) {
	
		elm.click();
	
		
	}

	@Override
	public void type(WebElement elm, String value) {
		
		elm.clear();
		elm.sendKeys(value);
	}
	public void type(WebElement elm, String value, Keys keys) {
		WebElement element = wait.until
				(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(value , keys);
	}

	@Override
	public void appendtext(WebElement elm, String testData) {
		WebElement element = wait.until
				(ExpectedConditions.visibilityOf(elm));
		
		element.sendKeys(testData);
	}

	@Override
	public String getTitle() {
		
		return driver.getTitle();
	}
	

	@Override
	public String getUrl() {
		
		return driver.getCurrentUrl();
		
	}



	
	public Boolean Displayed(WebElement element) {
		
		return element.isDisplayed();
	}


	
	public Boolean Selected(WebElement element) {
		
		return  element.isSelected();
	}

	
	public Boolean Enabled(WebElement element) {
		
		return element.isEnabled();
	}

	@Override
	public void doubleClickElement(WebElement element) {
		Actions actions = new Actions(driver);
		 actions.doubleClick(element).perform();
		
		 
		
	}

	@Override
	public void rightClickElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
		
	}

	@Override
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		 actions.dragAndDrop(source, target).perform(); 
		
	}

	@Override
	public void accept() {
		try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present to accept.");
        }
		
	}

	@Override
	public void dismiss() {
		 try {
	            Alert alert = driver.switchTo().alert();
	            alert.dismiss();
	        } catch (NoAlertPresentException e) {
	            System.out.println("No alert present to dismiss.");
	        }
		
	}

	@Override
	public String AlertgetText() {
		try {
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present to get text from.");
            return null;
        }
		
	
	}

	@Override
	public boolean isMultiple(WebElement elm) {
		Select select = new Select(elm);
        return select.isMultiple();
		
	}

	@Override
	public void navigateback() {
		driver.navigate().back();
	}

	@Override
	public void navigateForward() {
		driver.navigate().forward();
		
	}

	@Override
	public void navigateReferesh() {
		driver.navigate().refresh();
		
	}
	 
	@Override
	public void screenshot(String file)  {
		File firstsrc = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File(file);
		try {
			FileHandler.copy(firstsrc, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	 public String getText(WebElement element) {
	        return element.getText();
	    }
	 
	
	
	
	@Override
	public void Close() {
		driver.close();
	}

	@Override
	public void Quit() {
		driver.quit();
		
	}



	



	
	
	
	
}
