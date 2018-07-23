package tnk.gesture.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) throws IOException {

        FileInputStream configFile = null;

        Properties config = new Properties();
        configFile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
        config.load(configFile);

        Properties OR = new Properties();
        configFile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
        OR.load(configFile);

        //driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
        System.out.println(config.getProperty("browser"));

        System.out.println(OR.getProperty("bmlBtn"));
    }
}
