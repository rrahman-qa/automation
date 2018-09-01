package com.automation;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class NavigateTest extends BaseTest{
    
    @Test
    public void test() {
        driver.navigate().to("http://bbc.co.uk");
        System.out.println("Page loaded");

        getScreenshot("HOME");
        driver.findElement(By.linkText("News")).click();
        System.out.println("News link clicked");
        getScreenshot("NEWS");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"brand\"]")).isDisplayed());
    }
}
