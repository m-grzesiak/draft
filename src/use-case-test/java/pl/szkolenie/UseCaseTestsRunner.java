package pl.szkolenie;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src/use-case-test/resources/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "pl.szkolenie")
public class UseCaseTestsRunner {
}
