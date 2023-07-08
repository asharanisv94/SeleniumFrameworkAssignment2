package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MyWishList extends TestBase{
	
	//finding the cell WebElement from the table
	public WebElement getCellElementFromTable(MyWishListTableHeader column, String ColumnElementName) {
		int columnIndex = getIndexOfColumn(column);
		if(columnIndex < 0) {
			throw new NoSuchElementException();
		}
		List<WebElement> rowsElement = wd.findElements(By.cssSelector("table[class='table table-bordered table-hover'] tbody tr"));
		for(int i =0; i < rowsElement.size(); i++) {
			List<WebElement> cells = rowsElement.get(i).findElements(By.cssSelector("td"));
			if(cells.get(2).getText().equals(ColumnElementName)) {
				return cells.get(columnIndex);
			}
		}
		return null;	
	}
	
	//finding the index of the header cell in the header column
	public int getIndexOfColumn(MyWishListTableHeader columnName) {
		List<WebElement> headers = wd.findElements(By.cssSelector("table[class='table table-bordered table-hover'] thead tr td"));
		for (WebElement headerElement : headers) {
			if(headerElement.getText().equals(columnName.value)) {
				return headers.indexOf(headerElement);
			}
		}
		return -1;
	}

	public enum MyWishListTableHeader{
		IMAGE("Image"),
		PRODUCT_NAME("Product Name"),
		MODEL("Model"),
		STOCK("Stock"),
		UNIT_PRICE("Unit Price"),
		ACTION("Action");
		
		String value;
		
		MyWishListTableHeader(String value) {
			this.value = value;
		}
		
		public String getTableHeaders() {
			return value;
		}
		}

	}
