import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static ChromeDriverService service;
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp()throws Exception{

            service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("C:\\SeleniumIEDriver\\chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
            service.start();
    }
    @Before
    public void createDriver(){


        driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }


    @AfterClass
    public static void tearDown(){
        driver.quit();
    }



}