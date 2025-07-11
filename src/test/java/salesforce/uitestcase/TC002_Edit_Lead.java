package salesforce.uitestcase;

import com.framework.selenium.salesforcepages.HomePage;
import com.framework.testng.api.base.BaseMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC002_Edit_Lead extends BaseMethods {

    @BeforeTest
    public void setFileName() {
        excelFileName = "EditLead";
        testcaseName = "Edit Leads";
        testDescription = "Alter the Existing lead in Salesforce";
        authors = "Muthu";
        category = "Regression";
    }


    @Test( dataProvider = "fetchData")
    public void editLeadTest(String searchName, String FirstName, String LastName, String Company) throws InterruptedException {
        new HomePage()
                .openAppLauncher()
                .clickViewAll()
                .searchApp("Leads")
                .selectApp("Leads")
               // .searchLead(searchName)
                .clickExpandButton()
                .clickEdit()
                .enterLeadDetails(FirstName, LastName, Company)
                .saveLead(LastName)
                .getToastMessage();
        
    }
}
