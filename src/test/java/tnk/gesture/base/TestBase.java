package tnk.gesture.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fileInputStream;

    @BeforeSuite
    public void setUp(){
        if(driver == null){
            // load the config properties
            //String userDir = "D:\\dev\\gesture"; //System.getProperty("user.dir");
            String userDir = System.getProperty("user.dir");
            try {
                fileInputStream = new FileInputStream(userDir + "\\src\\test\\resources\\properties\\Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //load the OR properties
            try {
                fileInputStream = new FileInputStream(userDir + "\\src\\test\\resources\\properties\\OR.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                OR.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // setup the driver
            if(config.getProperty("browser").equals("firefox")){
                // System.setProperty("webdriver.gecko.driver", "gecko.exe"); if it's the latest
                driver = new FirefoxDriver();
            } else if(config.getProperty("browser").equals("chrome")){
                System.setProperty("webdriver.chrome.driver", userDir +"\\src\\test\\resources\\executables\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if(config.getProperty("browser").equals("ie")){
                System.setProperty("webdriver.ie.driver", userDir +"\\src\\test\\resources\\executables\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }
            driver.get(config.getProperty("testsiteurl"));
//            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
        }
    }

    @AfterSuite
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
