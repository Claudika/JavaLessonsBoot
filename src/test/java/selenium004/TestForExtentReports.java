package selenium004;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestForExtentReports extends ExtentReportManager{

    private ExtentTest extentTest;
    @BeforeMethod
    public void setUpExtentTest(ITestResult testResult){
        String testName =testResult.getMethod().getMethodName();
        extentTest= getInstance().createTest(testName);
    }
    @AfterMethod
    public void tearDownExtentTest(ITestResult testResult){
        if(testResult.getStatus()==ITestResult.FAILURE){
            extentTest.log(Status.FAIL,"Test Filed: "+ testResult.getThrowable());
        }else if(testResult.getStatus()==ITestResult.SKIP){
            extentTest.log(Status.SKIP,"Test skipped: "+ testResult.getThrowable());
        }else{
            extentTest.log(Status.PASS,"Test passed");
        }
    }



    @Test
    public void cigarPartySuccessOnWeekday(){
        boolean isWeekend= false;
        int cigars =50;
        boolean expected= true;
        boolean actual= SquirrelParty.isPartySuccessful(cigars,isWeekend);
        Assert.assertEquals(expected,actual,"Party is not successful on a weekday with 50 cigars");
    }
    @Test
    public void cigarPartySuccessOnWeekend(){
        boolean isWeekend = true;
        int cigars=40;
        boolean expected = true;
        boolean actual = SquirrelParty.isPartySuccessful(cigars,isWeekend);
        Assert.assertEquals(actual,expected,"Party is successful on a weekend with 40 cigars");
    }
    @ Test
    public void cigarPartyUnSuccessOnWeekday(){
        boolean isWeekend= false;
        int cigars=30;
        Boolean expected= false;
        boolean actual=SquirrelParty.isPartySuccessful(cigars,isWeekend);
        Assert.assertEquals(actual,expected,"Party is Successful on a weekday with 30 cigars");
    }
    @Test
    public void cigarPartyUnSuccessfulOnWeekend(){
        boolean isWeekend= true;
        int cigars=70;
        boolean expected = false;
        boolean actual = SquirrelParty.isPartySuccessful(cigars,isWeekend);
        Assert.assertEquals(actual,expected,"Party is Successful on a weekday with 70 cigars");
    }

}
