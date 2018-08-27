package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class BaseTest {
    static WebDriver driver = null;
    static Properties prop = new Properties();
    static InputStream input = null;

    public BaseTest(){
        ChromeOptions options = new ChromeOptions();
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
        driver = new ChromeDriver(options);
    }

    public static String getProperty(String key){
        if(input==null){
            try {
                input = new FileInputStream("application.properties");
                prop.load(input);
            }
            catch (IOException ex){
                System.out.println("Unable to load properties file");
            }
        }
        return prop.getProperty(key);
    }

}
