package com.automation;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NavigateTest extends BaseTest{

    public NavigateTest(){
        super();
    }

    @Test
    public void test(){
        driver.navigate().to("http://bbc.co.uk");
        driver.findElement(By.linkText("News")).click();
    }

    @AfterClass
    public static void cleanUp(){
        driver.close();
    }
}
