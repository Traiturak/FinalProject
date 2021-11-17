package pl.coders.zadania;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/pl/coders/zadania/features", plugin = {"pretty","html:out.html"}, tags = "@Test1")
public class RunTest1 {
}
