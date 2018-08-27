package com.automation;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class NavigateTest extends BaseTest{
    
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
