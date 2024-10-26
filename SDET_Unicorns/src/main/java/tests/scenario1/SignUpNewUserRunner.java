package tests.scenario1;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features= {"src/main/java/tests/scenario1/signUpNewUserTest.feature"},
        glue=     {"tests"},
        plugin = {"pretty", "html:reports/signUpScenario-Report.html", "json:Report\\jsonReport.json"},
        monochrome=true, tags = "@SdetUnicorns"
)

public class SignUpNewUserRunner extends AbstractTestNGCucumberTests{
}
