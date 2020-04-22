/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.automation.remarks.testng.UniversalVideoListener;
import extensions.WebDriverExtensions;
import io.qameta.allure.Attachment;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
import org.testng.annotations.Listeners;

@Listeners(UniversalVideoListener.class)
public class BaseTest {
    protected RemoteWebDriver driver = null;

    @Parameters("browser")
    @BeforeClass
    public void OneTimeSetUp(String browser) {

        DesiredCapabilities cap = null;

        if (browser.equalsIgnoreCase("chrome")){
            cap = DesiredCapabilities.chrome();
            cap.setBrowserName("chrome");
        }

        if (browser.equalsIgnoreCase("firefox")){
            cap = DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");
        }

        if (browser.equalsIgnoreCase("safari")){
            cap = DesiredCapabilities.safari();
            cap.setBrowserName("safari");
        }

        if (browser.equalsIgnoreCase("edge")){
            cap = DesiredCapabilities.edge();
            cap.setBrowserName("edge");
        }

        if (browser.equalsIgnoreCase("internetExplorer")){
            cap = DesiredCapabilities.internetExplorer();
            cap.setBrowserName("internetExplorer");
        }
     
        // driver = new RemoteWebDriver(cap);
        Local();
        driver.manage().window().maximize();
    }

    
    
    public void Local(){
        System.setProperty("webdriver.chrome.driver","C:\\driver\\1\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    @AfterMethod
    public void TearDown() {
        try {
            attachPerformedActionsLog();
            WebDriverExtensions.takeScreenshot(driver);
        } catch (Exception ex) {
            Reporter.log("Error occurring while taking screenshot " + ex.toString());
        }
    }

    @AfterClass
    public void OneTimeTearDown()
    {
        driver.quit();
    }

    @Attachment(value = "Console output", type = "text/plain")
    public byte[] attachPerformedActionsLog() throws IOException {
        var lines = Reporter.getOutput();
        String report = "";

        for (String line : lines) {
            report = report + line + "\n";
        }

        return report.getBytes();
    }
}
