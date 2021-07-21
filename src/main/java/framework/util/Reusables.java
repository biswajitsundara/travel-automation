package framework.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Biswajit Sundara
 * @date 21/07/2021
 *
 */

public class Reusables {

	WebDriver driver;
	WebDriverWait wait;

	public Reusables(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(this.driver,30); 
	}


	public WebElement getElement(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return driver.findElements(locator);
	}


	public void enterText(By locator, String text) {
		getElement(locator).sendKeys(text);
	}

	public void clickElement(By locator) {
		getElement(locator).click();
	}

	public void clickElementByIndex(By locator, int index) {
		getElements(locator).get(index-1).click();
	}

	public void selectFromDropDown(By locator, String text) {
		Select dropdown = new Select(getElement(locator));  
		dropdown.selectByVisibleText(text);
	}


	public String getElementText(By locator) {
		String text = getElement(locator).getText();
		if(text.isBlank()) {
			text = getElement(locator).getAttribute("innerText");
		}
		return text;
	}

	public int getTableColumnIndex(By tableLocator, String columnName) {
		WebElement table = getElement(tableLocator);
		List<WebElement> headers = table.findElements(By.tagName("th"));
		int colNo=0;

		for(int i=0;i<headers.size();i++) {
			if(headers.get(i).getText().contentEquals(columnName)) {
				colNo=i;
				break;
			}
		}
		return colNo+1;
	}

	
	public String getCellValue(By tableLocator, int rowNo, String columnName) {
		WebElement table = getElement(tableLocator);
		int colIndex = getTableColumnIndex(tableLocator,columnName);
		WebElement cellVal = table.findElement(By.xpath("tbody/tr["+rowNo+"]/td["+colIndex+"]"));
		return cellVal.getText();
	}


}
