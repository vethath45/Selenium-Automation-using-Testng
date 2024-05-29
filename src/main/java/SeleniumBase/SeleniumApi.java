package SeleniumBase;

import org.openqa.selenium.WebElement;

public interface SeleniumApi {
	
	 /**
	  * This Method will launch the window to the Browser
	  * @param link
	  * @author R.VETHATH SURYAKUMAR
	  * @exception NUllPointerException
	  */
	void setup(String link);
	
	
	
	/**
	 * This  method will launch to the Specific browser Window
	 * @author R.VETHATH SURYAKUMAR
	 * @param BrowserName
	 * @param link	
	 * @exception NUllPointerException 
	 */
	void setup(String BrowserName , String link);
	
	
	
	/**
	 * This method is used to find the web element
	 * @param type
	 * @param value
	 * @return WebElement
	 */
	WebElement element (String type , String value);
	
	
	
	/**
	 * This method help the user to switch the window
	 * @param i
	 * @exception NoSuchElementException
	 */
	void SwitchWindow(int i);
	
	
	
	
	
	/**
	 * This method will select the drop down  by value
	 * @param elm
	 * @param value
	 * @return WebElement
	 */
	void SelectByvalue(WebElement elm, String value);
	
	
	
	
	/**
	 * This method will select the drop down  by text
	 * @param elm
	 * @param value
	 * @return WebElement
	 */
	void SelectByText(WebElement elm, String value);
	
	
	
	/**
	 * This method will select the drop down  by index
	 * @param elm
	 * @param position
	 * @return WebElement 
	 */
	void SelectByIndex(WebElement elm,int position);
	
	
	
	
	
	/**
	 * This method  click the button the webElement
	 *  @throws org.openqa.selenium.ElementNotInteractableException if the element is not interactable
 * @throws org.openqa.selenium.NoSuchElementException if the element could not be found
 * @throws org.openqa.selenium.StaleElementReferenceException if the element is no longer valid
 * @throws org.openqa.selenium.WebDriverException for other WebDriver errors
	 * @param elm
	 */
	void click(WebElement elm);
	
	
	
	
	/**
	 * This method used to clear and type the value in given space
	 * @param elm
	 * @param value
	 */
	void type(WebElement elm ,String value);
	
	
	
	/**
	 * This method used to type the value in given space
	 * @param elm
	 * @param testData
	 * @return String
	 */
	void appendtext (WebElement elm ,String testData);
	
	
	
	
	/**
	 * This Method is used to screenshot the entire page
	 * @param file
	 */
	void screenshot(String file);
	
	
	/**
	 * This method used to get title of the Window
	 * @return String
	 */
	
	public String getTitle();
	
	
	
	
	/**
	 * This method is used to get the url of the page
	 * @return String
	 */
	public String getUrl();
	
	
	
	/**
	 * This method is used to verify that element the is displayed  on the page or not
	 * @return Boolean
	 */
	Boolean Displayed(WebElement element);

	
	
	
	/**
	 * This method is used to verify that the element is Selected on the page or not
	 * @return Boolean
	 */
	Boolean Selected(WebElement element);
	
	
	
	
	/**
	 * This method is used to verify that the element is displayed  on the page or not
	 * @return Boolean
	 */
	Boolean Enabled(WebElement element);
	
	
	
	
	/**
	 * This method is used to double click the element 
	 * @param element
	 */
	void doubleClickElement(WebElement element);
	
	
	
	/**
	 * This method is used to right  click the element 
	 * @param element
	 */
    void rightClickElement(WebElement element);
    
    
    
    /**
	 * This method is used to drag and drop  the element in particular target
	 * @param element
	 */
    void dragAndDrop(WebElement source, WebElement target);
    
    
    /**
     * This method used to accept and click the Ok button on the alert
     */
    void accept();
    
    
    
    /**
     * This method used to Dismisses (clicks Cancel on) the alert.
     */
    void dismiss();
    
    
    
    /**
     * This method used to Gets the text of the alert.
     * @return String
     */
    String AlertgetText();
    
    
    
    /**
     * This method used to Select class is used to check whether a drop down (select element) allows multiple selections or not.
     * @return Boolean
     */
    
    boolean isMultiple(WebElement elm);
    
    
    /**
     * This method used to navigate back of the previous  page
     */
    void navigateback();
    
    
    
    
    /**
     * This method used to navigate forward of the page
     */
    
    void navigateForward();
    
    
    
    /**
     * This method used to Refresh of the page
     */
    
    void navigateReferesh();
    
     
     
	void Close();
	
	void Quit();
   
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
