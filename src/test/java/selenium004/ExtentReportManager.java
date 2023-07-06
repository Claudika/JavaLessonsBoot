package selenium004;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private  static ExtentReports extentReports;
    public static ExtentReports getInstance(){
        if(extentReports==null){
            extentReports = createExtentReports();
        }
        return  extentReports;
    }
    public static ExtentReports createExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
        sparkReporter.config().setDocumentTitle("Extent Report");
        sparkReporter.config().setReportName("Squirrel Party Report");
        sparkReporter.config().setTheme(Theme.STANDARD);

         ExtentReports extentReports= new ExtentReports();
         extentReports.attachReporter(sparkReporter);
         return extentReports;
    }
}
