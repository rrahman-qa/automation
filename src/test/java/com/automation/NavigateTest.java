package com.automation;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateTest {

    @Test
    public void Test(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.binary", "/opt/google/chrome/google-chrome");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://bbc.co.uk");
        driver.findElement(By.linkText("News")).click();
        driver.close();
    }
}
