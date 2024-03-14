package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

public WebDriver driver;
    public WebDriver WebDriverManager() throws IOException {

        FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+ "//src//test//resources//global.properties");
        Properties prop=new Properties();
        prop.load(fi);
        String url=prop.getProperty("QaUrl");
        System.out.println("browser is "+prop.getProperty("browser"));
        if(driver == null){
            
            if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abdul.Ansari1\\IdeaProjects\\SeleniumTraining\\Driver\\chromedriver.exe");
                driver = new ChromeDriver(); //driver gets the life

            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }

        return driver;
    }
}
