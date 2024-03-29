package week4.day2;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class nyKaa {
	
		public static void main(String[] args) throws InterruptedException, IOException {
			ChromeDriver d = new ChromeDriver();
			 d.manage().window().maximize();
			 d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 
			 d.get("https://www.nykaa.com/");
			 WebElement brands=d.findElement(By.xpath("//a[text()='brands']"));
			 Actions builder = new Actions(d);
			 builder.moveToElement(brands).perform();
			 
			 d.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
			 d.findElement(By.linkText("L'Oreal Paris")).click();
			 
			 String title=d.getTitle();
			 System.out.println("Webpage title is : " +  title);
			 
			 d.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
			 d.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
			 
			 d.findElement(By.xpath("//span[text()='Category']")).click();
			 
			 Thread.sleep(2000);
			 
			 d.findElement(By.xpath("//span[text()='Hair']")).click();
			 
			 Thread.sleep(2000);
			 
			 d.findElement(By.xpath("//div[@class=' css-b5p5ep']")).click();
			 
			 Thread.sleep(2000);
			 
			 d.findElement(By.xpath("(//span[@class='title'])[2]")).click();
			 
			 Thread.sleep(2000);
			 
			 d.findElement(By.xpath("//span[text()='Concern']")).click();
			 
			 Thread.sleep(2000);
			 
			 d.findElement(By.xpath("(//span[@class='title'])[12]")).click();
			 
			 Thread.sleep(2000);
			 
			 d.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
			 
			 Thread.sleep(2000);
			 
			 Set<String> windowHandles=d.getWindowHandles();
				List<String> newwindow=new ArrayList<String>(windowHandles);
				
				Thread.sleep(2000);
				
				d.switchTo().window(newwindow.get(1));
				
				Thread.sleep(2000);
				
				d.findElement(By.xpath("//span[@class=' css-d3w64v']")).click();
				
				Thread.sleep(2000);
				
				String MRP=d.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
				System.out.println("Product MRP for 180ml is : " + MRP);
				
				
				d.findElement(By.xpath("//span[@class='btn-text']")).click();
				
				Thread.sleep(2000);
				
				//d.findElement(By.xpath("(//*[local-name()='svg' and @fill='none']/*[local-name()='path'])[2]")).click();\
				
				Actions act =  new Actions(d);
				act.moveToElement(d.findElement(By.xpath("(//*[local-name()='svg' and @fill='none']/*[local-name()='path'])[2]"))).click().perform();
				
				Thread.sleep(2000);
			
	WebElement frame=d.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
	d.switchTo().frame(frame);
	
	Thread.sleep(2000);
	
	String Total=d.findElement(By.xpath("(//p[@class='css-masf0q eka6zu20'])[2]")).getText();
	System.out.println("Grand Total is : " + Total);
	
	Thread.sleep(2000);
	
	d.findElement(By.xpath("//div[@class='css-15vhhhd e25lf6d4']")).click();
	
	Thread.sleep(2000);
	
	d.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
	d.findElement(By.xpath("(//img[@class='css-16z7tzi ek8d9s80'])[2]")).click();
	
	String PriceDetails=d.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']")).getText();
	System.out.println("Price Detail : " + PriceDetails);
		
	
	Thread.sleep(2000);
	
	 File source = d.getScreenshotAs(OutputType.FILE);
		File destination= new File("./snaps/nykaa.jpg");
	FileUtils.copyFile(source, destination);
	
	Thread.sleep(2000);
	
	d.quit();

	}

}
