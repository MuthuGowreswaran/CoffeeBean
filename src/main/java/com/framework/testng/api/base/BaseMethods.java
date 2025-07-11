package com.framework.testng.api.base;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.framework.config.ConfigurationManager;
import com.framework.selenium.api.base.SeleniumBase;
import com.framework.selenium.api.design.Locators;
import com.framework.utils.DataLibrary;
import com.framework.utils.VideoGenerator;

public class BaseMethods extends SeleniumBase {
	
	 
    @DataProvider(name = "fetchData", indices = 0)
    public Object[][] fetchData() throws IOException {
        return DataLibrary.getSheet(excelFileName);
    }

    @BeforeMethod
    public void preCondition() {
      String url=  ConfigurationManager.configuration().url();
      System.out.print(url);
      setUp();
        startApp("chrome", false, ConfigurationManager.configuration().url());
        setNode();
        setDom();
        login();
    }

    public void login() {
        clearAndType(locateElement(Locators.ID, "username"), ConfigurationManager.configuration().username());
        reportStep("UserName enter successfully","pass",true);
        clearAndType(locateElement(Locators.ID, "password"), ConfigurationManager.configuration().password());
        reportStep("Password enter successfully","pass",true);
        click(locateElement(Locators.ID, "Login"));
        reportStep("Login clicked successfully","pass",true);
    }

    @AfterMethod
    public void postCondition() throws IOException, InterruptedException {
    	 String threadDir = screenshotDir.get();
         String videoPath = threadToVideoMap.get(Thread.currentThread().getId());

         VideoGenerator generator = new VideoGenerator();
         generator.generateVideo(threadDir, videoPath, 60);
       getDriver().quit();;
    }
    
    

}
