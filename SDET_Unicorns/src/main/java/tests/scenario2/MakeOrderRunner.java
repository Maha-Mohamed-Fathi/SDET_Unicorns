package tests.scenario2;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features= {"src/main/java/tests/scenario2"},
        glue=     {"tests"},
        plugin = {"pretty", "html:reports/makeOrder-Report.html", "json:Report\\jsonReport.json"},
        monochrome=true, tags = "@SdetUnicorns"
)

public class MakeOrderRunner extends AbstractTestNGCucumberTests {
}
