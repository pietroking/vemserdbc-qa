package br.com.aula.run;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/main/resources/features",
        tags = {"@wip"},
        glue = "br/com/aula/steps",
        plugin = {"json:target/cucumber.json", "pretty","html:target/cucumber-reports"},
        snippets = SnippetType.CAMELCASE
)

public class RunTest {

}
