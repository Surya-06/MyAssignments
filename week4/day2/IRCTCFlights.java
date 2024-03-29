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
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTCFlights {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		ChromeDriver d = new ChromeDriver();
		 d.manage().window().maximize();
		 d.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		 
		 d.get("https://www.irctc.co.in/nget/train-search");
		 
		
		 Thread.sleep(2000);
		 
		 d.findElement(By.xpath(" //a[text()=' FLIGHTS '] ")).click();
		
	Set<String> windowHandles=d.getWindowHandles();
	List<String> window=new ArrayList<String>(windowHandles);
	
	d.switchTo().window(window.get(1));
	
	String title=d.getTitle();
	System.out.println("Current window tilte is : " + title);
	
	
	File source = d.getScreenshotAs(OutputType.FILE);
	File destination = new File("./snaps/WindowHandles.jpg");
	FileUtils.copyFile(source, destination);

	}

}
