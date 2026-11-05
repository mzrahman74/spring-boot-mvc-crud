package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager {
    private static ExtentReports extent;
    public static ExtentReports  getReportInstance() {

        if (extent == null) {
            ExtentSparkReporter sparkReporter =
            new ExtentSparkReporter(
                    "target/extent-report/ExtentReport.html"
            );
            sparkReporter.config().setDocumentTitle("Family CRUD Test Report");
            sparkReporter.config().setReportName("Family Controller Integration Tests");
            sparkReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Application", "Thymeleaf Family CRUD");
            extent.setSystemInfo("Framework", "Spring Boot 4.1.0");
            extent.setSystemInfo("Java", "17");

        }

        return extent;

    }
}
