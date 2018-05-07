package booking;

import org.openqa.selenium.support.ui.Select;
import org.junit.Test;
import org.openqa.selenium.By;

public class CreateAndDeleteHotel extends TestBase {
	
	@Test
	public void createHotel(){
	// Create a Hotel by entering the date in various field 
		
		driver.findElement(By.id("firstname")).sendKeys("testfirst");
		driver.findElement(By.id("lastname")).sendKeys("testlast");
		driver.findElement(By.id("totalprice")).sendKeys("34");
		new Select(driver.findElement(By.id("depositpaid"))).getFirstSelectedOption();
		
		driver.findElement(By.id("checkin")).sendKeys("2018-05-05");

		driver.findElement(By.id("checkout")).sendKeys("2018-05-10");
		driver.findElement(By.cssSelector("input[value=' Save ']")).click();
	}
	
	@Test
	public void deleteHotel(){
	// Delete a record
		driver.findElement(By.xpath("//input[@value='Delete'][1]")).click();
		System.out.println("First instance of a record deleted");
	}
	
	
	
	

}
