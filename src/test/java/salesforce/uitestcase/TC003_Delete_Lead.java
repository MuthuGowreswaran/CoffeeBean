package salesforce.uitestcase;

import com.framework.selenium.salesforcepages.HomePage;
import com.framework.testng.api.base.BaseMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC003_Delete_Lead extends BaseMethods {

    @BeforeTest
    public void setFileName() {
        excelFileName = "DeleteLead";
        testcaseName = "delete Leads";
        testDescription = "Delete an existing lead in Salesforce";
        authors = "Muthu";
        category = "Regression";
    }

    @Test(dataProvider = "fetchData")
    public void deleteLeadTest(String searchName) throws InterruptedException {
        new HomePage()
                .openAppLauncher()
                .clickViewAll()
                .searchApp("Leads")
                .selectApp("Leads")
              //  .searchLead(searchName)
                .clickExpandButton()
                .clickDelete()
                .getToastMessage();
    }


}
