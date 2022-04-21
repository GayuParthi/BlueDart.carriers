package eShipslogin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlueDartCarriers {
	@Test
	public void editBDcarriers() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://qa-eshipz.herokuapp.com/");
		driver.findElement(By.id("email")).sendKeys("automation@eshipz.com");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login-submit")).click();
		if(driver.getTitle().contains("eShipz")) {
			System.out.println("My HomePage is displayed..");
		}else {
		     System.out.println("HomePage is not displayed..");	
			}
		
		WebElement settings = driver.findElement(By.xpath("//a[@data-activates='settings']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(settings).perform();
		driver.findElement(By.linkText("Carriers")).click();
		driver.findElement(By.xpath("//i[text()='edit']")).click();
		//driver.findElement(By.xpath("//input[@class='select-dropdown active']")).click();
		driver.findElement(By.xpath("//input[@value='Testing']")).click();
		WebElement description = driver.findElement(By.name("desc"));
		description.clear();
		description.sendKeys("Test");
		WebElement licenseKey = driver.findElement(By.id("license_key"));
		licenseKey.clear();
		licenseKey.sendKeys("4ecbd06dc0b9737d69120029cb05c9df");
		WebElement areaCode = driver.findElement(By.id("area_code"));
		areaCode.clear();
		areaCode.sendKeys("BOM");
		WebElement customerCode = driver.findElement(By.id("customer_code"));
		customerCode.clear();
		customerCode.sendKeys("099960");
		WebElement loginId = driver.findElement(By.id("login_id"));
		loginId.clear();
		loginId.sendKeys("BOM00001");
		WebElement serviceType = driver.findElement(By.id("service_type"));
		serviceType.clear();
		serviceType.sendKeys("DomesticPriority, CriticalExpress, Apex, Ground, eTailCODAir, eTailCODGround, eTailPrePaidAir, eTailPrePaidGround, Dart_Plus_COD, Dart_Plus_Prepaid, PARCEL_INT_DIRECT_PLT, GM_PCKT_STD_PKD, GM_PCKT_PLUS_STD_PPS,EXPRESS_WORLDWIDE, Ecom_Cod_TDD_12:00, Ecom_Prepaid_TDD_12.00, Ecom_Prepaid_TDD_10.30, Ecom_Cod_TDD_10.30, Apex_TDD, Domestic_TDD_12:00, Domestic_TDD_10:30");
		driver.findElement(By.xpath("//label[text()='I Agree to the ']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
