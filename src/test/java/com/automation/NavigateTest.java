package com.automation;

import org.apache.commons.io.FileUtils;
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

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Now you can do whatever you need to do with it, for example copy somewhere
            FileUtils.copyFile(scrFile, new File("screenshots/" + java.util.UUID.randomUUID().toString()));
        }
        catch (IOException ex){
            System.out.println(ex.getStackTrace().toString());
        }
        driver.findElement(By.linkText("News")).click();
    }
}
