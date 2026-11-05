package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.junit.jupiter.api.extension.*;

public class ExtentTestExtension implements
        BeforeAllCallback,
        AfterAllCallback,
        BeforeEachCallback,
        AfterTestExecutionCallback {

    private static final ExtentReports extent =
            ExtentReportManager.getReportInstance();

    private static final ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void beforeEach(ExtensionContext context) {

        ExtentTest extentTest =
                extent.createTest(context.getDisplayName());

        test.set(extentTest);
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {

        Throwable exception =
                context.getExecutionException().orElse(null);

        if (exception == null) {

            test.get().pass("Test passed");

        } else {

            test.get().fail(exception);
        }
    }

    @Override
    public void afterAll(ExtensionContext context) {

        extent.flush();
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {

    }
}
