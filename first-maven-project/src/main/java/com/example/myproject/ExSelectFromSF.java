package com.example.myproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class ExSelectFromSF {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		EdgeOptions options = new EdgeOptions();
		options.setCapability("ms:edgeOptions", "{\"args\": [\"--enable-notifications\"]}");
		WebDriver driver = new EdgeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://brave-wolf-rwfyyf-dev-ed.trailblaze.lightning.force.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys("sathya.vandv@brave-wolf-rwfyyf.com");
		driver.findElement(By.name("pw")).sendKeys("Sathya@456");
		driver.findElement(By.cssSelector("input[id=\"Login\"]")).click();
		options.setCapability("ms:edgeOptions", "{\"args\": [\"--enable-notifications\"]}");
		//driver.findElement(By.xpath("//div[@class='slds-r5']")).click();
		Thread.sleep(2000);

	}

}
