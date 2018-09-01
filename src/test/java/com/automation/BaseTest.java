package com.automation;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {
    static WebDriver driver = null;
    static Properties prop = new Properties();
    static InputStream input = null;

    public BaseTest() {
        ChromeOptions options = new ChromeOptions();
        //Set options and properties depending on platform
        if(getProperty("platform").equals("linux")){
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            System.setProperty("webdriver.chrome.binary", "/opt/google/chrome/google-chrome");
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        else {
            System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        }

        try {
            driver = new RemoteWebDriver(new URL(getProperty("remotewebdriver")), new ChromeOptions());
            //driver = new ChromeDriver(options);
        }
        catch(MalformedURLException ex){
            ex.printStackTrace();
        }
        driver.manage().window().setSize(new Dimension(1024,768));
    }

    public static String getProperty(String key){
        if(input==null){
            try {
                input = new FileInputStream("application.properties");
                prop.load(input);
                input.close();
            }
            catch (IOException ex){
                System.out.println("Unable to load properties file");
            }
        }
        return prop.getProperty(key);
    }

    public void getScreenshot(String prefixSection){
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Now you can do whatever you need to do with it, for example copy somewhere
            FileUtils.copyFile(scrFile, new File("screenshots/" + prefixSection + "_" + java.util.UUID.randomUUID().toString() + ".png"));
            System.out.println("Screenshot captured");
        }
        catch (IOException ex){
            System.out.println(ex.getStackTrace().toString());
        }
    }

    @AfterClass
    public static void cleanUp(){
        driver.close();
    }

}
