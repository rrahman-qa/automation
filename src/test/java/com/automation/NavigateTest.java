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
    public void test() throws IOException {
        driver.navigate().to("http://bbc.co.uk");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("screenshots/" + java.util.UUID.randomUUID().toString()));
        driver.findElement(By.linkText("News")).click();
    }
}
