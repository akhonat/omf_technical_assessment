package test_runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions
        (
            features="classpath:features/CalculatePersonalLoan.feature",
            glue = {"steps"},
            tags = {"@Test"},
            monochrome = true,
                plugin = {"pretty", "html:reports/cucumberhtmlreport"}
        )

public class TestRunner {

}

